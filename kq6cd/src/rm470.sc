;;; Sierra Script 1.0 - (do not remove this comment)
(script# 470)
(include sci.sh)
(use Main)
(use KQ6Room)
(use Kq6Procs)
(use Conv)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm470 0
)

(local
	local0
	local1
	local2
	[local3 34] = [5 1 1]
	[newSlimeBall 12]
	[newSlimeBall_2 6]
	local55
	local56
	local57
	local58
	local59
	local60
	local61 =  3
	local62
	[newACat 10]
	[local73 8] = [276 280 284 283 195 210 213 232]
	[local81 8] = [181 182 185 181 165 158 158 170]
	[local89 8] = [4701 4701 4701 4701 4701 4701 4701 4701]
	[local97 8] = [1 2 5 4 6 7 8 10]
	[newACat_2 5]
	[local110 3] = [273 279 230]
	[local113 3] = [179 179 168]
	[local116 3] = [4703 4703 4703]
	[local119 3] = [0 2 9]
	[local122 4] = [135 177 146 136]
	[local126 4] = [169 179 184 157]
	[local130 5] = [57 30 149 103 220]
	[local135 5] = [147 165 156 135 163]
	newProp
	newProp_3
	newProp_2
)
(procedure (localproc_00fe &tmp temp0)
	(= temp0 0)
	(while (< temp0 8)
		((= [newACat temp0] (aCat new:))
			view: [local89 temp0]
			loop: [local97 temp0]
			x: [local73 temp0]
			y: [local81 temp0]
			signal: 20480
			addToPic:
		)
		(++ temp0)
	)
)

(procedure (localproc_013c &tmp temp0)
	(= temp0 0)
	(while (< temp0 3)
		((= [newACat_2 temp0] (aCat new:))
			view: [local116 temp0]
			loop: [local119 temp0]
			x: [local110 temp0]
			y: [local113 temp0]
			signal: 20480 9
			init:
			stopUpd:
		)
		(++ temp0)
	)
)

(procedure (localproc_01d8 &tmp temp0)
	(= temp0 0)
	(while (< temp0 3)
		([newACat_2 temp0] stopUpd:)
		(++ temp0)
	)
)

(instance myConv of Conversation
	(properties)
)

(instance rm470 of KQ6Room
	(properties
		noun 3
		picture 470
		horizon 0
		walkOffEdge 1
		autoLoad 0
	)
	
	(method (init)
		(if
			(and
				debugging
				(== prevRoomNum 99)
				(FileIO fiEXISTS {g})
			)
			(ego get: 49 get: 46 get: 19 get: 11 get: 8)
		)
		(super init: &rest)
		(theGame handsOn:)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 223 189 129 165 141 151 213 151 319 170 319 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 189 0 140 85 161 88 167 53 170 54 174 121 174 137 181 131 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						319
						129
						124
						129
						172
						148
						89
						148
						52
						132
						70
						126
						67
						124
						44
						126
						39
						135
						0
						131
						0
						0
						319
						0
					yourself:
				)
		)
		(theMusic number: 470 setLoop: -1 play:)
		(features
			add: swamp1 swamp2 farTrees pathage milkers dogTree log
			eachElementDo: #init
		)
		(localproc_00fe)
		(localproc_013c)
		(bump init: stopUpd:)
		(cond 
			(
				(and
					(not (Btst 127))
					(== ((inventory at: 49) owner?) curRoomNum)
				)
				(mater
					view: 475
					z: 60
					posn: 274 189
					setLoop: 5
					cel: 6
					setPri: 5
					init:
					stopUpd:
				)
				((= [newSlimeBall 0] (slimeBall new:))
					x: 31
					y: 148
					setLoop: 0
					cel: 3
					setPri: 15
					init:
					addToPic:
				)
				((= [newSlimeBall 1] (slimeBall new:))
					x: 32
					y: 154
					setLoop: 1
					cel: 3
					setPri: 15
					init:
					addToPic:
				)
				(= global167 5)
				(= global168 5)
				(stick init: cue: 1)
				(= local55 2)
			)
			(
				(and
					(Btst 127)
					(== ((inventory at: 49) owner?) curRoomNum)
				)
				(= global167 5)
				(= global168 5)
				(stick init: cue: 1)
				(= local55 2)
			)
			((Btst 134) (stick init: cue: 0) (= local55 1))
			(else (stick init: cue: 1) (= local55 0))
		)
		(doggy init: stopUpd:)
		(ego
			init:
			scaleSignal: 4
			scaleX: 128
			scaleY: 128
			maxScale: 128
		)
		(curRoom setScript: egoEnters)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			((curRoom script?))
			((== (ego edgeHit?) 3) (curRoom setScript: walkOut 0 1))
			((<= (ego x?) 8) (curRoom setScript: walkOut 0 0))
			((== (ego onControl: 1) 2) (curRoom setScript: quagmire))
			(
			(and (ego inRect: 104 142 190 167) (not local2)) (= local2 1) (Load rsVIEW 4731) (Load rsMESSAGE 470))
			((and (== local0 5) (== local1 5))
				(= local0 6)
				(= local1 6)
				(theGame handsOff:)
				((= newProp (Prop new:))
					view: 476
					init:
					setScript: stepOnFrog
				)
			)
		)
		(Palette palANIMATE 64 68 -10)
	)
	
	(method (dispose)
		(DisposeScript 939)
		(super dispose:)
	)
)

