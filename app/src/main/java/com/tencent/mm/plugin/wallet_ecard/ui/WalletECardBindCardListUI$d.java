package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.x;

class WalletECardBindCardListUI$d implements b {
    TextView jJn;
    TextView kQo;
    final /* synthetic */ WalletECardBindCardListUI sZK;
    CdnImageView sZN;

    public WalletECardBindCardListUI$d(WalletECardBindCardListUI walletECardBindCardListUI, View view) {
        this.sZK = walletECardBindCardListUI;
        this.sZN = (CdnImageView) view.findViewById(f.ufz);
        this.jJn = (TextView) view.findViewById(f.ufC);
        this.kQo = (TextView) view.findViewById(f.ufB);
    }

    public final void a(View view, ey eyVar) {
        if (eyVar != null) {
            this.sZN.vnf = true;
            this.sZN.setUrl(eyVar.vKK);
            this.jJn.setText(String.format("%s %s(%s)", new Object[]{eyVar.nBM, eyVar.kUg, eyVar.vKI}));
            this.kQo.setText(String.format("%s", new Object[]{eyVar.sIF}));
            if (eyVar.vKL) {
                x.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[]{eyVar.nBM});
                view.setEnabled(false);
                this.jJn.setTextColor(this.sZK.getResources().getColor(c.uaG));
                this.kQo.setTextColor(this.sZK.getResources().getColor(c.uaG));
                return;
            }
            view.setEnabled(true);
            this.jJn.setTextColor(this.sZK.getResources().getColor(c.black));
            this.kQo.setTextColor(this.sZK.getResources().getColor(c.bts));
        }
    }
}
