package kim.hsl.livedatademo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Fragment1: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 设置布局
        val root: View = inflater.inflate(R.layout.fragment1, container, false)

        // 获取拖动条
        var seekBar: SeekBar = root.findViewById(R.id.seekBar)

        // 获取 ViewModel
        var viewModel: MyViewModel = ViewModelProvider(requireActivity(),
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application))
            .get(MyViewModel::class.java)

        seekBar.progress = viewModel.progress.value!!

        // 设置进度条拖动事件
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                viewModel.progress.value = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }

        })

        return root
    }
}