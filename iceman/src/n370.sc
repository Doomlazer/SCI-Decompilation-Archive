;;; Sierra Script 1.0 - (do not remove this comment)
(script# 370)
(include game.sh)
(use subMarine)

(public
	RedrawControlPanel 0
)

(local
	local0 = [
		127 5 4 108 160
		27 2 0 210 33
		27 4 2 125 127
		227 3 5 234 19
		227 3 5 47 19
		27 4 3 67 111
		127 5 3 97 142
		127 5 0 220 113
		27 5 8 93 106
		27 5 7 192 106
		227 0 0 125 134
		227 3 0 244 124
		427 3 0 214 157
		427 3 1 0 32
		427 3 2 27 124
		427 5 0 13 141
		427 7 0 59 155
		427 3 4 46 137
		427 3 4 54 133
		427 7 1 64 179
		427 7 1 71 173
		427 7 1 78 167
		427 7 1 85 161
	]
)
(procedure (RedrawControlPanel &tmp i)
	(= i 1)
	(for ((= i 1)) (<= i 115) ((+= i 5))
		(DrawCel
			[local0 (- i 1)]
			[local0 i]
			[local0 (+ i 1)]
			[local0 (+ i 2)]
			[local0 (+ i 3)]
			12
		)
	)
	(DrawCel 527 2
		(cond 
			((<= ((subMarine script?) state?) 5) 1)
			((<= ((subMarine script?) state?) 8) 2)
			((<= ((subMarine script?) state?) 11) 3)
			(else 4)
		)
		45 36 12
	)
)