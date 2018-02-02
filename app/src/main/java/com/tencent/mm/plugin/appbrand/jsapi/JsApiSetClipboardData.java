package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;
import org.json.JSONObject;

public final class JsApiSetClipboardData extends a {
    public static final int CTRL_INDEX = 168;
    public static final String NAME = "setClipboardData";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        if (bh.ov(optString)) {
            jVar.E(i, e("fail", null));
            return;
        }
        x.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[]{optString});
        ClipboardManager clipboardManager = (ClipboardManager) jVar.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            x.i("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            jVar.E(i, e("fail", null));
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("text", optString));
        jVar.E(i, e("ok", null));
        if (!bh.ov(optString)) {
            String str = jVar.mAppId;
            p b = b(jVar);
            AppBrandMainProcessService.a(new ReportClipBoardTask(str, b != null ? b.getURL() : "", optString.getBytes(Charset.forName("UTF-8")).length));
        }
    }
}
