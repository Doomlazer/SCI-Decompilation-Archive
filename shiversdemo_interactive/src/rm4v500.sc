;;; Sierra Script 1.0 - (do not remove this comment)
(script# 4500)
(include sci.sh)
(use Main)

(public
	rm4v500 0
)

(instance rm4v500 of ShiversRoom
	(properties
		picture 4120
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 69
		nextRoom 4530
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4510
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4480
	)
	
	(method (init)
		(self
			createPoly: 176 112 86 112 117 77 117 61 145 61 145 78
		)
		(super init: &rest)
	)
)
