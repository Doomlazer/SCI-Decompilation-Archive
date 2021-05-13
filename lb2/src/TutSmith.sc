;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1883)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	TutSmith 9
)

(instance TutSmith of Talker
	(properties
		x 5
		y 5
		view 1883
		loop 3
		talkWidth 150
		back 15
		textX 112
		textY 12
	)
	
	(method (init)
		(= font userFont)
		(super
			init: tutSmithBust tutSmithEyes tutSmithMouth &rest
		)
	)
)

(instance tutSmithBust of Prop
	(properties
		view 1883
		loop 1
	)
)

(instance tutSmithEyes of Prop
	(properties
		nsTop 44
		nsLeft 30
		view 1883
		loop 2
	)
)

(instance tutSmithMouth of Prop
	(properties
		nsTop 64
		nsLeft 20
		view 1883
	)
)
