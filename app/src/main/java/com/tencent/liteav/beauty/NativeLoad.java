package com.tencent.liteav.beauty;

import com.tencent.liteav.basic.util.a;
import java.nio.ByteBuffer;

public class NativeLoad {
    private static NativeLoad m_Instance = null;
    private static boolean m_bLoadJni = false;

    public static native void OnLoadBeauty();

    public static native void nativeClearQueue();

    public static native void nativeDeleteYuv2Yuv();

    public static native void nativeGlMapBufferToQueue(int i, int i2, ByteBuffer byteBuffer);

    public static native void nativeGlReadPixs(int i, int i2, byte[] bArr);

    public static native boolean nativeGlReadPixsFromQueue(int i, int i2, byte[] bArr);

    public static native void nativeGlReadPixsToQueue(int i, int i2);

    public static native int nativeLoadGLProgram(int i);

    public static native void nativeglTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr, int i9);

    private NativeLoad() {
        a.d();
        if (!m_bLoadJni) {
            m_bLoadJni = true;
            OnLoadBeauty();
        }
    }

    public static NativeLoad getInstance() {
        if (m_Instance == null) {
            m_Instance = new NativeLoad();
        }
        return m_Instance;
    }
}
