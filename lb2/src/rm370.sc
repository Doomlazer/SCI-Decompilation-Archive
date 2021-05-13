;;; Sierra Script 1.0 - (do not remove this comment)
(script# 370)
(include sci.sh)
(use Main)
(use LbDoor)
(use LBRoom)
(use ExitFeature)
(use RotundaRgn)
(use Scaler)
(use Feature)
(use MoveFwd)
(use Actor)
(use System)

(public
	rm370 0
)

(instance rm370 of LBRoom
	(properties
		noun 5
		picture 370
		style $000c
		east 400
		west 350
	)
	
	(method (init &tmp [temp0 6])
		(ego init: normalize: 831 setScale: Scaler 95 0 190 0)
		(if (== currentAct 2)
			(self setRegions: 93)
			((ScriptID 2370 0) doit: (= obstacles (List new:)))
		else
			(self setRegions: 90)
		)
		(if (== prevRoomNum 355)
			((ScriptID 90 5) moveTo: 420 goTo: 500)
			((ScriptID 90 1) moveTo: 420 goTo: 510)
			((ScriptID 90 7) moveTo: 450 wander:)
			((ScriptID 90 4) moveTo: 454 wander:)
			((ScriptID 90 2) moveTo: -2)
			((ScriptID 32 0) moveTo: -2)
			((ScriptID 90 6) moveTo: 550 posn: 175 130 setHeading: 1)
			((ScriptID 90 3)
				originalView: 818
				moveTo: 430
				posn: 155 165
				setHeading: 135
			)
		)
		(switch prevRoomNum
			(east
				(= style 100)
				(ego edgeHit: 0 setHeading: 270)
			)
			(340 (= style 9))
			(355 0)
			(west
				(if (> (ego y?) 185) (ego y: 185))
			)
			(else  (ego posn: 160 160))
		)
		(super init:)
		(if (!= prevRoomNum east) (theGame handsOn:))
		(westExitFeature init:)
		(giftShoppeDoor init:)
		(if (> currentAct 2) (giftShoppeDoor locked: 1))
		(tables setOnMeCheck: 1 4096 init:)
		(column1 init:)
		(column2 init:)
		(column3 init:)
		(column4 init:)
		(column5 init:)
		(bench init:)
		(alcove init:)
		(doorway init: approachVerbs: 4)
		(if (== currentAct 2)
			(partyATP1 setScale: 170 addToPic:)
			(partyATP2 setScale: 170 addToPic:)
			(partyATP3 setScale: 170 addToPic:)
			(partyATP4 setScale: 170 addToPic:)
			(partyATP5 setScale: 170 addToPic:)
			(partyATP6 setScale: 170 addToPic:)
			(switch global128
				(0
					((ScriptID 93 1)
						setLoop: 8
						setCel: 3
						posn: 160 180
						addToPic:
					)
				)
				(1
					((ScriptID 93 1)
						setLoop: 8
						setCel: 3
						posn: 160 180
						addToPic:
					)
				)
				(2
					((ScriptID 93 10)
						setLoop: 8
						setCel: 3
						posn: 160 180
						addToPic:
					)
				)
				(3
					((ScriptID 93 10)
						setLoop: 8
						setCel: 6
						posn: 155 180
						addToPic:
					)
					((ScriptID 93 11)
						setLoop: 8
						setCel: 7
						posn: 170 180
						addToPic:
					)
				)
				(4
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 140 180
						addToPic:
					)
					((ScriptID 93 11)
						setLoop: 8
						setCel: 2
						posn: 155 180
						addToPic:
					)
					((ScriptID 93 10)
						setLoop: 8
						setCel: 1
						posn: 170 180
						addToPic:
					)
				)
				(5
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 140 180
						addToPic:
					)
					((ScriptID 93 11)
						setLoop: 8
						setCel: 2
						posn: 155 180
						addToPic:
					)
					((ScriptID 93 10)
						setLoop: 8
						setCel: 1
						posn: 170 180
						addToPic:
					)
				)
				(6
					((ScriptID 93 12)
						setLoop: 8
						setCel: 0
						posn: 155 185
						addToPic:
					)
					((ScriptID 93 11)
						setLoop: 8
						setCel: 2
						posn: 165 186
						addToPic:
					)
				)
				(7
					((ScriptID 93 11)
						setLoop: 8
						setCel: 0
						posn: 150 185
						addToPic:
					)
					((ScriptID 93 10)
						setLoop: 8
						setCel: 5
						posn: 165 183
						addToPic:
					)
				)
				(8
					((ScriptID 93 5)
						setLoop: 8
						setCel: 2
						posn: 155 182
						addToPic:
					)
					((ScriptID 93 12)
						setLoop: 8
						setCel: 0
						posn: 165 185
						addToPic:
					)
				)
				(9
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 140 180
						addToPic:
					)
					((ScriptID 93 10)
						setLoop: 8
						setCel: 3
						posn: 155 183
						addToPic:
					)
					((ScriptID 93 12)
						setLoop: 8
						setCel: 7
						posn: 170 180
						addToPic:
					)
				)
				(10
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 140 180
						addToPic:
					)
					((ScriptID 93 10)
						setLoop: 8
						setCel: 3
						posn: 155 183
						addToPic:
					)
					((ScriptID 93 12)
						setLoop: 8
						setCel: 7
						posn: 170 180
						addToPic:
					)
				)
				(11
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 140 180
						addToPic:
					)
					((ScriptID 93 10)
						setLoop: 8
						setCel: 3
						posn: 155 183
						addToPic:
					)
					((ScriptID 93 12)
						setLoop: 8
						setCel: 7
						posn: 170 180
						addToPic:
					)
				)
				(12
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 140 180
						addToPic:
					)
					((ScriptID 93 10)
						setLoop: 8
						setCel: 3
						posn: 155 183
						addToPic:
					)
					((ScriptID 93 12)
						setLoop: 8
						setCel: 7
						posn: 170 180
						addToPic:
					)
				)
				(13
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 140 180
						addToPic:
					)
					((ScriptID 93 10)
						setLoop: 8
						setCel: 3
						posn: 155 183
						addToPic:
					)
					((ScriptID 93 12)
						setLoop: 8
						setCel: 7
						posn: 170 180
						addToPic:
					)
				)
			)
		)
		(if
			(and
				(== prevRoomNum 340)
				(== curRoomNum (RotundaRgn convRoom?))
			)
			(while (IsObjectOnControl ego 8)
				(ego x: (- (ego x?) 1) y: (- (ego y?) 1))
			)
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((not (user canControl:)))
			(
				(and
					(== currentAct 2)
					(IsObjectOnControl ego 8)
					(== curRoomNum (RotundaRgn convRoom?))
				)
				(RotundaRgn notify:)
			)
		)
	)
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 2370)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager
				say: noun theVerb (if (> currentAct 2) 1 else 2)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sExitEast of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setPri: 9 setMotion: MoveFwd 30 self)
			)
			(1
				(ego edgeHit: 2)
				(curRoom newRoom: (curRoom east?))
			)
		)
	)
)

