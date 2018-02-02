package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class h {
    public static h mgm;
    public int lHX = 0;
    public int[] mgk = null;
    public int mgl = -1;

    public static a aGJ() {
        String str;
        int aGF = f.mgf.aGF();
        g gVar = f.mgf.mgg.mil;
        if (gVar.mgj == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
            str = null;
        } else {
            str = gVar.mgj.engineGetCurrMotionData();
        }
        return new a(aGF, str);
    }

    public final String toString() {
        return "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.mgk) + '}';
    }
}
