;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19310)
(include sci.sh)
(use Main)

(public
	rm19v310 0
)

(instance rm19v310 of ShiversRoom
	(properties
		picture 19310
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19320
	)
)
