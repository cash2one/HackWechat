package com.tencent.mm.plugin.exdevice.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.plugin.exdevice.b.k.b;
import com.tencent.mm.plugin.exdevice.b.k.c;
import com.tencent.mm.plugin.exdevice.b.k.d;
import com.tencent.mm.plugin.exdevice.b.k.e;
import com.tencent.mm.plugin.exdevice.b.k.f;
import com.tencent.mm.plugin.exdevice.e.k;
import com.tencent.mm.plugin.exdevice.i.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import junit.framework.Assert;

class k$a extends af {
    final /* synthetic */ k lKj;

    public k$a(k kVar, Looper looper) {
        this.lKj = kVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[]{Integer.valueOf(message.what)});
        e eVar;
        switch (message.what) {
            case 0:
                long longValue = ((Long) message.obj).longValue();
                e eVar2 = (e) k.c(this.lKj).get(Long.valueOf(longValue));
                if (eVar2 == null) {
                    x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[]{Long.valueOf(longValue)});
                    return;
                }
                eVar2.aDM().b(-1, "", null);
                u.aEM().a(new h(eVar2.aDM()));
                k.c(this.lKj).remove(Long.valueOf(longValue));
                return;
            case 1:
                f fVar = (f) message.obj;
                if (!u.aEL().cD(fVar.kAq)) {
                    x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[]{Long.valueOf(fVar.kAq)});
                    fVar.b(-2, "", new byte[0]);
                    u.aEM().a(new h(fVar));
                    return;
                } else if (-5 == message.arg1 || -3 == message.arg1 || -4 == message.arg1) {
                    x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(message.arg1)});
                    fVar.b(-1, "", new byte[0]);
                    u.aEM().a(new h(fVar));
                    return;
                } else {
                    bq zf = ad.aEk().zf(fVar.kAq);
                    if (zf == null) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                        return;
                    }
                    if (System.currentTimeMillis() / 1000 < ((long) zf.gfK)) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
                        fVar.b(-5, "Device Is Block", null);
                        u.aEM().a(new h(fVar));
                        return;
                    }
                    long aDO = f.aDO();
                    k kVar = (k) fVar.aDJ();
                    if (kVar == null) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
                        fVar.b(-4, "Decode failed", null);
                        u.aEM().a(new h(fVar));
                        return;
                    }
                    Integer num = (Integer) k.b(this.lKj).get(zf.field_deviceID);
                    if (num == null) {
                        num = Integer.valueOf(0);
                    }
                    x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[]{num});
                    Object dVar;
                    e eVar3;
                    if (num.intValue() != 0) {
                        if ((num.intValue() & 1) != 0) {
                            ad.aEv();
                            com.tencent.mm.plugin.exdevice.model.e.c(zf.field_deviceID, zf.field_brandName, kVar.ksB.toByteArray());
                        }
                        if ((num.intValue() & 2) != 0) {
                            ar.CG().a(new w(fVar.kAq, zf.field_deviceType, zf.field_deviceID, aDO, bh.Wp(), kVar.ksB.toByteArray(), kVar.ktN), 0);
                            dVar = new d(this.lKj, aDO);
                            k.a(this.lKj).postDelayed(dVar, 30000);
                            eVar3 = new e((byte) 0);
                            eVar3.a(fVar);
                            eVar3.a(dVar);
                            eVar3.lKp = 0;
                            k.c(this.lKj).put(Long.valueOf(aDO), eVar3);
                            return;
                        }
                        return;
                    } else if (kVar.ktN == 10001) {
                        ad.aEv();
                        com.tencent.mm.plugin.exdevice.model.e.c(zf.field_deviceID, zf.field_brandName, kVar.ksB.toByteArray());
                        return;
                    } else {
                        ar.CG().a(new w(fVar.kAq, zf.field_deviceType, zf.field_deviceID, aDO, bh.Wp(), kVar.ksB.toByteArray(), kVar.ktN), 0);
                        dVar = new d(this.lKj, aDO);
                        k.a(this.lKj).postDelayed(dVar, 30000);
                        eVar3 = new e((byte) 0);
                        eVar3.a(fVar);
                        eVar3.a(dVar);
                        eVar3.lKp = 0;
                        k.c(this.lKj).put(Long.valueOf(aDO), eVar3);
                        return;
                    }
                }
            case 2:
                b bVar = (b) message.obj;
                if (bVar.lKk != 0 || bVar.lJY != 0) {
                    w wVar = (w) bVar.lKl;
                    Assert.assertNotNull(wVar.lMW);
                    long j = ((bft) wVar.lMW.hmg.hmo).wKD.wrb;
                    eVar = (e) k.c(this.lKj).get(Long.valueOf(j));
                    if (eVar == null) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[]{Long.valueOf(j)});
                        return;
                    }
                    int i;
                    f aDM = eVar.aDM();
                    switch (bVar.lJY) {
                        case -417:
                            i = -5;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    aDM.b(i, bVar.jcD, null);
                    u.aEM().a(new h(eVar.aDM()));
                    k.a(this.lKj).removeCallbacks(eVar.aDN());
                    k.c(this.lKj).remove(Long.valueOf(j));
                    return;
                }
                return;
            case 3:
                c cVar = (c) message.obj;
                eVar = (e) k.c(this.lKj).get(Long.valueOf(cVar.mSessionId));
                if (eVar == null) {
                    x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[]{Long.valueOf(cVar.mSessionId)});
                    return;
                }
                eVar.lKn.b(0, "", cVar.kwG);
                u.aEM().a(new h(eVar.aDM()));
                k.a(this.lKj).removeCallbacks(eVar.aDN());
                k.c(this.lKj).remove(Long.valueOf(cVar.mSessionId));
                return;
            default:
                x.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[]{Integer.valueOf(message.what)});
                return;
        }
    }
}
