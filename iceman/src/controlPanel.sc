;;; Sierra Script 1.0 - (do not remove this comment)
(script# 27)
(include sci.sh)
(use Main)
(use Intrface)
(use subMarine)
(use n370)
(use n396)
(use Submarine_806)
(use DigitalGauge)
(use EgoDead)
(use Cat)
(use Sight)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	controlPanel 0
	tV 1
	mBut 2
	butSnd 3
	positionBlip 4
	minuteDG 5
	hourDG 6
)

(local
	local0
	local1
	submarineRoll
	submarinePitch_2
	local4
	local5
	[local6 6] = [5 0 5 20 40 60]
)
(procedure (localproc_0e92 param1)
	(if param1
		(silentRunInd setCycle: sVForward)
		(Submarine flags: (| (Submarine flags?) $0040))
		(self setCel: 2)
	else
		(silentRunInd setCycle: sVEndLoop silentRunInd)
		(self setCel: 1)
		(Submarine flags: (& (Submarine flags?) $ffbf))
	)
)

(procedure (localproc_21a5)
	(missleSelector
		setCel: (mod (+ (missleSelector cel?) 1) 3)
	)
	(= local1 0)
)

(procedure (localproc_21c4)
	(if
		(switch (missleSelector cel?)
			(0 (Submarine misslesLeft?))
			(1 (Submarine decoysLeft?))
			(2 (Submarine torpedosLeft?))
		)
		(= local1 1)
		(if (OneOf ((subMarine script?) state?) 14 9 5)
			(SubPrint 4 27 6)
		else
			(Print 27 7)
		)
	else
		(SubPrint 4 27 8)
	)
)

(procedure (localproc_2252)
	(tV setPri: (if (!= (tV priority?) 15) 15 else 13))
)

(procedure (localproc_2272 param1)
	(cond 
		(
		(and (& (Submarine flags?) $0100) (not local0))
			(switch (missleSelector cel?)
				(0
					(if (Submarine misslesLeft?)
						(Submarine misslesLeft: (- (Submarine misslesLeft?) 1))
					else
						(Print 27 9)
						(return)
					)
				)
				(1
					(if (Submarine decoysLeft?)
						(Submarine decoysLeft: (- (Submarine decoysLeft?) 1))
					else
						(Print 27 10)
						(return)
					)
				)
				(2
					(if (Submarine torpedosLeft?)
						(Submarine
							torpedosLeft: (- (Submarine torpedosLeft?) 1)
						)
					else
						(Print 27 11)
						(return)
					)
				)
			)
			(= local0 (+ 3 (* 6 howFast)))
			(torpSnd play:)
			(curRoom
				handleEvent:
					(param1
						type: 1024
						message: (missleSelector cel?)
						modifiers: local1
						yourself:
					)
			)
			(= local1 0)
		)
		(
		(not (OneOf ((subMarine script?) state?) 14 9 5)) (Print 27 7))
		((== ((subMarine script?) state?) 5) (EgoDead 7 0 0 27 12))
		((not (& (Submarine flags?) $0100)) (Print 27 13))
	)
)

