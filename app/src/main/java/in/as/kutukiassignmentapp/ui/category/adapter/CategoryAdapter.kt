package `in`.`as`.kutukiassignmentapp.ui.category.adapter

import `in`.`as`.kutukiassignmentapp.data.model.Categories
import `in`.`as`.kutukiassignmentapp.databinding.ItemCategoryBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Akshay Sharma on 01-04-2022.
 */
class CategoryAdapter(private val arrayList: ArrayList<Categories>, private val postClickListener: PostClickListener) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dataToBind = arrayList.get(position)
        holder.bindView(dataToBind,postClickListener)
    }

    override fun getItemCount(): Int = arrayList.size
}