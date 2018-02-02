package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.protocal.c.acv;
import com.tencent.mm.protocal.c.acw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;

class e$36 implements e {
    final /* synthetic */ e lLO;
    final /* synthetic */ dg lLP;

    e$36(e eVar, dg dgVar) {
        this.lLO = eVar;
        this.lLP = dgVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null || kVar.getType() != 543) {
            this.lLP.frM.frO = true;
            this.lLP.frM.frP = null;
            if (this.lLP.fqI != null) {
                this.lLP.fqI.run();
                return;
            }
            return;
        }
        ar.CG().b(543, this);
        if (i == 0 && i2 == 0) {
            acv com_tencent_mm_protocal_c_acv;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            z zVar = (z) kVar;
            if (zVar.lMW == null || zVar.lMW.hmh.hmo == null) {
                com_tencent_mm_protocal_c_acv = null;
            } else {
                com_tencent_mm_protocal_c_acv = (acv) zVar.lMW.hmh.hmo;
            }
            Iterator it = com_tencent_mm_protocal_c_acv.wlt.iterator();
            Object obj = null;
            while (it.hasNext()) {
                acw com_tencent_mm_protocal_c_acw = (acw) it.next();
                if (com_tencent_mm_protocal_c_acw != null) {
                    String str2 = null;
                    String str3 = null;
                    if (com_tencent_mm_protocal_c_acw.vLz != null) {
                        str2 = com_tencent_mm_protocal_c_acw.vLz.ksX;
                        str3 = com_tencent_mm_protocal_c_acw.vLz.vJA;
                    }
                    if (com_tencent_mm_protocal_c_acw.vJU != 0 || bh.ov(com_tencent_mm_protocal_c_acw.vZK)) {
                        x.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[]{str2, Integer.valueOf(com_tencent_mm_protocal_c_acw.vJU), com_tencent_mm_protocal_c_acw.vZK});
                    } else {
                        Object obj2;
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[]{str2, str3, com_tencent_mm_protocal_c_acw.vZK, Integer.valueOf(com_tencent_mm_protocal_c_acw.wlp)});
                        this.lLP.frM.frO = true;
                        this.lLP.frM.frP = com_tencent_mm_protocal_c_acw.vZK;
                        if (this.lLP.fqI != null) {
                            this.lLP.fqI.run();
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                }
            }
            if (obj == null) {
                this.lLP.frM.frO = true;
                this.lLP.frM.frP = null;
                if (this.lLP.fqI != null) {
                    this.lLP.fqI.run();
                    return;
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.lLP.frM.frO = true;
        this.lLP.frM.frP = null;
        if (this.lLP.fqI != null) {
            this.lLP.fqI.run();
        }
    }
}