(instance giftShoppeDoor of LbDoor
	(properties
		x 276
		y 145
		noun 9
		approachX 257
		approachY 149
		view 371
		entranceTo 400
		moveToX 300
		moveToY 145
		enterType 0
		exitType 0
	)
	
	(method (createPoly)
		(super createPoly: 255 140 271 140 288 152 273 152)
	)
)

(instance westExitFeature of ExitFeature
	(properties
		nsTop 94
		nsBottom 189
		nsRight 5
		cursor 12
		exitDir 4
		noun 4
	)
)

(instance tables of Feature
	(properties
		y 147
		noun 8
		sightAngle 40
	)
)

(instance column1 of Feature
	(properties
		x 35
		y 72
		noun 1
		nsTop 54
		nsLeft 30
		nsBottom 91
		nsRight 40
		sightAngle 40
	)
)

(instance column2 of Feature
	(properties
		x 100
		y 73
		noun 1
		nsTop 55
		nsLeft 95
		nsBottom 92
		nsRight 105
		sightAngle 40
	)
)

(instance column3 of Feature
	(properties
		x 168
		y 77
		noun 1
		nsTop 52
		nsLeft 163
		nsBottom 102
		nsRight 173
		sightAngle 40
	)
)

(instance column4 of Feature
	(properties
		x 231
		y 83
		noun 1
		nsTop 47
		nsLeft 226
		nsBottom 119
		nsRight 237
		sightAngle 40
	)
)