(instance log of Feature
	(properties
		x 30
		y 165
		noun 14
		onMeCheck $0080
	)
)

(instance farTrees of Feature
	(properties
		x 168
		y 10
		noun 12
		onMeCheck $0008
	)
)

(instance pathage of Feature
	(properties
		noun 13
		onMeCheck $0040
	)
)

(instance dogTree of Feature
	(properties
		x 40
		y 17
		noun 5
		onMeCheck $0010
		approachX 80
		approachY 146
	)
	
	(method (init)
		(self approachVerbs: 5)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(++ local0)
				(messager say: 5 1 0 1)
			)
			(0 (messager say: 5 0 0 1))
			(2
				(curRoom setScript: bowWow 0 theVerb)
			)
			(5
				(curRoom setScript: bowWow 0 theVerb)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swamp1 of Feature
	(properties
		x 180
		y 10
		noun 6
		onMeCheck $0004
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(44 (messager say: 6 44 10 1))
			(0 (messager say: 6 0 0 1))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swamp2 of Feature
	(properties
		x 180
		y 10
		noun 6
		onMeCheck $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(44
				(cond 
					((Btst 68) (messager say: 6 44 12 1))
					((== local55 2) (messager say: 6 44 11))
					((= local55 1) (curRoom setScript: teaParty))
				)
			)
			(0 (messager say: 6 0 0 1))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance milkers of Feature
	(properties
		x 60
		y 120
		noun 9
		nsTop 96
		nsLeft 47
		nsBottom 117
		nsRight 89
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(5
				(if (ego has: 22)
					(++ local1)
					(messager say: 9 5 20 1)
				else
					(curRoom setScript: getMilk)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mater of Actor
	(properties
		noun 11
		view 475
		loop 6
		priority 15
		signal $4010
	)
)

(instance milkWeed of View
	(properties
		x 9
		y 117
		noun 9
		view 4701
		loop 5
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(5
				(if (ego has: 22)
					(messager say: 9 5 20 1)
				else
					(messager say: 9 5 19 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bump of Prop
	(properties
		x 28
		y 178
		z 25
		noun 7
		approachX 88
		approachY 177
		approachDist 20
		view 4700
		loop 1
		signal $5000
	)
	
	(method (init)
		(self approachVerbs: 2 setPri: 15)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(44
				(switch local55
					(0 (messager say: 7 44 13 1))
					(1 (messager say: 7 44 14 1))
					(else 
						(messager say: 7 44 15 1)
					)
				)
			)
			(1
				(switch local55
					(0 (messager say: 7 1 13 1))
					(1 (messager say: 7 1 14 1))
					(else  (messager say: 7 1 15 1))
				)
			)
			(5
				(switch local55
					(0 (messager say: 7 5 13 1))
					(1 (messager say: 7 5 14 1))
					(else  (messager say: 7 5 15 1))
				)
			)
			(2
				(cond 
					((== local55 2) (messager say: 7 5 15 1))
					((== local55 0) (messager say: 7 2 13 1))
					((== (++ global167) 1) (self setScript: fightTalk self))
					((== global167 2) (messager say: 7 2 26 0 stick))
					(else (messager say: 7 2 17 0 stick))
				)
			)
			(34
				(if ((ScriptID 40 0) stickTalk?)
					(= global168 3)
					(ego put: 49 bump)
					(curRoom setScript: bumpMaterToss)
				else
					(messager say: 7 34 18 1)
				)
			)
			(8 ;34
				(if (== local55 1)
					(messager say: 7 8 14 1)
				else
					(messager say: 7 0 13 1)
				)
			)
			(else 
				(switch local55
					(0 (messager say: 7 0 13 1))
					(1 (messager say: 7 0 14 0))
					(else  (messager say: 7 5 15 1))
				)
			)
		)
	)
)

(instance bumpArm of Prop
	(properties
		x 30
		y 150
		view 474
		loop 5
		priority 15
		signal $4010
	)
)

(instance stick of Prop
	(properties
		x 287
		y 189
		z 66
		noun 10
		approachDist 300
		view 4700
		loop 2
		priority 4
		signal $5010
		cycleSpeed 8
	)
	
	(method (init)
		(if
			(and
				((ScriptID 40 0) stickTalk?)
				(!= ((inventory at: 49) owner?) curRoomNum)
			)
			(self view: 475 setLoop: 1)
			(= local55 1)
		else
			(self cue:)
		)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(5
				(switch local55
					(0 (messager say: 10 5 13 1))
					(1 (messager say: 10 5 14 1))
					(else 
						(messager say: 10 5 15 1)
					)
				)
			)
			(1
				(switch local55
					(0 (messager say: 10 1 13 1))
					(1 (messager say: 10 1 14 1))
					(else 
						(messager say: 10 1 15 1)
					)
				)
			)
			(2
				(curRoom setScript: sTalkToStick)
			)
			(34
				(cond 
					((== local55 0) (messager say: 10 0 13 1))
					(local56 (ego put: 49 470) (curRoom setScript: egoMaterThrowAway))
					(else (curRoom setScript: egoMaterToss))
				)
			)
			(44
				(switch local55
					(0 (messager say: 10 44 13 1))
					(1 (messager say: 10 44 14 1))
					(else 
						(messager say: 10 44 15 1)
					)
				)
			)
			(else 
				(switch local55
					(0 (messager say: 10 0 13 1))
					(1 (messager say: 10 0 14 0))
					(else 
						(messager say: 10 0 15 1)
					)
				)
			)
		)
	)
	
	(method (cue param1)
		(self view: 4700 setLoop: 2 cel: param1 stopUpd:)
	)
)

(instance fightTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(myConv add: -1 7 2 16 1 add: -1 7 2 16 2 init: self)
			)
			(2 (ego cel: 2) (= cycles 2))
			(3
				(messager say: 7 2 16 3 self)
			)
			(4 (= cycles 2))
			(5
				(messager say: 7 2 16 4 self)
			)
			(6 (= cycles 2))
			(7
				(messager say: 7 2 16 5 self)
			)
			(8 (= cycles 2))
			(9
				(messager say: 7 2 16 6 self)
			)
			(10 (= cycles 2))
			(11
				(messager say: 7 2 16 7 self)
			)
			(12 (= cycles 2))
			(13
				(messager say: 7 2 16 8 self)
			)
			(14
				(ego reset:)
				(self dispose:)
			)
		)
	)
)

(instance stickTalking of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(myConv add: -1 10 2 22 1 add: -1 10 2 22 2 init: self)
			)
			(1 (ego cel: 2) (= cycles 2))
			(2
				(messager say: 10 2 22 3 self)
			)
			(3
				(theGame handsOn:)
				(ego reset:)
				(self dispose:)
			)
		)
	)
)

(instance slimeBall of Prop
	(properties
		noun 8
		approachX 87
		approachY 181
		approachDist 20
		view 4702
		loop 1
		signal $5810
	)
	
	(method (init)
		(self approachVerbs: 5 9)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(44
				(if (not (Btst 68))
					(curRoom setScript: getOoze)
				else
					(messager say: 6 44 12 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aCat of Prop
	(properties
		noun 4
		cycleSpeed 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(curRoom setScript: doPussy 0 2)
			)
			(5
				(curRoom setScript: doPussy 0 5)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doggy of Prop
	(properties
		x 25
		y 19
		noun 5
		view 4700
		priority 1
		signal $4010
		cycleSpeed 1
	)
)

(instance slime of Actor
	(properties
		yStep 36
		view 474
		loop 4
		signal $4000
		xStep 68
	)
)

(instance materSlime of Actor
	(properties
		yStep 36
		view 475
		signal $5010
		xStep 68
	)
)

(instance egoEnters of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(switch prevRoomNum
					(450
						(ego
							setLoop: 3
							posn: 162 249
							setMotion: MoveTo 165 185 self
						)
						(if (not (Random 0 1))
							((= newProp_2 (Prop new:))
								view: 476
								init:
								setScript: (Clone sFrogX)
							)
						)
					)
					(else 
						(ego
							setLoop: 0
							posn: -10 135
							setMotion: MoveTo 10 139 self
						)
						(if (not (Random 0 1))
							((= newProp_3 (Prop new:))
								view: 476
								init:
								setScript: (Clone sFrogY)
							)
						)
						(if (not (Random 0 1))
							((= newProp_2 (Prop new:))
								view: 476
								init:
								setScript: (Clone sFrogX)
							)
						)
					)
				)
			)
			(1
				(theGame handsOn:)
				(ego reset:)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(if register
					(ego setMotion: MoveTo (ego x?) 255 self)
				else
					(ego setMotion: MoveTo -25 (ego y?) self)
				)
			)
			(1
				(if register
					(curRoom newRoom: 450)
				else
					(curRoom newRoom: 480)
				)
			)
		)
	)
)

(instance getMilk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(stick stopUpd:)
				(bump stopUpd:)
				(ego setMotion: PolyPath 64 141 self)
			)
			(1
				(ego setHeading: 0)
				(UnLoad 128 474)
				(UnLoad 128 475)
				(= ticks 6)
			)
			(2
				(ego
					view: 472
					normal: 0
					loop: 1
					cel: 0
					posn: 64 141
					setCycle: EndLoop self
				)
			)
			(3
				(messager say: 9 5 19 1 self)
			)
			(4
				(if (not (Btst 130))
					(Bset 130)
					(theGame givePoints: 1)
				)
				(ego
					reset: 6
					posn: 53 133
					get: 22
					setMotion: PolyPath 79 145 self
				)
			)
			(5
				(ego setHeading: 335)
				(= cycles 8)
			)
			(6
				(self setScript: bowWow self 99)
			)
			(7
				(messager say: 9 5 19 2 self)
			)
			(8
				(theGame handsOn:)
				(ego reset: 3)
				(UnLoad 128 472)
				(self dispose:)
			)
		)
	)
)

(instance getOoze of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setHeading: 270 self)
			)
			(1
				(if (not (Btst 68)) (Bset 68) (theGame givePoints: 1))
				(ego
					view: 474
					setLoop: 10
					posn: 71 189
					cel: 0
					normal: 0
					setCycle: EndLoop self
				)
			)
			(2
				(messager say: 8 44 0 1 self)
			)
			(3 (ego setCycle: BegLoop self))
			(4
				(ego posn: 87 181 reset: 1 setMotion: MoveTo 107 167 self)
			)
			(5
				(theGame handsOn:)
				(ego setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance doPussy of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(if (== register 5)
					(messager say: 4 5 0 1 self)
				else
					(messager say: 4 2 0 1 self)
				)
			)
			(1
				(if (== register 5)
					(ego setMotion: PolyPath 205 186 self)
				else
					(self cue:)
				)
			)
			(2
				(if (== register 5)
					(ego setHeading: 135)
					(= ticks 6)
				else
					(self cue:)
				)
			)
			(3
				(theGlobalSound number: 473 setLoop: 1 play:)
				([newACat_2 0] view: 4701 startUpd: setCycle: EndLoop self)
			)
			(4
				(theGlobalSound number: 473 setLoop: 1 play:)
				([newACat_2 0] setCycle: BegLoop)
				([newACat_2 1] view: 4701 startUpd: setCycle: EndLoop self)
			)
			(5
				(theGlobalSound number: 473 setLoop: 1 play:)
				([newACat_2 1] setCycle: BegLoop)
				([newACat_2 2] view: 4701 startUpd: setCycle: EndLoop self)
			)
			(6
				(if (< local62 3)
					(++ local62)
					([newACat_2 2] setCycle: BegLoop)
					(= state (- state 4))
					(self cue:)
				else
					([newACat_2 2] setCycle: BegLoop self)
				)
			)
			(7
				(localproc_01d8)
				(if (== register 5) (ego setHeading: 315))
				(= cycles 10)
			)
			(8
				(if (== register 5)
					(self setScript: bowWow self 99)
				else
					(self cue:)
				)
			)
			(9
				(if (== register 5)
					(messager say: 4 5 0 2 self)
				else
					(self cue:)
				)
			)
			(10
				(theGame handsOn:)
				(= local62 0)
				(self dispose:)
			)
		)
	)
)

