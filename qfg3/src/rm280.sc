;;; Sierra Script 1.0 - (do not remove this comment)
(script# 280)
(include sci.sh)
(use Main)
(use TellerIcon)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm280 0
)

(local
	local0
	[local1 21] = [0 -2 -3 -4 -6 -7 -19 -20 -21 -22 -37 -39 -38 -40 -65 -70 -71 -74 -74 -64 999]
	[local22 11]
	[local33 10] = [0 -4 -5 -7 -20 -65 -66 -69 -71 999]
	[local43 3] = [0 72 999]
	[local46 3] = [0 -5 999]
	[local49 4] = [0 -66 34 999]
	[local53 3] = [0 67 999]
	[local56 6] = [0 -59 -58 56 57 999]
	[local62 4] = [0 60 61 999]
	[local66 4] = [0 68 -69 999]
	[local70 3] = [0 26 999]
	[local73 8] = [0 -78 -11 -19 -36 -75 -76 999]
	[local81 2]
	[local83 7] = [0 -2 -8 -54 -3 -55 999]
	[local90 5]
	[local95 5] = [0 -8 -3 -51 999]
	[local100 4] = [0 -49 -51 999]
	[local104 5] = [0 -50 -48 -18 999]
	[local109 4] = [0 -53 -52 999]
)
(instance rm280 of Rm
	(properties
		noun 10
		picture 280
		horizon 62
		picAngle 70
		vanishingX 168
		vanishingY -160
	)
	
	(method (init)
		(theIconBar enable:)
		(if (== prevRoomNum 270)
			(cSound hold: 0 setVol: 127)
		else
			(cSound number: 280 setLoop: -1 play: 127)
		)
		(= [local22 0] @local1)
		(= [local22 1] @local46)
		(= [local22 2] @local56)
		(= [local22 3] @local62)
		(= [local22 4] @local66)
		(= [local22 5] @local49)
		(= [local22 6] @local53)
		(= [local22 7] @local43)
		(= [local22 8] @local70)
		(= [local90 0] @local83)
		(= [local90 1] @local100)
		(= [local90 2] @local104)
		(= [local90 3] @local109)
		(= [local81 0] @local73)
		(ego
			init:
			normalize:
			x: -100
			y: -100
			noun: 4
			edgeHit: 0
			setScale: 175
			changeGait: 0
		)
		(egoTell init: ego @local73 @local81)
		(kreeshaTell init: kreeshaTop @local1 @local22 @local33)
		(rakeeshTell
			init: (ScriptID 35 1) @local83 @local90 @local95
		)
		(super init:)
		(AutoTarget -10 -10)
		(urn init:)
		(chest init:)
		(pillar init:)
		(vases init:)
		(moreBooks init:)
		(plant init:)
		(shelf init:)
		(otherBottles init:)
		(boxes init:)
		(skulls init:)
		(bottles init:)
		(moreCandles init:)
		(cretianUrn init:)
		(pentagram init:)
		(leftPitcher init:)
		(stool init:)
		(books init:)
		(hornSkull init:)
		(leftCandles init:)
		(rightCandles init:)
		(curRoom
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						0
						319
						189
						0
						189
						0
						88
						3
						88
						3
						187
						317
						187
						317
						115
						295
						115
						292
						108
						295
						100
						317
						100
						316
						92
						232
						92
						232
						96
						267
						97
						272
						107
						267
						115
						37
						115
						38
						108
						52
						97
						65
						97
						65
						93
						0
						84
						0
						0
					yourself:
				)
		)
		(cond 
			(
				(and
					(not (== heroType 3))
					(not (Btst 44))
					(> [egoStats 14] 149)
					(not (Btst 19))
					(== prevRoomNum 420)
				)
				(= local0 kreeshaHomeState)
				(= kreeshaHomeState 8)
			)
			((== kreeshaHomeState 7) (== kreeshaHomeState 7))
			((and (ego has: 44) (not (Btst 69))) (= local0 kreeshaHomeState) (= kreeshaHomeState 6))
			((and (== kreeshaHomeState 3) (Btst 42)) (= kreeshaHomeState 5))
			(
				(and
					(Btst 159)
					(not (== kreeshaHomeState 2))
					(not (Btst 142))
					(not (Btst 35))
				)
				(= kreeshaHomeState 2)
			)
			((Btst 35) (= kreeshaHomeState 3))
			((and (Btst 159) (not (Btst 35))) (= kreeshaHomeState 1))
			(
			(and (not (== kreeshaHomeState 0)) (not (Btst 159))) (= kreeshaHomeState 1))
			((== kreeshaHomeState 0) (= kreeshaHomeState 0))
			(else (= kreeshaHomeState 1))
		)
		(if (== prevRoomNum 285)
			(self setScript: from285)
		else
			(switch kreeshaHomeState
				(0
					(curRoom
						addObstacle:
							((Polygon new:)
								type: 2
								init: 21 159 177 157 178 176 14 179
								yourself:
							)
					)
					(self setScript: firstEntrance)
				)
				(2
					(Bset 142)
					(kreeshaTell init: kreesha @local1 @local22 @local33)
					(kreesha
						x: 169
						y: 146
						loop: 2
						cel: 0
						noun: 2
						actions: kreeshaTell
						init:
						ignoreActors: 1
						stopUpd:
					)
					(curRoom
						addObstacle:
							((Polygon new:)
								type: 2
								init: 98 133 147 126 173 130 178 153 123 161 89 157
								yourself:
							)
					)
					(self setScript: doneChanger)
				)
				(6
					(self setScript: enterWithWood)
				)
				(8
					((ScriptID 35 1) view: 963 loop: 1 x: 236 y: 130 init:)
					(ego x: 155 y: 142 init:)
					(kreesha x: 54 y: 182 init: addToPic:)
					(kreeshaTop
						x: (- (kreesha x?) 2)
						y: (- (kreesha y?) 35)
						setPri: 14
						init:
					)
					(self setScript: ceremonyScript)
				)
				(else 
					(self setScript: mostTimes)
				)
			)
		)
	)
	
	(method (doit)
		(cond 
			((self script?) 0)
			((ego script?) 0)
			((ego inRect: 255 89 319 102)
				(if (OneOf kreeshaHomeState 0 2 4 6 8)
					(self setScript: bePolite)
				else
					(curRoom newRoom: 285)
				)
			)
			((ego inRect: 0 87 45 115) (curRoom setScript: egoExits))
		)
		(super doit:)
	)
	
	(method (dispose)
		(LoadMany 0 964 35 34 49 62)
		(if (== kreeshaHomeState 0) (= kreeshaHomeState 1))
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(if (curRoom script?)
			(super doVerb: theVerb)
		else
			(switch theVerb
				(81
					(cond 
						(
							(or
								(cast contains: kreesha)
								(cast contains: (ScriptID 35 1))
							)
							(messager say: 1 6 86)
						)
						((ego castSpell: 25) (self setScript: (ScriptID 32 0) 0 81))
					)
				)
				(83
					(cond 
						(
							(or
								(cast contains: kreesha)
								(cast contains: (ScriptID 35 1))
							)
							(messager say: 1 6 86)
						)
						((ego castSpell: 27) (self setScript: (ScriptID 32 0) 0 83))
					)
				)
				(88
					(cond 
						(
							(or
								(cast contains: kreesha)
								(cast contains: (ScriptID 35 1))
							)
							(messager say: 1 6 86)
						)
						((ego castSpell: 32) (self setScript: (ScriptID 32 0) 0 88))
					)
				)
				(80
					(if (ego castSpell: 24)
						(curRoom setScript: (ScriptID 12))
					)
				)
				(77
					(if (ego castSpell: 21) (messager say: 1 6 45))
				)
				(85
					(if (ego castSpell: 29) (messager say: 1 6 87))
				)
				(84 ((ScriptID 31 0) init:))
				(86
					(if (ego castSpell: 30)
						(curRoom setScript: (ScriptID 62))
					)
				)
				(82
					(if (ego castSpell: 26) (messager say: 1 6 90))
				)
				(else  (super doVerb: theVerb))
			)
		)
	)
)

