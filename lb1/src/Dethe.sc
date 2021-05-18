;;; Sierra Script 1.0 - (do not remove this comment)
(script# 268)
(include sci.sh)
(use Main)
(use Intrface)
(use FndBody)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Dethe 0
)
(synonyms
	(ethel body girl)
)

(local
	local0
)
(instance Body of Prop
	(properties
		view 323
		cel 1
	)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dethe of Rgn
	(properties)
	
	(method (init)
		(proc415_1 8)
		(if (== curRoomNum 61)
			(Body view: 331 posn: 42 125 setPri: 11 init:)
		else
			(Body posn: 157 95 setPri: 4 ignoreActors: 1 init:)
			(ego observeControl: 256)
		)
		(= global200 100)
		(= global195 8)
		(self setScript: showCloseup)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(if (event claimed?) (return 1))
		(return
			(if (== (event type?) evSAID)
				(cond 
					((Said 'examine/head') (Print 268 0))
					((Said '/ethel>')
						(cond 
							((Said 'kill') (Print 268 1))
							((Said 'kiss') (Print 268 2))
							((Said 'embrace') (Print 268 3))
							((Said 'get,drag,drag,press,move') (Print 268 4))
							((Said '(examine<in),search')
								(cond 
									(local0 (Print 268 5))
									((< (ego distanceTo: Body) 25)
										(if (== curRoomNum 61)
											(Print 268 6)
										else
											(self setScript: pickUp)
										)
									)
									(else (NotClose))
								)
							)
							((Said 'examine') (Print 268 7))
							((Said 'help') (Print 268 8))
							((Said 'converse') (Print 268 9))
						)
					)
				)
			else
				0
			)
		)
	)
)

(instance showCloseup of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (HandsOff) (= seconds 2))
			(1 (= cycles 1))
			(2
				(if (not (& deadGuests $0008))
					(= deadGuests (| deadGuests $0008))
					(myMusic play:)
					(if (!= curRoomNum 61)
						(Print 268 10 #at 10 10 #icon 323 1 0 #mode 1)
					else
						(Print 268 10 #at 10 10 #icon 331 1 0 #mode 1)
					)
				)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance pickUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face ego Body)
				(= cycles 2)
			)
			(1
				(ego view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2 (Print 268 6) (= cycles 1))
			(3 (ego setCycle: Beg self))
			(4
				(ego view: 0 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)
