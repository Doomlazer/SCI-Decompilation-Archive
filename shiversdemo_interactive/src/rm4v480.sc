;;; Sierra Script 1.0 - (do not remove this comment)
(script# 4480)
(include sci.sh)
(use Main)

(public
	rm4v480 0
)

(instance rm4v480 of ShiversRoom
	(properties
		picture 4110
	)
	
	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4490
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4490
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4470
	)
	
	(method (init)
		(self createPoly: 189 128 76 128 99 101 99 53 190 53)
		(super init: &rest)
	)
)
