;;; Sierra Script 1.0 - (do not remove this comment)
(script# 66)
(include sci.sh)
(use Main)
(use Game)

(public
	northDeadEndRm 0
)

(instance northDeadEndRm of Rm
	(properties
		picture 66
	)
	
	(method (init)
		(super init:)
		(ego init:)
		(self setRegions: 304)
	)
)
