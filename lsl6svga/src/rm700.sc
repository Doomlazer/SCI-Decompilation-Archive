;;; Sierra Script 1.0 - (do not remove this comment)
(script# 700)
(include sci.sh)
(use Main)
(use LarryRoom)
(use PolyFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
	local1
)
(instance rm700 of LarryRoom
	(properties
		noun 1
		picture 700
		horizon 0
		west 710
	)
	
	(method (init)
		(curRoom
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						0
						139
						319
						139
						319
						97
						288
						97
						268
						85
						242
						85
						242
						71
						286
						71
						310
						89
						319
						89
						319
						76
						235
						49
						229
						45
						212
						47
						202
						45
						146
						45
						130
						43
						82
						63
						73
						70
						26
						49
						0
						49
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 159 100 213 84 261 92 276 109 226 128 197 128 154 116
					yourself:
				)
		)
		(super init: &rest)
		(ego
			normalize: 900 2
			setScaler: Scaler 100 80 121 47
			init:
		)
		(switch prevRoomNum
			(570
				(self setScript: fromKitchenScr)
			)
			(else 
				(self setScript: fromBalconyScr)
			)
		)
		(if (!= prevRoomNum 710)
			(theMusic
				number: 700
				loop: -1
				setVol: 50
				play:
				fade: 127 10 10 0
			)
		)
		(dumbWaiter init:)
		(elevatorDoor init: approachVerbs: 4)
		(elevatorButton init: approachVerbs: 4)
		(priFixPoly init:)
		(plant1 init:)
		(table1 init:)
		(door init:)
		(table2 init:)
		(screen init:)
		(lamp init:)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script 0)
			((and (not local1) (ego inRect: 282 67 328 93)) (ego setPri: 73) (= local1 1))
			((and local1 (not (ego inRect: 282 67 328 93))) (ego setPri: -1) (= local1 0))
		)
	)
	
	(method (newRoom n)
		(priFixPoly dispose:)
		(if (!= n 710) (theMusic fade:))
		(super newRoom: n)
	)
	
	(method (edgeToRoom param1)
		(if (== param1 4) (self setScript: toBalconyScr))
		(return 0)
	)
)

(instance fromBalconyScr of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego posn: -8 80 setMotion: MoveTo 10 80 self)
			)
			(1
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toBalconyScr of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(if register
					(ego setMotion: MoveTo -8 42 self)
				else
					(ego setMotion: MoveTo -8 (ego y?) self)
				)
			)
			(1
				(theGame handsOn:)
				(curRoom newRoom: 710)
			)
		)
	)
)

(instance fromKitchenScr of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dumbWaiter setPri: 2)
				(ego
					setSpeed: 8
					setScale: 0
					setCycle: 0
					posn: 134 47
					view: 701
					loop: 0
					cel: 0
				)
				(= cycles 2)
			)
			(1 (= ticks 60))
			(2
				(dumbWaiter setCycle: End self)
				(theMusic2 number: 573 loop: 1 play:)
			)
			(3 (= ticks 20))
			(4
				(dumbWaiter setPri: -1)
				(ego setCycle: End self)
			)
			(5
				(theMusic2 number: 574 loop: 1 play:)
				(dumbWaiter setCycle: Beg)
				(ego
					normalize: 900 8
					cel: 2
					setScaler: Scaler 100 80 121 47
				)
				(= cycles 2)
			)
			(6
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toKitchenScr of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setHeading: 45 self)
			)
			(1
				(theMusic2 number: 573 loop: 1 play:)
				(dumbWaiter setCycle: End self)
			)
			(2 (= ticks 30))
			(3
				(ego
					posn: 130 47
					setSpeed: 8
					setScale: 0
					view: 701
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(theMusic2 number: 574 loop: 1 play:)
				(dumbWaiter
					setPri: (+ (ego priority?) 1)
					setCycle: Beg self
				)
			)
			(5 (= ticks 30))
			(6 (curRoom newRoom: 570))
		)
	)
)

