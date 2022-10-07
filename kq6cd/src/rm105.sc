;;; Sierra Script 1.0 - (do not remove this comment)
(script# 105)
(include sci.sh)
(use Main)
(use Audio)
(use KQ6Room)
(use Sync)
(use RandCyc)
(use LoadMany)
(use User)
(use Actor)
(use System)

(public
	rm105 0
)

(local
	local0
	[local1 400]
	local401
	local402
	local403
)
(instance rm105 of KQ6Room
	(properties
		picture 98
		autoLoad 0
	)
	
	(method (init)
		(directionHandler addToFront: self)
		(keyDownHandler addToFront: self)
		(mouseDownHandler addToFront: self)
		(self setScript: showMovie)
		(super init: &rest)
	)
	
	(method (handleEvent)
		(DoAudio 3)
		(if local403
			(theGame masterVolume: local403)
			(= local403 0)
		)
		(DrawPic 98)
		(SetVideoMode 0)
		(Cursor showCursor: 1)
		(theGame restart: 1)
	)
	
	(method (cue)
		(theGame restart: 1)
	)
	
	(method (newRoom)
		(directionHandler delete: self)
		(keyDownHandler delete: self)
		(mouseDownHandler delete: self)
		(LoadMany 0 929)
		(super newRoom: &rest)
	)
)

(instance showMovie of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(LoadMany 128 1 2 3 1091 4)
				(LoadMany 129 1 107 10 2 11 141 5 7 6)
				(theIconBar disable: height: -100 activateHeight: -100)
				(User controls: 1)
				(Cursor showCursor: 0)
				(= cycles 2)
			)
			(1
				(SetVideoMode 1)
				(Animate 0)
				(Palette palSET_INTENSITY 0 256 0)
				(= cycles 1)
			)
			(2
				(DrawPic 107)
				(= temp0 0)
				(while (< temp0 100)
					(Palette palSET_INTENSITY 0 256 temp0)
					(= temp1 0)
					(while (< temp1 30)
						(++ temp1)
					)
					(++ temp0)
				)
				(= cycles 1)
			)
			(3
				((ScriptID 107 2) doit: 1 self)
			)
			(4
				(theMusic loop: 1 number: 105 play:)
				(Message msgGET 105 1 0 0 1 @local1)
				(= local401
					(Display
						@local1
						dsCOORD
						12
						81
						dsWIDTH
						300
						dsCOLOR
						98
						dsFONT
						3110
						dsALIGN
						1
						dsSAVEPIXELS
					)
				)
				(= cycles 1)
			)
			(5
				((ScriptID 107 2) doit: 0 self)
			)
			(6 (= seconds 6))
			(7
				((ScriptID 107 2) doit: 1 self)
			)
			(8
				(Display 105 0 108 local401)
				(= seconds 2)
			)
			(9 (DrawPic 10) (= cycles 1))
			(10
				((ScriptID 107 2) doit: 0 self)
			)
			(11 (= cycles 1))
			(12
				(ShowMovie {FS1.SEQ} 10)
				(ShowMovie {FS2Y.SEQ} 10)
				(= cycles 1)
			)
			(13
				(DrawPic 1)
				(flames init:)
				(= cycles 1)
			)
			(14
				(toonAudio play: 1 0 0 2 self)
			)
			(15
				(alexMouth init: setCycle: MouthSync 105 1 0 0 3)
				(toonAudio play: 1 0 0 3 self)
			)
			(16
				(alexMouth dispose: delete:)
				(toonAudio play: 1 0 0 4 self)
			)
			(17
				(alexMouth init: setCycle: MouthSync 105 1 0 0 5)
				(toonAudio play: 1 0 0 5 self)
			)
			(18
				(alexMouth dispose: delete:)
				(toonAudio play: 1 0 0 6 self)
			)
			(19
				(alexMouth init: setCycle: MouthSync 105 1 0 0 7)
				(toonAudio play: 1 0 0 7 self)
			)
			(20
				(alexMouth dispose: delete:)
				(toonAudio play: 1 0 0 8 self)
			)
			(21
				(alexMouth init: setCycle: MouthSync 105 1 0 0 9)
				(toonAudio play: 1 0 0 9 self)
			)
			(22
				(alexMouth dispose: delete:)
				(flames dispose:)
				(ShowMovie {FS2Z.SEQ} 10)
				(DrawPic 2)
				(= seconds 2)
			)
			(23
				((ScriptID 107 2) doit: 1 self)
			)
			(24 (DrawPic 107) (= cycles 1))
			(25
				(theMusic loop: -1 number: 120 play:)
				(Message msgGET 105 3 0 0 1 @local1)
				(= local401
					(Display
						@local1
						dsCOORD
						12
						81
						dsWIDTH
						300
						dsCOLOR
						98
						dsFONT
						3110
						dsALIGN
						1
						dsSAVEPIXELS
					)
				)
				(= cycles 1)
			)
			(26
				((ScriptID 107 2) doit: 0 self)
			)
			(27 (= seconds 4))
			(28
				((ScriptID 107 2) doit: 1 self)
			)
			(29
				(Display 105 0 108 local401)
				(= seconds 2)
			)
			(30 (DrawPic 11) (= cycles 1))
			(31
				((ScriptID 107 2) doit: 0 self)
			)
			(32
				(ShowMovie {CD1.SEQ} 10)
				(= cycles 1)
			)
			(33 (DrawPic 3) (= seconds 5))
			(34
				(theMusic stop:)
				(theMusic loop: 1 number: 125 play:)
				(theMusic loop: 1 number: 107 play:)
				(ShowMovie {CD6.SEQ} 10)
				(= cycles 1)
			)
			(35
				((ScriptID 107 2) doit: 1 self)
			)
			(36 (DrawPic 141) (= cycles 1))
			(37
				((ScriptID 107 2) doit: 0 self)
			)
			(38
				(cassMouth init: setCycle: MouthSync 105 1 0 0 10)
				(toonAudio play: 1 0 0 10 self)
			)
			(39
				(cassMouth dispose: delete:)
				((ScriptID 107 2) doit: 1 self)
				(= cycles 2)
			)
			(40
				(toonAudio play: 1 0 0 11 self)
			)
			(41)
			(42
				(DrawPic 107)
				(theMusic number: 108 play:)
				(toonAudio play: 1 0 0 12 self)
			)
			(43
				(Palette palSET_INTENSITY 0 231 100)
				(ShowMovie {FPAN.SEQ} 10)
				(= cycles 1)
			)
			(44
				(DrawPic 5)
				(flames2 init:)
				(= cycles 1)
			)
			(45
				(momMouth init: setCycle: MouthSync 105 1 0 0 13)
				(toonAudio play: 1 0 0 13 self)
			)
			(46
				(momMouth dispose: delete:)
				(alexMouth2 init: setCycle: MouthSync 105 1 0 0 14)
				(toonAudio play: 1 0 0 14 self)
			)
			(47
				(alexMouth2 dispose: delete:)
				(momMouth init: setCycle: MouthSync 105 1 0 0 15)
				(toonAudio play: 1 0 0 15 self)
			)
			(48
				(momMouth dispose: delete:)
				(alexMouth2 init: setCycle: MouthSync 105 1 0 0 16)
				(toonAudio play: 1 0 0 16 self)
			)
			(49
				(alexMouth2 dispose: delete:)
				(momMouth init: setCycle: MouthSync 105 1 0 0 17)
				(toonAudio play: 1 0 0 17 self)
			)
			(50
				(momMouth dispose: delete:)
				(alexMouth2 init: setCycle: MouthSync 105 1 0 0 18)
				(toonAudio play: 1 0 0 18 self)
			)
			(51
				(alexMouth2 dispose: delete:)
				(momMouth init: setCycle: MouthSync 105 1 0 0 19)
				(toonAudio play: 1 0 0 19 self)
			)
			(52
				(momMouth dispose: delete:)
				(alexMouth2 init: setCycle: MouthSync 105 1 0 0 20)
				(toonAudio play: 1 0 0 20 self)
			)
			(53
				(alexMouth2 dispose: delete:)
				((ScriptID 107 2) doit: 1 self)
			)
			(54
				(flames2 dispose:)
				(DrawPic 107)
				(= cycles 2)
			)
			(55
				(theMusic stop: number: 121 play:)
				(Message msgGET 105 1 0 0 21 @local1)
				(= local401
					(Display
						@local1
						dsCOORD
						12
						81
						dsWIDTH
						300
						dsCOLOR
						98
						dsFONT
						3110
						dsALIGN
						1
						dsSAVEPIXELS
					)
				)
				((ScriptID 107 2) doit: 0 self)
			)
			(56 (= seconds 3))
			(57
				((ScriptID 107 2) doit: 1 self)
			)
			(58
				(Display 105 0 108 local401)
				(= cycles 2)
			)
			(59
				(Palette palSET_INTENSITY 0 231 100)
				(= cycles 1)
			)
			(60
				(ShowMovie {CLOUD.SEQ} 10)
				(ShowMovie {BIRDS.SEQ} 10)
				(theMusic stop: number: 122 play:)
				(ShowMovie {OPEN.SEQ} 10)
				(ShowMovie {OPEN2.SEQ} 10)
				(ShowMovie {CLOSE.SEQ} 10)
				(ShowMovie {SCAN.SEQ} 10)
				(ShowMovie {SCOP.SEQ} 10)
				(toonAudio play: 1 0 0 22 self)
			)
			(61
				(ShowMovie {LAND.SEQ} 10)
				(= cycles 1)
			)
			(62
				((ScriptID 107 2) doit: 1 self)
			)
			(63 (DrawPic 107) (= cycles 2))
			(64
				(Message msgGET 105 3 0 0 2 @local1)
				(= local401
					(Display
						@local1
						dsCOORD
						12
						81
						dsWIDTH
						300
						dsCOLOR
						98
						dsFONT
						3110
						dsALIGN
						1
						dsSAVEPIXELS
					)
				)
				((ScriptID 107 2) doit: 0 self)
			)
			(65 (= seconds 3))
			(66
				((ScriptID 107 2) doit: 1 self)
			)
			(67
				(Display 105 0 108 local401)
				(= cycles 2)
			)
			(68
				(theMusic stop: number: 123 play:)
				(DrawPic 7)
				(= cycles 1)
			)
			(69
				((ScriptID 107 2) doit: 0 self)
			)
			(70
				(ShowMovie {BOAT.SEQ} 10)
				(= cycles 1)
			)
			(71
				((ScriptID 107 2) doit: 1 self)
			)
			(72
				(DrawPic 107)
				(theMusic stop: number: 124 loop: 1 play: self)
				(Message msgGET 105 1 0 0 23 @local1)
				(Display 105 0 108 local401)
				(= local401
					(Display
						@local1
						dsCOORD
						12
						81
						dsWIDTH
						300
						dsCOLOR
						98
						dsFONT
						3110
						dsALIGN
						1
						dsSAVEPIXELS
					)
				)
				(= cycles 1)
			)
			(73
				((ScriptID 107 2) doit: 0 self)
			)
			(74 (= seconds 7))
			(75
				((ScriptID 107 2) doit: 1 self)
			)
			(76
				(Display 105 0 108 local401)
				(= cycles 2)
			)
			(77 (DrawPic 6) (= cycles 1))
			(78
				((ScriptID 107 2) doit: 0 self)
			)
			(79 (= seconds 2))
			(80
				(ShowMovie {NSHP.SEQ} 10)
				(= cycles 2)
			)
			(81)
			(82
				((ScriptID 107 2) doit: 1 self)
			)
			(83
				(DrawPic 107)
				(self setScript: (ScriptID 107 0) self)
			)
			(84
				(= temp0 100)
				(while (> temp0 0)
					(Palette palSET_INTENSITY 0 256 temp0)
					(= temp1 0)
					(while (< temp1 30)
						(++ temp1)
					)
					(-- temp0)
				)
				(= cycles 1)
			)
			(85 (DrawPic 98) (= cycles 1))
			(86
				(SetVideoMode 0)
				(theIconBar height: 0 activateHeight: 0)
				(Cursor showCursor: 1)
				(curRoom newRoom: 200)
			)
		)
	)
)

