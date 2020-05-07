;;; Sierra Script 1.0 - (do not remove this comment)
(script# 202)
(include sci.sh)
(use Main)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	nightmareCartoon 0
)

(local
	[local0 21] = [180 127 180 128 180 128 178 131 181 131 196 124 207 129 207 129 207 129 217 131 -1]
	local21 =  -1
)
(instance nightmare of Actor
	(properties
		x 146
		y 119
		view 203
	)
)

(instance nightmareCartoon of Script
	(properties)
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 202)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Cursor showCursor: 1)
				(ego hide:)
				(nightmare init: setCycle: End self)
				(soundFx2 number: 346 loop: 1 play:)
			)
			(1 (= ticks 120))
			(2
				(nightmare posn: 180 126 view: 203 loop: 2 cel: 0)
				(ego
					show:
					setScale: 0
					normal: 0
					view: 203
					loop: 1
					cel: 0
					setSpeed: 6
					setPri: 15
					posn: 180 80
					setCycle: End self
				)
			)
			(3 (= cycles 2))
			(4
				(ego
					reset: 7
					ignoreActors:
					setPri: 15
					posn: 199 126
					setScale: Scaler 100 50 112 57
				)
				(theMusic number: 915 loop: -1 play:)
				(= cycles 2)
			)
			(5
				(= register -1)
				(messager say: 1 0 2 0 self)
			)
			(6
				(ego setMotion: MoveTo 169 137 self)
			)
			(7 (ego setHeading: 45 self))
			(8
				(nightmare
					view: 2031
					loop: 0
					cel: 0
					posn: 174 123
					setCycle: End self
				)
				(soundFx2 number: 346 loop: 1 play:)
			)
			(9
				(if (!= [local0 (+ local21 1)] -1)
					(nightmare
						view: 2031
						loop: 1
						cel: (++ register)
						posn: [local0 (++ local21)] [local0 (++ local21)]
					)
					(-- state)
				)
				(= ticks 10)
			)
			(10
				(nightmare dispose:)
				(ego setPri: -1 ignoreActors: 0)
				(= cycles 2)
			)
			(11
				(theGame handsOn:)
				(theIconBar enable: 6)
				(self dispose:)
			)
		)
	)
)
