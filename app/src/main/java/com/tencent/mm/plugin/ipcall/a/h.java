package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.g.a.ii;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends c<ii> {
    public a nCU;

    public interface a {
        void a(ayl com_tencent_mm_protocal_c_ayl);
    }

    public h() {
        this.xen = ii.class.getName().hashCode();
    }

    private boolean a(ii iiVar) {
        if (iiVar instanceof ii) {
            Object obj = iiVar.fyN.fyO;
            if (obj != null && obj.length > 0 && obj[0] == (byte) 101) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                try {
                    ayl com_tencent_mm_protocal_c_ayl = (ayl) new ayl().aF(obj2);
                    x.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayl.wbh), Long.valueOf(com_tencent_mm_protocal_c_ayl.wbi), Integer.valueOf(com_tencent_mm_protocal_c_ayl.nDS)});
                    LinkedList linkedList = com_tencent_mm_protocal_c_ayl.wFH;
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ayu com_tencent_mm_protocal_c_ayu = (ayu) it.next();
                            x.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayu.wEr), Integer.valueOf(com_tencent_mm_protocal_c_ayu.wFR), Integer.valueOf(com_tencent_mm_protocal_c_ayu.wFQ)});
                        }
                    }
                    if (this.nCU != null) {
                        this.nCU.a(com_tencent_mm_protocal_c_ayl);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[]{e.getMessage()});
                }
            }
        }
        return false;
    }
}
