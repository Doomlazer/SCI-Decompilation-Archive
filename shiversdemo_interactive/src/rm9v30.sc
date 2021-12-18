;;; Sierra Script 1.0 - (do not remove this comment)
(script# 9300)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm9v30 0
)

(instance rm9v30 of ShiversRoom
	(properties
		picture 9300
	)
	
	(method (init)
		(efExitStairs init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
	
	(method (newRoom n)
		(if (and (proc951_5 42) (< 9000 n) (< n 9300))
			(sounds fade: 10908 0 20 3 1 0)
			(MonoOut {fade to 0})
		)
		(super newRoom: n &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9331
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9310
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9270
	)
	
	(method (init)
		(self
			createPoly: 63 143 88 111 91 63 207 64 219 87 217 141
		)
		(super init: &rest)
	)
)

(instance efExitStairs of ExitFeature
	(properties
		nextRoom 9240
	)
	
	(method (init)
		(self
			createPoly:
				194
				111
				194
				84
				215
				84
				198
				57
				185
				41
				184
				11
				209
				38
				235
				47
				250
				56
				250
				115
				194
				112
		)
		(super init: &rest)
	)
)
