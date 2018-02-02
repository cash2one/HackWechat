package com.tencent.mm.plugin.exdevice.model;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.ary;
import com.tencent.mm.protocal.c.zu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class i$2 implements Runnable {
    final /* synthetic */ i lMS;
    final /* synthetic */ zu lMT;

    i$2(i iVar, zu zuVar) {
        this.lMS = iVar;
        this.lMT = zuVar;
    }

    public final void run() {
        i.ct(bh.Wp());
        c aEk = ad.aEk();
        List<b> linkedList = new LinkedList();
        Cursor Tj = aEk.Tj();
        Iterator it;
        ajr com_tencent_mm_protocal_c_ajr;
        boolean z;
        Iterator it2;
        ary com_tencent_mm_protocal_c_ary;
        ajs com_tencent_mm_protocal_c_ajs;
        ajr com_tencent_mm_protocal_c_ajr2;
        bq zg;
        com.tencent.mm.sdk.e.c bVar;
        if (Tj == null || !Tj.moveToFirst()) {
            if (Tj != null) {
                Tj.close();
            }
            for (b bVar2 : linkedList) {
                it = this.lMT.wjp.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_ajr = ((ary) it.next()).vLR;
                    if (!bVar2.field_deviceType.equals(com_tencent_mm_protocal_c_ajr.vJA) && bVar2.field_deviceID.equals(com_tencent_mm_protocal_c_ajr.ksX)) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (!z) {
                    x.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[]{bVar2.field_deviceID, bVar2.field_deviceType});
                    i.d(bVar2);
                    ad.aEk().cq(bVar2.field_deviceID, bVar2.field_deviceType);
                    ad.aEv();
                    e.ad(bVar2.field_deviceID, false);
                }
            }
            it2 = this.lMT.wjp.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_ary = (ary) it2.next();
                com_tencent_mm_protocal_c_ajs = com_tencent_mm_protocal_c_ary.vLS;
                com_tencent_mm_protocal_c_ajr2 = com_tencent_mm_protocal_c_ary.vLR;
                if (!(com_tencent_mm_protocal_c_ajr2 == null || com_tencent_mm_protocal_c_ajs == null || bh.ov(com_tencent_mm_protocal_c_ajr2.ksX))) {
                    x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[]{com_tencent_mm_protocal_c_ajr2.ksX, com_tencent_mm_protocal_c_ajr2.vJA, Integer.valueOf(com_tencent_mm_protocal_c_ary.wzG)});
                    zg = ad.aEk().zg(com_tencent_mm_protocal_c_ajr2.ksX);
                    if (2 != com_tencent_mm_protocal_c_ary.wzG) {
                        x.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[]{com_tencent_mm_protocal_c_ajr2.ksX, com_tencent_mm_protocal_c_ajs.vLs, com_tencent_mm_protocal_c_ajs.wqJ});
                        if (zg != null) {
                            i.d(zg);
                            ad.aEk().cq(zg.field_deviceID, zg.field_deviceType);
                            ad.aEv();
                            e.ad(zg.field_deviceID, false);
                        }
                    } else {
                        bVar = new b();
                        bVar.field_deviceID = com_tencent_mm_protocal_c_ajr2.ksX;
                        bVar.field_deviceType = com_tencent_mm_protocal_c_ajr2.vJA;
                        bVar.field_connProto = com_tencent_mm_protocal_c_ajs.wqK;
                        bVar.field_connStrategy = com_tencent_mm_protocal_c_ajs.wqL;
                        bVar.field_closeStrategy = com_tencent_mm_protocal_c_ajs.wqM;
                        if (!(com_tencent_mm_protocal_c_ajs.gfR != 2 || zg == null || zg.gfN == null)) {
                            com_tencent_mm_protocal_c_ajs.hvy = zg.gfN;
                        }
                        bVar.cZ(com_tencent_mm_protocal_c_ajs.hvy);
                        bVar.dN(com_tencent_mm_protocal_c_ajs.wqS);
                        bVar.dM(com_tencent_mm_protocal_c_ajs.wqR);
                        bVar.dL(com_tencent_mm_protocal_c_ajs.wqQ);
                        bVar.eY(com_tencent_mm_protocal_c_ajs.wqT);
                        bVar.dJ(com_tencent_mm_protocal_c_ajs.nfT);
                        bVar.dK(com_tencent_mm_protocal_c_ajs.nfg);
                        bVar.eZ(com_tencent_mm_protocal_c_ajs.gfR);
                        bVar.an(com_tencent_mm_protocal_c_ajs.gfS);
                        bVar.dO(com_tencent_mm_protocal_c_ajs.gfT);
                        bVar.dP(com_tencent_mm_protocal_c_ajs.gfU);
                        bVar.dQ(com_tencent_mm_protocal_c_ajs.gfV);
                        bVar.dR(com_tencent_mm_protocal_c_ajs.gfW);
                        bVar.field_url = "";
                        bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.zu(com.tencent.mm.plugin.exdevice.j.b.zv(com_tencent_mm_protocal_c_ajs.vLs));
                        bVar.field_md5Str = g.s(new String(com_tencent_mm_protocal_c_ajr2.vJA + com_tencent_mm_protocal_c_ajr2.ksX).getBytes());
                        bVar.field_authKey = com_tencent_mm_protocal_c_ajs.vJh;
                        bVar.field_brandName = com_tencent_mm_protocal_c_ajs.wqJ;
                        if (bVar.field_mac == 0) {
                            bVar.field_mac = System.currentTimeMillis();
                        }
                        if (zg == null) {
                            z = ad.aEk().b(bVar);
                            if (z) {
                                ad.aEv();
                                e.ad(bVar.field_deviceID, true);
                            }
                        } else {
                            z = ad.aEk().e(bVar) == 0;
                        }
                        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[]{Boolean.valueOf(z), bVar.field_brandName, bVar.field_deviceID, com_tencent_mm_protocal_c_ajr2.vJA, bVar.field_connProto, Integer.valueOf(bVar.field_connStrategy), Integer.valueOf(bVar.field_closeStrategy), Long.valueOf(bVar.field_mac)});
                    }
                }
            }
        }
        do {
            b bVar3 = new b();
            bVar3.b(Tj);
            linkedList.add(bVar3);
        } while (Tj.moveToNext());
        if (Tj != null) {
            Tj.close();
        }
        for (b bVar22 : linkedList) {
            it = this.lMT.wjp.iterator();
            while (it.hasNext()) {
                com_tencent_mm_protocal_c_ajr = ((ary) it.next()).vLR;
                if (!bVar22.field_deviceType.equals(com_tencent_mm_protocal_c_ajr.vJA)) {
                }
            }
            z = false;
            if (!z) {
                x.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[]{bVar22.field_deviceID, bVar22.field_deviceType});
                i.d(bVar22);
                ad.aEk().cq(bVar22.field_deviceID, bVar22.field_deviceType);
                ad.aEv();
                e.ad(bVar22.field_deviceID, false);
            }
        }
        it2 = this.lMT.wjp.iterator();
        while (it2.hasNext()) {
            com_tencent_mm_protocal_c_ary = (ary) it2.next();
            com_tencent_mm_protocal_c_ajs = com_tencent_mm_protocal_c_ary.vLS;
            com_tencent_mm_protocal_c_ajr2 = com_tencent_mm_protocal_c_ary.vLR;
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[]{com_tencent_mm_protocal_c_ajr2.ksX, com_tencent_mm_protocal_c_ajr2.vJA, Integer.valueOf(com_tencent_mm_protocal_c_ary.wzG)});
            zg = ad.aEk().zg(com_tencent_mm_protocal_c_ajr2.ksX);
            if (2 != com_tencent_mm_protocal_c_ary.wzG) {
                bVar = new b();
                bVar.field_deviceID = com_tencent_mm_protocal_c_ajr2.ksX;
                bVar.field_deviceType = com_tencent_mm_protocal_c_ajr2.vJA;
                bVar.field_connProto = com_tencent_mm_protocal_c_ajs.wqK;
                bVar.field_connStrategy = com_tencent_mm_protocal_c_ajs.wqL;
                bVar.field_closeStrategy = com_tencent_mm_protocal_c_ajs.wqM;
                com_tencent_mm_protocal_c_ajs.hvy = zg.gfN;
                bVar.cZ(com_tencent_mm_protocal_c_ajs.hvy);
                bVar.dN(com_tencent_mm_protocal_c_ajs.wqS);
                bVar.dM(com_tencent_mm_protocal_c_ajs.wqR);
                bVar.dL(com_tencent_mm_protocal_c_ajs.wqQ);
                bVar.eY(com_tencent_mm_protocal_c_ajs.wqT);
                bVar.dJ(com_tencent_mm_protocal_c_ajs.nfT);
                bVar.dK(com_tencent_mm_protocal_c_ajs.nfg);
                bVar.eZ(com_tencent_mm_protocal_c_ajs.gfR);
                bVar.an(com_tencent_mm_protocal_c_ajs.gfS);
                bVar.dO(com_tencent_mm_protocal_c_ajs.gfT);
                bVar.dP(com_tencent_mm_protocal_c_ajs.gfU);
                bVar.dQ(com_tencent_mm_protocal_c_ajs.gfV);
                bVar.dR(com_tencent_mm_protocal_c_ajs.gfW);
                bVar.field_url = "";
                bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.zu(com.tencent.mm.plugin.exdevice.j.b.zv(com_tencent_mm_protocal_c_ajs.vLs));
                bVar.field_md5Str = g.s(new String(com_tencent_mm_protocal_c_ajr2.vJA + com_tencent_mm_protocal_c_ajr2.ksX).getBytes());
                bVar.field_authKey = com_tencent_mm_protocal_c_ajs.vJh;
                bVar.field_brandName = com_tencent_mm_protocal_c_ajs.wqJ;
                if (bVar.field_mac == 0) {
                    bVar.field_mac = System.currentTimeMillis();
                }
                if (zg == null) {
                    z = ad.aEk().b(bVar);
                    if (z) {
                        ad.aEv();
                        e.ad(bVar.field_deviceID, true);
                    }
                } else if (ad.aEk().e(bVar) == 0) {
                }
                x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[]{Boolean.valueOf(z), bVar.field_brandName, bVar.field_deviceID, com_tencent_mm_protocal_c_ajr2.vJA, bVar.field_connProto, Integer.valueOf(bVar.field_connStrategy), Integer.valueOf(bVar.field_closeStrategy), Long.valueOf(bVar.field_mac)});
            } else {
                x.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[]{com_tencent_mm_protocal_c_ajr2.ksX, com_tencent_mm_protocal_c_ajs.vLs, com_tencent_mm_protocal_c_ajs.wqJ});
                if (zg != null) {
                    i.d(zg);
                    ad.aEk().cq(zg.field_deviceID, zg.field_deviceType);
                    ad.aEv();
                    e.ad(zg.field_deviceID, false);
                }
            }
        }
    }
}
