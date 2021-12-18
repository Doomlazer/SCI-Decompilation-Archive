;;; Sierra Script 1.0 - (do not remove this comment)
(script# 9510)
(include sci.sh)
(use Main)
(use Procs)

(public
	rm9v51 0
)

(instance rm9v51 of ShiversRoom
	(properties
		picture 9510
	)
	
	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitUp init: 4)
		(if (proc951_11 6 9000)
			(sounds fade: 20903 0 10 16 1 0)
			(proc951_9 20908)
			(sounds play: 20908 -1 50 0)
		)
		(super init: &rest)
	)
	
	(method (newRoom n)
		(if (and (!= n 9540) (proc951_11 6 9000))
			(sounds fade: 20908 0 10 16 1 0)
			(sounds stop: 20903)
			(proc951_9 20903)
			(sounds play: 20903 -1 0 0)
			(sounds fade: 20903 42 10 16 0 0)
		)
		(super newRoom: n &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9480
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9480
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9540
	)
	
	(method (init)
		(self createPoly: 66 139 34 125 39 53 210 59 217 141)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 9920
	)
	
	(method (init)
		(self createPoly: 236 32 20 18 20 0 243 0)
		(super init: &rest)
	)
)
