package sim.coder.androidchallengeno8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import sim.coder.androidchallengeno8.Model.Question
import sim.coder.androidchallengeno8.Model.QuizViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    val quizViewModel: QuizViewModel by lazy{
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var questionTextView: TextView
    var trueAnswer=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var eListQuesation= arrayListOf<Question>()
        eListQuesation.addAll(quizViewModel.equestionBank)
        var mListQuestion=arrayListOf<Question>()
        mListQuestion.addAll(quizViewModel.mQuestionBank)
        var dListQuestion=arrayListOf<Question>()
        dListQuestion.addAll(quizViewModel.dQuestionBank)
        randomQuestions(eListQuesation)
        randomQuestions(mListQuestion)
        randomQuestions(dListQuestion)


        var currentCheat = 3
        tv_cheat.setOnClickListener {

            quizViewModel.isCheater

            if (currentCheat <=3 && currentCheat!=0) {
                currentCheat -= 1
                makeText(this, "Your remaining opportunities $currentCheat", LENGTH_SHORT).show()
                //Log.d( "", "TOKENS $currentCheat")
                val answerIsTrue = quizViewModel.currentQuestionAnswer
                val intent = Intent(this,CheatActivity::class.java)
                intent.putExtra("a",answerIsTrue)
                startActivity(intent)
                //startActivityForResult(intent, 0)
            }

            else { tv_cheat.isClickable= false
                makeText(this, "Oops!, You have no chances left", LENGTH_SHORT).show() }
        }


//        val apiLevel = Build.VERSION.SDK_INT
//        //val versionRelease = Build.VERSION.RELEASE
//        tv_Api.text = "API Level : $apiLevel"


        trueButton = findViewById(R.id.t_button)
        falseButton = findViewById(R.id.f_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.q_textview)
        updateQuestion()

        prevButton.setOnClickListener {
            tv_Result.text=trueAnswer.toString()
            if (quizViewModel.currentIndex==0){
                quizViewModel.currentIndex=( quizViewModel.currentIndex + 5)
            }

            //quizViewModel.moveToPrev()
            if (quizViewModel.prevQuestion!=""){
                trueButton.isClickable=false
                falseButton.isClickable=false
                quizViewModel.moveToPrev()
            }else{
                trueButton.isClickable=true
                falseButton.isClickable=true
                quizViewModel.moveToPrev()
                updateQuestion()
            }

        }


        nextButton.setOnClickListener {
            if (quizViewModel.currentIndex==5){
                quizViewModel.currentIndex=( quizViewModel.currentIndex - 6)
            }

            //quizViewModel.moveToNext()
            if (quizViewModel.nextQuestion!="") {
                trueButton.isClickable = false
                falseButton.isClickable = false
                Log.d("aa",quizViewModel.nextQuestion)
                quizViewModel.moveToNext()
                updateQuestion()
            }else{
                trueButton.isClickable=true
                falseButton.isClickable=true
                quizViewModel.moveToNext()
                updateQuestion()
            }

        }



        trueButton.setOnClickListener {
            checkAnswer(true)
            tv_Result.text="Your score is : "+trueAnswer.toString()


        }


        falseButton.setOnClickListener {
            checkAnswer(false )

                tv_Result.text="Your score is : "+trueAnswer.toString()
        }







/// Challenge 1 Answer ////////////////////////////////
        questionTextView.setOnClickListener {
            updateQuestion()
        }
////////////////////////////////////////////////////
    }




    fun updateQuestion(){
        val questionTextResId= quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }


    fun checkAnswer(userAnswer:Boolean) {

        val correctAnswer = quizViewModel.currentQuestionAnswer
        if (correctAnswer == userAnswer) {
            quizViewModel.isAnswered("1")
            trueButton.isClickable = false
            falseButton.isClickable = false
            trueAnswer+=quizViewModel.currentScore
            makeText(this, "Correct!", LENGTH_SHORT).show()
        } else {
            quizViewModel.isAnswered("1")
            trueButton.isClickable = false
            falseButton.isClickable = false
            makeText(this, "OOps! false", LENGTH_SHORT).show()
        }
    }


    fun randomQuestions(question: ArrayList<Question>){
        var random = Random()
        for (i in 1..2){
            var randIndex=random.nextInt(question.size)
            var randItem:Question=question.get(randIndex)

            quizViewModel.questionBank.add(randItem)
            question.remove(question[randIndex])

        }
    }





//    override fun onStart() {
//        super.onStart()
//        Log.d("", "onStart() called")
//    }
//    override fun onResume() {
//        super.onResume()
//        Log.d("", "onResume() called")
//    }
//    override fun onPause() {
//        super.onPause()
//        Log.d("", "onPause() called")
//    }
//
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("", "onStop() called")
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("", "onDestroy() called")
//    }




}
