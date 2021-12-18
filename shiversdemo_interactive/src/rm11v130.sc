;;; Sierra Script 1.0 - (do not remove this comment)
(script# 11130)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm11v130 0
)

(instance rm11v130 of ShiversRoom
	(properties
		picture 11130
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (proc951_5 43)
			(sounds play: 11107 0 64 0)
			(proc951_4 43)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11100
	)
)
