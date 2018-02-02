package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.p.c;
import java.nio.ByteBuffer;

class e$a$2 implements e {
    e$a$2() {
    }

    public final String h(ByteBuffer byteBuffer) {
        return Base64.encodeToString(c.j(byteBuffer), 0);
    }

    public final ByteBuffer so(String str) {
        return ByteBuffer.wrap(Base64.decode(str.getBytes(), 0));
    }
}
