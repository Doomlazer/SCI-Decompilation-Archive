;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19130)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm19v130 0
)

(instance rm19v130 of ShiversRoom
	(properties
		picture 19130
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(if (proc951_11 8 19000)
			(sounds fadeChain:)
			(sounds fade: 21903 0 15 8 1 0)
			(sounds play: 21909 -1 58 0)
		)
	)
	
	(method (newRoom n)
		(if (proc951_11 8 19000)
			(sounds stop: 21903)
			(sounds interruptChain:)
		)
		(super newRoom: n &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19090
	)
	
	(method (init)
		(self
			createPoly:
				88
				141
				89
				110
				120
				110
				111
				71
				129
				71
				141
				62
				151
				85
				161
				85
				196
				118
				196
				141
		)
		(super init: &rest)
	)
)
