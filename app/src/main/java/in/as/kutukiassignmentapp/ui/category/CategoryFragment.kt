package `in`.`as`.kutukiassignmentapp.ui.category

import `in`.`as`.kutukiassignmentapp.data.model.Categories
import `in`.`as`.kutukiassignmentapp.data.model.CategoryResponse
import `in`.`as`.kutukiassignmentapp.databinding.FragmentCategoryBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment
import `in`.`as`.kutukiassignmentapp.ui.category.adapter.CategoryAdapter
import `in`.`as`.kutukiassignmentapp.ui.category.adapter.PostClickListener
import `in`.`as`.kutukiassignmentapp.utils.common.Status
import `in`.`as`.kutukiassignmentapp.utils.common.goTo
import android.content.pm.ActivityInfo
import androidx.recyclerview.widget.GridLayoutManager

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
class CategoryFragment : BaseFragment<CategoryViewModel,FragmentCategoryBinding>(FragmentCategoryBinding::inflate),PostClickListener{
    override fun setupView() {
        createNetworkRequest()
        changeOrientationAndLock()
        observeRequest()
    }

    private fun observeRequest() {
        viewModel.categoryLiveData.observe(viewLifecycleOwner){
            when(it.status){
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    renderRecycler(it.data)
                }
                Status.ERROR -> {

                }
            }
        }
    }

    private fun renderRecycler(data: CategoryResponse?) {
        val arrayList = ArrayList<Categories>()
            data?.let { categoryResponse ->
                if(categoryResponse.response.videoCategories.isNotEmpty()){
                    arrayList.addAll(categoryResponse.response.videoCategories.values)
                }
            }
        val categoryAdapter = CategoryAdapter(arrayList,this)
        binding.rvCategory.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = categoryAdapter
    }

    private fun createNetworkRequest() {
        viewModel.getCategories()
    }

    private fun changeOrientationAndLock() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)
    override fun onPostClick(category: Categories) {
        goTo(CategoryFragmentDirections.actionCategoryFragmentToContentFragment())

    }

}