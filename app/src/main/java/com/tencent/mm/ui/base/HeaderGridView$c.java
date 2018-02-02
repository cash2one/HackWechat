package com.tencent.mm.ui.base;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.mm.ui.base.HeaderGridView.a;
import java.util.ArrayList;
import java.util.Iterator;

class HeaderGridView$c implements Filterable, WrapperListAdapter {
    private final ListAdapter FP;
    public final DataSetObservable mDataSetObservable = new DataSetObservable();
    int mNumColumns = 1;
    ArrayList<a> xXO;
    boolean xXR;
    private final boolean xXS;

    public HeaderGridView$c(ArrayList<a> arrayList, ListAdapter listAdapter) {
        this.FP = listAdapter;
        this.xXS = listAdapter instanceof Filterable;
        if (arrayList == null) {
            throw new IllegalArgumentException("headerViewInfos cannot be null");
        }
        this.xXO = arrayList;
        this.xXR = ai(this.xXO);
    }

    public final boolean isEmpty() {
        return (this.FP == null || this.FP.isEmpty()) && this.xXO.size() == 0;
    }

    private static boolean ai(ArrayList<a> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((a) it.next()).isSelectable) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int getCount() {
        if (this.FP != null) {
            return (this.xXO.size() * this.mNumColumns) + this.FP.getCount();
        }
        return this.xXO.size() * this.mNumColumns;
    }

    public final boolean areAllItemsEnabled() {
        if (this.FP == null) {
            return true;
        }
        if (this.xXR && this.FP.areAllItemsEnabled()) {
            return true;
        }
        return false;
    }

    public final boolean isEnabled(int i) {
        int size = this.xXO.size() * this.mNumColumns;
        if (i >= size) {
            size = i - size;
            return (this.FP == null || size >= this.FP.getCount()) ? false : this.FP.isEnabled(size);
        } else if (i % this.mNumColumns == 0 && ((a) this.xXO.get(i / this.mNumColumns)).isSelectable) {
            return true;
        } else {
            return false;
        }
    }

    public final Object getItem(int i) {
        int size = this.xXO.size() * this.mNumColumns;
        if (i >= size) {
            size = i - size;
            if (this.FP == null || size >= this.FP.getCount()) {
                return null;
            }
            return this.FP.getItem(size);
        } else if (i % this.mNumColumns == 0) {
            return ((a) this.xXO.get(i / this.mNumColumns)).data;
        } else {
            return null;
        }
    }

    public final long getItemId(int i) {
        int size = this.xXO.size() * this.mNumColumns;
        if (this.FP != null && i >= size) {
            size = i - size;
            if (size < this.FP.getCount()) {
                return this.FP.getItemId(size);
            }
        }
        return -1;
    }

    public final boolean hasStableIds() {
        if (this.FP != null) {
            return this.FP.hasStableIds();
        }
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int size = this.xXO.size() * this.mNumColumns;
        if (i < size) {
            View view2 = ((a) this.xXO.get(i / this.mNumColumns)).xXP;
            if (i % this.mNumColumns == 0) {
                return view2;
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            view.setMinimumHeight(view2.getHeight());
            return view;
        }
        size = i - size;
        if (this.FP != null && size < this.FP.getCount()) {
            return this.FP.getView(size, view, viewGroup);
        }
        if (view == null) {
            view = new View(viewGroup.getContext());
        }
        view.setVisibility(4);
        return view;
    }

    public final int getItemViewType(int i) {
        int size = this.xXO.size() * this.mNumColumns;
        if (i < size && i % this.mNumColumns != 0) {
            return this.FP != null ? this.FP.getViewTypeCount() : 1;
        } else {
            if (this.FP != null && i >= size) {
                size = i - size;
                if (size < this.FP.getCount()) {
                    return this.FP.getItemViewType(size);
                }
            }
            return -2;
        }
    }

    public final int getViewTypeCount() {
        if (this.FP != null) {
            return this.FP.getViewTypeCount() + 1;
        }
        return 2;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
        if (this.FP != null) {
            this.FP.registerDataSetObserver(dataSetObserver);
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
        if (this.FP != null) {
            this.FP.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public final Filter getFilter() {
        if (this.xXS) {
            return ((Filterable) this.FP).getFilter();
        }
        return null;
    }

    public final ListAdapter getWrappedAdapter() {
        return this.FP;
    }
}
