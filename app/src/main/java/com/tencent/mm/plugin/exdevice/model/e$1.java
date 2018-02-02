package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d$b$b;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.la;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class e$1 extends c<jc> {
    final /* synthetic */ e lLO;

    e$1(e eVar) {
        this.lLO = eVar;
        this.xen = jc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jc jcVar = (jc) bVar;
        e eVar = this.lLO;
        int i = jcVar.fzE.opType;
        int i2 = jcVar.fzE.fzG;
        String str = jcVar.fzE.fzF;
        if (i == 1) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "Just enter, so clear previous state.");
            b laVar = new la();
            laVar.fCm.op = 3;
            laVar.fCm.fzF = jcVar.fzE.fzF;
            a.xef.m(laVar);
        }
        LinkedList zi = ad.aEk().zi(str);
        d jS = f.jS(str);
        if (jS != null) {
            d.b bI = jS.bI(false);
            if (bI != null) {
                d$b$b Ly = bI.Ly();
                if (Ly != null && Ly.LH() && Ly.hpc == 1) {
                    List<com.tencent.mm.plugin.exdevice.h.b> aEQ = ad.aEk().aEQ();
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat sport biz...");
                    if (aEQ.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar2 : aEQ) {
                            com.tencent.mm.plugin.exdevice.h.b bVar22;
                            if (0 != (bVar22.gfS & 1)) {
                                x.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE connected device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d), connProto(%s)", new Object[]{Long.valueOf(bVar22.field_mac), bVar22.field_deviceID, bVar22.field_deviceType, Long.valueOf(bVar22.gfS), bVar22.field_connProto});
                                zi.add(bVar22);
                            }
                        }
                    }
                }
            }
        }
        if (zi == null) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName failed : %s", new Object[]{str});
            return false;
        } else if (zi.size() == 0) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName(%s) result count is 0 ", new Object[]{str});
            return true;
        } else {
            if (i == 2) {
                x.d("MicroMsg.exdevice.ExdeviceEventManager", "exit chattingui, clear observers.");
                eVar.lKV.clear();
            }
            List linkedList = new LinkedList();
            Iterator it = zi.iterator();
            Object obj = null;
            while (it.hasNext()) {
                bVar22 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (bVar22 == null || bh.ov(bVar22.field_brandName)) {
                    return false;
                }
                String ou = bh.ou(bVar22.field_connProto);
                if (ou.contains("4")) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz.");
                    linkedList.add(bVar22);
                } else {
                    if (ou.contains("1") || ou.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || ou.contains("5") || ou.length() == 0) {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "BlueTooth biz.");
                        if (com.tencent.mm.plugin.g.a.e.a.arv()) {
                            obj = null;
                            eVar.a(bVar22, i, i2);
                        } else {
                            x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                            obj = 1;
                        }
                    }
                    obj = obj;
                }
            }
            i2 = linkedList.size();
            if (i2 > 0) {
                eVar.e(linkedList, i);
                bVar22 = (com.tencent.mm.plugin.exdevice.h.b) linkedList.get(i2 - 1);
                if (i2 == zi.size()) {
                    e.c(bVar22.field_brandName, bVar22.field_url, 0, bVar22.field_deviceID);
                }
            }
            e.bg(str, obj != null ? 0 : -1);
            return false;
        }
    }
}