(instance from285 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					x: 288
					y: 108
					init:
					normalize:
					setMotion: MoveTo 277 141 self
				)
			)
			(1 (HandsOn) (self dispose:))
		)
	)
)

(instance ceremonyScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (HandsOff) (= cycles 1))
			(1
				(messager say: 1 6 80 0 self)
				(= paladinStat (- [egoStats 14] 9))
			)
			(2
				(messager say: 3 6 46 0 self)
			)
			(3
				((ScriptID 35 1) setCycle: End self)
				(globalSound number: 240 play:)
			)
			(4
				(messager say: 3 6 47 0 self)
			)
			(5
				(ego setMotion: MoveTo 198 136 self)
			)
			(6
				(ego view: 31 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				((ScriptID 35 1) cel: 0)
				(ego setCycle: Beg self)
			)
			(8
				(ego view: 38 loop: 0 cel: 1 setCycle: End self)
			)
			(9 (= seconds 1))
			(10 (ego setCycle: Beg self))
			(11
				(ego normalize:)
				(messager say: 3 6 21 0 self)
			)
			(12
				(messager say: 3 6 35 0 self)
			)
			(13
				(Bset 44)
				(ego solvePuzzle: 238 25 1)
				(= kreeshaHomeState local0)
				(= heroType 3)
				(curRoom newRoom: 340)
			)
		)
	)
)

