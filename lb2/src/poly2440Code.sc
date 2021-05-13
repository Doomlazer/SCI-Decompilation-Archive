;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2440)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2440Code 0
	pts2440 1
)

(local
	[thePoints 34] = [0 0 319 0 319 170 264 163 254 156 209 148 215 140 264 124 242 127 216 137 200 144 172 140 139 96 100 139 76 146 6 147 0 189]
	[thePoints_2 8] = [29 177 102 167 102 182 34 188]
	[thePoints_3 8] = [111 145 134 145 133 153 112 152]
	[thePoints_4 8] = [131 158 175 158 175 167 126 166]
	[thePoints_5 8] = [201 189 210 182 263 184 274 189]
)
(instance poly2440Code of Code
	(properties)
	
	(method (doit param1)
		(param1
			add:
				(poly2440a init: yourself:)
				(poly2440b init: yourself:)
				(poly2440c init: yourself:)
				(poly2440d init: yourself:)
				(poly2440e init: yourself:)
		)
	)
)

(instance poly2440a of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(= size 17)
		(= points @thePoints)
	)
)

(instance poly2440b of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(= size 4)
		(= points @thePoints_2)
	)
)

(instance poly2440c of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(= size 4)
		(= points @thePoints_3)
	)
)

(instance poly2440d of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(= size 4)
		(= points @thePoints_4)
	)
)

(instance poly2440e of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(= size 4)
		(= points @thePoints_5)
	)
)

(instance pts2440 of MuseumPoints
	(properties
		midPtX 180
		midPtY 150
		northPtX 135
		northPtY 130
		southPtX 110
		southPtY 250
		eastPtX 235
		eastPtY 140
	)
)
