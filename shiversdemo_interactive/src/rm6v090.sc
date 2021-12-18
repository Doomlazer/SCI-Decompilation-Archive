;;; Sierra Script 1.0 - (do not remove this comment)
(script# 6090)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm6v090 0
)

(instance rm6v090 of ShiversRoom
	(properties
		picture 6090
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(if
			(and
				(!= prevRoomNum 6160)
				(!= prevRoomNum 6100)
				(proc951_11 2 6000)
			)
			(sounds fade: 20603 0 15 8 1 0)
			(sounds playChain: -1 -4 20602 -1)
			(sounds adjChainVol: 34)
			(proc951_7 20601)
			(proc951_9 20601)
			(sounds play: 20601 -1 0 0)
			(sounds fade: 20601 10 15 8 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 33
		nextRoom 6100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6160
	)
	
	(method (init)
		(self
			createPoly: 83 141 87 133 87 120 86 101 155 107 171 125 173 145
		)
		(super init: &rest)
	)
)
