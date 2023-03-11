package kim.hsl.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import java.util.*

class MainActivity2 : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 获取 视图 View 组件
        textView = findViewById(R.id.textView)

        // 获取 ViewModel
        myViewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory(application))
            .get(MyViewModel::class.java)

        // 将 ViewModel 中的数据设置到 视图 View 组件中
        textView.setText("${myViewModel.second.value}")

        // 设置 LiveData 监听
        myViewModel.second.observe(this, object : androidx.lifecycle.Observer<Int> {
            override fun onChanged(t: Int?) {
                // 将 ViewModel 中的数据设置到 视图 View 组件中
                textView.setText("${myViewModel.second.value}")
            }
        })

        // 启动定时器, 将 ViewModel 中的数据自增
        startTimer()
    }

    fun startTimer() {
        Timer().schedule(object : TimerTask(){
            override fun run() {
                // 获取 ViewModel 中的数据
                var second: Int? = myViewModel.second.value

                // 将 ViewModel 中的数据自增 1
                myViewModel.second.postValue(second?.plus(1))
            }
        }, 1000, 1000)
    }
}