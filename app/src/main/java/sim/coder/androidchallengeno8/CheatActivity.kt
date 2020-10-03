package sim.coder.androidchallengeno8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_cheat.*

class CheatActivity : AppCompatActivity() {

    private lateinit var cheatTextView :TextView
    private lateinit var btnShowAnswer :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)


        cheatTextView =findViewById(R.id.cheatAnswer)
        btnShowAnswer =findViewById(R.id.btn_showAnswer)


        btnShowAnswer.setOnClickListener {
            cheatTextView.setText(intent.getBooleanExtra("answer",false).toString())
        }






    }
}
