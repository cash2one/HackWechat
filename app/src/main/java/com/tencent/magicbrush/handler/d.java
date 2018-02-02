package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.a.c.f;
import java.io.UnsupportedEncodingException;

final class d {
    static byte[] encodeString(String str, String str2) {
        byte[] bArr = null;
        if (str != null) {
            try {
                bArr = str.getBytes(str2);
            } catch (UnsupportedEncodingException e) {
                f.d("MicroMsg.MBStringCharsetHandler", "UnsupportedEncoding [" + str2 + "] " + e.getMessage(), new Object[0]);
            }
        }
        return bArr;
    }

    static String decodeString(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            f.d("MicroMsg.MBStringCharsetHandler", "UnsupportedDecoding [" + str + "] " + e.getMessage(), new Object[0]);
            return null;
        }
    }
}
