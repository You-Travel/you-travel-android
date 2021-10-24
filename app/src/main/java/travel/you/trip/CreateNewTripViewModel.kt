package travel.you.trip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class CreateNewTripViewModel : ViewModel() {
    private var _createTrip = MutableLiveData<Boolean>()
    val createTrip: LiveData<Boolean>
        get() = _createTrip

    fun createTrip() {
        _createTrip.value = true
    }

}