package com.tuyenmonkey.stackfeed.base;

import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 4/23/16.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> mItems = new ArrayList<>();
    private int mRecyclerViewRefCount = 0;
    private final WeakReferenceOnListChangedCallback<T> callback =
            new WeakReferenceOnListChangedCallback<>(this);

    @SuppressWarnings("unchecked")
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (mRecyclerViewRefCount == 0 && mItems != null && mItems instanceof ObservableList) {
            ((ObservableList)mItems).addOnListChangedCallback(callback);
        }
        mRecyclerViewRefCount += 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        mRecyclerViewRefCount -= 1;
        if (mRecyclerViewRefCount == 0 && mItems != null && mItems instanceof ObservableList) {
            ((ObservableList)mItems).removeOnListChangedCallback(callback);
        }
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    protected int indexOf(T item) {
        return this.mItems.indexOf(item);
    }

    public void setItems(List<T> items) {
        if (this.mItems == items) {
            return;
        }
        if (mRecyclerViewRefCount > 0) {
            if (this.mItems instanceof ObservableList) {
                ((ObservableList<T>)this.mItems).removeOnListChangedCallback(callback);
            }
            if (items instanceof ObservableList) {
                ((ObservableList<T>) items).addOnListChangedCallback(callback);
            }
        }
        this.mItems = items;
        notifyDataSetChanged();
    }

    private static class WeakReferenceOnListChangedCallback<T> extends ObservableList.OnListChangedCallback<ObservableList<T>> {
        final WeakReference<BaseRecyclerViewAdapter<T>> adapterRef;

        WeakReferenceOnListChangedCallback(BaseRecyclerViewAdapter<T> adapter) {
            this.adapterRef = new WeakReference<>(adapter);
        }

        @Override
        public void onChanged(ObservableList sender) {
            BaseRecyclerViewAdapter<T> adapter = adapterRef.get();
            if (adapter == null) {
                return;
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(ObservableList sender, final int positionStart, final int itemCount) {
            BaseRecyclerViewAdapter<T> adapter = adapterRef.get();
            if (adapter == null) {
                return;
            }
            adapter.notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeInserted(ObservableList sender, final int positionStart, final int itemCount) {
            BaseRecyclerViewAdapter<T> adapter = adapterRef.get();
            if (adapter == null) {
                return;
            }
            adapter.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeMoved(ObservableList sender, final int fromPosition, final int toPosition, final int itemCount) {
            BaseRecyclerViewAdapter<T> adapter = adapterRef.get();
            if (adapter == null) {
                return;
            }
            for (int i = 0; i < itemCount; i++) {
                adapter.notifyItemMoved(fromPosition + i, toPosition + i);
            }
        }

        @Override
        public void onItemRangeRemoved(ObservableList sender, final int positionStart, final int itemCount) {
            BaseRecyclerViewAdapter<T> adapter = adapterRef.get();
            if (adapter == null) {
                return;
            }
            adapter.notifyItemRangeRemoved(positionStart, itemCount);
        }
    }
}
