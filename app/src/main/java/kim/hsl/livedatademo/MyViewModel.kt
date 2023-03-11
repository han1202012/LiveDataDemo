package kim.hsl.livedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel {
    var second: MutableLiveData<Int> = MutableLiveData<Int>()

    constructor() {
        second.value = 0
    }
}