(instance controlPanel of Rm
	(properties
		picture 27
		horizon 1
	)
	
	(method (init &tmp newEvent)
		(Submarine lastH: gLastH lastM: gLastM)
		(engSnd init:)
		(butSnd init:)
		(tV init:)
		(super init:)
		(= local4 (theGame setSpeed: 1))
		(wheel init: posn: (Submarine wheelX?))
		(directionHandler add: wheel)
		(HandsOn)
		(sqSon init: setCel: 16)
		(vSLine1 init:)
		(vSLine2 init:)
		(if howFast
			(scanPanelBlip init: setScript: scanLightsScript)
		)
		(mBut init:)
		(bBut init:)
		(bBORide init:)
		(strnBORide init:)
		(pbORide init:)
		(sbORide init:)
		(bBalLights init:)
		(strnBalLights init:)
		(pBalLights init:)
		(sBalLights init:)
		(bowPIndBot init:)
		(bowPIndTop init:)
		(sternPIndTop init:)
		(sternPIndBot init:)
		(bankTurnInd init:)
		(diveLever init: posn: 277 (Submarine diveLeverY?))
		(directionHandler add: diveLever)
		(engineLever init:)
		(rpmLights init:)
		(sonarSwitch init:)
		(if (& (Submarine flags?) $0080)
			(sonarSwitch
				handleEvent: ((= newEvent (Event new:)) type: 4 message: 22016)
			)
			(newEvent dispose:)
		)
		(silentSwitch init:)
		(diveIndLights init: stopUpd:)
		(eBalGauge init:)
		(ebs init: hide:)
		(positionBlip init:)
		(compassNeedle init:)
		(Load rsFONT 100)
		(hatch1Ind
			init:
			setCel: (if (& (Submarine flags?) $0008) 3 else 4)
		)
		(silentRunInd init:)
		(torpSnd init:)
		(fCPanel init:)
		(missleSelector init: hide:)
		(keyDownHandler
			add: mBut bBut sonarSwitch silentSwitch fCPanel
		)
		(mouseDownHandler
			release:
			add:
				mBut
				bBut
				sonarSwitch
				silentSwitch
				fCPanel
				wheel
				diveLever
				engineLever
		)
		(= gLastH (Random 10 23))
		(= gLastM (Random 10 40))
		(Submarine lastH: gLastH lastM: gLastM)
		(self replay: setRegions: 314)
		(if (& (subMarine roomFlags?) $8000)
			(EgoDead 918 0 0 27 0)
			(return)
		)
		(switch (((ScriptID 314) script?) state?)
			(0
				(Submarine flags: (| (Submarine flags?) $0008))
				(subMarine cue:)
				(self setScript: (ScriptID 373))
			)
			(5
				(self setScript: (ScriptID 349))
			)
			(6
				(self setScript: (ScriptID 347))
			)
			(8
				(subMarine cue: 1)
				(ScriptID 396)
				(self setScript: (ScriptID 348))
			)
			(11
				(self setScript: (ScriptID 344))
			)
			(12
				(self setScript: (ScriptID 344))
			)
			(13
				(subMarine cue:)
				(ScriptID 396)
				(self setScript: (ScriptID 397))
			)
			(14
				(ScriptID 396)
				(self setScript: (ScriptID 397))
			)
		)
		(if
		(not (if (positionBlip x?) (positionBlip y?)))
			(positionBlip dispose:)
		)
	)
	
	(method (doit &tmp userCurEvent theGLastM)
		(super doit:)
		(depthDG doit:)
		(speedDG doit:)
		(tempDG doit:)
		(rpmDG doit:)
		(compassDG doit:)
		(latDG doit:)
		(longDG doit:)
		(if
		(== ((= userCurEvent (User curEvent?)) type?) 4)
			(engineLever handleEvent: userCurEvent)
		)
		(if
			(!=
				(= theGLastM (>> (& (GetTime 1) $0fc0) $0006))
				gLastM
			)
			(= gLastM theGLastM)
			(if (> (= theGLastM (+ (Submarine lastM?) 1)) 60)
				(= theGLastM (mod theGLastM 60))
				(Submarine lastH: (+ (Submarine lastH?) 1))
				(hourDG doit:)
			)
			(Submarine lastM: theGLastM)
			(minuteDG doit:)
		)
	)
	
	(method (dispose)
		(cls)
		(keyDownHandler
			delete: mBut bBut sonarSwitch silentSwitch
		)
		(mouseDownHandler release: add: cast features)
		(theGame setSpeed: local4)
		(depthDG dispose:)
		(speedDG dispose:)
		(tempDG dispose:)
		(rpmDG dispose:)
		(compassDG dispose:)
		(latDG dispose:)
		(longDG dispose:)
		(hourDG dispose:)
		(minuteDG dispose:)
		(super dispose:)
		(DisposeScript 816)
		(DisposeScript 808)
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((Said 'stand,exit,exit,get[<up][/room,panel]') (DisposeScript 370) (self newRoom: 25))
			(
			(or (Said 'look/panel,control') (Said 'look[<around]')) (Print 27 1) (Print 27 2))
			((Said 'close/hatch')
				(if (& (Submarine flags?) $0008)
					(Print 27 3)
					(Submarine flags: (& $fff7 (Submarine flags?)))
					(hatch1Ind setCel: 4)
				else
					(Print 27 4)
				)
			)
		)
	)
	
	(method (replay)
		(RedrawControlPanel)
		(PicNotValid 1)
		(depthDG init: Submarine 352)
		(speedDG init: Submarine 358)
		(rpmDG init: Submarine 362)
		(tempDG init: Submarine 369)
		(hourDG init: Submarine 370)
		(minuteDG init: Submarine 371)
		(compassDG init: Submarine 353)
		(latDG init: Submarine 364)
		(longDG init: Submarine 363)
	)
)

