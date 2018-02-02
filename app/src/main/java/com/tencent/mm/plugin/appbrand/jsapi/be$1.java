package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

class be$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ be jem;

    be$1(be beVar, JSONObject jSONObject, j jVar, int i) {
        this.jem = beVar;
        this.jel = jSONObject;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void run() {
        float f = 0.01f;
        this.jem.jek = (float) this.jel.optDouble(DownloadSettingTable$Columns.VALUE);
        if (Float.isNaN(this.jem.jek) || this.jem.jek < 0.0f || this.jem.jek > 1.0f) {
            this.iZy.E(this.gOK, this.jem.e("fail:value invalid", null));
            x.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
            return;
        }
        MMActivity a = this.jem.a(this.iZy);
        if (a == null) {
            this.iZy.E(this.gOK, this.jem.e("fail", null));
            x.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
            return;
        }
        LayoutParams attributes = a.getWindow().getAttributes();
        if (Float.isNaN(this.jem.jej)) {
            this.jem.jej = attributes.screenBrightness;
            c.a(this.iZy.mAppId, new 1(this, attributes, a));
        }
        if (this.jem.jek >= 0.01f) {
            f = this.jem.jek;
        }
        attributes.screenBrightness = f;
        a.getWindow().setAttributes(attributes);
        this.iZy.E(this.gOK, this.jem.e("ok", null));
    }
}
