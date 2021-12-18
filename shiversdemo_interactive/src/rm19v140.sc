;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19140)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm19v140 0
)

(instance rm19v140 of ShiversRoom
	(properties
		picture 19140
	)
	
	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(if
		(and (proc951_11 8 19000) (== prevRoomNum 19130))
			(sounds adjChainVol: 16)
			(sounds fade: 21909 0 15 8 1 0)
			(sounds
				playChain: -1 -5 21901 -1 -1 -5 21901 -1 -1 -5 21904 -1
			)
			(sounds play: 21903 -1 48 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19020
	)
	
	(method (init)
		(self
			createPoly:
				133
				30
				110
				33
				102
				43
				93
				51
				91
				66
				92
				92
				93
				117
				175
				118
				173
				54
				165
				42
				151
				35
		)
		(super init: &rest)
	)
)
