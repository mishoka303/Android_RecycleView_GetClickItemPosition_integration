package com.android.recycleviewppp;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name, facno, phone;
    DialogListener RecycleViewListener;

    public ViewHolder(@NonNull View itemView, DialogListener onNoteListener) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        facno = itemView.findViewById(R.id.facno);
        phone = itemView.findViewById(R.id.phone);

        this.RecycleViewListener = onNoteListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        RecycleViewListener.onRecyclerItemClicked(getAdapterPosition());
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setFacno(String facno) {
        this.facno.setText(facno);
    }

    public void setPhone(String phone) {
        this.phone.setText(phone);
    }
}
