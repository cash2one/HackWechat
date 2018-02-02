package com.tencent.mm.plugin.wallet_index.ui;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;

class WalletBrandUI$c implements WalletBrandUI$b {
    final /* synthetic */ WalletBrandUI tbb;

    WalletBrandUI$c(WalletBrandUI walletBrandUI) {
        this.tbb = walletBrandUI;
    }

    public final k bNp() {
        WalletBrandUI.a(this.tbb, this.tbb.getIntent().getStringExtra("appId"));
        String stringExtra = this.tbb.getIntent().getStringExtra("signtype");
        String stringExtra2 = this.tbb.getIntent().getStringExtra("nonceStr");
        String stringExtra3 = this.tbb.getIntent().getStringExtra("timeStamp");
        String stringExtra4 = this.tbb.getIntent().getStringExtra("packageExt");
        String stringExtra5 = this.tbb.getIntent().getStringExtra("paySignature");
        String stringExtra6 = this.tbb.getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        WalletBrandUI.b(this.tbb, this.tbb.getIntent().getStringExtra("bizUsername"));
        k aVar = new a(WalletBrandUI.c(this.tbb), stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.d(this.tbb), this.tbb.getIntent().getIntExtra("pay_channel", 0));
        g.Dk();
        g.Di().gPJ.a(aVar, 0);
        return aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a aVar = (a) kVar;
        String str2 = aVar.tam;
        x.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
        PayInfo payInfo = new PayInfo();
        payInfo.fuH = str2;
        payInfo.appId = WalletBrandUI.c(this.tbb);
        payInfo.tan = aVar.tan;
        payInfo.fCV = WalletBrandUI.e(this.tbb);
        payInfo.fnL = str;
        payInfo.fCR = this.tbb.getIntent().getIntExtra("pay_channel", 0);
        h.a(this.tbb, payInfo, 1);
    }

    public final int bNo() {
        return 1521;
    }
}
