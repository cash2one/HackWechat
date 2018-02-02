package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s extends a {
    public static final int CTRL_BYTE = 16;
    public static final String NAME = "getNetworkType";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetNetworkType", "invoke");
        Context context = dVar.getContext();
        if (context == null) {
            x.e("MicroMsg.GameJsApiGetNetworkType", "context is null");
        } else if (an.isConnected(context)) {
            x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, type = " + an.getNetType(context));
            Map hashMap = new HashMap();
            if (an.isWifi(context)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, wifi");
                dVar.E(i, a.e("network_type:wifi", null));
                return;
            }
            if (an.is2G(context)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
            } else if (an.is3G(context)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
            } else if (an.is4G(context)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
            }
            dVar.E(i, e("network_type:wwan", hashMap));
        } else {
            x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, not connected");
            dVar.E(i, a.e("network_type:fail", null));
        }
    }
}