(instance teaParty of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				((ScriptID 40 0) stickTalk: 1)
				(cond 
					((>= local57 3) (messager say: 6 44 11 1) (self dispose:))
					((Btst 68) (messager say: 6 44 12 1) (self dispose:))
					(else (theGame handsOff:) (= ticks 4))
				)
			)
			(1
				(ego setMotion: PolyPath 132 155 self)
			)
			(2
				(ego
					view: 472
					setLoop: 0
					normal: 0
					cel: 0
					posn: (+ (ego x?) 6) (+ (ego y?) 4)
					cycleSpeed: 6
					setCycle: CycleTo 2 1 self
				)
			)
			(3
				(theGlobalSound number: 924 setLoop: 1 play:)
				(ego setCycle: EndLoop self)
			)
			(4
				(ego posn: (- (ego x?) 11) (- (ego y?) 8) reset: 4)
				(= ticks 4)
			)
			(5
				(ego
					setLoop: 4
					setMotion: MoveTo (- (ego x?) 6) (- (ego y?) 4)
				)
				(stick view: 475 setLoop: 1 setCycle: EndLoop self)
			)
			(6 (stick setCycle: BegLoop self))
			(7
				(if (== local57 0)
					(myConv
						add: -1 6 44 4 1
						add: -1 6 44 4 2
						add: -1 6 44 4 3
						init: self
					)
				else
					(self cue:)
				)
			)
			(8
				(switch (= temp0 (Random 0 2))
					(0
						(messager say: 6 44 8 1 self)
					)
					(1
						(messager say: 6 44 9 1 self)
					)
					(2
						(messager say: 6 44 7 1 self)
					)
				)
			)
			(9
				(switch local57
					(0
						(self setScript: teaTalk self 1)
					)
					(1
						(self setScript: teaTalk self 2)
					)
					(2
						(self setScript: teaTalk self 3)
					)
				)
			)
			(10
				(++ local57)
				(ego reset:)
				(stick setLoop: 2 setCycle: Oscillate 1 self)
				(= cycles 1)
			)
			(11
				(theGlobalSound number: 478 setLoop: 1 play:)
			)
			(12
				(theGame handsOn:)
				(stick cue: 0)
				(Bset 134)
				(self dispose:)
			)
		)
	)
)

