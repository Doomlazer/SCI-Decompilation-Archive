;;; Sierra Script 1.0 - (do not remove this comment)
(script# 419)
(include game.sh)
(use Main)
(use Motion)
(use System)


(class TimedCycle of Cycle
	(properties
		name "TCyc"
		value 0
		points 0
		size 0
	)
	
	(method (init theObj thePoints whoCares dir &tmp [temp0 2])
		(= client theObj)
		(= points thePoints)
		(if (>= argc 3)
			(cond 
				((>= argc 4) (= cycleDir dir) (= caller whoCares))
				((IsObject whoCares) (= caller whoCares))
				(else (= cycleDir whoCares))
			)
		)
		(= size 0)
		(while (!= (WordAt points size) -32768)
			(++ size)
		)
		(if (== cycleDir 1)
			(= value 0)
		else
			(= value (- size 2))
		)
		(super init:)
	)
	
	(method (doit)
		(if
		(>= (Abs (- gameTime cycleCnt)) (client cycleSpeed?))
			(= cycleCnt gameTime)
			(self nextCel:)
		)
	)
	
	(method (nextCel)
		(client
			loop: (WordAt points value)
			cel: (WordAt points (+ value 1))
		)
		(= value (+ value (* cycleDir 2)))
		(if
			(or
				(and (== cycleDir 1) (>= value size))
				(and (== cycleDir -1) (< value 0))
			)
			(self cycleDone:)
		)
	)
	
	(method (cycleDone)
		(= completed TRUE)
		(= value 0)
		(if caller (= doMotionCue 1) else (self motionCue:))
	)
)
