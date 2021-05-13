;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1886)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Watney 11
)

(instance Watney of Talker
	(properties
		x 5
		y 5
		view 1886
		loop 3
		talkWidth 150
		back 15
		textX 115
		textY 12
	)
	
	(method (init)
		(= font userFont)
		(super init: watneyBust watneyEyes watneyMouth &rest)
	)
)

(instance watneyBust of Prop
	(properties
		view 1886
		loop 1
	)
)

(instance watneyEyes of Prop
	(properties
		nsTop 36
		nsLeft 30
		view 1886
		loop 2
	)
)

(instance watneyMouth of Prop
	(properties
		nsTop 52
		nsLeft 29
		view 1886
	)
)
