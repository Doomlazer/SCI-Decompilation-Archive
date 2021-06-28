;;; Sierra Script 1.0 - (do not remove this comment)
(script# 27)
(include game.sh)
(use Main)
(use System)

(public
	proc27_0 0
	proc27_1 1
	proc27_2 2
)

(procedure (proc27_0 param1 param2)
	(return (& param2 (>> $8000 (mod param1 16))))
)

(procedure (proc27_1 param1 param2 &tmp temp0)
	(= temp0
		(|
			(= temp0 (WordAt param2 0))
			(>> $8000 (mod param1 16))
		)
	)
	(Memory MWriteWord param2 temp0)
)

(procedure (proc27_2 &tmp temp0 temp1)
	(= temp0 48)
	(= temp1 0)
	(while (< temp1 72)
		(= [global296 temp1] (& [global296 temp1] temp0))
		(++ temp1)
	)
)
