package com.manager.managerapp.ui.fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.manager.managerapp.common.pojo.Email;
import com.manager.managerapp.databinding.HomeFragmentBinding;
import com.manager.managerapp.ui.BottomSheetDialog;
import com.manager.managerapp.ui.adapter.recyclerViewHomeAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private HomeFragmentBinding homeFragmentBinding;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false);
        homeFragmentBinding.setLifecycleOwner(this);

        Toast.makeText(getActivity(), "onCreateView", Toast.LENGTH_SHORT).show();

        return homeFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        homeFragmentBinding.setViewModel(homeViewModel);
        // TODO: Use the ViewModel
        recyclerViewConfing();
        observerViewModel();
        listenerViewConfig();
        Toast.makeText(getActivity(), "onActivityCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "onStop", Toast.LENGTH_SHORT).show();
    }


    private void observerViewModel() {
        homeViewModel.get_isEmpty().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    homeFragmentBinding.imageView.setVisibility(View.VISIBLE);
                } else {
                    homeFragmentBinding.imageView.setVisibility(View.GONE);
                }
            }
        });
    }

    private void listenerViewConfig() {
        homeFragmentBinding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeViewModel.setBoolean();
                /*BottomSheetDialog mSheetDialog = new BottomSheetDialog();
                mSheetDialog.show(getActivity().getSupportFragmentManager(), "showBottomSheetDiaolog");*/
            }
        });
    }

    private void recyclerViewConfing() {
        Query query = FirebaseFirestore.getInstance().collection("email").whereEqualTo("viculado", false).orderBy("email", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Email> options = new FirestoreRecyclerOptions.Builder<Email>().setLifecycleOwner(this).setQuery(query, Email.class).build();
        // RecyclerView manager and adapter
        recyclerViewHomeAdapter recyclerViewHomeAdapter = new recyclerViewHomeAdapter(options);
        homeFragmentBinding.recyclerViewHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeFragmentBinding.recyclerViewHome.setAdapter(recyclerViewHomeAdapter);

    }


}