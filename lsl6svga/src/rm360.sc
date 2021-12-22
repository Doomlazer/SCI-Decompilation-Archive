;;; Sierra Script 1.0 - (do not remove this comment)
(script# 360)
(include sci.sh)
(use Main)
(use LarryRoom)
(use RangeOsc)
(use Motion)
(use Actor)
(use System)

(public
	rm360 0
)

(instance rm360 of LarryRoom
	(properties
		noun 1
		picture 360
	)
	
	(method (init)
		(super init: &rest)
		(water init: setCycle: Fwd)
		(theGirl init:)
		((ScriptID 0 11) init: curRoom)
		(theMusic number: 360 play: setVol: 127 setLoop: -1)
		(narrator x: 200)
		(self setScript: showerScript)
	)
	
	(method (dispose)
		(narrator x: -1)
		(theMusic fade:)
		((ScriptID 0 11) dispose:)
		(DisposeScript -598)
		(super dispose:)
	)
	
	(method (cue)
		(curRoom newRoom: 350)
	)
)

(instance showerScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(theGame changeScore: 1 191)
				(theGame handsOn:)
				(theGirl cycleSpeed: 12 setCycle: ROsc self 0 2)
				(= seconds 5)
			)
			(2 (messager say: 1 0 1 0 self))
			(3 (theGirl setCycle: End self))
			(4 (= ticks 10))
			(5
				(theGirl setCycle: CT 2 -1 self)
			)
			(6 (= ticks 10))
			(7 (theGirl setCycle: End self))
			(8 (= ticks 30))
			(9 (theGirl setCycle: Beg self))
			(10 (= ticks 30))
			(11
				(theGirl setCycle: CT 2 1 self)
			)
			(12 (= ticks 30))
			(13
				(theGirl setLoop: 1 setCel: 0)
				(water dispose:)
				(= seconds 2)
			)
			(14
				(theGirl cycleSpeed: 12 setCycle: End self)
			)
			(15 (= seconds 3))
			(16 (curRoom newRoom: 350))
		)
	)
)

(instance water of Prop
	(properties
		x 97
		y 9
		priority 136
		fixPriority 1
		view 360
		loop 2
		cel 4
	)
)

(instance theGirl of Prop
	(properties
		x 104
		y 135
		view 360
		cycleSpeed 12
	)
)
