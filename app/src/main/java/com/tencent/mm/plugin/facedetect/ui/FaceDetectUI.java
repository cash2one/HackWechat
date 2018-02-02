package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.c.b;
import com.tencent.mm.plugin.facedetect.c.e;
import com.tencent.mm.plugin.facedetect.e.a.1;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.h$a;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView.4;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI extends MMActivity implements e, com.tencent.mm.plugin.facedetect.views.a {
    private String gAb = null;
    boolean lMx = false;
    private int meK = -1;
    private com.tencent.mm.plugin.facedetect.c.a mjA = null;
    private a mjB = null;
    private b mjC = null;
    private boolean mjD = false;
    h mkb = null;
    private b mkc = null;
    private boolean mkd = false;
    private boolean mke = false;
    private View mkf = null;
    private RelativeLayout mkg;
    FaceDetectView mkh = null;
    FaceScanRect mki = null;
    private TextView mkj = null;
    private Button mkk = null;
    private FaceDetectProcessService mkl = null;
    private ServiceConnection mkm = null;
    private boolean mkn = false;
    private boolean mko = false;
    private c mkp = null;
    private WakeLock wakeLock = null;

    private interface a {
        void onFinish();
    }

    static /* synthetic */ void e(FaceDetectUI faceDetectUI) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo start");
        faceDetectUI.aGl();
    }

    static /* synthetic */ void f(FaceDetectUI faceDetectUI) {
        x.v("MicroMsg.FaceDetectUI", "alvinluo onPreviewDone");
        if (com.tencent.mm.plugin.facedetect.e.a.aHt().mkZ) {
            com.tencent.mm.plugin.facedetect.e.a aHt = com.tencent.mm.plugin.facedetect.e.a.aHt();
            int rotation = faceDetectUI.mkh.mms.mlY.getRotation();
            int aGM = faceDetectUI.mkh.mms.mlY.aGM();
            int aHF = faceDetectUI.mkh.aHF();
            int i = faceDetectUI.mkh.mms.mlY.aHD().x;
            int aHF2 = faceDetectUI.mkh.aHF();
            x.i("MicroMsg.FaceVideoRecorder", "hy: init record");
            x.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d", new Object[]{Integer.valueOf(rotation), Integer.valueOf(aGM), Integer.valueOf(aHF), Boolean.valueOf(false), Integer.valueOf(0)});
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.isDefault = true;
            videoTransPara.width = aHt.mlb;
            videoTransPara.height = aHt.mlc;
            videoTransPara.fps = 30;
            videoTransPara.videoBitrate = 1200000;
            videoTransPara.hud = 1;
            videoTransPara.huc = 64000;
            videoTransPara.hue = 2;
            videoTransPara.huf = 1;
            videoTransPara.audioSampleRate = 16000;
            videoTransPara.duration = 15;
            aHt.mle.a(aHt.mfB, videoTransPara);
            aHt.mkR.F(new 1(aHt, rotation, aHF, aGM, false, 0, i, aHF2));
        }
        faceDetectUI.mkh.g(false, faceDetectUI.gAb);
        ag.h(new 6(faceDetectUI), 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        this.gAb = getIntent().getStringExtra("k_user_name");
        this.mjD = getIntent().getBooleanExtra("k_need_signature", false);
        this.meK = getIntent().getIntExtra("k_server_scene", -1);
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.aGK().a(faceDetectReporter);
        }
        int i = b.mfE;
        this.mjA = b.a(this, this, this.meK, getIntent().getExtras());
        n.p(this);
        this.mkk = (Button) findViewById(com.tencent.mm.plugin.facedetect.a.e.csK);
        this.mkk.setOnClickListener(new 1(this));
        this.mkf = findViewById(com.tencent.mm.plugin.facedetect.a.e.mcV);
        this.mkf.setVisibility(8);
        this.mkg = (RelativeLayout) findViewById(com.tencent.mm.plugin.facedetect.a.e.mcZ);
        this.mki = (FaceScanRect) findViewById(com.tencent.mm.plugin.facedetect.a.e.mcY);
        this.mkh = (FaceDetectView) findViewById(com.tencent.mm.plugin.facedetect.a.e.mcX);
        this.mkj = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.mcS);
        this.mkh.mmw = this;
        FaceDetectView faceDetectView = this.mkh;
        ViewGroup viewGroup = this.mkg;
        ViewGroup viewGroup2 = this.mki.mnC;
        faceDetectView.mmu = viewGroup;
        faceDetectView.mmv = viewGroup2;
        this.mkh.mkj = this.mkj;
        this.mkh.g(true, this.gAb);
        this.mki.mnB = new 3(this);
        this.mki.setVisibility(4);
        this.mkc = new b(this, (byte) 0);
    }

    private void aDT() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[]{Boolean.valueOf(this.mkn)});
        if (this.mkn) {
            x.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
            unbindService(this.mkm);
            this.mkn = false;
        }
    }

    public final void aGq() {
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
        }
        if (!this.wakeLock.isHeld()) {
            x.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
            this.wakeLock.acquire();
        }
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("key_face_service_connection_from", 2);
        this.mkm = new 4(this);
        x.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
        bindService(intent, this.mkm, 1);
    }

    protected void onStop() {
        super.onStop();
        x.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
        aDT();
        if (this.mko) {
            finish();
        } else {
            b(1, 90006, "cancel with on stop", null);
        }
    }

    protected final int getLayoutId() {
        return g.mdK;
    }

    public final void aGl() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.9f) {
            attributes.screenBrightness = 0.9f;
            getWindow().setAttributes(attributes);
        }
        this.mki.mnE = com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.mnH;
        FaceScanRect faceScanRect = this.mki;
        if (faceScanRect.mnE == com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.mnF) {
            x.w("MicroMsg.FaceScanRect", "hy: already opened");
        } else {
            faceScanRect.mnD.setVisibility(0);
            faceScanRect.mnm.setBackgroundResource(d.mcP);
            faceScanRect.mnD.startAnimation(faceScanRect.mnA);
            for (View view : faceScanRect.mnv) {
                view.clearAnimation();
                view.setBackgroundColor(faceScanRect.getResources().getColor(com.tencent.mm.plugin.facedetect.a.b.white));
            }
            faceScanRect.mnE = com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.mnF;
        }
        this.mkh.mmt.mmn = false;
        this.mki.setVisibility(0);
        x.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[]{Integer.valueOf(this.mki.getTop()), Integer.valueOf(this.mki.getRight()), Integer.valueOf(this.mki.getLeft()), Integer.valueOf(this.mki.getBottom())});
        this.mkd = true;
        this.lMx = false;
        this.mkc.reset();
        if (this.mkd) {
            this.mkp = new 5(this);
            x.i("MicroMsg.FaceDetectUI", "hy: start preview");
            c cVar = this.mkp;
            FaceDetectView faceDetectView = this.mkh;
            faceDetectView.mms.a(new 4(faceDetectView, cVar));
        }
    }

    public final void aGn() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
        if (!this.mke) {
            this.mkp = null;
            this.mke = true;
            if (this.mkc.mkx) {
                aHo();
                this.mkh.mms.mlY.aHB();
            }
            if (this.wakeLock != null && this.wakeLock.isHeld()) {
                this.wakeLock.release();
                this.wakeLock = null;
            }
            com.tencent.mm.sdk.f.e.post(new 2(this), "Face_active_gc");
        }
        aDT();
    }

    public final void b(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 0 && i2 != 0 && com.tencent.mm.plugin.facedetect.e.a.aHt().isStarted() && com.tencent.mm.plugin.facedetect.e.a.aHt().mkZ) {
            com.tencent.mm.plugin.facedetect.e.a.aHt().aHv();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_parcelable_reporter", FaceDetectReporter.aGK());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("err_type", i);
        bundle3.putInt("err_code", i2);
        bundle3.putString("err_msg", str);
        bundle3.putAll(bundle2);
        Intent intent = new Intent();
        intent.putExtras(bundle3);
        setResult(-1, intent);
        finish();
    }

    final void aHn() {
        if (this.lMx) {
            x.i("MicroMsg.FaceDetectUI", "hy: start capture face");
            FaceDetectView faceDetectView = this.mkh;
            Rect rect = new Rect(this.mki.getLeft(), this.mki.getTop(), this.mki.getRight(), this.mki.getBottom());
            h$a aGJ = h.aGJ();
            if (aGJ.type != 100) {
                if (faceDetectView.mmx != null) {
                    faceDetectView.mmx.aGW();
                }
                faceDetectView.kMn = false;
                faceDetectView.isPaused = false;
                faceDetectView.mmD = bh.Wq();
                faceDetectView.mmB = aGJ.mgp;
                faceDetectView.mmA = aGJ.imS;
                faceDetectView.mgq = aGJ.mgq;
                faceDetectView.mmy = true;
                faceDetectView.mmC = aGJ.mgt;
                faceDetectView.mmx = com.tencent.mm.plugin.facedetect.d.b.c.a(aGJ);
                if (faceDetectView.mmx != null) {
                    if (faceDetectView.mmu != null) {
                        faceDetectView.mmu.removeAllViews();
                    }
                    if (faceDetectView.mmv != null) {
                        faceDetectView.mmv.removeAllViews();
                    }
                    faceDetectView.mmx.a(faceDetectView.getContext(), faceDetectView.mmu, faceDetectView.mmv);
                }
                if (faceDetectView.mms != null) {
                    faceDetectView.mms.a(rect, aGJ.mgn);
                }
                faceDetectView.mmz = false;
            }
        }
    }

    private void aHo() {
        this.lMx = false;
        this.mkh.eV(false);
        x.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
        this.mkd = false;
        this.mkh.mms.mlY.stopPreview();
        x.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    }

    public final void a(boolean z, boolean z2, a.b bVar) {
        if (z) {
            aHo();
        }
        if (z2) {
            x.i("MicroMsg.FaceDetectUI", "hy: need blur");
            com.tencent.mm.sdk.f.e.post(new 7(this, aHp()), "FaceDetectUI_BlurBgMap");
        }
        this.mjB.a(bVar);
    }

    private void b(int i, int i2, String str, String str2) {
        x.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(4), Integer.valueOf(i2), str});
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        aHo();
        b(4, i2, str, bundle);
    }

    public final void g(int i, int i2, String str, Bundle bundle) {
    }

    public final void K(int i, String str) {
        boolean z = true;
        x.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[]{Integer.valueOf(i)});
        if (!FaceCharacteristicsResult.pr(i)) {
            h hVar = this.mkb;
            if (hVar.lHX >= hVar.mgl + -1) {
                x.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
                this.mkh.eV(true);
                final Bitmap aHp = aHp();
                String str2 = "MicroMsg.FaceDetectUI";
                String str3 = "alvinluo bitmap == null: %b";
                Object[] objArr = new Object[1];
                if (aHp != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str2, str3, objArr);
                final a 9 = new 9(this);
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ FaceDetectUI mkq;

                    public final void run() {
                        n.n(this.mkq.gAb, aHp);
                        ag.y(new 1(this));
                    }
                }, "save_face_bitmap");
                return;
            }
            hVar = this.mkb;
            com.tencent.mm.plugin.facedetect.model.g gVar = f.mgf.mgg.mil;
            if (gVar.mgj == null) {
                x.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
            } else {
                x.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
                gVar.mgj.engineNextMotion();
            }
            hVar.lHX++;
            int i2 = h.aGJ().type;
            x.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[]{Integer.valueOf(i2)});
            if (h.aGJ().mgs) {
                this.mki.b(new 10(this));
                return;
            }
            x.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[]{Integer.valueOf(i2)});
            aHn();
        } else if (i == 3) {
            b(4, 90017, "face detect time out", str);
        } else if (i == 6 || i == 5) {
            b(4, 90023, "face track failed or not stable", str);
        } else if (i == 7) {
            b(4, 90009, "audio permission not granted", ac.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.ezQ));
        } else {
            b(4, 90018, "system error", str);
        }
    }

    public final void pC(int i) {
        if (i == 1) {
            this.mki.b(null);
        }
    }

    private void aHg() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
        FaceDetectView faceDetectView = this.mkh;
        com.tencent.mm.plugin.facedetect.d.b.b aGX = faceDetectView.mmx != null ? faceDetectView.mmx.aGX() : new com.tencent.mm.plugin.facedetect.d.b.b(90004, "user cancelled in processing");
        b(1, aGX.errCode, aGX.fnL, null);
    }

    protected void onDestroy() {
        x.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[]{Integer.valueOf(hashCode())});
        super.onDestroy();
    }

    public void finish() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo finish");
        if (this.mjB != null && this.mjB.aHh()) {
            this.mjB.dismiss();
        }
        if (this.mjC != null) {
            this.mjC.dismiss();
        }
        x.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
        aGn();
        super.finish();
    }

    public void onBackPressed() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
        aHg();
    }

    private Bitmap aHp() {
        return this.mkh.mms.getBitmap();
    }
}
