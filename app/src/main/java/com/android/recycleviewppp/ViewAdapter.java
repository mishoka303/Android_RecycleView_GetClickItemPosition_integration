package com.android.recycleviewppp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<Student> students = new ArrayList<>();
    DialogListener mRecycleViewListener;

    public ViewAdapter(ArrayList<Student> students, DialogListener mOnRecycleViewListener) {
        this.students = students;
        this.mRecycleViewListener = mOnRecycleViewListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext(); // Vzemame sustoqnieto na parent
        LayoutInflater inflater = LayoutInflater.from(context); // Da mojem da chetem ot XLM-a(pravi vruzkata)
        View view = inflater.inflate(R.layout.student_element, parent, false);

        return new ViewHolder(view, mRecycleViewListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student1 = students.get(position);
        holder.setName(student1.getName());
        holder.setFacno(student1.getFacno());
        holder.setPhone(student1.getPhone());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    /*public void addStudent(Student student){
        students.add(0,student);
        notifyItemChanged(0);
    }*/
}
