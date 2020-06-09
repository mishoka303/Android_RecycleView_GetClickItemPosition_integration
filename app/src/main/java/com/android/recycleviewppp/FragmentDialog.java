package com.android.recycleviewppp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FragmentDialog extends DialogFragment implements View.OnClickListener {
    EditText addName, addFacno, addPhone;
    Button addStudent;
    DialogListener dlistener;

    @Override
    public void onClick(View v) {
        Student student = new Student(addName.getText().toString(), addFacno.getText().toString(), addPhone.getText().toString());
        dlistener.onFinish(student);
        dismiss();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_student, container, false); //zamestvame s inflater, pokazvame add_student XML
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addName = view.findViewById(R.id.addName);
        addFacno = view.findViewById(R.id.addFacno);
        addPhone = view.findViewById(R.id.addPhone);
        addStudent = view.findViewById(R.id.addButton);
        addStudent.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dlistener = (DialogListener) context; //casted
    }

    public static FragmentDialog newInstance() {
        return new FragmentDialog();
    }
}
