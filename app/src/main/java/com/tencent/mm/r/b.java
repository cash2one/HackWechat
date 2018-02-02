package com.tencent.mm.r;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class b implements e {
    private List<d> gJF = null;
    private List<d> gJG = null;
    private d gJH = null;
    private a gJI;

    public b(List<d> list, a aVar) {
        this.gJF = list;
        this.gJG = new ArrayList();
        this.gJI = aVar;
    }

    public final boolean start() {
        if (this.gJF == null || this.gJF.size() <= 0) {
            return false;
        }
        x.i("MicroMsg.FunctionMsgFetchLooper", "start, fetchItemList.size: %s", Integer.valueOf(this.gJF.size()));
        g.CG().a(825, (e) this);
        Bb();
        return true;
    }

    private void Bb() {
        x.d("MicroMsg.FunctionMsgFetchLooper", "fetchNext, fetchItemList.size: %s", Integer.valueOf(this.gJF.size()));
        if (this.gJF.size() > 0) {
            this.gJH = (d) this.gJF.remove(0);
            d dVar = this.gJH;
            if (dVar != null) {
                x.i("MicroMsg.FunctionMsgFetchLooper", "fetchInternal, functionMsgId: %s", dVar.field_functionmsgid);
                dVar.field_status = 0;
                g.CG().a(new g(dVar), 0);
                return;
            }
            return;
        }
        g.CG().b(825, (e) this);
        if (this.gJI != null) {
            this.gJI.z(this.gJG);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FunctionMsgFetchLooper", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar.getType() == 825) {
            g gVar = (g) kVar;
            acj com_tencent_mm_protocal_c_acj = gVar.gJS;
            d dVar = gVar.gJU;
            if (dVar != null && dVar.field_functionmsgid.equals(this.gJH.field_functionmsgid)) {
                if (i == 0 || i2 == 0) {
                    x.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s", dVar.field_functionmsgid, Long.valueOf(com_tencent_mm_protocal_c_acj.wlf), Long.valueOf(dVar.field_version));
                    if (com_tencent_mm_protocal_c_acj.wlf >= dVar.field_version) {
                        dVar.field_preVersion = dVar.field_version;
                        dVar.field_version = com_tencent_mm_protocal_c_acj.wlf;
                        dVar.field_status = 2;
                        dVar.b(com_tencent_mm_protocal_c_acj.wlg);
                        i.Bl().a(dVar.field_functionmsgid, dVar);
                        this.gJG.add(dVar);
                    }
                } else {
                    x.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s", dVar.field_functionmsgid, Long.valueOf(dVar.field_preVersion), Long.valueOf(dVar.field_version));
                    dVar.field_status = 3;
                    dVar.field_version = dVar.field_preVersion;
                    i.Bl().a(dVar.field_functionmsgid, dVar);
                }
                Bb();
            }
        }
    }
}
