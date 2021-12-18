;;; Sierra Script 1.0 - (do not remove this comment)
(script# 4510)
(include sci.sh)
(use Main)

(public
	rm4v510 0
)

(instance rm4v510 of ShiversRoom
	(properties
		picture 4040
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4500
	)
	
	(method (init)
		(self createPoly: 0 0 50 0 50 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4520
	)
	
	(method (init)
		(self createPoly: 210 0 262 0 262 142 210 142 210 0)
		(super init: &rest)
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
