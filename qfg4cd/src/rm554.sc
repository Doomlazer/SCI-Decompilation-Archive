;;; Sierra Script 1.0 - (do not remove this comment)
(script# 554)
(include sci.sh)
(use Main)
(use GloryRm)
(use ForestView)
(use PChase)
(use PolyPath)
(use Polygon)

(public
	rm554 0
)

(instance rm554 of GloryRm
	(properties
		picture 410
		style $0400
		horizon 70
		north 553
		east 559
		topX 142
	)
	
	(method (init)
		(curRoom
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						189
						0
						189
						0
						0
						97
						0
						97
						78
						171
						106
						171
						116
						108
						116
						108
						126
						62
						126
						62
						146
						138
						179
						319
						179
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 194 0 319 0 319 131 213 131 213 103 161 89 194 75
					yourself:
				)
		)
		(self setRegions: 50)
		(if (Btst 35)
			(self setRegions: 51)
			((ScriptID 50 1) caller: self)
		)
		(super init: &rest)
		(curRoom
			addPoly:
				((Polygon new:)
					init: 319 189 298 189 278 148 299 141 282 133 319 120
					yourself:
				)
				130
				((Polygon new:)
					init: 233 128 189 137 159 125 226 105
					yourself:
				)
				60
		)
		(atp1 init: setPri: 116)
		(atp4 init: setPri: 106)
		(atp5 init: setPri: 180)
		(if Night
			(atp2Night init: setPri: 180)
			(atp3Night init: setPri: 180)
		else
			(atp2Day init: setPri: 180)
			(atp3Day init: setPri: 180)
		)
		(if (Btst 380) (theGame save: 1))
	)
	
	(method (cue)
		(ego setMotion: PolyPath (ego x?) (+ (ego y?) 25))
		((ScriptID 51 1)
			posn: topX (- horizon 15)
			init:
			setMotion: PChase ego 25
		)
	)
	
	(method (notify param1)
		(if (== param1 1) (curRoom setScript: (ScriptID 51 4)))
	)
)

(instance atp1 of ForestView
	(properties
		x 27
		y 110
		view 411
		loop 1
		cel 2
	)
)

(instance atp4 of ForestView
	(properties
		x 165
		y 56
		view 411
		loop 1
		cel 1
	)
)

(instance atp5 of ForestView
	(properties
		x 109
		y 119
		view 414
		loop 1
		cel 6
	)
)

(instance atp2Day of ForestView
	(properties
		x 176
		y 146
		view 412
		loop 1
		cel 1
	)
)

(instance atp3Day of ForestView
	(properties
		x 317
		y 170
		view 412
		loop 1
	)
)

(instance atp2Night of ForestView
	(properties
		x 61
		y 189
		view 418
		cel 1
	)
)

(instance atp3Night of ForestView
	(properties
		x 232
		y 189
		view 418
		cel 2
	)
)
