;;; Sierra Script 1.0 - (do not remove this comment)
(script# 300)
(include sci.sh)
(use Main)
(use TellerIcon)
(use GloryTalker)
(use PAvoid)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm300 0
	survivorTalker 1
	welcomeTalker 2
)

(local
	local0
	local1
	theX
	theY
	local4
	local5 =  150
	local6 =  150
	local7
	theFeature
	local9
	local10 =  1
	[local11 29] = [0 -20 143 0 142 143 159 -32768 143 159 0 142 -20 143 -32768 -20 143 0 142 236 150 -32768 236 150 0 142 -20 143 -32768]
	local40
	local41
	local42
	local43
	local44
	local45
	[local46 3] = [0 1 2]
	[local49 3] = [2 3 1]
	[local52 3] = [3 2]
	[local55 3] = [0 4 2]
	[local58 3] = [2 5 6]
	[local61 3] = [4 3 5]
	[local64 3] = [5 6 4]
	[local67 3] = [11 12 13]
	[local70 3] = [13 14 15]
	[local73 3] = [14 13 11]
	[local76 3] = [16 17 18]
	[local79 3] = [18 19 20]
	[local82 3] = [17 21 19]
	[local85 3] = [19 20 17]
	local88
	[local89 16] = [0 -19 -4 44 -2 -38 33 -12 -3 -40 58 -34 37 -26 -5 999]
	[local105 3] = [0 -20 999]
	[local108 5] = [0 -21 25 24 999]
	[local113 4] = [0 23 22 999]
	[local117 5] = [0 13 -14 18 999]
	[local122 5] = [0 15 16 17 999]
	[local127 8] = [0 27 28 29 30 31 32 999]
	[local135 3] = [0 -9 999]
	[local138 3] = [0 -62 999]
	[local141 3] = [0 -63 999]
	[local144 3] = [0 39 999]
	[local147 3] = [0 -41 999]
	[local150 4] = [0 42 43 999]
	[local154 4] = [0 35 36 999]
	[local158 9] = [0 -70 1 -60 69 68 64 -6 999]
	[local167 6] = [0 -17 -53 -32 33 999]
	[local173 5] = [0 -46 -49 -52 999]
	[local178 4] = [0 -47 -66 999]
	[local182 3] = [0 -48 999]
	[local185 4] = [0 -50 -51 999]
	[local189 3] = [0 -65 999]
	[local192 4] = [0 54 55 999]
	[local196 3] = [0 -56 999]
	[local199 3] = [0 67 999]
	[local202 4]
	[local206 19]
	[local225 15] = [0 -19 -20 -21 -12 -14 -26 -2 -3 -5 -38 -40 -41 -34 999]
	[local240 15]
	[local255 10] = [0 -17 -53 -32 -46 -49 -52 -47 -56 999]
)
(procedure (localproc_1fab param1)
	(= global408 (| global408 param1))
)

(procedure (localproc_1fb5 param1)
	(= global408 (& global408 (~ param1)))
)

(procedure (localproc_1fc0 param1)
	(return (& global408 param1))
)

(procedure (localproc_1fc7 param1 param2 param3 &tmp temp0)
	(= temp0 1)
	(while
	(Message msgGET curRoomNum param1 param2 param3 temp0)
		(++ temp0)
	)
	(return (-- temp0))
)

