package com.tencent.mm.plugin.fps_lighter.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.gmtrace.GMTraceHandler;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e extends GMTraceHandler {
    public boolean fAs = false;
    public int mAR;
    private int mAS;
    c mAT;

    public e(c cVar) {
        this.mAT = cVar;
    }

    public final void stopTrace() {
        if (this.fAs) {
            GMTrace.stopTrace();
            this.mAS = GMTrace.getMainThreadIndex();
            x.i("MicroMsg.FpsGMTraceHandler", "[stopTrace] start:%s end:%s", new Object[]{Integer.valueOf(this.mAR), Integer.valueOf(this.mAS)});
            this.fAs = false;
        }
    }

    public static int aKM() {
        return GMTrace.getMainThreadIndex();
    }

    public final void aKN() {
        if (this.fAs) {
            this.mAR = GMTrace.getMainThreadIndex();
        } else {
            x.e("MicroMsg.FpsGMTraceHandler", "its never start!");
        }
    }

    public final List<Integer> getPointId() {
        return null;
    }

    public final void syncDo(int i, long j) {
    }

    public final void postBufferData(boolean z) {
    }
}
