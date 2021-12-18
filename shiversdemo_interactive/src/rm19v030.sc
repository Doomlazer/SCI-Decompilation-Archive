;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19030)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm19v030 0
)

(instance rm19v030 of ShiversRoom
	(properties
		picture 19030
	)
	
	(method (init)
		(super init: &rest)
		(if (proc951_5 43)
			(sounds play: 11903 0 82 0)
			(proc951_4 43)
		)
		(if
		(and (proc951_11 8 19000) (> prevRoomNum 19040))
			(sounds adjChainVol: 16)
			(sounds fade: 21909 0 15 8 1 0)
			(sounds
				playChain: -1 -5 21901 -1 -1 -5 21901 -1 -1 -5 21904 -1
			)
			(sounds play: 21903 -1 48 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19230
	)
	
	(method (init)
		(self
			createPoly: 73 143 76 131 62 132 91 80 158 80 170 67 190 99 243 99 243 143
		)
		(super init: &rest)
	)
)
