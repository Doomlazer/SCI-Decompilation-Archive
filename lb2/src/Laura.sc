;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1881)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Laura 2
)

(instance Laura of Talker
	(properties
		x 5
		y 5
		view 1881
		loop 3
		talkWidth 150
		back 15
		textX 107
		textY 12
	)
	
	(method (init)
		(= font userFont)
		(lauraBust setCel: (not (ego wearingGown?)))
		(super init: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		view 1881
		loop 1
	)
)

(instance lauraEyes of Prop
	(properties
		nsTop 34
		nsLeft 30
		view 1881
		loop 2
	)
)

(instance lauraMouth of Prop
	(properties
		nsTop 50
		nsLeft 29
		view 1881
	)
)
