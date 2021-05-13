;;; Sierra Script 1.0 - (do not remove this comment)
(script# 360)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use RotundaRgn)
(use Scaler)
(use Feature)
(use StopWalk)
(use Actor)
(use System)

(public
	rm360 0
)

(instance rm360 of LBRoom
	(properties
		noun 1
		picture 360
		style $000b
		east 350
	)
	
	(method (init &tmp [temp0 5])
		(ego init: normalize: 831 setScale: Scaler 95 0 190 0)
		(if (== currentAct 2)
			(self setRegions: 93)
			((ScriptID 2360 0) doit: (= obstacles (List new:)))
		else
			(self setRegions: 90)
		)
		(switch prevRoomNum
			(east
				(if (> (ego y?) 185) (ego y: 185))
			)
			(340 (= style 9))
			(else  (ego posn: 160 140))
		)
		(super init:)
		(theGame handsOn:)
		(eastExitFeature init:)
		(tables setOnMeCheck: 1 4096 init:)
		(column1 init:)
		(column2 init:)
		(column3 init:)
		(column4 init:)
		(column5 init:)
		(alcove init:)
		(bench init:)
		(if (== currentAct 2)
			(partyATP1 init: setScale: 170 addToPic:)
			(partyATP2 init: setScale: 170 addToPic:)
			(partyATP3 init: setScale: 170 addToPic:)
			(partyATP4 init: setScale: 170 addToPic:)
			(partyATP5 init: setScale: 170 addToPic:)
			(partyATP6 init: setScale: 170 addToPic:)
			(switch global128
				(0
					((ScriptID 93 4)
						setLoop: 8
						setCel: 2
						posn: 160 180
						addToPic:
					)
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 145 182
						addToPic:
					)
					((ScriptID 93 9)
						setLoop: 8
						setCel: 5
						posn: 180 180
						addToPic:
					)
				)
				(1
					((ScriptID 93 4)
						setLoop: 8
						setCel: 4
						posn: 157 180
						addToPic:
					)
					((ScriptID 93 5)
						setLoop: 8
						setCel: 0
						posn: 145 182
						addToPic:
					)
					((ScriptID 93 9)
						setLoop: 8
						setCel: 5
						posn: 185 180
						addToPic:
					)
					((ScriptID 93 11)
						setLoop: 8
						setCel: 2
						posn: 170 180
						addToPic:
					)
				)
				(2
					((ScriptID 93 11)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 0
						posn: 158 185
						addToPic:
					)
					((ScriptID 93 5)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 5
						posn: 180 182
						addToPic:
					)
				)
				(3
					((ScriptID 93 5)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 2
						posn: 165 182
						addToPic:
					)
					((ScriptID 93 9)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 5
						setScale: 170
						posn: 180 182
						addToPic:
					)
				)
				(4
					((ScriptID 93 4)
						setLoop: 8
						setCel: 2
						posn: 160 180
						addToPic:
					)
					((ScriptID 93 6)
						setLoop: 8
						setCel: 0
						posn: 145 182
						addToPic:
					)
					((ScriptID 93 9)
						setLoop: 8
						setCel: 5
						posn: 180 180
						addToPic:
					)
				)
				(5
					((ScriptID 93 4)
						setLoop: 8
						setCel: 2
						posn: 160 180
						addToPic:
					)
					((ScriptID 93 6)
						setLoop: 8
						setCel: 0
						posn: 145 182
						addToPic:
					)
					((ScriptID 93 9)
						setLoop: 8
						setCel: 5
						posn: 180 180
						addToPic:
					)
				)
				(6
					((ScriptID 93 1)
						setLoop: 8
						setCel: 1
						posn: 180 182
						addToPic:
					)
					((ScriptID 93 4)
						setLoop: 8
						setCel: 2
						posn: 160 180
						addToPic:
					)
					((ScriptID 93 6)
						setLoop: 8
						setCel: 0
						posn: 145 182
						addToPic:
					)
				)
				(7
					((ScriptID 93 1)
						setLoop: 8
						setCel: 1
						posn: 180 182
						addToPic:
					)
					((ScriptID 93 4)
						setLoop: 8
						setCel: 2
						posn: 160 180
						addToPic:
					)
					((ScriptID 93 6)
						setLoop: 8
						setCel: 0
						posn: 145 182
						addToPic:
					)
				)
				(8
					((ScriptID 93 1)
						setLoop: 8
						setCel: 1
						posn: 180 182
						addToPic:
					)
					((ScriptID 93 4)
						setLoop: 8
						setCel: 2
						posn: 160 180
						addToPic:
					)
					((ScriptID 93 6)
						setLoop: 8
						setCel: 0
						posn: 145 182
						addToPic:
					)
				)
				(9
					((ScriptID 93 1)
						setLoop: 8
						setCel: 1
						posn: 180 182
						addToPic:
					)
					((ScriptID 93 4)
						setLoop: 8
						setCel: 2
						posn: 160 180
						addToPic:
					)
					((ScriptID 93 6)
						setLoop: 8
						setCel: 0
						posn: 145 182
						addToPic:
					)
				)
				(10
					((ScriptID 93 11)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 0
						posn: 155 182
						addToPic:
					)
					((ScriptID 93 4)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 5
						setScale: 170
						posn: 166 179
						addToPic:
					)
					((ScriptID 93 1)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 5
						posn: 180 182
						addToPic:
					)
				)
				(11
					((ScriptID 93 6)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 4
						posn: 155 182
						addToPic:
					)
					((ScriptID 93 11)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 2
						posn: 170 185
						addToPic:
					)
				)
				(12
					((ScriptID 93 6)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 4
						posn: 150 185
						addToPic:
					)
					((ScriptID 93 9)
						setCycle: StopWalk -1
						setLoop: 8
						setCel: 5
						setScale: 170
						posn: 165 182
						addToPic:
					)
				)
				(13
					((ScriptID 93 1)
						setLoop: 8
						setCel: 1
						posn: 180 182
						addToPic:
					)
					((ScriptID 93 4)
						setLoop: 8
						setCel: 2
						posn: 160 180
						addToPic:
					)
					((ScriptID 93 9)
						setLoop: 8
						setCel: 0
						posn: 145 182
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
		(DisposeScript 2360)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(messager
				say: noun theVerb (if (> currentAct 2) 2 else 1)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		nsTop 94
		nsLeft 315
		nsBottom 189
		nsRight 320
		cursor 14
		exitDir 2
		noun 8
	)
)

(instance tables of Feature
	(properties
		y 147
		noun 7
		sightAngle 40
	)
)

(instance column1 of Feature
	(properties
		x 5
		y 93
		noun 2
		nsTop 32
		nsBottom 155
		nsRight 11
		sightAngle 40
	)
)

(instance column2 of Feature
	(properties
		x 86
		y 78
		noun 2
		nsTop 43
		nsLeft 80
		nsBottom 113
		nsRight 92
		sightAngle 40
	)
)

(instance column3 of Feature
	(properties
		x 149
		y 72
		noun 2
		nsTop 47
		nsLeft 145
		nsBottom 97
		nsRight 154
		sightAngle 40
	)
)

(instance column4 of Feature
	(properties
		x 218
		y 68
		noun 2
		nsTop 49
		nsLeft 214
		nsBottom 88
		nsRight 223
		sightAngle 40
	)
)

(instance column5 of Feature
	(properties
		x 283
		y 68
		noun 2
		nsTop 49
		nsLeft 278
		nsBottom 87
		nsRight 288
		sightAngle 40
	)
)

(instance alcove of Feature
	(properties
		x 119
		y 78
		noun 3
		nsTop 45
		nsLeft 94
		nsBottom 111
		nsRight 145
		sightAngle 40
	)
)

(instance bench of Feature
	(properties
		x 115
		y 111
		noun 4
		nsTop 111
		nsLeft 100
		nsBottom 117
		nsRight 130
		sightAngle 40
	)
)

(instance partyATP1 of View
	(properties
		x 216
		y 113
		noun 5
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
		(super init:)
	)
)

(instance partyATP2 of View
	(properties
		x 231
		y 115
		noun 5
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
		x 119
		y 133
		noun 5
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
		x 138
		y 126
		noun 5
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
		x 84
		y 169
		noun 5
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
		x 101
		y 177
		noun 5
		view 374
		cel 15
		signal $4000
	)
)
