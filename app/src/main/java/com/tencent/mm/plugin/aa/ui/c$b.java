package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.contact.a.a.b;

public class c$b extends b {
    final /* synthetic */ c iit;

    public c$b(c cVar) {
        this.iit = cVar;
        super(cVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate;
        if (a.ey(context)) {
            inflate = LayoutInflater.from(context).inflate(g.qfz, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(context).inflate(g.qfy, viewGroup, false);
        }
        c.a aVar = this.iit.iio;
        aVar.iip = (ImageView) inflate.findViewById(a$f.bLL);
        aVar.iiq = (TextView) inflate.findViewById(a$f.cSu);
        aVar.iir = (TextView) inflate.findViewById(a$f.caS);
        aVar.contentView = inflate.findViewById(a$f.cKR);
        aVar.iis = (CheckBox) inflate.findViewById(a$f.cKI);
        LayoutParams layoutParams = (LayoutParams) aVar.iis.getLayoutParams();
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(d.ubO);
        layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.ubP);
        aVar.iis.setLayoutParams(layoutParams);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
        c.a aVar3 = (c.a) aVar;
        c cVar = (c) aVar2;
        if (cVar.username == null || cVar.username.length() <= 0) {
            aVar3.iip.setImageResource(e.bBB);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.iip, cVar.username);
        }
        if (bh.M(cVar.iil)) {
            aVar3.iiq.setVisibility(8);
        } else {
            aVar3.iiq.setText(cVar.iil);
            aVar3.iiq.setVisibility(0);
        }
        if (bh.M(cVar.iim)) {
            aVar3.iir.setVisibility(8);
        } else {
            aVar3.iir.setText(cVar.iim);
            aVar3.iir.setVisibility(0);
        }
        if (this.iit.ySW) {
            if (z) {
                aVar3.iis.setChecked(true);
                aVar3.iis.setEnabled(false);
            } else {
                aVar3.iis.setChecked(z2);
                aVar3.iis.setEnabled(true);
            }
            aVar3.iis.setVisibility(0);
        } else {
            aVar3.iis.setVisibility(8);
        }
        if (this.iit.kFO) {
            aVar3.contentView.setBackgroundResource(e.bBy);
        } else {
            aVar3.contentView.setBackgroundResource(e.bBx);
        }
        if (cVar.jLe.field_deleteFlag == 1) {
            aVar3.iir.setVisibility(0);
            aVar3.iir.setText(context.getString(i.uGL));
        }
    }

    public final boolean WS() {
        return false;
    }
}
