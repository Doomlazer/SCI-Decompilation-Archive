;;; Sierra Script 1.0 - (do not remove this comment)
(script# 340)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use Scaler)
(use RandCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Reverse)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	gEgoView
	local1
	local2
)
(instance rm340 of LarryRoom
	(properties
		noun 1
		picture 340
		horizon 0
		north 350
	)
	
	(method (init)
		(if (theMusic2 handle?) (theMusic2 stop:))
		(curRoom
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						48
						139
						42
						167
						85
						167
						104
						150
						118
						104
						136
						82
						108
						82
						115
						93
						92
						100
						47
						139
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						266
						119
						248
						112
						266
						105
						304
						114
						314
						129
						305
						134
						289
						132
						278
						122
						267
						119
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 69 319 120 286 100 244 93 203 95 199 85
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 159 80 183 80 208 137 159 137
					yourself:
				)
		)
		(super init: &rest)
		(if (or (not prevRoomNum) (== prevRoomNum 350))
			(theMusic number: 310 play: setLoop: -1 setVol: 95)
		)
		(ego
			init:
			normalize:
			actions: egoActions
			setScaler: Scaler 100 67 129 77
		)
		(showerDoor init: approachVerbs: 3)
		(larryLocker init: setCel: (if (Btst 47) 4 else 0))
		(girlLocker init:)
		(lamps init:)
		(rightSide init:)
		(cond 
			((Random 0 1) (girl1 init: ignoreActors: 1))
			((Random 0 1)
				(girl2
					init:
					ignoreActors: 1
					setScaler: Scaler 100 67 100 90
					setScript: babeLeaves
				)
			)
			((Random 0 1) (showerGirl init: cycleSpeed: 12 setScript: girlShowers))
			(else (girl1 init: setScript: babeEnters))
		)
		(dirtyPoster init: approachVerbs: 4)
		(dirtyTowel init: ignoreActors: 1)
		((dirtyTowel new:) setLoop: 1 1 x: 242 y: 124 init:)
		((dirtyTowel new:) setLoop: 2 1 x: 196 y: 121 init:)
		((dirtyTowel new:) setLoop: 3 1 x: 163 y: 131 init:)
		((dirtyTowel new:) setLoop: 4 1 x: 268 y: 110 init:)
		(lockers init:)
		(garbageCan init: approachVerbs: 4)
		(walkHandler addToFront: showerDoor)
		(switch prevRoomNum
			(310
				(ego posn: 86 158)
				(curRoom setScript: enterFromLobby)
			)
			(350
				(ego posn: 125 87)
				(curRoom setScript: enterFromShower)
			)
			(else 
				(ego posn: 125 87)
				(curRoom setScript: enterFromLobby)
			)
		)
	)
	
	(method (doit &tmp egoEdgeHit egoY)
		(super doit: &rest)
		(= egoEdgeHit (ego edgeHit?))
		(= egoY (ego y?))
		(cond 
			(script)
			((== egoEdgeHit 3)
				(if (not (OneOf (ego view?) 0 900))
					(messager say: 7 0 3)
					(self setScript: enterFromLobby)
				else
					(curRoom setScript: toSpaLobby)
				)
			)
			((< egoY 87) (theMusic fade:) (curRoom newRoom: 350))
		)
		(cond 
			(
				(and
					(== (ego view?) 900)
					(ego mover?)
					(== (ego cel?) 4)
				)
				(if (== local1 0)
					(= local1 1)
					(sfx number: 346 loop: 1 play:)
				)
			)
			(
				(and
					(== (ego view?) 900)
					(ego mover?)
					(== (ego cel?) 1)
					(== local1 1)
				)
				(= local1 0)
				(sfx number: 347 loop: 1 play:)
			)
		)
	)
	
	(method (dispose)
		(sfx number: 0 stop:)
		(walkHandler delete: showerDoor)
		(super dispose:)
	)
)

(instance girlShowers of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(showerGirl setCycle: CT (Random 1 9) 1 self)
			)
			(1 (= ticks (Random 30 120)))
			(2
				(showerGirl setCycle: Beg self)
			)
			(3 (= ticks (Random 90 180)))
			(4 (self init:))
		)
	)
)

