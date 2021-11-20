;;; Sierra Script 1.0 - (do not remove this comment)
(script# 630)
(include sci.sh)
(use Main)
(use GloryRm)
(use EgoDead)
(use Intrface)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm630 0
)

(local
	local0
	local1
	local2
	local3
)
(instance rm630 of GloryRm
	(properties
		noun 1
		picture 630
	)
	
	(method (init)
		(if debugging
			(= local0 (GetNumber {Event #?}))
		else
			(= local0
				(cond 
					((Btst 101) 3)
					(
					(and (== prevRoomNum 627) (not (Btst 112)) Night) 1)
					((or (not Night) (Btst 112) (not (Btst 110))) 2)
					(else 0)
				)
			)
		)
		(switch prevRoomNum
			(610
				(theMusic doSongs: 630 631 632)
				(= local1 173)
				(= local2 180)
				(ego posn: 173 189)
			)
			(623
				(= local1 20)
				(= local2 157)
				(ego posn: 0 157)
			)
			(625
				(= local1 44)
				(= local2 75)
				(ego posn: 20 55)
			)
			(627
				(= local1 269)
				(= local2 140)
				(ego posn: 319 135)
			)
			(else 
				(theMusic doSongs: 630 631 632)
				(= local1 161)
				(= local2 172)
				(ego posn: 188 140)
			)
		)
		(ego init: normalize: setScript: sEnterTheRoom)
		(if (== prevRoomNum 625)
			(ego setScaler: Scaler 85 73 145 68)
		else
			(ego setScaler: Scaler 112 60 176 123)
		)
		(curRoom
			addObstacle:
				((Polygon new:)
					type: 2
					init: -300 177 43 177 24 189 -300 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						-300
						140
						-300
						0
						619
						0
						619
						164
						302
						166
						287
						154
						297
						135
						292
						132
						274
						133
						268
						125
						254
						125
						238
						120
						133
						120
						133
						124
						235
						124
						235
						140
						126
						140
						95
						151
						53
						151
						88
						96
						28
						63
						25
						67
						82
						98
						42
						152
						-300
						152
					yourself:
				)
		)
		(pCandles
			ignoreActors: 1
			cycleSpeed: 10
			setCycle: Fwd
			init:
		)
		(pFireplace
			ignoreActors: 1
			cycleSpeed: 10
			setCycle: Fwd
			init:
		)
		(pChair
			ignoreActors: 1
			cycleSpeed: 10
			setCycle: Fwd
			init:
		)
		(pTabletop
			ignoreActors: 1
			cycleSpeed: 10
			setCycle: Fwd
			init:
		)
		(pStairDoor
			setCel: (if (== prevRoomNum 625) 4 else 0)
			init:
			approachVerbs: 4 32
		)
		(pRightDoor
			setCel: (if (and (Btst 112) (== prevRoomNum 627)) 5 else 0)
			init:
			approachVerbs: 4 32
		)
		(super init: &rest)
		(fCrest init: approachVerbs: 4)
		(fChair1 init: approachVerbs: 4)
		(fChair2 init: approachVerbs: 4)
		(fTable init: approachVerbs: 4)
		(fHearth init: approachVerbs: 4)
		(fStatue1 init: approachVerbs: 4)
		(fStatue2 init: approachVerbs: 4)
		(fStatue3 init: approachVerbs: 4)
		(fStatue4 init: approachVerbs: 4)
		(fBust init: approachVerbs: 4)
		(fCandelabra init: approachVerbs: 4)
		(fRug init: approachVerbs: 4)
		(vClosentDoor init: approachVerbs: 32)
		(fSouth init:)
		(fUp init:)
		(fDown init:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 91)
			(messager say: 17 91 0 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sLeaveWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath -10 (ego y?) self)
			)
			(1 (curRoom newRoom: 623))
		)
	)
)

(instance sCastleBreached of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (ego script?))
					(theGame handsOff:)
					(if (== prevRoomNum 610)
						(ego setMotion: MoveTo (ego x?) (+ (ego y?) 30) self)
					else
						(messager say: 16 6 1 0 self)
					)
				else
					(self dispose:)
				)
			)
			(1
				(if (== prevRoomNum 610)
					(curRoom newRoom: 600)
				else
					(ego setMotion: MoveTo (ego x?) (- (ego y?) 30) self)
				)
			)
			(2
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterTheRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= ticks 30)
			)
			(1
				(switch local0
					(1
						(pKatrina
							view: 631
							setLoop: 4 1
							setCel: 0
							posn: 106 105
							ignoreActors:
							init:
						)
						(pAdAvis
							ignoreActors:
							setScaler: Scaler 107 61 175 120
							init:
						)
						(client setScript: sListenToKatrina)
					)
					(2
						(ego setMotion: MoveTo local1 local2 self)
					)
					(3
						(pKatrina
							view: 632
							setLoop: 2 1
							setCel: 0
							posn: 160 136
							ignoreActors: 1
							init:
							setPri: 152
							cycleSpeed: 6
							setCycle: Fwd
						)
						(pAdAvis
							ignoreActors: 1
							setScaler: Scaler 107 61 175 120
							init:
						)
						(pNecrotaur ignoreActors: 1 init:)
						(pTail ignoreActors: 1 init: cycleSpeed: 10 setCycle: Fwd)
						(curRoom setScript: sAllRituals)
					)
					(else 
						(ego setMotion: MoveTo local1 local2 self)
					)
				)
			)
			(2
				(switch prevRoomNum
					(625
						(pStairDoor setCel: 4 setCycle: Beg self)
					)
					(627
						(pRightDoor setCel: 5 setCycle: Beg self)
					)
					(else 
						(theGame handsOn:)
						(self dispose:)
					)
				)
			)
			(3
				(if (OneOf prevRoomNum 627 625) (thudSound play:))
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sListenToKatrina of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= seconds 2)
			)
			(1
				(Bset 112)
				(if (not (Btst 114)) (squeakSound play:))
				(pRightDoor setCycle: CT 3 1 self)
			)
			(2
				(if (not (Btst 113))
					(ego
						view: 4
						setLoop: 3 1
						setCel: 4
						posn: 307 135
						setPri: 108
						setCycle: 0
					)
				)
				(cond 
					((Btst 114) (self cue:))
					((Btst 113) (client setScript: sHallDeath))
					(else (client setScript: sSqueakDeath))
				)
			)
			(3
				(pKatrina
					setLoop: 5 1
					setCel: 0
					posn: 104 108
					setCycle: End self
				)
			)
			(4
				(messager say: 18 6 4 0 self)
			)
			(5
				(ego hide:)
				(pRightDoor setPri: 150 setCycle: CT 0 -1 self)
			)
			(6 (= seconds 2))
			(7 (curRoom newRoom: 627))
		)
	)
)