(instance srForward of Fwd
	(properties)
)

(instance butSnd of Sound
	(properties
		number 47
		priority 3
	)
)

(instance engSnd of Sound
	(properties
		number 54
		priority 2
	)
)

(instance depthDG of DigitalGauge
	(properties
		x 245
		y 36
	)
)

(instance tempDG of DigitalGauge
	(properties
		x 245
		y 46
	)
)

(instance hourDG of DigitalGauge
	(properties
		x 231
		y 56
	)
)

(instance minuteDG of DigitalGauge
	(properties
		x 245
		y 56
	)
)

(instance speedDG of DigitalGauge
	(properties
		x 245
		y 66
	)
)

(instance rpmDG of DigitalGauge
	(properties
		x 245
		y 77
	)
)

(instance compassDG of DigitalGauge
	(properties
		x 77
		y 90
	)
)

(instance latDG of DigitalGauge
	(properties
		x 124
		y 108
	)
)

(instance longDG of DigitalGauge
	(properties
		x 157
		y 108
	)
)

(instance wheel of Cat
	(properties
		y 163
		x 158
		view 127
		loop 8
		cel 6
		priority 15
		signal $0010
	)
	
	(method (dispose)
		(directionHandler delete: self)
		(Submarine wheelX: x)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event message?)
			(JOY_LEFT
				(self posn: (- x 16))
			)
			(JOY_RIGHT
				(self posn: (+ x 14))
			)
		)
	)
	
	(method (posn param1 &tmp temp0)
		(cond 
			((<= param1 109) (= x 109) (= y 188) (= cel 0))
			((<= param1 122) (= x 122) (= y 178) (= cel 1))
			((<= param1 125) (= x 125) (= y 175) (= cel 2))
			((<= param1 128) (= x 128) (= y 171) (= cel 3))
			((<= param1 136) (= x 136) (= y 167) (= cel 4))
			((<= param1 144) (= x 144) (= y 165) (= cel 5))
			((<= param1 158) (= x 158) (= y 163) (= cel 6))
			((<= param1 174) (= x 174) (= y 165) (= cel 7))
			((<= param1 181) (= x 181) (= y 167) (= cel 8))
			((<= param1 189) (= x 189) (= y 171) (= cel 9))
			((<= param1 192) (= x 192) (= y 175) (= cel 10))
			(else (= x 204) (= y 187) (= cel 11))
		)
		(super posn: x y)
		(Submarine
			turn: (- (AngleDiff 0 (GetAngle 158 215 x y)))
		)
	)
)

(instance sqSon of Prop
	(properties
		y 84
		x 210
		view 27
		priority 12
		signal $0011
	)
	
	(method (cue)
		(self cel: 0 setCycle: sSEndLoop)
	)
)

(instance sSEndLoop of End
	(properties)
)

