package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.a.c.a;

@Keep
public class MBJavaHandler {
    private static c mCallbackProxy;

    public static void setCallbackProxy(c cVar) {
        mCallbackProxy = cVar;
    }

    @Keep
    public static byte[] encodeString(String str, String str2) {
        return d.encodeString(str, str2);
    }

    @Keep
    public static String decodeString(byte[] bArr, String str) {
        return d.decodeString(bArr, str);
    }

    @Keep
    public static byte[] readResource(String str, String str2) {
        if (mCallbackProxy != null) {
            return mCallbackProxy.bz(str2);
        }
        return null;
    }

    @Keep
    public static String resource_getMediaFilePath(String str, String str2) {
        if (mCallbackProxy != null) {
            return mCallbackProxy.r(str, str2);
        }
        return null;
    }

    @Keep
    public static void v8_exception(String str, String str2, long j) {
        if (mCallbackProxy != null) {
            mCallbackProxy.s(str, str2);
        }
    }

    @Keep
    public static void printConsole(int i, String str) {
        a.i(i, str);
    }

    @Keep
    public static void onScreenCanvasContextTypeSet(boolean z) {
        if (mCallbackProxy != null) {
            mCallbackProxy.onScreenCanvasContextTypeSet(z);
        }
    }

    @Keep
    public static void onShaderCompileError(String str) {
        if (mCallbackProxy != null) {
            mCallbackProxy.onShaderCompileError(str);
        }
    }
}
