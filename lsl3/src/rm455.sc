;;; Sierra Script 1.0 - (do not remove this comment)
(script# 455)
(include game.sh)
(use Main)
(use Face)
(use Intrface)
(use Game)
(use System)

(public
	rm455 0
)
(synonyms
	(babe entertainer)
)

(instance rm455 of Room
	(properties
		picture 455
	)
	
	(method (init)
		(super init:)
		(self setRegions: FACE setLocales: GIRL setScript: RoomScript)
		(NotifyScript 71 1 104 72)
		(NotifyScript 71 2 133 60)
		(NotifyScript 71 3 104 69)
		(NotifyScript 71 4 135 55)
		(NotifyScript 71 5 133 82)
		(NotifyScript 71 6 138 91)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(PersonSays 455 73)
				(theGame changeScore: 100)
				(= currentStatus egoAUTO)
				(++ state)
				(AnimateFace 2 99)
				(= cycles 33)
			)
			(2
				(EgoSays 455 74)
				(PersonSays 455 75)
				(AnimateFace 2 55)
				(= cycles 33)
			)
			(3 (curRoom newRoom: 450))
		)
	)
	
	(method (handleEvent event &tmp item [str 200])
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(cond 
			(
				(or
					(Said '(go<out),date/babe')
					(Said 'get/anyword/building')
					(Said 'ask/anyword/date')
					(Said 'ask,get/date')
					(Said 'make/enjoy,date')
					(Said 'let<make/enjoy,date')
					(Said 'anyword/make/enjoy')
					(Said
						'go/area,penthouse,backdrop,comedian,club,date,exit,bar,show,dance'
					)
				)
				(cond 
					((not (InRoom iDivorceDecree)) (EgoSays 455 0) (PersonSays 455 1) (AnimateFace 4))
					((not larryBuffed) (EgoSays 455 2) (PersonSays 455 3) (AnimateFace 4))
					((Btst fNotShower) (EgoSays 455 4) (PersonSays 455 5) (AnimateFace 4))
					((Btst fNotUseSoap) (EgoSays 455 4) (PersonSays 455 6) (AnimateFace 4))
					((Btst fNotUseDeodorant) (EgoSays 455 4) (PersonSays 455 7) (AnimateFace 4))
					((not (InRoom iOrchids)) (EgoSays 455 8) (PersonSays 455 9))
					(else (self changeState: 1))
				)
			)
			((or (Said '/marriage') (Said 'marry/')) (Print 455 10))
			((Said 'bang') (PersonSays 455 11) (AnimateFace 4 4))
			((Said '/neck') (Print 455 12))
			((Said '/penthouse,area') (PersonSays 455 13))
			((Said 'caress') (PersonSays 455 14) (AnimateFace 2 5))
			((Said 'embrace') (PersonSays 455 15) (AnimateFace 2 5))
			((Said '/music,gamble') (EgoSays 455 16) (PersonSays 455 17) (AnimateFace 2 5))
			((Said 'crap') (PersonSays 455 18) (AnimateFace 4 4))
			((Said 'address')
				(switch (Random 1 3)
					(1 (PersonSays 455 19))
					(2 (PersonSays 455 20))
					(else  (PersonSays 455 21))
				)
			)
			((Said 'show/ball') (EgoSays 455 22) (PersonSays 455 23) (AnimateFace 2 20))
			((Said 'make/joke')
				(Print 455 24)
				(Print 455 25 #at -1 144)
				(PersonSays 455 26)
				(AnimateFace 7 22)
			)
			((Said 'enjoy/ya,babe') (EgoSays 455 27) (PersonSays 455 28) (AnimateFace 5 44))
			((Said '/pass,backstage') (EgoSays 455 29) (PersonSays 455 30))
			((Said 'get,gamble/music,buy') (EgoSays 455 31) (PersonSays 455 32))
			(
				(or
					(Said 'cease/look')
					(Said 'look<cease')
					(Said 'look/bar,area')
					(Said 'done,exit,exit,done,exit,go')
					(Said
						'exit,nightstand,(nightstand<up),(get<off,up)/barstool'
					)
				)
				(self changeState: 2)
			)
			((Said 'look>')
				(cond 
					((Said '/calf') (PersonSays 455 33) (AnimateFace 3 22))
					((Said '/bracelet') (Print 455 34))
					((Said '/ear') (Print 455 35))
					((Said '/boob') (Print 455 36) (PersonSays 455 37) (AnimateFace 6 12))
					((Said '/keyboard') (Print 455 38))
					((Said '[/keyboard,babe,babe]') (Print 455 39) (PersonSays 455 40) (AnimateFace 2 33))
				)
			)
			((Said 'give,throw,backdrop,show,backdrop>')
				(= item (inventory saidMe:))
				(event claimed: FALSE)
				(cond 
					((Said '[/noword]') (Print 455 41))
					((not item) (Print 455 42))
					((not (item ownedBy: ego)) (DontHave))
					((Btst fNotShower) (PersonSays 455 5) (AnimateFace 4))
					((Btst fNotUseSoap) (PersonSays 455 6) (AnimateFace 4))
					((== item (inventory at: iCreditCard)) (EgoSays 455 43) (PersonSays 455 44) (AnimateFace 4))
					((== item (inventory at: iGrass))
						(if (== (item view?) 23)
							(EgoSays 455 45)
							(PersonSays 455 46)
						else
							(EgoSays 455 47)
							(PersonSays 455 48)
						)
						(AnimateFace 4)
					)
					((== item (inventory at: iSoap)) (EgoSays 455 49) (PersonSays 455 50) (AnimateFace 4))
					((== item (inventory at: iMoney))
						(EgoSays (Format @str 455 51 dollars))
						(PersonSays 455 52)
						(AnimateFace 4)
					)
					((== item (inventory at: iLandDeed)) (EgoSays 455 53) (PersonSays 455 54) (AnimateFace 4))
					((== item (inventory at: iTowel)) (EgoSays 455 55) (PersonSays 455 56) (AnimateFace 4))
					((== item (inventory at: iSpaKeycard)) (EgoSays 455 57) (PersonSays 455 58) (AnimateFace 2))
					((== item (inventory at: iDivorceDecree))
						(EgoSays 455 59)
						(if (not (ego has: iSpaKeycard))
							(Print 455 60)
							(ego get: iSpaKeycard)
							(Bset fFoundGymKeyAccidentally)
							(Print 455 61)
						)
						(theGame changeScore: 100)
						(PutInRoom iDivorceDecree)
						(PersonSays 455 62)
						(AnimateFace 2)
					)
					((== item (inventory at: iOrchids))
						(cond 
							((and (== orchidMinutes 1) (== orchidSeconds 0)) (EgoSays 455 63) (PersonSays 455 64) (AnimateFace 4))
							((not (InRoom iDivorceDecree)) (EgoSays 455 65) (PersonSays 455 66) (AnimateFace 4))
							((not (== (item view?) 26)) (EgoSays 455 67) (PersonSays 455 68) (AnimateFace 4))
							(else
								(EgoSays 455 69)
								(PersonSays 455 70)
								(theGame changeScore: 100)
								(PutInRoom iOrchids)
								(AnimateFace 2)
							)
						)
					)
					(else
						(EgoSays (Format @str 455 71 (item name?)))
						(PersonSays 455 72)
					)
				)
				(event claimed: TRUE)
			)
		)
	)
)
