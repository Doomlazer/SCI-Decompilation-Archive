;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1064)
(include sci.sh)
(use Kq6Talker)

(public
	MotherGhost 40
)

(instance MotherGhost of Kq6Talker
	(properties
		x 5
		y 5
		view 2002
		cel 1
		talkWidth 213
		textX 76
		textY 8
	)
	
	(method (init)
		(super init: 0 0 0 &rest)
	)
)