(instance enterWithWood of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= kreeshaHomeState local0)
				(HandsOff)
				(ego x: 20 y: 110 init: setMotion: PolyPath 133 131 self)
				(kreesha x: 50 y: 180 loop: 0 cel: 0 init: addToPic:)
				(kreeshaTop
					x: (- (kreesha x?) 2)
					y: (- (kreesha y?) 35)
					setPri: 14
					init:
				)
			)
			(1
				(messager say: 2 6 25 0 self)
			)
			(2
				(messager say: 2 6 26 0 self)
			)
			(3
				(ego setMotion: PolyPath 133 146 self)
			)
			(4
				(ego view: 4 cel: 0 setCycle: End self)
			)
			(5
				(stick init:)
				(ego setCycle: Beg self)
			)
			(6
				(ego normalize: setMotion: PolyPath 79 142 self)
			)
			(7 (ego setHeading: 90 self))
			(8
				(messager say: 2 6 27 0 self)
			)
			(9
				(kreeshaTop setCycle: End self)
			)
			(10
				(globalSound number: 12 setLoop: 1 play:)
				(thatOldGlow init: setPri: 12 setCycle: Fwd)
				(stick setPri: 13)
				(= seconds 5)
			)
			(11
				(messager say: 2 6 43 0 self)
			)
			(12
				(globalSound number: 900 setLoop: 1 play:)
				(pentaGlow init: setPri: 11)
				(= seconds 3)
			)
			(13
				(globalSound number: 281 setLoop: 1 play:)
				(stick setMotion: MoveTo 155 96 self)
			)
			(14
				(messager say: 2 6 28 0 self)
			)
			(15
				(ego view: 15 learn: 31 10 drop: 44 setCycle: CT 3 1 self)
				(Bset 69)
			)
			(16
				(pow
					x: 81
					y: 84
					setLoop: 2
					init:
					setScale:
					setPri: 14
					setCycle: Fwd
				)
				(= seconds 1)
			)
			(17
				(ego setCycle: End)
				(globalSound number: 13 setLoop: 1 play:)
				(pow setStep: 6 5 setMotion: MoveTo 153 98 self)
			)
			(18
				(pow dispose:)
				(= seconds 1)
			)
			(19
				(messager say: 2 6 29 0 self)
			)
			(20
				(ego view: 15 setCycle: CT 3 1 self)
			)
			(21
				(pow
					x: 81
					y: 84
					setLoop: 4
					init:
					setScale:
					setPri: 14
					setCycle: Fwd
				)
				(= seconds 1)
			)
			(22
				(ego setCycle: End)
				(globalSound number: 13 setLoop: 1 play:)
				(pow setStep: 6 5 setMotion: MoveTo 153 98 self)
			)
			(23
				(pow dispose:)
				(= seconds 1)
			)
			(24
				(messager say: 2 6 29 0 self)
			)
			(25
				(ego view: 15 setCycle: CT 3 1 self)
			)
			(26
				(pow
					x: 81
					y: 84
					setLoop: 2
					init:
					setScale:
					setPri: 14
					setCycle: Fwd
				)
				(= seconds 1)
			)
			(27
				(ego setCycle: End)
				(globalSound number: 13 setLoop: 1 play:)
				(pow setStep: 6 5 setMotion: MoveTo 153 98 self)
			)
			(28
				(pow dispose:)
				(= seconds 1)
			)
			(29
				(messager say: 2 6 29 0 self)
			)
			(30
				(ego view: 15 setCycle: CT 3 1 self)
			)
			(31
				(pow
					x: 81
					y: 84
					setLoop: 4
					init:
					setScale:
					setPri: 14
					setCycle: Fwd
				)
				(= seconds 1)
			)
			(32
				(ego setCycle: End)
				(globalSound number: 13 setLoop: 1 play:)
				(pow setStep: 6 5 setMotion: MoveTo 153 98 self)
			)
			(33
				(pow dispose:)
				(= seconds 1)
			)
			(34
				(messager say: 2 6 37 0 self)
			)
			(35
				(stick dispose:)
				(ego view: 20 loop: 0 cel: 0 setCycle: End self)
				(globalSound number: 12 setLoop: 1 play:)
			)
			(36
				(ego loop: 2 setCycle: End self)
			)
			(37
				(messager say: 2 6 30 0 self)
			)
			(38
				(pentaGlow dispose:)
				(= seconds 3)
			)
			(39
				(thatOldGlow dispose:)
				(kreeshaTop setCycle: Beg self)
			)
			(40
				(messager say: 2 6 32 0 self)
			)
			(41
				(ego solvePuzzle: 237 10 2)
				(ego normalize:)
				(curRoom newRoom: 270)
			)
		)
	)
)

