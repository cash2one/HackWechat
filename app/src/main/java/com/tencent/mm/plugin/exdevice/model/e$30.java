package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dv;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.5;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class e$30 extends c<dv> {
    final /* synthetic */ e lLO;

    e$30(e eVar) {
        this.lLO = eVar;
        this.xen = dv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dv dvVar = (dv) bVar;
        e eVar = this.lLO;
        dvVar = dvVar;
        if (eVar.lLJ == null) {
            eVar.lLJ = new ExdeviceWCLanSDKUtil();
        }
        ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil = eVar.lLJ;
        if (dvVar.fst.fro) {
            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
            j.aEb().a(14, exdeviceWCLanSDKUtil.lMm);
            j.aEb().a(10, exdeviceWCLanSDKUtil.lME);
            j.aEb().a(13, exdeviceWCLanSDKUtil.lMo);
            j.aEb().a(16, exdeviceWCLanSDKUtil.lMF);
        } else {
            ar.Dm().F(new 5(exdeviceWCLanSDKUtil));
            x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "unregisterReceiver...");
            if (exdeviceWCLanSDKUtil.jhN != null) {
                exdeviceWCLanSDKUtil.mContext.unregisterReceiver(exdeviceWCLanSDKUtil.jhN);
                exdeviceWCLanSDKUtil.jhN = null;
            }
            j.aEb().b(14, exdeviceWCLanSDKUtil.lMm);
            j.aEb().b(10, exdeviceWCLanSDKUtil.lME);
            j.aEb().b(13, exdeviceWCLanSDKUtil.lMo);
            j.aEb().b(16, exdeviceWCLanSDKUtil.lMF);
        }
        return true;
    }
}
