;;; Sierra Script 1.0 - (do not remove this comment)
(script# 9560)
(include sci.sh)
(use Main)
(use Procs)
(use System)

(public
	rm9v56 0
)

(instance rm9v56 of ShiversRoom
	(properties
		picture 9560
	)
	
	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (== prevRoomNum 20040)
			(sounds play: 12020 0 82 0)
			(curRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9570
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9570
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9530
	)
	
	(method (init)
		(self
			createPoly: 114 142 114 80 81 70 39 67 49 61 125 65 211 74 229 79 218 142
		)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(sounds fade: 22001 0 1 30 1 self)
			)
			(1
				(proc951_10 22001)
				(= cycles 1)
			)
			(2
				(proc951_9 20903)
				(sounds play: 20903 -1 0 0)
				(sounds fade: 20903 42 1 30 0 0)
				(theGame handsOn:)
				(= cycles 1)
			)
			(3 (self dispose:))
		)
	)
)
