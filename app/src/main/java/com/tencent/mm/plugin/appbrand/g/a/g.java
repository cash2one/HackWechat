package com.tencent.mm.plugin.appbrand.g.a;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g implements a {
    private final AtomicInteger jwv = new AtomicInteger(0);
    private final HashMap<Integer, ByteBuffer> jww = new HashMap();

    public final int ahL() {
        Integer valueOf = Integer.valueOf(this.jwv.addAndGet(1));
        this.jww.put(valueOf, null);
        return valueOf.intValue();
    }

    public final ByteBuffer jt(int i) {
        if (!this.jww.containsKey(Integer.valueOf(i))) {
            return null;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.jww.get(Integer.valueOf(i));
        this.jww.remove(Integer.valueOf(i));
        return byteBuffer;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.isDirect() && this.jww.containsKey(Integer.valueOf(i))) {
            this.jww.put(Integer.valueOf(i), byteBuffer);
        }
    }
}
