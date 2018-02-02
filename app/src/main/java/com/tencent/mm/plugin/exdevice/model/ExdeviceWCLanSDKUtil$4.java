package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class ExdeviceWCLanSDKUtil$4 implements j$a {
    final /* synthetic */ ExdeviceWCLanSDKUtil lML;

    ExdeviceWCLanSDKUtil$4(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.lML = exdeviceWCLanSDKUtil;
    }

    public final void e(int i, Object... objArr) {
        Throwable th;
        if (i == 16 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof byte[])) {
            String string;
            String str;
            b dmVar;
            byte[] bArr = (byte[]) objArr[1];
            try {
                JSONObject jSONObject = new JSONObject(new String((String) objArr[0]));
                String string2 = jSONObject.getString("deviceType");
                try {
                    string = jSONObject.getString("deviceId");
                    str = string2;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    string = string2;
                    th = th2;
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", th, "", new Object[0]);
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                    str = string;
                    string = null;
                    x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                    dmVar = new dm();
                    dmVar.fsh.ffq = string;
                    dmVar.fsh.data = bArr;
                    dmVar.fsh.frn = str;
                    a.xef.m(dmVar);
                }
            } catch (Throwable e2) {
                th = e2;
                string = null;
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", th, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                str = string;
                string = null;
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                dmVar = new dm();
                dmVar.fsh.ffq = string;
                dmVar.fsh.data = bArr;
                dmVar.fsh.frn = str;
                a.xef.m(dmVar);
            }
            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
            dmVar = new dm();
            dmVar.fsh.ffq = string;
            dmVar.fsh.data = bArr;
            dmVar.fsh.frn = str;
            a.xef.m(dmVar);
        }
    }
}
