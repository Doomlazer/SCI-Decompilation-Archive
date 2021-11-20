;;; Sierra Script 1.0 - (do not remove this comment)
(script# 801)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	runesPuz 0
)

(local
	local0
	local1
	local2
	local3
	local4
	dialCel
)
(procedure (localproc_0058)
	(switch local1
		(0
			(if (== (dial cel?) 5) (= local1 1) else (= local1 0))
		)
		(1
			(if (== (dial cel?) 1) (= local1 2) else (= local1 0))
		)
		(2
			(if (OneOf (dial cel?) 0)
				(= local1 3)
			else
				(= local1 0)
			)
		)
		(3
			(if (OneOf (dial cel?) 0)
				(= local1 4)
			else
				(= local1 0)
			)
		)
		(4
			(if (== (dial cel?) 3) (= local1 5) else (= local1 0))
		)
		(5
			(if (OneOf (dial cel?) 2)
				(Bset 355)
				(runesPuz dispose:)
			else
				(= local1 0)
			)
		)
		(else  (= local1 0))
	)
)

(instance runesPuz of Script
	(properties)
	
	(method (init)
		(Bclr 6)
		(keyDownHandler addToFront: self)
		(mouseDownHandler addToFront: self)
		(directionHandler addToFront: self)
		(= local0 0)
		(= local1 0)
		(= dialCel (= register 0))
		(= local3 1)
		(aFeature init:)
		(o2Feature init:)
		(lFeature init:)
		(o1Feature init:)
		(vFeature init:)
		(cFeature init:)
		(myEFeature init:)
		(zFeature init:)
		(super init: &rest)
	)
	
	(method (dispose)
		(keyDownHandler delete: self)
		(mouseDownHandler delete: self)
		(directionHandler delete: self)
		(Bclr 50)
		(Bclr 51)
		(curRoom drawPic: curRoomNum 0)
		((ScriptID 0 21) doit: curRoomNum)
		(cast eachElementDo: #perform (ScriptID 90 0) 0)
		(runes dispose:)
		(dial dispose:)
		(aFeature dispose:)
		(o2Feature dispose:)
		(lFeature dispose:)
		(o1Feature dispose:)
		(vFeature dispose:)
		(zFeature dispose:)
		(cFeature dispose:)
		(myEFeature dispose:)
		(vRedLetter dispose:)
		(if (and (< 2700 Clock) (< Clock 2801))
			(PalVary 9 (+ (curRoom picture?) 1))
		)
		(CyclePalette)
		(CyclePalette_13)
		(Bset 6)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(Bset 50)
				(Bset 51)
				(UpdatePlane
					((curRoom plane?) back: 0 picture: -1 yourself:)
				)
				((ScriptID 0 21) doit: 100)
				(cast eachElementDo: #perform (ScriptID 90 0) 1)
				(= cycles 2)
			)
			(1
				(runes init:)
				(dial setCel: 0 setPri: 97 init:)
				(vRedLetter setPri: 86 init:)
				(Bclr 51)
				(theGame handsOn:)
				(theGame
					setCursor: ((theIconBar getCursor:)
						view: 999
						loop: 0
						cel: 0
						yourself:
					)
				)
				(PalVary pvUNINIT)
				(Bset 51)
			)
		)
	)
	
	(method (handleEvent event)
		(cond 
			(register (if (OneOf (event type?) 2 8 64) (= register 0)))
			((OneOf (event type?) 1 4 32)
				(cond 
					((aFeature onMe: event) (= local2 0) (self setScript: sTurnTheDial))
					((o2Feature onMe: event) (= local2 5) (self setScript: sTurnTheDial))
					((cFeature onMe: event) (= local2 6) (self setScript: sTurnTheDial))
					((lFeature onMe: event) (= local2 4) (self setScript: sTurnTheDial))
					((o1Feature onMe: event) (= local2 1) (self setScript: sTurnTheDial))
					((vFeature onMe: event) (= local2 3) (self setScript: sTurnTheDial))
					((myEFeature onMe: event) (= local2 7) (self setScript: sTurnTheDial))
					((zFeature onMe: event) (= local2 2) (self setScript: sTurnTheDial))
					((dial onMe: event) (messager say: 15 6 39))
					((runes onMe: event)
						(switch local0
							(3
								(= local0 0)
								(messager say: 15 6 3 4 0 800)
							)
							(2
								(= local0 3)
								(messager say: 15 6 3 3 0 800)
							)
							(1
								(= local0 2)
								(messager say: 15 6 3 2 0 800)
							)
							(else 
								(= local0 1)
								(messager say: 15 6 3 1 0 800)
							)
						)
					)
					(else (self dispose:))
				)
				(event claimed: 1)
				(return)
			)
			(else (super handleEvent: event))
		)
	)
)

