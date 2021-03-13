;;; Sierra Script 1.0 - (do not remove this comment)
(script# 595)
(include sci.sh)
(use Main)
(use Combat)
(use Motion)
(use Actor)
(use System)

(public
	leopardmanMonster 0
)

(instance leopardmanMonster of Monster
	(properties
		x 165
		y 145
		roar 909
		primDamage 20
		secDamage 8
		tertDamage 8
		armorValue 4
		monHP 180
		spellHitX 165
		spellHitY 90
	)
	
	(method (init)
		(if (== prevRoomNum 650)
			(= view 655)
			(curRoom picture: 550)
			(= mustFight 1)
		else
			(= view 591)
			(curRoom picture: 555)
			(cSound setLoop: -1 changeTo: 154)
		)
		(super init: &rest)
		(self setScript: sFight)
		(leopSpell init: hide:)
	)
	
	(method (getHurt)
		(self setScript: sReact)
		(super getHurt:)
	)
	
	(method (defenseLevel)
		(return 200)
	)
)

(instance leopSpell of Actor
	(properties
		x 160
		y 90
		yStep 15
		view 22
		priority 11
		signal $4810
		cycleSpeed 5
		xStep 15
		moveSpeed 0
	)
	
	(method (cue)
		(if (and (> x -20) (< loop 3))
			(gWarriorObj autoDodge:)
			(if
				(not
					(if
						(or
							(== (gWarriorObj view?) 26)
							(== (gWarriorObj view?) 27)
						)
					else
						(== (gWarriorObj view?) 555)
					)
				)
				(if (not (> reversalTimer 0))
					(gWarriorObj getHurt: (gMonster primDamage?))
				)
				(self
					setCel: 0
					setLoop: (if (mod loop 2) 4 else 3)
					setCycle: End self
				)
			else
				(globalSound number: 940 play:)
				(self setMotion: MoveTo -20 90 self)
			)
		else
			(self hide:)
		)
	)
)

(instance sFight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (/ (Random 60 150) arcadeDifficulty))
			)
			(1
				(gMonster
					setLoop: (Random 0 2)
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gWarriorObj autoDodge:)
				(cond 
					(
						(not
							(if
								(or
									(== (gWarriorObj view?) 26)
									(== (gWarriorObj view?) 27)
								)
							else
								(== (gWarriorObj view?) 555)
							)
						)
						(gWarriorObj getHurt: (gMonster secDamage?))
					)
					((< (gMonster loop?) 2) (globalSound number: 940 play:))
				)
				(gMonster setCel: 0)
				(= ticks (/ (Random 60 150) arcadeDifficulty))
			)
			(3
				(= start 0)
				(if (> (= global432 (- global432 5)) 4)
					(gMonster setLoop: 3 setCycle: End self)
				else
					(self start: 0 init:)
				)
			)
			(4
				(leopSpell
					show:
					cel: 0
					loop: (Random 0 2)
					x: 160
					y: 90
					setCycle: Fwd
					setMotion: MoveTo 105 90 leopSpell
				)
				(self start: 0 init:)
			)
		)
	)
)

(instance sReact of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMonster
					x: 165
					y: 145
					setCel: 0
					setLoop: 1
					setCycle: CT 2 1
				)
				(= ticks 60)
			)
			(1
				(gMonster whimper:)
				(= ticks (- (/ (Random 90 120) arcadeDifficulty) 29))
			)
			(2
				(if (Random 0 1) (sFight start: 3))
				(gMonster setScript: sFight)
			)
		)
	)
)
