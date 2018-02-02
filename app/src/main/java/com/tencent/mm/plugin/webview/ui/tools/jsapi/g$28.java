package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.modeltools.d$a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class g$28 implements d$a {
    final /* synthetic */ String tIE;
    final /* synthetic */ i tIF;
    final /* synthetic */ g tIj;

    g$28(g gVar, String str, i iVar) {
        this.tIj = gVar;
        this.tIE = str;
        this.tIF = iVar;
    }

    public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
        if (!bh.ou(str).equalsIgnoreCase(this.tIE)) {
            x.i("MicroMsg.MsgHandler", "msg.params.cardType = %s, callback type = %s, mismatch!!!", this.tIE, str);
        } else if (jSONObject == null) {
            x.e("MicroMsg.MsgHandler", "doScanLicence, type = %s, callback onSuccess but result is null", str);
            KZ(str);
        } else {
            Map hashMap = new HashMap(2);
            hashMap.put("cardType", str);
            hashMap.put("cardInfo", jSONObject);
            g.a(this.tIj, this.tIF, "scanLicence:ok", hashMap);
        }
    }

    public final void OH(String str) {
        if (bh.ou(str).equals(this.tIE)) {
            Map hashMap = new HashMap(1);
            hashMap.put("cardType", str);
            g.a(this.tIj, this.tIF, "scanLicence:cancel", hashMap);
        }
    }

    public final void KZ(String str) {
        if (bh.ou(str).equals(this.tIE)) {
            Map hashMap = new HashMap(1);
            hashMap.put("cardType", str);
            g.a(this.tIj, this.tIF, "scanLicence:fail", hashMap);
        }
    }
}
