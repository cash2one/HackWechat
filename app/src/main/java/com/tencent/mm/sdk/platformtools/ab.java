package com.tencent.mm.sdk.platformtools;

import java.security.MessageDigest;

public final class ab {
    protected static char[] xfo = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> xfp = new ThreadLocal<MessageDigest>() {
        protected final /* synthetic */ Object initialValue() {
            return AnonymousClass1.cfo();
        }

        private static MessageDigest cfo() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (Throwable e) {
                throw new RuntimeException("Initialize MD5 failed.", e);
            }
        }
    };

    public static String UZ(String str) {
        return bt(str.getBytes());
    }

    public static String bt(byte[] bArr) {
        byte[] digest = ((MessageDigest) xfp.get()).digest(bArr);
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (length = 0; length < i; length++) {
            byte b = digest[length];
            char c = xfo[(b & 240) >> 4];
            char c2 = xfo[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
