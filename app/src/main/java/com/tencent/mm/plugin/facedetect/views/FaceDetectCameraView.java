package com.tencent.mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import org.xwalk.core.XWalkUpdater;

public class FaceDetectCameraView extends MMTextureView implements SurfaceTextureListener {
    private static a mlX = null;
    private int height;
    private boolean kwb;
    private long mgd;
    b mlG;
    private SurfaceTexture mlH;
    private ActivityManager mlI;
    private long mlJ;
    private long mlK;
    private int mlL;
    private boolean mlM;
    private boolean mlN;
    private boolean mlO;
    private final Object mlP;
    private boolean mlQ;
    private boolean mlR;
    private final Object mlS;
    private final Object mlT;
    private Rect mlU;
    private c mlV;
    private boolean mlW;
    public b mlY;
    private byte[] mlZ;
    private boolean mma;
    private long mmb;
    private int width;

    static /* synthetic */ void a(FaceDetectCameraView faceDetectCameraView, Point point) {
        DisplayMetrics displayMetrics = faceDetectCameraView.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        x.v("MicroMsg.FaceDetectCameraView", "alvinluo screen size: (%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(displayMetrics.heightPixels)});
        int i2 = displayMetrics.widthPixels;
        i = (int) (((1.0d * ((double) i2)) * ((double) point.x)) / ((double) point.y));
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo previewResolution: (%d, %d), adjust: (%d, %d), temp:%f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Integer.valueOf(i2), Integer.valueOf(i), Double.valueOf(((1.0d * ((double) i2)) * ((double) point.x)) / ((double) point.y))});
        ag.y(new 2(faceDetectCameraView, r2, i, i2));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(FaceDetectCameraView faceDetectCameraView, byte[] bArr) {
        int i = 0;
        synchronized (faceDetectCameraView.mlS) {
            if (!faceDetectCameraView.kwb) {
                x.w("MicroMsg.FaceDetectCameraView", "hy: not requesting scanning. stop send msg");
            } else if (!(bArr == null || faceDetectCameraView.mma)) {
                Object obj;
                faceDetectCameraView.mma = true;
                f fVar = f.mgf;
                int aGM = faceDetectCameraView.mlY.aGM();
                int aGN = faceDetectCameraView.mlY.aGN();
                int rotation = faceDetectCameraView.mlY.getRotation();
                g gVar = fVar.mgg.mil;
                x.v("MicroMsg.FaceDetectNativeManager", "alvinluo process parameter: width: %d, height: %d, depth: %d, imageType: %d, rotateAngle: %d, imgData length: %d", new Object[]{Integer.valueOf(aGM), Integer.valueOf(aGN), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(rotation), Integer.valueOf(bArr.length)});
                FaceCharacteristicsResult faceCharacteristicsResult = new FaceCharacteristicsResult();
                if (gVar.mgj == null) {
                    x.e("MicroMsg.FaceDetectNativeManager", "hy: process not init");
                    faceCharacteristicsResult.aa(4, ac.getContext().getString(h.meB));
                    obj = faceCharacteristicsResult;
                } else {
                    FaceCharacteristicsResult faceCharacteristicsResult2;
                    switch (rotation) {
                        case 0:
                            break;
                        case 90:
                            i = 4;
                            break;
                        case 270:
                            i = 5;
                            break;
                        default:
                            x.w("MicroMsg.FaceDetectNativeManager", "hy: rotate type not support!");
                            faceCharacteristicsResult.aa(1, ac.getContext().getString(h.mey));
                            faceCharacteristicsResult2 = faceCharacteristicsResult;
                            break;
                    }
                    long Wq = bh.Wq();
                    FaceStatus engineFaceProcess = gVar.mgj.engineFaceProcess(bArr, aGM, aGN, 3, 1, i);
                    long bA = bh.bA(Wq);
                    if (engineFaceProcess != null) {
                        FaceDetectReporter.aGK().q(engineFaceProcess.result, bA);
                    }
                    x.d("MicroMsg.FaceDetectNativeManager", "hy: process using: %d ms. result: %d", new Object[]{Long.valueOf(bA), Integer.valueOf(engineFaceProcess.result)});
                    faceCharacteristicsResult.mfZ = engineFaceProcess;
                    if (faceCharacteristicsResult.mfZ == null) {
                        x.e("MicroMsg.FaceCharacteristicsResult", "hy: invalid face status");
                    } else if (faceCharacteristicsResult.mfZ.result > 0) {
                        if (faceCharacteristicsResult.mfZ.result == 1) {
                            faceCharacteristicsResult.aa(0, ac.getContext().getString(h.mez));
                        } else if (faceCharacteristicsResult.mfZ.result == 2) {
                            faceCharacteristicsResult.aa(-1, ac.getContext().getString(h.mez));
                        } else {
                            x.e("MicroMsg.FaceCharacteristicsResult", "hy: unknown face num. regard as ok");
                            faceCharacteristicsResult.aa(0, ac.getContext().getString(h.mez));
                        }
                    } else if (faceCharacteristicsResult.mfZ.result == 0) {
                        faceCharacteristicsResult.aa(10, ac.getContext().getString(h.meu));
                    } else if (faceCharacteristicsResult.mfZ.result == -1 || faceCharacteristicsResult.mfZ.result == -2) {
                        faceCharacteristicsResult.aa(1, ac.getContext().getString(h.meB));
                    } else if (faceCharacteristicsResult.mfZ.result == -11) {
                        faceCharacteristicsResult.aa(13, ac.getContext().getString(h.meC));
                    } else if (faceCharacteristicsResult.mfZ.result == -12) {
                        faceCharacteristicsResult.aa(15, ac.getContext().getString(h.meD));
                    } else if (faceCharacteristicsResult.mfZ.result == -13) {
                        faceCharacteristicsResult.aa(14, ac.getContext().getString(h.mer));
                    } else if (faceCharacteristicsResult.mfZ.result == XWalkUpdater.ERROR_SET_VERNUM) {
                        faceCharacteristicsResult.aa(102, ac.getContext().getString(h.mes));
                    } else if (faceCharacteristicsResult.mfZ.result == -102) {
                        faceCharacteristicsResult.aa(16, ac.getContext().getString(h.met));
                    } else if (faceCharacteristicsResult.mfZ.result == -103) {
                        faceCharacteristicsResult.aa(17, ac.getContext().getString(h.mew));
                    } else if (faceCharacteristicsResult.mfZ.result == -105) {
                        faceCharacteristicsResult.aa(18, ac.getContext().getString(h.mev));
                    } else if (faceCharacteristicsResult.mfZ.result == -106) {
                        faceCharacteristicsResult.aa(11, ac.getContext().getString(h.mex));
                    } else if (faceCharacteristicsResult.mfZ.result == -107) {
                        faceCharacteristicsResult.aa(3, ac.getContext().getString(h.meA));
                    } else if (faceCharacteristicsResult.mfZ.result == -108) {
                        faceCharacteristicsResult.aa(6, ac.getContext().getString(h.mev));
                    } else if (faceCharacteristicsResult.mfZ.result == -109) {
                        faceCharacteristicsResult.aa(5, ac.getContext().getString(h.mev));
                    } else {
                        x.e("MicroMsg.FaceCharacteristicsResult", "hy: not defined system error! %d", new Object[]{Integer.valueOf(faceCharacteristicsResult.mfZ.result)});
                        faceCharacteristicsResult.aa(1, ac.getContext().getString(h.meB));
                    }
                    x.d("MicroMsg.FaceDetectNativeManager", "hy: detect result is: %s", new Object[]{faceCharacteristicsResult.toString()});
                    faceCharacteristicsResult2 = faceCharacteristicsResult;
                }
                faceDetectCameraView.mma = false;
                Message obtainMessage = mlX.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = obj;
                obtainMessage.sendToTarget();
            }
        }
    }

