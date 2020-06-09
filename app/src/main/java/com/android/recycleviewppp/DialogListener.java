package com.android.recycleviewppp;

import android.view.View;

public interface DialogListener {
    void onFinish(Student student) ;
    void onRecyclerItemClicked(int position) ;
}
