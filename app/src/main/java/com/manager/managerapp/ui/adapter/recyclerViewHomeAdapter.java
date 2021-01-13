package com.manager.managerapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.manager.managerapp.R;
import com.manager.managerapp.common.pojo.ItemEmailList;
import com.manager.managerapp.databinding.ItemCorreoListBinding;
import com.manager.managerapp.common.pojo.Email;

import java.util.List;

public class recyclerViewHomeAdapter extends FirestoreRecyclerAdapter<Email, recyclerViewHomeAdapter.MiViewHolder> {


    public recyclerViewHomeAdapter(@NonNull FirestoreRecyclerOptions<Email> options) {
        super(options);
    }

    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCorreoListBinding binding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()), R.layout.item_correo_list, parent, false);
        return new MiViewHolder(binding);
    }


    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    protected void onBindViewHolder(@NonNull MiViewHolder holder, int position, @NonNull Email model) {

        holder.mBindin.textViewEmail.setText(model.getEmail());
        holder.mBindin.textViewEmailVinculado.setText(model.getEmailVinculado());
    }


    public static class MiViewHolder extends RecyclerView.ViewHolder {

        ItemCorreoListBinding mBindin;

        public MiViewHolder(@NonNull ItemCorreoListBinding binding) {
            super(binding.getRoot());
            this.mBindin = binding;
            mBindin.executePendingBindings();
        }
    }
}
