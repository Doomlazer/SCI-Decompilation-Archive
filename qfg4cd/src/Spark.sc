;;; Sierra Script 1.0 - (do not remove this comment)
(script# 760)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use EgoDead)
(use Array)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm760 0
)

(local
	local0
	local1
	gTheObj_2CycleSpeed
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10 =  1000
	theSpark
	local12 =  1
	local13
	local14
	local15
)
(instance rm760 of GloryRm
	(properties
		picture 760
	)
	
	(method (init)
		(ego
			init:
			x: 251
			y: 169
			code: heightenSenses
			normalize:
			setScaler: Scaler 60 37 189 100
		)
		(= local3 (IDArray new: 13))
		(= local4
			(IntArray
				with: 165 96 14 30 15 26 48 12 185 182 230 278 313 281
			)
		)
		(= local5
			(IntArray
				with: 53 50 33 17 127 127 147 172 138 167 170 96 72 82
			)
		)
		(= local6
			(IntArray with: 154 78 22 0 16 25 61 0 0 215 174 0 0 254)
		)
		(= local7
			(IntArray with: 49 48 62 0 107 119 183 0 0 179 187 0 0 78)
		)
		(= local8
			(IntArray with: 187 109 51 0 25 52 63 0 0 250 215 0 0 254)
		)
		(= local9
			(IntArray with: 44 51 48 0 119 119 163 0 0 177 179 0 0 78)
		)
		(keyDownHandler addToFront: self)
		(mouseDownHandler addToFront: self)
		(RemapColors 2 254 60)
		(Palette palSET_FLAG 112 235 0)
		(Palette palSET_FLAG 66 85 60)
		(tracer init: hide:)
		(exitF init:)
		(caveExit init:)
		(altar init:)
		(stirrup init:)
		(eye init:)
		(anvil init:)
		(senseOrgan init:)
		(senseOrgan2 init:)
		(dendrites1 init:)
		(dendrite2 init:)
		(dendrite3 init:)
		(dendrite4 init:)
		(dendrite5 init:)
		(dendrite6 init:)
		(dendrite7 init:)
		(dendrite8 init:)
		(dendrite9 init:)
		(dendriteStem init:)
		(earPart init:)
		(leftNostril init:)
		(rightNostril init:)
		(altarPlatform init:)
		(nosePlatform init:)
		(noseTop init:)
		(curRoom
			addObstacle:
				((Polygon new:)
					type: 3
					init: 257 164 195 181 167 185 167 189 211 189 259 175 294 127
					yourself:
				)
		)
		(super init: &rest)
		(self setScript: sEnter)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script)
			(
				(ego
					inRect:
						(exitF nsLeft?)
						(exitF nsTop?)
						(exitF nsRight?)
						(exitF nsBottom?)
				)
				(exitF doVerb: 4)
			)
		)
	)
	
	(method (dispose)
		(keyDownHandler delete: self)
		(mouseDownHandler delete: self)
		(local4 dispose:)
		(local5 dispose:)
		(local6 dispose:)
		(local7 dispose:)
		(local8 dispose:)
		(local9 dispose:)
		(local3 dispose:)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		(if
			(and
				(<= global471 3)
				(or
					(and
						(& (event type?) evKEYBOARD)
						(& (event message?) KEY_RETURN)
					)
					(and
						(OneOf (event type?) 1 32)
						(not (& (event modifiers?) emSHIFT))
					)
				)
			)
			(switch ((theIconBar curIcon?) message?)
				(1
					(DailyMsg 15 6 13)
					(event claimed: 1)
					(return)
				)
				(4
					(cond 
						((== global471 0) (messager say: 15 6 7) (event claimed: 1) (return))
						(
							(and
								(= temp0 (features firstTrue: #perform findNoun event))
								(> (ego distanceTo: temp0) 50)
							)
							(switch global471
								(2
									(messager say: (temp0 noun?) 4 14)
								)
								(3
									(messager say: (temp0 noun?) 4 15)
								)
								(else  (messager say: 15 6 9))
							)
							(event claimed: 1)
							(return)
						)
						(else (super handleEvent: event &rest))
					)
				)
				(else 
					(super handleEvent: event &rest)
				)
			)
		)
	)
)

(instance heightenSenses of Code
	(properties)
	
	(method (doit)
		(switch global471
			(0
				(if (< (ego x?) 208) (curRoom setScript: sFeel))
			)
			(1
				(if (< (ego x?) 28) (curRoom setScript: sSmell))
			)
			(2
				(if (and (> (ego x?) 134) (< (ego y?) 70))
					(curRoom setScript: sHear)
				)
			)
			(3
				(if (and (> (ego x?) 231) (< (ego y?) 70))
					(++ global471)
					(tracer setScript: sLighten)
				)
			)
		)
	)
)

(instance exitF of Feature
	(properties
		noun 1
		nsLeft 240
		nsTop 132
		nsRight 284
		nsBottom 166
		sightAngle 40
		approachX 251
		approachY 169
		x 262
		y 149
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (curRoom setScript: sExit))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance sLighten of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(caveExit approachVerbs: 4)
				(altar approachVerbs: 4)
				(stirrup approachVerbs: 4 approachVerbs: 33)
				(eye approachVerbs: 4)
				(anvil approachVerbs: 4)
				(senseOrgan approachVerbs: 4)
				(senseOrgan2 approachVerbs: 4)
				(dendrites1 approachVerbs: 4)
				(dendrite2 approachVerbs: 4 approachVerbs: 33)
				(dendrite3 approachVerbs: 4)
				(dendrite4 approachVerbs: 4)
				(dendrite5 approachVerbs: 4)
				(dendrite6 approachVerbs: 4)
				(dendrite7 approachVerbs: 4)
				(dendrite8 approachVerbs: 4)
				(dendrite9 approachVerbs: 4)
				(dendriteStem approachVerbs: 4)
				(earPart approachVerbs: 4)
				(leftNostril approachVerbs: 4)
				(rightNostril approachVerbs: 4)
				(altarPlatform approachVerbs: 4)
				(nosePlatform approachVerbs: 4)
				(noseTop approachVerbs: 4)
				(Palette palSET_FLAG 112 235 60)
				(Palette palSET_FLAG 66 85 70)
				(= cycles 10)
			)
			(1
				(messager say: 15 6 17 0 self)
			)
			(2
				(= local0 60)
				(while (> local0 50)
					(Palette palSET_FLAG 112 235 local0)
					(Palette palSET_FLAG 66 85 (+ local0 10))
					(FrameOut)
					(= local0 (- local0 2))
				)
				(= cycles 1)
			)
			(3
				(= local0 50)
				(while (< local0 70)
					(Palette palSET_FLAG 112 235 local0)
					(Palette palSET_FLAG 66 85 (+ local0 10))
					(FrameOut)
					(= local0 (+ local0 5))
				)
				(= cycles 1)
			)
			(4
				(RemapColors 2 253 200)
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(= cycles 2)
			)
			(5
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 3
							init:
								259
								164
								195
								181
								76
								185
								53
								172
								77
								163
								136
								154
								138
								144
								114
								136
								145
								106
								124
								90
								137
								83
								91
								83
								117
								89
								142
								106
								112
								134
								89
								128
								103
								121
								103
								114
								47
								114
								38
								118
								14
								118
								14
								114
								29
								106
								29
								94
								5
								79
								38
								54
								98
								54
								169
								54
								169
								45
								222
								45
								242
								49
								235
								57
								189
								63
								239
								72
								211
								82
								300
								82
								300
								72
								251
								72
								246
								59
								275
								51
								231
								42
								160
								42
								144
								49
								41
								45
								0
								72
								0
								95
								19
								95
								19
								104
								4
								110
								4
								125
								49
								126
								49
								118
								100
								119
								76
								130
								121
								144
								125
								151
								39
								164
								49
								189
								197
								189
								203
								183
								270
								170
								265
								146
								260
								148
							yourself:
						)
				)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(if (Btst 459)
					(ego setMotion: PolyPath 262 165 self)
				else
					(self changeState: 2)
				)
			)
			(1
				(Palette palSET_FLAG 0 255 100)
				(ego solvePuzzle: 460 15)
				(curRoom newRoom: 720)
			)
			(2
				(ego setMotion: 0)
				(messager say: 15 6 4 0 self)
			)
			(3
				(ego setMotion: PolyPath 246 174 self)
			)
			(4
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath 251 169 self)
			)
			(1
				(messager say: 15 6 5 0 self)
			)
			(2
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFeel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(++ global471)
				(messager say: 15 6 8 0 self)
			)
			(1
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(= cycles 2)
			)
			(2
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 3
							init:
								228
								170
								195
								181
								76
								185
								53
								172
								77
								163
								136
								154
								138
								144
								111
								135
								144
								106
								124
								90
								137
								83
								91
								83
								118
								87
								130
								106
								102
								132
								95
								130
								107
								112
								14
								118
								14
								114
								29
								106
								29
								95
								19
								95
								19
								104
								4
								110
								4
								125
								49
								126
								61
								118
								96
								118
								71
								130
								131
								148
								39
								164
								49
								189
								211
								189
								228
								180
							yourself:
						)
				)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSmell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(++ global471)
				(messager say: 15 6 14 0 self)
			)
			(1
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(= cycles 2)
			)
			(2
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 3
							init:
								14
								118
								14
								114
								29
								106
								29
								94
								5
								79
								44
								51
								146
								51
								146
								49
								38
								49
								0
								72
								4
								95
								19
								95
								19
								104
								4
								110
								4
								125
								49
								126
								49
								121
							yourself:
						)
				)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHear of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(++ global471)
				(messager say: 15 6 16 0 self)
			)
			(1
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(= cycles 2)
			)
			(2
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 3
							init: 70 51 167 51 174 44 225 44 255 56 255 52 228 42 173 42 166 49 70 49
							yourself:
						)
				)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSenseRitual of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(theGame handsOff:)
				(ego drop: 55 1 solvePuzzle: 459 6)
				(messager say: 2 72 0 0 self)
			)
			(1
				1
				(= local0 0)
				(while (<= local0 13)
					(local3
						at:
							local0
							((Spark new:)
								init:
								view: 760
								loop: (if (>= local0 1) (+ local0 1) else local0)
								x: (local4 at: local0)
								y: (local5 at: local0)
								hide:
								leftX: (local6 at: local0)
								leftY: (local7 at: local0)
								rightX: (local8 at: local0)
								rightY: (local9 at: local0)
								yourself:
							)
					)
					(++ local0)
				)
				(= cycles 2)
			)
			(2
				2
				(theGame handsOn:)
				(= cycles 1)
			)
			(3
				3
				(= local12 0)
				(= local0 0)
				(while (<= local0 2)
					(if
						(and
							(not ((local3 at: (= local1 (Random 0 13))) cycler?))
							(!= (local3 at: local1) theSpark)
							((local3 at: local1) enabled?)
						)
						((local3 at: local1)
							show:
							setCycle: End (local3 at: local1)
						)
					)
					(++ local0)
				)
				(if (and theSpark (theSpark enabled?))
					(= local10 1000)
					(theSpark show: setCycle: End theSpark)
				else
					(= cycles 1)
				)
			)
			(4
				(if (== local14 4)
					(= local14 0)
					(= local15 1)
				else
					(= local15 0)
					(++ local14)
				)
				(= local12 1)
				(= state 2)
				(= seconds (Random 1 3))
			)
		)
	)
)

