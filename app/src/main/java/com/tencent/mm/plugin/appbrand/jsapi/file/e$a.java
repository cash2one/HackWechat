package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class e$a {
    static final Map<String, e> jjv;

    static void init() {
    }

    static {
        Map hashMap = new HashMap();
        jjv = hashMap;
        hashMap.put("ascii", new 1());
        jjv.put("base64", new 2());
        jjv.put("binary", new e() {
            public final String h(ByteBuffer byteBuffer) {
                return new BigInteger(1, c.j(byteBuffer)).toString(2);
            }

            public final ByteBuffer so(String str) {
                return ByteBuffer.wrap(new BigInteger(str, 2).toByteArray());
            }
        });
        jjv.put("hex", new 4());
        final Charset forName = Charset.forName("ISO-10646-UCS-2");
        AnonymousClass5 anonymousClass5 = new e() {
            public final String h(ByteBuffer byteBuffer) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                return new String(c.j(byteBuffer), forName);
            }

            public final ByteBuffer so(String str) {
                return ByteBuffer.wrap(str.getBytes(forName)).order(ByteOrder.LITTLE_ENDIAN);
            }
        };
        jjv.put("ucs2", anonymousClass5);
        jjv.put("ucs-2", anonymousClass5);
        6 6 = new 6(Charset.forName("UTF-16LE"));
        jjv.put("utf16le", 6);
        jjv.put("utf-16le", 6);
        AnonymousClass7 anonymousClass7 = new e() {
            public final String h(ByteBuffer byteBuffer) {
                return new String(c.j(byteBuffer), UTF_8);
            }

            public final ByteBuffer so(String str) {
                return ByteBuffer.wrap(str.getBytes(UTF_8));
            }
        };
        jjv.put("utf8", anonymousClass7);
        jjv.put(ProtocolPackage.ServerEncoding, anonymousClass7);
        jjv.put("latin1", new 8());
    }
}
