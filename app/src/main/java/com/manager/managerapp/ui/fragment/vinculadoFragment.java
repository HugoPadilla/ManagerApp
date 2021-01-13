
package com.manager.managerapp.ui.fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.manager.managerapp.common.pojo.Email;
import com.manager.managerapp.common.pojo.ItemEmailList;
import com.manager.managerapp.databinding.VinculadoFragmentBinding;
import com.manager.managerapp.ui.adapter.recyclerViewHomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class vinculadoFragment extends Fragment  {

    private VinculadoViewModel mViewModel;
    private VinculadoFragmentBinding viewBinding;

    public static vinculadoFragment newInstance() {
        return new vinculadoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewBinding = VinculadoFragmentBinding.inflate(inflater, container, false);
        recyclerViewConfing();
        return viewBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(VinculadoViewModel.class);
        // TODO: Use the ViewModel
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

    private void recyclerViewConfing() {
        Query query = FirebaseFirestore.getInstance().collection("email").whereEqualTo("viculado",true).orderBy("email", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Email> options = new FirestoreRecyclerOptions.Builder<Email>().setLifecycleOwner(this).setQuery(query, Email.class).build();
        // RecyclerView manager and adapter
        viewBinding.recyclerViewVinculado.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewBinding.recyclerViewVinculado.setAdapter(new recyclerViewHomeAdapter(options));
    }
}