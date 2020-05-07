;;; Sierra Script 1.0 - (do not remove this comment)
(script# 13)
(include sci.sh)
(use Motion)
(use System)

(public
	windScr 0
)

(class windScr of Script
	(properties
		client 0
		state $ffff
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
		curWindSpeed 0
		minWindSpeed 0
		intervalDuration 0
		loopDir 1
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0 (= seconds (Random 2 10)))
			(1
				(client startUpd:)
				(= cycles 1)
			)
			(2
				(= minWindSpeed (Random 3 12))
				(= curWindSpeed minWindSpeed)
				(= intervalDuration (Random 10 30))
				(client cycleSpeed: curWindSpeed setCycle: Fwd)
				(self cue:)
			)
			(3 (= cycles intervalDuration))
			(4
				(if loopDir
					(-- curWindSpeed)
					(if (== curWindSpeed -1)
						(= loopDir 0)
					else
						(client cycleSpeed: curWindSpeed)
					)
				else
					(++ curWindSpeed)
					(if (== curWindSpeed (+ minWindSpeed 1))
						(= loopDir 1)
					else
						(client cycleSpeed: curWindSpeed)
					)
				)
				(self cue:)
			)
			(5 (= cycles intervalDuration))
			(6
				(client setCycle: 0)
				(client stopUpd:)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)