(instance doneChanger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego x: 20 y: 110 init: setMotion: PolyPath 160 125 self)
			)
			(1 (kreesha setCycle: End self))
			(2
				(kreesha stopUpd:)
				(messager say: 2 6 63 0 self)
			)
			(3
				(if (or (Btst 26) (Btst 27))
					(messager say: 2 6 20 0 self)
				else
					(self cue:)
				)
			)
			(4 (HandsOn) (self dispose:))
		)
	)
)

(instance mostTimes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego x: 20 y: 110 init: setMotion: PolyPath 160 100 self)
			)
			(1
				(switch kreeshaHomeState
					(1
						(messager say: 1 6 17 0 self)
					)
					(3
						(messager say: 1 6 17 0 self)
					)
					(5
						(messager say: 1 6 17 0 self)
					)
					(7
						(messager say: 1 6 17 0 self)
					)
					(else  (self cue:))
				)
			)
			(2 (HandsOn) (self dispose:))
		)
	)
)

(instance firstEntrance of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 15])
		(switch (= state newState)
			(0
				(HandsOff)
				(Bset 6)
				(kreesha
					x: 74
					y: 176
					view: 282
					loop: 0
					cel: 0
					actions: kreeshaTell
					noun: 2
					signal: 16384
					init:
					addToPic:
				)
				(kreeshaTop
					x: (- (kreesha x?) 2)
					y: (- (kreesha y?) 35)
					setPri: 13
					loop: 3
					cel: 0
					signal: 16400
					init:
					cycleSpeed: 12
					setCycle: End self
				)
				(= seconds 5)
			)
			(1
				(globalSound number: 932 setLoop: -1 play: 127)
				(portal cycleSpeed: 10 setCycle: Fwd init:)
				(= seconds 3)
			)
			(2
				(kreeshaTop setCycle: Beg)
				(ego x: 283 y: 115 setMotion: PolyPath 290 170 self)
			)
			(3
				((ScriptID 34 1)
					x: 281
					y: 115
					view: 968
					loop: 2
					cel: 0
					origStep: 1026
					setScale: 165
					setCycle: Walk
					init:
					setMotion: PolyPath 281 123 self
				)
				(ego setLoop: 1)
				(ego setLoop: -1)
			)
			(4
				((ScriptID 34 1) setMotion: PolyPath 180 130 self)
			)
			(5
				((ScriptID 34 1) setLoop: 2 ignoreActors: 1)
				(= cycles 2)
			)
			(6
				((ScriptID 35 1)
					x: 285
					y: 115
					view: 281
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setScale: 165
					setCycle: Walk
					origStep: 1540
					noun: 3
					init:
					setMotion: MoveTo 255 155 self
				)
			)
			(7
				((ScriptID 35 1)
					setLoop: 3
					x: (- ((ScriptID 35 1) x?) 20)
					ignoreActors: 1
					setMotion: MoveTo 127 165 self
				)
				(kreeshaTop setCycle: End)
			)
			(8
				((ScriptID 35 1) setLoop: 5 stopUpd:)
				(= seconds 2)
			)
			(9
				(kreeshaTop setCycle: Beg self)
			)
			(10
				(kreeshaTop stopUpd:)
				(portal dispose:)
				(globalSound stop:)
				(= cycles 2)
			)
			(11
				(messager say: 3 6 12 0 self)
			)
			(12
				(messager say: 3 6 8 0 self)
			)
			(13
				((ScriptID 34 1)
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 5
					moveSpeed: 5
					setMotion: MoveTo -7 ((ScriptID 34 1) y?) self
				)
			)
			(14
				((ScriptID 34 1) dispose:)
				(if (== heroType 3)
					(messager say: 3 6 34 0 self)
				else
					(messager say: 3 6 14 0 self)
				)
			)
			(15
				(if [egoStats 18]
					(messager say: 2 6 15 0 self)
				else
					(self cue:)
				)
			)
			(16
				(HandsOn)
				(portal dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bePolite of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(messager say: 2 6 42 0 self)
			)
			(1
				(ego setMotion: MoveTo 265 138 self)
			)
			(2 (HandsOn) (self dispose:))
		)
	)
)

