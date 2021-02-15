package com.manager.managerapp.ui.fragment;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<Boolean> _isEmpty;

    public HomeViewModel() {
        // Init Variable MutableLiveData
        get_isEmpty();
    }

    public MutableLiveData<Boolean> get_isEmpty () {
        if (_isEmpty == null){
            _isEmpty = new MutableLiveData<>();
        }
        return _isEmpty;
    }

    public LiveData<Boolean> isEmpy(){
        return _isEmpty;
    }

    public void setBoolean() {
        // Verfico si el valor es nulo o si ya tiene un valor
        if (get_isEmpty().getValue() == null || get_isEmpty().getValue()){
            get_isEmpty().setValue(false);
        } else {
            get_isEmpty().setValue(true);
        }
    }
}