(instance sonarSwitch of View
	(properties
		y 159
		x 193
		view 227
		loop 3
		cel 3
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			(
			(or (MousedOn self event) (== (event message?) 22016))
				(event claimed: 1)
				(butSnd number: (SoundFX 47) play:)
				(if (== cel 3)
					(self setCel: 4)
					(globalSound number: 43 play: sqSon)
					(sqSon setCycle: swEndLoop)
					(vSLine1 setScript: vSonarScript)
					(Submarine flags: (| (Submarine flags?) $0080))
				else
					(self setCel: 3)
					(globalSound client: 0 number: 11 play:)
					(sqSon setCel: 16 stopUpd:)
					(vSLine1 setScript: 0 hide:)
					(vSLine2 hide:)
					(Submarine flags: (& (Submarine flags?) $ff7f))
				)
			)
		)
	)
)

(instance swEndLoop of End
	(properties)
)

(instance vSonarScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(vSLine1 y: 46 show: setCycle: topScanCycle)
				(vSLine2 y: 46 show: setCycle: bottomScanCycle)
				(= cycles 2)
			)
			(1
				(vSLine1 setMotion: vS1MoveTo (vSLine1 x?) 36 self)
				(vSLine2 setMotion: vS2MoveTo (vSLine2 x?) 56 self)
			)
			(2)
			(3 (self init:))
		)
	)
)

(instance vS1MoveTo of MoveTo
	(properties)
)

(instance vS2MoveTo of MoveTo
	(properties)
)

(instance bottomScanCycle of Cycle
	(properties)
	
	(method (doit)
		(if
			(>
				(* (- (client y?) 46) 10)
				(- (Submarine floor?) (Submarine _depth?))
			)
			(client cel: 2)
		else
			(client cel: 1)
		)
	)
)

(instance topScanCycle of Cycle
	(properties)
	
	(method (doit)
		(if
			(>
				(* (- 46 (client y?)) 10)
				(- (Submarine _depth?) (Submarine ceiling?))
			)
			(client cel: 3)
		else
			(client cel: 1)
		)
	)
)

(instance silentSwitch of View
	(properties
		y 157
		x 204
		view 227
		loop 3
		cel 1
	)
	
	(method (init)
		(super init:)
		(localproc_0e92 (& (Submarine flags?) $0040))
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			(
			(or (MousedOn self event) (== (event message?) 22272))
				(butSnd number: (SoundFX 47) play:)
				(localproc_0e92 (!= cel 2))
				(event claimed: 1)
			)
		)
	)
)

(instance sVForward of Fwd
	(properties)
)

(instance sVEndLoop of End
	(properties)
)

(instance vSLine1 of Act
	(properties
		y 46
		x 225
		view 27
		loop 2
		cel 1
		priority 13
		signal $4811
	)
)

(instance vSLine2 of Act
	(properties
		y 46
		x 225
		view 27
		loop 2
		cel 1
		priority 13
		signal $4811
	)
)

(instance scanPanelBlip of Act
	(properties
		y 129
		x 123
		view 27
		loop 5
		cel 5
		priority 12
		signal $4810
		illegalBits $0000
	)
)

(instance scanLightsScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: sLMoveTo 186 (client y?) self)
			)
			(1
				(client posn: 123 129)
				(self init:)
			)
		)
	)
)

(instance sLMoveTo of MoveTo
	(properties)
)

(instance mBut of View
	(properties
		y 144
		x 117
		view 27
		loop 5
		priority 11
		signal $0111
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			(
			(or (MousedOn self event) (== (event message?) 21504))
				(event claimed: 1)
				(butSnd number: (SoundFX 47) play:)
				(if (== cel 0)
					(self setCel: 1)
					(if (fCPanel cel?)
						(fCPanel setCycle: Beg fCPanel)
						(bBut setCel: 0)
					)
					(if (== ((subMarine script?) state?) 11)
						(tV setCel: 0 setPri: 0)
					else
						(tV setCel: 2 setPri: 15)
					)
				else
					(self setCel: 0)
					(tV setCel: 4 setPri: 13)
				)
			)
		)
	)
)