(instance teaTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(switch register
					(1
						(messager say: 6 44 4 4 self)
					)
					(2
						(messager say: 6 44 5 1 self)
					)
					(3
						(messager say: 6 44 28 1 self)
					)
				)
			)
			(2 (= cycles 2))
			(3
				(switch register
					(1
						(messager say: 6 44 4 5 self)
					)
					(2
						(messager say: 6 44 5 2 self)
					)
					(3
						(messager say: 6 44 28 2 self)
					)
				)
			)
			(4 (= cycles 2))
			(5
				(switch register
					(1
						(messager say: 6 44 4 6 self)
					)
					(2
						(messager say: 6 44 5 3 self)
					)
					(3
						(messager say: 6 44 28 3 self)
					)
				)
			)
			(6 (self dispose:))
		)
	)
)

(instance backOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setMotion: PolyPath 155 186 self)
			)
			(1
				(ego setHeading: 0)
				(= cycles 2)
			)
			(2
				(ego view: 4702 setLoop: 2 normal: 0 setCycle: 0)
				(= cycles 2)
			)
			(3
				(Load rsVIEW 475)
				(self dispose:)
			)
		)
	)
)

(instance materTossSlime of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(UnLoad 128 474)
				(mater
					setLoop: 8
					cel: 0
					z: 0
					posn: 275 129
					setCycle: EndLoop self
				)
			)
			(1
				(mater cel: 0)
				(theGlobalSound number: 0 stop:)
				(= ticks 4)
			)
			(2
				(theGlobalSound number: 476 setLoop: 1 play:)
				(materSlime
					view: 475
					posn: 217 111
					ignoreActors:
					init:
					setLoop: 10
					cel: 0
					setPri: 15
				)
				(= ticks 4)
			)
			(3
				(materSlime posn: 172 109 forceUpd:)
				(= ticks 2)
			)
			(4
				(materSlime
					view: 4702
					setLoop: 1
					cel: 0
					posn: 121 108
					forceUpd:
				)
				(= ticks 2)
			)
			(5
				(materSlime posn: 87 119 forceUpd:)
				(= ticks 2)
			)
			(6
				(materSlime cel: 0 posn: 87 119 forceUpd:)
				(= ticks 4)
			)
			(7
				((= [newSlimeBall_2 local59] (slimeBall new:))
					x: 31
					y: 189
					z: 41
					setLoop: 0
					priority: 15
					init:
					setCycle: EndLoop self
				)
				(materSlime setCycle: 0 hide: dispose:)
			)
			(8
				([newSlimeBall_2 local59] addToPic:)
				(if (< local59 2) (++ local59) (= state (- state 9)))
				(self cue:)
			)
			(9
				(mater
					view: 475
					setLoop: 5
					cel: 6
					x: 274
					y: 189
					z: 60
					setPri: 5
					stopUpd:
				)
				(self dispose:)
			)
		)
	)
)

