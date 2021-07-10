;;; Sierra Script 1.0 - (do not remove this comment)
(script# 383)
(include game.sh)
(use pearlScript)
(use n396)
(use Submarine_806)
(use EgoDead)
(use ChangeScriptState)
(use Monitor)
(use System)

(public
	pearl1Script 0
)

(instance pearl1Script of Script

	(method (doit)
		(switch state
			(10
				(if (== (Submarine hSpeed?) 20) (= cycles 1))
			)
			(1
				(if (== (Submarine hSpeed?) 5) (self cue: 1))
			)
			(3
				(if
					(and
						(< 175 (Submarine absHeading:))
						(< (Submarine absHeading:) 185)
					)
					(= cycles 1)
				)
			)
			(5
				(if
					(and
						(< 265 (Submarine absHeading:))
						(< (Submarine absHeading:) 275)
					)
					(= cycles 1)
				)
			)
		)
		(checkThrottle doit:)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 383)
	)
	
	(method (changeState newState param2)
		(switch (= state newState)
			(0
				(Submarine longitude: 156 latitude: 13 absHeading: 94)
				(= seconds 10)
				(ChangeScriptState self (ScriptID 373 4) 0 35)
				((ScriptID 373 6) init: 353 94 5)
			)
			(1
				(= start state)
				(SubPrint 5 383 0)
				(= seconds 10)
				(if (> (++ register) 3) (PearlDeath 383 1))
			)
			(2
				(if (and (>= argc 2) param2)
					(= register 0)
					(= cycles 1)
					(= seconds 0)
					((ScriptID 373 1) init: 358 5 2)
				else
					(self init:)
				)
			)
			(3
				(= start state)
				(SubPrint 5 383 2)
				((ScriptID 373 6) active: 0)
				((ScriptID 373 2) init: 356 6 2)
			)
			(4
				((ScriptID 373 2) active: 0)
				((ScriptID 373 6) active: 1 value: 180)
				(= seconds 15)
			)
			(5
				((ScriptID 373 2) active: 1)
				((ScriptID 373 6) active: 0)
				(SubPrint 5 383 3)
				(= register 0)
			)
			(6
				(= start state)
				((ScriptID 373 6) active: 1 value: 270)
				(SubPrint 5 383 4)
				((ScriptID 373 2) active: 0)
				(= seconds 7)
				(if (> (++ register) 3) (PearlDeath 383 5))
			)
			(7
				(ChangeScriptState self (ScriptID 373 5) self)
			)
			(8
				(if (and (>= argc 2) param2)
					(= register 0)
					(self cue:)
				else
					(self init:)
				)
			)
			(9
				(SubPrint 5 383 6)
				((ScriptID 373 1) active: 0)
				(= seconds 5)
			)
			(10
				(checkThrottle init: 361 2 0)
			)
			(11
				((ScriptID 373 1) active: 1 value: 20)
				(= seconds 10)
			)
			(12
				(= start state)
				(SubPrint 5 383 7)
				(= seconds 10)
				(if (> (++ register) 4) (PearlDeath 383 8))
			)
			(13
				(if (and (>= argc 2) param2)
					(= register 0)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(14
				((ScriptID 373 4) dispose:)
				(= cycles 5)
			)
			(15 (self dispose:))
		)
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			(
				(or
					(Said '/acknowledge,confirm<board<green')
					(Said 'confirm/board<green')
					(Said '[!*]/green<all')
					(Said '[!*]/board<green')
				)
				(if (OneOf state 12 13)
					(self cue: 1)
				else
					(SubPrint 5 383 9)
				)
			)
			((Said 'acknowledge/board<green') (SubPrint 5 383 10))
		)
	)
)

(instance checkThrottle of Monitor
	(properties
		cycles 10
	)
	
	(method (warn)
		(SubPrint 2 383 11)
	)
	
	(method (die)
		(EgoDead 7 0 0 383 12)
	)
)
