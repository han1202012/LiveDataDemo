package kim.hsl.livedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel {
    var progress: MutableLiveData<Int> = MutableLiveData<Int>()

    constructor() {
        progress.value = 0
    }
}