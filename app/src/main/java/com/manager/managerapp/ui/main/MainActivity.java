package com.manager.managerapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.manager.managerapp.R;
import com.manager.managerapp.common.pojo.Email;
import com.manager.managerapp.databinding.ActivityMainBinding;
import com.manager.managerapp.ui.BottomSheetDialog;

public class MainActivity extends AppCompatActivity implements BottomSheetDialog.listenerBottomSheet {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // data binding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // instance of view model
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // instance of appbar configuration for Toolbar
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment
                ,R.id.vinculadoFragment
                ,R.id.perfilFragment)
                .build();
        // instance navController con la referencia del hotFragment
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(binding.toolbar,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavigationView,navController);

    }

    @Override
    public void onButtomAddEmailNewVinculado(Email email) {
        viewModel.addEmailVinculado(email);
    }
}