;;; Sierra Script 1.0 - (do not remove this comment)
(script# 6161)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm6v161 0
)

(instance rm6v161 of ShiversRoom
	(properties
		picture 6162
	)
	
	(method (init)
		(proc951_16 91)
		(efBack init: 8)
		(efDown init: 5)
		(if (== prevRoomNum 6160)
			(sounds play: 10618 0 58 0)
		else
			(sounds play: 10622 0 58 0)
		)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 6160
	)
	
	(method (init)
		(self
			createPoly: 0 0 0 143 20 143 20 20 243 20 243 143 263 143 263 0
		)
		(super init: &rest)
	)
)

(instance efDown of ExitFeature
	(properties
		nsLeft 20
		nsTop 103
		nsRight 243
		nsBottom 143
		nextRoom 6162
	)
)
