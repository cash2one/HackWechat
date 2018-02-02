package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y extends a {
    public static final int CTRL_INDEX = 169;
    public static final String NAME = "getClipboardData";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        ClipboardManager clipboardManager = (ClipboardManager) jVar.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            x.i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            jVar.E(i, e("fail", null));
            return;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        Object obj = "";
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getText() != null) {
                obj = itemAt.getText().toString();
            }
        }
        x.d("MicroMsg.JsApiGetClipboardData", "stevyang retData %s", new Object[]{obj});
        Map hashMap = new HashMap();
        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, obj);
        jVar.E(i, e("ok", hashMap));
    }
}
