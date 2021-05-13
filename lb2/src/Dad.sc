;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1880)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Dad 1
)

(instance Dad of Talker
	(properties
		x 5
		y 5
		view 1880
		loop 3
		talkWidth 150
		back 15
		textX 105
		textY 12
	)
	
	(method (init)
		(= font userFont)
		(super init: dadBust dadEyes dadMouth &rest)
	)
)

(instance dadBust of Prop
	(properties
		view 1880
		loop 1
	)
)

(instance dadEyes of Prop
	(properties
		nsTop 34
		nsLeft 26
		view 1880
		loop 2
	)
)

(instance dadMouth of Prop
	(properties
		nsTop 43
		nsLeft 24
		view 1880
	)
)
