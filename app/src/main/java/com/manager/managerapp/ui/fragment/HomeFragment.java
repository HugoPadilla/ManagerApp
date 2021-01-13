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

    private HomeViewModel viewModel;
    private HomeFragmentBinding binding;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);

        Toast.makeText(getActivity(), "onCreateView", Toast.LENGTH_SHORT).show();

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        binding.setViewModel(viewModel);
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
        /*mViewModel.get_isEmpty().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    viewBinding.imageView.setVisibility(View.VISIBLE);
                } else {
                    viewBinding.imageView.setVisibility(View.GONE);
                }
            }
        });*/
    }

    private void listenerViewConfig() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setBoolean();
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
        binding.recyclerViewHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerViewHome.setAdapter(recyclerViewHomeAdapter);

    }


}