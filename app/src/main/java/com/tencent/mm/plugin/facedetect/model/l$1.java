package com.tencent.mm.plugin.facedetect.model;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class l$1 implements PreviewCallback {
    final /* synthetic */ PreviewCallback mhh;
    final /* synthetic */ l mhi;

    l$1(l lVar, PreviewCallback previewCallback) {
        this.mhi = lVar;
        this.mhh = previewCallback;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.mhh != null) {
            this.mhh.onPreviewFrame(bArr, camera);
        }
        camera.addCallbackBuffer(bArr);
    }
}
