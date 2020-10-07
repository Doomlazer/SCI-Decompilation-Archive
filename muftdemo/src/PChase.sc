;;; Sierra Script 1.0 - (do not remove this comment)
(script# PCHASE)
(include game.sh)
(use Main)
(use PolyPath)
(use System)


(class PChase of PolyPath
	(properties
		who NULL
		distance 0
		targetX 0
		targetY 0
	)
	
	(method (init actor whom howClose whoCares theObst)
		(cond 
			((>= argc 5)
				(= obstacles theObst)
			)
			((not (IsObject obstacles))
				(= obstacles (curRoom obstacles?))
			)
		)
		(if (>= argc 1)
			(= client actor)
			(if (>= argc 2)
				(= who whom)
				(= targetX (who x?))
				(= targetY (who y?))
				(if (>= argc 3)
					(= distance howClose)
					(if (>= argc 4) (= caller whoCares))
				)
			)
		)
		(super init: client targetX targetY caller TRUE obstacles)
	)
	
	(method (doit &tmp theDistance)
		(cond 
			(
				(>
					(GetDistance targetX targetY (who x?) (who y?))
					distance
				)
				(if points (Memory MDisposePtr points))
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(
				(<= (= theDistance (client distanceTo: who)) distance)
				(self moveDone:)
			)	
			(else
				(super doit:)
			)
		)
	)
	
	(method (moveDone &tmp theDistance)
		(cond 
			(
			(<= (= theDistance (client distanceTo: who)) distance)
				(super moveDone:)
			)
			((== (WordAt points value) $7777)
				(if points (Memory MDisposePtr points))
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(else (self init:))
		)
	)
)

(class PFollow of PolyPath
	(properties
		who NULL
		distance 0
		targetX 0
		targetY 0
	)
	
	(method (init actor whom howClose param4 &tmp obstList)
		(= obstList
			(if (>= argc 4) param4 else (curRoom obstacles?))
		)
		(if (>= argc 1)
			(= client actor)
			(if (>= argc 2)
				(= who whom)
				(= targetX (who x?))
				(= targetY (who y?))
				(if (>= argc 3) (= distance howClose))
			)
		)
		(super init: client targetX targetY 0 TRUE obstList)
	)
	
	(method (doit &tmp theDistance)
		(cond 
			(
				(>
					(GetDistance targetX targetY (who x?) (who y?))
					distance
				)
				(if points (Memory MDisposePtr points))
				(= points 0)
				(= value 2)
				(self init: client who)
				0
			)
			(
			(<= (= theDistance (client distanceTo: who)) distance)
				(client
					setHeading: (GetAngle (client x?) (client y?) (who x?) (who y?))
				)
				(= xLast (client x?))
				(= yLast (client y?))
				(= b-moveCnt gameTime)
				0
			)
			(else (super doit:))
		)
	)
	
	(method (moveDone)
		(self init:)
	)
)