(instance intoElevatorScr of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setHeading: 0 self)
			)
			(1
				(ego
					view: 901
					loop: 6
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(theMusic2 number: 572 loop: 1 play: self)
			)
			(3 (ego setCycle: Beg self))
			(4
				(ego normalize: 900 8 1 cel: 3)
				(= ticks 20)
			)
			(5
				(ego setMotion: MoveTo 184 45 self)
			)
			(6 (ego setHeading: 0 self))
			(7 (= ticks 120))
			(8
				(theMusic2 number: 602 loop: 1 play:)
				(= ticks 120)
			)
			(9
				(theMusic2 number: 600 loop: 1 play:)
				(elevatorDoor setCycle: End self)
			)
			(10
				(ego setMotion: MoveTo 186 39 self)
			)
			(11 (ego setHeading: 180 self))
			(12 (= ticks 60))
			(13
				(theMusic2 number: 601 loop: 1 play:)
				(elevatorDoor setCycle: Beg self)
			)
			(14 (= ticks 60))
			(15 (curRoom newRoom: 600))
		)
	)
)

(instance plant1 of Feature
	(properties
		noun 10
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 43 31 44 9 57 9 56 38 44 38
					yourself:
				)
		)
		(super init: &rest)
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
					init: 76 60 80 18 91 6 115 16 128 32 119 43
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tryDoorScr of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= cycles 2)
			)
			(1
				(ego
					view: 901
					loop: 6
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(theMusic2 number: 34 loop: 1 play: self)
			)
			(3 (ego setCycle: Beg self))
			(4
				(ego normalize: 900 8 1 cel: 3)
				(= cycles 2)
			)
			(5 (messager say: 5 4 0 0 self))
			(6
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 5
		approachX 227
		approachY 47
		x 227
		y 45
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 215 45 217 2 234 3 239 49
					yourself:
				)
			approachVerbs: 4
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(curRoom setScript: tryDoorScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance table2 of Feature
	(properties
		noun 6
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init:
						165
						93
						208
						82
						203
						78
						214
						67
						220
						76
						218
						80
						243
						84
						264
						92
						262
						112
						231
						123
						194
						125
						162
						118
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance balcony of Feature
	(properties
		x 18
		y 34
	)
	
	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4
			setPolygon: ((Polygon new:)
				type: 0
				init: 0 0 29 0 29 25 0 31
				yourself:
			)
			approachX: x
			approachY: y
		)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(curRoom newRoom: 710)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance elevatorButton of Feature
	(properties
		nsLeft 199
		nsTop 25
		nsRight 205
		nsBottom 34
		approachX 203
		approachY 45
		x 203
		y 41
	)
	
	(method (doVerb theVerb)
		(elevatorDoor doVerb: theVerb)
	)
)

(instance elevatorDoor of Actor
	(properties
		noun 4
		approachX 203
		approachY 45
		x 184
		y 41
		view 700
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(self setScript: intoElevatorScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance screen of PolyFeature
	(properties
		noun 8
	)
	
	(method (init)
		(self
			addPolygon:
				((Polygon new:)
					init: 252 26 282 26 302 40 319 39 319 94 299 94 275 76 251 76 251 27
					yourself:
				)
				((Polygon new:)
					init: 0 92 17 92 35 106 56 106 51 140 0 140
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance dumbWaiter of Prop
	(properties
		noun 7
		approachX 134
		approachY 47
		x 137
		y 32
		view 700
		loop 1
		cycleSpeed 12
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(self setScript: toKitchenScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 11
	)
	
	(method (init)
		(super init: &rest)
		(self
			setPolygon: ((Polygon new:)
				init: 215 0 219 35 207 35 212 0
				yourself:
			)
		)
	)
)

(instance priFixPoly of Polygon
	(properties)
	
	(method (init)
		(super init: 277 76 277 56 319 70 319 94 300 94)
	)
)
