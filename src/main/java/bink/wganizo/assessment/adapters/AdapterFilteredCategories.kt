package bink.wganizo.assessment.adapters
    import ModelFilteredByCategory
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

class AdapterFilteredCategories(context: Context,arrayListDetails:ArrayList<ModelFilteredByCategory>) : BaseAdapter(){

    private val layoutInflater_meals: LayoutInflater
    private val arrayListDetails:ArrayList<ModelFilteredByCategory>

    init {
        this.layoutInflater_meals = LayoutInflater.from(context)
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
        val listRowHolder_meals: ListRowHolderMeals
        if (convertView == null) {
            view = this.layoutInflater_meals.inflate(R.layout.adapter_layout, parent, false)
            listRowHolder_meals = ListRowHolderMeals(view)
            view.tag = listRowHolder_meals
        } else {
            view = convertView
            listRowHolder_meals = view.tag as ListRowHolderMeals
        }
        listRowHolder_meals.tvName.text = arrayListDetails.get(position).name
        Glide.with(this.layoutInflater_meals.context).load(arrayListDetails.get(position).thumbnails).into(listRowHolder_meals.thumbnail);

        return view
    }
}

private class ListRowHolderMeals(row: View?) {
    val tvName: TextView
    val thumbnail: ImageView
    val linearLayout: LinearLayout

    init {
        this.tvName = row?.findViewById(R.id.tvName) as TextView
        this.thumbnail = row?.findViewById(R.id.thumbnail) as ImageView
        this.linearLayout = row?.findViewById(R.id.linearLayout) as LinearLayout
    }
}