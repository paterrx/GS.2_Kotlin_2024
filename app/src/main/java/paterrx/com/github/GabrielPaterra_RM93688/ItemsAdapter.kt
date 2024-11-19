package paterrx.com.github.GabrielPaterra_RM93688

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
    private var items = listOf<ItemModel>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewTitulo: TextView = view.findViewById(R.id.textViewTitulo)
        private val textViewDica: TextView = view.findViewById(R.id.textViewDica)
        private val button: ImageButton = view.findViewById(R.id.imageButton)

        fun bind(item: ItemModel) {
            textViewTitulo.text = item.name
            textViewDica.text = item.description

            button.setOnClickListener {
                item.onRemove(item)
            }

            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "${item.name}: ${item.description}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<ItemModel>) {
        items = newItems
        notifyDataSetChanged()
    }
}