(instance sShockEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego view: 762 setCel: 0 setCycle: 0 setMotion: 0)
				(theMusic2 number: 371 loop: 1 play:)
				(if (OneOf (ego loop?) 3 6 0 4)
					(ego
						setLoop: 0 1
						setCycle: Fwd
						setMotion: MoveTo (client rightX?) (client rightY?) self
					)
				else
					(ego
						setLoop: 1 1
						setCycle: Fwd
						setMotion: MoveTo (client leftX?) (client leftY?) self
					)
				)
			)
			(1 (ego setCycle: End self))
			(2
				(cond 
					(
						(OneOf
							client
							(local3 at: 8)
							(local3 at: 9)
							(local3 at: 10)
						)
						(cond 
							(resistTimer
								(if (ego takeDamage: 25)
									(= cycles 1)
								else
									(EgoDead 20 0 961 1 912)
								)
							)
							((ego takeDamage: 100) (= cycles 1))
							(else (EgoDead 20 0 961 1 912))
						)
					)
					(resistTimer
						(if (ego takeDamage: 12)
							(= cycles 1)
						else
							(EgoDead 20 0 961 1 912)
						)
					)
					((ego takeDamage: 50) (= cycles 1))
					(else (EgoDead 20 0 961 1 912))
				)
			)
			(3
				(ego normalize: 2)
				(= cycles 1)
			)
			(4
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSwingOnStirrup of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= local13 1)
				(= gTheObj_2CycleSpeed (ego cycleSpeed?))
				(ego
					view: 761
					loop: 0
					cel: 0
					x: 130
					y: 83
					cycleSpeed: 9
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(ego
					x: 127
					setScaler: Scaler 60 37 189 100
					cycleSpeed: gTheObj_2CycleSpeed
					normalize: 1
				)
				(= local13 0)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSwingOnDendrite of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= local13 1)
				(= gTheObj_2CycleSpeed (ego cycleSpeed?))
				(ego
					view: 761
					loop: 1
					cel: 0
					x: 236
					y: 173
					cycleSpeed: 9
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(ego
					x: 238
					setScaler: Scaler 60 37 189 100
					cycleSpeed: gTheObj_2CycleSpeed
					normalize: 0
				)
				(= local13 0)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tracer of Prop
	(properties
		view 762
		loop 6
		signal $4001
		cycleSpeed 12
	)
)

