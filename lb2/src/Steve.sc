;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1887)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Steve 12
)

(instance Steve of Talker
	(properties
		x 5
		y 5
		view 1887
		loop 3
		talkWidth 150
		back 15
		textX 107
		textY 12
	)
	
	(method (init)
		(= font userFont)
		(super init: steveBust steveEyes steveMouth &rest)
	)
)

(instance steveBust of Prop
	(properties
		view 1887
		loop 1
	)
)

(instance steveEyes of Prop
	(properties
		nsTop 39
		nsLeft 27
		view 1887
		loop 2
	)
)

(instance steveMouth of Prop
	(properties
		nsTop 49
		nsLeft 20
		view 1887
	)
)
