;;; Sierra Script 1.0 - (do not remove this comment)
(script# 28)
(include sci.sh)
(use Main)
(use Intrface)
(use CyclingProp)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	bridgeRm 0
)

(instance bridgeRm of Rm
	(properties
		picture 28
		south 25
	)
	
	(method (init)
		(super init:)
		(bridgeSound play:)
		(self overlay: 128 setRegions: 314)
		(water1CP init:)
		(water2CP init:)
		(water3CP init:)
		(radarCP init:)
		(reflectionCP init:)
		(reflectionCP1 init:)
		(reflectionCP2 init:)
		(addToPics
			add: destroyer1PV destroyer2PV
			eachElementDo: #init
			doit:
		)
		(ego
			init:
			ignoreActors: 1
			posn: 83 80
			view: 228
			loop: 0
			cel: 0
		)
		(captainP init: setScript: captainsScript)
		(binocularV init: hide:)
		(HandsOn)
		(User canControl: 0)
	)
	
	(method (dispose)
		(cls)
		(ego ignoreActors: 0)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene,bay,water]') (Print 28 0))
			(
				(or
					(Said 'use,get,(look[<at])/binoculars')
					(Said 'binoculars<use')
				)
				(Print 28 1)
			)
		)
	)
)

(instance water1CP of CyclingProp
	(properties
		y 142
		x 259
		view 28
		loop 2
	)
)

(instance water2CP of CyclingProp
	(properties
		y 142
		x 259
		view 28
		loop 3
	)
)

(instance water3CP of CyclingProp
	(properties
		y 92
		x 209
		view 28
		loop 1
	)
)

(instance radarCP of CyclingProp
	(properties
		y 77
		x 37
		view 28
		priority 15
	)
)

(instance reflectionCP of CyclingProp
	(properties
		y 41
		x 197
		view 28
		loop 4
	)
)

(instance reflectionCP1 of CyclingProp
	(properties
		y 38
		x 246
		view 28
		loop 4
	)
)

(instance reflectionCP2 of CyclingProp
	(properties
		y 39
		x 254
		view 28
		loop 4
	)
)

(instance destroyer1PV of PV
	(properties
		y 36
		x 304
		view 128
	)
)

(instance destroyer2PV of PV
	(properties
		y 36
		x 286
		view 128
		cel 1
	)
)

(instance captainP of Prop
	(properties
		y 80
		x 128
		view 228
		loop 1
	)
	
	(method (init)
		(keyDownHandler add: self)
		(mouseDownHandler add: self)
		(self ignoreActors: 1)
		(super init: &rest)
	)
	
	(method (dispose)
		(keyDownHandler delete: self)
		(mouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance binocularV of View
	(properties
		y 50
		x 70
		view 128
	)
	
	(method (show param1)
		(self cel: param1)
		(super show:)
	)
)

(instance captainsScript of Script
	(properties
		seconds 3
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(1
				(Print 28 2 #dispose)
				(= seconds 10)
			)
			(2
				(keyDownHandler delete: self)
				(mouseDownHandler delete: self)
				(if modelessDialog (modelessDialog dispose:))
				(= seconds 10)
			)
			(3
				(if modelessDialog (modelessDialog dispose:))
				(Print 28 3)
				(= start state)
				(= seconds 10)
			)
			(4 (self init:))
		)
	)
	
	(method (handleEvent event)
		(cond 
			((== state 1) (= cycles 1))
			((super handleEvent: event))
			((Said 'address[/man,captain]') (client setScript: binocularScript))
			(
				(or
					(Said 'exit,exit')
					(Said 'go<below')
					(Said 'climb<down/ladder')
				)
				(Print 28 4)
			)
		)
	)
)

(instance binocularScript of Script
	(properties)
	
	(method (dispose)
		(if modelessDialog (modelessDialog dispose:))
		(super dispose:)
	)
	
	(method (changeState newState)
		(if modelessDialog (modelessDialog dispose:))
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 28 5 #dispose)
			)
			(1 (Print 28 6 #dispose))
			(2 (Print 28 7 #dispose))
			(3
				(captainP setPri: 6 setCycle: CT 7 1 self)
			)
			(4 (= cycles 3))
			(5
				(ego setPri: 7 setCycle: CT 4 1 self)
			)
			(6
				(captainP setCycle: End self)
			)
			(7 (ego setCycle: End self))
			(8
				(binocularV show: 2)
				(= seconds 10)
			)
			(9
				(binocularV hide:)
				(Print 28 8 #dispose)
			)
			(10
				(ego setPri: 6 setCycle: CT 4 -1 self)
			)
			(11
				(captainP setPri: 7 setCycle: CT 7 -1 self)
			)
			(12
				(ego setCycle: Beg self)
				(captainP setCycle: Beg self)
			)
			(13)
			(14
				(User canInput: 1)
				(Print 28 9 #dispose)
				(= seconds 15)
			)
			(15
				(User canInput: 0)
				(Print 28 10 #dispose)
			)
			(16
				(bridgeSound fade:)
				(Print 28 11 #dispose)
				(= seconds 10)
			)
			(17
				(bridgeSound dispose:)
				(curRoom newRoom: 25)
			)
		)
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((== state 14)
				(cond 
					((== (event type?) evSAID)
						(if
							(or
								(Said 'get,(look[<at])/binoculars')
								(Said 'binoculars<use')
							)
							(self setScript: lookBinocsScript self seconds: 0)
						)
					)
					(modelessDialog (modelessDialog dispose:))
				)
			)
			((OneOf state 0 1 2 9 15 16) (= cycles 2))
		)
	)
)

(instance lookBinocsScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(captainP setPri: 6 setCycle: CT 7 1 self)
			)
			(1 (= cycles 3))
			(2
				(ego setPri: 7 setCycle: CT 4 1 self)
			)
			(3
				(captainP setCycle: End self)
			)
			(4 (ego setCycle: End self))
			(5
				(binocularV show: 3)
				(= seconds 5)
			)
			(6
				(binocularV hide:)
				(Print 28 8 #dispose)
				(ego setPri: 6 setCycle: CT 4 -1 self)
			)
			(7
				(captainP setPri: 7 setCycle: CT 7 -1 self)
			)
			(8
				(ego setCycle: Beg self)
				(captainP setCycle: Beg self)
			)
			(9)
			(10 (self dispose:))
		)
	)
)

(instance bridgeSound of Sound
	(properties
		number 90
		priority 15
		loop -1
	)
)
