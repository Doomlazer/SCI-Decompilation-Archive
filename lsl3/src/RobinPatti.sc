;;; Sierra Script 1.0 - (do not remove this comment)
(script# ROBIN_PATTI)
(include game.sh)
(use Main)
(use Intrface)
(use Game)

(public
	rm81 0
)

(instance rm81 of Locale
	(properties)
	
	(method (handleEvent event)
		(if (or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(cond 
			((Said '/hair')
				(Print 81 0)
			)
			((Said '/larry')
				(Print 81 1)
			)
			((Said 'give')
				(Printf 81 2 currentEgo)
			)
			((or (Said '//buffet,buffet') (Said '/buffet,buffet'))
				(Print 81 3)
			)
			((Said '/eye')
				(Print 81 4)
			)
		)
	)
)
