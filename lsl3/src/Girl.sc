;;; Sierra Script 1.0 - (do not remove this comment)
(script# GIRL)
(include game.sh)
(use Intrface)
(use Game)

(public
	rm70 0
)

(instance rm70 of Locale
	(properties)
	
	(method (handleEvent event)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(cond 
			(
				(or
					(Said 'embrace') (Said '/embrace') (Said '//embrace') (Said '/coconut')
					(Said '//coconut') (Said '/boob')(Said '//boob')
				)
				(Print 70 0)
			)
			((Said '/ass')
				(Print 70 1)
			)
			((Said '/bracelet')
				(Print 70 2)
			)
			((Said '/body')
				(Print 70 3)
			)
			((Said '/ankle')
				(Print 70 4)
			)
			((Said '/hair')
				(Print 70 5)
			)
			((Said '/ear')
				(Print 70 6)
			)
			((Said '/nose')
				(Print 70 7)
				(Print 70 8 #at -1 144)
			)
			((Said '/lip,lip')
				(Print 70 9)
			)
			((Said '/eye')
				(Print 70 10)
			)
			((Said '/dicklicker')
				(Print 70 11)
			)
		)
	)
)
