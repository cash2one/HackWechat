package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

public final class e extends d {
    private Context mContext = null;

    public e(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(g.uCA, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.jJn = (TextView) view.findViewById(f.uot);
            aVar2.lkn = (TextView) view.findViewById(f.uor);
            aVar2.oid = (TextView) view.findViewById(f.uos);
            aVar2.ogw = (TextView) view.findViewById(f.uoq);
            aVar2.wn = i;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        h sh = sh(i);
        aVar.jJn.setText(sh.ocs);
        aVar.oid.setText(sh.oct);
        aVar.ogw.setText(this.mContext.getString(i.uJK, new Object[]{com.tencent.mm.wallet_core.ui.e.t(((double) sh.obU) / 100.0d)}));
        CharSequence string = this.mContext.getString(i.uKR, new Object[]{Long.valueOf(sh.obS), Long.valueOf(sh.ocu)});
        if (sh.status == 5) {
            string = this.mContext.getString(i.uKS) + " " + string;
        }
        aVar.lkn.setText(string);
        return view;
    }
}
