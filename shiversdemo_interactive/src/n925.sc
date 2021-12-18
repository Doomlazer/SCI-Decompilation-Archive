;;; Sierra Script 1.0 - (do not remove this comment)
(script# 925)
(include sci.sh)
(use Main)
(use Procs)
(use RangeOsc)
(use Osc)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	proc925_0 0
	proc925_1 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15 =  1
	local16
	local17
	[local18 44] = [0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 -1 -1 0 0 0 2 0 0 0 0 0 0 0 0 0 -1 -1]
	[local62 44] = [20904 20905 20906 20907 20804 20805 20806 20807 20605 20606 20607 20604 21112 21113 21114 21115 22507 22508 22509 22510 20703 20704 20705 20706 20911 20912 20913 20914 22904 22905 22906 22907 21907 21908 21906 21905 21105 21106 21107 21108 22502 22503 22504 22505]
)
(procedure (proc925_0 param1)
	(param1 setScript: sEntity param1)
)

(procedure (proc925_1 param1 param2 param3 param4)
	(= local11 0)
	(= local15 1)
	(if (>= argc 3)
		(if param3 (= local0 param3) else (= local0 0))
		(if (== argc 4)
			(= local15 (not param4))
			(MonoOut {timedelay: %d} local15)
		)
	else
		(= local0 0)
	)
	(= local16 0)
	(= local17 0)
	(= local12 0)
	(= local3 0)
	(= local7 0)
	(if (proc951_5 35)
		(MonoOut {isFast})
		(= local2 2)
	else
		(MonoOut {isSlow})
		(= local2 1)
	)
	(= local1 0)
	(= local8 param1)
	(spEffects loop: 0 cel: 0)
	(if (== local8 -11286) (spEffects setPri: 55 1))
	(switch param1
		(-15506
			(= local4 62)
			(= local5 136)
			(= local12 20303)
			(= local11 20302)
			(= local6 0)
		)
		(-15446
			(= local4 90)
			(= local5 101)
			(= local12 20909)
			(= local11 20908)
			(= local6 0)
		)
		(-15286
			(= local4 132)
			(= local5 111)
			(= local12 22511)
			(= local11 22506)
			(= local6 0)
		)
		(-14456
			(= local4 131)
			(= local5 96)
			(= local12 20803)
			(= local11 20802)
			(= local6 1)
		)
		(-14316
			(= local4 123)
			(= local5 72)
			(= local12 20803)
			(= local11 22212)
			(= local6 1)
		)
		(-14296
			(= local4 136)
			(= local5 79)
			(= local12 20803)
			(= local11 22404)
			(= local6 1)
		)
		(-13476
			(= local4 132)
			(= local5 108)
			(= local11 20603)
			(= local12 20608)
			(= local6 2)
		)
		(-13326
			(= local4 152)
			(= local5 114)
			(= local11 22102)
			(= local12 20608)
			(= local6 2)
		)
		(-12426
			(= local4 113)
			(= local5 129)
			(= local12 21110)
			(= local11 21103)
			(= local6 3)
		)
		(-12396
			(= local4 107)
			(= local5 125)
			(= local12 21110)
			(= local11 21402)
			(= local6 3)
		)
		(-11336
			(= local4 141)
			(= local5 116)
			(= local12 22512)
			(= local11 22002)
			(= local6 4)
		)
		(-11326
			(= local4 119)
			(= local5 116)
			(= local12 22512)
			(= local11 22102)
			(= local6 4)
		)
		(-11286
			(= local4 123)
			(= local5 125)
			(= local12 22512)
			(= local11 22506)
			(= local6 4)
		)
		(-10466
			(= local4 118)
			(= local5 128)
			(= local12 20702)
			(= local11 20701)
			(= local6 5)
		)
		(-10306
			(= local4 133)
			(= local5 143)
			(= local12 20702)
			(= local11 22313)
			(= local6 5)
		)
		(-10296
			(= local4 120)
			(= local5 133)
			(= local12 20702)
			(= local11 22404)
			(= local6 5)
		)
		(-10266
			(= local4 143)
			(= local5 117)
			(= local12 20702)
			(= local11 22702)
			(= local6 5)
		)
		(-9446
			(= local4 134)
			(= local5 50)
			(= local12 20910)
			(= local11 20908)
			(= local6 6)
		)
		(-9416
			(= local4 124)
			(= local5 114)
			(= local12 20910)
			(= local11 21212)
			(= local6 6)
		)
		(-8246
			(= local4 136)
			(= local5 47)
			(= local12 22903)
			(= local11 22902)
			(= local6 7)
		)
		(-8216
			(= local4 129)
			(= local5 58)
			(= local12 22903)
			(= local11 23210)
			(= local6 7)
		)
		(-8146
			(= local4 98)
			(= local5 80)
			(= local12 23905)
			(= local11 23904)
			(= local6 7)
		)
		(-7416
			(= local4 127)
			(= local5 124)
			(= local12 21910)
			(= local11 21212)
			(= local6 8)
		)
		(-7346
			(= local4 133)
			(= local5 116)
			(= local12 21910)
			(= local11 21909)
			(= local6 8)
		)
		(-6426
			(= local4 141)
			(= local5 49)
			(= local12 21111)
			(= local11 21103)
			(= local6 9)
		)
		(-6366
			(= local4 139)
			(= local5 102)
			(= local12 21111)
			(= local11 21703)
			(= local6 9)
		)
		(-6166
			(= local4 128)
			(= local5 41)
			(= local12 21111)
			(= local11 23702)
			(= local6 9)
		)
	)
	(= local14 [global164 (* local6 2)])
	(param2 setScript: sWait param2)
)

