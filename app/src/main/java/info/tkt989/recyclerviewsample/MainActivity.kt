package info.tkt989.recyclerviewsample

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
            "Alice", "Bob", "Charlie", "Dave", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy"
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerAdapter(this, data)
    }
}

class RecyclerAdapter(context: Context, val data: List<String>) : RecyclerView.Adapter<ViewHolder>() {
    val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // ここでViewHolderを作る
        return ViewHolder(inflater.inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        // データの要素数を返す
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // ViewHolderを通してデータをViewに設定する
        holder.textView.text = data[position]
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView: TextView = itemView.findViewById(R.id.textView)
}