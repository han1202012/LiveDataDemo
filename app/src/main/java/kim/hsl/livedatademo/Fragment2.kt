package kim.hsl.livedatademo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Fragment2: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 设置布局
        val root: View = inflater.inflate(R.layout.fragment2, container, false)

        // 获取文本组件
        val textView: TextView = root.findViewById(R.id.textView)

        // 获取 ViewModel
        var viewModel: MyViewModel = ViewModelProvider(requireActivity(),
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application))
            .get(MyViewModel::class.java)

        // 设置文本显示内容
        textView.setText("${viewModel.progress.value}")

        // 设置 LiveData 监听
        viewModel.progress.observe(requireActivity(), object : androidx.lifecycle.Observer<Int> {
            override fun onChanged(t: Int) {
                textView.setText("${viewModel.progress.value}")
            }
        })

        return root
    }
}