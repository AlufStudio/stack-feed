package com.tuyenmonkey.stackfeed.presentation.main.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tuyenmonkey.stackfeed.R;
import com.tuyenmonkey.stackfeed.base.BaseRecyclerViewAdapter;
import com.tuyenmonkey.stackfeed.databinding.ItemQuestionBinding;
import com.tuyenmonkey.stackfeed.presentation.main.viewmodel.QuestionItemViewModel;

/**
 * Created by Tuyen Nguyen on 5/4/16.
 */
public class QuestionAdapter extends BaseRecyclerViewAdapter<QuestionItemViewModel> {

    private static final String TAG = QuestionAdapter.class.getSimpleName();

    private LayoutInflater inflater;

    public QuestionAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemQuestionBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_question, parent, false);
        return new QuestionHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((QuestionHolder)holder).bind(mItems.get(position));
    }

    static class QuestionHolder extends RecyclerView.ViewHolder {

        private ItemQuestionBinding binding;

        public QuestionHolder(ItemQuestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(QuestionItemViewModel itemViewModel) {
            this.binding.setViewModel(itemViewModel);
            this.binding.executePendingBindings();
        }
    }
}
