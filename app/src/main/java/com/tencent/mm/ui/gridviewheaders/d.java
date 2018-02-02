package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public final class d extends BaseAdapter implements b {
    private DataSetObserver BD = new DataSetObserver(this) {
        final /* synthetic */ d zfk;

        {
            this.zfk = r1;
        }

        public final void onChanged() {
            this.zfk.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            this.zfk.notifyDataSetInvalidated();
        }
    };
    private ListAdapter zfj;

    public d(ListAdapter listAdapter) {
        this.zfj = listAdapter;
        listAdapter.registerDataSetObserver(this.BD);
    }

    public final int getCount() {
        return this.zfj.getCount();
    }

    public final Object getItem(int i) {
        return this.zfj.getItem(i);
    }

    public final long getItemId(int i) {
        return this.zfj.getItemId(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.zfj.getView(i, view, viewGroup);
    }

    public final int Gz(int i) {
        return 0;
    }

    public final int cxl() {
        return 0;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
