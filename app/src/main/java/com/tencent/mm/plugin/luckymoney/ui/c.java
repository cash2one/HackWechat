package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.ui.e;

public final class c extends d {
    private Context mContext;

    public c(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(a$g.uCy, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.nqD = (TextView) view.findViewById(f.uoo);
            aVar2.oid = (TextView) view.findViewById(f.uop);
            aVar2.ogw = (TextView) view.findViewById(f.uok);
            aVar2.oht = (ImageView) view.findViewById(f.uom);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        h sh = sh(i);
        n.a(this.mContext, aVar.nqD, sh.ocp);
        aVar.oid.setText(sh.ocr);
        aVar.ogw.setText(this.mContext.getString(a$i.upj, new Object[]{e.t(((double) sh.ocq) / 100.0d)}));
        if (sh.obK == 1) {
            aVar.oht.setImageResource(a.e.ucY);
            aVar.oht.setVisibility(0);
        } else if (sh.obK == 2) {
            aVar.oht.setImageResource(a.e.ucW);
            aVar.oht.setVisibility(0);
        } else {
            aVar.oht.setVisibility(8);
        }
        return view;
    }
}