(instance sSqueakDeath of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= seconds 2)
			)
			(1
				(pKatrina setLoop: 6 1 setCel: 0 setCycle: End self)
			)
			(2
				(spellSound play:)
				(aZap
					view: 21
					setLoop: 2 1
					setCel: 0
					setCycle: Fwd
					init:
					setStep: 10 10
					moveSpeed: 0
					setMotion: MoveTo 289 125 self
				)
			)
			(3
				(aZap setLoop: 9 1 setCel: 0 setCycle: End self)
				(spellSound stop:)
				(pRightDoor setCycle: CT 4 1)
			)
			(4
				(aZap hide: dispose:)
				(pKatrina setCel: 0 setCycle: 0)
				(thudSound play:)
				(ego
					view: 43
					setLoop: 1 1
					setCel: 5
					posn: 290 136
					setCycle: End self
				)
			)
			(5
				(thudSound stop:)
				(spellSound play:)
				(pAdAvis setCycle: CT 5 1 self)
			)
			(6
				(aZap
					view: 21
					setLoop: 2 1
					setCel: 0
					posn: 161 94
					ignoreActors: 1
					setStep: 10 10
					setPri: 207
					init:
					setCycle: Fwd
					moveSpeed: 0
					setMotion: MoveTo 273 132 self
				)
			)
			(7
				(spellSound stop:)
				(pAdAvis setCel: 5 setCycle: End self)
				(aZap setLoop: 9 1 setCel: 0 setCycle: End self)
			)
			(8 0)
			(9
				(pAdAvis setPri: 97)
				(messager say: 16 6 2 0 self)
			)
			(10 (EgoDead 2 630 970 1))
		)
	)
)

