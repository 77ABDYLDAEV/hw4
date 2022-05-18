package com.example.hw4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNoteFragment extends Fragment {

    private EditText etTitle, etDesciption;
    private Button btnAdd;



    public AddNoteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_note, container, false);
        etTitle = view.findViewById(R.id.et_title);
        etDesciption = view.findViewById(R.id.et_description);
        btnAdd = view.findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(view1 -> {
            String title = etTitle.getText().toString();
            String description = etDesciption.getText().toString();
            String dateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault()).format(new Date());

            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("description", description);
            bundle.putString("date", dateTime);

            requireActivity().getSupportFragmentManager().setFragmentResult("addNote", bundle);
            requireActivity().getSupportFragmentManager().popBackStack();



        });

        return view;
    }
}