(instance rm300 of Rm
	(properties
		noun 25
		picture 300
		vanishingY 30
	)
	
	(method (init)
		(if (== prevRoomNum 270) (cSound hold: 0 setVol: 127))
		(ego
			noun: 2
			init:
			normalize:
			setScale: Scaler 95 60 180 30
		)
		(= [local202 0] @local158)
		(= [local206 0] @local89)
		(= [local206 1] @local105)
		(= [local206 2] @local108)
		(= [local206 3] @local113)
		(= [local206 4] @local117)
		(= [local206 5] @local122)
		(= [local206 6] @local127)
		(= [local206 7] @local135)
		(= [local206 8] @local138)
		(= [local206 9] @local141)
		(= [local206 10] @local144)
		(= [local206 11] @local147)
		(= [local206 12] @local150)
		(= [local206 13] @local154)
		(= [local240 0] @local167)
		(= [local240 1] @local173)
		(= [local240 2] @local192)
		(= [local240 3] @local196)
		(= [local240 4] @local178)
		(= [local240 5] @local185)
		(= [local240 6] @local189)
		(= [local240 7] @local182)
		(= [local240 8] @local199)
		(egoTell init: ego @local158 @local202)
		(welcomeTell
			init: welcomeWoman @local89 @local206 @local225
		)
		(survivorTell
			init: survivor @local167 @local240 @local255
		)
		(walkHandler addToFront: curRoom)
		(curRoom
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						177
						189
						177
						187
						313
						187
						313
						172
						232
						171
						221
						162
						208
						159
						192
						151
						235
						150
						256
						160
						247
						141
						273
						141
						287
						150
						312
						146
						312
						138
						297
						138
						282
						117
						274
						117
						288
						139
						275
						139
						239
						130
						238
						137
						214
						137
						197
						115
						169
						107
						157
						106
						182
						116
						199
						139
						168
						139
						140
						127
						97
						127
						101
						140
						68
						140
						63
						115
						59
						107
						39
						107
						35
						114
						25
						141
						4
						141
						4
						146
						31
						146
						34
						152
						80
						154
						80
						177
						3
						179
						3
						187
						176
						187
						176
						189
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						87
						160
						114
						157
						122
						166
						137
						165
						123
						148
						159
						148
						167
						152
						187
						151
						205
						160
						218
						163
						229
						172
						195
						176
						160
						181
						118
						178
						87
						175
					yourself:
				)
		)
		(leftDoor init:)
		(rightDoor init:)
		(super init:)
		(cond 
			((>= Clock 750)
				(if (!= prevRoomNum 305)
					(cond 
						((not global408) (localproc_1fab 1) (localproc_1fab 256))
						((localproc_1fc0 1)
							(cond 
								(
									(and
										(not (localproc_1fc0 16))
										(>= Day (+ survivorDay 1))
										(localproc_1fc0 128)
										(>= timeODay 4)
									)
									(localproc_1fb5 1)
									(localproc_1fab 4)
								)
								((localproc_1fc0 128) (localproc_1fb5 1) (localproc_1fab 2))
							)
						)
						(
							(and
								(not (localproc_1fc0 16))
								(localproc_1fc0 2)
								(>= Day (+ survivorDay 1))
								(localproc_1fc0 128)
								(>= timeODay 4)
							)
							(localproc_1fb5 2)
							(localproc_1fab 4)
						)
						((localproc_1fc0 4)
							(cond 
								(
									(and
										(not (localproc_1fc0 32))
										(>= Day (+ survivorDay 3))
										(localproc_1fc0 16)
									)
									(= survivorDay Day)
									(localproc_1fb5 4)
									(localproc_1fab 8)
								)
								((or (localproc_1fc0 16) (< timeODay 4)) (localproc_1fb5 4) (localproc_1fab 2))
							)
						)
						(
							(and
								(not (localproc_1fc0 32))
								(localproc_1fc0 2)
								(>= Day (+ survivorDay 3))
								(localproc_1fc0 16)
							)
							(= survivorDay Day)
							(localproc_1fb5 2)
							(localproc_1fab 8)
						)
						((and (localproc_1fc0 8) (!= survivorDay Day))
							(localproc_1fb5 8)
							(localproc_1fab 32)
							(localproc_1fab 2)
						)
					)
					(if (and (localproc_1fc0 256) (localproc_1fc0 1))
						(localproc_1fb5 256)
						(welcomeWoman
							x: 37
							y: 179
							view: 303
							loop: 1
							cel: 0
							init:
							stopUpd:
						)
						(cond 
							((== prevRoomNum 310) (ego x: 302 y: 33) (self setScript: firstWalkIn))
							((< (ego x?) 35)
								(= local0 197)
								(= local1 135)
								(ego y: 114 x: 179)
								(self setScript: firstWalkIn)
							)
							(else
								(= local0 47)
								(= local1 135)
								(ego y: 114 x: 47)
								(self setScript: firstWalkIn)
							)
						)
					else
						(welcomeWoman
							setCycle: StopWalk -1
							setAvoider: PAvoider
							init:
							stopUpd:
						)
						(cond 
							((== prevRoomNum 310) (ego x: 302 y: 33) (self setScript: sEnter self))
							((< (ego x?) 35)
								(= local0 197)
								(= local1 135)
								(ego y: 114 x: 179)
								(self setScript: walkIn)
							)
							(else
								(= local0 47)
								(= local1 135)
								(ego y: 114 x: 47)
								(self setScript: walkIn)
							)
						)
					)
				else
					(welcomeWoman
						setCycle: StopWalk -1
						setAvoider: PAvoider
						init:
						stopUpd:
					)
				)
				(flameRight setCycle: Fwd init:)
				(flameCenter setCycle: Fwd init:)
				(flameLeft setCycle: Fwd init:)
				(= local88 (mod (+ Day 3) 3))
				(northSitter1
					loop: (mod (+ Day 2) 2)
					cel: [local46 local88]
					noun: [local67 local88]
					addToPic:
				)
				(eastSitter2
					cel: [local58 local88]
					noun:
						[local79 (eastSitter1
							cel: [local55 local88]
							noun:
								[local76 (if (and (not (localproc_1fc0 4)) (mod Day 2))
									(northSitter2
										loop: (mod (+ Day 2) 2)
										cel: [local49 local88]
										noun: [local70 (northCushion3 approachVerbs: 4 init:)]
										addToPic:
									)
									(otherTray x: 132 y: 200 z: 35 priority: 14 addToPic:)
								else
									(northCushion2 init: approachVerbs: 4)
									(northSitter3
										loop: (mod (+ Day 2) 2)
										cel: [local52 local88]
										noun: [local73 (otherTray x: 250 y: 200 z: 41 addToPic:)]
										addToPic:
									)
								)]
							addToPic:
						)]
					addToPic:
				)
				(eastSitter3 noun: 22 addToPic:)
				(westSitter2
					cel: [local64 local88]
					noun:
						[local85 (cond 
							((not (localproc_1fc0 4))
								(westSitter1
									cel: [local61 local88]
									noun: [local82 local88]
									addToPic:
								)
							)
							((localproc_1fc0 16)
								(= local40 1)
								(= local41 (localproc_1fc0 512))
								(= local42 1)
								(survivor
									view: 307
									loop: 2
									cel: (if (== global466 1023) 3 else 1)
									x: 104
									y: 171
									init:
								)
							)
							(else (westCushion init:))
						)]
					addToPic:
				)
				(tray1 addToPic:)
				(tray2 addToPic:)
				(tray3 addToPic:)
				(tray4 addToPic:)
				(tray5 addToPic:)
				(tray6 addToPic:)
			)
			((!= prevRoomNum 305)
				(cond 
					((== prevRoomNum 310) (ego x: 302 y: 33) (self setScript: sEnter self))
					((< (ego x?) 35)
						(= local0 197)
						(= local1 135)
						(ego y: 114 x: 179)
						(self setScript: walkIn)
					)
					(else
						(= local0 47)
						(= local1 135)
						(ego y: 114 x: 47)
						(self setScript: walkIn)
					)
				)
			)
		)
		(chandelier init:)
		(rightchandelier init:)
		(lefttable init:)
		(midtable init:)
		(righttable init:)
		(stairs init:)
		(board init: approachVerbs: 1)
	)
	
	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 76 81 6)
		(cond 
			(script 0)
			((== (ego onControl: 1) 2) (self setScript: toRoom))
			((== (ego onControl: 2) 4) (curRoom newRoom: 270))
			((and (ego mover?) (== (ego view?) 40)) (ego setMotion: 0 setScript: standNorth))
		)
	)
	
	(method (dispose)
		(UnLoad 128 300)
		(UnLoad 128 301)
		(UnLoad 128 302)
		(UnLoad 128 303)
		(UnLoad 128 306)
		(walkHandler delete: curRoom)
		(if local41 (localproc_1fab 512))
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3 (egoActions doVerb: 3))
			(else 
				(if (< Clock 750)
					(messager say: 0 6 77)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance firstWalkIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== prevRoomNum 310)
					(self setScript: sEnter self)
				else
					(HandsOff)
					(ego setMotion: PolyPath local0 local1 self)
				)
			)
			(1
				(HandsOff)
				(welcomeWoman setCycle: End self)
			)
			(2
				(welcomeWoman
					view: 301
					loop: 4
					cel: 5
					setCycle: StopWalk -1
					setAvoider: PAvoider
				)
				(= cycles 2)
			)
			(3
				(messager say: 1 6 59 0 self)
			)
			(4
				(welcomeWoman setMotion: MoveTo -20 174 self)
			)
			(5
				(welcomeWoman y: 145 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setMotion: PolyPath local0 local1 self)
			)
			(1 (HandsOn) (self dispose:))
		)
	)
)

