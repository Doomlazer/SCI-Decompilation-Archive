;;; Sierra Script 1.0 - (do not remove this comment)
(script# 402)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Talker)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	aardvarkEntrance 0
	aardvarkTalker 1
	cleanUp 2
)

(local
	theCurrentTime
	theClient
	[local2 8] = [0 -14 13 -11 -8 7 12 999]
	[local10 6] = [0 15 16 17 18 999]
	[local16 6] = [0 19 20 21 9 999]
	[local22 4] = [0 9 10 999]
	[local26 10]
	[local36 5] = [0 -14 -11 -8 999]
	[local41 4] = [0 22 -23 999]
	[local45 6]
)
(instance aardvarkEntrance of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= theCurrentTime Clock)
				(= theClient client)
				(= [local26 0] @local2)
				(= [local26 1] @local10)
				(= [local26 2] @local16)
				(= [local26 3] @local22)
				(= [local45 0] @local41)
				(aardvark init:)
				(aardvarkTell init: aardvark @local2 @local26 @local36)
				(egoTell init: ego @local41 @local45)
				(messager say: 2 6 27 0 self 400)
			)
			(1 (ego setCycle: Beg self))
			(2
				(ego x: (+ (ego x?) 25) normalize:)
				(aardvark
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 67 149 self
				)
			)
			(3
				(aardvark loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(messager say: 2 6 5 0 self 400)
			)
			(5
				(aardvark loop: 3 cel: 0 setCycle: End self)
			)
			(6
				(aardvark loop: 4 cel: 0 setCycle: End self)
			)
			(7
				(messager say: 2 6 6 0 self 400)
			)
			(8
				(aardvark loop: 5 cel: 0)
				(theIconBar enable: 4 2)
				(User canInput: 1)
				(theIconBar advanceCurIcon:)
				(aardvark setScript: drink)
				(self dispose:)
			)
		)
	)
)

(instance drink of Script
	(properties)
	
	(method (doit)
		(= Clock theCurrentTime)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(aardvark setCycle: End self)
			)
			(1
				(aardvark setCycle: Beg self)
			)
			(2 (= cycles 300))
			(3 (self init:))
		)
	)
)

(instance aardvark of Actor
	(properties
		x -10
		y 149
		noun 2
		view 404
	)
	
	(method (doit)
		(Palette palANIMATE 67 69 2)
		(super doit: &rest)
	)
)

(instance aardvarkTalker of Talker
	(properties
		x 0
		y 0
		view 405
		loop 1
		cel 1
		priority 11
		signal $0010
		talkWidth 150
		back 57
		textX 137
		textY 5
	)
	
	(method (init)
		(super init: aardvarkCandle aardvarkEyes aardvarkMouth)
	)
	
	(method (doit)
		(if (and (super doit:) mouth) (self cycle: mouth))
		(if bust (self cycle: bust))
		(if eyes (self cycle: eyes))
	)
	
	(method (dispose param1)
		(if (and mouth underBits)
			(mouth cel: 0)
			(DrawCel
				(mouth view?)
				(mouth loop?)
				0
				(+ (mouth nsLeft?) nsLeft)
				(+ (mouth nsTop?) nsTop)
				-1
			)
		)
		(if (and mouth (mouth cycler?))
			(if ((mouth cycler?) respondsTo: #cue)
				((mouth cycler?) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if (and bust underBits)
				(bust setCycle: 0 cel: 0)
				(DrawCel
					(bust view?)
					(bust loop?)
					0
					(+ (bust nsLeft?) nsLeft)
					(+ (bust nsTop?) nsTop)
					-1
				)
			)
			(if (and eyes underBits)
				(eyes setCycle: 0 cel: 0)
				(DrawCel
					(eyes view?)
					(eyes loop?)
					0
					(+ (eyes nsLeft?) nsLeft)
					(+ (eyes nsTop?) nsTop)
					-1
				)
			)
			(self hide:)
		)
		(super dispose: param1)
	)
	
	(method (show &tmp temp0)
		(if (not underBits)
			(= underBits
				(Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1)
			)
		)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if bust
			(DrawCel
				(bust view?)
				(bust loop?)
				(bust cel?)
				(+ (bust nsLeft?) nsLeft)
				(+ (bust nsTop?) nsTop)
				-1
			)
		)
		(if eyes
			(DrawCel
				(eyes view?)
				(eyes loop?)
				(eyes cel?)
				(+ (eyes nsLeft?) nsLeft)
				(+ (eyes nsTop?) nsTop)
				-1
			)
		)
		(if mouth
			(DrawCel
				(mouth view?)
				(mouth loop?)
				(mouth cel?)
				(+ (mouth nsLeft?) nsLeft)
				(+ (mouth nsTop?) nsTop)
				-1
			)
		)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
	)
	
	(method (startText &tmp [temp0 21])
		(if bust (bust setCycle: Fwd))
		(super startText:)
	)
)

(instance aardvarkEyes of Prop
	(properties
		nsTop 45
		nsLeft 45
		view 405
		loop 2
		cel 1
		priority 15
		signal $0010
	)
)

(instance aardvarkCandle of Prop
	(properties
		nsTop 5
		nsLeft 49
		view 405
		loop 3
		priority 15
		signal $0010
		cycleSpeed 10
	)
)

(instance aardvarkMouth of Prop
	(properties
		nsTop 53
		nsLeft 41
		view 405
		cel 4
		priority 14
		signal $0010
	)
)

(instance aardvarkTell of Teller
	(properties)
)

(instance egoTell of Teller
	(properties)
	
	(method (doChild param1)
		(return
			(if (== param1 -23)
				(theClient setScript: cleanUp theClient)
				(return 1)
			else
				0
			)
		)
	)
)

(instance cleanUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (HandsOff) (= cycles 10))
			(1
				(drink dispose:)
				(aardvark setCycle: End self)
			)
			(2
				(aardvark loop: 6 cel: 0 setCycle: End self)
			)
			(3
				(aardvark loop: 3 cel: 6 setCycle: Beg self)
			)
			(4
				(aardvark
					loop: 1
					setCycle: Walk
					setMotion: MoveTo -20 149 self
				)
			)
			(5
				(ego
					view: 35
					loop: 1
					cel: 0
					x: (- (ego x?) 25)
					setCycle: End self
				)
				(aardvarkTell dispose:)
				(aardvarkTalker dispose:)
				(aardvark dispose:)
				(egoTell dispose:)
				(cSound number: 927 setLoop: -1 play:)
			)
			(6 (= seconds 5))
			(7
				(PalVary pvREVERSE 3)
				(Bclr 81)
				(= seconds 4)
			)
			(8
				((ScriptID 7 7) init: 5 40)
				(= cycles 10)
			)
			(9 (ego setCycle: Beg self))
			(10
				(ego normalize: x: (+ (ego x?) 25))
				(self dispose:)
			)
		)
	)
)
