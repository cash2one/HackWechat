package com.tencent.magicbrush.engine;

import android.content.res.AssetManager;
import com.tencent.magicbrush.a.b;

public class MBRendererJNI {
    private native void nativeChanged(int i, int i2);

    private native void nativeCreated(AssetManager assetManager, String str, int i, int i2, float f, boolean z, long j);

    private native void nativeFinalize();

    private native void nativeOnCreateEglSurface();

    private native void nativePause();

    private native boolean nativeRender();

    private native void nativeResume();

    MBRendererJNI() {
    }

    public void Created(AssetManager assetManager, String str, int i, int i2, float f, boolean z, long j) {
        nativeCreated(assetManager, str, i, i2, f, z, j);
    }

    public void Changed(int i, int i2) {
        nativeChanged(i, i2);
    }

    public boolean Render() {
        return nativeRender();
    }

    public void Finalize() {
        nativeFinalize();
    }

    public void Pause() {
        nativePause();
    }

    public void Resume() {
        nativeResume();
    }

    public void onCreateEglSurface() {
        nativeOnCreateEglSurface();
    }

    static {
        b.loadLibrary("mmv8");
        b.loadLibrary("magicbrush");
    }
}
