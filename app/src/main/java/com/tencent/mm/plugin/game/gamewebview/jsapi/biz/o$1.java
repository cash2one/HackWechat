package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class o$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ o mWJ;
    final /* synthetic */ d mWr;

    o$1(o oVar, d dVar, int i) {
        this.mWJ = oVar;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.mWJ.hashCode() & 65535)) {
            d dVar;
            int i3;
            o oVar;
            if (i2 == -1) {
                dVar = this.mWr;
                i3 = this.gOK;
                oVar = this.mWJ;
                dVar.E(i3, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("ok", null));
            } else if (i2 == 5) {
                Map hashMap = new HashMap();
                i3 = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                String ou = bh.ou(intent.getStringExtra("key_jsapi_pay_err_msg"));
                hashMap.put("err_code", Integer.valueOf(i3));
                hashMap.put("err_desc", ou);
                x.e("MicroMsg.GameJsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i3), ou});
                this.mWr.E(this.gOK, o.e("get_brand_wcpay_request:fail", hashMap));
            } else {
                dVar = this.mWr;
                i3 = this.gOK;
                oVar = this.mWJ;
                dVar.E(i3, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("get_brand_wcpay_request:cancel", null));
            }
        }
    }
}
