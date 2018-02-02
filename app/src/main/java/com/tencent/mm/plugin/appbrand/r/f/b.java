package com.tencent.mm.plugin.appbrand.r.f;

import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class b {
    public static CodingErrorAction jUr = CodingErrorAction.REPORT;

    public static byte[] uO(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return new byte[0];
        }
    }

    public static byte[] uP(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return new byte[0];
        }
    }

    public static String C(byte[] bArr, int i) {
        try {
            return new String(bArr, 0, i, "ASCII");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return "";
        }
    }

    public static String v(ByteBuffer byteBuffer) {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(jUr);
        newDecoder.onUnmappableCharacter(jUr);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (Throwable e) {
            throw new com.tencent.mm.plugin.appbrand.r.c.b(1007, e);
        }
    }
}
