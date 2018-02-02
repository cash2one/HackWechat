package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class m$2 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ long hUS;
    final /* synthetic */ m hUT;

    m$2(m mVar, long j, int i, int i2) {
        this.hUT = mVar;
        this.hUS = j;
        this.fma = i;
        this.fmb = i2;
    }

    public final void run() {
        m.TQ();
        m.c(this.hUT);
        m.a(this.hUT, "");
        long j = 0;
        if (this.hUS > 0 && m.d(this.hUT).get(Long.valueOf(this.hUS)) != null) {
            j = ((a) m.d(this.hUT).get(Long.valueOf(this.hUS))).zi();
        }
        x.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[]{Long.valueOf(this.hUS), Long.valueOf(j), Integer.valueOf(this.fma), Integer.valueOf(this.fmb)});
        if (!(this.fma == 0 && this.fmb == 0)) {
            m.j(this.hUT);
        }
        x.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[]{Integer.valueOf(m.Td()), Integer.valueOf(m.e(this.hUT)), Boolean.valueOf(m.f(this.hUT)), Boolean.valueOf(m.g(this.hUT))});
        if (m.e(this.hUT) > 0) {
            m.h(this.hUT);
        } else if (!m.g(this.hUT)) {
            x.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
            s TU = o.TU();
            List k = m.k(this.hUT);
            if (!(k == null || k.isEmpty())) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('(');
                for (int i = 0; i < k.size() - 1; i++) {
                    stringBuilder.append((Long) k.get(i));
                    stringBuilder.append(',');
                }
                Long l = (Long) k.get(k.size() - 1);
                if (l != null) {
                    stringBuilder.append(l);
                }
                stringBuilder.append(')');
                x.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[]{"UPDATE videoinfo2 SET status=198, lastmodifytime=" + currentTimeMillis + " WHERE masssendid IN " + stringBuilder.toString()});
                TU.hhp.fx("videoinfo2", r0);
            }
            m.i(this.hUT);
        }
        m.TR();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
