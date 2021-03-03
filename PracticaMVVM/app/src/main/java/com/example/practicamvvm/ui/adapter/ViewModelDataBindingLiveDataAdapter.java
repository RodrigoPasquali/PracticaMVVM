package com.example.practicamvvm.ui.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class ViewModelDataBindingLiveDataAdapter {
    @BindingAdapter("visible")
    public static void setVisibility(View view, boolean visible) {
        if(visible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter({"visibility", "size"})
    public static void setSize(TextView view, boolean visibility, float size) {
        setVisibility(view, visibility);
        view.setTextSize(size);
    }
}