(instance toonAudio of Audio
	(properties)
	
	(method (doit &tmp temp0)
		(if
		(and (not stopped) (== (DoAudio 6) -1) (== loop 1))
			(= doNotStop 0)
			(= stopped 1)
			(if (!= local0 0)
				(= temp0 local0)
				(= local0 0)
				(theDoits delete: self)
				(theGame masterVolume: local403)
				(= local403 0)
				(temp0 cue:)
			)
		)
		(if
			(and
				(not stopped)
				(== (DoAudio 6) -1)
				(or (> loop 1) (== loop -1))
			)
			(self play:)
		)
	)
	
	(method (play param1 param2 param3 param4 param5)
		(theDoits add: self)
		(if (not local403)
			(= local403
				(theGame masterVolume: (- (theGame masterVolume:) 4))
			)
		)
		(= local0 0)
		(cond 
			((DoAudio 2 105 param1 param2 param3 param4)
				(= stopped 0)
				(if (IsObject param5) (= local0 param5))
				(self doit:)
			)
			(
			(and (IsObject param5) (!= (= local0 param5) 0)) (local0 cue:))
		)
	)
)

(instance flames of Prop
	(properties
		x 146
		y 47
		view 1
		cycleSpeed 12
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: RandCycle)
	)
)

(instance flames2 of Prop
	(properties
		x 182
		y 94
		view 2
		cycleSpeed 14
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: RandCycle)
	)
)

(instance alexMouth of Prop
	(properties
		x 108
		y 46
		view 3
	)
	
	(method (init)
		(self setPri: 14 ignoreActors: 1)
		(super init: &rest)
	)
)

(instance cassMouth of Actor
	(properties
		x 111
		y 86
		view 1091
		cel 7
	)
)

(instance alexMouth2 of Actor
	(properties
		x 70
		y 67
		view 4
		cel 1
		priority 14
		signal $0010
	)
)

(instance momMouth of Actor
	(properties
		x 242
		y 64
		view 4
		loop 1
		cel 7
	)
)
