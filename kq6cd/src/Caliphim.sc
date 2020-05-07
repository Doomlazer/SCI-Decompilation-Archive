;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1004)
(include sci.sh)
(use Kq6Talker)
(use Kq6Procs)
(use Actor)

(public
	Caliphim 11
)

(instance Caliphim of Kq6Talker
	(properties
		x 5
		y 5
		view 899
		talkWidth 213
		textY 12
		raveName {CALIPHIM}
	)
	
	(method (init)
		(if (Btst 91)
			(tBust view: (= view 8991))
			(tEyes view: 8991 nsLeft: 31 nsTop: 34)
			(tMouth view: 8991 nsLeft: 33 nsTop: 43)
			(= raveName {CALIPHID})
		else
			(tBust view: (= view 899))
			(tEyes view: 899 nsLeft: 28 nsTop: 29)
			(tMouth view: 899 nsLeft: 29 nsTop: 38)
			(= raveName {CALIPHIM})
		)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties)
)

(instance tEyes of Prop
	(properties
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		loop 1
	)
)
