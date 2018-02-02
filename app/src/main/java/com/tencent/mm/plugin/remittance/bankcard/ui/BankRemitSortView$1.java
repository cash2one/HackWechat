package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

class BankRemitSortView$1 implements a {
    final /* synthetic */ BankRemitSortView pJY;

    BankRemitSortView$1(BankRemitSortView bankRemitSortView) {
        this.pJY = bankRemitSortView;
    }

    public final View a(d dVar, View view, int i, boolean z, boolean z2) {
        Context context = this.pJY.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(g.uBl, null);
            BankRemitSortView.a aVar = new BankRemitSortView.a(this.pJY, (byte) 0);
            aVar.pJZ = (TextView) view.findViewById(f.bSw);
            aVar.pHJ = (TextView) view.findViewById(f.ugL);
            aVar.pHH = (CdnImageView) view.findViewById(f.ugK);
            view.setTag(aVar);
        }
        BankRemitSortView.a aVar2 = (BankRemitSortView.a) view.getTag();
        ez ezVar = (ez) dVar.data;
        if (ezVar != null) {
            if (this.pJY.ykc && z) {
                if (dVar.ykk.equals("☆")) {
                    aVar2.pJZ.setText(i.uHR);
                } else {
                    aVar2.pJZ.setText(dVar.ykk);
                }
                aVar2.pJZ.setVisibility(0);
            } else {
                aVar2.pJZ.setVisibility(8);
            }
            aVar2.pHH.setUrl(ezVar.pHq);
            aVar2.pHJ.setText(ezVar.nBM);
        } else {
            x.w("MicroMsg.BankcardSortView", "elem is null: %s", new Object[]{Integer.valueOf(i)});
        }
        return view;
    }
}
