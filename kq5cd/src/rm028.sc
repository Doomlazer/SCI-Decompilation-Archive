;;; Sierra Script 1.0 - (do not remove this comment)
(script# 28)
(include sci.sh)
(use Main)
(use Intrface)
(use Door)
(use KQ5Room)
(use Language)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm028 0
)

(local
	[local0 14] = [0 189 0 108 107 130 72 147 123 147 145 153 145 189]
	[local14 12] = [108 128 0 104 0 0 319 0 235 132 162 127]
	[local26 12] = [319 189 174 189 174 153 254 153 237 134 319 4]
)
(instance rm028 of KQ5Room
	(properties
		picture 28
	)
	
	(method (init)
		(super init:)
		(HandsOn)
		(addToPics add: smokeOut1 smokeOut2 doit:)
		(switch prevRoomNum
			(27
				(ego view: 0 setStep: 3 2 posn: 107 135)
			)
			(85 (ego posn: 228 137))
			(else  (ego posn: 160 150))
		)
		(RDoor init: stopUpd:)
		(LDoor init: stopUpd:)
		(cupboard init: stopUpd:)
		(self
			setFeatures: interior
			addObstacle: poly1 poly2 poly3
		)
		(ego init:)
		(poly1 points: @local0 size: 7)
		(poly2 points: @local14 size: 6)
		(poly3 points: @local26 size: 6)
		(theMusic number: 119 loop: -1 play: 60)
	)
	
	(method (doit &tmp temp0 temp1)
		(cond 
			(script (script doit:))
			((& (= temp1 (ego onControl: 0)) $2000) (HandsOff) (theMusic fade:) (self setScript: enter27))
			((& temp1 $0008) (theMusic fade:) (curRoom newRoom: 86))
			((& temp1 $1000) (HandsOff) (self setScript: enterBar))
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(cond 
			((event claimed?) (return))
			(script (return))
		)
	)
)

(instance enterBar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setMotion: PolyPath 227 132 self)
			)
			(1
				(RDoor cycleSpeed: 2 setCycle: End self)
			)
			(2
				(ego setMotion: MoveTo 253 131 self)
			)
			(3 (curRoom newRoom: 85))
		)
	)
)

(instance enter27 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& (ego onControl: 0) $2000)
					(= cycles 1)
				else
					(ego setMotion: PolyPath 112 127 self)
				)
			)
			(1
				(if (not (Btst 79)) (Bset 79) (proc0_29 403))
				(= cycles 1)
			)
			(2
				(LDoor cycleSpeed: 2 setCycle: End self)
			)
			(3 (= seconds 3))
			(4
				(ego
					setPri: 8
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 90 125 self
				)
			)
			(5
				(ego setPri: -1)
				(curRoom newRoom: 27)
			)
		)
	)
)

(instance openCup of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== ((inventory at: 19) owner?) 28)
					(ego setMotion: MoveTo 185 130 self)
				else
					(proc0_29 404)
					(HandsOn)
					(client setScript: 0)
				)
			)
			(1
				((ego head?) hide:)
				(ego
					normal: 0
					view: 470
					loop: 4
					cel: 0
					illegalBits: 0
					posn: 187 130
					cycleSpeed: 2
					setCycle: CT 2 1 self
				)
			)
			(2
				(theAudio number: 8796 loop: 1 play:)
				(cupboard setCycle: End self)
			)
			(3 (ego setCycle: CT 4 1 self))
			(4
				(User canInput: 1)
				(lambInset init: stopUpd:)
				(proc0_29 405)
				(ego
					normal: 1
					view: 0
					loop: 11
					cel: 2
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					posn: 185 130
					illegalBits: -32768
				)
				((ego head?) show:)
				(cupboard stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getLamb of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego setMotion: MoveTo 185 130 self)
			)
			(1
				((ego head?) hide:)
				(ego
					normal: 0
					view: 470
					loop: 4
					cel: 0
					illegalBits: 0
					posn: 187 130
					cycleSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(2
				(proc0_29 9075)
				(lambInset dispose:)
				(ego get: 19)
				(SolvePuzzle 2)
				(ego cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(theAudio number: 8795 loop: 1 play:)
				(cupboard setCycle: Beg self)
				(ego setCycle: CT 4 1)
			)
			(4
				(ego
					normal: 1
					view: 0
					loop: 11
					cel: 2
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					posn: 185 130
					illegalBits: -32768
				)
				((ego head?) show:)
				(cupboard stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance interior of RFeature
	(properties
		nsTop 35
		nsLeft 65
		nsBottom 155
		nsRight 253
	)
	
	(method (handleEvent event)
		(if
			(or
				(event claimed?)
				(not (== (event type?) 16384))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message?)
				(JOY_UPRIGHT
					(proc0_29 406)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance LDoor of Door
	(properties
		x 101
		y 123
		view 470
		loop 2
		priority 2
		signal $4010
	)
	
	(method (handleEvent event)
		(if
			(or
				(event claimed?)
				(not (== (event type?) 16384))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message?)
				(JOY_UPRIGHT
					(proc0_29 407)
					(event claimed: 1)
				)
				(JOY_RIGHT
					(HandsOff)
					(curRoom setScript: enter27)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance RDoor of Door
	(properties
		x 235
		y 114
		view 470
		loop 1
		priority 2
		signal $4010
	)
	
	(method (handleEvent event)
		(if
			(or
				(event claimed?)
				(not (== (event type?) 16384))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message?)
				(JOY_UPRIGHT
					(proc0_29 408)
					(event claimed: 1)
				)
				(JOY_RIGHT
					(curRoom setScript: enterBar)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cupboard of Prop
	(properties
		x 200
		y 107
		view 470
		priority 2
		signal $4010
	)
	
	(method (handleEvent event)
		(if
			(or
				(event claimed?)
				(not (== (event type?) 16384))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message?)
				(JOY_UPRIGHT
					(proc0_29 409)
					(event claimed: 1)
				)
				(JOY_RIGHT
					(if (== (cupboard cel?) 0)
						(HandsOff)
						(curRoom setScript: openCup)
					else
						(curRoom setScript: getLamb)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance lambInset of Prop
	(properties
		x 260
		y 90
		view 470
		loop 3
		priority 15
		signal $4010
	)
	
	(method (doit)
		(super doit:)
		(if (ego mover?) (self dispose:))
	)
	
	(method (handleEvent event)
		(if
			(or
				(event claimed?)
				(not (== (event type?) 16384))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message?)
				(JOY_UPRIGHT
					(proc0_29 405)
					(event claimed: 1)
				)
				(JOY_RIGHT
					(curRoom setScript: getLamb)
					(self dispose:)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type $0002
	)
)

(instance poly2 of Polygon
	(properties
		type $0002
	)
)

(instance poly3 of Polygon
	(properties
		type $0002
	)
)

(instance smokeOut1 of PicView
	(properties
		x 187
		y 3
		view 292
		loop 3
	)
	
	(method (init)
		(= view (proc932_2 292 113))
		(super init: &rest)
	)
)

(instance smokeOut2 of PicView
	(properties
		x 294
		y 7
		view 292
		loop 4
	)
	
	(method (init)
		(= view (proc932_2 292 113))
		(super init: &rest)
	)
)
