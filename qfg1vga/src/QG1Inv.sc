;;; Sierra Script 1.0 - (do not remove this comment)
(script# GLORYINV)
(include game.sh) (include "206.shm")
(use Main)
(use GloryWindow)
(use Procs)
(use Print)
(use IconBar)
(use Invent)
(use System)

(public
	gloryInv 0
	pageCode 1
	dropInv 2
)

(local
	local0
	local1
)
(class QG1InvItem of InvItem
	(properties
		view 950
		loop 0
		cel 0
		weight 0
		amount 0
		amtDropped 0
	)
	
	(method (select)
		(if (super select: &rest)
			((= cursor invCursor) view: 960 loop: loop cel: cel)
		)
	)
	
	(method (doVerb theVerb &tmp i temp1 temp2 [temp3 50] [str 30] [temp83 10] [temp93 20])
		(if (== theVerb V_HELP)
			(return TRUE)
		)
		(Print font: userFont mode: teJustCenter)
		(Message MsgGet GLORYINV N_ITEM (self message?) NULL 1 @temp93)
		(return
			(switch theVerb
				(V_LOOK
					(if local1
						(if (== amtDropped 1)
							(Message MsgGet GLORYINV N_ITEM NULL NULL 22 @str)
							(Print addTextF: @temp3 @str @temp93 init:)
						else
							(Message MsgGet GLORYINV N_ITEM NULL NULL 23 @str)
							(Print addTextF: @temp3 @str amtDropped @temp93 init:)
						)
					else
						(= temp1 (= temp2 0))
						(= temp1 (/ weight 60))
						(if
							(and
								(not (= temp2 (/ (mod weight 60) 6)))
								(not temp1)
							)
							(= temp2 1)
						)
						(if (> (self amount?) 1)
							(Message MsgGet GLORYINV N_ITEM NULL NULL 1 @str)
						else
							(Message MsgGet GLORYINV N_ITEM NULL NULL 2 @str)
						)
						(Print
							addTextF: @temp3 @str amount @temp93 temp1 temp2
							init:
						)
					)
				)
				(V_DROP
					(cond 
						((and (== self dagger) (== (self amount?) 1) (not (ego has: iSword)))
							(Print addText: N_ITEM NULL NULL 4 0 0 GLORYINV init:)
						)
						(
							(OneOf
								self
								sword
								shield
								disenchant
								thiefKit
								magicGem
								ring
								brassKey
								magicMirror
								seed
								acorn
								fairyDust
								greenFur
							)
							(Message MsgGet GLORYINV N_ITEM NULL NULL 5 @str)
							(Print addTextF: @temp3 @str @temp93 init:)
						)
						((== curRoomNum 322)
							(Print addText: N_ITEM NULL NULL 6 0 0 GLORYINV init:)
						)
						((> amount 1)
							(self dumpIt: 1)
							(Message MsgGet GLORYINV N_ITEM NULL NULL 7 @str)
							(Print addTextF: @temp3 @str @temp93 init:)
						)
						(else
							(Message MsgGet GLORYINV N_ITEM NULL NULL 8 @str)
							(Print addTextF: @temp3 @str @temp93 init:)
							(self dumpIt: 1)
							(if (== (theIconBar curInvIcon?) self)
								(theIconBar curInvIcon: 0)
							)
							(= i 0)
							(while (< i NUM_INVITEMS)
								(if (== ((inventory at: i) owner?) ego)
									(= i (+ NUM_INVITEMS 1))
								)
								(++ i)
							)
							(inventory hide:)
							(if (> i NUM_INVITEMS)
								(inventory curIcon: invDrop show:)
							else
								(= local0 1)
								(invPageUp select:)
							)
						)
					)
				)
				(V_TRIGGER	;strangely, this uses the trigger verb
					(if (not amtDropped)
						(Print addText: N_ITEM NULL NULL 20 0 0 GLORYINV init:)
					else
						(if (== amtDropped 1)
							(Message MsgGet GLORYINV N_ITEM NULL NULL 25 @str)
						else
							(Message MsgGet GLORYINV N_ITEM NULL NULL 24 @str)
						)
						(Print addTextF: @temp3 @str @temp93 init:)
						(self pickItUp: 1)
					)
				)
				(9 0)
				(else 
					(Message MsgGet GLORYINV N_ITEM NULL NULL 3 @str)
					(Message MsgGet GLORYINV 3 theVerb 0 1 @temp83)
					(Print addTextF: @temp3 @str @temp83 @temp93 init:)
				)
			)
		)
	)
	
	(method (dumpIt param1 &tmp i)
		(= amtDropped
			(+
				amtDropped
				(= i (if (> param1 amount) amount else param1))
			)
		)
		(ego use: (gloryInv indexOf: self) i)
		(if (not amount) (= owner 0))
		(dropInv addToFront: self)
	)
	
	(method (pickItUp param1 &tmp i [temp1 2])
		(= amtDropped
			(-
				amtDropped
				(= i
					(if (> param1 amtDropped) amtDropped else param1)
				)
			)
		)
		(ego get: (gloryInv indexOf: self) i)
		(if (not amtDropped)
			(dropInv hide: delete: self)
			(if (> (dropInv size?) MARGIN)
				(= local1 1)
				((= inventory dropInv) showSelf:)
			else
				((= inventory gloryInv) showSelf:)
			)
		)
	)
)

(instance gloryInv of Inventory
	(properties
		normalHeading 3819
		empty 3837
	)
	
	(method (init)
		((= inventory self)
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			add:
				silver
				rations
				sword
				chainMail
				leather
				shield
				dagger
				lockPick
				thiefKit
				thiefLicense
				rock
				flask
				healingPotion
				manaPotion
				staminaPotion
				disenchant
				brassKey
				magicGem
				ring
				ghostOil
				magicMirror
				mandrake
				fruit
				vegetables
				acorn
				seed
				flowers
				greenFur
				fairyDust
				flyingWater
				mushroom
				vase
				candelabra
				musicBox
				candleSticks
				pearls
				cheetaurClaw
				trollBeard
				gold
				paper
				invPageDown
				invPageUp
				invLook
				invSelect
				invDrop
				invPickup
				invWeight
				ok
				invHelp
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			state: NOCLICKHELP
		)
		(ego get: iLeather get: iRations 5 get: iGold 4 get: iSilver 10)
		(dropInv init:)
	)
	
	(method (hide &tmp i)
		(super hide: &rest)
		(theGame setCursor: ((theIconBar curIcon?) cursor?) TRUE)
	)
	
	(method (noClickHelp)
		(super noClickHelp: &rest)
		(= curIcon invSelect)
		(theGame setCursor: (invSelect cursor?) TRUE)
	)
)

(instance dropInv of Inventory
	(properties
		normalHeading 3819
		empty 3837
	)
	
	(method (init)
		(self
			window: invWin
			helpIconItem: invHelp
			okButton: ok
			add: invLook invPickup ok invHelp
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			state: 2048
		)
	)
	
	(method (showSelf &tmp i)
		(= i 0)
		(while (< i (- size MARGIN))
			((self at: i) owner: ego)
			(++ i)
		)
		(super showSelf: &rest)
	)
	
	(method (show)
		(= curIcon invPickup)
		(super show: &rest)
	)
	
	(method (hide &tmp i)
		(if (== inventory self) (= inventory gloryInv))
		(= local1 0)
		(= i 0)
		(while (< i (- size MARGIN))
			(if ((self at: i) amount?)
				((self at: i) owner: ego)
			)
			(++ i)
		)
		(super hide: &rest)
		(theGame setCursor: ((theIconBar curIcon?) cursor?) TRUE)
	)
	
	(method (noClickHelp)
		(super noClickHelp: &rest)
		(= curIcon invPickup)
		(theGame setCursor: (invPickup cursor?) TRUE)
	)
)

(instance invWin of GloryWindow
	(properties
		yOffset 28
	)
)

(instance pageCode of Code
	
	(method (init &tmp i temp1)
		(if (Btst fFlag361)
			(Bclr fFlag361)
			(= i 0)
			(while (< i (- (dropInv size?) MARGIN))
				((dropInv at: i) owner: ego)
				(++ i)
			)
			((= inventory dropInv) okButton: ok showSelf:)
		else
			(if
				(or
					(OneOf curRoomNum
						vBear vMinotaur vSaurus vMantray vCheetaur vGoblin
						vOgre vTroll vDragon vBrigand vBrigandLeader
					)
					(== curRoomNum 32)
				)
				(return)
			)
			(invSelect message: -1)
			(= global423 0)
			(invPageUp owner: 0)
			(invPageDown owner: 0)
			(= i 0)
			(while (< i NUM_INVITEMS)
				((inventory at: i) owner: 0)
				(if
					(and
						(!= i iGold)
						(or
							(> ((inventory at: i) amount?) 0)
							(== i 0)
						)
						(< (++ global423) 24)
					)
					((inventory at: i) owner: ego)
				)
				(++ i)
			)
			(if (> global423 23)
				(invPageDown highlightColor: -1 owner: ego)
			)
			(inventory showSelf:)
		)
	)
)

(instance invPageDown of InvItem
	(properties
		view 991
		loop 5
		message 75
		signal (| RELVERIFY IMMEDIATE)
		noun N_PAGETURNER
		modNum GLORYINV
		helpVerb V_HELP
	)
	
	(method (show)
		(super show:)
		(DrawCel
			991
			7
			0
			(+ nsLeft (CelWide view loop cel))
			nsTop
			-1
		)
	)
	
	(method (select &tmp i)
		(return
			(if (super select: &rest)
				(= i 0)
				(while (< i NUM_INVITEMS)
					(if
						(and
							(!= i iGold)
							(or
								(> ((inventory at: i) amount?) 0)
								(== i 0)
							)
						)
						(if (== ((inventory at: i) owner?) ego)
							((inventory at: i) owner: 1)
						else
							((inventory at: i) owner: ego)
						)
					)
					(++ i)
				)
				(invPageUp owner: ego highlightColor: -1)
				(= owner 0)
				(inventory hide: showSelf:)
				(return 0)
			else
				0
			)
		)
	)
)

(instance invPageUp of InvItem
	(properties
		view 991
		loop 5
		message V_PAGETURNER
		signal (| RELVERIFY IMMEDIATE)
		noun N_PAGETURNER
		modNum GLORYINV
		helpVerb V_HELP
	)
	
	(method (show)
		(super show:)
		(DrawCel
			991
			7
			0
			(+ nsLeft (CelWide view loop cel))
			nsTop
			-1
		)
	)
	
	(method (select &tmp i)
		(return
			(if (super select: &rest)
				(= i 0)
				(while (< i NUM_INVITEMS)
					(if
						(and
							(!= i iGold)
							(or
								(> ((inventory at: i) amount?) 0)
								(== i 0)
							)
						)
						(if (== ((inventory at: i) owner?) 1)
							((inventory at: i) owner: ego)
						else
							((inventory at: i) owner: 0)
						)
					)
					(++ i)
				)
				(inventory hide:)
				(= owner 0)
				(if (not local0)
					(invPageDown owner: ego highlightColor: -1)
					(= owner 0)
				)
				(= local0 0)
				(inventory showSelf:)
				(return 0)
			else
				0
			)
		)
	)
)

(instance invLook of IconItem
	(properties
		view 991
		loop 2
		cel 0
		cursor 941
		message V_LOOK
		signal (| FIXED_POSN RELVERIFY)
		noun N_LOOK
		modNum GLORYINV
		helpVerb V_HELP
	)
)

(instance invSelect of IconItem
	(properties
		view 991
		loop 0
		cel 0
		cursor 942
		message V_DO
		noun N_USE
		modNum GLORYINV
		helpVerb V_HELP
	)
)

(instance invPickup of IconItem
	(properties
		view 991
		loop 8
		cel 0
		cursor 938
		message V_TRIGGER
		noun N_PICKUP
		modNum GLORYINV
		helpVerb V_HELP
	)
	
	(method (select &tmp temp0 i)
		(return
			(if (super select: &rest)
				(= temp0 0)
				(= i 0)
				(while (< i 40)
					(if ((gloryInv at: i) amtDropped?) (= temp0 1))
					(++ i)
				)
				(if (= local1 temp0)
					(if (== inventory gloryInv)
						(Bset 361)
						(inventory hide:)
					)
					(return 1)
				else
					(Print addText: N_ITEM NULL NULL 20 0 0 GLORYINV init:)
					(return 0)
				)
			else
				0
			)
		)
	)
)

(instance invDrop of IconItem
	(properties
		view 991
		loop 6
		cel 0
		cursor 939
		message V_DROP
		noun N_DROP
		modNum GLORYINV
		helpVerb V_HELP
	)
)

(instance invWeight of IconItem
	(properties
		view 991
		loop 4
		cel 0
		cursor 949
		message V_HELP
		signal (| HIDEBAR RELVERIFY IMMEDIATE)
		noun N_STATUS
		modNum GLORYINV
		helpVerb V_HELP
	)
	
	(method (select &tmp weight [temp1 60] [temp61 60])
		(return
			(if (super select: &rest)
				(= weight (WtCarried))
				(Message MsgGet GLORYINV 9 0 0 1 @temp1)
				(Print
					font: userFont
					mode: 1
					addTextF: @temp61 @temp1 weight (if (== weight 1) {} else {s})
					init: youOnlyLoveMeForMyCueMethod
				)
				(return 0)
			else
				0
			)
		)
	)
)

(instance invHelp of IconItem
	(properties
		view 991
		loop 1
		cel 0
		cursor 949
		message V_HELP
		noun N_HELP
		modNum GLORYINV
		helpVerb V_HELP
	)
	
	(method (show)
		(super show:)
		(DrawCel
			991
			7
			0
			(+ nsLeft (CelWide view loop cel))
			nsTop
			-1
		)
	)
)

(instance ok of IconItem
	(properties
		view 991
		loop 3
		cel 0
		cursor 949
		message V_HELP
		signal (| HIDEBAR RELVERIFY IMMEDIATE)
		noun N_CANCEL
		modNum GLORYINV
		helpVerb V_HELP
	)
)

(instance silver of QG1InvItem
	(properties
		message V_MONEY
		weight 1
	)
	
	(method (doVerb theVerb &tmp [temp0 40] [temp40 50] temp90 temp91)
		(if (== theVerb 9) (return 1))
		(Print font: userFont mode: 1)
		(return
			(switch theVerb
				(V_LOOK
					(if local1
						(Message MsgGet GLORYINV N_ITEM NULL NULL 21 @temp40)
						(Print
							addTextF: @temp0 @temp40 amtDropped (if (> amtDropped 1) {s} else {})
							init:
						)
					else
						(= temp90 (= temp91 0))
						(= temp90
							(/ (= temp91 (/ (+ (gold amount?) amount) 6)) 10)
						)
						(if
						(and (not (= temp91 (mod temp91 10))) (not temp90))
							(= temp91 1)
						)
						(cond 
							((and amount (gold amount?))
								(Message MsgGet GLORYINV N_ITEM NULL NULL 9 @temp40)
								(Print
									addTextF:
										@temp0
										@temp40
										(gold amount?)
										(if (> (gold amount?) 1) {s} else {})
										amount
										(if (> amount 1) {s} else {})
										temp90
										temp91
									init:
								)
							)
							(amount
								(Message MsgGet GLORYINV N_ITEM NULL NULL 10 @temp40)
								(Print
									addTextF:
										@temp0
										@temp40
										amount
										(if (> amount 1) {s} else {})
										temp90
										temp91
									init:
								)
							)
							((gold amount?)
								(Message MsgGet GLORYINV N_ITEM NULL NULL 11 @temp40)
								(Print
									addTextF:
										@temp0
										@temp40
										(gold amount?)
										(if (> (gold amount?) 1) {s} else {})
										temp90
										temp91
									init:
								)
							)
							(else
								(switch (Random 0 5)
									(0
										(Print addText: N_ITEM NULL NULL 12 0 0 GLORYINV init:)
									)
									(1
										(Print addText: N_ITEM NULL NULL 13 0 0 GLORYINV init:)
									)
									(else 
										(Print addText: N_ITEM NULL NULL 14 0 0 GLORYINV init:)
									)
								)
							)
						)
					)
				)
				(V_DROP
					(cond 
						((== curRoomNum 322) (Print addText: N_ITEM NULL NULL 6 0 0 GLORYINV init:))
						((> amount 10) (Print addText: N_ITEM NULL NULL 15 0 0 GLORYINV init:) (self dumpIt: 10))
						((> amount 1)
							(Print addText: N_ITEM NULL NULL 16 0 0 GLORYINV init:)
							(self dumpIt: (- amount 1))
						)
						(else (Print addText: N_ITEM NULL NULL 17 0 0 GLORYINV init:))
					)
				)
				(V_TRIGGER
					(cond 
						((> amtDropped 10)
							(Print addText: N_ITEM NULL NULL 18 0 0 GLORYINV init:)
							(self pickItUp: 10)
						)
						((not amtDropped) (Print addText: N_ITEM NULL NULL 20 0 0 GLORYINV init:))
						(else
							(Print addText: N_ITEM NULL NULL 19 0 0 GLORYINV init:)
							(self pickItUp: amtDropped)
						)
					)
				)
				(9 0)
				(else  (super doVerb: theVerb))
			)
		)
	)
)

(instance gold of QG1InvItem
	(properties
		loop 6
		message V_GOLD
		weight 1
	)
)

(instance rations of QG1InvItem
	(properties
		cel 1
		message V_RATIONS
		weight 20
	)
)

(instance sword of QG1InvItem
	(properties
		cel 4
		message V_SWORD
		weight 420
	)
)

(instance chainMail of QG1InvItem
	(properties
		loop 2
		cel 14
		message V_CHAINMAIL
		weight 2100
	)
)

(instance leather of QG1InvItem
	(properties
		cel 6
		message V_LEATHER
		weight 1200
	)
)

(instance shield of QG1InvItem
	(properties
		cel 7
		message V_SHIELD
		weight 720
	)
)

(instance dagger of QG1InvItem
	(properties
		cel 5
		message V_DAGGER
		weight 120
	)
)

(instance lockPick of QG1InvItem
	(properties
		loop 2
		cel 4
		message V_LOCKPICK
		weight 5
	)
)

(instance thiefKit of QG1InvItem
	(properties
		loop 2
		cel 5
		message V_THIEFKIT
		weight 30
	)
)

(instance thiefLicense of QG1InvItem
	(properties
		loop 2
		cel 6
		message V_THIEFLICENSE
		weight 2
	)
)

(instance rock of QG1InvItem
	(properties
		loop 2
		cel 2
		message V_ROCK
		weight 30
	)
)

(instance flask of QG1InvItem
	(properties
		loop 2
		cel 7
		message V_FLASK
		weight 10
	)
)

(instance healingPotion of QG1InvItem
	(properties
		loop 4
		message V_HEALING
		weight 40
	)
)

(instance manaPotion of QG1InvItem
	(properties
		loop 4
		cel 1
		message V_MANA
		weight 40
	)
)

(instance staminaPotion of QG1InvItem
	(properties
		loop 4
		cel 2
		message V_VIGOR
		weight 40
	)
)

(instance disenchant of QG1InvItem
	(properties
		loop 4
		cel 3
		message V_DISENCHANT
		weight 40
	)
)

(instance brassKey of QG1InvItem
	(properties
		cel 3
		message V_BRASSKEY
		weight 15
	)
)

(instance magicGem of QG1InvItem
	(properties
		cel 10
		message V_MAGICGEM
		weight 6
	)
)

(instance ring of QG1InvItem
	(properties
		loop 2
		message V_RING
		weight 10
	)
)

(instance ghostOil of QG1InvItem
	(properties
		loop 4
		cel 4
		message V_GHOSTOIL
		weight 40
	)
)

(instance magicMirror of QG1InvItem
	(properties
		loop 4
		cel 5
		message V_MAGICMIRROR
		weight 30
	)
)

(instance mandrake of QG1InvItem
	(properties
		cel 2
		message V_MANDRAKE
		weight 30
	)
)

(instance fruit of QG1InvItem
	(properties
		cel 9
		message V_FRUIT
		weight 15
	)
)

(instance vegetables of QG1InvItem
	(properties
		loop 2
		cel 15
		message V_VEGETABLES
		weight 30
	)
)

(instance acorn of QG1InvItem
	(properties
		loop 4
		cel 6
		message V_ACORN
		weight 3
	)
)

(instance seed of QG1InvItem
	(properties
		loop 2
		cel 1
		message V_SEED
		weight 60
	)
)

(instance flowers of QG1InvItem
	(properties
		loop 2
		cel 3
		message V_FLOWERS
		weight 1
	)
)

(instance greenFur of QG1InvItem
	(properties
		loop 2
		cel 8
		message V_GREENFUR
		weight 3
	)
)

(instance fairyDust of QG1InvItem
	(properties
		loop 2
		cel 9
		message V_FAIRYDUST
		weight 10
	)
)

(instance flyingWater of QG1InvItem
	(properties
		loop 2
		cel 10
		message V_WATER
		weight 40
	)
)

(instance mushroom of QG1InvItem
	(properties
		loop 2
		cel 11
		message V_MUSHROOM
		weight 10
	)
)

(instance vase of QG1InvItem
	(properties
		cel 11
		message V_VASE
		weight 30
	)
)

(instance candelabra of QG1InvItem
	(properties
		cel 12
		message V_CANDELABRA
		weight 180
	)
)

(instance musicBox of QG1InvItem
	(properties
		cel 13
		message V_MUSICBOX
		weight 45
	)
)

(instance candleSticks of QG1InvItem
	(properties
		cel 14
		message V_CANDLESTICKS
		weight 60
	)
)

(instance pearls of QG1InvItem
	(properties
		cel 15
		message V_PEARLS
		weight 30
	)
)

(instance cheetaurClaw of QG1InvItem
	(properties
		loop 2
		cel 12
		message V_CHEETAURCLAW
		weight 20
	)
)

(instance trollBeard of QG1InvItem
	(properties
		loop 2
		cel 13
		message V_TROLLBEARD
		weight 60
	)
)

(instance paper of QG1InvItem
	(properties
		cel 8
		message V_PAPER
		weight 1
	)
)

(instance invCursor of Cursor
	(properties
		view 950
	)
)

(instance youOnlyLoveMeForMyCueMethod of Script
	(properties)
	
	(method (cue &tmp temp0 [temp1 60] [temp61 60])
		(= temp0 (MaxLoad))
		(Message MsgGet GLORYINV 9 0 0 2 @temp1)
		(Print
			font: userFont
			mode: teJustCenter
			addTextF: @temp61 @temp1 temp0 (if (== temp0 1) {} else {s})
			init:
		)
	)
)
