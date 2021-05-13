;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2700)
(include sci.sh)
(use Polygon)
(use System)

(public
	poly2700Code 0
	proc2700_1 1
)

(local
	[thePoints 20] = [99 148 175 148 182 144 176 134 179 127 173 119 156 119 156 125 131 125 131 136]
)
(procedure (proc2700_1)
)

(instance poly2700Code of Code
	(properties)
	
	(method (doit param1)
		(param1 add: (poly2700a init: yourself:))
	)
)

(instance poly2700a of Polygon
	(properties)
	
	(method (init)
		(= type 3)
		(= size 10)
		(= points @thePoints)
	)
)
