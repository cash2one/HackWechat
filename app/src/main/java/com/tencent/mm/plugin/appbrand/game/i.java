package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.engine.JsEngine;
import com.tencent.magicbrush.engine.b;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.g.f;
import java.nio.ByteBuffer;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public enum i implements d, f {
    ;
    
    volatile e iXr;
    final AtomicInteger iXs;
    final TreeMap<Integer, a> iXt;

    private i(String str) {
        this.iXs = new AtomicInteger(0);
        this.iXt = new TreeMap();
    }

    public final a adS() {
        return this.iXr;
    }

    public final a adT() {
        int addAndGet = this.iXs.addAndGet(1);
        a eVar = new e(false, new b(this.iXr.iXj.sB()), addAndGet);
        this.iXt.put(Integer.valueOf(addAndGet), eVar);
        return eVar;
    }

    public final void ke(int i) {
        a aVar = (a) this.iXt.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.destroy();
        }
        this.iXt.remove(Integer.valueOf(i));
    }

    public final int getNativeBufferId() {
        e eVar = this.iXr;
        return JsEngine.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        e eVar = this.iXr;
        if (byteBuffer == null) {
            c.f.d("JsVmContext", "JsVmContext setNativeBuffer failed. byteBuffer == null", new Object[0]);
            return;
        }
        if (!byteBuffer.isDirect()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
            byteBuffer.rewind();
            allocateDirect.put(byteBuffer);
            byteBuffer = allocateDirect;
        }
        JsEngine.setNativeBuffer(i, byteBuffer);
    }

    public final ByteBuffer ef(int i) {
        return this.iXr.iXj.ef(i);
    }

    public final boolean adU() {
        return true;
    }
}
