;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1900)
(include game.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Irmgaard 15
)

(instance Irmgaard of Talker
	(properties
		x 0
		y 0
		loop 1
		talkWidth 150
		back 15
		textX 10
		textY 10
	)
	
	(method (init)
		(= view (if (== curRoomNum 155) 1156 else 828))
		(= font userFont)
		(if (== curRoomNum 155)
			(= disposeWhenDone FALSE)
			(= bust irmgaardBust)
			(= eyes irmgaardEyes)
			(= mouth irmgaardMouth)
			(= textX 10)
			(= textY 125)
		else
			(= mouth (= eyes (= bust 0)))
		)
		(super init: &rest)
	)
)

(instance irmgaardBust of Prop
	(properties
		view 1156
		loop 1
	)
)

(instance irmgaardEyes of Prop
	(properties
		nsTop 87
		nsLeft 258
		view 1156
		loop 2
	)
)

(instance irmgaardMouth of Prop
	(properties
		nsTop 96
		nsLeft 258
		view 1156
	)
)
