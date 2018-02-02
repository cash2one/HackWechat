package com.tencent.mm.memory;

import com.tencent.mm.sdk.b;
import com.tencent.mm.sdk.f.e;
import java.nio.ByteBuffer;

public final class h extends b<ByteBuffer> {
    public static h gZY = new h();

    static /* synthetic */ void a(h hVar, Object obj) {
        if (hVar.ws != null && hVar.wt < hVar.ws.length) {
            hVar.ws[hVar.wt] = obj;
            hVar.wt++;
        }
    }

    static {
        e.post(new 1(), "DecodeTempStorage_preload");
    }

    private h() {
    }
}