(instance egoMaterToss of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego setMotion: PolyPath 55 172 self)
			)
			(1
				(ego setHeading: 225)
				(= cycles 8)
			)
			(2
				(messager say: 10 34 24 0 self)
			)
			(3
				(theGame handsOn:)
				(= local56 1)
				(self dispose:)
			)
		)
	)
)

(instance egoMaterThrowAway of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(Bset 127)
				(messager say: 10 34 25 1 self)
			)
			(1
				(ego setMotion: PolyPath 108 149 self)
			)
			(2
				(ego view: 472 normal: 0 setLoop: 2 setCycle: EndLoop self)
				(theGlobalSound number: 0 stop:)
				(theGlobalSound number: 474 setLoop: 1 play:)
			)
			(3
				(ego posn: 108 149 reset: 0)
				(self setScript: egoMaterFlight self)
			)
			(4 (= cycles 8))
			(5
				(myConv
					add: -1 10 34 25 3
					add: -1 10 34 25 4
					add: -1 10 34 25 5
					add: -1 10 34 25 6
					add: -1 10 34 25 7
					add: -1 10 34 25 8
					add: -1 10 34 25 9
					add: -1 10 34 25 10
					add: -1 10 34 25 11
					init: self
				)
			)
			(6
				(theGame handsOn:)
				(= local55 2)
				(stick cue: 1)
				(= global168 2)
				(self dispose:)
			)
		)
	)
)

