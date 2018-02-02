package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements d, e {
    private Queue<a> rWd = null;
    private boolean rWe = false;

    public final com.tencent.mm.ae.d.b b(a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        if (this.rWd == null) {
            this.rWd = new LinkedList();
        }
        a aVar2 = new a(a);
        if (aVar2.ikn != null) {
            this.rWd.offer(aVar2);
            bDZ();
        }
        return null;
    }

    private void bDZ() {
        if (!this.rWe && this.rWd.size() != 0) {
            a aVar = (a) this.rWd.peek();
            if (aVar.rWf.size() == 0) {
                this.rWd.poll();
                ar.Hg();
                c.CU().set(8193, aVar.ikn);
                ar.Hg();
                c.CU().set(8449, Long.valueOf(bh.Wo()));
                return;
            }
            String str = (String) aVar.rWf.peek();
            if (str != null && str.length() > 0) {
                this.rWe = true;
                k aVar2 = new a(str);
                ar.CG().a(j.CTRL_INDEX, this);
                ar.CG().a(aVar2, 0);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != j.CTRL_INDEX) {
            this.rWe = false;
            return;
        }
        ar.CG().b(j.CTRL_INDEX, this);
        String str2 = ((a) kVar).url;
        a aVar = (a) this.rWd.peek();
        if (aVar == null || aVar.rWf.size() == 0) {
            x.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
            this.rWd = new LinkedList();
            this.rWe = false;
        } else if (aVar.rWf.size() == 0) {
            x.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
            this.rWd.poll();
            this.rWe = false;
        } else if (!((String) aVar.rWf.peek()).equals(str2)) {
            x.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
            this.rWd.poll();
            this.rWe = false;
        } else if (i == 0 && i2 == 0) {
            aVar.rWf.poll();
            this.rWe = false;
            bDZ();
        } else {
            x.e("MicroMsg.PushMessageExtension", "down failed [" + i + "," + i2 + "] ignore this message : img:[" + str2 + "] ");
            this.rWd.poll();
            this.rWe = false;
        }
    }

    public final void h(au auVar) {
    }
}