(instance bBut of View
	(properties
		y 156
		x 127
		view 27
		loop 5
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			(
			(or (MousedOn self event) (== (event message?) 21760))
				(event claimed: 1)
				(butSnd number: (SoundFX 47) play:)
				(if (== cel 0)
					(self setCel: 1)
					(fCPanel setCycle: End fCPanel)
					(mBut setCel: 0)
				else
					(self setCel: 0)
					(fCPanel setCycle: Beg fCPanel)
				)
			)
		)
	)
)

(instance bBORide of View
	(properties
		y 112
		x 226
		view 127
		loop 5
		cel 1
		priority 11
	)
)

(instance strnBORide of View
	(properties
		y 117
		x 222
		view 127
		loop 5
		cel 1
		priority 11
	)
)

(instance pbORide of View
	(properties
		y 122
		x 218
		view 127
		loop 5
		cel 1
		priority 11
	)
)

(instance sbORide of View
	(properties
		y 127
		x 214
		view 127
		loop 5
		cel 1
		priority 11
	)
)

(instance bBalLights of Prop
	(properties
		y 117
		x 236
		view 127
		loop 6
		priority 12
		signal $0010
		cycleSpeed 10
	)
	
	(method (cue)
		(self stopUpd:)
	)
)

(instance strnBalLights of Prop
	(properties
		y 122
		x 232
		view 127
		loop 6
		priority 12
		signal $0010
		cycleSpeed 10
	)
	
	(method (cue)
		(self stopUpd:)
	)
)

(instance pBalLights of Prop
	(properties
		y 127
		x 228
		view 127
		loop 6
		priority 12
		signal $0010
		cycleSpeed 10
	)
	
	(method (cue)
		(self stopUpd:)
	)
)

(instance sBalLights of Prop
	(properties
		y 132
		x 224
		view 127
		loop 6
		priority 12
		signal $0010
		cycleSpeed 10
	)
	
	(method (cue)
		(self stopUpd:)
	)
)

(instance bowPIndBot of Prop
	(properties
		y 117
		x 104
		view 27
		loop 7
		priority 12
		signal $0011
	)
	
	(method (doit &tmp submarinePitch)
		(self
			cel:
				(if (> (= submarinePitch (Submarine pitch?)) 0)
					(Abs (/ submarinePitch 6))
				else
					0
				)
		)
		(super doit:)
	)
)

(instance bowPIndTop of Prop
	(properties
		y 115
		x 101
		view 27
		loop 6
		priority 12
		signal $0011
	)
	
	(method (doit &tmp submarinePitch)
		(self
			cel:
				(if (< (= submarinePitch (Submarine pitch?)) 0)
					(Abs (/ submarinePitch 6))
				else
					0
				)
		)
		(super doit:)
	)
)

(instance sternPIndBot of Prop
	(properties
		y 117
		x 201
		view 27
		loop 9
		priority 12
		signal $0011
	)
	
	(method (doit &tmp submarinePitch)
		(self
			cel:
				(if (< (= submarinePitch (Submarine pitch?)) 0)
					(Abs (/ submarinePitch 6))
				else
					0
				)
		)
		(super doit:)
	)
)

(instance sternPIndTop of Prop
	(properties
		y 115
		x 202
		view 27
		loop 8
		priority 12
		signal $0010
	)
	
	(method (doit &tmp submarinePitch)
		(self
			cel:
				(if (> (= submarinePitch (Submarine pitch?)) 0)
					(Abs (/ submarinePitch 6))
				else
					0
				)
		)
		(super doit:)
	)
)