(instance egoExits of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond 
					((== kreeshaHomeState 2) (messager say: 2 6 79 0 self))
					((== kreeshaHomeState 0) (messager say: 3 6 10 0 self) (++ kreeshaHomeState))
					(else (self cue:))
				)
			)
			(1 (curRoom newRoom: 270))
		)
	)
)

(instance pow of Actor
	(properties
		view 21
		loop 2
		signal $4000
	)
)

(instance kreesha of Actor
	(properties
		x 246
		y 186
		noun 2
		yStep 4
		view 282
		cycleSpeed 2
		xStep 5
	)
	
	(method (doVerb theVerb)
		(kreeshaTell doVerb: theVerb)
	)
)

(instance kreeshaTop of Prop
	(properties
		x 71
		y 142
		noun 2
		view 282
		loop 3
		signal $4000
	)
)

(instance portal of Prop
	(properties
		x 285
		y 117
		view 280
		signal $4000
	)
)

(instance stick of Actor
	(properties
		x 155
		y 141
		view 790
		loop 1
		signal $4000
	)
)

(instance thatOldGlow of Prop
	(properties
		x 157
		y 163
		view 283
		loop 1
		signal $4000
	)
)

(instance pentaGlow of Prop
	(properties
		x 157
		y 163
		view 283
		signal $4000
	)
)

(instance leftCandles of Feature
	(properties
		x 12
		y 45
		noun 20
		nsTop 35
		nsLeft 2
		nsBottom 55
		nsRight 22
		sightAngle 180
	)
)

(instance rightCandles of Feature
	(properties
		x 293
		y 46
		noun 20
		nsTop 37
		nsLeft 284
		nsBottom 55
		nsRight 303
		sightAngle 180
	)
)

(instance hornSkull of Feature
	(properties
		x 157
		y 17
		noun 7
		nsTop 5
		nsLeft 146
		nsBottom 30
		nsRight 168
		sightAngle 180
	)
)

(instance pentagram of Feature
	(properties
		x 157
		y 145
		noun 8
		nsTop 125
		nsLeft 92
		nsBottom 165
		nsRight 222
		sightAngle 180
	)
)

(instance leftPitcher of Feature
	(properties
		x 39
		y 73
		noun 9
		nsTop 56
		nsLeft 33
		nsBottom 90
		nsRight 46
		sightAngle 180
	)
)

(instance stool of Feature
	(properties
		x 61
		y 94
		noun 23
		nsTop 81
		nsLeft 45
		nsBottom 108
		nsRight 78
		sightAngle 180
	)
)

(instance books of Feature
	(properties
		x 200
		y 39
		noun 11
		nsTop 29
		nsLeft 175
		nsBottom 49
		nsRight 226
		sightAngle 180
	)
)

(instance moreCandles of Feature
	(properties
		x 228
		y 62
		noun 12
		nsTop 49
		nsLeft 220
		nsBottom 75
		nsRight 236
		sightAngle 180
	)
)

(instance cretianUrn of Feature
	(properties
		x 135
		y 44
		noun 13
		nsTop 33
		nsLeft 122
		nsBottom 55
		nsRight 148
		sightAngle 180
	)
)

(instance boxes of Feature
	(properties
		x 92
		y 73
		noun 14
		nsTop 65
		nsLeft 79
		nsBottom 82
		nsRight 106
		sightAngle 180
	)
)

(instance skulls of Feature
	(properties
		x 207
		y 12
		noun 15
		nsTop 8
		nsLeft 179
		nsBottom 17
		nsRight 236
		sightAngle 180
	)
)

(instance bottles of Feature
	(properties
		x 103
		y 15
		noun 16
		nsTop 5
		nsLeft 65
		nsBottom 25
		nsRight 141
		sightAngle 180
	)
)

(instance shelf of Feature
	(properties
		x 83
		y 34
		noun 17
		nsTop 26
		nsLeft 66
		nsBottom 43
		nsRight 100
		sightAngle 180
	)
)

