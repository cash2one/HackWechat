package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;

class DragSortListView$a extends BaseAdapter {
    private ListAdapter FP;
    final /* synthetic */ DragSortListView zsq;

    public DragSortListView$a(DragSortListView dragSortListView, ListAdapter listAdapter) {
        this.zsq = dragSortListView;
        this.FP = listAdapter;
        this.FP.registerDataSetObserver(new 1(this, dragSortListView));
    }

    public final long getItemId(int i) {
        return this.FP.getItemId(i);
    }

    public final Object getItem(int i) {
        return this.FP.getItem(i);
    }

    public final int getCount() {
        return this.FP.getCount();
    }

    public final boolean areAllItemsEnabled() {
        return this.FP.areAllItemsEnabled();
    }

    public final boolean isEnabled(int i) {
        return this.FP.isEnabled(i);
    }

    public final int getItemViewType(int i) {
        return this.FP.getItemViewType(i);
    }

    public final int getViewTypeCount() {
        return this.FP.getViewTypeCount();
    }

    public final boolean hasStableIds() {
        return this.FP.hasStableIds();
    }

    public final boolean isEmpty() {
        return this.FP.isEmpty();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View childAt;
        View view2;
        if (view != null) {
            view = (c) view;
            childAt = view.getChildAt(0);
            view2 = this.FP.getView(i, childAt, this.zsq);
            if (view2 != childAt) {
                if (childAt != null) {
                    view.removeViewAt(0);
                }
                view.addView(view2);
            }
        } else {
            view2 = this.FP.getView(i, null, this.zsq);
            if (view2 instanceof Checkable) {
                childAt = new d(this.zsq.getContext());
            } else {
                childAt = new c(this.zsq.getContext());
            }
            childAt.setLayoutParams(new LayoutParams(-1, -2));
            childAt.addView(view2);
            view = childAt;
        }
        DragSortListView.a(this.zsq, this.zsq.getHeaderViewsCount() + i, view);
        return view;
    }
}
