;;; Sierra Script 1.0 - (do not remove this comment)
(script# 341)
(include sci.sh)
(use Main)
(use TextIcon)
(use Array)
(use System)

(public
	barrelPuz 0
)

(local
	local0
	local1
	local2
	local3 =  1
)
(procedure (localproc_0208 &tmp temp0)
	(= temp0 0)
	(while (<= temp0 8)
		(if
		(!= ((local0 at: temp0) loop?) (local1 at: temp0))
			(return 0)
		)
		(++ temp0)
	)
	(return 1)
)

(instance barrelPuz of PuzzleBar
	(properties)
	
	(method (init)
		(= local0 (IntArray new: 9))
		(= local1 (IntArray with: 2 2 3 1 1 1 0 1 0))
		(super init: &rest)
	)
	
	(method (dispose)
		(= state (& state $ffdf))
		(local0 dispose:)
		(local1 dispose:)
		(super dispose:)
		(return local2)
	)
	
	(method (resetPuzzle &tmp temp0 temp1 newSquare)
		(= temp0 0)
		(while (<= temp0 8)
			(= newSquare (square new:))
			(newSquare
				loop: 4
				nsTop: (= temp1 (+ 35 (* (/ temp0 3) (CelHigh 645 0 0))))
				y: newSquare
				nsLeft: (= temp1 (+ 40 (* (mod temp0 3) (CelWide 645 0 0))))
				x: newSquare
				init: self
			)
			(local0 at: temp0 newSquare)
			(self add: newSquare)
			(++ temp0)
		)
	)
	
	(method (helpYou)
		(messager say: 28 9 0 local3 0)
		(return
			(if (== local3 5)
				(barrelPuz setScript: leaveScript)
			else
				(++ local3)
			)
		)
	)
	
	(method (setPlane)
		(= usePlane 1)
		(plane
			bitmap: 0
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 82 40 250 155
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)
)

(instance square of TextIcon
	(properties
		priority 55
		fixPriority 1
		view 339
	)
	
	(method (init)
		(super init: &rest)
		(= nsRight (+ nsLeft (CelWide 645 0 0)))
		(= nsBottom (+ nsTop (CelHigh 645 0 0)))
	)
	
	(method (select)
		(= loop (if (== loop 4) 0 else (+ loop 1)))
		(UpdateScreenItem self)
		(FrameOut)
		(if (localproc_0208) (barrelPuz setScript: leaveScript))
	)
)

(instance leaveScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(barrelPuz state: (& (barrelPuz state?) $ffdf))
				(= local2 1)
				(self dispose:)
			)
		)
	)
)
