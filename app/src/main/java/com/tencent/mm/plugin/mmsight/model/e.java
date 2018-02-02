package com.tencent.mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import com.tencent.mm.compatible.d.d$a$a;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e implements SensorEventListener {
    private static int orU = Integer.MAX_VALUE;
    static boolean osw = true;
    private SensorManager bgR;
    public Camera gEB = null;
    private Context mContext = null;
    private int orN = -1;
    public int orO = -1;
    private p orP = p.bao();
    private boolean orQ = false;
    private boolean orR = false;
    public boolean orS = false;
    private int orT = 0;
    d$a$a orV;
    private Sensor orW;
    private float orX = 0.0f;
    private float orY = 0.0f;
    private float orZ = 0.0f;
    private Point osa = null;
    public Point osb = null;
    private Point osc = null;
    private int osd = 0;
    private byte[] ose;
    private boolean osf = false;
    private com.tencent.mm.plugin.base.model.a osg = new com.tencent.mm.plugin.base.model.a();
    public boolean osh = false;
    private List<f> osi = new ArrayList();
    private boolean osj = false;
    private a osk = a.Preview;
    private b osl = new b("prevcameraCallback");
    private b osm = new b("cameraCallback");
    private b osn = new b("cameraPreviewCallback");
    private b oso = new b("cameraCropCallback");
    private b osp = new b("mirrorCameraCallback");
    private b osq = new b("finishCallbackTimeCallback");
    private VideoTransPara osr;
    public volatile byte[] oss = null;
    public volatile boolean ost = false;
    public boolean osu = false;
    private boolean osv = false;
    AutoFocusCallback osx = new 2(this);
    public c osy = new c(this, Looper.getMainLooper());
    public boolean osz = true;
    private int scene = 0;

    public enum a {
        Preview,
        Recording,
        Stoping
    }

    public final void a(com.tencent.mm.plugin.mmsight.model.e.b r8, boolean r9, int r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r4 = 1;
        r6 = 0;
        r0 = "MicroMsg.MMSightCamera";
        r1 = "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s";
        r2 = 4;
        r2 = new java.lang.Object[r2];
        r2[r6] = r8;
        r3 = r7.oss;
        r2[r4] = r3;
        r3 = 2;
        r4 = java.lang.Boolean.valueOf(r9);
        r2[r3] = r4;
        r3 = 3;
        r4 = java.lang.Integer.valueOf(r10);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r7.oss;
        if (r0 == 0) goto L_0x0064;
    L_0x0026:
        r0 = 1;
        r7.ost = r0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = new android.graphics.Point;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.<init>();	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r7.osc;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        if (r1 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
    L_0x0032:
        r1 = r7.osc;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.x;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.x = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r7.osc;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.y;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.y = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
    L_0x003e:
        r1 = com.tencent.mm.plugin.mmsight.model.a.j.ouM;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r7.oss;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r2.length;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.h(r2);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r7.oss;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r4 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r5 = r7.oss;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r5 = r5.length;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        java.lang.System.arraycopy(r2, r3, r1, r4, r5);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r7.orV;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r4 = r2.fFy;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r0.x;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = r0.y;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = r8;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r5 = r10;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r7.ost = r6;
    L_0x0064:
        return;
    L_0x0065:
        r1 = r7.ose;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        if (r1 == 0) goto L_0x009d;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
    L_0x0069:
        r1 = r7.osf;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        if (r1 == 0) goto L_0x009d;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
    L_0x006d:
        r1 = r7.osb;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.x;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.x = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r7.osb;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.y;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.y = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        goto L_0x003e;
    L_0x007a:
        r0 = move-exception;
        r1 = "MicroMsg.MMSightCamera";	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = "takePicture error: %s";	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = 1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r4 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3[r4] = r0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r7.ost = r0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r4 = -1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r5 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = r8;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r7.ost = r6;
        goto L_0x0064;
    L_0x009d:
        r1 = r7.orP;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.mlb;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.x = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r7.orP;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.mlc;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.y = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        goto L_0x003e;
    L_0x00aa:
        r0 = move-exception;
        r7.ost = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.e.a(com.tencent.mm.plugin.mmsight.model.e$b, boolean, int):void");
    }

    static /* synthetic */ boolean a(e eVar, byte[] bArr) {
        bh.Wq();
        if (eVar.osi == null || eVar.osi.size() == 0) {
            return false;
        }
        boolean z = false;
        for (f R : eVar.osi) {
            z = R.R(bArr) | z;
        }
        return z;
    }

    public e(VideoTransPara videoTransPara, int i) {
        this.osr = videoTransPara;
        this.scene = i;
    }

    public final void a(f fVar) {
        if (fVar != null) {
            this.osi.add(fVar);
        }
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.osi.remove(fVar);
        }
    }

    public final void a(a aVar) {
        this.osk = aVar;
        if (aVar == a.Stoping) {
            a aZT = a.aZT();
            String aZV = this.osm.aZV();
            String aZV2 = this.osl.aZV();
            com.tencent.mm.plugin.base.model.a aVar2 = this.osg;
            int i = aVar2.kuA == 0 ? 0 : aVar2.kuz / aVar2.kuA;
            aZT.ors = (int) (bh.VK(aZV) * 10.0d);
            aZT.ort = (int) (bh.VK(aZV2) * 10.0d);
            aZT.orz = i;
        }
    }

    public final void aZX() {
        if (!(this.bgR == null || this.orW == null)) {
            this.bgR.unregisterListener(this);
        }
        x.i("MicroMsg.MMSightCamera", this.osl.getValue());
        x.i("MicroMsg.MMSightCamera", this.osm.getValue());
        x.i("MicroMsg.MMSightCamera", this.osn.getValue());
        x.i("MicroMsg.MMSightCamera", this.oso.getValue());
        x.i("MicroMsg.MMSightCamera", this.osp.getValue());
        x.i("MicroMsg.MMSightCamera", this.osq.getValue());
        if (this.gEB != null) {
            long Wq = bh.Wq();
            x.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[]{Looper.myLooper()});
            this.osy.removeCallbacksAndMessages(null);
            this.osy.osH = true;
            this.gEB.setPreviewCallback(null);
            this.gEB.stopPreview();
            this.gEB.release();
            this.gEB = null;
            this.orS = false;
            x.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[]{Long.valueOf(bh.bA(Wq)), Looper.myLooper()});
        }
        this.orQ = false;
        this.orX = 0.0f;
        this.orY = 0.0f;
        this.orZ = 0.0f;
        osw = true;
        this.mContext = null;
        this.osv = false;
        this.osb = null;
        this.osc = null;
        this.oss = null;
        this.osj = false;
    }

    private boolean a(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            a aZT;
            boolean z2;
            int i;
            Parameters parameters = camera.getParameters();
            Point db = d.db(this.mContext);
            List supportedPreviewSizes;
            List supportedPictureSizes;
            int i2;
            if (this.osz) {
                aZT = a.aZT();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i2 = this.orV.fFy;
                if (bh.ov(aZT.ori)) {
                    aZT.ori = d.bg(supportedPreviewSizes);
                }
                if (bh.ov(aZT.orj)) {
                    aZT.orj = d.bg(supportedPictureSizes);
                }
                aZT.fFy = i2;
                aZT.orE = 1;
            } else {
                aZT = a.aZT();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i2 = this.orV.fFy;
                if (bh.ov(aZT.ork)) {
                    aZT.ork = d.bg(supportedPreviewSizes);
                }
                if (bh.ov(aZT.orl)) {
                    aZT.orl = d.bg(supportedPictureSizes);
                }
                aZT.fFy = i2;
                aZT.orE = 2;
            }
            if (z) {
                z2 = this.orV.fFy == 90 || this.orV.fFy == 270;
                j.a(parameters, z2);
            }
            k.baK();
            int baM = k.baM();
            z2 = this.orV.fFy == 90 || this.orV.fFy == 270;
            b b = g.b(parameters, db, baM, z2);
            j.a(b);
            Point point = b.osL;
            if (point == null) {
                g.pQN.a(440, 140, 0, false);
            }
            if (point != null) {
                this.orP.mlb = point.x;
                this.orP.mlc = point.y;
                this.osb = point;
            }
            Context context = this.mContext;
            z2 = this.orV.fFy == 90 || this.orV.fFy == 270;
            boolean a = d.a(context, point, z2);
            x.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[]{Boolean.valueOf(a)});
            if (a) {
                if (j.osX.gGj == 2) {
                    this.osc = b.osN;
                } else {
                    this.osc = b.osM;
                }
                this.osb = new Point(this.osc.x, this.osc.y);
                this.osd = ((this.osc.x * this.osc.y) * 3) / 2;
                x.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[]{this.osc});
            }
            if (j.osX.oti) {
                Object obj = 1;
                if (this.orV.fFy == 90 || this.orV.fFy == 270) {
                    if (point.y < this.osr.width || point.x < this.osr.height) {
                        obj = null;
                        x.w("MicroMsg.MMSightCamera", "previewSize %s not support", new Object[]{point});
                    }
                    if (obj != null) {
                        if (j.osX.orw == 1080) {
                            this.osb = new Point(d.cM(this.osc == null ? point.x / 2 : this.osc.x / 2, this.osc == null ? point.x : this.osc.x), d.cM(this.osc == null ? point.y / 2 : this.osc.y / 2, this.osc == null ? point.y : this.osc.y));
                        } else if (j.osX.orw == 720) {
                            this.osb = new Point(d.cM((int) (this.osc == null ? ((float) point.x) * 0.75f : ((float) this.osc.x) * 0.75f), this.osc == null ? point.x : this.osc.x), d.cM((int) (this.osc == null ? ((float) point.y) * 0.75f : ((float) this.osc.y) * 0.75f), this.osc == null ? point.y : this.osc.y));
                        }
                    }
                } else {
                    if (point.x < this.osr.width || point.y < this.osr.height) {
                        obj = null;
                        x.w("MicroMsg.MMSightCamera", "previewSize %s not support", new Object[]{point});
                    }
                    if (obj != null) {
                        if (j.osX.orw == 1080) {
                            this.osb = new Point(d.cM(this.osc == null ? point.y / 2 : this.osc.y / 2, this.osc == null ? point.y : this.osc.y), d.cM(this.osc == null ? point.x / 2 : this.osc.x / 2, this.osc == null ? point.x : this.osc.x));
                        } else if (j.osX.orw == 720) {
                            baM = (int) (this.osc == null ? ((float) point.x) * 0.75f : ((float) this.osc.x) * 0.75f);
                            int cM = d.cM((int) (this.osc == null ? ((float) point.y) * 0.75f : ((float) this.osc.y) * 0.75f), this.osc == null ? point.y : this.osc.y);
                            if (this.osc == null) {
                                i = point.x;
                            } else {
                                i = this.osc.x;
                            }
                            this.osb = new Point(cM, d.cM(baM, i));
                        }
                    }
                }
            }
            aZT = a.aZT();
            db = this.osc;
            Point point2 = this.osb;
            aZT.orr = -1;
            aZT.orq = -1;
            aZT.orn = -1;
            aZT.orm = -1;
            aZT.orp = -1;
            aZT.oro = -1;
            if (point != null) {
                aZT.oro = point.x;
                aZT.orp = point.y;
            }
            if (db != null) {
                aZT.orm = db.x;
                aZT.orn = db.y;
            }
            if (point2 != null) {
                aZT.orq = point2.x;
                aZT.orr = point2.y;
            }
            if (z) {
                if (a || j.osX.gGj != 2 || d.sI(this.osb.y)) {
                    j.d(this.osb);
                } else {
                    i = d.sJ(this.osb.y);
                    if (Math.abs(i - this.osb.y) <= 16) {
                        x.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[]{this.osb, Integer.valueOf(i)});
                        this.osa = new Point(this.osb.x, this.osb.y);
                        this.osb.y = i;
                        this.osf = true;
                        this.ose = new byte[(((this.osb.x * this.osb.y) * 3) / 2)];
                    } else {
                        j.d(this.osb);
                    }
                }
            } else if (!a && j.osX.gGj == 2 && !d.sI(this.osb.y) && this.osf && this.ose != null && this.osa.y == this.osb.y) {
                i = d.sJ(this.osb.y);
                if (this.ose.length == ((this.osb.x * i) * 3) / 2) {
                    this.osb.y = i;
                }
            }
            x.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[]{point, this.osb, this.osc});
            parameters.setPreviewSize(this.orP.mlb, this.orP.mlc);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    private boolean a(Camera camera, int i, float f, boolean z) {
        if (camera == null || i <= 0) {
            return false;
        }
        try {
            int i2;
            Parameters parameters = camera.getParameters();
            Point point = new Point(i, (int) (((float) i) / f));
            Point fz = ae.fz(ac.getContext());
            float min = ((float) Math.min(fz.x, fz.y)) / ((float) Math.max(fz.x, fz.y));
            float f2 = 1.0f / f;
            if (f < 1.0f) {
                i2 = i;
            } else {
                i2 = Math.round(((float) i) / f2);
            }
            x.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(min)});
            boolean z2 = this.orV.fFy == 90 || this.orV.fFy == 270;
            b a = g.a(parameters, fz, i2, z2);
            if (a == null || a.osL == null) {
                x.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                z2 = this.orV.fFy == 90 || this.orV.fFy == 270;
                a = g.c(parameters, fz, i, z2);
                this.osu = false;
            }
            if (!(a == null || a.osL == null)) {
                x.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[]{a.osL, Integer.valueOf((int) (((float) a.osL.x) * f))});
                if (((int) (((float) a.osL.x) * f)) <= a.osL.y) {
                    this.osu = false;
                } else {
                    this.osu = true;
                }
            }
            if (!(a == null || a.osL == null)) {
                point = a.osL;
                this.orP.mlb = point.x;
                this.orP.mlc = point.y;
                this.osb = point;
                this.osc = null;
                if (!z) {
                    if (j.osX.gGj != 2 || d.sI(this.osb.y)) {
                        j.d(this.osb);
                    } else {
                        i2 = d.sJ(this.osb.y);
                        if (Math.abs(i2 - this.osb.y) <= 16) {
                            x.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[]{this.osb, Integer.valueOf(i2)});
                            this.osa = new Point(this.osb.x, this.osb.y);
                            this.osb.y = i2;
                            this.osf = true;
                            this.ose = new byte[(((this.osb.x * this.osb.y) * 3) / 2)];
                        } else {
                            j.d(this.osb);
                        }
                    }
                }
                x.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[]{point, this.osb, this.osc, Boolean.valueOf(this.osu)});
                parameters.setPreviewSize(this.orP.mlb, this.orP.mlc);
                camera.setParameters(parameters);
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    @TargetApi(14)
    private static boolean a(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
            Parameters parameters = camera.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(DownloadResult.CODE_UNDEFINED, DownloadResult.CODE_UNDEFINED, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    private static boolean b(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            int i;
            if (z) {
                if (q.gFU.gEg > 0) {
                    x.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
                } else if (parameters == null) {
                    x.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
                } else {
                    try {
                        Collection supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                        if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                            parameters.setPreviewFrameRate(Math.min(30, ((Integer) Collections.max(supportedPreviewFrameRates)).intValue()));
                            x.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[]{Integer.valueOf(i)});
                        }
                    } catch (Exception e) {
                        x.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
                    }
                }
            } else if (q.gFU.gEg > 0) {
                x.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
            } else {
                List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                    int i2 = Integer.MIN_VALUE;
                    int i3 = Integer.MIN_VALUE;
                    Object obj = null;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2;
                        int i5;
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i6 = iArr[0];
                            i = iArr[1];
                            x.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i)});
                            if (i6 >= 0 && i >= i6) {
                                if (i >= i3 && obj == null) {
                                    i3 = i;
                                    i2 = i6;
                                }
                                if (i >= 30000) {
                                    obj2 = 1;
                                    i5 = i3;
                                    i3 = i2;
                                    i4++;
                                    i2 = i3;
                                    i3 = i5;
                                    obj = obj2;
                                }
                            }
                        }
                        obj2 = obj;
                        i5 = i3;
                        i3 = i2;
                        i4++;
                        i2 = i3;
                        i3 = i5;
                        obj = obj2;
                    }
                    x.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30)});
                    if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            x.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                        } catch (Exception e2) {
                            x.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[]{Looper.myLooper(), e2.getMessage()});
                        }
                    }
                }
            }
            List supportedPreviewFrameRates2 = parameters.getSupportedPreviewFrameRates();
            x.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[]{Boolean.valueOf(z), supportedPreviewFrameRates2});
            camera.setParameters(parameters);
            return true;
        } catch (Exception e22) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[]{Looper.myLooper(), e22.getMessage()});
            return false;
        }
    }

    private static boolean b(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
            Parameters parameters = camera.getParameters();
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                x.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    private static boolean c(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                x.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            } else if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-video")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        x.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                x.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
            } else {
                x.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                parameters.setFocusMode("continuous-video");
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    public final void aZY() {
        x.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
        if (this.gEB != null && this.orS) {
            try {
                Parameters parameters = this.gEB.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                    x.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                    parameters.setFocusMode("continuous-picture");
                }
                this.gEB.setParameters(parameters);
            } catch (Exception e) {
                x.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void aZZ() {
        if (this.gEB != null) {
            try {
                Parameters parameters = this.gEB.getParameters();
                x.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.orP.mlb * this.orP.mlc)) / 8;
                for (int i = 0; i < 5; i++) {
                    this.gEB.addCallbackBuffer(j.ouM.h(Integer.valueOf(bitsPerPixel)));
                }
                this.osl.reset();
                this.osm.reset();
                this.osn.reset();
                this.oso.reset();
                this.osp.reset();
                this.osq.reset();
                this.osg = new com.tencent.mm.plugin.base.model.a();
                this.gEB.setPreviewCallbackWithBuffer(new 1(this));
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    @TargetApi(11)
    public final int a(SurfaceTexture surfaceTexture, boolean z) {
        long Wq = bh.Wq();
        this.osj = false;
        x.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[]{Boolean.valueOf(this.orS), Looper.myLooper(), surfaceTexture, Boolean.valueOf(z)});
        if (this.orS) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
        x.i("MicroMsg.MMSightCamera", "this texture %s", new Object[]{surfaceTexture});
        try {
            Integer valueOf;
            boolean z2;
            a(this.gEB, z);
            Integer valueOf2 = Integer.valueOf(0);
            if (k.baK().ouO != null) {
                valueOf = Integer.valueOf(k.baK().ouO.oqR);
            } else {
                valueOf = valueOf2;
            }
            String str = "MicroMsg.MMSightCamera";
            String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
            Object[] objArr = new Object[6];
            objArr[0] = valueOf;
            String str3 = q.gFU.gEl == 1 ? "Range" : q.gFU.gEk == 1 ? "Fix" : "Error";
            objArr[1] = str3;
            objArr[2] = Boolean.valueOf(q.gFU.gEm == 1);
            if (q.gFU.gEn == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[3] = Boolean.valueOf(z2);
            if (q.gFU.gEo == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[4] = Boolean.valueOf(z2);
            if (q.gFU.gEp == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[5] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            if (q.gFU.gEl == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                b(this.gEB, false);
            } else if (q.gFU.gEk == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                b(this.gEB, true);
            }
            if (q.gFU.gEm == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                b(this.gEB);
            }
            if (q.gGb.gGr != -1 && q.gGb.gGr == 1 && com.tencent.mm.compatible.util.d.fO(14)) {
                a(this.gEB);
            }
            if (q.gFU.gEo == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                c(this.gEB);
            }
            if (q.gFU.gEp == 1 && valueOf.intValue() != 0) {
                valueOf.intValue();
            }
            d(this.gEB);
            aZZ();
            this.gEB.setPreviewTexture(surfaceTexture);
            this.gEB.startPreview();
            if (!j.osX.otj) {
                this.bgR.registerListener(this, this.orW, 2);
            } else if (!(q.gFU.gEo != 0 || this.bgR == null || this.orW == null)) {
                this.bgR.registerListener(this, this.orW, 2);
            }
            this.orS = true;
            x.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[]{Long.valueOf(bh.bA(Wq)), Looper.myLooper()});
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public final int a(SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        long Wq = bh.Wq();
        this.osj = false;
        x.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[]{Boolean.valueOf(this.orS), Looper.myLooper(), surfaceTexture});
        if (this.orS) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
        x.i("MicroMsg.MMSightCamera", "this texture %s", new Object[]{surfaceTexture});
        try {
            Integer valueOf;
            a(this.gEB, i, f, z);
            Integer valueOf2 = Integer.valueOf(0);
            if (k.baK().ouO != null) {
                valueOf = Integer.valueOf(k.baK().ouO.oqR);
            } else {
                valueOf = valueOf2;
            }
            String str = "MicroMsg.MMSightCamera";
            String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
            Object[] objArr = new Object[6];
            objArr[0] = valueOf;
            String str3 = q.gFU.gEl == 1 ? "Range" : q.gFU.gEk == 1 ? "Fix" : "Error";
            objArr[1] = str3;
            objArr[2] = Boolean.valueOf(q.gFU.gEm == 1);
            objArr[3] = Boolean.valueOf(q.gFU.gEn == 1);
            objArr[4] = Boolean.valueOf(q.gFU.gEo == 1);
            objArr[5] = Boolean.valueOf(q.gFU.gEp == 1);
            x.i(str, str2, objArr);
            if (q.gFU.gEl == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                b(this.gEB, false);
            } else if (q.gFU.gEk == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                b(this.gEB, true);
            }
            if (q.gFU.gEm == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                b(this.gEB);
            }
            if (q.gGb.gGr != -1 && q.gGb.gGr == 1 && com.tencent.mm.compatible.util.d.fO(14)) {
                a(this.gEB);
            }
            if (q.gFU.gEo == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                c(this.gEB);
            }
            if (q.gFU.gEp == 1 && valueOf.intValue() != 0) {
                valueOf.intValue();
            }
            d(this.gEB);
            aZZ();
            this.gEB.setPreviewTexture(surfaceTexture);
            this.gEB.startPreview();
            if (!j.osX.otj) {
                this.bgR.registerListener(this, this.orW, 2);
            } else if (!(q.gFU.gEo != 0 || this.bgR == null || this.orW == null)) {
                this.bgR.registerListener(this, this.orW, 2);
            }
            this.orS = true;
            x.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[]{Long.valueOf(bh.bA(Wq)), Looper.myLooper()});
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    private static void d(Camera camera) {
        try {
            Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            camera.setParameters(parameters);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[]{e.getMessage()});
        }
    }

    private void baa() {
        if (true != this.osv && this.mContext != null) {
            if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.e.b.za()) {
                com.tencent.mm.sdk.b.b lpVar = new lp();
                lpVar.fDc.type = 2;
                com.tencent.mm.sdk.b.a.xef.m(lpVar);
                if (lpVar.fDd.fDb) {
                    this.osv = true;
                    return;
                }
                i h = h.h(this.mContext, com.tencent.mm.plugin.t.a.a.oEk, com.tencent.mm.plugin.t.a.a.dGO);
                if (h != null) {
                    h.setCancelable(false);
                    h.setCanceledOnTouchOutside(false);
                    h.show();
                    this.osv = true;
                }
            }
        }
    }

    public final String bab() {
        if (this.gEB == null) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList a = d.a(this.gEB.getParameters());
            Point db = d.db(this.mContext);
            stringBuffer.append(String.format("Screen size %d %d r:%.4f\n", new Object[]{Integer.valueOf(db.x), Integer.valueOf(db.y), Double.valueOf((((double) db.x) * 1.0d) / ((double) db.y))}));
            Iterator it = a.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if ((aGM() == size.width && aGN() == size.height) || (aGM() == size.height && aGN() == size.width)) {
                    stringBuffer.append(String.format("%s*%s √ r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                } else {
                    stringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                }
            }
            if (this.osc != null) {
                stringBuffer.append("\nSIGHTCROPMODE:  " + this.osc.x + " " + this.osc.y + " from " + this.orP.mlb + " " + this.orP.mlc);
            } else {
                stringBuffer.append("\nFinalPreviewSize: " + aGM() + " " + aGN());
            }
            stringBuffer.append("\ngetOrientation:" + getOrientation());
            stringBuffer.append("\nrecorderOption: " + q.gGb.gGq);
            return stringBuffer.toString();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.orX - f) > 5.0f || Math.abs(this.orY - f2) > 5.0f || Math.abs(this.orZ - f3) > 5.0f) {
            x.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[]{Float.valueOf(5.0f), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            this.osy.e(this.gEB);
            this.orX = f;
            this.orY = f2;
            this.orZ = f3;
        }
    }

    public final void b(boolean z, boolean z2, int i) {
        if (this.gEB != null && this.orS) {
            try {
                x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[]{Boolean.valueOf(z)});
                if (this.orR) {
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
                    return;
                }
                Parameters parameters = this.gEB.getParameters();
                if (parameters.isZoomSupported()) {
                    int i2;
                    this.orR = true;
                    int zoom = parameters.getZoom();
                    int maxZoom = parameters.getMaxZoom();
                    if (!z2) {
                        if (this.orN <= 0) {
                            this.orN = Math.round(((float) maxZoom) / 15.0f);
                            if (this.orN > 5) {
                                this.orN = 5;
                            }
                        }
                        i2 = this.orN;
                    } else if (this.orO <= 0) {
                        x.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[]{Integer.valueOf(this.orO)});
                        this.orR = false;
                        return;
                    } else {
                        i2 = this.orO;
                    }
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[]{Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.orN), Integer.valueOf(this.orO), Integer.valueOf(i)});
                    if (i > 0) {
                        i2 *= i;
                    }
                    if (z) {
                        if (zoom >= maxZoom) {
                            this.orR = false;
                            return;
                        }
                        i2 += zoom;
                        if (i2 < maxZoom) {
                            maxZoom = i2;
                        }
                    } else if (zoom == 0) {
                        this.orR = false;
                        return;
                    } else {
                        maxZoom = zoom - i2;
                        if (maxZoom <= 0) {
                            maxZoom = 0;
                        }
                    }
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[]{Integer.valueOf(maxZoom)});
                    parameters.setZoom(maxZoom);
                    this.gEB.setParameters(parameters);
                }
                this.orR = false;
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[]{e.getMessage()});
            } finally {
                this.orR = false;
            }
        }
    }

    public final boolean i(Context context, boolean z) {
        if (!j.osX.otj || (q.gFU.gEo == 0 && this.bgR == null && this.orW == null)) {
            this.bgR = (SensorManager) context.getSystemService("sensor");
            this.orW = this.bgR.getDefaultSensor(1);
        }
        if (this.gEB == null) {
            aZX();
            this.osz = z;
            if (z) {
                try {
                    this.orT = com.tencent.mm.compatible.d.d.yk();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMSightCamera", e, "try to get cameraid error %s, useBackCamera: %s", new Object[]{e.getMessage(), Boolean.valueOf(this.osz)});
                    this.orT = 0;
                }
            } else {
                int numberOfCameras = Camera.getNumberOfCameras();
                CameraInfo cameraInfo = new CameraInfo();
                int i = 0;
                while (i < numberOfCameras) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        x.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[]{Integer.valueOf(i)});
                        break;
                    }
                    i++;
                }
                i = 0;
                x.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[]{Integer.valueOf(i)});
                this.orT = i;
            }
            x.i("MicroMsg.MMSightCamera", "use camera id %d, DeviceInfo id %d", new Object[]{Integer.valueOf(this.orT), Integer.valueOf(q.gFU.gEr)});
            this.osv = false;
            this.mContext = context;
            this.orV = new n().o(context, this.orT);
            x.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[]{Looper.myLooper()});
            if (this.orV == null) {
                x.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[]{Looper.myLooper()});
                baa();
                return false;
            }
            this.gEB = this.orV.gEB;
            this.osy.osH = false;
            this.orP.fFy = this.orV.fFy;
            if (this.gEB == null) {
                x.e("MicroMsg.MMSightCamera", "start camera FAILED!");
                baa();
                return false;
            }
        }
        return true;
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, boolean z) {
        x.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[]{Boolean.valueOf(this.osz)});
        try {
            aZX();
            i(context, !this.osz);
            a(surfaceTexture, z);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[]{e});
            return false;
        }
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        x.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[]{Boolean.valueOf(this.osz)});
        try {
            aZX();
            i(context, !this.osz);
            a(surfaceTexture, i, f, z);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[]{e});
            return false;
        }
    }

    public final void bac() {
        x.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[]{this.gEB, Boolean.valueOf(this.orS)});
        if (this.gEB != null && this.orS) {
            try {
                this.osh = true;
                Parameters parameters = this.gEB.getParameters();
                if (bh.cA(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                    x.i("MicroMsg.MMSightCamera", "camera not support flash!!");
                    return;
                }
                parameters.setFlashMode("torch");
                this.gEB.setParameters(parameters);
                x.i("MicroMsg.MMSightCamera", "open flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightCamera", e, "openFlash error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void bad() {
        x.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[]{this.gEB, Boolean.valueOf(this.orS)});
        if (this.gEB != null && this.orS) {
            try {
                this.osh = false;
                Parameters parameters = this.gEB.getParameters();
                if (bh.cA(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    x.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
                    return;
                }
                parameters.setFlashMode("off");
                this.gEB.setParameters(parameters);
                x.i("MicroMsg.MMSightCamera", "close flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightCamera", e, "closeFlash error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final int aGM() {
        if (this.gEB == null || this.orV == null) {
            return 0;
        }
        try {
            return (!this.osf || this.ose == null) ? this.osc == null ? (this.orV.fFy == 0 || this.orV.fFy == 180) ? this.orP.mlb : this.orP.mlc : (this.orV.fFy == 0 || this.orV.fFy == 180) ? this.osc.x : this.osc.y : (this.orV.fFy == 0 || this.orV.fFy == 180) ? this.osb.x : this.osb.y;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public final int aGN() {
        if (this.gEB == null || this.orV == null) {
            return 0;
        }
        try {
            return (!this.osf || this.ose == null) ? this.osc == null ? (this.orV.fFy == 0 || this.orV.fFy == 180) ? this.orP.mlc : this.orP.mlb : (this.orV.fFy == 0 || this.orV.fFy == 180) ? this.osc.y : this.osc.x : (this.orV.fFy == 0 || this.orV.fFy == 180) ? this.osb.y : this.osb.x;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public final int getOrientation() {
        if (this.orV == null || !this.orS) {
            return -1;
        }
        return this.orV.fFy;
    }
}
