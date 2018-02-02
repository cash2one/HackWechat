package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.b.h;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter {
    protected LayoutInflater DF;
    protected Context mContext;
    protected List<h> ogJ = new LinkedList();

    public /* synthetic */ Object getItem(int i) {
        return sh(i);
    }

    public d(Context context) {
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
    }

    public final void bd(List<h> list) {
        if (list == null) {
            this.ogJ = new LinkedList();
        } else {
            this.ogJ = list;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.ogJ.size();
    }

    public final void a(h hVar) {
        this.ogJ.remove(hVar);
    }

    public final h sh(int i) {
        return (h) this.ogJ.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
