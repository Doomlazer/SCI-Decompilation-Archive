;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1060)
(include sci.sh)
(use Kq6Talker)

(public
	Door_Master 83
)

(instance Door_Master of Kq6Talker
	(properties
		x 190
		y 200
		view 2002
		loop 1
		cel 1
		talkWidth 110
		textX 0
		textY -120
		name "Door Master"
	)
	
	(method (init)
		(super init: 0 0 0 &rest)
	)
)
