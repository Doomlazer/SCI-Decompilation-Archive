;;; Sierra Script 1.0 - (do not remove this comment)
(script# 150)
(include sci.sh)
(use Main)
(use TWRoom)
(use Motion)
(use System)

(public
	rm150 0
)

(instance rm150 of ADRoom
	(properties
		picture 155
		north 200
		vanishingY -60
	)
	
	(method (init)
		(super init: &rest)
		(theGame setEgo: (ScriptID 895 0))
		((ScriptID 895 0)
			cel: 1
			x: 140
			y: 104
			init:
			view: 155
			setLoop: 0
			setCycle: 0
			setLoop: 3
		)
		((ScriptID 895 1)
			view: 155
			init:
			normalize: 155
			setLoop: 4
			cel: 1
			posn: 172 82
		)
		(self setScript: startScr)
	)
	
	(method (doit)
		(super doit:)
		(Palette palANIMATE 64 235 -1)
	)
	
	(method (newRoom)
		(theMusic fade:)
		(super newRoom: &rest)
	)
)

(instance startScr of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(= cycles 1)
			)
			(1
				(theMusic number: 150 setLoop: -1 play:)
				(ego cycleSpeed: 5 setLoop: 3 setCycle: Fwd)
				((ScriptID 895 1) cycleSpeed: 5 setCycle: Fwd)
				(= seconds 6)
			)
			(2
				(theMusic2 number: 1500 setLoop: 1 play: self)
				((ScriptID 2000 3)
					dontUpd: 0
					winX: 32
					winY: 83
					tailPosn: 1
					forceWidth: 1
					talkWidth: 90
				)
				((ScriptID 2004 0)
					dontUpd: 0
					winX: 183
					winY: 68
					tailPosn: 0
				)
				(messager say: 1 0 1 0 self)
			)
			(3
				(theIconBar enable: (theIconBar at: 8))
				(curRoom newRoom: (curRoom north?))
				(self dispose:)
			)
		)
	)
)
