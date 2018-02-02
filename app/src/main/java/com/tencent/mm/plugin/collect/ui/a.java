package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.v;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a extends BaseAdapter {
    List<com.tencent.mm.plugin.collect.b.a> lli = new ArrayList();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.lli.size();
    }

    public final Object getItem(int i) {
        return this.lli.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = v.fv(this.mContext).inflate(g.uBs, viewGroup, false);
            view.setTag(new a(view));
        }
        com.tencent.mm.plugin.collect.b.a aVar = (com.tencent.mm.plugin.collect.b.a) this.lli.get(i);
        a aVar2 = (a) view.getTag();
        aVar2.llj.setText(new SimpleDateFormat(this.mContext.getString(i.uIl)).format(new Date(aVar.timestamp * 1000)));
        aVar2.llk.setText(e.oq(aVar.fpO));
        if (bh.ov(aVar.desc)) {
            aVar2.lkn.setVisibility(8);
        } else {
            aVar2.lkn.setText(aVar.desc);
            aVar2.lkn.setVisibility(0);
        }
        return view;
    }
}
