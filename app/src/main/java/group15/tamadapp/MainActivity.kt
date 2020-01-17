package group15.tamadapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.tamada)
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.start()
    }

    fun tableSelected(table : String) {
        intent = Intent(applicationContext, TablesActivity::class.java)
        intent.putExtra("table", table)
        startActivity(intent)

    }

    fun onGeneralTable(view: View) {
        tableSelected("general")
    }
    fun onFuneralTable(view: View) {
        tableSelected("funeral")
    }
    fun onBdayTable(view: View) {
        tableSelected("birthday")
    }
    fun onWeddingTable(view: View) {
        tableSelected("wedding")
    }
    fun onCustomTable(view: View) {

    }
}
