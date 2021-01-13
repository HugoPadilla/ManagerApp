package com.manager.managerapp.ui.main;

import androidx.lifecycle.ViewModel;

import com.manager.managerapp.common.pojo.Email;
import com.manager.managerapp.repository.repositoryFirebase;

public class MainViewModel extends ViewModel {

    private repositoryFirebase mRepository;

    public MainViewModel() {
        mRepository = new repositoryFirebase();
    }

    public void addEmailVinculado(Email email) {
        mRepository.addEmailVinculado(email);
    }
}
