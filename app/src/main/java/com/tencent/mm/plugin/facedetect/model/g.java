package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.XWalkUpdater;

public final class g {
    public FaceProNative mgj = null;

    public final FaceResult aGH() {
        if (this.mgj == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
            return null;
        }
        try {
            long Wq = bh.Wq();
            x.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[]{Integer.valueOf(this.mgj.engineReleaseOut().result), Long.valueOf(bh.Wq() - Wq)});
            this.mgj = null;
            return this.mgj.engineReleaseOut();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.FaceDetectNativeManager", th, "hy: face lib release crash!!!", new Object[0]);
            this.mgj.engineRelease();
            this.mgj = null;
            return null;
        }
    }

    public final int aGI() {
        String str = "MicroMsg.FaceDetectNativeManager";
        String str2 = "alvinluo cutDown sFaceProNative == null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.mgj == null);
        x.v(str, str2, objArr);
        if (this.mgj == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        x.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[]{Integer.valueOf(this.mgj.engineRelease())});
        this.mgj = null;
        return this.mgj.engineRelease();
    }
}
