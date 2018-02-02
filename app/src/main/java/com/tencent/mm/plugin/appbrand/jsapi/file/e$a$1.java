package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.p.c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class e$a$1 implements e {
    private final Charset nZ = Charset.forName("US-ASCII");

    e$a$1() {
    }

    public final String h(ByteBuffer byteBuffer) {
        return new String(c.j(byteBuffer), this.nZ);
    }

    public final ByteBuffer so(String str) {
        return ByteBuffer.wrap(str.getBytes(this.nZ));
    }
}
