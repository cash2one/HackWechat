package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.bq.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.x;

final class b$b implements h<b, IPCRunCgiRespWrapper> {
    private b$b() {
    }

    public final /* synthetic */ void a(Object obj, final i iVar) {
        b bVar = (b) obj;
        if (bVar == null || bVar.hmh.hmo.getClass() == a.class) {
            x.e("MicroMsg.IPCRunCgi", "InvokeTask, mm received invalid rr %s", new Object[]{bVar});
            iVar.as(IPCRunCgiRespWrapper.BG());
            return;
        }
        u.a(bVar, new u.a(this) {
            final /* synthetic */ b$b gNh;

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                if (iVar != null) {
                    IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                    iPCRunCgiRespWrapper.errType = i;
                    iPCRunCgiRespWrapper.errCode = i2;
                    iPCRunCgiRespWrapper.fnL = str;
                    iPCRunCgiRespWrapper.gJQ = bVar;
                    iVar.as(iPCRunCgiRespWrapper);
                }
                return 0;
            }
        }, true);
    }
}