(instance egoMaterFlight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(mater posn: (+ (ego x?) 36) (- (ego y?) 61) init:)
				(= ticks 4)
			)
			(1
				(mater posn: (+ (mater x?) 31) (- (mater y?) 10))
				(= ticks 4)
			)
			(2
				(mater posn: (+ (mater x?) 31) (+ (mater y?) 2))
				(= ticks 4)
			)
			(3
				(mater posn: (+ (mater x?) 28) (+ (mater y?) 10))
				(= ticks 4)
			)
			(4
				(mater posn: (+ (mater x?) 18) (+ (mater y?) 13))
				(= ticks 4)
			)
			(5
				(mater posn: (+ (mater x?) 6) (+ (mater y?) 16))
				(= ticks 4)
			)
			(6
				(theGlobalSound number: 0 stop:)
				(theGlobalSound number: 475 setLoop: 1 play:)
				(mater posn: 266 131)
				(= ticks 12)
			)
			(7
				(mater setLoop: 5 posn: 274 130 cel: 0 setCycle: EndLoop self)
			)
			(8
				(mater setLoop: 6 posn: 266 131 startUpd: forceUpd:)
				(= cycles 4)
			)
			(9
				(messager say: 10 34 25 2 self)
			)
			(10
				(mater setLoop: 6 setMotion: MoveTo 270 140 self)
			)
			(11
				(mater setLoop: 9 posn: 279 139 cel: 0 setCycle: EndLoop self)
				(theGlobalSound number: 477 setLoop: 1 play:)
			)
			(12
				(mater dispose:)
				(= ticks 4)
			)
			(13
				(theGlobalSound number: 0 stop:)
				(self dispose:)
			)
		)
	)
)

(instance bowWow of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(switch register
					(2 (messager say: 5 2 0 1 self))
					(5 (messager say: 5 5 0 1 self))
					(else  (self cue:))
				)
			)
			(1 (doggy setCycle: EndLoop self))
			(2
				(theGlobalSound number: 0 stop:)
				(theGlobalSound number: 472 setLoop: 1 play:)
				(= ticks 30)
			)
			(3
				(doggy setCel: 1)
				(if (-- local61)
					(= state (- state 3))
				else
					(doggy setCycle: BegLoop)
				)
				(= ticks 30)
			)
			(4
				(if (== register 5)
					(messager say: 5 5 0 2 self)
				else
					(self cue:)
				)
			)
			(5
				(theGame handsOn:)
				(doggy stopUpd:)
				(= local61 3)
				(self dispose:)
			)
		)
	)
)

