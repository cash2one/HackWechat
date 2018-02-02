package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.k;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 347;
    public static final String NAME = "operateSocketTask";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiOperateSocketTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("socketTaskId");
        if (bh.ov(optString)) {
            x.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
            jVar.E(i, e("fail:taskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bh.ov(optString2)) {
            x.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
            jVar.E(i, e("fail:operationType is null or nil", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.j.j tB = k.aiE().tB(jVar.mAppId);
        if (tB == null) {
            jVar.E(i, e("fail:no task", null));
            x.w("MicroMsg.JsApiOperateSocketTask", "client is null");
            return;
        }
        com.tencent.mm.plugin.appbrand.r.a.a tA = tB.tA(optString);
        if (tA == null) {
            jVar.E(i, e("fail:taskID not exist", null));
            x.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
        } else if (optString2.equals("close")) {
            int optInt = jSONObject.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, 1000);
            if (optInt == 1000 || (optInt >= 3000 && optInt < 5000)) {
                String optString3 = jSONObject.optString("reason", "");
                if (tA != null) {
                    try {
                        x.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                        if (tA.jTw != null) {
                            tA.P(optInt, optString3);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + e.toString());
                    }
                    tB.b(tA);
                }
                jVar.E(i, e("ok", null));
                x.d("MicroMsg.JsApiOperateSocketTask", "closeSocket code %d, reason %s", new Object[]{Integer.valueOf(optInt), optString3});
                return;
            }
            jVar.E(i, e("fail:The code must be either 1000, or between 3000 and 4999", null));
        } else if (optString2.equals("send")) {
            boolean isOpen;
            if (tA != null) {
                isOpen = tA.jTr.isOpen();
            } else {
                isOpen = false;
            }
            if (isOpen) {
                Object opt = jSONObject.opt(SlookAirButtonFrequentContactAdapter.DATA);
                if (opt != null) {
                    if (opt instanceof ByteBuffer) {
                        x.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[]{opt});
                        tA.p((ByteBuffer) opt);
                    } else if (opt instanceof String) {
                        x.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
                        optString2 = (String) opt;
                        if (tA != null) {
                            tA.uI(optString2);
                        }
                    } else {
                        x.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
                        jVar.E(i, e("fail:unknown data", null));
                        return;
                    }
                    jVar.E(i, e("ok", null));
                    return;
                }
                jVar.E(i, e("fail:message is null or nil", null));
                x.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[]{opt});
                return;
            }
            jVar.E(i, e("fail", null));
            x.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[]{optString});
        } else {
            jVar.E(i, e("fail:unknown operationType", null));
        }
    }
}
