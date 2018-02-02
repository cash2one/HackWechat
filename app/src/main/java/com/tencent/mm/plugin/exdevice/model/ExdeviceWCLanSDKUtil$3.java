package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dl;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class ExdeviceWCLanSDKUtil$3 implements a {
    final /* synthetic */ ExdeviceWCLanSDKUtil lML;

    ExdeviceWCLanSDKUtil$3(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.lML = exdeviceWCLanSDKUtil;
    }

    public final void e(int i, Object... objArr) {
        String string;
        Throwable e;
        b dlVar;
        String str = null;
        if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
            String str2 = (String) objArr[0];
            int intValue = ((Integer) objArr[1]).intValue();
            try {
                JSONObject jSONObject = new JSONObject(new String(str2));
                string = jSONObject.getString("deviceId");
                try {
                    str = jSONObject.getString("deviceType");
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
                    switch (intValue) {
                        case 1:
                            this.lML.lMK = 2;
                            this.lML.lMl.put(string, Boolean.valueOf(true));
                            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                            break;
                        default:
                            this.lML.lMK = 0;
                            this.lML.lMl.put(string, Boolean.valueOf(false));
                            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                            break;
                    }
                    if (!this.lML.lMJ) {
                        if (this.lML.lMK == 2) {
                            this.lML.f(true, string);
                        }
                        dlVar = new dl();
                        dlVar.fsf.ffq = string;
                        dlVar.fsf.fsg = this.lML.lMK;
                        dlVar.fsf.frn = str;
                        com.tencent.mm.sdk.b.a.xef.m(dlVar);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                string = str;
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
                switch (intValue) {
                    case 1:
                        this.lML.lMK = 2;
                        this.lML.lMl.put(string, Boolean.valueOf(true));
                        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                        break;
                    default:
                        this.lML.lMK = 0;
                        this.lML.lMl.put(string, Boolean.valueOf(false));
                        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                        break;
                }
                if (!this.lML.lMJ) {
                    if (this.lML.lMK == 2) {
                        this.lML.f(true, string);
                    }
                    dlVar = new dl();
                    dlVar.fsf.ffq = string;
                    dlVar.fsf.fsg = this.lML.lMK;
                    dlVar.fsf.frn = str;
                    com.tencent.mm.sdk.b.a.xef.m(dlVar);
                }
            }
            switch (intValue) {
                case 1:
                    this.lML.lMK = 2;
                    this.lML.lMl.put(string, Boolean.valueOf(true));
                    x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                    break;
                default:
                    this.lML.lMK = 0;
                    this.lML.lMl.put(string, Boolean.valueOf(false));
                    x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                    break;
            }
            if (!this.lML.lMJ) {
                if (this.lML.lMK == 2) {
                    this.lML.f(true, string);
                }
                dlVar = new dl();
                dlVar.fsf.ffq = string;
                dlVar.fsf.fsg = this.lML.lMK;
                dlVar.fsf.frn = str;
                com.tencent.mm.sdk.b.a.xef.m(dlVar);
            }
        }
    }
}
