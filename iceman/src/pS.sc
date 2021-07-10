;;; Sierra Script 1.0 - (do not remove this comment)
(script# 358)
(include game.sh)
(use Main)
(use Intrface)
(use EgoDead)
(use Avoider)
(use Motion)
(use System)

(public
	pS 0
)

(instance pS of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 371) dispose:)
				(DisposeScript 971)
				(DisposeScript 956)
				(client
					setAvoider: Avoider
					ignoreActors: 0
					view: 211
					setLoop: (if register 3 else 4)
					setCycle: Walk
					setMotion: MoveTo 146 126 self
				)
				(HandsOff)
			)
			(1
				(client setLoop: 3 ignoreActors: FALSE)
				(ego setMotion: MoveTo 183 126 self setAvoider: Avoider)
				(Print 612 (Random 0 1))
			)
			(2
				(Print 612 (Random 2 5))
				(ego setLoop: 1 setAvoider: 0)
				(client
					setAvoider: 0
					cycleSpeed: 2
					setLoop: 5
					setCycle: EndLoop self
				)
				(DisposeScript AVOIDER)
			)
			(3
				((ego looper?) dispose:)
				(DisposeScript GROOPER)
				(client setLoop: 6 setCycle: EndLoop self)
				(ego view: 211 setLoop: 7 setCycle: EndLoop self)
			)
			(4 0)
			(5
				(EgoDead 907 0 0 358 0)
				(client posn: 20 110 setScript: 0)
			)
		)
	)
)