(instance sTurnTheDial of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOn:)
				(if local3
					(= local3 0)
					(= local4 -1)
				else
					(= local3 1)
					(= local4 1)
				)
				(vRedLetter hide:)
				(switch local2
					(0
						(dial setCel: dialCel setCycle: CT 5 local4 self)
					)
					(7
						(dial setCel: dialCel setCycle: CT 4 local4 self)
					)
					(5
						(dial setCel: dialCel setCycle: CT 6 local4 self)
					)
					(2
						(dial setCel: dialCel setCycle: CT 3 local4 self)
					)
					(3
						(dial setCel: dialCel setCycle: CT 1 local4 self)
					)
					(1
						(dial setCel: dialCel setCycle: CT 0 local4 self)
					)
					(4
						(dial setCel: dialCel setCycle: CT 2 local4 self)
					)
					(6
						(dial setCel: dialCel setCycle: CT 7 local4 self)
					)
				)
			)
			(1
				(switch local2
					(0
						(vRedLetter posn: 144 61 setCel: 0 show:)
					)
					(7
						(vRedLetter posn: 120 74 setCel: 7 show:)
					)
					(5
						(vRedLetter posn: 177 68 setCel: 3 show:)
					)
					(2
						(vRedLetter posn: 112 95 setCel: 6 show:)
					)
					(3
						(vRedLetter posn: 148 136 setCel: 4 show:)
					)
					(1
						(vRedLetter posn: 179 122 setCel: 1 show:)
					)
					(4
						(vRedLetter posn: 122 118 setCel: 5 show:)
					)
					(6
						(vRedLetter posn: 185 98 setCel: 2 show:)
					)
				)
				(= dialCel (dial cel?))
				(= ticks 30)
			)
			(2
				(localproc_0058)
				(User canControl: 1)
				(sTurnTheDial dispose:)
			)
		)
	)
)

(instance dial of Prop
	(properties
		x 154
		y 97
		priority 75
		fixPriority 1
		view 802
		loop 1
		signal $5001
	)
)

(instance runes of View
	(properties
		x 52
		y 66
		view 802
		signal $4000
	)
)

(instance vRedLetter of View
	(properties
		x 179
		y 122
		view 802
		loop 2
		cel 1
	)
)

(instance aFeature of Feature
	(properties
		nsLeft 128
		nsTop 51
		nsRight 181
		nsBottom 75
		sightAngle 180
		x 128
		y 51
	)
	
	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: 0
				init: 144 51 164 51 181 59 163 75 143 74 128 58
				yourself:
			)
		)
	)
)

(instance o2Feature of Feature
	(properties
		nsLeft 163
		nsTop 60
		nsRight 200
		nsBottom 89
		sightAngle 180
		x 163
		y 60
	)
	
	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: 0
				init: 163 75 181 60 190 67 196 76 200 83 177 89 173 81
				yourself:
			)
		)
	)
)

(instance cFeature of Feature
	(properties
		nsLeft 175
		nsTop 83
		nsRight 203
		nsBottom 115
		sightAngle 180
		x 175
		y 83
	)
	
	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: 0
				init: 177 88 200 83 202 95 203 107 200 115 175 108 180 98
				yourself:
			)
		)
	)
)

(instance zFeature of Feature
	(properties
		nsLeft 106
		nsTop 84
		nsRight 132
		nsBottom 116
		sightAngle 180
		x 106
		y 84
	)
	
	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: 0
				init: 132 110 110 116 106 100 109 84 132 88 129 99
				yourself:
			)
		)
	)
)

(instance vFeature of Feature
	(properties
		nsLeft 137
		nsTop 122
		nsRight 180
		nsBottom 148
		sightAngle 180
		x 137
		y 122
	)
	
	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: 0
				init: 146 125 152 125 161 122 180 140 170 145 156 148 140 145 137 143
				yourself:
			)
		)
	)
)

(instance o1Feature of Feature
	(properties
		nsLeft 161
		nsTop 109
		nsRight 147
		nsBottom 140
		sightAngle 180
		x 161
		y 109
	)
	
	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: 0
				init: 176 109 200 115 197 123 191 131 180 140 161 121 170 115
				yourself:
			)
		)
	)
)

(instance lFeature of Feature
	(properties
		nsLeft 109
		nsTop 110
		nsRight 146
		nsBottom 144
		sightAngle 180
		x 109
		y 110
	)
	
	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: 0
				init: 124 136 115 127 109 117 131 110 138 118 146 125 136 144
				yourself:
			)
		)
	)
)

(instance myEFeature of Feature
	(properties
		nsLeft 109
		nsTop 59
		nsRight 142
		nsBottom 88
		sightAngle 180
		x 109
		y 59
	)
	
	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: 0
				init: 116 69 131 59 142 76 132 88 128 87 109 85
				yourself:
			)
		)
	)
)
