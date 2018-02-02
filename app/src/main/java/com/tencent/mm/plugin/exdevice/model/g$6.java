package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class g$6 implements a {
    final /* synthetic */ g lMw;

    g$6(g gVar) {
        this.lMw = gVar;
    }

    public final void e(int i, Object... objArr) {
        if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
            String str = (String) objArr[0];
            int intValue = ((Integer) objArr[1]).intValue();
            Object obj = null;
            try {
                JSONObject jSONObject = new JSONObject(new String(str));
                obj = jSONObject.getString("deviceId");
                jSONObject.getString("deviceType");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
            }
            switch (intValue) {
                case -2:
                case -1:
                case 0:
                    this.lMw.lMl.put(obj, Boolean.valueOf(false));
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = " + intValue);
                    return;
                case 1:
                    this.lMw.lMl.put(obj, Boolean.valueOf(true));
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
                    return;
                default:
                    return;
            }
        }
    }
}
