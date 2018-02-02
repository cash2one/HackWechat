package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wf;
import com.tencent.mm.protocal.c.wg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class e extends c {
    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new wf();
        aVar.hmk = new wg();
        aVar.uri = "/cgi-bin/mmo2o-bin/freewifireport";
        aVar.hmi = 1781;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1781;
    }

    public e(LinkedList<we> linkedList) {
        aLV();
        if (linkedList != null && linkedList.size() > 0) {
            ((wf) this.gJQ.hmg.hmo).wgE = linkedList;
        }
    }

    protected final void b(int i, int i2, int i3, String str) {
        x.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (m.cz(i2, i3)) {
            j.aLS().aLz().post(new 1(this));
        }
    }

    public final LinkedList<we> aMe() {
        wg wgVar = (wg) this.gJQ.hmh.hmo;
        if (wgVar == null) {
            return null;
        }
        return wgVar.wgE;
    }
}
