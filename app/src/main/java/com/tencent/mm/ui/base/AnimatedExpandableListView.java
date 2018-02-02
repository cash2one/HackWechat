package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class AnimatedExpandableListView extends ExpandableListView {
    private static final String TAG = a.class.getSimpleName();
    private a xXs;

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof a) {
            this.xXs = (a) expandableListAdapter;
            a.a(this.xXs, this);
            return;
        }
        throw new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
    }

    @SuppressLint({"NewApi"})
    public final boolean El(int i) {
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < getChildCount() && getChildAt(flatListPosition).getBottom() >= getBottom()) {
                this.xXs.En(i).xXG = -1;
                return expandGroup(i);
            }
        }
        a.a(this.xXs, i);
        return expandGroup(i);
    }

    public final boolean Em(int i) {
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < 0 || flatListPosition >= getChildCount()) {
                return collapseGroup(i);
            }
            if (getChildAt(flatListPosition).getBottom() >= getBottom()) {
                return collapseGroup(i);
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        flatListPosition = getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = getPackedPositionGroup(expandableListPosition);
        if (flatListPosition == -1 || packedPositionGroup != i) {
            flatListPosition = 0;
        }
        a.a(this.xXs, i, flatListPosition);
        this.xXs.notifyDataSetChanged();
        return isGroupExpanded(i);
    }
}
