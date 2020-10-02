package sim.coder.androidchallengeno8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_cheat.*

class CheatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        val bundle:Bundle? = intent.extras
       val msg =  bundle?.getString("a")
        cheatAnswer.text= msg
        Log.d("mm" ,"$msg")



    }
}
