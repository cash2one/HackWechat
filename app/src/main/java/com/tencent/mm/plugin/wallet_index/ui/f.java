package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.d.a.a.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.p;
import java.util.ArrayList;

public final class f implements b {
    private c taB;
    private d tbl = null;
    private c tbm;

    public f(c cVar, c cVar2) {
        this.taB = cVar;
        this.tbm = cVar2;
        a.xef.b(this.tbm);
    }

    public final int bNm() {
        return 2;
    }

    public final void a(MMActivity mMActivity, d dVar) {
        x.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay");
        p.cBw();
        this.tbl = dVar;
        if (!this.taB.taO) {
            PayInfo payInfo = new PayInfo();
            payInfo.fuH = this.taB.tap.wsn;
            payInfo.partnerId = this.taB.tap.wso;
            payInfo.fKx = this.taB.tap.wsp;
            payInfo.fCV = 5;
            h.a(mMActivity, payInfo, 1);
        } else if (this.taB.tap != null) {
            g gVar = new g();
            gVar.appId = this.taB.tap.wsq.kJT;
            gVar.timeStamp = this.taB.tap.wsq.sMr;
            gVar.nonceStr = this.taB.tap.wsq.kUf;
            gVar.packageExt = this.taB.tap.wsq.wCZ;
            gVar.signType = this.taB.tap.wsq.kUd;
            gVar.fCT = this.taB.tap.wsp;
            gVar.fCV = this.taB.tap.fCV;
            h.a(mMActivity, gVar, 1, null);
        } else {
            x.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
        }
    }

    public final boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        x.d("MicroMsg.WeiXinWallet", "onPayEnd payResult : " + i2 + ", data is null : " + (intent == null));
        if (this.tbl != null) {
            com.tencent.mm.plugin.wallet_index.c.a aL;
            if (i2 == -1) {
                if (intent == null || intent.getIntExtra("key_jsapi_pay_err_code", 0) != 0) {
                    aL = com.tencent.mm.plugin.wallet_index.c.a.aL(5, "");
                } else {
                    aL = com.tencent.mm.plugin.wallet_index.c.a.aL(0, "");
                }
            } else if (i2 == 0) {
                aL = com.tencent.mm.plugin.wallet_index.c.a.aL(1, "");
            } else {
                aL = com.tencent.mm.plugin.wallet_index.c.a.aL(6, "");
            }
            x.i("MicroMsg.WeiXinWallet", "wxpay result : ");
            this.tbl.a(aL, new com.tencent.mm.plugin.wallet_index.b.a.c(this.taB.lyH, this.taB.taG, this.taB.taj, this.taB.tak));
            this.tbl = null;
        }
        return true;
    }

    public final void g(MMActivity mMActivity) {
        a.xef.c(this.tbm);
    }

    public final void c(MMActivity mMActivity, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", 0);
        intent.putExtra("key_err_msg", "");
        mMActivity.setResult(-1, intent);
        t.finish();
    }

    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        if (dVar != null) {
            dVar.a(com.tencent.mm.plugin.wallet_index.c.a.aL(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.taB.lyH, this.taB.taG, this.taB.taj, this.taB.tak));
        }
    }
}
