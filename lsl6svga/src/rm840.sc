;;; Sierra Script 1.0 - (do not remove this comment)
(script# 840)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm840 0
)

(local
	local0
	local1
	local2
	theTub
	local4
	local5
	local6
)
(instance rm840 of LarryRoom
	(properties
		noun 1
		picture 840
		horizon 0
		west 820
	)
	
	(method (init)
		(curRoom
			addObstacle:
				(= local0
					((Polygon new:)
						type: 3
						init: 0 133 48 127 63 121 287 123 319 130 319 89 135 89 135 75 55 86 0 83
						yourself:
					)
				)
				((Polygon new:)
					type: 2
					init: 213 100 214 106 187 104 193 99
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 72 90 154 93 119 108 68 103
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 293 116 299 105 315 106 316 120
					yourself:
				)
		)
		(super init: &rest)
		(tent init:)
		(table1 init:)
		(table2 init:)
		(razorWire init:)
		(dancer1
			init:
			setPri: 30
			cycleSpeed: 10
			setScript: boogie
		)
		(guyChugger init: setPri: 30 ignoreActors: 1)
		(girlChugger
			init:
			setPri: 30
			ignoreActors: 1
			setScript: guzzleBeer
		)
		(tub init:)
		(walkHandler addToFront: tent)
		(theMusic
			number: 840
			loop: -1
			play:
			setVol: 50
			fade: 127 10 10 0
		)
		(ego init: normalize: posn: -8 101)
		(fence init:)
		(trees init:)
		(proc79_11 843)
		(self setScript: enterRoom)
	)
	
	(method (dispose)
		(sFx number: 0 stop:)
		(proc79_12 843)
		(walkHandler delete: tent)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2
					(if local2
						(messager say: 1 2 1)
						(return 1)
					else
						(super doVerb: theVerb)
					)
				)
				(else  (super doVerb: theVerb))
			)
		)
	)
	
	(method (newRoom n)
		(theMusic fade:)
		(super newRoom: n)
	)
)

(instance boogie of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: (Random 0 2) setCel: 0 setCycle: Fwd)
				(= seconds (Random 1 5))
			)
			(1 (self init:))
		)
	)
)

(instance guzzleBeer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(girlChugger setCel: 0)
				(guyChugger setCycle: CT 3 1 self)
			)
			(1 (= ticks 180))
			(2
				(guyChugger setCycle: Beg self)
			)
			(3 (= ticks 30))
			(4
				(girlChugger setCycle: End self)
			)
			(5
				(sFx number: 843 loop: 1 play:)
				(girlChugger loop: 1 setCel: 0 setCycle: End self)
			)
			(6 (= ticks 180))
			(7
				(girlChugger setCycle: Beg self)
			)
			(8
				(girlChugger loop: 0 setCycle: End self)
			)
			(9
				(sFx number: 843 loop: 1 play:)
				(= ticks 20)
			)
			(10 (self init:))
		)
	)
)

