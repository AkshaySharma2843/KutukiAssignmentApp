package `in`.`as`.kutukiassignmentapp.ui.content

import `in`.`as`.kutukiassignmentapp.data.model.VideoDetails
import `in`.`as`.kutukiassignmentapp.databinding.FragmentContentBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment
import `in`.`as`.kutukiassignmentapp.utils.common.popBackStack
import android.content.pm.ActivityInfo
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class ContentFragment : BaseFragment<ContentViewModel, FragmentContentBinding>(FragmentContentBinding::inflate), ContentCallback {

    private lateinit var exoPlayer: ExoPlayer

    override fun setupView() {
        changeOrientationAndLock()
        viewModel.getVideList()
        initExoPlayer()
        observeData()
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnBack.setOnClickListener {
            popBackStack()
        }
    }

    private fun observeData() {
        viewModel.videoList.observe(viewLifecycleOwner){
            if(it.isNotEmpty()){
                renderRecyclerAndPlayVideo(it)
            }
        }
    }

    private fun renderRecyclerAndPlayVideo(arrayList: ArrayList<VideoDetails>) {
        setupRecycler(arrayList)
        val firstVideoToPlay = createMediaResource(arrayList.first())
        playVideo(firstVideoToPlay)
    }

    private fun setupRecycler(arrayList: java.util.ArrayList<VideoDetails>) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = ContentAdapter(arrayList, this@ContentFragment)
        }
    }

    private fun createMediaResource(url: VideoDetails): ProgressiveMediaSource {
        val dataSourceFactory = DefaultHttpDataSource.Factory()
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(url.videoURL))
    }

    private fun initExoPlayer() {
        exoPlayer = ExoPlayer.Builder(requireContext()).build()
        binding.playerView.player = exoPlayer
    }


    private fun changeOrientationAndLock() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun onStop() {
        super.onStop()
        if(::exoPlayer.isInitialized){
            exoPlayer.release()
        }
    }

    override fun onVideoClicked(videoDetails: VideoDetails) {
        val clickedVideoToPlay = createMediaResource(videoDetails)
        playVideo(clickedVideoToPlay)
    }

    private fun playVideo(videoToPlay: ProgressiveMediaSource) {
        if(::exoPlayer.isInitialized){
            exoPlayer.playWhenReady = true
            exoPlayer.setMediaSource(videoToPlay)
            exoPlayer.prepare()
        }
    }

}