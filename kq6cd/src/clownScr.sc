;;; Sierra Script 1.0 - (do not remove this comment)
(script# 224)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	clownScr 0
)

(instance clownScr of Script
	(properties)
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 224)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(clown init: setMotion: PolyPath 124 119 self)
			)
			(1 (clown setHeading: 0 self))
			(2 (= cycles 2))
			(3 (messager say: 1 0 2 1 self))
			(4 (messager say: 1 0 2 2 self))
			(5
				(self setScript: (ScriptID 220 1) self 1)
			)
			(6
				(clown setMotion: MoveTo 117 109 self)
			)
			(7
				(clown setMotion: MoveTo 104 95 self)
			)
			(8
				(clown
					setPri: 2
					setScale: Scaler 64 94 103 95
					setMotion: MoveTo 75 100 self
				)
			)
			(9
				((ScriptID 10 0) clrIt: 2)
				(clown dispose:)
				(script cue:)
			)
			(10
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ModStopWalk of StopWalk
	(properties)
	
	(method (doit &tmp clientLoop clientMover)
		(if (client isStopped:)
			(cond 
				((and (== vStopped -1) (!= (client loop?) 4))
					(= clientLoop (client loop?))
					(if
						(and
							(= clientMover (client mover?))
							(not (clientMover completed?))
						)
						(client setMotion: 0)
					)
					(super doit:)
					(client loop: 4 setCel: clientLoop)
				)
				(
				(and (!= vStopped -1) (== (client view?) vWalking))
					(client view: vStopped)
					(if
						(and
							(= clientMover (client mover?))
							(not (clientMover completed?))
						)
						(client setMotion: 0)
					)
					(super doit:)
				)
				((!= vStopped -1) (super doit:))
			)
		else
			(switch vStopped
				((client view?)
					(client view: vWalking)
				)
				(-1
					(client setLoop: -1 setCel: -1)
					(if (== (client loop?) 4)
						(client loop: (client cel?) cel: 0)
					)
				)
			)
			(super doit:)
		)
	)
)

(instance clown of Actor
	(properties
		x 166
		y 172
		view 717
		signal $4000
	)
	
	(method (init)
		(super init: &rest)
		(self setScale: setCycle: ModStopWalk -1)
	)
)
