package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.t;

class WalletBrandUI$d implements WalletBrandUI$b {
    final /* synthetic */ WalletBrandUI tbb;

    WalletBrandUI$d(WalletBrandUI walletBrandUI) {
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
        k cVar = new c(WalletBrandUI.c(this.tbb), stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.d(this.tbb), this.tbb.getIntent().getIntExtra("pay_channel", 0), WalletBrandUI.e(this.tbb));
        cVar.mgu = System.currentTimeMillis();
        cVar.gOs = "PayProcess";
        cVar.irz = WalletBrandUI.e(this.tbb);
        g.Dk();
        g.Di().gPJ.a(cVar, 0);
        return cVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            c cVar = (c) kVar;
            String str2 = cVar.tam;
            x.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
            PayInfo payInfo = new PayInfo();
            payInfo.fuH = str2;
            payInfo.appId = WalletBrandUI.c(this.tbb);
            payInfo.tan = cVar.tan;
            payInfo.fCV = WalletBrandUI.e(this.tbb);
            payInfo.fnL = str;
            payInfo.fCR = this.tbb.getIntent().getIntExtra("pay_channel", 0);
            payInfo.vzB = cVar.mgu;
            t.j(payInfo.fCV, str2, i2);
            h.a(this.tbb, payInfo, 1);
            return;
        }
        t.j(WalletBrandUI.e(this.tbb), "", i2);
        Intent intent = new Intent();
        if (i != 0) {
            i2 = -1;
        }
        intent.putExtra("key_jsapi_pay_err_code", i2);
        String str3 = "key_jsapi_pay_err_msg";
        if (bh.ov(str)) {
            str = this.tbb.getString(i.uTb);
        }
        intent.putExtra(str3, str);
        this.tbb.setResult(5, intent);
        this.tbb.finish();
    }

    public final int bNo() {
        return 398;
    }
}