(instance sHallDeath of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(pRightDoor setCycle: End self)
			)
			(1
				(ego setMotion: MoveTo local1 local2 self)
			)
			(2
				(messager say: 16 6 3 0 self)
			)
			(3
				(pAdAvis setCycle: CT 5 1 self)
			)
			(4
				(spellSound play:)
				(aZap
					view: 21
					setLoop: 2 1
					setCel: 0
					posn: 161 94
					setStep: 10 10
					ignoreActors: 1
					setPri: 207
					init:
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 265 108 self
				)
			)
			(5
				(spellSound stop:)
				(pAdAvis setCel: 5 setCycle: End self)
				(aZap setLoop: 9 1 setCel: 0 setCycle: End self)
			)
			(6 0)
			(7
				(pAdAvis setPri: 97)
				(aZap dispose:)
				(= ticks 10)
			)
			(8 (EgoDead 3 630 970 1))
		)
	)
)

(instance sAllRituals of Script
	(properties)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if (== state 8)
			(if (= register (- register 10))
				(Palette palSET_FLAG 0 255 register)
			else
				(Palette palSET_FLAG 0 255 0)
				(FrameOut)
				(self cue:)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				((ScriptID 7 4) init: 19 15)
				(ego normalize: 3)
				(= seconds 3)
			)
			(1
				(messager say: 18 6 5 0 self)
			)
			(2
				(ego
					setMotion: MoveTo (+ (ego x?) 30) (- (ego y?) 40) self
				)
			)
			(3 (ego setHeading: 315 self))
			(4
				(= cycles (+ (ego cycleSpeed?) 1))
			)
			(5
				(messager say: 18 6 6 0 self)
			)
			(6
				(pKatrina setLoop: 3 1 setCel: 0 setCycle: End self)
			)
			(7
				(pKatrina
					view: 633
					setLoop: 2 1
					setCel: 0
					setCycle: End self
				)
			)
			(8
				(= register 100)
				(= geasDay 0)
				(cast eachElementDo: #hide)
				(theMusic doSongs: fade:)
			)
			(9 (curRoom newRoom: 790))
		)
	)
)

(instance sLeave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(doorSound play:)
				(if local3
					(pRightDoor setCycle: End self)
					(if (not (Btst 114)) (squeakSound play:))
					(= local3 0)
				else
					(if (not (Btst 207)) (squeakSound play:))
					(pStairDoor setCycle: End self)
				)
			)
			(1
				(if (> (ego x?) 100)
					(ego
						setMotion: MoveTo (+ (ego x?) 40) (- (ego y?) 10) self
					)
				else
					(ego setMotion: MoveTo (- (ego x?) 10) (ego y?) self)
				)
			)
			(2
				(if (> (ego x?) 100)
					(curRoom newRoom: 627)
				else
					(curRoom newRoom: 625)
				)
			)
		)
	)
)

(instance sCastOpenDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(doorSound play:)
				(ego trySkill: 20)
				(if local3
					(pRightDoor setCycle: End self)
					(if (not (Btst 114)) (squeakSound play:))
				else
					(if (not (Btst 207)) (squeakSound play:))
					(pStairDoor setCycle: End self)
				)
			)
			(1
				(if local3
					(ego
						setMotion: PolyPath (pRightDoor approachX?) (pRightDoor approachY?) self
					)
				else
					(ego setMotion: PolyPath 54 146 self)
				)
			)
			(2
				(if local3
					(self cue:)
				else
					(ego
						setScaler: Scaler 85 73 145 68
						setMotion: PolyPath (pStairDoor approachX?) (pStairDoor approachY?) self
					)
				)
			)
			(3
				(if local3
					(curRoom newRoom: 627)
				else
					(curRoom newRoom: 625)
				)
			)
		)
	)
)

(instance sChangeUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setScaler: Scaler 85 73 145 68)
				(self cue:)
			)
			(1 (self dispose:))
		)
	)
)

(instance sChangeDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setScaler: Scaler 112 60 176 123)
				(self cue:)
			)
			(1 (self dispose:))
		)
	)
)

