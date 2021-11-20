;;; Sierra Script 1.0 - (do not remove this comment)
(script# 711)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	sClimbDown 0
	sClimbUp 1
	sLeviDown 2
	sLeviUp 3
	sLeviDownRt 4
	sLeviUpRt 5
)

(local
	gTheObj_2CycleSpeed
)
(instance sClimbDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(Bset 388)
				(= gTheObj_2CycleSpeed (ego cycleSpeed?))
				(ego setMotion: PolyPath 97 96 self)
			)
			(1
				((ScriptID 710 2) setPri: 185)
				(ego setPri: 185 setHeading: 90 self)
			)
			(2
				(ego
					view: 4
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(grapnel loop: 6 setCel: 7 setPri: 184 x: 97 y: 140 init:)
				(ego setCycle: Beg self)
			)
			(4
				(ego view: 7 loop: 5 cel: 11 x: 99 setCycle: Beg self)
			)
			(5
				(ego
					view: 7
					loop: 1
					cel: 5
					x: 106
					y: 139
					setCycle: Beg self
				)
			)
			(6
				(ego cel: 5 y: 151 setCycle: Beg self)
			)
			(7
				(ego cel: 5 y: 163 setCycle: Beg self)
			)
			(8
				(grapnel hide:)
				(ego
					x: 107
					y: 160
					normalize: 3
					setPri: 185
					cycleSpeed: gTheObj_2CycleSpeed
					setMotion: MoveTo 70 170 self
				)
			)
			(9
				(ego setMotion: MoveTo 80 178 self)
			)
			(10
				(ego
					view: 4
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(11
				(grapnel x: 86 y: 222 show:)
				(ego setCycle: Beg self)
			)
			(12
				(ego
					view: 7
					loop: 5
					cel: 11
					x: 92
					y: 179
					setCycle: Beg self
				)
			)
			(13
				(ego loop: 1 cel: 11 x: 95 y: 223 setCycle: Beg self)
			)
			(14
				(ego cel: 11 x: 95 y: 233 setCycle: Beg self)
			)
			(15
				(ego hide:)
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(= seconds 2)
			)
			(16
				(grapnel dispose:)
				(ego
					show:
					normalize: 3
					setPri: 152
					cycleSpeed: gTheObj_2CycleSpeed
					x: 145
					y: 240
				)
				((ScriptID 710 2) setPri: 152)
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								-300
								489
								-300
								-300
								619
								-300
								619
								489
								150
								489
								150
								184
								266
								185
								284
								161
								258
								161
								221
								161
								210
								154
								210
								140
								173
								140
								167
								163
								146
								163
								127
								489
							yourself:
						)
				)
				(= cycles 2)
			)
			(17
				(ego setMotion: MoveTo 177 171 self)
			)
			(18
				(self setScript: (ScriptID 710 3) self)
			)
			(19
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(Bclr 388)
				(ego setMotion: MoveTo 145 240 self)
			)
			(1
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(grapnel posn: 86 222 setPri: 184 init:)
				(= seconds 2)
			)
			(2
				((ScriptID 710 2) setPri: 185)
				(= gTheObj_2CycleSpeed (ego cycleSpeed?))
				(ego
					view: 7
					loop: 1
					cel: 11
					x: 95
					y: 233
					setPri: 190
					cycleSpeed: 12
					setPri: 185
					setCycle: End self
				)
			)
			(3
				(ego cel: 0 x: 95 y: 223 setCycle: End self)
			)
			(4
				(ego loop: 5 cel: 0 x: 80 y: 179 setCycle: End self)
			)
			(5
				(ego
					view: 4
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(6
				(grapnel hide:)
				(ego setCycle: Beg self)
			)
			(7
				(ego
					x: 80
					y: 178
					normalize: 0
					cycleSpeed: gTheObj_2CycleSpeed
					setPri: 185
					setMotion: MoveTo 107 160 self
				)
			)
			(8
				(grapnel show: loop: 6 setCel: 7 x: 97 y: 140)
				(ego
					view: 7
					loop: 1
					cel: 0
					x: 106
					y: 163
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(9
				(ego cel: 0 y: 151 setCycle: End self)
			)
			(10
				(ego cel: 0 y: 139 setCycle: End self)
			)
			(11
				(ego
					view: 7
					loop: 4
					cel: 0
					x: 106
					y: 95
					setCycle: End self
				)
			)
			(12
				(ego posn: 97 96 setHeading: 270 self)
			)
			(13
				(ego view: 4 loop: 0 cel: 0 setCycle: End self)
			)
			(14
				(grapnel dispose:)
				(ego setCycle: Beg self)
			)
			(15
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								8
								105
								60
								94
								110
								94
								106
								88
								138
								88
								164
								74
								131
								74
								113
								65
								59
								65
								28
								47
								94
								-300
								619
								-300
								619
								489
								-300
								489
								-300
								-300
								20
								-300
								46
								24
								14
								48
								32
								62
								8
								69
							yourself:
						)
						((Polygon new:)
							type: 2
							init: 102 68 112 75 109 86 27 88 17 78 29 68
							yourself:
						)
				)
				((ScriptID 710 2) setPri: -1)
				(ego
					normalize: 0
					cycleSpeed: gTheObj_2CycleSpeed
					setMotion: PolyPath 129 82 self
				)
			)
			(16
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeviDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(Bset 388)
				(ego setMotion: PolyPath 109 95 self)
			)
			(1
				((ScriptID 710 2) setPri: 180)
				(ego
					view: 7
					loop: 5
					cel: 11
					posn: 107 94
					setPri: 180
					setCycle: Beg self
				)
			)
			(2
				(theMusic2 number: 941 play:)
				(sparklies init: setCycle: Fwd)
				(ego
					view: 17
					setLoop: 3 1
					cel: 5
					posn: 109 127
					setMotion: MoveTo 109 159 self
				)
			)
			(3
				(theMusic2 fade:)
				(sparklies hide:)
				(ego setLoop: -1 setCycle: Beg self)
			)
			(4
				(ego
					normalize: 7
					setPri: 180
					setMotion: MoveTo 86 178 self
				)
			)
			(5
				(ego
					view: 7
					loop: 5
					cel: 11
					posn: 84 177
					setCycle: Beg self
				)
			)
			(6
				(theMusic2 number: 941 play:)
				(sparklies show:)
				(ego
					view: 17
					setLoop: 3 1
					cel: 5
					posn: 87 212
					setMotion: MoveTo 87 252 self
				)
			)
			(7
				(theMusic2 fade:)
				(sparklies dispose:)
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(= cycles 2)
			)
			(8
				(ego
					normalize: 3
					setPri: 152
					cycleSpeed: gTheObj_2CycleSpeed
					x: 145
					y: 240
				)
				((ScriptID 710 2) setPri: 152)
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								-300
								489
								-300
								-300
								619
								-300
								619
								489
								150
								489
								150
								184
								266
								185
								284
								161
								258
								161
								221
								161
								210
								154
								210
								140
								173
								140
								167
								163
								146
								163
								127
								489
							yourself:
						)
				)
				(= cycles 2)
			)
			(9
				(ego setMotion: MoveTo 145 173 self)
			)
			(10
				(self setScript: (ScriptID 710 3) self)
			)
			(11
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeviUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: MoveTo 145 240 self)
			)
			(1
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(= cycles 2)
			)
			(2
				(theMusic2 number: 941 play:)
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								8
								105
								60
								94
								110
								94
								106
								88
								138
								88
								164
								74
								131
								74
								113
								65
								59
								65
								28
								47
								94
								-300
								619
								-300
								619
								489
								-300
								489
								-300
								-300
								20
								-300
								46
								24
								14
								48
								32
								62
								8
								69
							yourself:
						)
						((Polygon new:)
							type: 2
							init: 102 68 112 75 109 86 27 88 17 78 29 68
							yourself:
						)
				)
				((ScriptID 710 2) setPri: 180)
				(sparklies init: setCycle: Fwd)
				(ego
					view: 17
					setLoop: 3 1
					cel: 5
					posn: 87 252
					setPri: 180
					setMotion: MoveTo 87 212 self
				)
			)
			(3
				(theMusic2 fade:)
				(sparklies hide:)
				(ego
					view: 7
					loop: 5
					cel: 0
					posn: 84 177
					setCycle: End self
				)
			)
			(4
				(ego
					normalize: 3
					posn: 86 178
					setPri: 180
					setMotion: MoveTo 109 159 self
				)
			)
			(5
				(theMusic2 number: 941 play:)
				(ego view: 17 setLoop: 3 1 cel: 0 setCycle: End self)
			)
			(6
				(sparklies show:)
				(ego setMotion: MoveTo 109 127 self)
			)
			(7
				(theMusic2 fade:)
				(sparklies dispose:)
				(ego
					view: 7
					loop: 5
					cel: 0
					posn: 107 94
					setCycle: End self
				)
			)
			(8
				((ScriptID 710 2) setPri: -1)
				(ego normalize: 3)
				(theGame handsOn:)
				(Bclr 388)
				(self dispose:)
			)
		)
	)
)

