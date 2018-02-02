package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.ee;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class e$15 extends c<ee> {
    final /* synthetic */ e lLO;

    e$15(e eVar) {
        this.lLO = eVar;
        this.xen = ee.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ee eeVar = (ee) bVar;
        if (eeVar == null || !(eeVar instanceof ee)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTBindDeviceEvent");
            return false;
        }
        eeVar = eeVar;
        if (ad.aEk().cJ(com.tencent.mm.plugin.exdevice.j.b.zu(eeVar.fsO.mac)) != null) {
            x.d("MicroMsg.exdevice.ExdeviceEventManager", "device(" + eeVar.fsO.mac + ") has been binded");
            eeVar.fsP.frp = true;
        } else {
            boolean z;
            String str = eeVar.fsO.mac;
            String str2 = eeVar.fsO.fsQ;
            long j = eeVar.fsO.fsR;
            if (bh.ov(str)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                z = false;
            } else {
                String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
                String str4 = "handleExDeviceSimpleBTBindDevice. mac = %s, broadcastName = %s, profileType = %d";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = str2 == null ? "null" : str2;
                objArr[2] = Long.valueOf(j);
                x.d(str3, str4, objArr);
                int Km = ar.CG().Km();
                if (Km == 4 || Km == 6) {
                    if (ar.CG().a(new m(com.tencent.mm.plugin.exdevice.j.b.zu(str), str2, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, j), 0)) {
                        z = true;
                    } else {
                        x.e("MicroMsg.exdevice.ExdeviceEventManager", "do NetSceneBindUnauthDevice fail");
                        z = false;
                    }
                } else {
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, current state is %d", new Object[]{Integer.valueOf(Km)});
                    z = false;
                }
            }
            if (z) {
                eeVar.fsP.frp = true;
            } else {
                eeVar.fsP.frp = false;
            }
        }
        return true;
    }
}