(instance theBattle of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(++ local58)
				(stick view: 475 setLoop: 4 cel: 0 setCycle: EndLoop self)
			)
			(1
				(theGlobalSound number: 0 stop:)
				(theGlobalSound number: 476 setLoop: 1 play:)
				(slime
					posn: (Random 248 252) (Random 88 92)
					illegalBits: 0
					ignoreActors:
					init:
					setLoop: 3
					cel: 0
					setPri: 15
					setCycle: Forward
					setMotion: MoveTo (Random 180 185) (Random 60 65) self
				)
			)
			(2
				(slime
					setMotion: MoveTo (Random 115 122) (Random 75 82) self
				)
			)
			(3
				(slime
					cel: 1
					setMotion: MoveTo (Random 68 74) (Random 110 115) self
				)
			)
			(4
				(if (mod local58 2) (= temp0 0) else (= temp0 1))
				((= [newSlimeBall local58] (slimeBall new:))
					view: 474
					x: (if temp0 31 else 28)
					y: (if temp0 189 else 188)
					z: (if temp0 41 else 35)
					setLoop: (if temp0 0 else 1)
					priority: 15
					init:
				)
				(if temp0
					([newSlimeBall local58] setCycle: EndLoop self)
				else
					(= cycles 4)
				)
				(slime setCycle: 0 dispose:)
				(stick cel: 0)
			)
			(5
				(if (< local58 2)
					([newSlimeBall local58] ignoreActors: 1 addToPic:)
					(self init:)
				else
					(theGlobalSound stop:)
					(ego reset: 3)
					(stick cue: 0)
					(= local60 1)
					(= local55 2)
					(self dispose:)
				)
			)
		)
	)
)

(instance bumpMaterToss of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(if (not (Btst 139))
					(Bset 139)
					(theGame givePoints: 3)
				)
				(ego setMotion: PolyPath 87 177 self)
			)
			(1
				(ego
					view: 474
					setLoop: 4
					cel: 0
					posn: 70 185
					normal: 0
					cycleSpeed: 8
					setCycle: EndLoop self
				)
			)
			(2
				(bumpArm
					init:
					view: 474
					setLoop: 5
					setCel: 0
					cycleSpeed: 6
					setCycle: CycleTo 2 1 self
				)
			)
			(3
				(ego reset: 1)
				(bumpArm setCycle: EndLoop self)
			)
			(4 (= cycles 2))
			(5
				(myConv
					add: -1 7 34 14 1
					add: -1 7 34 14 2
					add: -1 7 34 14 3
					add: -1 7 34 14 4
					add: -1 7 34 14 5
					add: -1 7 34 14 6
					init: self
				)
			)
			(6
				(ego setScript: backOut self)
			)
			(7
				(self setScript: bumpMaterFlight self)
			)
			(8
				(mater setScript: materTossSlime self)
				(self setScript: theBattle self)
			)
			(9)
			(10
				(stick cue: 0)
				(UnLoad 128 474)
				(UnLoad 128 475)
				(myConv
					add: -1 7 34 14 7
					add: -1 7 34 14 8
					add: -1 7 34 14 9
					add: -1 7 34 14 10
					add: -1 7 34 14 11
					init: self
				)
			)
			(11
				((inventory at: 49) owner: curRoomNum)
				(theGlobalSound number: 961 setLoop: 1 play:)
				(mater init: view: 4700 setLoop: 1 cel: 2)
				(slimeBall addToPic:)
				(= ticks 120)
			)
			(12
				(theGame handsOn:)
				(mater cel: 1 forceUpd:)
				(stick cue: 1)
				(= global168 2)
				(self dispose:)
			)
		)
	)
)

