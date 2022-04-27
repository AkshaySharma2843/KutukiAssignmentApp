package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.ui

import `in`.`as`.kutukiassignmentapp.R
import `in`.`as`.kutukiassignmentapp.data.model.FreeOffering
import `in`.`as`.kutukiassignmentapp.data.network.response.HomeApiResponse
import `in`.`as`.kutukiassignmentapp.data.network.response.ScheduleResponse
import `in`.`as`.kutukiassignmentapp.databinding.FragmentHomeBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment
import `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter.CourseAdapter
import `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter.FreeOfferingAdapter
import `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter.ScheduleAdapter
import `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter.SubjectAdapter
import `in`.`as`.kutukiassignmentapp.utils.common.Resource
import `in`.`as`.kutukiassignmentapp.utils.common.Status
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>(FragmentHomeBinding::inflate){
    var viewAll : Boolean = false
    val subjectAdapter = SubjectAdapter()
    val subjectList = ArrayList<HomeApiResponse.Data.Subject>()

    override fun setupView() {
        binding.subjectRecycler.apply {
            binding.subjectRecycler.layoutManager = GridLayoutManager(requireContext(),4,GridLayoutManager.VERTICAL,false)
            binding.subjectRecycler.adapter = subjectAdapter
        }
        setNetworkCall()
        setViewModelObserver()
        setFreeOffering()


    }

    private fun setNetworkCall() {
        viewModel.getUserPackage()
        viewModel.getHomeApiDetails()
        viewModel.getScheduleDetails()

    }

    private fun setFreeOffering() {
        val arrayList = ArrayList<FreeOffering>()
        arrayList.add(FreeOffering("CPS", R.drawable.ic_cps_image,1))
        arrayList.add(FreeOffering("PYQ's",R.drawable.ic_pyq,2))
        arrayList.add(FreeOffering("Mock Test",R.drawable.ic_mock_test,3))
        arrayList.add(FreeOffering("Exams",R.drawable.ic_exam,4))
        val freeOfferingAdapter = FreeOfferingAdapter(arrayList)
        binding.rvFreeOffering.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvFreeOffering.adapter = freeOfferingAdapter
    }

    private fun setViewModelObserver() {
        viewModel.userPackage.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS->{
                    //Toast.makeText(context,"DATA IS COMING",Toast.LENGTH_SHORT).show()
                }
                Status.LOADING->{

                }
                Status.ERROR->{
                   // Toast.makeText(context,"SOMETHING WENT WRONG",Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.homeApiDetails.observe(viewLifecycleOwner){ it ->
            when(it.status){
                Status.SUCCESS->{
                    setupSubject(it)
                    setupCourse(it)
                    binding.pbHome.visibility = View.GONE
                    binding.tvUserName.text = it.data?.let { user->
                        user.data?.user?.name
                    }
                }
                Status.LOADING->{
                    binding.pbHome.visibility = View.VISIBLE
                }
                Status.ERROR->{

                }
            }
        }

        viewModel.scheduleDetails.observe(viewLifecycleOwner){
            when(it.status)
            {

                Status.LOADING->{

                }
                Status.SUCCESS->{
                    val arrayList = ArrayList<ScheduleResponse.Data.ZoomClass>()
                    it.data?.data?.zoomclass.let {
                        if(it!!.isNotEmpty()){
                            arrayList.addAll(it)
                        }
                    }
                    val scheduleAdapter = ScheduleAdapter(arrayList)
                    binding.dayVdoERecycler.layoutManager = LinearLayoutManager(context)
                    binding.dayVdoERecycler.adapter = scheduleAdapter
                }
                Status.ERROR->{

                }
            }
        }

    }

    private fun setupCourse(it: Resource<HomeApiResponse>?) {
        val arrayList = ArrayList<HomeApiResponse.Data.Course>()
        it?.data?.data?.courses.let {course->
            if(course!!.isNotEmpty())
            arrayList.addAll(course)
        }
            val courseAdapter = CourseAdapter(arrayList)
            binding.rvCourse.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            binding.rvCourse.adapter = courseAdapter

    }

    private fun setupSubject(it: Resource<HomeApiResponse>?) {
        renderRecyclerView(it?.data?.data?.subject)
        binding.llSeeAll.setOnClickListener {
            viewAll = true
            binding.llSeeAll.visibility = View.GONE
            binding.llViewLess.visibility = View.VISIBLE
            subjectAdapter.submitList(viewAll,subjectList)

        }

        binding.llViewLess.setOnClickListener {
            viewAll = false
            binding.llSeeAll.visibility = View.VISIBLE
            binding.llViewLess.visibility = View.GONE
            subjectAdapter.submitList(viewAll,subjectList)
        }

    }

    private fun renderRecyclerView(subject: List<HomeApiResponse.Data.Subject>?) {
            subject.let {
                if(it!!.isNotEmpty()){
                    subjectList.addAll(subject!!)
                }
            }
        subjectAdapter.submitList(viewAll,subjectList)


    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)
}