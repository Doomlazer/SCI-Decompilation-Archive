;;; Sierra Script 1.0 - (do not remove this comment)
(script# 222)
(include game.sh)
(use Main)
(use Procs)
(use Motion)
(use System)

(public
	intro 0
	intro2 1
	startFight 2
)

(local
	local0
)
(instance intro of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch prevRoomNum
					(38
						((ScriptID 39 2)
							posn: 318 138
							fightLeft: 1
							setLoop: 0
							setMotion: MoveTo 200 138 self
						)
					)
					(40
						((ScriptID 39 2)
							posn: 1 138
							setLoop: 1
							setMotion: MoveTo 100 138 self
						)
					)
					(41
						(if (> egoX 160)
							((ScriptID 39 2)
								posn: 1 138
								setLoop: 1
								setMotion: MoveTo 100 138 self
							)
						else
							((ScriptID 39 2)
								posn: 318 138
								setLoop: 0
								fightLeft: 1
								setMotion: MoveTo 200 138 self
							)
						)
					)
					(else 
						((ScriptID 39 2)
							posn: 1 138
							setLoop: 1
							setMotion: MoveTo 100 138 self
						)
					)
				)
			)
			(1
				(if (not (Btst 243)) (Bset 243))
				(self cue:)
			)
			(2
				((ScriptID 39 2) view: 638)
				(++ local0)
				(self
					setScript: (ScriptID 217 (Random 0 6)) 0 (ScriptID 39 2)
				)
				(= cycles 15)
			)
			(3
				(if
					(and
						(< local0 (Random 7 12))
						(not (< (ego distanceTo: (ScriptID 39 2)) 45))
					)
					(self changeState: 2)
				else
					(= local0 0)
					(self cue:)
				)
			)
			(4
				((ScriptID 39 2)
					view: 639
					setLoop: (if (< (ego x?) ((ScriptID 39 2) x?)) 0 else 1)
					setCel: 0
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance intro2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch prevRoomNum
					(38
						((ScriptID 39 2) posn: 200 140 fightLeft: 1)
					)
					(40
						((ScriptID 39 2) posn: 100 140)
					)
					(41
						(if (> egoX 160)
							((ScriptID 39 2) posn: 100 170)
						else
							((ScriptID 39 2) posn: 200 170 fightLeft: 1)
						)
					)
					(else 
						((ScriptID 39 2) posn: 100 147)
					)
				)
				(= cycles 1)
			)
			(1
				((ScriptID 39 2) view: 638)
				(++ local0)
				(self
					setScript: (ScriptID 217 (Random 0 6)) 0 (ScriptID 39 2)
				)
				(= cycles 12)
			)
			(2
				(if
					(and
						(< local0 (Random 7 12))
						(not (< (ego distanceTo: (ScriptID 39 2)) 45))
					)
					(self changeState: 1)
				else
					(= local0 0)
					(self cue:)
				)
			)
			(3
				(HandsOn)
				((ScriptID 39 2)
					view: 639
					setLoop: (if (< (ego x?) ((ScriptID 39 2) x?)) 0 else 1)
					setCel: 0
				)
				(client setScript: 0)
			)
		)
	)
)

(instance startFight of Script
	(properties)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 39 2) ignoreActors:)
				(ego ignoreActors:)
				(if (> ((ScriptID 39 2) x?) (ego x?))
					((ScriptID 39 2)
						view: 639
						setLoop: (if (> ((ScriptID 39 2) x?) 187) 0 else 1)
						setCycle: Walk
						fightLeft: 1
						warriorX: 157
						warriorY: 135
						setMotion: MoveTo 207 135
					)
				else
					((ScriptID 39 2)
						view: 639
						setLoop: (if (> ((ScriptID 39 2) x?) 137) 0 else 1)
						setCycle: Walk
						fightLeft: 0
						warriorX: 187
						warriorY: 135
						setMotion: MoveTo 137 135
					)
				)
				(if ((ScriptID 39 2) fightLeft?)
					(ego setMotion: MoveTo 157 135)
				else
					(ego setMotion: MoveTo 187 135)
				)
				(= cycles 3)
			)
			(1
				(cond 
					(((ScriptID 39 2) fightLeft?)
						(if
							(and
								(== (ego x?) 157)
								(== (ego y?) 135)
								(== ((ScriptID 39 2) x?) 207)
								(== ((ScriptID 39 2) y?) 135)
							)
							(self changeState: 3)
						else
							(= cycles 1)
						)
					)
					(
						(and
							(== (ego x?) 187)
							(== (ego y?) 135)
							(== ((ScriptID 39 2) x?) 137)
							(== ((ScriptID 39 2) y?) 135)
						)
						(self changeState: 3)
					)
					(else (= cycles 1))
				)
			)
			(2 (self changeState: 1))
			(3
				(Face ego (ScriptID 39 2))
				(if ((ScriptID 39 2) fightLeft?)
					((ScriptID 39 2) setPri: 6 setLoop: 5 cel: 0)
				else
					((ScriptID 39 2) setPri: 12 setLoop: 4 cel: 0)
				)
				(= ticks 20)
			)
			(4
				(messager say: 8 0 24)
				((ScriptID 39 2) cycleSpeed: 12 setCycle: EndLoop self)
			)
			(5
				(messager say: 8 0 2)
				(ego
					view: 502
					setLoop: (if ((ScriptID 39 2) fightLeft?) 0 else 1)
					setCycle: EndLoop self
				)
			)
			(6
				(messager say: 8 0 1)
				((ScriptID 39 2) setCel: 0)
				(HandsOn)
				((ScriptID 39 2) setScript: (ScriptID 220 0))
				(client setScript: 0)
			)
		)
	)
)