(instance openLocker of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath 84 106 self)
			)
			(1
				(theGame changeScore: 4 189)
				(= gEgoView (ego view?))
				(ego
					loop: (if (== (ego view?) 353) 1 else 0)
					view: 342
					setCel: 0
					setSpeed: 12
					setScale: 0
					setCycle: CT 5 1 self
				)
			)
			(2
				(sfx number: 343 loop: 1 play:)
				(= ticks 90)
			)
			(3 (ego setCycle: CT 3 -1 self))
			(4
				(sfx number: 343 loop: 1 play:)
				(= ticks 90)
			)
			(5
				(ego setSpeed: 12 setCycle: CT 5 1 self)
			)
			(6
				(sfx number: 343 loop: 1 play:)
				(= ticks 90)
			)
			(7
				(ego setCycle: Beg self)
				(sfx number: 344 loop: 1 play:)
			)
			(8
				(larryLocker cel: 0 setCycle: End)
				(ego
					normalize: gEgoView 1 1
					setScaler: Scaler 100 67 129 88
				)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeLocker of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath 84 106 self)
			)
			(1
				(= gEgoView (ego view?))
				(larryLocker setCycle: Beg self)
				(ego
					loop: (if (== (ego view?) 353) 1 else 0)
					view: 342
					setCel: 5
					setSpeed: 12
					setScale: 0
					setCycle: Beg
				)
			)
			(2
				(sfx number: 345 loop: 1 play:)
				(ego
					normalize: gEgoView 1 1
					setScaler: Scaler 100 67 129 88
				)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toSpaLobby of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(theMusic fade: 127 10 5 0)
				(ego setMotion: MoveTo (ego x?) 185 self)
			)
			(1 (curRoom newRoom: 310))
		)
	)
)

(instance enterFromLobby of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: MoveTo 102 135 self)
			)
			(1
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromShower of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath 118 100 self)
			)
			(1
				(ego normalize: (ego view?) 2 1)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance babeLeaves of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 5 20)))
			(1 (girl2 setCycle: Beg self))
			(2
				(girl2
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 196 84 self
				)
			)
			(3
				(girl2 setMotion: PolyPath 212 84 self)
			)
			(4
				(if (cast contains: girl1)
					(girl1 setScript: babeEnters)
				)
				(girl2 setPri: -1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance babeEnters of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 5 25)))
			(1
				(girl2
					x: 196
					y: 84
					init:
					setPri: 100
					setScaler: Scaler 100 75 100 90
					setCycle: Walk
					setMotion: PolyPath 233 97 self
				)
			)
			(2
				(girl2
					setScale: 0
					view: 344
					posn: 263 70
					loop: 0
					setPri: -1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(girlLocker setCycle: End self)
			)
			(4
				(girl2 loop: 1 setCel: 0 setCycle: End self)
			)
			(5 (= seconds 5))
			(6
				(girl2 loop: 2 setCel: 0 setCycle: End self)
				(girlLocker setCycle: Beg)
			)
			(7 (= seconds 2))
			(8
				(girl2
					view: 341
					setScaler: Scaler 100 75 100 90
					posn: 235 98
					setCycle: Walk
					setMotion: PolyPath 215 110 self
				)
			)
			(9
				(girl2 setMotion: PolyPath 257 118 self)
			)
			(10
				(girl2 setMotion: MoveTo 257 118 self)
			)
			(11
				(girl2 loop: 5 setCel: 0 setCycle: End self)
			)
			(12
				(girl2 setScript: babeLeaves)
				(self dispose:)
			)
		)
	)
)

(instance wearTowel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath 82 106 self)
			)
			(1
				(ego setMotion: MoveTo 75 106 self)
			)
			(2
				(ego
					view: 342
					setSpeed: 12
					setScale: 0
					loop: 2
					setPri: (- (larryLocker priority?) 1)
					setCel: 0
					setCycle: End self
				)
				(sfx2 number: 234 loop: -1 play:)
			)
			(3 (= ticks 30))
			(4
				(ego loop: 3 setCel: 0 setCycle: End self)
			)
			(5
				(sfx2 number: 0 stop:)
				(= ticks 30)
			)
			(6
				(ego loop: 4 setCel: 0 setCycle: End self)
			)
			(7 (= ticks 30))
			(8
				(inventory eachElementDo: #perform dropInv)
				(ego get: 38)
				(theGame changeScore: 6 190)
				(= ticks 30)
			)
			(9
				(ego
					view: 353
					setLoop: 1 1
					setCycle: Rev
					setScaler: Scaler 100 67 129 88
					setPri: -1
					setMotion: MoveTo 83 106 self
				)
			)
			(10
				(larryLocker setCycle: Beg self)
			)
			(11
				(sfx number: 345 loop: 1 play:)
				(Bclr 47)
				(ego normalize: 353 1 1)
				(Bset 74)
				(UpdateScreenItem ((ScriptID 92 3) view: 1901))
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getDressed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath 82 106 self)
			)
			(1
				(ego setMotion: MoveTo 75 106 self)
			)
			(2
				(ego
					view: 342
					setSpeed: 12
					loop: 4
					setCel: 4
					setScale: 0
					setPri: (- (larryLocker priority?) 1)
					setCycle: Beg self
				)
			)
			(3 (= ticks 30))
			(4
				(sfx2 number: 234 loop: -1 play:)
				(ego loop: 3 setCel: 14 setCycle: Beg self)
			)
			(5 (= ticks 30))
			(6
				(ego view: 342 loop: 2 setCel: 11 setCycle: Beg self)
			)
			(7
				(sfx2 number: 0 stop:)
				(= ticks 30)
			)
			(8
				(inventory eachElementDo: #perform getInv)
				(ego
					get: 38
					view: 900
					setLoop: 1 1
					setPri: -1
					setCycle: Rev
					setScaler: Scaler 100 67 129 88
					setMotion: MoveTo 85 106 self
				)
			)
			(9
				(larryLocker setCycle: Beg self)
			)
			(10
				(sfx number: 345 loop: 1 play:)
				(Bclr 47)
				(ego normalize: 900 1 1)
				(Bclr 74)
				(UpdateScreenItem ((ScriptID 92 3) view: 1900))
				(self cue:)
			)
			(11
				(if (Btst 65)
					(Bclr 65)
					(messager say: 1 0 6 0 self)
				else
					(self cue:)
				)
			)
			(12
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance larryLocker of Prop
	(properties
		noun 6
		x 61
		y 79
		view 346
		loop 3
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(56
					(cond 
						((not (Btst 47))
							(cond 
								((== (ego view?) 353) (messager say: 6 56 3) (return 1))
								((== (ego view?) 900) (super doVerb: theVerb))
								(else (messager say: 6 56 1) (return 1))
							)
						)
						((== (ego view?) 900) (curRoom setScript: wearTowel))
						((Btst 25)
							(if (== (ego view?) 353)
								(messager say: 7 0 2)
							else
								(messager say: 7 0 1)
							)
							(return 1)
						)
						(else (curRoom setScript: getDressed))
					)
				)
				(4
					(cond 
						((== (ego view?) 351) (messager say: 6 4 1) (return 1))
						((Btst 47) (Bclr 47) (curRoom setScript: closeLocker))
						(else (Bset 47) (curRoom setScript: openLocker))
					)
				)
				(else  (super doVerb: theVerb))
			)
		)
	)
)

