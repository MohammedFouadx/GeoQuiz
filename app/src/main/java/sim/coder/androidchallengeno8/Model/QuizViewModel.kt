package sim.coder.androidchallengeno8.Model

import androidx.lifecycle.ViewModel
import sim.coder.androidchallengeno8.R

class QuizViewModel : ViewModel(){
    var currentIndex = 0

    val  questionBank= mutableListOf<Question>(

    )


      val equestionBank = arrayListOf(
        Question(R.string.eFirst,false,""),
        Question(R.string.eSecound,false,""),
        Question(R.string.eThird,true,""),
        Question(R.string.eFour,true,""),
        Question(R.string.eFive,true,""),
        Question(R.string.eSix,true,"")
    )

     val mQuestionBank= arrayListOf(
        Question(R.string.mFirst,true,""),
        Question(R.string.mSecound,false,""),
        Question(R.string.mThird,false,""),
        Question(R.string.mFour,true,""),
        Question(R.string.mFive,false,""),
        Question(R.string.mSix,false,"")
    )

     val dQuestionBank = arrayListOf(
        Question(R.string.dFirst,true,""),
        Question(R.string.dSecound,true,""),
        Question(R.string.dThird,false,""),
        Question(R.string.dFour,true,""),
        Question(R.string.dFive,true,""),
        Question(R.string.dSix,true,"")
    )



    val currentQuestionAnswer:Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText:Int
        get() = questionBank[currentIndex].textResId
    val nextQuestion:String
        get() = questionBank[currentIndex +1].answered
    val prevQuestion:String
        get() = questionBank[currentIndex -1].answered





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