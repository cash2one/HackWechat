package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dn;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class ExdeviceWCLanSDKUtil$1 implements a {
    final /* synthetic */ ExdeviceWCLanSDKUtil lML;

    ExdeviceWCLanSDKUtil$1(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.lML = exdeviceWCLanSDKUtil;
    }

    public final void e(int i, Object... objArr) {
        String string;
        Throwable e;
        String str = null;
        if (i == 10 && objArr != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                string = jSONObject2.getString("deviceType");
                try {
                    str = jSONObject2.getString("deviceId");
                    if (!jSONObject.isNull("manufacturerData")) {
                        this.lML.lMG.put(str, jSONObject.getString("manufacturerData"));
                    }
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
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                    if (string != null) {
                    }
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                }
            } catch (Exception e3) {
                e = e3;
                string = null;
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                if (string != null) {
                }
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
            }
            if (string != null || r1 == null) {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
            }
        }
    }
}
