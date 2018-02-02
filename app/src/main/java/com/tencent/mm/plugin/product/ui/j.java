package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;

public final class j extends BaseAdapter {
    private Context mContext;
    m pgy;
    String pgz;

    public final /* synthetic */ Object getItem(int i) {
        return uG(i);
    }

    public j(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.pgy.peX != null ? this.pgy.peX.size() : 0;
    }

    private h uG(int i) {
        return (h) this.pgy.peX.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        return uG(i).peP;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        h uG = uG(i);
        if (view == null || view.getTag() == null) {
            inflate = View.inflate(this.mContext, g.uDC, null);
        } else {
            inflate = view;
        }
        CheckBox checkBox = (CheckBox) inflate;
        checkBox.setText(uG.name);
        checkBox.setEnabled(uG.peP);
        checkBox.setChecked(uG.id.equals(this.pgz));
        if (!uG.peP) {
            inflate.setBackgroundResource(e.udz);
        } else if (uG.id.equals(this.pgz)) {
            inflate.setBackgroundResource(e.udB);
        } else {
            inflate.setBackgroundResource(e.udA);
        }
        inflate.setTag(new Pair(this.pgy.peV, uG.id));
        return inflate;
    }
}
