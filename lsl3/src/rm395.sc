;;; Sierra Script 1.0 - (do not remove this comment)
(script# 395)
(include game.sh)
(use Main)
(use Face)
(use Intrface)
(use Game)
(use System)

(public
	rm395 0
)
(synonyms
	(babe bambi)
)

(local
	timesTalkedToBambi
	[str 55]
)
(instance rm395 of Room
	(properties
		picture 395
	)
	
	(method (init)
		(super init:)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript)
		(NotifyScript 71 1 111 47)
		(NotifyScript 71 2 174 85)
		(NotifyScript 71 3 98 60)
		(NotifyScript 71 4 165 96)
		(NotifyScript 71 5 93 104)
		(NotifyScript 71 6 90 111)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(self dispose: 71)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(7
				(HandsOff)
				(EgoSays 395 53)
				(PersonSays 395 54)
				(AnimateFace 2 22)
				(= cycles 22)
			)
			(8
				(theGame changeScore: 99)
				(EgoSays 395 55)
				(PersonSays 395 56)
				(AnimateFace 2 22)
				(= cycles 22)
			)
			(9
				(EgoSays 395 57)
				(PersonSays 395 58)
				(AnimateFace 2 22)
				(= cycles 22)
				(music fade:)
			)
			(10
				(= currentStatus 1)
				(music stop:)
				(curRoom newRoom: 390)
			)
			(11
				(EgoSays 395 59)
				(PersonSays 395 60)
				(AnimateFace 2 33)
				(= cycles 22)
			)
			(12 (curRoom newRoom: 390))
		)
	)
	
	(method (handleEvent event &tmp item)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed?))
				modelessDialog
				(== (event message?) ENTER)
				(== (event type?) keyDown)
			)
			(event claimed: TRUE)
			(cls)
			(self cue:)
		)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(cond 
			((Said 'give>')
				(= item (inventory saidMe:))
				(event claimed: FALSE)
				(cond 
					((Said '[/noword]') (Print 395 0))
					((not item) (Print 395 1))
					((not (item ownedBy: ego)) (DontHave))
					((== item (inventory at: iSpaKeycard)) (PersonSays 395 2) (AnimateFace 4))
					((== item (inventory at: iSoap)) (PersonSays 395 3) (AnimateFace 4))
					((== item (inventory at: iDivorceDecree)) (EgoSays 395 4) (PersonSays 395 5) (AnimateFace 4 6))
					((== item (inventory at: iKnife)) (PersonSays 395 6) (AnimateFace 4))
					((== item (inventory at: iOrchids)) (PersonSays 395 7) (AnimateFace 4))
					((== item (inventory at: iTowel)) (PersonSays 395 8) (AnimateFace 4))
					(else (PersonSays 395 9) (AnimateFace 4))
				)
				(event claimed: TRUE)
			)
			((Said 'bang') (Print 395 10) (PersonSays 395 11) (AnimateFace 4 4))
			((or (Said 'aid//tape') (Said 'aid/tape'))
				(if (not larryBuffed)
					(EgoSays 395 12)
					(PersonSays 395 13)
					(AnimateFace 4 22)
				else
					(self changeState: 7)
				)
			)
			(
			(or (Said 'aid') (Said '/aid') (Said '//aid')) (if (Random 0 1) (Print 395 14) else (Print 395 15)))
			((or (Said 'ask//tape') (Said 'ask/tape')) (EgoSays 395 16) (PersonSays 395 17) (AnimateFace 4 11))
			(
				(or
					(Said 'class,(work<out)')
					(Said '/class,class,(work<out)')
					(Said '//class,class,(work<out)')
				)
				(EgoSays 395 18)
				(PersonSays 395 19)
				(AnimateFace 4 4)
			)
			(
				(or
					(Said '/tan,booth,booth')
					(Said '//tan,booth,booth')
				)
				(EgoSays 395 20)
				(PersonSays 395 21)
			)
			((or (Said '/attendant') (Said '//attendant')) (EgoSays 395 22) (PersonSays 395 23) (AnimateFace 6 5))
			((Said 'show/ball') (EgoSays 395 24) (PersonSays 395 25) (AnimateFace 2 20))
			((Said 'make/joke')
				(EgoSays 395 26)
				(EgoSays 395 27 67 -1 144)
				(PersonSays 395 28)
				(AnimateFace 7 22)
			)
			(
				(or
					(Said '(out<go),dance,show,date/')
					(Said 'get/babe/building')
					(Said
						'ask,go//area,backdrop,comedian,club,date,exit,bar,show,dance'
					)
					(Said
						'ask,go/area,backdrop,comedian,club,date,exit,bar,show,dance'
					)
				)
				(EgoSays 395 29)
				(PersonSays 395 30)
				(AnimateFace 4 11)
			)
			((Said '/equipment,camera,camera') (EgoSays 395 31) (PersonSays 395 32) (AnimateFace 2 20))
			((Said 'address/babe')
				(cond 
					((not larryBuffed)
						(EgoSays (Format @str 395 33 introductoryPhrase))
						(PersonSays 395 34)
					)
					((Btst fNotShower)
						(Printf 395 33 introductoryPhrase)
						(PersonSays 395 35)
						(AnimateFace 4 11)
					)
					((Btst fNotUseSoap)
						(Printf 395 33 introductoryPhrase)
						(PersonSays 395 36)
						(AnimateFace 4 11)
					)
					((Btst fNotUseDeodorant)
						(Printf 395 33 introductoryPhrase)
						(PersonSays 395 37)
						(AnimateFace 4 11)
					)
					(else
						(AnimateFace 2 20)
						(switch (++ timesTalkedToBambi)
							(1
								(EgoSays 395 38)
								(PersonSays 395 32)
							)
							(2
								(EgoSays 395 39)
								(PersonSays 395 17)
							)
							(else 
								(EgoSays 395 40)
								(PersonSays 395 41)
							)
						)
					)
				)
			)
			((or (Said 'enjoy/ya') (Said '/enjoy/ya')) (EgoSays 395 42) (PersonSays 395 43) (AnimateFace 5 44))
			(
				(or
					(Said 'cease/look')
					(Said 'look<cease')
					(Said 'look/area')
					(Said 'done,exit,exit,done,exit,go')
					(Said 'nightstand,(nightstand<up),(get<off,up)')
				)
				(self changeState: 11)
			)
			((Said 'look>')
				(cond 
					((Said '/calf') (PersonSays 395 44) (AnimateFace 3 22))
					((Said '/bracelet') (Print 395 45))
					((Said '/ear') (Print 395 46))
					((or (Said '/tape') (Said '//tape')) (EgoSays 395 47) (PersonSays 395 48))
					((Said '/boob') (Print 395 49) (PersonSays 395 50) (AnimateFace 6 12))
					((Said '[/area,babe]') (Print 395 51) (PersonSays 395 52) (AnimateFace 2 33))
				)
			)
		)
	)
)
