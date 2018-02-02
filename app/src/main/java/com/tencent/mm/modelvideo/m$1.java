package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements Runnable {
    final /* synthetic */ long hUS;
    final /* synthetic */ m hUT;

    m$1(m mVar, long j) {
        this.hUT = mVar;
        this.hUS = j;
    }

    public final void run() {
        long j = 0;
        m.TQ();
        m.c(this.hUT);
        m.a(this.hUT, "");
        if (this.hUS > 0 && m.d(this.hUT).get(Long.valueOf(this.hUS)) != null) {
            j = ((a) m.d(this.hUT).get(Long.valueOf(this.hUS))).zi();
        }
        x.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.hUS + " time:" + j + " inCnt:" + m.Td() + " stop:" + m.e(this.hUT) + " running:" + m.f(this.hUT) + " sending:" + m.g(this.hUT));
        if (m.e(this.hUT) > 0) {
            m.h(this.hUT);
        } else if (!m.g(this.hUT)) {
            m.i(this.hUT);
        }
        m.TR();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