(instance bankTurnInd of Act
	(properties
		y 146
		x 156
		yStep 1
		view 227
		loop 1
		cel 4
		priority 12
		signal $4811
		cycleSpeed 4
		illegalBits $0000
		moveSpeed 4
	)
	
	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(if (!= submarineRoll (Submarine roll:))
			(bankTurnInd
				setCycle:
					tBCycleTo
					(= temp0 (+ (/ (Submarine roll:) 10) 4))
					(sign (- temp0 cel))
					self
			)
			(= submarineRoll (Submarine roll:))
		)
		(if (!= submarinePitch_2 (Submarine pitch?))
			(self
				setMotion: tBMoveTo 156 (+ 146 (/ (Submarine pitch?) 10)) bankTurnInd
			)
			(= submarinePitch_2 (Submarine pitch?))
			(= temp1 (/ (- (Submarine bowBallast?) 1) 26))
			(bBalLights cel: temp1)
			(strnBalLights cel: temp1)
			(pBalLights cel: temp1)
			(sBalLights cel: temp1)
		)
	)
	
	(method (cue)
		(if (not (if cycler else mover)) (self stopUpd:))
	)
)

(instance tBCycleTo of CT
	(properties)
)

(instance tBMoveTo of MoveTo
	(properties)
)

(instance silentRunInd of Prop
	(properties
		y 161
		x 196
		view 227
		loop 4
		priority 12
		cycleSpeed 2
	)
	
	(method (cue)
		(self stopUpd:)
	)
)

(instance diveLever of Cat
	(properties
		y 144
		x 277
		view 227
		loop 6
		cel 3
		priority 12
		signal $0010
		top 139
		left 266
		bottom 149
		right 287
		diagonal -2
	)
	
	(method (dispose)
		(directionHandler delete: self)
		(Submarine diveLeverY: y)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (== (event type?) evJOYSTICK)
			(switch (event message?)
				(JOY_UP (self posn: x (- y 2)))
				(JOY_DOWN
					(self posn: x (+ y 2))
				)
			)
		)
	)
	
	(method (posn &tmp [temp0 2])
		(super posn: &rest)
		(self cel: (/ (- (- right x) 1) 3))
		(Submarine dive: cel)
		(diveIndLights
			setCycle:
				dICycleTo
				cel
				(- (* 2 (> cel (diveIndLights cel?))) 1)
				diveIndLights
		)
	)
)

(instance dICycleTo of CT
	(properties)
)

(instance diveIndLights of Prop
	(properties
		y 180
		x 285
		view 227
		loop 5
		cycleSpeed 3
	)
	
	(method (cue)
		(self stopUpd:)
	)
)

(instance engineLever of Cat
	(properties
		y 177
		x 238
		view 127
		loop 9
		cel 2
		priority 13
		top 172
		left 229
		bottom 183
		right 244
		diagonal -2
	)
	
	(method (init)
		(super init: &rest)
		(self
			posn: 244 (Submarine throttleY?)
			setPri: priority
			caller: self
		)
	)
	
	(method (dispose)
		(Submarine throttleY: y)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (== (event type?) evKEYBOARD)
			(switch (event message?)
				(KEY_EXECUTE
					(self posn: x (- y 2))
					(self cue:)
					(event claimed: 1)
					(return)
				)
				(KEY_SUBTRACT
					(self posn: x (+ y 2))
					(theGame setSpeed: 0)
					(self cue:)
					(event claimed: 1)
					(return)
				)
			)
		)
	)
	
	(method (posn)
		(super posn: &rest)
		(self cel: (/ (- (- bottom y) 1) 2))
		(Submarine throttle: (- cel 1))
		(rpmLights setCel: cel)
	)
	
	(method (cue &tmp temp0)
		(if
			(mod
				(= temp0
					(SoundFX
						(cond 
							(
								(<
									[local6 (+ (Submarine throttle?) 1)]
									(Abs (Submarine hSpeed?))
								)
								55
							)
							(
								(>
									[local6 (+ (Submarine throttle?) 1)]
									(Abs (Submarine hSpeed?))
								)
								54
							)
						)
					)
				)
				200
			)
			(if
				(not
					(if (== temp0 (engSnd number?))
						(== (engSnd state?) 3)
					)
				)
				(engSnd number: temp0 play:)
			)
		)
	)
)

