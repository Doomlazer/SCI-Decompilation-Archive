;;; Sierra Script 1.0 - (do not remove this comment)
(script# 705)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use GControl)
(use System)

(public
	askFire 0
)

(local
	newGameControls
)
(instance askFire of Code
	(properties)
	
	(method (init param1 param2 param3 &tmp temp0)
		((= newGameControls (GameControls new:))
			window:
				((GloryWindow new:)
					top: 40
					left: 65
					bottom: 80
					right: 256
					priority: 15
					yourself:
				)
		)
		((= temp0 (fireIcon new: param1 param2 param3 1))
			view: 935
			loop: 1
			cel: 0
			nsTop: 2
			nsLeft: 2
			modifiers: 1
		)
		(newGameControls add: temp0)
		((= temp0 (fireIcon new: param1 param2 param3 2))
			nsTop: 25
			nsLeft: 5
			cursor: 1
		)
		(newGameControls add: temp0)
		((= temp0 (fireIcon new: param1 param2 param3 3))
			nsTop: 25
			nsLeft: 95
			cursor: 2
		)
		(newGameControls add: temp0)
		(newGameControls init: show: dispose:)
		(= newGameControls 0)
	)
)

(instance fireIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
	)
	
	(method (new param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(= temp0 (Clone self))
		(if argc
			(= temp1
				(Message msgSIZE curRoomNum param1 param2 param3 param4)
			)
			(temp0 message: (Memory memALLOC_NONCRIT temp1))
			(Message
				msgGET
				curRoomNum
				param1
				param2
				param3
				param4
				(temp0 message?)
			)
		)
		(return temp0)
	)
	
	(method (dispose)
		(Memory memFREE message)
		(super dispose:)
	)
	
	(method (show)
		(= nsRight (+ nsLeft (if (== loop 1) 0 else 90)))
		(= nsBottom (if (== loop 1) nsTop else (+ nsTop 15)))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display
			message
			dsCOORD
			(if (== loop 1) nsLeft else (+ nsLeft 20))
			(+ nsTop 2)
			dsFONT
			(if (== loop 1) 123 else 0)
			dsCOLOR
			17
			dsALIGN
			modifiers
			dsWIDTH
			(if (== loop 1) 189 else 70)
		)
	)
	
	(method (select)
		(return
			(if (!= loop 1)
				(= controlRet cursor)
				(newGameControls
					state: (& (newGameControls state?) $ffdf)
				)
			else
				(return 0)
			)
		)
	)
	
	(method (highlight param1 &tmp temp0)
		(if (!= loop 1)
			(if param1
				(DrawCel view loop 1 nsLeft nsTop -1)
				(= temp0 46)
			else
				(DrawCel view loop 0 nsLeft nsTop -1)
				(= temp0 17)
			)
			(Display
				message
				dsCOORD
				(if (== loop 1) nsLeft else (+ nsLeft 20))
				(+ nsTop 2)
				dsFONT
				(if (== loop 1) 123 else 0)
				dsCOLOR
				temp0
				dsALIGN
				modifiers
				dsWIDTH
				(if (== loop 1) 189 else 70)
			)
		)
	)
)
