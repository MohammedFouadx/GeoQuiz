package sim.coder.androidchallengeno8.Model

import androidx.annotation.StringRes

data class Question (
    @StringRes val textResId: Int,
    val answer: Boolean,
    var answered : String,
    var score:Int,
    var isCheater:Boolean=false
)