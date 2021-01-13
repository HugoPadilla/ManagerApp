package com.manager.managerapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.manager.managerapp.R;
import com.manager.managerapp.common.pojo.Email;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    private listenerBottomSheet mListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_dialog,container,false);

        final EditText editTextEmail = view.findViewById(R.id.editTextEmail);
        final EditText editTextEmailVinculado = view.findViewById(R.id.editTextEmailVinculado);
        Button button = view.findViewById(R.id.buttonGuardar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString().trim();
                String emailVinculado = editTextEmailVinculado.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    editTextEmail.setError("Escribe un correo");
                }else if (TextUtils.isEmpty(emailVinculado)){
                    Email email1 = new Email(email,emailVinculado,false);
                    mListener.onButtomAddEmailNewVinculado(email1);
                    dismiss();
                }else {
                    Email email1 = new Email(email,emailVinculado,true);
                    mListener.onButtomAddEmailNewVinculado(email1);
                    dismiss();
                }
            }
        });

        return view;
    }

    public interface listenerBottomSheet {
        void onButtomAddEmailNewVinculado(Email email);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (listenerBottomSheet) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement listner");
        }
    }
}