(instance rpmLights of View
	(properties
		y 167
		x 205
		view 427
		loop 4
	)
)

(instance hatch1Ind of View
	(properties
		y 142
		x 38
		view 427
		loop 3
		cel 4
		priority 12
		signal $0111
	)
)

(instance eBalGauge of Prop
	(properties
		y 156
		x 25
		view 427
		loop 6
		priority 12
		cycleSpeed 8
	)
	
	(method (cue)
		(self stopUpd:)
	)
)

(instance ebs of View
	(properties
		y 163
		x 29
		view 427
		loop 5
		cel 1
		priority 12
		signal $0111
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((MousedOn self event)
				(if (& signal $0080)
					(self show:)
					(eBalGauge setCycle: End eBalGauge)
					(Submarine emergencyBallast: 0 vSpeed:)
				else
					(self hide:)
					(eBalGauge setCycle: Beg eBalGauge)
					(Submarine emergencyBallast: 480 vSpeed:)
				)
			)
		)
	)
)

(instance positionBlip of Prop
	(properties
		view 527
		priority 13
		signal $0010
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance compassNeedle of View
	(properties
		y 123
		x 83
		view 127
		priority 13
		signal $0011
	)
	
	(method (doit &tmp temp0)
		(if (not (mod (++ local5) 10))
			(super doit:)
			(if
				(!=
					(= temp0 (mod (/ (Submarine _absHeading?) 22) 16))
					cel
				)
				(self setCel: temp0)
			)
		)
	)
)

(instance tV of View
	(properties
		y 98
		x 157
		view 527
		loop 3
		cel 4
		priority 13
		signal $4111
	)
)

(instance missleSelector of View
	(properties
		y 90
		x 152
		view 427
		loop 2
		priority 14
		signal $0111
	)
	
	(method (delete)
		(keyDownHandler delete: fCPanel)
		(super delete:)
	)
)

(instance fCPanel of Prop
	(properties
		y 4
		x 156
		view 27
		loop 3
		priority 12
		signal $0010
	)
	
	(method (doit)
		(if local0 (-- local0))
		(super doit:)
	)
	
	(method (handleEvent event &tmp eventX)
		(cond 
			((super handleEvent: event))
			((!= cel 9))
			((== (event type?) evKEYBOARD)
				(switch (event message?)
					(22528
						(localproc_21a5)
						(event claimed: 1)
					)
					(22784
						(localproc_21c4)
						(event claimed: 1)
					)
					(23040
						(localproc_2252)
						(event claimed: 1)
					)
					(23296
						(localproc_2272 event)
						(event claimed: 1)
					)
				)
			)
			((MousedOn self event)
				(cond 
					(
					(not (if (<= 22 (event y?)) (<= (event y?) 26))))
					(
					(and (<= 143 (= eventX (event x?))) (<= eventX 147)) (localproc_21a5))
					((and (<= 150 eventX) (<= eventX 154)) (localproc_21c4))
					((and (<= 157 eventX) (<= eventX 161)) (localproc_2252))
					((and (<= 164 eventX) (<= eventX 168)) (localproc_2272 event))
				)
			)
		)
	)
	
	(method (setCycle theCycler)
		(if (and argc theCycler (theCycler isKindOf: Beg))
			(missleSelector hide:)
		)
		(super setCycle: theCycler &rest)
	)
	
	(method (cue)
		(if cel
			(if (!= (tV cel?) 4) (tV setCel: 4 setPri: 15))
			(missleSelector show:)
			(if (== ((subMarine script?) state?) 5) (Print 27 5))
		)
	)
)

(instance torpSnd of Sound
	(properties
		number 48
		priority 4
	)
)
