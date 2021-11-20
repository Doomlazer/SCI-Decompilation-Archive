;;; Sierra Script 1.0 - (do not remove this comment)
(script# 35)
(include sci.sh)
(use Main)
(use GloryIconItem)
(use Print)
(use Cursor)

(public
	theJewelry 0
	theKnob 1
	theStaff 2
	theBonsai 3
	theHammer 4
	theStake 5
	theBag 6
	theBoneRit 7
	theBloodRit 8
	theBreathRit 9
	theSenseRit 10
	theHeartRit 11
	theFlowers 12
	theWillowisp 13
	theLocket 14
	theStatue 15
	theTorch 16
	theAmulet 17
	theHair 18
	theBroom 19
)

(procedure (localproc_0064 &tmp temp0)
	(theIconBar curInvIcon: 0 advanceCurIcon:)
	(theIconBar disableIcon: (theIconBar at: 6))
	(= temp0 (ScriptID 36 1))
	(temp0 signal: (| (temp0 signal?) $0008))
	(DeleteScreenItem temp0)
)

(instance theJewelry of NumInvItem
	(properties
		noun 70
		message 77
		mainView 905
		mainLoop 8
		mainCel 8
		value 2
	)
)

(instance theKnob of NumInvItem
	(properties
		noun 71
		message 78
		mainView 905
		mainLoop 8
		value 2
	)
)

(instance theStaff of NumInvItem
	(properties
		noun 17
		message 157
		mainView 905
		mainLoop 6
		mainCel 12
		value 5
	)
	
	(method (select &tmp temp0)
		(return
			(if
				(and
					(= temp0 (super select: &rest))
					(== curRoomNum 730)
				)
				(Bset 360)
				(return 1)
			else
				(return temp0)
			)
		)
	)
)

(instance theBonsai of NumInvItem
	(properties
		noun 18
		message 14
		mainView 905
		mainLoop 8
		mainCel 6
		value 5
	)
)

(instance theHammer of NumInvItem
	(properties
		noun 72
		message 171
		mainView 905
		mainLoop 4
		mainCel 6
		value 5
	)
)

(instance theStake of NumInvItem
	(properties
		noun 73
		message 170
		mainView 905
		mainLoop 4
		mainCel 7
		value 5
	)
)

(instance theBag of NumInvItem
	(properties
		noun 74
		message 13
		mainView 905
		mainLoop 2
		value 5
	)
)

(instance theBoneRit of NumInvItem
	(properties
		noun 50
		message 67
		mainView 905
		mainLoop 2
		mainCel 14
		value 2
	)
)

(instance theBloodRit of NumInvItem
	(properties
		noun 52
		message 69
		mainView 905
		mainLoop 2
		mainCel 14
		value 2
	)
)

(instance theBreathRit of NumInvItem
	(properties
		noun 76
		message 70
		mainView 905
		mainLoop 2
		mainCel 14
		value 2
	)
)

(instance theSenseRit of NumInvItem
	(properties
		noun 56
		message 72
		mainView 905
		mainLoop 2
		mainCel 14
		value 2
	)
)

(instance theHeartRit of NumInvItem
	(properties
		noun 66
		message 74
		mainView 905
		mainLoop 2
		mainCel 14
		value 2
	)
)

(instance theFlowers of NumInvItem
	(properties
		noun 41
		message 59
		mainView 905
		mainLoop 4
		mainCel 14
		value 2
	)
)

(instance theWillowisp of NumInvItem
	(properties
		noun 42
		message 60
		mainView 905
		mainLoop 4
		mainCel 10
		value 2
	)
)

(instance theLocket of NumInvItem
	(properties
		noun 46
		message 63
		mainView 905
		mainLoop 8
		mainCel 2
		value 2
	)
)

(instance theStatue of NumInvItem
	(properties
		noun 49
		message 66
		mainView 905
		mainLoop 10
		mainCel 5
		value 2
	)
)

(instance theTorch of NumInvItem
	(properties
		noun 69
		message 76
		mainView 905
		mainLoop 8
		mainCel 9
		value 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 39)
			(if (ego has: 5)
				(theTorch cel: 10 state: 1)
				(Print addText: 69 39 0 1 0 0 16 y: 165 init:)
				(Cursor loop: 8 cel: 10)
				(SetCursor 905 8 10)
				(UpdateScreenItem theTorch)
				((theIconBar at: 6) cursorCel: 10)
				((= temp0 (ScriptID 36 1)) cel: 10 show:)
				(UpdateScreenItem temp0)
				(ego solvePuzzle: 401 6)
				(curRoom doTorch: 1)
			else
				(Print addText: 69 39 55 1 0 0 16 y: 165 init:)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theAmulet of NumInvItem
	(properties
		noun 45
		message 56
		mainView 905
		mainLoop 4
		mainCel 3
		value 10
	)
)

(instance theHair of NumInvItem
	(properties
		noun 37
		message 57
		mainView 905
		mainLoop 10
		mainCel 3
		value 2
	)
)

(instance theBroom of NumInvItem
	(properties
		noun 39
		message 58
		mainView 905
		mainLoop 10
		value 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(super doVerb: theVerb)
				(if state
					(Print y: 165 addText: noun theVerb 31 2 0 0 16 init:)
				)
			)
			(57
				(if
					(and
						(== (theIconBar curInvIcon?) theHair)
						(== (theHair amount?) 1)
					)
					(localproc_0064)
				)
				(= cel (+ cel (= state 1)))
				(theHair amount: (- (theHair amount?) 1))
				(= value (+ value (theHair value?)))
				(if (< (theHair amount?) 1)
					(theHair signal: 4)
					(DeleteScreenItem theHair)
				)
				(inventory drawInvItems:)
				(inventory advanceCurIcon:)
				(FrameOut)
				(Print y: 165 addText: noun 57 0 0 0 0 16 init:)
			)
			(else  (super doVerb: theVerb))
		)
	)
)