(instance sEnter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego setMotion: MoveTo 273 81 self)
			)
			(1
				(ego setMotion: MoveTo 250 79 self)
			)
			(2
				(ego setMotion: MoveTo 295 139 self)
			)
			(3 (HandsOn) (self dispose:))
		)
	)
)

(instance toRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego setMotion: MoveTo 250 79 self)
			)
			(1
				(ego setMotion: MoveTo 273 81 self)
			)
			(2
				(ego setMotion: MoveTo 309 31 self)
			)
			(3 (curRoom newRoom: 310))
		)
	)
)

(instance survivorWalkIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= survivorDay Day)
				(= local40 1)
				(localproc_1fab 16)
				(survivor
					init:
					setCycle: Walk
					setMotion: MoveTo 104 171 self
				)
			)
			(1
				(survivor loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(survivor loop: 2 cel: 1)
				(self dispose:)
			)
		)
	)
)

(instance sitNorth of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(if (not local40) (= local9 1))
				(CueObj client: 0)
				(HandsOff)
				(ego setPri: local4 setMotion: MoveTo theX theY self)
			)
			(1
				(ego
					view: 40
					setLoop: 1
					cel: 0
					x: theX
					y: theY
					setCycle: End self
				)
				(if (ego looper?)
					((ego looper?) dispose:)
					(ego looper: 0)
				)
				(if local40 (HandsOn) (self dispose:))
			)
			(2
				(welcomeWoman setMotion: MoveTo 5 142 self)
			)
			(3
				(welcomeWoman setMotion: PolyPath local0 local1 self)
			)
			(4
				(cond 
					((and (not local42) (localproc_1fc0 4)) (= local42 1) (messager say: 1 6 16 0 self))
					((and (not local42) (localproc_1fc0 8)) (= local42 1) (messager say: 1 6 45 0 self))
					(else
						(= local10 (localproc_1fc7 1 6 1))
						(messager
							say: 1 6 1 (+ (mod (+ Day local10) local10) 1) self
						)
					)
				)
			)
			(5 (HandsOn) (self dispose:))
		)
	)
)

