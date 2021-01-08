package github.learn.compose.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import github.learn.compose.R
import github.learn.compose.text.SimpleTextAct

class MainAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, SimpleTextAct::class.java))
    }
}