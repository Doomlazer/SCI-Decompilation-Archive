;;; Sierra Script 1.0 - (do not remove this comment)
(script# 155)
(include sci.sh)
(use Main)
(use LBRoom)
(use Talker)
(use RandCyc)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm155 0
	Laura 2
)

(instance rm155 of LBRoom
	(properties
		picture 155
		style $000a
	)
	
	(method (init)
		(LoadMany 128 1155 156 157 155)
		(self setRegions: 92)
		(super init:)
		(theMusic2 number: 151 flags: 1 loop: -1 play:)
		(grass init: addToPic:)
		(moon init: addToPic:)
		(cloud1 init: addToPic:)
		(cloud2 init: addToPic:)
		(blue init: addToPic:)
		(lauraArm init: cycleSpeed: 15 setCycle: RandCycle)
		(fan init: setCycle: Fwd)
		(trees1 init: setScript: sMoveTrees1)
		(trees2 init: setScript: sMoveTrees2)
		(curRoom setScript: sCartoon)
	)
	
	(method (dispose)
		(theMusic fade: 0 30 12 1)
		(theMusic2 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 1900 15) modeless: 1)
				(Laura modeless: 1)
				(= ticks 60)
			)
			(1 (messager say: 1 0 0 0 self))
			(2
				(curRoom newRoom: 160)
				(self dispose:)
			)
		)
	)
)

(instance sMoveTrees1 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(trees1
					setLoop: 2
					xStep: 15
					yStep: 15
					setMotion: MoveTo 365 160 self
				)
			)
			(1
				(client x: 0 y: 79)
				(self changeState: 0)
			)
		)
	)
)

(instance sMoveTrees2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(trees2
					setLoop: 2
					xStep: 15
					yStep: 15
					setMotion: MoveTo 438 160 self
				)
			)
			(1
				(client x: 0 y: 79)
				(self changeState: 0)
			)
		)
	)
)

(instance trees1 of Actor
	(properties
		y 74
		view 155
		loop 2
		priority 3
		signal $4010
		moveSpeed 5
	)
)

(instance trees2 of Actor
	(properties
		y 74
		view 155
		loop 2
		cel 1
		priority 3
		signal $4010
		moveSpeed 5
	)
)

(instance fan of Prop
	(properties
		x 157
		y 35
		view 157
		priority 14
		signal $0010
	)
)

(instance lauraArm of Prop
	(properties
		x 144
		y 131
		view 156
	)
)

(instance Laura of Talker
	(properties
		x 0
		y 0
		view 1155
		loop 3
		disposeWhenDone 0
		talkWidth 150
		back 15
		textX 10
		textY 10
	)
	
	(method (init)
		(= font userFont)
		(super init: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		view 1155
		loop 1
	)
)

(instance lauraEyes of Prop
	(properties
		nsTop 85
		nsLeft 180
		view 1155
		loop 2
	)
)

(instance lauraMouth of Prop
	(properties
		nsTop 88
		nsLeft 180
		view 1155
	)
)

(instance grass of View
	(properties
		x 142
		y 87
		view 155
		loop 1
		priority 2
		signal $4010
	)
)

(instance moon of View
	(properties
		x 140
		y 60
		view 155
		priority 1
		signal $4010
	)
)

(instance blue of View
	(properties
		x 34
		y 71
		view 155
		loop 3
		cel 1
		priority 1
		signal $4010
	)
)

(instance cloud1 of View
	(properties
		x 148
		y 48
		view 155
		loop 3
		priority 1
		signal $4010
	)
)

(instance cloud2 of View
	(properties
		x 26
		y 47
		view 155
		loop 3
		priority 1
		signal $4010
	)
)
