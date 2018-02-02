package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a.a;
import junit.framework.Assert;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    protected Context mContext;
    public SparseArray<a> yjU;
    public Runnable yjV;

    public abstract a nv(int i);

    public abstract Object[] nw(int i);

    public /* synthetic */ Object getItem(int i) {
        return ny(i);
    }

    public b(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null.");
        }
        this.mContext = context;
        this.yjU = new SparseArray();
        this.yjV = new 1(this);
    }

    public int getCount() {
        return this.yjU.size();
    }

    public int getItemViewType(int i) {
        if (ny(i) == null) {
            x.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", Integer.valueOf(getCount()), Integer.valueOf(i));
            return 0;
        } else if (ny(i) == null) {
            return 0;
        } else {
            return ny(i).type;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    public a ny(int i) {
        if (i < 0 || i > getCount()) {
            x.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", Integer.valueOf(i));
            return null;
        }
        a aVar = (a) this.yjU.get(i);
        if (aVar != null) {
            return aVar;
        }
        aVar = nv(i);
        this.yjU.put(i, aVar);
        return aVar;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        long currentTimeMillis = System.currentTimeMillis();
        a ny = ny(i);
        if (ny == null) {
            x.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            a$b asm = ny.asm();
            if (asm == null) {
                x.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
            } else {
                a asn;
                if (view == null) {
                    view = asm.b(this.mContext, view);
                    asn = ny.asn();
                    asm.a(view, asn);
                    view.setTag(asn);
                } else {
                    asn = (a) view.getTag();
                }
                Object[] nw = nw(i);
                Assert.assertNotNull(asn);
                if (!ny.yjT) {
                    ny.a(this.mContext, asn, nw);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                asm.a(this.mContext, asn, ny);
                long currentTimeMillis4 = System.currentTimeMillis();
                x.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3));
            }
        }
        return view;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a ny = ny(i);
        if (ny != null) {
            a$b asm = ny.asm();
            if (asm != null && asm.a(this.mContext, ny, nw(i))) {
            }
        }
    }
}
