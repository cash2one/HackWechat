package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dn;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class ExdeviceWCLanSDKUtil$2 implements a {
    final /* synthetic */ ExdeviceWCLanSDKUtil lML;

    ExdeviceWCLanSDKUtil$2(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.lML = exdeviceWCLanSDKUtil;
    }

    public final void e(int i, Object... objArr) {
        String string;
        Exception e;
        String str = null;
        if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(new String((byte[]) objArr[0])).getJSONObject("deviceInfo");
                try {
                    string = jSONObject.getString("deviceType");
                } catch (Exception e2) {
                    e = e2;
                    string = str;
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                    if (string != null) {
                    }
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                    return;
                }
                try {
                    str = jSONObject.getString("deviceId");
                } catch (Exception e3) {
                    e = e3;
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                    if (string != null) {
                    }
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                    return;
                }
            } catch (Exception e4) {
                e = e4;
                jSONObject = str;
                string = str;
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                if (string != null) {
                }
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                return;
            }
            if (string != null || str == null) {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                return;
            }
            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get device deviceType =" + string + ",deviceId = " + str);
            if (ad.aEk().zg(str) == null) {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "hdInfo null, %s", new Object[]{str});
                return;
            }
            this.lML.lMj.put(str, jSONObject.toString().getBytes());
            b dnVar = new dn();
            dnVar.fsi.ffq = str;
            if (this.lML.lMG.containsKey(str)) {
                String str2 = (String) this.lML.lMG.get(str);
                if (!bh.ov(str2)) {
                    dnVar.fsi.fsj = str2.getBytes();
                }
                this.lML.lMG.remove(str);
            }
            dnVar.fsi.aow = false;
            com.tencent.mm.sdk.b.a.xef.m(dnVar);
        }
    }
}