(instance exitTent of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= local5 (- mouseX 10))
				(= local6 (- mouseY 10))
				(= local2 0)
				((curRoom obstacles?) delete: local1)
				(local1 dispose:)
				(curRoom
					addObstacle:
						(= local0
							((Polygon new:)
								type: 3
								init: 0 133 48 127 63 121 287 123 319 130 319 89 135 89 135 75 55 86 0 83
								yourself:
							)
						)
				)
				(= cycles 2)
			)
			(1
				(ego setMotion: MoveTo 154 82 self)
			)
			(2
				(ego
					view: 840
					setPri: 30
					setLoop: 3 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 139 83 self
				)
			)
			(3
				(ego normalize: 900 1 setMotion: MoveTo 127 81 self)
			)
			(4
				(walkHandler delete: outSide addToFront: tent)
				(ego setMotion: PolyPath local5 local6)
				(outSide dispose:)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setMotion: MoveTo 12 101 self)
			)
			(1
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterTent of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= local2 1)
				(outSide init:)
				(walkHandler delete: tent addToFront: outSide)
				((curRoom obstacles?) delete: local0)
				(local0 dispose:)
				(curRoom
					addObstacle:
						(= local1
							((Polygon new:)
								type: 3
								init: 319 84 319 82 153 82 153 85 319 85
								yourself:
							)
						)
				)
				(ego setMotion: PolyPath 138 82 self)
			)
			(1
				(ego
					view: 840
					setPri: 30
					loop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 151 82 self
				)
			)
			(2
				(ego view: 843 setMotion: MoveTo 153 83 self)
			)
			(3
				(if (== local4 3)
					(= local4 (= register 0))
					(ego setMotion: PolyPath local5 local6)
					(theGame handsOn:)
					(self dispose:)
				)
				(if (self register?)
					(theTub doVerb: register)
					(= register 0)
				)
				(if (!= theTub tub)
					(= register 0)
					(theGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getBeer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: MoveTo 212 83 self)
			)
			(1
				(cond 
					((== (self register?) 4) (messager say: 7 4 0 0 self))
					((== (self register?) 35)
						(= global185 0)
						((inventory at: 39) cue:)
						(messager say: 7 35 0 0 self)
					)
					(else (self cue:))
				)
			)
			(2
				(if (OneOf (self register?) 4 35)
					(theGame handsOn:)
					(self dispose:)
				else
					(self cue:)
				)
			)
			(3
				(ego
					setSpeed: 12
					view: 844
					loop: 0
					setCel: 0
					setSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(4
				(sFx number: 843 loop: 1 play:)
				(ego setCycle: End self)
			)
			(5 (= ticks 60))
			(6
				(if (Btst 271)
					(theGame changeScore: 6 272)
				else
					(theGame changeScore: 6 271)
				)
				(ego view: 843 setCycle: Walk get: 3)
				(= register 0)
				(enterTent register: 0)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tub of View
	(properties
		noun 7
		x 225
		y 86
		view 840
		loop 1
	)
	
	(method (doVerb theVerb)
		(= theTub tub)
		(return
			(switch theVerb
				(5
					(cond 
						((not local2) (curRoom setScript: enterTent 0 theVerb))
						((ego has: 3) (messager say: 7 5 3) (theGame handsOn:) (return 1))
						((Btst 215) (messager say: 7 5 2) (theGame handsOn:) (return 1))
						(else (curRoom setScript: getBeer 0 5))
					)
				)
				(35
					(if (not local2)
						(curRoom setScript: enterTent 0 theVerb)
					else
						(curRoom setScript: getBeer 0 35)
					)
				)
				(4
					(if (not local2)
						(curRoom setScript: enterTent 0 theVerb)
					else
						(curRoom setScript: getBeer 0 4)
					)
				)
				(else  (super doVerb: theVerb))
			)
		)
	)
)

(instance dancer1 of Prop
	(properties
		noun 8
		x 282
		y 85
		view 841
		loop 2
	)
)

(instance guyChugger of Prop
	(properties
		noun 11
		x 204
		y 86
		view 845
		loop 3
	)
)

(instance girlChugger of Prop
	(properties
		noun 12
		x 236
		y 86
		view 845
	)
)

(instance tent of Feature
	(properties
		noun 2
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 147 85 145 33 135 33 153 15 164 0 319 0 319 85
					yourself:
				)
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 3)
			(= local4 3)
			(= local5 (- mouseX 10))
			(= local6 (- mouseY 10))
			(curRoom setScript: enterTent)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance table1 of Feature
	(properties
		noun 3
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 14 76 13 66 24 67 26 60 69 58 76 75 15 76
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table2 of Feature
	(properties
		noun 4
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 84 92 92 77 108 71 136 71 154 88 137 92 85 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance razorWire of Feature
	(properties
		noun 5
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init:
						0
						139
						0
						116
						59
						103
						88
						101
						130
						114
						199
						113
						208
						103
						261
						106
						302
						117
						291
						58
						319
						55
						319
						139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fence of Feature
	(properties
		noun 6
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 0 79 0 34 138 36 134 44 142 47 142 73 79 77 72 64 23 65 12 79
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance trees of Feature
	(properties
		noun 9
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 0 25 0 0 319 0 319 10 160 11 139 35 90 34 79 14 65 14 62 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance outSide of Feature
	(properties
		y 100
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 0 79 143 73 143 90 319 89 319 139 0 138 0 80
					yourself:
				)
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(if (and (== (ego view?) 843) (== theVerb 3))
			(curRoom setScript: exitTent)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sFx of Sound
	(properties
		flags $0001
	)
)
