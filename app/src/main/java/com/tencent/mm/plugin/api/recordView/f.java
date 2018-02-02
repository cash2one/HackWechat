package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera.Parameters;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView$c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView$e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.e.3;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public final class f extends d implements g$a, a, com.tencent.mm.plugin.mmsight.model.f {
    private int audioSampleRate;
    private Context context;
    private int fps;
    private int huc;
    private MMSightRecordView.a ipA;
    boolean ipB = false;
    boolean ipC = false;
    int ipD = -1;
    Point ipE;
    private Point ipF;
    private boolean ipG = true;
    private boolean ipH = true;
    private g ipI;
    MMSightRecordView$c ipJ;
    private boolean ipK = false;
    private float ipL = 1.0f;
    private byte[] ipM = null;
    private com.tencent.mm.plugin.mmsight.model.a.d ipr;
    e ips;
    int ipt;
    float ipu;
    private int ipv;
    private boolean ipw = true;
    private ObservableTextureView ipx;
    private MMSightCameraGLSurfaceView ipy;
    boolean ipz = false;
    private int videoBitrate;
    private String videoPath;

    public final void b(Context context, ViewGroup viewGroup) {
        this.context = context;
        this.ipx = new ObservableTextureView(context);
        this.ipy = new MMSightCameraGLSurfaceView(context);
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(context, 1);
        viewGroup.addView(this.ipx, new LayoutParams(fromDPToPix, fromDPToPix));
        viewGroup.addView(this.ipy, new MarginLayoutParams(-1, -1));
        this.ipI = new g();
        this.ipI.ipU = this;
        this.ipy.setOnTouchListener(this.ipI);
        j.bae();
        x.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[]{context});
    }

    public final void a(MMSightRecordView$c mMSightRecordView$c) {
        this.ipJ = mMSightRecordView$c;
    }

    public final void R(float f) {
        x.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s", new Object[]{Float.valueOf(f)});
        this.ipu = f;
    }

    public final void jp(int i) {
        x.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[]{Integer.valueOf(i)});
        this.ipt = i;
    }

    public final void startPreview() {
        x.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[]{Float.valueOf(this.ipu), Integer.valueOf(this.ipt)});
        if (this.ipu > 0.0f && this.ipt > 0) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.ipt;
            videoTransPara.height = (int) (((float) this.ipt) / this.ipu);
            x.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[]{Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height)});
            this.ips = new e(videoTransPara, -1);
            this.ips.a(this);
            if (this.ips.i(this.context, this.ipw)) {
                x.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
                if (this.ipx.isAvailable()) {
                    if (this.ips.a(this.ipx.getSurfaceTexture(), this.ipt, this.ipu, this.ipB) < 0) {
                        x.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                        if (this.ipJ != null) {
                            this.ipJ.agh();
                        }
                    }
                    if (this.ipD != -1) {
                        Yi();
                    }
                    this.ips.aZY();
                    x.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
                    Yd();
                    return;
                }
                this.ipx.a(new 1(this));
                return;
            }
            x.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
            if (this.ipJ != null) {
                this.ipJ.agh();
            }
        }
    }

    public final void h(int i, int i2, int i3, int i4, int i5) {
        this.ipv = i;
        this.videoBitrate = 4800000;
        this.fps = 30;
        this.huc = 64000;
        this.audioSampleRate = 44100;
        x.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100)});
    }

    public final void oP(String str) {
        x.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[]{str});
        this.videoPath = str;
    }

    public final String Yb() {
        if (this.ipr == null || !this.ipz) {
            return this.videoPath;
        }
        return this.ipr.getFilePath();
    }

    public final void Yc() {
        Yd();
    }

    final void Yd() {
        if (this.ipz) {
            x.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
            return;
        }
        if (this.ipr != null) {
            x.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
            this.ipr.cancel();
            if (this.ips != null) {
                this.ips.b(this.ipr.bay());
            }
            this.ipr = null;
        }
        if (this.ipt > 0 && this.ipv > 0 && this.videoBitrate > 0 && this.fps > 0 && this.huc > 0 && this.audioSampleRate > 0 && this.ips != null && this.ips.osb != null) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.ipt;
            videoTransPara.height = (int) (((float) this.ipt) / this.ipu);
            videoTransPara.duration = this.ipv;
            videoTransPara.videoBitrate = this.videoBitrate;
            videoTransPara.fps = this.fps;
            videoTransPara.huc = this.huc;
            videoTransPara.audioSampleRate = this.audioSampleRate;
            videoTransPara.hue = 2;
            videoTransPara.huf = 1;
            videoTransPara.hud = 1;
            j.osX.oqJ = videoTransPara;
            j.osX.videoBitrate = this.videoBitrate;
            j.osX.orw = this.ipt;
            k.baK();
            this.ipr = k.c(videoTransPara);
            if (this.ipr == null) {
                x.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
                if (this.ipJ != null) {
                    this.ipJ.agh();
                    return;
                }
                return;
            }
            this.ipr.setFilePath(this.videoPath);
            if (this.ipB && this.ips != null && this.ips.orS) {
                Yg();
            }
            int i = this.ips.osb.x;
            int i2 = this.ips.osb.y;
            if (this.ipF != null && this.ipB) {
                i = this.ipF.x;
                i2 = this.ipF.y;
            }
            i2 = (int) (((float) i2) * this.ipL);
            i = com.tencent.mm.plugin.mmsight.d.sJ((int) (((float) i) * this.ipL));
            i2 = com.tencent.mm.plugin.mmsight.d.sJ(i2);
            x.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(this.ipL)});
            if (this.ipF == null || !this.ipB) {
                this.ipr.m(this.ips.aGM(), this.ips.aGN(), i, i2);
            } else {
                this.ipr.m(this.ipF.y, this.ipF.x, i, i2);
            }
            this.ipr.baG();
            this.ipr.a(this);
            if (this.ipr.sN(this.ips.getOrientation())) {
                this.ipz = true;
                return;
            }
            x.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
            if (this.ipJ != null) {
                this.ipJ.agh();
            }
        }
    }

    public final boolean vr() {
        x.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[]{this.ipr});
        Yd();
        if (this.ipr == null) {
            x.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
            return false;
        }
        x.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[]{Integer.valueOf(this.ipr.c(this.ips.getOrientation(), false, 0))});
        if (this.ipr.c(this.ips.getOrientation(), false, 0) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(final com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f fVar) {
        if (this.ipr != null) {
            x.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[]{fVar});
            this.ipr.a(new 2(this, fVar));
            this.ipr.C(new Runnable(this) {
                final /* synthetic */ f ipN;

                public final void run() {
                    this.ipN.ipz = false;
                    if (fVar != null) {
                        fVar.cJ(false);
                    }
                }
            });
            this.ipr = null;
        }
    }

    public final void a(MMSightRecordView$e mMSightRecordView$e, boolean z) {
        if (mMSightRecordView$e != null && this.ips != null && this.ips.orS) {
            if (z) {
                this.ips.bac();
            }
            if (z) {
                ag.h(new 4(this, mMSightRecordView$e, z), 100);
            } else {
                b(mMSightRecordView$e, z);
            }
        }
    }

    final void b(MMSightRecordView$e mMSightRecordView$e, boolean z) {
        this.ips.a(new 5(this, z, mMSightRecordView$e), false, 0);
    }

    public final void ck(boolean z) {
        x.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[]{Boolean.valueOf(z)});
        this.ipw = z;
    }

    public final Point Ye() {
        if (this.ips == null || !this.ips.orS) {
            return null;
        }
        if (!this.ipC) {
            return new Point(this.ips.aGM(), this.ips.aGN());
        }
        Yh();
        return this.ipE;
    }

    public final Point Yf() {
        if (this.ips == null || !this.ips.orS) {
            return null;
        }
        int i = this.ips.osb.x;
        int i2 = this.ips.osb.y;
        if (this.ipF != null && this.ipB) {
            i = this.ipF.x;
            i2 = this.ipF.y;
        }
        return new Point(com.tencent.mm.plugin.mmsight.d.sJ((int) (((float) i) * this.ipL)), com.tencent.mm.plugin.mmsight.d.sJ((int) (((float) i2) * this.ipL)));
    }

    public final void a(MMSightRecordView.a aVar) {
        this.ipA = aVar;
    }

    public final void switchCamera() {
        if (this.ips != null && this.ips.orS) {
            if (this.ipr == null || this.ipr.baz() != c.oua) {
                this.ips.a(this.context, this.ipx.getSurfaceTexture(), this.ipt, this.ipu, this.ipB);
            }
        }
    }

    public final void cl(boolean z) {
        this.ipB = true;
        if (this.ipB && this.ips != null && this.ips.orS) {
            Yg();
        }
    }

    private void Yg() {
        if (this.ips != null && this.ips.orS) {
            if (this.ips.osu) {
                this.ipF = new Point(com.tencent.mm.plugin.mmsight.d.cM((int) (((float) this.ips.aGM()) / this.ipu), this.ips.aGN()), this.ips.aGM());
                return;
            }
            this.ipF = new Point(this.ips.aGN(), com.tencent.mm.plugin.mmsight.d.cM((int) (((float) this.ips.aGN()) * this.ipu), this.ips.aGM()));
        }
    }

    public final void cm(boolean z) {
        this.ipC = true;
        if (this.ipC && this.ips != null && this.ips.orS) {
            Yh();
        }
    }

    final void Yh() {
        if (this.ips != null && this.ips.orS) {
            if (this.ips.osu) {
                this.ipE = new Point(this.ips.aGM(), (int) (((float) this.ips.aGM()) / this.ipu));
                return;
            }
            this.ipE = new Point((int) (((float) this.ips.aGN()) * this.ipu), this.ips.aGN());
        }
    }

    public final void jq(int i) {
        boolean z = true;
        this.ipD = i;
        String str = "MicroMsg.MMSightRecordViewImpl";
        String str2 = "setFlashMode: %s, camera: %s, previewing: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = this.ips;
        if (this.ips == null || !this.ips.orS) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.ips != null && this.ips.orS) {
            Yi();
        }
    }

    final void Yi() {
        x.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[]{Integer.valueOf(this.ipD)});
        switch (this.ipD) {
            case 1:
                this.ips.bac();
                return;
            case 2:
                this.ips.bad();
                return;
            case 3:
                e eVar = this.ips;
                x.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[]{eVar.gEB, Boolean.valueOf(eVar.orS)});
                if (eVar.gEB != null && eVar.orS) {
                    try {
                        eVar.osh = true;
                        Parameters parameters = eVar.gEB.getParameters();
                        if (bh.cA(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("auto")) {
                            x.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
                            return;
                        }
                        parameters.setFlashMode("auto");
                        eVar.gEB.setParameters(parameters);
                        x.i("MicroMsg.MMSightCamera", "auto flash");
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMSightCamera", e, "autoFlash error: %s", new Object[]{e.getMessage()});
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final int Yj() {
        return this.ipD;
    }

    public final void Yk() {
        x.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
        this.ipL = 0.5f;
    }

    public final void Yl() {
        x.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
        this.ipL = 0.75f;
    }

    public final Bitmap Ym() {
        if (this.ips == null || !this.ips.orS) {
            return null;
        }
        byte[] bArr;
        e eVar = this.ips;
        if (eVar.oss != null) {
            eVar.ost = true;
            bArr = new byte[eVar.oss.length];
            System.arraycopy(eVar.oss, 0, bArr, 0, eVar.oss.length);
            eVar.ost = false;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        byte[] h;
        byte[] bArr2;
        int aGM = this.ips.aGM();
        int aGN = this.ips.aGN();
        if (this.ips.osu) {
            int aGM2 = (int) (((float) this.ips.aGM()) / this.ipu);
            if (aGM2 < aGN) {
                if (this.ipB || this.ipM != null) {
                    h = com.tencent.mm.plugin.mmsight.model.a.j.ouM.h(Integer.valueOf(((this.ipF.x * this.ipF.y) * 3) >> 1));
                } else {
                    this.ipM = new byte[(((aGM * aGM2) * 3) >> 1)];
                    h = this.ipM;
                }
                SightVideoJNI.cropCameraDataLongEdge(bArr, h, aGN, this.ipF.x, aGM);
                if (this.ipB) {
                    aGM2 = this.ipF.x;
                }
                this.ipK = true;
            } else {
                h = bArr;
                aGM2 = aGN;
            }
            aGN = aGM2;
            bArr2 = h;
        } else {
            int i = (int) (((float) aGN) * this.ipu);
            if (i < aGM) {
                if (this.ipB || this.ipM != null) {
                    h = com.tencent.mm.plugin.mmsight.model.a.j.ouM.h(Integer.valueOf(((this.ipF.x * this.ipF.y) * 3) >> 1));
                } else {
                    this.ipM = new byte[(((i * aGN) * 3) >> 1)];
                    h = this.ipM;
                }
                SightVideoJNI.cropCameraData(bArr, h, aGN, aGM, this.ipF.y);
                aGM = this.ipF.y;
                this.ipK = true;
                bArr2 = h;
            } else {
                bArr2 = bArr;
            }
        }
        YuvImage yuvImage = new YuvImage(bArr2, 17, aGN, aGM, null);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, aGN, aGM), 100, byteArrayOutputStream);
        h = byteArrayOutputStream.toByteArray();
        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(h, 0, h.length);
        Bitmap b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) this.ips.getOrientation());
        decodeByteArray.recycle();
        return b;
    }

    public final void release() {
        x.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[]{this.ips, this.ipr});
        if (this.ips != null) {
            this.ips.aZX();
        }
        if (this.ipr != null) {
            this.ipr.C(null);
            this.ipr = null;
        }
        this.ipz = false;
        this.ipB = false;
        this.ipC = false;
        this.ipE = null;
        this.ipF = null;
        this.ipD = -1;
        this.ipG = true;
        this.ipH = true;
        com.tencent.mm.plugin.mmsight.model.a.j.ouM.Es();
    }

    public final boolean R(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        byte[] bArr2;
        boolean z;
        Object obj;
        if (this.ipu <= 0.0f || this.ipt <= 0 || this.ips == null) {
            bArr2 = bArr;
        } else {
            int i;
            int aGM = this.ips.aGM();
            int aGN = this.ips.aGN();
            int aGM2;
            byte[] h;
            if (this.ips.osu) {
                aGM2 = (int) (((float) this.ips.aGM()) / this.ipu);
                if (aGM2 < aGN) {
                    if (this.ipB || this.ipM != null) {
                        h = com.tencent.mm.plugin.mmsight.model.a.j.ouM.h(Integer.valueOf(((this.ipF.x * this.ipF.y) * 3) >> 1));
                    } else {
                        this.ipM = new byte[(((aGM * aGM2) * 3) >> 1)];
                        h = this.ipM;
                    }
                    bh.Wq();
                    SightVideoJNI.cropCameraDataLongEdge(bArr, h, aGN, this.ipF.x, aGM);
                    if (this.ipB) {
                        aGM2 = this.ipF.x;
                    }
                    this.ipK = true;
                } else {
                    aGM2 = aGN;
                    h = bArr;
                }
                aGN = aGM2;
                bArr2 = h;
                i = aGM;
            } else {
                i = (int) (((float) aGN) * this.ipu);
                if (i < aGM) {
                    if (this.ipB || this.ipM != null) {
                        h = com.tencent.mm.plugin.mmsight.model.a.j.ouM.h(Integer.valueOf(((this.ipF.x * this.ipF.y) * 3) >> 1));
                    } else {
                        this.ipM = new byte[(((i * aGN) * 3) >> 1)];
                        h = this.ipM;
                    }
                    bh.Wq();
                    SightVideoJNI.cropCameraData(bArr, h, aGN, aGM, this.ipF.y);
                    aGM2 = this.ipF.y;
                    this.ipK = true;
                    int i2 = aGM2;
                    bArr2 = h;
                    i = i2;
                } else {
                    i = aGM;
                    bArr2 = bArr;
                }
            }
            if (this.ipy != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.ipy;
                int orientation = this.ips.getOrientation();
                if (!(aGN == mMSightCameraGLSurfaceView.ioD && i == mMSightCameraGLSurfaceView.ioE && orientation == mMSightCameraGLSurfaceView.ioX)) {
                    x.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[]{Integer.valueOf(aGN), Integer.valueOf(i), Integer.valueOf(orientation), mMSightCameraGLSurfaceView});
                    mMSightCameraGLSurfaceView.ioD = aGN;
                    mMSightCameraGLSurfaceView.ioE = i;
                    mMSightCameraGLSurfaceView.ioX = orientation;
                }
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView2 = this.ipy;
                if (bArr2 == null || mMSightCameraGLSurfaceView2.ioV == null || mMSightCameraGLSurfaceView2.ioV.ioB) {
                    x.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    a aVar = mMSightCameraGLSurfaceView2.ioV;
                    orientation = mMSightCameraGLSurfaceView2.ioD;
                    int i3 = mMSightCameraGLSurfaceView2.ioE;
                    int i4 = mMSightCameraGLSurfaceView2.ioX;
                    Object obj2 = null;
                    try {
                        if (!(aVar.ioE == i3 && aVar.ioD == orientation && aVar.fFy == i4 && !aVar.ioU)) {
                            obj2 = 1;
                        }
                        if (obj2 != null) {
                            x.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[]{bArr2, Integer.valueOf(orientation), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(false), Boolean.valueOf(true), aVar});
                        }
                        aVar.ioC = bArr2;
                        aVar.ioD = orientation;
                        aVar.ioE = i3;
                        aVar.fFy = i4;
                        aVar.ioU = false;
                        if (obj2 != null) {
                            aVar.ioF = ByteBuffer.allocateDirect(i3 * orientation);
                            aVar.ioG = ByteBuffer.allocateDirect((orientation * i3) / 2);
                            aVar.ioF.order(ByteOrder.nativeOrder());
                            aVar.ioG.order(ByteOrder.nativeOrder());
                            aVar.ioT = a.iow;
                            if (aVar.ioT != null) {
                                aVar.ioP.put(aVar.ioT);
                                aVar.ioP.position(0);
                            }
                        }
                        if (!(aVar.ioF == null || aVar.ioG == null)) {
                            aVar.ioF.put(bArr2, 0, orientation * i3);
                            aVar.ioF.position(0);
                            aVar.ioG.put(bArr2, orientation * i3, (orientation * i3) / 2);
                            aVar.ioG.position(0);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[]{e.getMessage()});
                    }
                    mMSightCameraGLSurfaceView2.requestRender();
                }
            }
        }
        if (this.ipA != null) {
            if (this.ips.getOrientation() == 0 || this.ips.getOrientation() == 180) {
                this.ips.aGM();
            } else {
                this.ips.aGN();
            }
            if (this.ips.getOrientation() == 0 || this.ips.getOrientation() == 180) {
                this.ips.aGM();
            } else {
                this.ips.aGN();
            }
        }
        if (this.ipr == null || this.ipr.bay() == null) {
            z = true;
            obj = null;
        } else if (this.ipB && this.ipK) {
            z = this.ipr.bay().R(bArr2);
            obj = 1;
        } else {
            z = this.ipr.bay().R(bArr);
            obj = null;
        }
        if (obj == null) {
            return z;
        }
        if (this.ipr != null && this.ipr.baz() == c.oua) {
            return z;
        }
        com.tencent.mm.plugin.mmsight.model.a.j.ouM.D(bArr2);
        return z;
    }

    public final void Yn() {
        x.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[]{Integer.valueOf(1)});
        this.ipr.reset();
    }

    public final void Yo() {
        if (this.ips != null && this.ips.orS && this.ipH) {
            e eVar = this.ips;
            if (eVar.gEB != null && eVar.orS) {
                Parameters parameters = eVar.gEB.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                    x.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                    parameters.setFocusMode("auto");
                    eVar.gEB.setParameters(parameters);
                }
                eVar.gEB.cancelAutoFocus();
                eVar.gEB.autoFocus(new 3(eVar));
            }
        }
    }

    public final void Yp() {
        if (this.ips != null && this.ips.orS && this.ipG) {
            this.ips.b(true, false, 1);
        }
    }

    public final void Yq() {
        if (this.ips != null && this.ips.orS && this.ipG) {
            this.ips.b(false, false, 1);
        }
    }
}
