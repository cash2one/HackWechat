package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import junit.framework.Assert;

public abstract class n extends BaseAdapter {
    public int scene;
    private SparseArray<a> xmv;
    public l ySV;
    private boolean ySW;
    boolean ySX;

    public abstract a jb(int i);

    public /* synthetic */ Object getItem(int i) {
        return Gm(i);
    }

    public n(l lVar, boolean z, int i, boolean z2) {
        this.ySV = lVar;
        this.ySW = z;
        this.xmv = new SparseArray();
        this.scene = i;
        this.ySX = z2;
    }

    public n(l lVar, boolean z, int i) {
        this(lVar, z, i, false);
    }

    public boolean btz() {
        return this.ySW;
    }

    public final void nb(boolean z) {
        this.ySW = z;
        notifyDataSetChanged();
    }

    public final a Gm(int i) {
        if (this.xmv.indexOfKey(i) >= 0) {
            return (a) this.xmv.get(i);
        }
        if (i < 0 || i >= getCount()) {
            x.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
            return null;
        }
        a jb = jb(i);
        if (jb != null) {
            jb.kFO = c(jb);
            this.xmv.put(i, jb);
            x.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", Integer.valueOf(jb.kTK), Integer.valueOf(i));
            return jb;
        }
        x.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
        return jb;
    }

    protected boolean c(a aVar) {
        return false;
    }

    public long getItemId(int i) {
        return -1;
    }

    public int getItemViewType(int i) {
        if (Gm(i) != null) {
            return Gm(i).kTK;
        }
        x.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 8;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a Gm = Gm(i);
        if (view == null) {
            view = Gm.WQ().a(this.ySV.getActivity(), viewGroup);
        }
        a.a aVar = (a.a) view.getTag();
        Assert.assertNotNull(aVar);
        if (!Gm.yVa) {
            Gm.bH(this.ySV.getActivity());
            Gm.yVa = true;
        }
        Gm.ySW = btz();
        Gm.WQ().a(this.ySV.getActivity(), aVar, Gm, this.ySV.b(Gm), this.ySV.a(Gm));
        return view;
    }

    public final void clearCache() {
        if (this.xmv != null) {
            this.xmv.clear();
        }
    }

    public void finish() {
        clearCache();
    }

    public boolean Gn(int i) {
        return false;
    }
}