(instance aZap of Actor
	(properties
		x 191
		y 92
		view 21
	)
)

(instance pCandles of Prop
	(properties
		noun 12
		sightAngle 180
		approachX 92
		approachY 87
		x 93
		y 43
		view 631
		detailLevel 2
	)
)

(instance pFireplace of Prop
	(properties
		noun 6
		sightAngle 180
		approachX 231
		approachY 129
		x 162
		y 71
		view 631
		loop 1
		detailLevel 2
	)
)

(instance pChair of Prop
	(properties
		noun 3
		sightAngle 180
		approachX 148
		approachY 139
		x 137
		y 101
		priority 138
		fixPriority 1
		view 631
		loop 2
		cel 1
		signal $0001
		detailLevel 2
	)
)

(instance pTabletop of Prop
	(properties
		noun 5
		sightAngle 180
		approachX 148
		approachY 139
		x 159
		y 118
		priority 138
		fixPriority 1
		view 631
		loop 3
		cel 1
		signal $0001
		detailLevel 2
	)
)

(instance pKatrina of Prop
	(properties
		x 167
		y 137
		priority 130
		fixPriority 1
		view 635
		loop 1
		signal $4001
	)
)

(instance pKEyes of Prop
	(properties
		x 160
		y 88
		priority 207
		fixPriority 1
		view 635
		loop 2
		signal $4001
	)
)

(instance pAdAvis of Prop
	(properties
		x 129
		y 137
		priority 207
		fixPriority 1
		view 677
		cel 1
	)
)

(instance pNecrotaur of Prop
	(properties
		x 133
		y 120
		priority 163
		fixPriority 1
		view 632
		scaleSignal $0001
	)
	
	(method (init)
		(super init: &rest)
		(self setScaler: Scaler 81 56 130 112)
	)
)

(instance pTail of Prop
	(properties
		x 139
		y 139
		priority 163
		fixPriority 1
		view 632
		loop 1
		cel 4
		detailLevel 2
	)
)

(instance pStairDoor of Prop
	(properties
		noun 13
		sightAngle 180
		approachX 50
		approachY 71
		x 19
		y 20
		view 630
		loop 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (curRoom setScript: sLeave))
			(-80
				(= local3 0)
				(curRoom setScript: sCastOpenDoor)
			)
			(80
				(= projX ((User curEvent?) x?))
				(= projY ((User curEvent?) y?))
				(curRoom setScript: (ScriptID 13) 0 self)
			)
			(32
				(Bset 207)
				(super doVerb: theVerb)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance pRightDoor of Prop
	(properties
		noun 14
		sightAngle 180
		approachX 281
		approachY 140
		x 284
		y 60
		view 630
		loop 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(= local3 1)
				(curRoom setScript: sLeave)
			)
			(32
				(Bset 114)
				(ego solvePuzzle: 517 2 4)
				(super doVerb: theVerb)
			)
			(-80
				(= local3 1)
				(curRoom setScript: sCastOpenDoor)
			)
			(80
				(= projX ((User curEvent?) x?))
				(= projY ((User curEvent?) y?))
				(curRoom setScript: (ScriptID 13) 0 self)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance vClosentDoor of View
	(properties
		noun 19
		approachX 128
		approachY 129
		x 123
		y 75
		view 630
	)
	
	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:)
				init:
					((Polygon new:)
						type: 1
						init: 0 136 18 136 18 180 0 180
						yourself:
					)
					1
					7
					5
					sLeaveWest
				yourself:
			)
		)
	)
	
	(method (dispose)
		(if heading (heading dispose:))
		(super dispose: &rest)
	)
)

(instance fSouth of Feature
	(properties
		nsLeft 129
		nsTop 56
		nsRight 211
		nsBottom 75
		sightAngle 180
		approachX 165
		approachY 109
		x 170
		y 65
	)
	
	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:)
				init:
					((Polygon new:)
						type: 1
						init: 319 180 319 189 0 189 0 180
						yourself:
					)
					2
					4
					5
					sCastleBreached
				yourself:
			)
		)
	)
	
	(method (dispose)
		(if heading (heading dispose:))
		(super dispose: &rest)
	)
)