(instance sLeviDownRt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(Bset 388)
				(ego setMotion: PolyPath 282 64 self)
			)
			(1
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				((ScriptID 710 2) setPri: 180)
				(ego setHeading: 315 self)
			)
			(2
				(theMusic2 number: 941 play:)
				(ego
					view: 17
					setLoop: 3 1
					cel: 0
					posn: 279 64
					setCycle: End self
				)
			)
			(3
				(sparklies init: setCycle: Fwd)
				(ego cel: 5 setPri: 180 setMotion: MoveTo 279 164 self)
			)
			(4
				(theMusic2 fade:)
				(sparklies dispose:)
				(ego setPri: 154 setCycle: Beg self)
			)
			(5
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								-300
								489
								-300
								-300
								619
								-300
								619
								489
								150
								489
								150
								184
								266
								185
								284
								161
								258
								161
								221
								161
								210
								154
								210
								140
								173
								140
								167
								163
								146
								163
								127
								489
							yourself:
						)
				)
				(ego normalize: 7)
				((ScriptID 710 2) setPri: -1)
				(= cycles 2)
			)
			(6
				(ego setPri: 152 setHeading: 270 self)
			)
			(7
				(self setScript: (ScriptID 710 3) self)
			)
			(8
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeviUpRt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath 281 164 self)
			)
			(1
				((curRoom obstacles?) dispose:)
				(curRoom obstacles: 0)
				(ego setHeading: 315 self)
			)
			(2
				(theMusic2 number: 941 play:)
				((ScriptID 710 2) setPri: 180)
				(ego
					view: 17
					setLoop: 3 1
					cel: 0
					posn: 279 164
					setCycle: End self
				)
			)
			(3
				(sparklies init: setCycle: Fwd)
				(ego setPri: 180 setMotion: MoveTo 279 64 self)
			)
			(4
				(theMusic fade:)
				(sparklies dispose:)
				(ego setPri: -1 setCycle: Beg self)
			)
			(5
				(curRoom
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								271
								47
								293
								58
								271
								64
								286
								68
								304
								63
								315
								45
								293
								36
								619
								11
								619
								489
								-300
								489
								-300
								-300
								267
								-300
								302
								19
								284
								35
								241
								37
								248
								43
								202
								43
								202
								47
							yourself:
						)
				)
				((ScriptID 710 2) setPri: -1)
				(ego posn: 283 64 normalize: 7 setHeading: 90 self)
			)
			(6
				(theGame handsOn:)
				(Bclr 388)
				(self dispose:)
			)
		)
	)
)

(instance sparklies of Prop
	(properties
		priority 182
		fixPriority 1
		view 17
		loop 4
		signal $4001
	)
	
	(method (init)
		(self setScaler: ego)
		(super init: &rest)
	)
	
	(method (doit)
		(= x (ego x?))
		(= y (ego y?))
		(super doit: &rest)
	)
)

(instance grapnel of View
	(properties
		sightAngle 180
		view 8
		loop 6
		cel 7
		signal $4000
	)
)
