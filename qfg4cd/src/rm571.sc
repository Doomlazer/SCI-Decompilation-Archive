;;; Sierra Script 1.0 - (do not remove this comment)
(script# 571)
(include sci.sh)
(use Main)
(use GloryRm)
(use ForestView)
(use Polygon)
(use Motion)

(public
	rm571 0
)

(instance rm571 of GloryRm
	(properties
		picture 410
		horizon 70
		north 500
		east 579
		south 572
		west 567
		topX 225
		rightY 137
	)
	
	(method (init)
		(curRoom
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 217 0 217 60 147 90 147 123 166 123 166 134 0 134
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 157 105 196 79 242 72 242 0 319 0 319 127 226 127 210 116 157 116
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 200 146 319 146 319 189 266 189 200 177
					yourself:
				)
		)
		(self setRegions: 50)
		(if (== prevRoomNum 500) (ego x: 218))
		(super init: &rest)
		(curRoom
			addPoly:
				((Polygon new:)
					init: 176 189 139 175 319 128 319 189
					yourself:
				)
				60
				((Polygon new:)
					init: 0 125 37 134 15 140 38 150 50 183 95 168 106 189 0 189
					yourself:
				)
				130
				((Polygon new:)
					init: 132 67 176 37 305 61 135 111
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp2 init: setPri: 180)
		(atp3 init:)
		(atp4 init: setPri: 127)
		(atp5 init: setPri: 95)
		(atp6 init: setPri: 169)
		(stream1 setPri: 80 setCycle: Fwd init:)
		(streamMat init:)
		(if (Btst 380) (theGame save: 1))
	)
	
	(method (dispose)
		(streamMat dispose:)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(11
				(if (streamMat onMe: (ego x?) (ego y?))
					(messager say: 12 6 10 0 0 50)
				else
					(messager say: 30 0 18 0 0 50)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 57
		y 73
		view 414
		cel 2
	)
)

(instance atp2 of ForestView
	(properties
		x 208
		y 119
		view 411
	)
)

(instance atp3 of ForestView
	(properties
		x 145
		y 5
		view 410
	)
)

(instance atp4 of ForestView
	(properties
		x 64
		y 4
		view 415
	)
)

(instance atp5 of ForestView
	(properties
		x 251
		y 6
		view 414
	)
)

(instance atp6 of ForestView
	(properties
		x 210
		y 119
		view 414
		cel 6
	)
)

(instance stream1 of ForestView
	(properties
		x 57
		y 73
		view 414
		loop 2
		signal $4001
		detailLevel 2
	)
)

(instance streamMat of Polygon
	(properties)
	
	(method (init)
		(super init: 161 109 137 110 146 83 200 83 161 109)
	)
)
