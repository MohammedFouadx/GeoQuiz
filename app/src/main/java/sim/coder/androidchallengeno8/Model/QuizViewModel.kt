package sim.coder.androidchallengeno8.Model

import androidx.lifecycle.ViewModel
import sim.coder.androidchallengeno8.R

class QuizViewModel : ViewModel(){
    var currentIndex = 0

    val  questionBank= mutableListOf<Question>(

    )


      val equestionBank = arrayListOf(
        Question(R.string.eFirst,false,"",2),
        Question(R.string.eSecound,false,"",2),
        Question(R.string.eThird,true,"",2),
        Question(R.string.eFour,true,"",2),
        Question(R.string.eFive,true,"",2),
        Question(R.string.eSix,true,"",2)
    )

     val mQuestionBank= arrayListOf(
        Question(R.string.mFirst,true,"",4),
        Question(R.string.mSecound,false,"",4),
        Question(R.string.mThird,false,"",4),
        Question(R.string.mFour,true,"",4),
        Question(R.string.mFive,false,"",4),
        Question(R.string.mSix,false,"",4)
    )

     val dQuestionBank = arrayListOf(
        Question(R.string.dFirst,true,"",6),
        Question(R.string.dSecound,true,"",6),
        Question(R.string.dThird,false,"",6),
        Question(R.string.dFour,true,"",6),
        Question(R.string.dFive,true,"",6),
        Question(R.string.dSix,true,"",6)
    )



    val currentQuestionAnswer:Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText:Int
        get() = questionBank[currentIndex].textResId
    val nextQuestion:String
        get() = questionBank[currentIndex +1].answered
    val prevQuestion:String
        get() = questionBank[currentIndex -1].answered
    val currentScore:Int
        get() =questionBank[currentIndex].score
    var isCheater:Boolean
        get() = questionBank[currentIndex].isCheater

        set(value) {
            questionBank[currentIndex].isCheater=true
        }





    fun moveToNext (){
        currentIndex = (currentIndex + 1) % questionBank.size

    }
    fun moveToPrev(){
        currentIndex = (currentIndex -1) % questionBank.size
    }
    fun isAnswered(state:String){
        questionBank[currentIndex].answered=state
    }


}