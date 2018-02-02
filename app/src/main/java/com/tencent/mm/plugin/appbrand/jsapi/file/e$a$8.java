package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.p.c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class e$a$8 implements e {
    private final Charset jjy = Charset.forName("ISO-8859-1");

    e$a$8() {
    }

    public final String h(ByteBuffer byteBuffer) {
        return new String(c.j(byteBuffer), this.jjy);
    }

    public final ByteBuffer so(String str) {
        return ByteBuffer.wrap(str.getBytes(this.jjy));
    }
}
