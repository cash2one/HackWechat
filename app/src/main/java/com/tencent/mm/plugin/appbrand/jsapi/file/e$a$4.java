package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.p.c;
import java.math.BigInteger;
import java.nio.ByteBuffer;

class e$a$4 implements e {
    e$a$4() {
    }

    public final String h(ByteBuffer byteBuffer) {
        return new BigInteger(1, c.j(byteBuffer)).toString(16);
    }

    public final ByteBuffer so(String str) {
        return ByteBuffer.wrap(new BigInteger(str, 16).toByteArray());
    }
}