(instance column5 of Feature
	(properties
		x 312
		y 100
		noun 1
		nsTop 39
		nsLeft 305
		nsBottom 162
		nsRight 319
		sightAngle 40
	)
)

(instance bench of Feature
	(properties
		x 200
		y 116
		noun 2
		nsTop 108
		nsLeft 186
		nsBottom 120
		nsRight 214
		sightAngle 40
	)
)

(instance alcove of Feature
	(properties
		x 198
		y 87
		noun 3
		nsTop 51
		nsLeft 174
		nsBottom 118
		nsRight 223
		sightAngle 40
	)
)

(instance doorway of Feature
	(properties
		x 261
		y 101
		noun 9
		nsTop 54
		nsLeft 244
		nsBottom 139
		nsRight 278
		sightAngle 40
	)
	
	(method (doVerb)
		(giftShoppeDoor doVerb: &rest)
	)
)

(instance partyATP1 of View
	(properties
		x 104
		y 103
		noun 6
		view 374
		signal $4000
	)
	
	(method (init)
		(= cel
			(switch (Random 0 4)
				(0 2)
				(1 7)
				(2 24)
				(3 26)
				(4 29)
			)
		)
		(= loop (/ cel 16))
		(= cel (mod cel 16))
		(= scaleSignal 1)
		(= scaleY (= scaleX 75))
		(super init:)
	)
)

(instance partyATP2 of View
	(properties
		x 119
		y 105
		noun 6
		view 374
		signal $4000
	)
	
	(method (init)
		(= cel
			(switch (Random 0 5)
				(0 3)
				(1 4)
				(2 19)
				(3 25)
				(4 27)
				(5 31)
			)
		)
		(= loop (/ cel 16))
		(= cel (mod cel 16))
		(super init:)
	)
)

(instance partyATP3 of View
	(properties
		x 171
		y 133
		noun 6
		view 374
		signal $4000
	)
	
	(method (init)
		(= cel
			(switch (Random 0 1)
				(0 5)
				(1 28)
			))
		(= loop (/ cel 16))
		(= cel (mod cel 16))
		(super init:)
	)
)

(instance partyATP4 of View
	(properties
		x 190
		y 126
		noun 6
		view 374
		signal $4000
	)
	
	(method (init)
		(= cel
			(switch (Random 0 5)
				(0 0)
				(1 1)
				(2 12)
				(3 16)
				(4 21)
				(5 23)
			)
		)
		(= loop (/ cel 16))
		(= cel (mod cel 16))
		(super init:)
	)
)

(instance partyATP5 of View
	(properties
		x 226
		y 169
		noun 6
		view 374
		signal $4000
	)
	
	(method (init)
		(= cel
			(switch (Random 0 8)
				(0 6)
				(1 9)
				(2 10)
				(3 11)
				(4 13)
				(5 17)
				(6 18)
				(7 20)
				(8 30)
			)
		)
		(= loop (/ cel 16))
		(= cel (mod cel 16))
		(super init:)
	)
)

(instance partyATP6 of View
	(properties
		x 243
		y 177
		noun 6
		view 374
		cel 15
		signal $4000
	)
)