    static /* synthetic */ void f(FaceDetectCameraView faceDetectCameraView) {
        if (faceDetectCameraView.mlQ && faceDetectCameraView.mlJ > 0) {
            x.i("MicroMsg.FaceDetectCameraView", "hy: already request scanning face and now automatically capture");
            ag.y(new 1(faceDetectCameraView));
        }
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mlG = null;
        this.mlH = null;
        this.mlJ = FaceDetectView.mmI;
        this.mlK = -1;
        this.mgd = -1;
        this.mlL = 1;
        this.mlM = false;
        this.mlN = false;
        this.mlO = false;
        this.mlP = new Object();
        this.mlQ = false;
        this.mlR = false;
        this.kwb = false;
        this.mlS = new Object();
        this.mlT = new Object();
        this.mlU = null;
        this.width = p.CTRL_INDEX;
        this.height = 576;
        this.mlV = null;
        this.mlW = false;
        this.mlY = null;
        this.mlZ = null;
        this.mma = false;
        this.mmb = -1;
        this.mlI = (ActivityManager) getContext().getSystemService("activity");
        x.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[]{Boolean.valueOf(this.mlW)});
        this.mlY = new c(this, (byte) 0);
        mlX = new a(this, (byte) 0);
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    public final void a(c cVar) {
        this.mlY.a(cVar);
        this.mgd = -1;
    }

    public final synchronized void a(Rect rect, long j) {
        aHx();
        this.mlU = rect;
        aHz();
        this.mlY.cS(j);
    }

    private static void aHx() {
        x.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
        f.aGA();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
        cpK();
        this.mlM = true;
        this.mlH = surfaceTexture;
        if (this.mlR) {
            a(this.mlV);
        }
    }

    public final void aHy() {
        this.kwb = false;
        this.mlY.aHC();
        aHx();
        int aGF = f.mgf.aGF();
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        FaceDetectReporter.aGK().s(aGF, r2);
    }

    private synchronized void aHz() {
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo capture face");
        f.mgf.aGE();
        g gVar = f.mgf.mgg.mil;
        if (gVar.mgj == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        } else {
            x.i("MicroMsg.FaceDetectNativeManager", "hy: start init motion");
            gVar.mgj.engineGetCurrMotion();
        }
        int aGF = f.mgf.aGF();
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo start motion time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        FaceDetectReporter.aGK().r(aGF, r2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
        this.mlH = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
        this.mlM = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.i("MicroMsg.FaceDetectCameraView", "hy: attached");
    }

    final synchronized FaceResult aHA() {
        FaceResult aGH;
        f.aGA();
        int aGE = f.mgf.aGE();
        aGH = f.mgf.mgg.mil.aGH();
        String str = "MicroMsg.FaceDetectCameraView";
        String str2 = "hy: motionResult: %d, finalResult: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aGE);
        objArr[1] = Integer.valueOf(aGH != null ? aGH.result : -10000);
        x.i(str, str2, objArr);
        return aGH;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        x.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }
}
