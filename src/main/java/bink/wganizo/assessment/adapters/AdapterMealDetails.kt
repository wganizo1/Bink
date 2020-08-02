package bink.wganizo.assessment.adapters
    import ModelMealDetails
    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.BaseAdapter
    import android.widget.ImageView
    import android.widget.LinearLayout
    import android.widget.TextView
    import bink.wganizo.assessment.R
    import com.bumptech.glide.Glide

class AdapterMealDetails(context: Context,arrayListDetails:ArrayList<ModelMealDetails>) : BaseAdapter(){

    private val layoutInflater_meal_details: LayoutInflater
    private val arrayListDetails:ArrayList<ModelMealDetails>

    init {
        this.layoutInflater_meal_details = LayoutInflater.from(context)
        this.arrayListDetails=arrayListDetails
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }

    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val listRowHolder_meal_details: ListRowHolderMealDetails
        if (convertView == null) {
            view = this.layoutInflater_meal_details.inflate(R.layout.adapter_layout, parent, false)
            listRowHolder_meal_details = ListRowHolderMealDetails(view)
            view.tag = listRowHolder_meal_details
        } else {
            view = convertView
            listRowHolder_meal_details = view.tag as ListRowHolderMealDetails
        }
        listRowHolder_meal_details.tvName.text = arrayListDetails.get(position).name
        listRowHolder_meal_details.tvDescr.text = arrayListDetails.get(position).instructions
        Glide.with(this.layoutInflater_meal_details.context).load(arrayListDetails.get(position).thumbnails).into(listRowHolder_meal_details.thumbnail);

        return view
    }
}

private class ListRowHolderMealDetails(row: View?) {
    val tvName: TextView
    val tvDescr: TextView
    val thumbnail: ImageView
    val linearLayout: LinearLayout

    init {
        this.tvName = row?.findViewById(R.id.tvName) as TextView
        this.tvDescr = row?.findViewById(R.id.tvDescr) as TextView
        this.thumbnail = row?.findViewById(R.id.thumbnail) as ImageView
        this.linearLayout = row?.findViewById(R.id.linearLayout) as LinearLayout
    }
}