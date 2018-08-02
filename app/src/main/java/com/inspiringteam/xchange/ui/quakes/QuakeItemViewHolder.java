package com.inspiringteam.xchange.ui.quakes;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.inspiringteam.xchange.R;

import rx.functions.Action0;
import rx.functions.Action1;

/**
 * View holder for the quake item.
 */
class QuakeItemViewHolder implements View.OnClickListener {

    private View mRow;

    private TextView mTitle;

    private CheckBox mCheckBox;

    private Action0 mOnItemClickAction;

    public QuakeItemViewHolder(View rowView) {
        mRow = rowView;
        mTitle = rowView.findViewById(R.id.title);


        rowView.setOnClickListener(this);
    }

    public void bindItem(QuakeItem quakeItem) {
        mTitle.setText(quakeItem.getQuake().getLocation());


//        mRow.setBackgroundResource(quakeItem.getBackground());

        mOnItemClickAction = quakeItem.getOnClickAction();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickAction != null) {
            mOnItemClickAction.call();
        }
    }
}