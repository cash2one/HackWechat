package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public enum f {
    ;
    
    private static ag mgh;
    public FaceDetectProcessService mgg;

    private f(String str) {
        this.mgg = null;
    }

    static {
        mgh = new ag("face_process");
    }

    public static void w(Runnable runnable) {
        mgh.F(runnable);
    }

    public static void aGA() {
        mgh.cfF().removeCallbacksAndMessages(null);
    }

    public static af aGB() {
        return mgh.cfF();
    }

    public final boolean eT(boolean z) {
        x.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[]{Boolean.valueOf(z)});
        boolean aGC = aGC();
        boolean aGO = n.aGO();
        if (z) {
            x.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b", new Object[]{Boolean.valueOf(bh.getInt(((a) g.h(a.class)).zY().getValue("BioSigFaceEntry"), 0) == 1), Boolean.valueOf(aGC), Boolean.valueOf(aGO)});
            if (!(bh.getInt(((a) g.h(a.class)).zY().getValue("BioSigFaceEntry"), 0) == 1) || (aGC & aGO) == 0) {
                return false;
            }
            return true;
        }
        x.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b", new Object[]{Boolean.valueOf(aGC), Boolean.valueOf(aGO)});
        if (aGO && aGC) {
            return true;
        }
        return false;
    }

    public static boolean aGC() {
        return ac.getContext().getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    public static boolean aGD() {
        return n.aGO();
    }

    public final int aGE() {
        g gVar = this.mgg.mil;
        if (gVar.mgj != null) {
            return gVar.mgj.engineReleaseCurrMotion();
        }
        x.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        return -3;
    }

    public final int aGF() {
        g gVar = this.mgg.mil;
        if (gVar.mgj != null) {
            return gVar.mgj.engineGetCurrMotion();
        }
        x.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
        return -1;
    }

    public static int aGG() {
        return FaceProNative.engineVersion();
    }
}