(instance standNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 0)
				(if
					(and
						(CueObj client?)
						((CueObj client?) approachX?)
						(!= (theIconBar curIcon?) (theIconBar at: 1))
					)
					(= local7 1)
				)
				(self cue:)
			)
			(1
				(HandsOff)
				(if local9
					(if local45
						(self setScript: welcomeFlirtExit self)
						(if (localproc_1fc0 4)
							(curRoom setScript: survivorWalkIn)
						)
					else
						(if (localproc_1fc0 4)
							(curRoom setScript: survivorWalkIn)
						)
						(self setScript: welcomeExit self)
					)
					(ego setCycle: Beg)
				else
					(ego setCycle: Beg self)
				)
				(theFeature approachVerbs: 4)
			)
			(2
				(if local9
					(welcomeWoman setMotion: MoveTo -10 142)
					(= local9 0)
				)
				(ego
					normalize: 5
					cel: 0
					setMotion: MoveTo (ego x?) (- (ego y?) 5) self
				)
			)
			(3
				(if local7
					(ego
						setPri: -1
						setMotion:
							PolyPath
							((CueObj client?) approachX?)
							((CueObj client?) approachY?)
							CueObj
					)
				else
					(ego setPri: -1 setMotion: PolyPath local5 local6 self)
				)
				(welcomeWoman stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getFood of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (localproc_1fc0 128))
					(localproc_1fab 128)
					(= survivorDay Day)
				)
				(HandsOff)
				(messager say: 2 5 70 0 self)
			)
			(1
				(if local45
					(self setScript: welcomeFlirtExit self)
				else
					(self setScript: welcomeExit self)
				)
				(if (localproc_1fc0 4) (ego setScript: survivorWalkIn))
			)
			(2 (= seconds 4))
			(3
				(welcomeWoman view: 304 setMotion: MoveTo 5 142 self)
			)
			(4
				(welcomeWoman setMotion: PolyPath local0 local1 self)
			)
			(5
				(welcomeWoman
					view: 303
					loop: 4
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(6
				(tray
					x: (welcomeWoman x?)
					y: (+ (welcomeWoman y?) 30)
					z: 30
					priority: (+ local4 3)
					addToPic:
				)
				(welcomeWoman setCycle: End self)
			)
			(7 (messager say: 1 6 9 0 self))
			(8
				(cond 
					((== ((inventory at: 0) message?) 59) (messager say: 1 6 8 0 self) (= local44 1))
					(((inventory at: 0) amount?)
						((inventory at: 0)
							amount: (- ((inventory at: 0) amount?) 1)
						)
						(messager say: 1 6 11 0 self)
					)
					(else (messager say: 1 6 10 0 self))
				)
			)
			(9
				(welcomeWoman
					view: 301
					setCycle: StopWalk -1
					setMotion: PolyPath 5 142 self
				)
			)
			(10
				(welcomeWoman setMotion: MoveTo -10 142 self)
			)
			(11
				(messager say: 0 6 71 0 self)
			)
			(12 (HandsOn) (self dispose:))
		)
	)
)

