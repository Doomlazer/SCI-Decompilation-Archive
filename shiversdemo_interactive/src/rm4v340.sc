;;; Sierra Script 1.0 - (do not remove this comment)
(script# 4340)
(include sci.sh)
(use Main)

(public
	rm4v340 0
)

(instance rm4v340 of ShiversRoom
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
		nextRoom 4370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4350
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4280
	)
	
	(method (init)
		(self
			createPoly: 176 112 86 112 117 77 117 61 145 61 145 78
		)
		(super init: &rest)
	)
)
