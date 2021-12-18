;;; Sierra Script 1.0 - (do not remove this comment)
(script# 5050)
(include sci.sh)
(use Main)

(public
	rm5v05 0
)

(instance rm5v05 of ShiversRoom
	(properties
		picture 5020
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 5010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 5030
	)
)