(instance girlLocker of Prop
	(properties
		x 264
		y 70
		view 346
		loop 1
	)
)

(instance dirtyTowel of View
	(properties
		x 214
		y 106
		view 340
	)
)

(instance girl1 of Prop
	(properties
		x 172
		y 106
		view 345
		loop 1
		cycleSpeed 12
	)
	
	(method (doit)
		(if
		(and (not (self cycler?)) (== (Random 0 500) 50))
			(if (== (self cel?) 0)
				(self setCycle: CT (Random 1 5) 1)
			else
				(self setCycle: Beg)
			)
		)
		(super doit: &rest)
	)
)

(instance girl2 of Actor
	(properties
		x 257
		y 118
		view 341
		loop 5
		cel 5
	)
)

(instance showerGirl of Prop
	(properties
		x 200
		y 87
		view 345
		cel 5
	)
	
	(method (cue)
		(self setCycle: RandCycle 5)
	)
)

(instance lockers of Feature
	(properties
		noun 3
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 0 30 76 45 71 98 56 106 49 106 11 120 10 123 0 127
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance dirtyPoster of Feature
	(properties
		noun 4
		nsLeft 82
		nsTop 59
		nsRight 93
		nsBottom 72
		approachX 91
		approachY 107
		x 87
		y 90
	)
)

(instance garbageCan of Feature
	(properties
		noun 5
		approachX 91
		approachY 107
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 82 93 77 80 81 77 92 78 90 91 83 93
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance showerDoor of Feature
	(properties
		noun 2
		nsLeft 98
		nsTop 44
		nsRight 137
		nsBottom 96
		approachX 122
		approachY 83
		x 130
		y 20
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 3)
			(curRoom newRoom: 350)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lamps of Feature
	(properties
		noun 9
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 47 17 48 13 57 10 68 11 75 13 76 18 62 21 48 19
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightSide of Feature
	(properties
		noun 11
		x 160
		y 200
	)
	
	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: 0
					init: 155 0 319 0 319 138 152 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance egoActions of Actions
	(properties)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(56
					(cond 
						((not (Btst 47))
							(if (== (ego view?) 900)
								(messager say: 7 56 5)
							else
								(messager say: 7 56 3)
							)
							(return 1)
						)
						((Btst 25)
							(if (== (ego view?) 353)
								(messager say: 7 0 2)
							else
								(messager say: 7 0 1)
							)
							(return 1)
						)
						((== (ego view?) 353) (curRoom setScript: getDressed) (return 1))
						(else (curRoom setScript: wearTowel) (return 1))
					)
				)
				(else  (super doVerb: theVerb))
			)
		)
	)
)

(instance dropInv of Code
	(properties)
	
	(method (doit param1)
		(if
			(and
				(not (== param1 (ScriptID 85 5)))
				(== (param1 owner?) -2)
			)
			(ego put: (inventory indexOf: param1) 340)
		)
	)
)

(instance getInv of Code
	(properties)
	
	(method (doit param1)
		(if
			(and
				(not (== param1 (ScriptID 85 5)))
				(== (param1 owner?) 340)
			)
			(ego get: (inventory indexOf: param1))
		)
	)
)

(instance sfx of Sound
	(properties
		flags $0005
	)
)

(instance sfx2 of Sound
	(properties
		flags $0005
	)
)