(instance tellFit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (HandsOff) (= cycles 5))
			(1
				(messager say: 3 6 74 0 self)
			)
			(2 (= cycles 15))
			(3
				(welcomeWoman setMotion: MoveTo 5 142 self)
			)
			(4
				(messager say: 1 6 57 0 self)
			)
			(5
				(welcomeWoman setMotion: MoveTo -15 142 self)
			)
			(6
				(survivor setCycle: End)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance welcomeExit of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(if (not caller) (HandsOff))
				(welcomeWoman
					view: 301
					setCycle: StopWalk -1
					setMotion: PolyPath 5 142 self
				)
			)
			(1
				(welcomeWoman setMotion: MoveTo -10 142 self)
				(= local45 0)
				(= local9 0)
			)
			(2
				(welcomeWoman stopUpd:)
				(if (not caller) (HandsOn))
				(self dispose:)
			)
		)
	)
)

(instance welcomeFlirtExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not caller) (HandsOff))
				(welcomeWoman
					view: 301
					setCycle: StopWalk -1
					setMotion: PolyPath 75 152 self
				)
			)
			(1
				(welcomeWoman
					view: 303
					loop: (+ (Random 0 1) 2)
					cel: 0
					setCycle: Beg self
				)
			)
			(2
				(welcomeWoman
					view: 301
					setCycle: StopWalk -1
					setMotion: PolyPath 5 142 self
				)
			)
			(3
				(welcomeWoman setMotion: MoveTo -10 142 self)
				(= local45 0)
				(= local9 0)
			)
			(4
				(welcomeWoman stopUpd:)
				(if (not caller) (HandsOn))
				(self dispose:)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(3
					(cond 
						((curRoom script?) 0)
						((== (ego view?) 40)
							(= local5 ((User curEvent?) x?))
							(= local6 ((User curEvent?) y?))
							(ego setScript: standNorth)
							(return 1)
						)
						(else (super doVerb: theVerb))
					)
				)
				(else  (super doVerb: theVerb))
			)
		)
	)
)

(instance egoTell of Teller
	(properties)
	
	(method (showDialog)
		(return
			(if (or local9 local40)
				(super
					showDialog:
						1
						local9
						-60
						local9
						64
						local9
						-6
						local9
						69
						(if local40 (not local41) else 0)
						68
						local40
						-70
						local9
				)
			else
				(client doVerb: 2)
				(return -999)
			)
		)
	)
	
	(method (doChild param1 &tmp temp0)
		(return
			(cond 
				((== param1 -60)
					(if local45
						(curRoom setScript: welcomeFlirtExit)
					else
						(curRoom setScript: welcomeExit)
					)
					(if
					(and (not (localproc_1fc0 16)) (localproc_1fc0 4))
						(ego setScript: survivorWalkIn)
					)
					(return 1)
				)
				((== param1 -70)
					(cond 
						((Btst 3) (Bclr 3))
						((Btst 2) (Bclr 2))
						((< freeMeals 2) (++ freeMeals))
						((not (localproc_1fc0 4)) (= local43 1))
					)
					(if (not local43)
						(curRoom setScript: getFood)
						(if
						(and (not (localproc_1fc0 16)) (localproc_1fc0 4))
							(ego setScript: survivorWalkIn)
						)
						(= local43 1)
					else
						(messager say: 0 6 72)
					)
					(return 0)
				)
				((== param1 -6)
					(= local45 1)
					(= temp0 (localproc_1fc7 1 6 6))
					(messager say: 1 6 6 (+ (mod (+ Day temp0) temp0) 1))
					(return 0)
				)
				(else (super doChild: param1 &rest))
			)
		)
	)
)

(instance survivor of Actor
	(properties
		x -15
		y 189
		noun 3
		view 307
		loop 2
		cel 2
	)
)

