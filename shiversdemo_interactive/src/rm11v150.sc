;;; Sierra Script 1.0 - (do not remove this comment)
(script# 11150)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm11v150 0
)

(instance rm11v150 of ShiversRoom
	(properties
		picture 11150
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efPlaque init: 3)
		(cond 
			((proc951_11 9 11000)
				(proc951_7 21103)
				(proc951_9 21103)
				(sounds play: 21103 -1 50 0)
				(sounds fade: 21101 0 15 8 1 0)
				(sounds fadeChain:)
			)
			((proc951_11 3 11000)
				(sounds fade: 21103 0 5 16 1 0)
				(proc951_7 21101)
				(proc951_9 21101)
				(sounds play: 21101 -1 48 0)
				(sounds adjChainVol: 32)
				(sounds playChain: -1 -5 21102 -1)
			)
		)
		(super init: &rest)
	)
	
	(method (newRoom n)
		(if (and (<= 11160 n) (<= n 11180))
			(if (proc951_11 3 11000)
				(sounds stop: 21101)
				(sounds interruptChain:)
			)
			(sounds fade: 21103 0 5 16 1 0)
		)
		(super newRoom: n &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11130
	)
	
	(method (init)
		(self
			createPoly: 50 143 69 111 45 95 48 32 183 32 212 80 200 81 196 142
		)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 11410
	)
	
	(method (init)
		(self createPoly: 59 115 44 105 56 101 69 110)
		(super init: &rest)
	)
)
