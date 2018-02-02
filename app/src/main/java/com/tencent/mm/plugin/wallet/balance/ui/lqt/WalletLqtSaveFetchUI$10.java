package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;

class WalletLqtSaveFetchUI$10 implements OnClickListener {
    final /* synthetic */ aua sBB;
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$10(WalletLqtSaveFetchUI walletLqtSaveFetchUI, aua com_tencent_mm_protocal_c_aua) {
        this.sBv = walletLqtSaveFetchUI;
        this.sBB = com_tencent_mm_protocal_c_aua;
    }

    public final void onClick(View view) {
        View linearLayout = new LinearLayout(this.sBv);
        linearLayout.setOrientation(1);
        Iterator it = this.sBB.wBW.iterator();
        while (it.hasNext()) {
            rf rfVar = (rf) it.next();
            if (!(rfVar == null || rfVar.title == null)) {
                LinearLayout linearLayout2 = (LinearLayout) View.inflate(this.sBv, g.uFg, null);
                ((TextView) linearLayout2.findViewById(f.title)).setText(rfVar.title);
                ((TextView) linearLayout2.findViewById(f.caP)).setText(rfVar.desc);
                linearLayout.addView(linearLayout2);
            }
        }
        h.a(this.sBv.mController.xIM, "", this.sBv.getString(i.uRP), linearLayout, new 1(this));
    }
}
