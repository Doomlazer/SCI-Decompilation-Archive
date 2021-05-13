;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1890)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Ziggy 6
)

(instance Ziggy of Talker
	(properties
		x 5
		y 5
		view 1890
		loop 3
		talkWidth 150
		back 15
		textX 115
		textY 12
	)
	
	(method (init)
		(= font userFont)
		(super init: ziggyBust ziggyEyes ziggyMouth &rest)
	)
)

(instance ziggyBust of Prop
	(properties
		view 1890
		loop 1
	)
)

(instance ziggyEyes of Prop
	(properties
		nsTop 39
		nsLeft 30
		view 1890
		loop 2
	)
)

(instance ziggyMouth of Prop
	(properties
		nsTop 55
		nsLeft 24
		view 1890
	)
)