(instance caveExit of Feature
	(properties
		noun 1
		nsLeft 249
		nsTop 138
		nsRight 275
		nsBottom 166
		sightAngle 180
		x 262
		y 152
	)
)

(instance altar of Feature
	(properties
		noun 2
		nsLeft 239
		nsTop 12
		nsRight 319
		nsBottom 62
		sightAngle 180
		x 279
		y 37
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(72
				(ego setScript: sSenseRitual)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stirrup of Feature
	(properties
		noun 3
		nsLeft 167
		nsTop 2
		nsRight 213
		nsBottom 27
		sightAngle 180
		approachX 210
		approachY 80
		x 190
		y 14
	)
	
	(method (handleEvent event)
		(if (InRect 183 0 319 98 ego)
			(self approachVerbs: 33)
		else
			(self approachVerbs: 0)
		)
		(super handleEvent: event &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(33
				(if (InRect 183 0 319 98 ego)
					(curRoom setScript: sSwingOnStirrup)
				else
					(messager say: 15 6 24)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance eye of Feature
	(properties
		noun 4
		nsLeft 203
		nsTop -1
		nsRight 253
		nsBottom 33
		sightAngle 180
		x 228
		y 16
	)
)

(instance anvil of Feature
	(properties
		noun 5
		nsLeft 136
		nsTop 5
		nsRight 163
		nsBottom 27
		sightAngle 180
		x 149
		y 16
	)
)

(instance senseOrgan of TargFeature
	(properties
		noun 6
		nsLeft 161
		nsTop 130
		nsRight 227
		nsBottom 153
		sightAngle 180
		x 194
		y 141
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(93
				(if (Btst 459)
					(curRoom setScript: (ScriptID 32) 0 93)
				else
					(messager say: 15 6 23)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (getHurt)
		(= local14 0)
		((local3 at: 8) enabled: 0)
		((local3 at: 9) enabled: 0)
		((local3 at: 10) enabled: 0)
	)
)

(instance senseOrgan2 of TargFeature
	(properties
		noun 6
		nsLeft 163
		nsTop 163
		nsRight 243
		nsBottom 186
		sightAngle 180
		x 227
		y 174
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(93
				(if (Btst 459)
					(curRoom setScript: (ScriptID 32) 0 93)
				else
					(messager say: 15 6 23)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (getHurt)
		(= local14 0)
		((local3 at: 8) enabled: 0)
		((local3 at: 9) enabled: 0)
		((local3 at: 10) enabled: 0)
	)
)

(instance dendrites1 of TargFeature
	(properties
		noun 7
		nsTop 123
		nsRight 60
		nsBottom 189
		sightAngle 180
		x 30
		y 156
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(93
				(if (Btst 459)
					(curRoom setScript: (ScriptID 32) 0 93)
				else
					(messager say: 15 6 23)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (getHurt)
		(= local14 0)
		((local3 at: 5) enabled: 0)
		((local3 at: 6) enabled: 0)
		((local3 at: 7) enabled: 0)
	)
)

(instance dendrite2 of Feature
	(properties
		noun 7
		nsLeft 178
		nsTop 76
		nsRight 207
		nsBottom 98
		sightAngle 180
		approachX 147
		approachY 149
		x 192
		y 87
	)
	
	(method (handleEvent event)
		(if (InRect 72 76 163 163 ego)
			(self approachVerbs: 33)
		else
			(self approachVerbs: 0)
		)
		(super handleEvent: event &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(33
				(if (InRect 72 76 163 163 ego)
					(curRoom setScript: sSwingOnDendrite)
				else
					(messager say: 15 6 24)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dendrite3 of TargFeature
	(properties
		noun 7
		nsLeft 232
		nsTop 89
		nsRight 256
		nsBottom 107
		sightAngle 180
		x 244
		y 98
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(93
				(if (Btst 459)
					(curRoom setScript: (ScriptID 32) 0 93)
				else
					(messager say: 15 6 23)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (getHurt)
		(= local14 0)
		((local3 at: 11) enabled: 0)
	)
)

(instance dendrite4 of TargFeature
	(properties
		noun 7
		nsLeft 278
		nsTop 67
		nsRight 319
		nsBottom 100
		sightAngle 180
		x 298
		y 83
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(93
				(if (Btst 459)
					(curRoom setScript: (ScriptID 32) 0 93)
				else
					(messager say: 15 6 23)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (getHurt)
		(= local14 0)
		((local3 at: 12) enabled: 0)
	)
)

(instance dendrite5 of Feature
	(properties
		noun 7
		nsLeft 77
		nsTop 16
		nsRight 101
		nsBottom 31
		sightAngle 180
		x 89
		y 23
	)
)

(instance dendrite6 of TargFeature
	(properties
		noun 7
		nsLeft 92
		nsTop 45
		nsRight 122
		nsBottom 63
		sightAngle 180
		x 107
		y 54
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(93
				(if (Btst 459)
					(curRoom setScript: (ScriptID 32) 0 93)
				else
					(messager say: 15 6 23)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (getHurt)
		(= local14 0)
		((local3 at: 1) enabled: 0)
	)
)

(instance dendrite7 of TargFeature
	(properties
		noun 7
		nsLeft 149
		nsTop 44
		nsRight 168
		nsBottom 59
		sightAngle 180
		x 158
		y 51
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(93
				(if (Btst 459)
					(curRoom setScript: (ScriptID 32) 0 93)
				else
					(messager say: 15 6 23)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (getHurt)
		(= local14 0)
		((local3 at: 0) enabled: 0)
	)
)

(instance dendrite8 of TargFeature
	(properties
		noun 7
		nsTop 28
		nsRight 23
		nsBottom 50
		sightAngle 180
		x 11
		y 39
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(93
				(if (Btst 459)
					(curRoom setScript: (ScriptID 32) 0 93)
				else
					(messager say: 15 6 23)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (getHurt)
		(= local14 0)
		((local3 at: 2) enabled: 0)
		((local3 at: 3) enabled: 0)
		((local3 at: 4) enabled: 0)
	)
)

(instance dendrite9 of Feature
	(properties
		noun 7
		nsLeft 140
		nsTop 89
		nsRight 162
		nsBottom 105
		sightAngle 180
		x 151
		y 97
	)
)

(instance dendriteStem of Feature
	(properties
		noun 8
		nsLeft 227
		nsTop 102
		nsRight 268
		nsBottom 122
		sightAngle 180
		x 247
		y 112
	)
)

(instance earPart of Feature
	(properties
		noun 9
		nsLeft 101
		nsTop 12
		nsRight 132
		nsBottom 47
		sightAngle 180
		x 116
		y 29
	)
)

(instance leftNostril of Feature
	(properties
		noun 10
		nsLeft 31
		nsTop 99
		nsRight 60
		nsBottom 121
		sightAngle 180
		x 45
		y 110
	)
)

(instance rightNostril of Feature
	(properties
		noun 11
		nsLeft 85
		nsTop 98
		nsRight 110
		nsBottom 121
		sightAngle 180
		x 97
		y 109
	)
)

(instance altarPlatform of Feature
	(properties
		noun 12
		nsLeft 190
		nsTop 56
		nsRight 298
		nsBottom 85
		sightAngle 180
		x 244
		y 70
	)
)

(instance nosePlatform of Feature
	(properties
		noun 13
		nsLeft 89
		nsTop 78
		nsRight 143
		nsBottom 93
		sightAngle 180
		x 116
		y 85
	)
)

(instance noseTop of Feature
	(properties
		noun 14
		nsLeft 23
		nsTop 45
		nsRight 100
		nsBottom 94
		sightAngle 180
		x 61
		y 69
	)
)

(instance findNoun of Code
	(properties)
	
	(method (doit param1 param2)
		(if (param1 onMe: param2) (param1 noun?))
	)
)

(class Spark of Prop
	(properties
		scratch 0
		heading 0
		noun 0
		case 0
		modNum -1
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		sightAngle 180
		actions 0
		onMeCheck $0000
		state $0000
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		plane 0
		x 0
		y 0
		z 0
		scaleX 128
		scaleY 128
		maxScale 128
		scaleType 0
		priority 0
		fixPriority 0
		inLeft 0
		inTop 0
		inRight 0
		inBottom 0
		useInsetRect 0
		view 760
		loop 0
		cel 0
		bitmap 0
		yStep 2
		signal $4001
		lsLeft 0
		lsTop 0
		lsRight 0
		lsBottom 0
		brLeft 0
		brTop 0
		brRight 0
		brBottom 0
		scaleSignal $0000
		magnifier 0
		oldScaleX 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
		leftX 0
		leftY 0
		rightX 0
		rightY 0
		enabled 1
	)
	
	(method (doit)
		(super doit: &rest)
		(if local15 (= enabled 1))
		(cond 
			(
				(and
					(!= script sShockEgo)
					(not (curRoom script?))
					(not (& signal $0008))
					(ObjectIntersect ego self)
					(not local13)
				)
				(self setScript: sShockEgo)
			)
			(
				(and
					local12
					(< (GetDistance (ego x?) (ego y?) x y) local10)
				)
				(= theSpark self)
				(= local10 (GetDistance (ego x?) (ego y?) x y))
			)
		)
	)
	
	(method (cue)
		(self hide: setCel: 0)
		(if (== self theSpark)
			((ego script?) cue:)
		else
			(super cue: &rest)
		)
	)
)
