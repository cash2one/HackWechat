package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.f.b.1;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class b$1$1 implements e {
    final /* synthetic */ 1 mGf;

    b$1$1(1 1) {
        this.mGf = 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        try {
            x.i("MicroMsg.FreeWifi.FreeWifiServerReporter", "errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (m.cz(i, i2)) {
                LinkedList aMe = ((com.tencent.mm.plugin.freewifi.d.e) kVar).aMe();
                if (aMe != null && aMe.size() > 0) {
                    f aLQ = j.aLQ();
                    Iterator it = aMe.iterator();
                    while (it.hasNext()) {
                        we weVar = (we) it.next();
                        String str2 = weVar.id;
                        x.i("MicroMsg.FreeWifi.FreeWifiServerReporter", "resp LinkedList<FreeWifiReport>. id=%s, errcode=%d", new Object[]{str2, Integer.valueOf(weVar.fts)});
                        if (!m.AA(str2) && r0 == 0) {
                            x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete. id=%s", new Object[]{str2});
                            c eVar = new com.tencent.mm.plugin.freewifi.g.e();
                            eVar.field_id = str2;
                            x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete ret" + aLQ.a(eVar, new String[0]));
                        }
                    }
                }
            }
            b.mGb = true;
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiServerReporter", m.f(e));
        } catch (Throwable th) {
            b.mGb = true;
        }
    }
}
