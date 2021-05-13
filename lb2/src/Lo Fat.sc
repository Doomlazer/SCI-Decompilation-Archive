;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1895)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Lo_Fat 4
)

(instance Lo_Fat of Talker
	(properties
		x 6
		y 47
		view 1895
		loop 3
		talkWidth 150
		back 15
		textX 100
		textY -37
		name "Lo Fat"
	)
	
	(method (init)
		(= font userFont)
		(super init: loFatBust loFatEyes loFatMouth &rest)
	)
)

(instance loFatBust of Prop
	(properties
		view 1895
		loop 1
	)
)

(instance loFatEyes of Prop
	(properties
		nsTop 22
		nsLeft 26
		view 1895
		loop 2
	)
)

(instance loFatMouth of Prop
	(properties
		nsTop 29
		nsLeft 23
		view 1895
	)
)