(instance otherBottles of Feature
	(properties
		x 190
		y 64
		noun 18
		nsTop 56
		nsLeft 178
		nsBottom 73
		nsRight 203
		sightAngle 180
	)
)

(instance plant of Feature
	(properties
		x 191
		y 78
		noun 19
		nsTop 74
		nsLeft 178
		nsBottom 82
		nsRight 204
		sightAngle 180
	)
)

(instance moreBooks of Feature
	(properties
		x 213
		y 65
		noun 21
		nsTop 56
		nsLeft 207
		nsBottom 74
		nsRight 219
		sightAngle 180
	)
)

(instance vases of Feature
	(properties
		x 140
		y 65
		noun 22
		nsTop 55
		nsLeft 111
		nsBottom 76
		nsRight 169
		sightAngle 180
	)
)

(instance chest of Feature
	(properties
		x 297
		y 84
		noun 26
		nsTop 73
		nsLeft 289
		nsBottom 95
		nsRight 306
		sightAngle 180
	)
)

(instance pillar of Feature
	(properties
		x 255
		y 61
		noun 24
		nsTop 12
		nsLeft 242
		nsBottom 111
		nsRight 269
		sightAngle 180
	)
)

(instance urn of Feature
	(properties
		x 275
		y 73
		noun 25
		nsTop 56
		nsLeft 270
		nsBottom 91
		nsRight 281
		sightAngle 180
	)
)

(instance kreeshaTell of Teller
	(properties)
	
	(method (showDialog)
		(super
			showDialog:
				-3
				(== kreeshaHomeState 0)
				-5
				(== kreeshaHomeState 0)
				-7
				(== kreeshaHomeState 0)
				-2
				(== kreeshaHomeState 0)
				-4
				(< kreeshaHomeState 2)
				-19
				(> kreeshaHomeState 2)
				-20
				(if (== heroType 1) (> kreeshaHomeState 1) else 0)
				-21
				(> kreeshaHomeState 1)
				-22
				(> kreeshaHomeState 1)
				-37
				(== kreeshaHomeState 7)
				-39
				(== kreeshaHomeState 6)
				-38
				(== kreeshaHomeState 6)
				-40
				(== kreeshaHomeState 7)
				-6
				(if (== kreeshaHomeState 0) else (== kreeshaHomeState 7))
				-58
				(if (== kreeshaHomeState 0) (== heroType 1) else 0)
				-74
				(== kreeshaHomeState 6)
				-71
				(== kreeshaHomeState 6)
				-70
				(== kreeshaHomeState 6)
				-74
				(== kreeshaHomeState 6)
				-65
				(== kreeshaHomeState 2)
				-64
				(== kreeshaHomeState 2)
		)
	)
	
	(method (doChild)
		(return
			(switch query
				(-69 (Bset 133) (return query))
				(-4 (super doChild: query))
				(-7 (super doChild: query))
				(-5 (super doChild: query))
				(-20 (super doChild: query))
				(-71 (super doChild: query))
				(-65 (super doChild: query))
				(-66 (super doChild: query))
				(else  (return query))
			)
		)
	)
	
	(method (doVerb theVerb)
		(cond 
			(
			(or (== theVerb 81) (== theVerb 83) (== theVerb 88)) (messager say: 1 6 89))
			((== theVerb 82) (messager say: 1 6 90))
			(else (super doVerb: theVerb))
		)
	)
)

(instance egoTell of Teller
	(properties)
	
	(method (showDialog)
		(super
			showDialog:
				-36
				(== kreeshaHomeState 7)
				-19
				(== kreeshaHomeState 3)
				-11
				(== kreeshaHomeState 0)
				-75
				(== kreeshaHomeState 0)
				-76
				(if (< kreeshaHomeState 6) (> kreeshaHomeState 0) else 0)
				-77
				(== kreeshaHomeState 6)
		)
	)
	
	(method (doChild)
		(return query)
	)
)

(instance rakeeshTell of Teller
	(properties)
	
	(method (showDialog)
		(super showDialog: -55 (== heroType 3))
	)
	
	(method (doChild)
		(return
			(switch query
				(-8 (super doChild: query))
				(-3 (super doChild: query))
				(-51 (super doChild: query))
				(else  (return query))
			)
		)
	)
	
	(method (doVerb theVerb)
		(cond 
			(
			(or (== theVerb 81) (== theVerb 83) (== theVerb 88)) (messager say: 1 6 88))
			((== theVerb 82) (messager say: 1 6 90))
			(else (super doVerb: theVerb))
		)
	)
)
