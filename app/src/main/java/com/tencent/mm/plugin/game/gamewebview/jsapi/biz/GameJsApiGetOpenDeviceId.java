package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiGetOpenDeviceId extends a {
    public static final int CTRL_BYTE = 227;
    public static final String NAME = "getOpenDeviceId";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetOpenDeviceId", "invoke");
        GWMainProcessTask getDeviceIdTask = new GetDeviceIdTask();
        GameWebViewMainProcessService.b(getDeviceIdTask);
        String aPl = dVar.aPl();
        if (bh.ov(getDeviceIdTask.ffq) || bh.ov(getDeviceIdTask.mWM) || bh.ov(aPl)) {
            dVar.E(i, a.e("getOpenDeviceId:fail", null));
            return;
        }
        String UZ = ab.UZ(ab.UZ(aPl + getDeviceIdTask.ffq));
        String UZ2 = ab.UZ(ab.UZ(aPl + getDeviceIdTask.mWM));
        Map hashMap = new HashMap();
        hashMap.put("deviceid", UZ);
        hashMap.put("newDeviceId", UZ2);
        dVar.E(i, e("getOpenDeviceId:ok", hashMap));
    }
}
