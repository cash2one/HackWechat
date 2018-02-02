package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.tl;
import com.tencent.mm.plugin.wear.model.b.2;
import com.tencent.mm.protocal.c.byj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends c<tl> {
    final /* synthetic */ b thU;

    b$1(b bVar) {
        this.thU = bVar;
        this.xen = tl.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(b bVar) {
        tl tlVar = (tl) bVar;
        if (tlVar instanceof tl) {
            switch (tlVar.fMa.fpr) {
                case 2:
                    x.i("MicroMsg.Wear.WearBizLogic", "receive register response, deviceId=%s | isSuccess=%b", new Object[]{tlVar.fMa.ffq, Boolean.valueOf(tlVar.fMa.fsH)});
                    break;
                case 5:
                    x.i("MicroMsg.Wear.WearBizLogic", "receive send response, deviceId=%s | isSuccess=%b", new Object[]{tlVar.fMa.ffq, Boolean.valueOf(tlVar.fMa.fsH)});
                    break;
                case 6:
                    byj com_tencent_mm_protocal_c_byj = a.bOt().thH.thY.tiP;
                    if (com_tencent_mm_protocal_c_byj != null && com_tencent_mm_protocal_c_byj.wYz.equals(tlVar.fMa.ffq)) {
                        x.i("MicroMsg.Wear.WearBizLogic", "request step count deviceId=%s", new Object[]{tlVar.fMa.ffq});
                        b bVar2 = this.thU;
                        boolean NG = b.NG(tlVar.fMa.ffq);
                        boolean bOu = b.bOu();
                        if (!NG || !bVar2.thR || !bOu) {
                            x.i("MicroMsg.Wear.WearBizLogic", "isRegister=%b | isFocus=%b | isAuth=%b", new Object[]{Boolean.valueOf(NG), Boolean.valueOf(bOu), Boolean.valueOf(bVar2.thR)});
                            break;
                        }
                        a.bOt().thN.a(new 2(bVar2));
                        break;
                    }
                    x.i("MicroMsg.Wear.WearBizLogic", "request is null or request.LocalNodeId is not same!");
                    break;
                    break;
                case 8:
                    x.i("MicroMsg.Wear.WearBizLogic", "receive auth response, deviceId=%s | isSuccess=%b", new Object[]{tlVar.fMa.ffq, Boolean.valueOf(tlVar.fMa.fsH)});
                    this.thU.thR = tlVar.fMa.fsH;
                    if (this.thU.thR) {
                    }
                    break;
                case 9:
                    this.thU.connect();
                    break;
            }
        }
        return false;
    }
}
