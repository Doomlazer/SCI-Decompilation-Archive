;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1894)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Sam 3
)

(instance Sam of Talker
	(properties
		x 5
		y 5
		view 1894
		loop 3
		talkWidth 150
		back 15
		textX 105
		textY 12
	)
	
	(method (init)
		(= font userFont)
		(super init: samBust samEyes samMouth &rest)
	)
)

(instance samBust of Prop
	(properties
		view 1894
		loop 1
	)
)

(instance samEyes of Prop
	(properties
		nsTop 35
		nsLeft 31
		view 1894
		loop 2
	)
)

(instance samMouth of Prop
	(properties
		nsTop 43
		nsLeft 19
		view 1894
	)
)