(instance fUp of Feature
	(properties
		nsLeft 30
		nsTop 142
		nsRight 77
		nsBottom 145
		sightAngle 180
		x 30
		y 145
	)
	
	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:)
				init:
					((Polygon new:)
						type: 1
						init: 30 142 78 142 78 146 30 146
						yourself:
					)
					3
					6
					7
					sChangeUp
				yourself:
			)
		)
	)
	
	(method (dispose)
		(if heading (heading dispose:))
		(super dispose: &rest)
	)
)

(instance fDown of Feature
	(properties
		nsLeft 30
		nsTop 140
		nsRight 77
		nsBottom 142
		sightAngle 180
		x 30
		y 140
	)
	
	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:)
				init:
					((Polygon new:)
						type: 1
						init: 30 142 78 142 78 146 30 146
						yourself:
					)
					2
					4
					5
					sChangeDown
				yourself:
			)
		)
	)
	
	(method (dispose)
		(if heading (heading dispose:))
		(super dispose: &rest)
	)
)

(instance fCrest of Feature
	(properties
		noun 2
		nsLeft 185
		nsTop 11
		nsRight 213
		nsBottom 40
		sightAngle 180
		approachX 231
		approachY 139
		x 199
		y 25
	)
)

(instance fChair1 of Feature
	(properties
		noun 3
		nsLeft 136
		nsTop 101
		nsRight 156
		nsBottom 131
		sightAngle 180
		approachX 148
		approachY 139
		x 146
		y 116
	)
)

(instance fChair2 of Feature
	(properties
		noun 4
		nsLeft 197
		nsTop 101
		nsRight 215
		nsBottom 132
		sightAngle 180
		approachX 213
		approachY 139
		x 206
		y 116
	)
)

(instance fTable of Feature
	(properties
		noun 5
		nsLeft 156
		nsTop 117
		nsRight 197
		nsBottom 133
		sightAngle 180
		approachX 148
		approachY 139
		x 176
		y 125
	)
)

(instance fHearth of Feature
	(properties
		noun 6
		nsLeft 163
		nsTop 71
		nsRight 241
		nsBottom 118
		sightAngle 180
		approachX 231
		approachY 129
		x 202
		y 94
	)
)

(instance fStatue1 of Feature
	(properties
		noun 7
		nsLeft 18
		nsTop 76
		nsRight 32
		nsBottom 115
		sightAngle 180
		approachX 31
		approachY 152
		x 25
		y 95
	)
)

(instance fStatue2 of Feature
	(properties
		noun 8
		nsLeft 73
		nsTop 75
		nsRight 88
		nsBottom 114
		sightAngle 180
		approachX 87
		approachY 154
		x 80
		y 94
	)
)

(instance fStatue3 of Feature
	(properties
		noun 9
		nsLeft 254
		nsTop 85
		nsRight 266
		nsBottom 110
		sightAngle 180
		approachX 264
		approachY 130
		x 260
		y 97
	)
)

(instance fStatue4 of Feature
	(properties
		noun 10
		nsLeft 303
		nsTop 83
		nsRight 319
		nsBottom 142
		sightAngle 180
		approachX 300
		approachY 165
		x 311
		y 112
	)
)

(instance fBust of Feature
	(properties
		noun 11
		nsLeft 104
		nsTop 100
		nsRight 115
		nsBottom 120
		sightAngle 180
		approachX 120
		approachY 140
		x 109
		y 110
	)
)

(instance fCandelabra of Feature
	(properties
		noun 12
		nsLeft 92
		nsTop 43
		nsRight 108
		nsBottom 77
		sightAngle 180
		approachX 92
		approachY 87
		x 100
		y 60
	)
)

(instance fRug of Feature
	(properties
		noun 15
		nsLeft 47
		nsTop 127
		nsRight 319
		nsBottom 176
		sightAngle 180
		approachX 173
		approachY 189
		x 183
		y 151
	)
	
	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: 0
					init: 48 175 138 129 242 127 319 175
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance doorSound of Sound
	(properties
		number 972
	)
)

(instance squeakSound of Sound
	(properties
		number 143
	)
)

(instance spellSound of Sound
	(properties
		number 934
	)
)

(instance thudSound of Sound
	(properties
		number 986
	)
)
