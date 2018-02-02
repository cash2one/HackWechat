package com.tencent.mm.plugin.fps_lighter.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fps_lighter.b.b;
import com.tencent.mm.plugin.fps_lighter.b.c;
import com.tencent.mm.plugin.fps_lighter.b.e;
import com.tencent.mm.plugin.fps_lighter.b.g;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements c {
    private c mAl;
    private int mAm;
    private int mAn;
    private e mAo = g.aKO().mBh;

    public a(c cVar) {
        this.mAl = cVar;
    }

    public final void a(int i, long j, long j2, int i2, int i3, boolean z, long j3, boolean z2) {
        if (com.tencent.mm.plugin.fps_lighter.e.a.pP(i2) == com.tencent.mm.plugin.fps_lighter.e.a.a.mBL && !z) {
            x.i("MicroMsg.FrameAnalyseCallback", "Scene:%s pre:%s droppedFrames:%s isInputHandling:%s isOnCreateConsuming:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z)});
            b bVar = g.aKO().mBg;
            long[] mainThreadBuffer = !this.mAo.fAs ? null : GMTrace.getMainThreadBuffer();
            long startTime = j2 - GMTrace.getStartTime();
            x.i("MicroMsg.FPSAnalyser", "[immediateExec] preIndex:%s,curIndex：%s droopedCount:%s previousFrameMS:%s scene:%s isOnCreateConsuming:%s", new Object[]{Integer.valueOf(this.mAm), Integer.valueOf(e.aKM()), Long.valueOf((long) i2), Long.valueOf(j - GMTrace.getStartTime()), Integer.valueOf(i), Boolean.valueOf(z)});
            Runnable aVar = new com.tencent.mm.plugin.fps_lighter.d.a(mainThreadBuffer, r4, r5, r6, r8, startTime, i3, i, z, j3, z2);
            aVar.mBH = bVar;
            g.aKO();
            g.VO().post(aVar);
        }
        this.mAm = this.mAn;
        this.mAn = this.mAo.mAR;
        this.mAo.aKN();
    }

    public final void D(int i, boolean z) {
        if (i == Integer.MAX_VALUE) {
            if (z) {
                e eVar = g.aKO().mBh;
                if (!eVar.fAs) {
                    if (!GMTrace.isInit()) {
                        GMTrace.init(true);
                    }
                    GMTrace.startTrace();
                    eVar.mAR = GMTrace.getMainThreadIndex();
                    x.i("MicroMsg.FpsGMTraceHandler", "[startTrace] start:%s", new Object[]{Integer.valueOf(eVar.mAR)});
                    eVar.fAs = true;
                }
            } else {
                g.aKO().mBh.stopTrace();
            }
        }
        this.mAm = this.mAn;
        this.mAn = this.mAo.mAR;
        this.mAo.aKN();
    }

    public final String toString() {
        return "MicroMsg.FrameAnalyseCallback";
    }
}
