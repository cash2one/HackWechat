package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class o$1 implements a {
    final /* synthetic */ j iZy;
    final /* synthetic */ o jcu;

    o$1(o oVar, j jVar) {
        this.jcu = oVar;
        this.iZy = jVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            if (intent == null) {
                this.iZy.E(this.jcu.jcs, this.jcu.e("fail", null));
                x.e("MicroMsg.JsApiAddCard", "location result is empty!");
                return;
            }
            Object jSONArray;
            Map hashMap = new HashMap();
            x.d("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback cardList:%s", new Object[]{intent.getStringExtra("card_list")});
            try {
                jSONArray = new JSONArray(intent.getStringExtra("card_list"));
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiAddCard", "parse fail result:%s", new Object[]{bh.i(e)});
                jSONArray = null;
            }
            if (jSONArray != null) {
                hashMap.put("cardList", jSONArray);
                this.iZy.E(this.jcu.jcs, this.jcu.e("ok", hashMap));
                return;
            }
            this.iZy.E(this.jcu.jcs, this.jcu.e("fail: cardList is empty", hashMap));
            x.e("MicroMsg.JsApiAddCard", "add card result is fail! cardList is empty");
        } else if (i2 == 0) {
            this.iZy.E(this.jcu.jcs, this.jcu.e("cancel", null));
            x.e("MicroMsg.JsApiAddCard", "add card result is cancel!");
        } else {
            int intExtra;
            if (intent != null) {
                intExtra = intent.getIntExtra("result_code", 2);
            } else {
                intExtra = 2;
            }
            x.i("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback ret_code:%d", new Object[]{Integer.valueOf(intExtra)});
            if (intExtra == 2) {
                this.iZy.E(this.jcu.jcs, this.jcu.e("fail", null));
            } else {
                this.iZy.E(this.jcu.jcs, this.jcu.e("cancel", null));
            }
        }
    }
}
