package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aq extends a {
    public static final int CTRL_INDEX = 434;
    public static final String NAME = "openQRCode";
    private static volatile boolean jdy = false;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jdy) {
            jVar.E(i, e("cancel", null));
            return;
        }
        jdy = true;
        x.i("MicroMsg.JsApiOpenQRCode", "openQRCode data::%s", new Object[]{jSONObject});
        Context a = a(jVar);
        if (a == null) {
            jdy = false;
            x.e("MicroMsg.JsApiOpenQRCode", "pageContext is null, err");
            jVar.E(i, e("fail:context is err", null));
            return;
        }
        boolean z;
        boolean z2;
        int i2;
        jSONObject.optString("desc");
        int i3 = bh.getInt(jSONObject.optString("needResult"), 1);
        String optString = jSONObject.optString("scanType");
        if (bh.ov(optString)) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (optString != null) {
            try {
                JSONArray jSONArray = new JSONArray(optString);
                int i4 = 0;
                while (i4 < jSONArray.length()) {
                    boolean z3;
                    optString = (String) jSONArray.get(i4);
                    if (optString.equalsIgnoreCase("qrCode")) {
                        z3 = z;
                        z = true;
                    } else if (optString.equalsIgnoreCase("barCode")) {
                        z3 = true;
                        z = z2;
                    } else {
                        z3 = z;
                        z = z2;
                    }
                    i4++;
                    z2 = z;
                    z = z3;
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiOpenQRCode", "doScanQRCode, ex in scanType");
            }
        }
        if (z2 && !r2) {
            i2 = 8;
        } else if (z2 || !r2) {
            i2 = 1;
        } else {
            i2 = 4;
        }
        a.jwN = new 1(this, jVar, i);
        if (i3 == 0) {
            x.i("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivity");
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i2);
            d.a(a, "scanner", ".ui.SingleTopScanUI", intent, false);
            jdy = false;
            jVar.E(i, e("ok", null));
        } else if (i3 == 1) {
            x.d("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivityForResult requestCode:%d", new Object[]{Integer.valueOf(hashCode())});
            Intent intent2 = new Intent();
            intent2.putExtra("BaseScanUI_select_scan_mode", i2);
            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent2.putExtra("key_is_finish_on_scanned", true);
            intent2.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            d.a(a, "scanner", ".ui.SingleTopScanUI", intent2, hashCode() & 65535, false);
        } else {
            x.e("MicroMsg.JsApiOpenQRCode", "needResult is err");
            jVar.E(i, e("fail:invalid data", null));
        }
    }
}
