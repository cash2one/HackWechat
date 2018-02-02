package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.p.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

class e$a$6 implements e {
    final /* synthetic */ Charset jjx;

    e$a$6(Charset charset) {
        this.jjx = charset;
    }

    public final String h(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return new String(c.j(byteBuffer), this.jjx);
    }

    public final ByteBuffer so(String str) {
        return ByteBuffer.wrap(str.getBytes(this.jjx)).order(ByteOrder.LITTLE_ENDIAN);
    }
}
