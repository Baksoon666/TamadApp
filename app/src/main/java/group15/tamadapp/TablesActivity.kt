package group15.tamadapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_tables.*
import org.json.JSONArray
import org.json.JSONObject
import android.media.MediaPlayer
import android.widget.ArrayAdapter


class TablesActivity : AppCompatActivity() {
    private var listItems = ArrayList<String>()
    private var tableRoot : JSONArray? = null
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)



        mediaPlayer = MediaPlayer.create(this, R.raw.drag)
        mediaPlayer?.start()

        loadList()

        for(i in 0 until tableRoot!!.length()) {
            Log.i("sdfds", tableRoot!!.get(i).toString())
            val toast : JSONObject = tableRoot!![i] as JSONObject
            listItems.add(toast["title"] as String)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        list_toasts.adapter = adapter

        list_toasts.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, ToastActivity::class.java)
            val toast : JSONObject = tableRoot!![position] as JSONObject
            intent.putExtra("text", toast["text"] as String)
            startActivity(intent)
        }
    }




    private fun loadList() {
        val str = assets.open("toast.json").bufferedReader().use { it.readText() }
        val root = JSONObject(str)

        val table : String? = intent.getStringExtra("table")
        tableRoot = root[table] as JSONArray

    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.start()}
}
