package com.manager.managerapp.ui.main;

import androidx.lifecycle.ViewModel;

import com.manager.managerapp.common.pojo.Email;
import com.manager.managerapp.repository.repositoryFirebase;

public class MainViewModel extends ViewModel {

    private final repositoryFirebase repositoryFirebase;

    public MainViewModel() {
        this.repositoryFirebase = new repositoryFirebase();
    }

    public void addEmailVinculado(Email email) {
        repositoryFirebase.addEmailVinculado(email);
    }
}