(instance EntityRoom of ShiversRoom
	(properties)
)

(instance hsEntity of HotSpot
	(properties
		nsLeft 102
		nsTop 78
		nsRight 162
		nsBottom 138
	)
	
	(method (handleEvent event &tmp temp0)
		(event localize: thePlane)
		(if
			(and
				(& (event type?) evMOUSEBUTTON)
				(self onMe: event)
			)
			(event claimed: 1)
			(cond 
				(global184
					(if (not local1) (= local1 1) (sWait ticks: 0 cue:))
					(MonoOut {item: %d %d} local6 (mod global105 10))
					(if (== local6 (mod global105 10))
						(if
							(and
								(> global105 219)
								(!= local8 -8246)
								(!= local8 -8216)
							)
							(= local3 3)
						else
							(= local3 2)
						)
					else
						(= local3 1)
					)
				)
				((proc951_5 44)
					(switch (= local3 (mod (++ local3) 4))
						(0 (MonoOut {attack}))
						(1 (MonoOut {mad}))
						(2 (MonoOut {cower}))
						(3 (MonoOut {die}))
					)
				)
				((not local1) (= local1 1) (sWait ticks: 0 cue:))
			)
		)
	)
)

(instance spEffects of Prop
	(properties
		priority 15
		fixPriority 1
		view -5537
	)
)

(instance pEntity of Prop
	(properties
		priority 10
		fixPriority 1
	)
)

(instance aPot of Actor
	(properties
		priority 15
		fixPriority 1
	)
)

(instance sSoundDelay of Script
	(properties)
	
	(method (cue)
		(= local13 1)
	)
)

(instance sWait of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 0)
				(sSoundDelay init:)
				(hsEntity
					nsLeft: (- local4 50)
					nsRight: (+ local4 50)
					nsTop: (- local5 60)
					nsBottom: (+ local5 40)
					init:
				)
				(cond 
					((== local8 -15506) (= cycles 1))
					(local15 (= ticks 200))
				)
			)
			(1 (= ticks 0) (self dispose:))
		)
	)
)

