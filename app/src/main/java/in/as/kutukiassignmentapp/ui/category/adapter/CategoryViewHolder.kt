package `in`.`as`.kutukiassignmentapp.ui.category.adapter

import `in`.`as`.kutukiassignmentapp.data.model.Categories
import `in`.`as`.kutukiassignmentapp.databinding.ItemCategoryBinding
import android.content.Context
import android.view.View
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Created by Akshay Sharma on 01-04-2022.
 */
class CategoryViewHolder(val itemCategoryBinding: ItemCategoryBinding ) : RecyclerView.ViewHolder(itemCategoryBinding.root) {



    fun bindView(dataToBind: Categories, postClickListener: PostClickListener) {
        Glide.with(itemView)
            .load(dataToBind.image)
            .into(itemCategoryBinding.ivCategory)

        //itemCategoryBinding.tvCategory.text = dataToBind.name

        itemView.setOnClickListener {
            postClickListener.onPostClick(dataToBind)
        }

    }
}