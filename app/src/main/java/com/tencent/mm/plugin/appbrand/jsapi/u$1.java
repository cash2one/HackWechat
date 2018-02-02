package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class u$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ u jcU;

    u$1(u uVar, j jVar, int i) {
        this.jcU = uVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.jcU.hashCode() & 65535)) {
            if (i2 == -1 && intent != null) {
                Map hashMap = new HashMap();
                String az = bh.az(intent.getStringExtra("choose_invoice_title_info"), "");
                x.i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : " + az);
                hashMap.put("invoiceTitleInfo", az);
                this.iZy.E(this.gOK, this.jcU.e("ok", hashMap));
            } else if (i2 == 0) {
                this.iZy.E(this.gOK, this.jcU.e("cancel", null));
            } else {
                this.iZy.E(this.gOK, this.jcU.e("fail", null));
            }
        }
    }
}
