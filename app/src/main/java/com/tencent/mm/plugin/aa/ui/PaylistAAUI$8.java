package com.tencent.mm.plugin.aa.ui;

import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.j.b;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.s;

class PaylistAAUI$8 implements a$a {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$8(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final void WO() {
        int i;
        int i2 = i.uOw;
        if (s.eV(PaylistAAUI.a(this.ikp))) {
            i = i2;
        } else {
            i = i.uOx;
        }
        b bVar = new b(this.ikp);
        String string = this.ikp.getString(i.uOy);
        int fromDPToPix = a.fromDPToPix(bVar.mContext, (int) (20.0f * a.eu(bVar.mContext)));
        if (!bh.ov(string)) {
            bVar.vnq.P((SpannableString) com.tencent.mm.ui.e.c.b.a(bVar.mContext, string.toString(), fromDPToPix));
        }
        View inflate = v.fv(this.ikp).inflate(g.uEm, null);
        TextView textView = (TextView) inflate.findViewById(a$f.text);
        ((ImageView) inflate.findViewById(a$f.image)).setImageResource(e.udv);
        textView.setText(i);
        bVar.vnq.dk(inflate);
        bVar.EG(i.dGA);
        bVar.xZR = this.ikp.getString(i.dEn);
        bVar.xZT = false;
        bVar.a(new 1(this), new 2(this));
        bVar.pyk.show();
        com.tencent.mm.plugin.report.service.g.pQN.h(13721, Integer.valueOf(4), Integer.valueOf(7));
    }
}
