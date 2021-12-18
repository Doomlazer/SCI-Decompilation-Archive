;;; Sierra Script 1.0 - (do not remove this comment)
(script# 6400)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm6v400 0
)

(instance rm6v400 of ShiversRoom
	(properties
		picture 6400
	)
	
	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(if (<= prevRoomNum 6010)
			(proc951_7 20601)
			(proc951_9 20601)
			(sounds play: 20601 -1 0 0)
			(sounds fade: 20601 10 15 5 0 0)
			(sounds playChain: -1 -4 20602 -1)
			(sounds adjChainVol: 34)
			(sounds play: 10505 0 30 0)
		)
	)
	
	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6130
	)
	
	(method (init)
		(self createPoly: 79 143 77 7 184 9 186 143)
		(super init: &rest)
	)
)
