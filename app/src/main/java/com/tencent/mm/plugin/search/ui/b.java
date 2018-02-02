package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    private int count;
    String fDj;
    private OnScrollListener lgq;
    private c qbT;
    private SparseArray<com.tencent.mm.plugin.fts.d.a.b> qbU = new SparseArray();
    long qbV;
    a qbW;

    public interface a {
        void H(int i, boolean z);
    }

    protected abstract boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z);

    protected abstract void bpU();

    protected abstract com.tencent.mm.plugin.fts.d.a.b qf(int i);

    public /* synthetic */ Object getItem(int i) {
        return vQ(i);
    }

    public final Context getContext() {
        return this.qbT.getContext();
    }

    public b(c cVar) {
        x.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
        this.qbT = cVar;
    }

    protected final void vP(int i) {
        x.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[]{Integer.valueOf(i)});
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemViewType(int i) {
        if (vQ(i) != null) {
            return vQ(i).kTK;
        }
        x.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
        return -1;
    }

    public int getViewTypeCount() {
        return 21;
    }

    private com.tencent.mm.plugin.fts.d.a.b vQ(int i) {
        if (this.qbU.indexOfKey(i) >= 0) {
            return (com.tencent.mm.plugin.fts.d.a.b) this.qbU.get(i);
        }
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i >= 0 && i < getCount()) {
            bVar = qf(i);
        }
        if (bVar == null) {
            return (com.tencent.mm.plugin.fts.d.a.b) this.qbU.get(0);
        }
        this.qbU.put(i, bVar);
        return bVar;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.fts.d.a.b vQ = vQ(i);
        if (view == null) {
            view = vQ.adp().a(getContext(), viewGroup);
        }
        com.tencent.mm.plugin.fts.d.a.b.a aVar = (com.tencent.mm.plugin.fts.d.a.b.a) view.getTag();
        if (!vQ.mPv) {
            vQ.a(getContext(), aVar, new Object[0]);
            vQ.mPv = true;
        }
        vQ.adp().a(getContext(), aVar, vQ, new Object[0]);
        return view;
    }

    public final void IT(String str) {
        stopSearch();
        this.qbV = System.currentTimeMillis();
        this.fDj = str;
        x.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[]{str});
        bpU();
    }

    public void stopSearch() {
        this.count = 0;
        this.fDj = "";
        clearCache();
        notifyDataSetChanged();
    }

    public void finish() {
        stopSearch();
    }

    protected void clearCache() {
        this.qbU.clear();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lgq != null) {
            this.lgq.onScrollStateChanged(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lgq != null) {
            this.lgq.onScroll(absListView, i, i2, i3);
        }
    }

    protected final void G(int i, boolean z) {
        if (this.qbW != null) {
            this.qbW.H(i, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.qbT.aWs();
        if (i < getCount()) {
            com.tencent.mm.plugin.fts.d.a.b vQ = vQ(i);
            a(view, vQ, vQ.adp().a(getContext(), vQ));
            this.qbT.a(vQ);
        }
    }

    protected int aNp() {
        return getCount();
    }
}
