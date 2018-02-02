package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.collect.b.h;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    List<h> lli = new ArrayList();
    private Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return or(i);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.lli.size();
    }

    public final h or(int i) {
        return (h) this.lli.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = v.fv(this.mContext).inflate(g.uBu, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        h or = or(i);
        aVar.llj.setText(e.a(this.mContext, or.liA, or.type));
        aVar.llk.setText(e.oq(or.liC));
        aVar.lkn.setText(this.mContext.getString(i.uIt, new Object[]{Integer.valueOf(or.liB)}));
        return view;
    }

    public final void ax(List<h> list) {
        this.lli.clear();
        this.lli.addAll(list);
        notifyDataSetChanged();
    }

    public final void ay(List<h> list) {
        this.lli.addAll(list);
        notifyDataSetChanged();
    }
}
