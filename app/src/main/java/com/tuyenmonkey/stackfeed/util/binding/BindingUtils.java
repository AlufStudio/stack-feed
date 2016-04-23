package com.tuyenmonkey.stackfeed.util.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.tuyenmonkey.stackfeed.base.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * Created by Tuyen Nguyen on 4/23/16.
 */
public class BindingUtils {

    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static <T> void setItems(RecyclerView recyclerView, List<T> items) {
        BaseRecyclerViewAdapter<T> adapter = (BaseRecyclerViewAdapter<T>)recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItems(items);
        }
    }
}