(instance survivorTell of Teller
	(properties)
	
	(method (showDialog)
		(return
			(if (not local41)
				(super showDialog:)
			else
				(messager say: 3 6 73)
				(return -999)
			)
		)
	)
	
	(method (doChild param1)
		(return
			(cond 
				((== param1 -17)
					(ego solvePuzzle: 248 7)
					(if (== (= global466 (| global466 $0001)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(super doChild: param1)
				)
				((== param1 -46)
					(if (== (= global466 (| global466 $0002)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(super doChild: param1)
				)
				((== param1 -49)
					(if (== (= global466 (| global466 $0004)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(super doChild: param1)
				)
				((== param1 -52)
					(if (== (= global466 (| global466 $0008)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(super doChild: param1)
				)
				((== param1 -47)
					(if (== (= global466 (| global466 $0010)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(super doChild: param1)
				)
				((== param1 -66)
					(if (== (= global466 (| global466 $0020)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(return 1)
				)
				((== param1 -48)
					(if (== (= global466 (| global466 $0040)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(return 1)
				)
				((== param1 -50)
					(if (== (= global466 (| global466 $0080)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(return 1)
				)
				((== param1 -51)
					(if (== (= global466 (| global466 $0100)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(return 1)
				)
				((== param1 -65)
					(if (== (= global466 (| global466 $0200)) 1023)
						(= local41 1)
						(curRoom setScript: tellFit)
					)
					(return 1)
				)
				(else (super doChild: param1))
			)
		)
	)
)

(instance survivorTalker of GloryTalker
	(properties
		x 1
		y 10
		view 308
		loop 1
		talkWidth 150
		back 57
		textX 137
		textY 3
		backColor 27
	)
	
	(method (init)
		(super
			init: survivorBrow survivorEyes survivorMouth &rest
		)
	)
)

(instance survivorEyes of Prop
	(properties
		nsTop 24
		nsLeft 62
		view 308
		loop 2
	)
)

(instance survivorBrow of View
	(properties
		nsTop 16
		nsLeft 40
		view 308
		loop 3
	)
)

(instance survivorMouth of Prop
	(properties
		nsTop 37
		nsLeft 42
		view 308
	)
)

(instance welcomeWoman of Actor
	(properties
		x -20
		y 145
		noun 1
		view 301
	)
)

(instance welcomeTalker of GloryTalker
	(properties
		x 1
		y 10
		view 302
		loop 1
		talkWidth 150
		back 57
		textX 137
		textY 3
		backColor 14
	)
	
	(method (init)
		(super init: welcomeBrow welcomeEyes welcomeMouth &rest)
	)
)

(instance welcomeEyes of Prop
	(properties
		nsTop 27
		nsLeft 45
		view 302
		loop 2
	)
)

(instance welcomeBrow of Prop
	(properties
		nsTop 27
		nsLeft 43
		view 302
		loop 3
	)
)

(instance welcomeMouth of Prop
	(properties
		nsTop 43
		nsLeft 48
		view 302
	)
)

(instance welcomeTell of Teller
	(properties)
	
	(method (showDialog)
		(super
			showDialog:
				-2
				(cond 
					((localproc_1fc0 6))
					((localproc_1fc0 64) (not (localproc_1fc0 8)))
				)
				-38
				(localproc_1fc0 8)
				7
				local44
				-19
				(localproc_1fc0 1)
				-4
				(localproc_1fc0 2)
				44
				(localproc_1fc0 8)
				33
				(localproc_1fc0 1)
				-12
				(localproc_1fc0 1)
				-3
				(localproc_1fc0 6)
				-40
				(localproc_1fc0 8)
				58
				(if (localproc_1fc0 16)
					(if (not (localproc_1fc0 8))
						(not (localproc_1fc0 32))
					)
				else
					0
				)
				-34
				(localproc_1fc0 4)
				37
				(localproc_1fc0 8)
				-26
				(localproc_1fc0 1)
				-5
				(localproc_1fc0 6)
		)
	)
	
	(method (getSeqNum param1 &tmp temp0)
		(return
			(if (== param1 63)
				(return
					(+
						(mod (+ Day (= temp0 (localproc_1fc7 1 2 63))) temp0)
						1
					)
				)
			else
				(return 1)
			)
		)
	)
	
	(method (doChild param1 &tmp temp0)
		(return
			(cond 
				((== param1 -4)
					(= temp0 (localproc_1fc7 1 5 4))
					(messager say: 1 5 4 (+ (mod (+ Day temp0) temp0) 1))
					(return 0)
				)
				((== param1 -3)
					(= temp0 (localproc_1fc7 1 5 3))
					(messager say: 1 5 3 (+ (mod (+ Day temp0) temp0) 1))
					(super doChild: param1)
					(return 0)
				)
				((== param1 -62)
					(= temp0 (localproc_1fc7 1 5 62))
					(messager say: 1 5 62 (+ (mod (+ Day temp0) temp0) 1))
					(return 0)
				)
				((== param1 -2)
					(= temp0 (localproc_1fc7 1 5 2))
					(messager say: 1 5 2 (+ (mod (+ Day temp0) temp0) 1))
					(super doChild: param1)
					(return 0)
				)
				((== param1 -9)
					(= temp0 (localproc_1fc7 1 5 9))
					(messager say: 1 5 9 (+ (mod (+ Day temp0) temp0) 1))
					(return 0)
				)
				((== param1 -5)
					(= temp0 (localproc_1fc7 1 5 5))
					(messager say: 1 5 5 (+ (mod (+ Day temp0) temp0) 1))
					(super doChild: param1)
					(return 0)
				)
				((== param1 -63)
					(= temp0 (localproc_1fc7 1 5 63))
					(messager say: 1 5 63 (+ (mod (+ Day temp0) temp0) 1))
					(return 0)
				)
				((== param1 -12) (localproc_1fab 64) (super doChild: param1) (return 1))
				(else (super doChild: param1))
			)
		)
	)
	
	(method (doVerb theVerb)
		(return
			(if (== theVerb 10)
				(cond 
					((Btst 3) (Bclr 3))
					((Btst 2) (Bclr 2))
					((< freeMeals 2) (++ freeMeals))
					((not (localproc_1fc0 4)) (= local43 1))
				)
				(if (not local43)
					(curRoom setScript: getFood)
					(if
					(and (not (localproc_1fc0 16)) (localproc_1fc0 4))
						(ego setScript: survivorWalkIn)
					)
					(= local43 1)
				else
					(messager say: 0 6 72)
				)
				(return 1)
			else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flameLeft of Prop
	(properties
		x 16
		y 162
		noun 23
		view 300
		loop 1
		cel 2
		priority 14
		signal $4010
		detailLevel 3
	)
)

(instance flameCenter of Prop
	(properties
		x 148
		y 162
		noun 23
		view 300
		loop 1
		priority 14
		signal $4010
		detailLevel 3
	)
)

(instance flameRight of Prop
	(properties
		x 274
		y 154
		noun 23
		view 300
		loop 1
		priority 12
		signal $4010
		detailLevel 3
	)
)

(instance leftDoor of View
	(properties
		x 31
		y 45
		noun 9
		view 300
		loop 4
		signal $5011
	)
	
	(method (doit &tmp temp0 temp1)
		(if (= temp0 (Abs (PalVary pvGET_CURRENT_STEP)))
			(if
				(!=
					(= temp1
						(cond 
							((and (<= 0 temp0) (<= temp0 5)) 0)
							((and (<= 6 temp0) (<= temp0 10)) 1)
							((and (<= 11 temp0) (<= temp0 15)) 2)
							((and (<= 16 temp0) (<= temp0 20)) 3)
							((and (<= 21 temp0) (<= temp0 25)) 4)
							((and (<= 26 temp0) (<= temp0 30)) 5)
							((and (<= 31 temp0) (<= temp0 35)) 6)
							((and (<= 36 temp0) (<= temp0 40)) 7)
							((and (<= 41 temp0) (<= temp0 45)) 8)
							((and (<= 46 temp0) (<= temp0 50)) 9)
							((and (<= 51 temp0) (<= temp0 55)) 10)
							((and (<= 56 temp0) (<= temp0 64)) 11)
						)
					)
					cel
				)
				(self setCel: temp1 stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance rightDoor of View
	(properties
		x 156
		y 45
		noun 26
		view 300
		loop 5
		signal $5011
	)
	
	(method (doit &tmp temp0 temp1)
		(if (= temp0 (Abs (PalVary pvGET_CURRENT_STEP)))
			(if
				(!=
					(= temp1
						(cond 
							((and (<= 0 temp0) (<= temp0 5)) 0)
							((and (<= 6 temp0) (<= temp0 10)) 1)
							((and (<= 11 temp0) (<= temp0 15)) 2)
							((and (<= 16 temp0) (<= temp0 20)) 3)
							((and (<= 21 temp0) (<= temp0 25)) 4)
							((and (<= 26 temp0) (<= temp0 30)) 5)
							((and (<= 31 temp0) (<= temp0 35)) 6)
							((and (<= 36 temp0) (<= temp0 40)) 7)
							((and (<= 41 temp0) (<= temp0 45)) 8)
							((and (<= 46 temp0) (<= temp0 50)) 9)
							((and (<= 51 temp0) (<= temp0 55)) 10)
							((and (<= 56 temp0) (<= temp0 64)) 11)
						)
					)
					cel
				)
				(self setCel: temp1 stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance tray of View
	(properties
		noun 24
		view 300
		loop 3
		priority 14
		signal $5010
	)
)

(instance otherTray of View
	(properties
		x 250
		y 200
		z 41
		noun 24
		view 300
		loop 3
		priority 13
		signal $5010
	)
)

(instance tray1 of View
	(properties
		x 1
		y 200
		z 37
		noun 24
		view 300
		loop 3
		priority 14
		signal $5010
	)
)

(instance tray2 of View
	(properties
		x 28
		y 200
		z 34
		noun 24
		view 300
		loop 3
		priority 14
		signal $5010
	)
)

(instance tray3 of View
	(properties
		x 107
		y 200
		z 31
		noun 24
		view 300
		loop 3
		priority 14
		signal $5010
	)
)

(instance tray4 of View
	(properties
		x 163
		y 200
		z 31
		noun 24
		view 300
		loop 3
		priority 14
		signal $5010
	)
)

(instance tray5 of View
	(properties
		x 225
		y 200
		z 38
		noun 24
		view 300
		loop 3
		priority 13
		signal $5010
	)
)

(instance tray6 of View
	(properties
		x 279
		y 200
		z 55
		noun 24
		view 306
		loop 4
		priority 13
		signal $5010
	)
)

(instance northSitter1 of View
	(properties
		x 15
		y 155
		view 306
		cel 2
		priority 10
		signal $5010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager say: 4 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance northSitter2 of View
	(properties
		x 150
		y 154
		view 306
		cel 1
		priority 10
		signal $5010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager say: 4 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance northSitter3 of View
	(properties
		x 266
		y 150
		view 306
		priority 9
		signal $5010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager say: 4 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance eastSitter1 of View
	(properties
		x 58
		y 165
		view 306
		loop 3
		cel 3
		priority 11
		signal $5010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager say: 4 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance eastSitter2 of View
	(properties
		x 200
		y 169
		view 306
		loop 3
		cel 1
		priority 12
		signal $5010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager say: 4 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance eastSitter3 of View
	(properties
		x 317
		y 158
		view 306
		loop 3
		cel 1
		priority 10
		signal $5010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager say: 4 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance westSitter1 of View
	(properties
		x 107
		y 171
		view 306
		loop 2
		cel 3
		priority 12
		signal $5010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager say: 4 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance westSitter2 of View
	(properties
		x 225
		y 159
		view 306
		loop 2
		priority 10
		signal $5010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager say: 4 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance board of Feature
	(properties
		x 113
		y 101
		nsTop 91
		nsLeft 98
		nsBottom 113
		nsRight 133
		sightAngle 40
		approachX 113
		approachY 126
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(ego solvePuzzle: 247 3)
			(curRoom newRoom: 305)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance northCushion2 of Feature
	(properties
		x 149
		y 154
		noun 27
		nsTop 146
		nsLeft 132
		nsBottom 155
		nsRight 165
		sightAngle 40
		approachX 164
		approachY 146
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(if (!= (ego view?) 40)
				(= theX x)
				(= theY y)
				(= local0 132)
				(= local1 165)
				(= local4 11)
				(= theFeature self)
				(ego setScript: sitNorth)
				(self approachVerbs:)
			else
				(super doVerb: theVerb &rest)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance northCushion3 of Feature
	(properties
		x 272
		y 148
		noun 27
		nsTop 140
		nsLeft 245
		nsBottom 146
		nsRight 281
		sightAngle 40
		approachX 252
		approachY 139
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(if (!= (ego view?) 40)
				(= theX x)
				(= theY y)
				(= local0 252)
				(= local1 159)
				(= local4 9)
				(= theFeature self)
				(ego setScript: sitNorth)
				(self approachVerbs:)
			else
				(super doVerb: theVerb &rest)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance westCushion of Feature
	(properties
		x 103
		y 167
		noun 28
		nsTop 160
		nsLeft 93
		nsBottom 174
		nsRight 113
		sightAngle 40
	)
)

(instance chandelier of Feature
	(properties
		x 114
		y 14
		noun 5
		nsTop -1
		nsLeft 86
		nsBottom 30
		nsRight 143
		sightAngle 180
	)
)

(instance rightchandelier of Feature
	(properties
		x 239
		y 20
		noun 5
		nsLeft 214
		nsBottom 41
		nsRight 264
		sightAngle 180
	)
)

(instance lefttable of Feature
	(properties
		x 27
		y 159
		noun 6
		nsTop 149
		nsBottom 169
		nsRight 55
		sightAngle 180
	)
)

(instance midtable of Feature
	(properties
		x 152
		y 162
		noun 7
		nsTop 155
		nsLeft 110
		nsBottom 173
		nsRight 194
		sightAngle 180
	)
)

(instance righttable of Feature
	(properties
		x 272
		y 155
		noun 8
		nsTop 146
		nsLeft 232
		nsBottom 164
		nsRight 313
		sightAngle 180
	)
)

(instance stairs of Feature
	(properties
		x 290
		y 58
		noun 10
		nsTop 39
		nsLeft 275
		nsBottom 78
		nsRight 305
		sightAngle 180
	)
)
