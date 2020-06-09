package com.android.recycleviewppp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogListener {
    private static final String TAG = "MainActivity";

    RecyclerView view;
    ViewAdapter adapter;
    FloatingActionButton button;
    ArrayList<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        view = findViewById(R.id.recyclerVIew);
        adapter = new ViewAdapter(students, this);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));

        button = findViewById(R.id.mainAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Opening add dialog...", Toast.LENGTH_SHORT).show();
                FragmentManager fmanager = getSupportFragmentManager();
                FragmentDialog fragdialog = FragmentDialog.newInstance();
                fragdialog.show(fmanager, "Guten tag");
            }
        });
    }

    @Override
    public void onFinish(Student student) {
        students.add(student);
        adapter.notifyItemChanged(adapter.getItemCount());
    }

    @Override
    public void onRecyclerItemClicked(int position) {
        Log.d(TAG, "onNoteClick: clicked on " + position + " position.");
    }
}
