;;; Sierra Script 1.0 - (do not remove this comment)
(script# 247)
(include sci.sh)
(use Main)
(use Vendor)
(use GloryTalker)
(use Actor)

(public
	honeyTalker 0
	honeyVendor 1
)

(local
	theVendor
)
(instance honeyTalker of GloryTalker
	(properties
		x 10
		y 15
		view 255
		loop 1
		talkWidth 260
		back 57
		textX 15
		textY 95
		backColor 12
	)
	
	(method (init)
		(super init: honeyBust honeyEyes honeyMouth &rest)
	)
)

(instance honeyBust of View
	(properties
		nsTop 21
		nsLeft 28
		view 255
		loop 3
	)
)

(instance honeyMouth of Prop
	(properties
		nsTop 52
		nsLeft 31
		view 255
	)
)

(instance honeyEyes of Prop
	(properties
		nsTop 40
		nsLeft 35
		view 255
		loop 2
	)
)

(instance honeyVendor of Vendor
	(properties
		noun 4
	)
	
	(method (dispose)
		(= goods 0)
		(super dispose: &rest)
	)
	
	(method (transact param1 param2)
		(= theVendor self)
		(switch param1
			(0
				(Buy param1 param2 theVendor)
				(ego solvePuzzle: 224 2 get: 29 param2)
				(messager say: 4 6 10 0 self)
			)
		)
	)
	
	(method (doBargain param1)
		(switch param1
			(1
				(messager say: 4 6 11 0 self)
			)
			(2
				(messager say: 4 6 14 0 self)
			)
			(3
				(messager say: 4 6 15 0 self)
			)
			(4
				(messager say: 4 6 16 0 self)
			)
			(5
				(messager say: 4 6 12 0 self)
			)
			(6
				(messager say: 4 6 13 0 self)
			)
			(else  (self cue:))
		)
	)
)
