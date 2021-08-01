;;; Sierra Script 1.0 - (do not remove this comment)
(script# 121)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use RandCyc)
(use Motion)
(use Actor)
(use System)

(public
	ending2 0
)

(instance ending2 of KQ5Room
	(properties
		picture 217
	)
	
	(method (init)
		(super init:)
		(HandsOff)
		(theGame setCursor: invCursor 1)
		(Load rsSCRIPT 941)
		(theEyes init:)
		(eyelid init:)
		(theMouth init: setCycle: RandCycle)
		(self setScript: cartoon)
	)
	
	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMouth setCycle: MouthSync 5202)
				(proc0_29 5202 self)
			)
			(1
				(cls)
				(theMouth setCycle: MouthSync 5203)
				(proc0_29 5203 self)
			)
			(2
				(cls)
				(theMouth setCycle: MouthSync 5204)
				(proc0_29 5204 self)
			)
			(3
				(cls)
				(theMouth setCycle: MouthSync 5205)
				(proc0_29 5205 self)
			)
			(4
				(theMouth setCycle: 0)
				(eyelid setScript: 0)
				(if (not (== (eyelid cel?) 0))
					(eyelid setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(5 (curRoom newRoom: 120))
		)
	)
)

(instance eyesScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theEyes cel: 0)
				(= seconds (Random 3 7))
			)
			(1
				(theEyes cel: (+ (theEyes cel?) 1))
				(if (NumCels theEyes) (= state -1) else (-- state))
				(= seconds (Random 2 5))
			)
		)
	)
)

(instance bodyScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (client cycler?)
					(= state 2)
					(= cycles 1)
				else
					(client setCycle: End self)
				)
			)
			(1 (= seconds 2))
			(2 (client setCycle: Beg self))
			(3 (client setScript: 0))
		)
	)
)

(instance theEyes of Prop
	(properties
		x 213
		y 79
		view 932
		loop 1
		priority 5
		signal $0010
	)
	
	(method (init)
		(super init:)
		(self setScript: eyesScript)
	)
)

(instance eyelid of Prop
	(properties
		x 213
		y 79
		view 932
		priority 6
		signal $0010
	)
	
	(method (doit)
		(super doit:)
		(if (not script)
			(switch (Random 1 60)
				(1
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance theMouth of Prop
	(properties
		x 212
		y 90
		view 932
		loop 2
		priority 5
		signal $0010
		cycleSpeed 2
	)
)

(instance hand of Prop
	(properties
		x 164
		y 158
		view 932
		loop 3
		priority 11
		signal $0010
	)
	
	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (not (self script?))
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)
