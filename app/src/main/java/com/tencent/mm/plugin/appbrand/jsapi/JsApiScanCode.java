package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class JsApiScanCode extends a {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";
    private static volatile boolean jdy = false;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jdy) {
            jVar.E(i, e("cancel", null));
            return;
        }
        jdy = true;
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        a.jwN = new 1(this, jVar, i);
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("key_is_finish_on_scanned", true);
        intent.putExtra("key_is_hide_right_btn", jSONObject.optBoolean("onlyFromCamera", false));
        d.a(a, "scanner", ".ui.SingleTopScanUI", intent, hashCode() & 65535, false);
    }
}
