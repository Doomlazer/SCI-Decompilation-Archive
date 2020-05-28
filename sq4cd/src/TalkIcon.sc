;;; Sierra Script 1.0 - (do not remove this comment)
(script# TALKICON) ;814
(include game.sh)
(use DCIcon)
(use Motion)


(class TalkIcon of DCIcon
	(properties
		iterate -1
		iterCnt 0
		saveBits 0
	)
	
	(method (init)
		(cond 
			((== cycler -1) (= cycler 0))
			(cycler ((= cycler (cycler new:)) init: self))
			(else ((= cycler (Forward new:)) init: self))
		)
		(= iterCnt 0)
	)
	
	(method (draw &tmp temp0)
		(if saveBits
			(Graph GRestoreBits saveBits)
			(Graph GReAnimate nsTop nsLeft nsBottom nsRight)
		)
		(= saveBits
			(Graph GSaveBits nsTop nsLeft nsBottom nsRight 3)
		)
		(DrawCel view loop cel nsLeft nsTop 15)
	)
	
	(method (cycle &tmp theCel)
		(= theCel cel)
		(super cycle:)
		(cond 
			((or (not (IsObject cycler)) (== cel theCel)) 0)
			((or (== iterate -1) (<= iterCnt iterate))
				(++ iterCnt)
				(if
					(and
						(> (NumLoops self) 1)
						(or loop (< (Random 1 100) 51))
					)
					(= loop (^ loop $0001))
				)
			)
			((> iterCnt iterate)
				(if (IsObject cycler) (cycler dispose:))
				(= loop (= cycler (= cel 0)))
			)
		)
	)
)
