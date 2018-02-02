package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.g.a.j;
import java.nio.ByteBuffer;

class m$1 extends j {
    final /* synthetic */ m ise;

    m$1(m mVar) {
        this.ise = mVar;
    }

    public final int YU() {
        if (this.ise.isb != null) {
            return this.ise.isb.getNativeBufferId();
        }
        return 0;
    }

    public final ByteBuffer jt(int i) {
        if (this.ise.isb != null) {
            return this.ise.isb.ef(i);
        }
        return null;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        if (this.ise.isb != null) {
            this.ise.isb.setNativeBuffer(i, byteBuffer);
        }
    }

    public final void z(int i, String str) {
        this.ise.iqB.irR.evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[]{Integer.valueOf(i), str}), null);
    }
}
