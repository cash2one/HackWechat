package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.sp;
import com.tencent.mm.plugin.wear.model.f.l;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

class e$6 extends c<sp> {
    final /* synthetic */ e tik;

    e$6(e eVar) {
        this.tik = eVar;
        this.xen = sp.class.getName().hashCode();
    }

    private static boolean a(sp spVar) {
        switch (spVar.fKq.fuL) {
            case 3:
                Object obj = spVar.fKq.fKk;
                if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                    buj com_tencent_mm_protocal_c_buj;
                    Object obj2 = new byte[(obj.length - 1)];
                    System.arraycopy(obj, 1, obj2, 0, obj2.length);
                    try {
                        com_tencent_mm_protocal_c_buj = (buj) new buj().aF(obj2);
                    } catch (IOException e) {
                        com_tencent_mm_protocal_c_buj = null;
                    }
                    if (com_tencent_mm_protocal_c_buj != null) {
                        String str = com_tencent_mm_protocal_c_buj.wVt;
                        int i = com_tencent_mm_protocal_c_buj.wVl;
                        x.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", new Object[]{str, Integer.valueOf(i)});
                        a.bOt().thN.a(new l(20010, str));
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
