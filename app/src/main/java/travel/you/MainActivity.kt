package travel.you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import travel.you.dialog.DialogUrl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DialogUrl().show(supportFragmentManager, "")
    }

}