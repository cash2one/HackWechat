package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ui.o;

public abstract class a<T> extends o<T> implements OnScrollListener {
    private static final String TAG = ("MicroMsg." + a.class.getName());
    protected boolean maM;

    public abstract boolean awe();

    public abstract int awf();

    public abstract int bmq();

    public a(Context context, T t) {
        super(context, t);
        lU(true);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.maM = false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