(instance sEntity of Script
	(properties)
	
	(method (dispose)
		(sounds stop: 15016)
		(super dispose: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 0)
				(if
					(and
						(or local1 (== local8 -15506))
						(or local15 global184)
					)
					(spEffects
						x: local4
						y: local5
						loop: 2
						cel: 4
						cycleSpeed: (+ local2 2)
						init:
					)
					(sounds play: 15016 -1 74 0)
					(= state (+ state 2))
				)
				(= local1 1)
				(= cycles 1)
			)
			(1
				(sounds play: 15016 -1 74 0)
				(spEffects
					x: local4
					y: local5
					loop: 2
					cel: 0
					cycleSpeed: (+ local2 2)
					setCycle: ROsc -1 0 7
					init:
				)
				(= seconds 5)
			)
			(2
				(spEffects cycleSpeed: (+ local2 1) setCycle: End)
				(= cycles 1)
			)
			(3
				(if global184
					(= global184 0)
					(= local7 1)
					(normalCursor show:)
					(global108 x: (- local4 26) y: (+ local5 42))
					(UpdateScreenItem global108)
					(if (not local3)
						(if (== local6 (mod global105 10))
							(MonoOut {waited too long})
							(= local3 2)
						else
							(= local3 1)
						)
					)
				)
				(hsEntity dispose:)
				(theGame handsOff:)
				(spEffects setCycle: End)
				(if (== local8 -15286)
					(= local10 [local62 (+ local3 40)])
				else
					(= local10 [local62 (+ local3 (* local6 4))])
				)
				(if local10 (proc951_7 local10))
				(if (== local8 -15506) (= local10 20304))
				(= cycles 1)
			)
			(4
				(switch local3
					(0 (Load rsVIEW local8))
					(1 (Load rsVIEW (+ local8 1)))
					(2
						(if (ResCheck 128 (+ local8 2))
							(Load rsVIEW (+ local8 2))
						else
							(Load rsVIEW (+ local8 3))
						)
					)
					(3 (Load rsVIEW (+ local8 3)))
				)
				(if (== local8 -15286)
					(= local9 [local18 (+ local3 40)])
				else
					(= local9 [local18 (+ local3 (* local6 4))])
				)
				(if local0 (local0 hide:))
				(pEntity
					view: (+ local8 4)
					x: local4
					y: local5
					init:
					loop: 0
					cel: 0
					cycleSpeed: local2
					setCycle: End self
				)
				(if (or (== local8 -15506) (== local8 -11286))
					(pEntity setPri: 50 1)
				)
				(if local11 (sounds stop: local11))
				(if local12 (sounds stop: local12))
				(if local10
					(sounds play: local10 0 122 sSoundDelay)
				else
					(= local13 1)
				)
			)
			(5
				(sounds stop: 15016)
				(pEntity cel: 0 loop: 0 cycleSpeed: local2)
				(switch local3
					(0
						(pEntity view: local8)
						(proc951_7 15010)
						(proc951_7 15012)
					)
					(1
						(pEntity view: (+ local8 1))
						(proc951_7 15010)
						(proc951_7 15012)
					)
					(2
						(if (ResCheck 128 (+ local8 2))
							(pEntity view: (+ local8 2) cycleSpeed: (+ local2 3))
						else
							(pEntity view: (+ local8 3) cycleSpeed: (+ local2 3))
						)
						(proc951_7 15012)
					)
					(3
						(pEntity view: (+ local8 3) cycleSpeed: (+ local2 3))
						(proc951_7 15028)
						(proc951_7 15011)
					)
				)
				(if (<= local9 0)
					(pEntity setCycle: End self)
				else
					(pEntity setCycle: CT local9 1 self)
				)
			)
			(6
				(if (== local9 2) (= cycles 30) else (= cycles 1))
			)
			(7
				(if local9
					(pEntity setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(8
				(if (and (== local8 -8146) (== local3 3))
					(pEntity view: -8141 cel: 0 setCycle: End self)
				else
					(pEntity
						view: (+ local8 4)
						cel: (pEntity lastCel:)
						setCycle: Beg self
					)
				)
			)
			(9
				(if (not local13) (-- state))
				(= cycles 1)
			)
			(10
				(if local0 (pEntity hide:) (local0 show:))
				(switch local3
					(0
						(proc951_2 -10)
						(sounds play: 15010 0 82 self)
						(= [global164 (+ (* local6 2) 1)]
							(+ [global164 (+ (* local6 2) 1)] 10)
						)
						(proc951_1 local6)
					)
					(1
						(proc951_2 -20)
						(sounds play: 15010 0 82 self)
						(= [global164 (+ (* local6 2) 1)]
							(+ [global164 (+ (* local6 2) 1)] 20)
						)
						(proc951_1 local6)
						(= local17 1)
					)
					(2
						(proc951_1 local6)
						(= cycles 1)
					)
					(3
						(proc951_15 8500)
						(proc951_2 [global164 (+ (* local6 2) 1)])
						(if (> [global164 (+ (* local6 2) 1)] 0)
							(sounds play: 15028 0 74 self)
						else
							(= cycles 1)
						)
						(= [global164 (* local6 2)] 0)
						(= local16 1)
					)
				)
			)
			(11
				(if (== local8 -15506) (spEffects setPri: 255 1))
				(spEffects cycleSpeed: (+ local2 3))
				(if (== local14 [global164 (* local6 2)])
					(spEffects
						loop: 2
						cel: (spEffects lastCel:)
						setCycle: Beg self
					)
					(if (== local3 1)
						(spEffects loop: 0 cel: 0 setCycle: Osc 1 self)
					)
				else
					(spEffects loop: 0 cel: 0 setCycle: End self)
				)
				(switch local3
					(0
						(sounds play: 15012 0 90 self)
					)
					(1
						(sounds play: 15012 0 90 self)
						(if local7 (global108 hide:))
						(aPot
							view: (global108 view?)
							x: (- local4 26)
							y: (+ local5 42)
							setMotion: JumpTo 300 160
							init:
						)
					)
					(2
						(sounds play: 15012 0 90 self)
					)
					(3
						(sounds play: 15011 0 90 self)
						(spEffects loop: 1 cel: 0 setCycle: End self)
					)
				)
			)
			(12)
			(13
				(aPot dispose:)
				(cond 
					(local16 (proc951_12))
					(local17 (proc951_13))
					(local7
						(= global184 1)
						(normalCursor hide:)
						(UpdateScreenItem global108)
					)
				)
				(= cycles 1)
			)
			(14
				(pEntity dispose:)
				(spEffects dispose:)
				(theGame handsOn:)
				(if (and local16 (not (proc951_5 60)))
					(= global550 1)
				)
				(self dispose:)
			)
		)
	)
)
