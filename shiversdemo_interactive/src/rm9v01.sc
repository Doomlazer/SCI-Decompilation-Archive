;;; Sierra Script 1.0 - (do not remove this comment)
(script# 9010)
(include sci.sh)
(use Main)
(use Procs)
(use Motion)
(use Actor)
(use System)

(public
	rm9v01 0
)

(local
	local0
)
(instance rm9v01 of ShiversRoom
	(properties
		picture 9010
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsDoor init:)
		(super init: &rest)
	)
	
	(method (newRoom n)
		(if (and (> n 9000) local0) (proc951_3 43))
		(super newRoom: n &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6020
	)
	
	(method (init)
		(self createPoly: 78 143 77 8 188 8 186 143)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		view 9010
		cycleSpeed 18
	)
)

(instance hsDoor of HotSpot
	(properties)
	
	(method (init)
		(self createPoly: 78 143 77 8 188 8 186 143)
		(super init: &rest)
	)
	
	(method (doVerb)
		(curRoom setScript: sDoorOpens)
	)
)

(instance sDoorOpens of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(pDoor init: setPri: 25 1)
				(proc951_7 10917)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(sounds play: 10917 0 40 self)
			)
			(2
				(theGame handsOn:)
				(efExitForward init: 3)
				(= local0 1)
				(hsDoor dispose:)
				(self dispose:)
			)
		)
	)
)
