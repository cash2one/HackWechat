package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends a {
    ArrayList<Object> ep = new ArrayList();
    Context mContext;
    int rQj;

    protected b(Context context, int i) {
        this.mContext = context;
        this.rQj = 4;
    }

    public void bZ(List<?> list) {
        clear();
        bY(list);
        this.ep.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        this.rQi.clear();
        this.ep.clear();
        notifyDataSetChanged();
    }

    public final void add(Object obj) {
        bM(obj);
        this.ep.add(obj);
        notifyDataSetChanged();
    }

    public final void add(int i, Object obj) {
        bM(obj);
        this.ep.add(i, obj);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.ep.size();
    }

    public Object getItem(int i) {
        return this.ep.get(i);
    }

    public final int getColumnCount() {
        return this.rQj;
    }

    public void dH(int i, int i2) {
        if (i2 < getCount()) {
            List list = this.ep;
            list.add(i2, list.remove(i));
            notifyDataSetChanged();
        }
    }

    public boolean xR(int i) {
        return true;
    }

    public boolean xS(int i) {
        return true;
    }
}
