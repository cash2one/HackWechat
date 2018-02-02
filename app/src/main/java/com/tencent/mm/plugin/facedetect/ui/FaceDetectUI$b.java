package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$b {
    final /* synthetic */ FaceDetectUI mkq;
    private boolean mkw;
    boolean mkx;
    private boolean mky;
    private final boolean mkz;

    private FaceDetectUI$b(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
        this.mkw = true;
        this.mkx = false;
        this.mky = true;
        this.mkz = true;
    }

    public final synchronized void aHr() {
        this.mkx = true;
    }

    final synchronized void reset() {
        this.mkx = false;
    }

    final synchronized void aHs() {
        x.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[]{toString()});
        if (this.mkw && this.mkx && this.mky) {
            FaceDetectUI.m(this.mkq).setVisibility(0);
        }
    }

    public final String toString() {
        return "InitHandler{isCgiInitDone=" + this.mkw + ", isCameraInitDone=" + this.mkx + ", isLightInitDone=true, isLibraryInitDone=" + this.mky + '}';
    }
}
