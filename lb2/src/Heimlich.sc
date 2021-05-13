;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1889)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Heimlich 18
)

(instance Heimlich of Talker
	(properties
		x 5
		y 5
		view 1889
		loop 3
		talkWidth 150
		back 15
		textX 110
		textY 12
	)
	
	(method (init)
		(= font userFont)
		(super
			init: heimlichBust heimlichEyes heimlichMouth &rest
		)
	)
)

(instance heimlichBust of Prop
	(properties
		view 1889
		loop 1
	)
)

(instance heimlichEyes of Prop
	(properties
		nsTop 36
		nsLeft 28
		view 1889
		loop 2
	)
)

(instance heimlichMouth of Prop
	(properties
		nsTop 53
		nsLeft 33
		view 1889
	)
)
