package bink.wganizo.assessment.activities

import ModelCategories
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import bink.wganizo.assessment.R
import bink.wganizo.assessment.adapters.AdapterCategories
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var progress:ProgressBar
    lateinit var listView_details: ListView
    var arrayList_details:ArrayList<ModelCategories> = ArrayList();


    val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress = findViewById(R.id.progressBar)
        listView_details = findViewById(R.id.listView)
        if(isNetworkAvailable(this)) {
            run("https://www.themealdb.com/api/json/v1/1/categories.php") 
        }
        else{
            error("They seem to be a network connection error ")
        }
    }

    fun run(url: String) {
        progress.visibility = View.VISIBLE
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                progress.visibility = View.GONE
            }

            override fun onResponse(call: Call, response: Response) {
                var str_response = response.body()!!.string()
                val json_contact = JSONObject(str_response)
                var jsonarray_info:JSONArray= json_contact.getJSONArray("categories")
                var size:Int = jsonarray_info.length()
                arrayList_details= ArrayList();
                for (i in 0.. size-1) {
                    var json_objectdetail:JSONObject=jsonarray_info.getJSONObject(i)
                    var model:ModelCategories= ModelCategories();
                    model.id=json_objectdetail.getString("idCategory")
                    model.name=json_objectdetail.getString("strCategory")
                    model.descr=json_objectdetail.getString("strCategoryDescription")
                    model.thumbnail=json_objectdetail.getString("strCategoryThumb")
                     arrayList_details.add(model)
                }

                runOnUiThread {
                    val obj_adapter : AdapterCategories
                    obj_adapter = AdapterCategories(applicationContext,arrayList_details)
                    listView_details.adapter=obj_adapter
                    listView_details.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                        intent = Intent(applicationContext, MealsActivity::class.java)
                        intent.putExtra("category", "https://www.themealdb.com/api/json/v1/1/filter.php?c="+arrayList_details[position].name)
                        startActivity(intent)
                    }
                    progress.visibility = View.GONE
                }
            }
        })
    }
    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

    fun error(str: String){
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setMessage(str)
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("RETRY", DialogInterface.OnClickListener {
                    dialog, id -> finish()
                run("https://www.themealdb.com/api/json/v1/1/categories.php")
            })
            // negative button text and action
            .setNegativeButton("CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Error!!")
        // show alert dialog
        alert.show()
    }
}
