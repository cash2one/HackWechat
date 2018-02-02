package com.tencent.mm.plugin.wallet_index.ui;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.t;

class WalletBrandUI$e implements b {
    final /* synthetic */ WalletBrandUI tbb;

    WalletBrandUI$e(WalletBrandUI walletBrandUI) {
        this.tbb = walletBrandUI;
    }

    public final int bNo() {
        return 2755;
    }

    public final k bNp() {
        WalletBrandUI.a(this.tbb, this.tbb.getIntent().getStringExtra("appId"));
        String stringExtra = this.tbb.getIntent().getStringExtra("signtype");
        String stringExtra2 = this.tbb.getIntent().getStringExtra("nonceStr");
        String stringExtra3 = this.tbb.getIntent().getStringExtra("timeStamp");
        String stringExtra4 = this.tbb.getIntent().getStringExtra("packageExt");
        String stringExtra5 = this.tbb.getIntent().getStringExtra("paySignature");
        String stringExtra6 = this.tbb.getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String stringExtra7 = this.tbb.getIntent().getStringExtra("ext_info");
        WalletBrandUI.b(this.tbb, this.tbb.getIntent().getStringExtra("bizUsername"));
        k bVar = new com.tencent.mm.plugin.wallet_index.c.b(WalletBrandUI.c(this.tbb), stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.d(this.tbb), this.tbb.getIntent().getIntExtra("pay_channel", 0), WalletBrandUI.e(this.tbb), stringExtra7);
        bVar.mgu = System.currentTimeMillis();
        bVar.gOs = "PayProcess";
        bVar.irz = WalletBrandUI.e(this.tbb);
        g.Dk();
        g.Di().gPJ.a(bVar, 0);
        return bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.wallet_index.c.b bVar = (com.tencent.mm.plugin.wallet_index.c.b) kVar;
            String str2 = bVar.tam;
            x.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
            PayInfo payInfo = new PayInfo();
            payInfo.fuH = str2;
            payInfo.appId = WalletBrandUI.c(this.tbb);
            payInfo.tan = bVar.tan;
            payInfo.fCV = WalletBrandUI.e(this.tbb);
            payInfo.fnL = str;
            payInfo.fCR = this.tbb.getIntent().getIntExtra("pay_channel", 16);
            payInfo.vzB = bVar.mgu;
            t.j(payInfo.fCV, str2, i2);
            h.a(this.tbb, payInfo, 1);
            return;
        }
        this.tbb.finish();
    }
}