(instance bumpMaterFlight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bump hide:)
				(bumpArm
					view: 4741
					init:
					posn: 29 154
					setLoop: 0
					cel: 0
					setPri: 15
					ignoreActors: 1
					setCycle: EndLoop self
				)
			)
			(1 (= ticks 30))
			(2
				(bumpArm setLoop: 1 setCycle: Forward)
				(= seconds 3)
			)
			(3
				(bumpArm setLoop: 2 cel: 0 setCycle: EndLoop self)
			)
			(4
				(theGlobalSound number: 474 setLoop: 1 play:)
				(mater view: 475 loop: 6 posn: 61 145 init:)
				(bump show:)
				(bumpArm dispose:)
				(= ticks 4)
			)
			(5
				(mater posn: 85 118)
				(= ticks 4)
			)
			(6
				(mater posn: 121 97)
				(= ticks 4)
			)
			(7
				(mater posn: 153 82)
				(= ticks 4)
			)
			(8
				(mater posn: 193 78)
				(= ticks 4)
			)
			(9
				(mater posn: 230 83)
				(= ticks 4)
			)
			(10
				(mater posn: 260 90)
				(= ticks 4)
			)
			(11
				(theGlobalSound number: 0 stop:)
				(theGlobalSound number: 475 setLoop: 1 play:)
				(stick view: 475 setLoop: 11 cel: 0 setCycle: Forward)
				(mater posn: 280 97)
				(= ticks 4)
			)
			(12
				(mater posn: 270 108)
				(= ticks 4)
			)
			(13
				(mater posn: 263 131)
				(= ticks 4)
			)
			(14
				(stick view: 475 setLoop: 1 cel: 0 stopUpd:)
				(mater setLoop: 5 posn: 274 129 setCycle: EndLoop self)
			)
			(15
				(mater
					view: 475
					setLoop: 5
					cel: 6
					x: 274
					y: 189
					z: 60
					setPri: 5
				)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToStick of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(if (and (!= (ego x?) 121) (!= (ego y?) 147))
					(ego setMotion: PolyPath 121 147 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= register (GetAngle (ego x?) (ego y?) 292 135))
				(= cycles 2)
			)
			(2
				(if (!= (ego heading?) register)
					(Face ego 292 135 self)
				else
					(= cycles 2)
				)
			)
			(3 (= cycles 4))
			(4
				(++ global168)
				(cond 
					((== local55 0) (-- global168) (messager say: 10 2 13 1 self))
					((== global168 1) (self setScript: stickTalking self))
					((== global168 2) (messager say: 10 2 27 0 self))
					((!= ((inventory at: 49) owner?) curRoomNum) (messager say: 10 2 23 0 self))
					(else (messager say: 10 2 15 1 self))
				)
			)
			(5
				(if (== local55 1) (stick cue: 0) else (stick cue: 1))
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance quagmire of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(ego view: 4731 normal: 0 setLoop: 0 cel: 0 posn: 151 160)
				(= ticks 10)
			)
			(1
				(ego
					cycleSpeed: 8
					moveSpeed: 15
					setCycle: EndLoop self
					setMotion: MoveTo 211 131
				)
				(= cycles 2)
			)
			(2)
			(3 (messager say: 6 3 0 1 self))
			(4
				(theGlobalSound number: 0 stop:)
				(theGlobalSound number: 477 setLoop: -1 play:)
				(ego
					view: 473
					setMotion: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 12
				)
				(= cycles 2)
			)
			(5 (ego setCycle: EndLoop self))
			(6
				(ego setLoop: 1 cel: 0 cycleSpeed: 15 setCycle: EndLoop self)
			)
			(7 (messager say: 6 3 0 2 self))
			(8 (EgoDead 36))
		)
	)
)

(instance sFrogY of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					loop: 2
					cel: 0
					x: [local122 register]
					y: [local126 (= register (Random 0 3))]
					signal: 26640
				)
				(= cycles 1)
			)
			(1 (= cycles (Random 4 8)))
			(2
				(client setCycle: CycleTo 3 1 self)
			)
			(3
				(client
					posn: (client x?) (+ (client y?) 15)
					setCycle: EndLoop self
				)
			)
			(4
				(if (< (client y?) 195)
					(= state 0)
					(= cycles 1)
				else
					(client dispose:)
				)
			)
		)
	)
)

(instance sFrogX of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					loop: 1
					cel: 0
					x: [local130 register]
					y: [local135 (= register (Random 0 4))]
					signal: 26640
				)
				(= cycles 1)
			)
			(1 (= cycles (Random 4 8)))
			(2
				(if (OneOf register 0 1)
					(client setCycle: CycleTo 9 1 self)
				else
					(= state (+ state 2))
					(client setCycle: EndLoop self)
				)
			)
			(3
				(client
					posn: (+ (client x?) 66) (- (client y?) 8)
					cel: 0
				)
				(= cycles (Random 2 4))
			)
			(4 (client setCycle: EndLoop self))
			(5 (client dispose:))
		)
	)
)

(instance stepOnFrog of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					posn: 46 168
					cel: 0
					setLoop: 1
					setCycle: CycleTo 9 1 self
				)
			)
			(1
				(theGame handsOff:)
				(ego setMotion: PolyPath 103 160 self)
			)
			(2
				(theGlobalSound number: 475 setLoop: 1 play:)
				(client
					setLoop: 3
					posn: 109 164
					setPri: 1
					ignoreActors: 1
					addToPic:
				)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)
