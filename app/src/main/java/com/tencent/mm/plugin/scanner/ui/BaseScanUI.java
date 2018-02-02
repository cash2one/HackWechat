package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.om;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.ui.i.2;
import com.tencent.mm.plugin.scanner.ui.i.3;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.1;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.IOException;
import java.util.List;

@a(3)
public class BaseScanUI extends MMActivity implements AutoFocusCallback, PreviewCallback, SurfaceTextureListener, b {
    private int fqw = 0;
    private final Object hpF = new Object();
    private boolean mlO = false;
    private int[] nZZ = new int[8];
    private boolean oNz = false;
    private final long pTW = 150;
    private final int pTX = 2;
    private MMTextureView pTY;
    private SurfaceTexture pTZ;
    private ImageView pUA;
    private i pUB;
    private int pUC = 0;
    private boolean pUD = false;
    private long pUE;
    private long pUF;
    private int pUG;
    private n pUH = new 1(this);
    protected af pUI = new 2(this);
    private final int pUJ = 2600;
    protected af pUK = new 6(this);
    protected af pUL = new 7(this);
    private c pUM = new 8(this);
    protected af pUN = new 9(this);
    protected final int pUO = 0;
    protected final int pUP = 1;
    protected final int pUQ = 2;
    private LinearLayout pUa;
    private TextView pUb;
    private FrameLayout pUc;
    private h pUd;
    private Point pUe;
    private SelectScanModePanel pUf;
    private ScanMaskView pUg = null;
    private ScannerFlashSwitcher pUh;
    private boolean pUi = false;
    private boolean pUj = false;
    private boolean pUk = true;
    private i.a pUl;
    private int pUm;
    private int pUn;
    private int pUo;
    private int pUp;
    private boolean pUq = true;
    private Rect pUr = new Rect();
    private TextView pUs;
    private View pUt;
    private boolean pUu = false;
    private boolean pUv = true;
    private boolean pUw = false;
    private boolean pUx = false;
    private e pUy = null;
    private TranslateAnimation pUz;
    private boolean pyw = true;
    private WakeLock wakeLock = null;

    public final /* bridge */ /* synthetic */ Activity getContext() {
        return this.mController.xIM;
    }

    static /* synthetic */ void i(BaseScanUI baseScanUI) {
        x.d("MicroMsg.scanner.BaseScanUI", "backBtn onClick");
        baseScanUI.pUj = true;
        baseScanUI.bpd();
        baseScanUI.overridePendingTransition(0, 0);
    }

    static /* synthetic */ void q(BaseScanUI baseScanUI) {
        if (baseScanUI.pUB != null) {
            baseScanUI.pUc.removeAllViews();
            View.inflate(baseScanUI, baseScanUI.pUB.boN(), baseScanUI.pUc);
            baseScanUI.pUB.cr(baseScanUI.pUc.getChildAt(0));
            baseScanUI.pUB.boP();
            i iVar = baseScanUI.pUB;
            View view = baseScanUI.pUc;
            iVar.lVX = new GestureDetector(new 2(iVar));
            view.setOnTouchListener(new 3(iVar));
            try {
                baseScanUI.boY();
                if (baseScanUI.pUB == null) {
                    x.d("MicroMsg.scanner.BaseScanUI", "initBodyByScanMode null scanMode");
                } else if (baseScanUI.pUd != null) {
                    baseScanUI.pUB.e(baseScanUI.pUe);
                    baseScanUI.pUd.mha = new Point(baseScanUI.pUe);
                    x.d("MicroMsg.scanner.ScanCamera", "set visible resolution:%s", new Object[]{r0.mha});
                    baseScanUI.pUB.f(baseScanUI.pUd.mgY);
                    h hVar = baseScanUI.pUd;
                    Rect y = baseScanUI.pUB.y(true, baseScanUI.yl());
                    int i = baseScanUI.pUC;
                    hVar.mhd = false;
                    hVar.qas = hVar.a(y, i);
                    hVar.bpG();
                    x.i("MicroMsg.scanner.ScanCamera", "scanDisplayRect:" + hVar.qas);
                    Rect rect = hVar.qas;
                    x.d("MicroMsg.scanner.BaseScanUI", "CameraScreenHeightRate() = [%s], CameraScreenWidthRate() = [%s], rect = [%s]", new Object[]{Float.valueOf(baseScanUI.pUd.bpD()), Float.valueOf(baseScanUI.pUd.bpC()), rect});
                    if (baseScanUI.yl()) {
                        x.d("MicroMsg.scanner.BaseScanUI", "landscape needRotate:" + baseScanUI.pUd.mhb);
                        baseScanUI.pUm = (int) (((float) rect.width()) * baseScanUI.pUd.bpC());
                        baseScanUI.pUn = (int) (((float) rect.height()) * baseScanUI.pUd.bpD());
                    } else {
                        x.d("MicroMsg.scanner.BaseScanUI", "portrait needRotate:" + baseScanUI.pUd.mhb);
                        if (baseScanUI.pUd.mhb) {
                            baseScanUI.pUm = (int) (((float) rect.height()) * baseScanUI.pUd.bpC());
                            baseScanUI.pUn = (int) (((float) rect.width()) * baseScanUI.pUd.bpD());
                        } else {
                            baseScanUI.pUm = (int) (((float) rect.width()) * baseScanUI.pUd.bpC());
                            baseScanUI.pUn = (int) (((float) rect.height()) * baseScanUI.pUd.bpD());
                        }
                    }
                    LayoutParams layoutParams = new LayoutParams(baseScanUI.pUm, baseScanUI.pUn, 3);
                    if (!baseScanUI.pUd.mhb || baseScanUI.yl()) {
                        layoutParams.leftMargin = (int) (((float) rect.left) * baseScanUI.pUd.bpC());
                        layoutParams.topMargin = (int) (((float) rect.top) * baseScanUI.pUd.bpD());
                    } else {
                        layoutParams.leftMargin = (int) (((float) rect.top) * baseScanUI.pUd.bpC());
                        layoutParams.topMargin = (int) (((float) rect.left) * baseScanUI.pUd.bpD());
                    }
                    x.d("MicroMsg.scanner.BaseScanUI", "mask : leftMargin=[%s], topMargin=[%s], width=[%s], height=[%s], needRotate=[%s]", new Object[]{Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(baseScanUI.pUm), Integer.valueOf(baseScanUI.pUn), Boolean.valueOf(baseScanUI.pUd.mhb)});
                    rect = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + baseScanUI.pUm, layoutParams.topMargin + baseScanUI.pUn);
                    if (baseScanUI.pUe.x - rect.right < rect.left) {
                        x.w("MicroMsg.scanner.BaseScanUI", "this is a special device");
                        if (baseScanUI.pUe.x - rect.left > rect.left) {
                            rect.right = baseScanUI.pUe.x - rect.left;
                        }
                    }
                    baseScanUI.pUm = rect.width();
                    if (baseScanUI.pUg != null) {
                        y = baseScanUI.pUg.pWT;
                        baseScanUI.pUg.bpm();
                        baseScanUI.pUg = new ScanMaskView(baseScanUI, y);
                    } else {
                        baseScanUI.pUg = new ScanMaskView(baseScanUI, rect);
                    }
                    ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -1);
                    baseScanUI.pUg.setLayoutParams(layoutParams2);
                    baseScanUI.pUc.removeAllViews();
                    View.inflate(baseScanUI, baseScanUI.pUB.boN(), baseScanUI.pUc);
                    baseScanUI.pUB.cr(baseScanUI.pUc.getChildAt(0));
                    baseScanUI.pUc.addView(baseScanUI.pUg, 0, layoutParams2);
                    ScanMaskView scanMaskView = baseScanUI.pUg;
                    if (!(rect.left == scanMaskView.pWT.left && rect.right == scanMaskView.pWT.right && rect.top == scanMaskView.pWT.top && rect.bottom == scanMaskView.pWT.bottom)) {
                        scanMaskView.pXa = (float) (rect.left - scanMaskView.pWT.left);
                        scanMaskView.pXb = (float) (rect.right - scanMaskView.pWT.right);
                        scanMaskView.pXc = (float) (rect.top - scanMaskView.pWT.top);
                        scanMaskView.pXd = (float) (rect.bottom - scanMaskView.pWT.bottom);
                        scanMaskView.pWY = new Rect(scanMaskView.pWT.left, scanMaskView.pWT.top, scanMaskView.pWT.right, scanMaskView.pWT.bottom);
                        scanMaskView.pWX = true;
                        scanMaskView.pXf = new ValueAnimator();
                        scanMaskView.pXf.setFloatValues(new float[]{0.0f, 1.0f});
                        scanMaskView.pXf.setDuration(200);
                        scanMaskView.pXf.addUpdateListener(new ScanMaskView$1(scanMaskView));
                        scanMaskView.pXf.start();
                    }
                    baseScanUI.pUB.h(rect);
                    baseScanUI.pUg.setBackgroundColor(0);
                    x.d("MicroMsg.scanner.BaseScanUI", "newRect = %s", new Object[]{rect});
                    if (baseScanUI.pUq) {
                        baseScanUI.pUo = rect.top;
                        baseScanUI.pUp = rect.bottom - BackwardSupportUtil.b.b(baseScanUI, 8.0f);
                        baseScanUI.pUr = rect;
                    } else {
                        baseScanUI.pUo = rect.left;
                        baseScanUI.pUp = rect.right - BackwardSupportUtil.b.b(baseScanUI, 8.0f);
                        baseScanUI.pUr = rect;
                    }
                    if (baseScanUI.pUh != null) {
                        LayoutParams layoutParams3 = (LayoutParams) baseScanUI.pUh.getLayoutParams();
                        if (baseScanUI.pUC == 3) {
                            layoutParams3.topMargin = baseScanUI.pUf.getTop() - com.tencent.mm.bv.a.fromDPToPix(baseScanUI, 70);
                        } else {
                            layoutParams3.topMargin = baseScanUI.pUr.top + (baseScanUI.pUr.height() - com.tencent.mm.bv.a.fromDPToPix(baseScanUI, 70));
                        }
                        x.k("MicroMsg.scanner.BaseScanUI", "initFlashSwitcher, scanMaskRect: %s, scanLineStart: %s, scanLineEnd: %s", new Object[]{baseScanUI.pUr, Integer.valueOf(baseScanUI.pUo), Integer.valueOf(baseScanUI.pUp)});
                        baseScanUI.pUh.setLayoutParams(layoutParams3);
                        baseScanUI.pUh.setOnClickListener(new OnClickListener(baseScanUI) {
                            final /* synthetic */ BaseScanUI pUR;

                            {
                                this.pUR = r1;
                            }

                            public final void onClick(View view) {
                                if (this.pUR.pUd != null) {
                                    l.pST.vF(2);
                                    if (this.pUR.pUd.osh) {
                                        this.pUR.pUd.bad();
                                        this.pUR.pUh.bpt();
                                        return;
                                    }
                                    h f = this.pUR.pUd;
                                    x.i("MicroMsg.scanner.ScanCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[]{f.gEB, Boolean.valueOf(f.mgX)});
                                    if (f.gEB != null && f.mgX) {
                                        try {
                                            f.osh = true;
                                            Parameters parameters = f.gEB.getParameters();
                                            if (bh.cA(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                                                x.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
                                            } else {
                                                parameters.setFlashMode("torch");
                                                f.gEB.setParameters(parameters);
                                                x.i("MicroMsg.scanner.ScanCamera", "open flash");
                                            }
                                        } catch (Throwable e) {
                                            x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "openFlash error: %s", new Object[]{e.getMessage()});
                                        }
                                    }
                                    ScannerFlashSwitcher g = this.pUR.pUh;
                                    x.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
                                    g.pYJ.setImageResource(R.k.dAx);
                                }
                            }
                        });
                        if (baseScanUI.pUd == null || !baseScanUI.pUd.osh) {
                            baseScanUI.pUh.setVisibility(8);
                        } else {
                            baseScanUI.pUh.setVisibility(0);
                        }
                    }
                    if (!baseScanUI.pUv || baseScanUI.pUk) {
                        baseScanUI.e(true, 350);
                        if (baseScanUI.pUd != null && baseScanUI.pUd.mgX) {
                            baseScanUI.eh(0);
                        }
                        if (baseScanUI.pUs != null && baseScanUI.pUt != null) {
                            baseScanUI.pUs.setVisibility(8);
                            baseScanUI.pUt.setVisibility(8);
                        }
                    } else if (baseScanUI.pUs != null && baseScanUI.pUt != null) {
                        baseScanUI.pUs.setText(R.l.eHS);
                        baseScanUI.pUt.setVisibility(0);
                        baseScanUI.pUs.setVisibility(0);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
            }
        }
    }

    protected final int getLayoutId() {
        if (yl()) {
            x.d("MicroMsg.scanner.BaseScanUI", "getLayoutId LANDSCAPE");
            return R.i.dqY;
        }
        x.d("MicroMsg.scanner.BaseScanUI", "getLayoutId PORTRAIT");
        return R.i.dqX;
    }

    protected final int getForceOrientation() {
        if (yl()) {
            x.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation LANDSCAPE");
            return 0;
        }
        x.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation PORTRAIT");
        return 1;
    }

    public void onCreate(Bundle bundle) {
        this.pUC = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
        super.onCreate(bundle);
        p.initLanguage(this);
        getWindow().addFlags(2097280);
        if (ar.CG().Km() == 6 || ar.CG().Km() == 4) {
            this.pUk = true;
        } else {
            this.pUk = false;
        }
        if (7 == this.pUC || 11 == this.pUC) {
            this.pUv = false;
        }
        com.tencent.mm.sdk.b.a.xef.b(this.pUM);
        initView();
        this.pUE = System.currentTimeMillis();
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qaA;
        try {
            scanCameraLightDetector.qaF = com.tencent.mm.sdk.f.e.Wf("ScanCameraLightDetector_detectThread");
            scanCameraLightDetector.qaF.start();
            scanCameraLightDetector.handler = new 1(scanCameraLightDetector, scanCameraLightDetector.qaF.getLooper());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "start error: %s", new Object[]{e.getMessage()});
        }
        x.i("MicroMsg.ScanCameraLightDetector", "start, sensorManager: %s, lightSensor: %s, isRegister: %s", new Object[]{scanCameraLightDetector.hRa, scanCameraLightDetector.qaC, Boolean.valueOf(scanCameraLightDetector.qaD)});
        this.pUE = System.currentTimeMillis();
    }

    protected final void initView() {
        Button button;
        if (yl()) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.mController.hideTitleView();
            x.d("MicroMsg.scanner.BaseScanUI", "oncreate LANDSCAPE");
        }
        this.pUt = findViewById(R.h.cIV);
        this.pUs = (TextView) findViewById(R.h.cIW);
        this.pUa = (LinearLayout) findViewById(R.h.cJa);
        this.pUb = (TextView) findViewById(R.h.cJb);
        this.pUc = (FrameLayout) findViewById(R.h.cIR);
        this.pUh = (ScannerFlashSwitcher) findViewById(R.h.cJe);
        this.pTY = (MMTextureView) findViewById(R.h.cDq);
        this.pTY.setOpaque(false);
        this.pTY.setSurfaceTextureListener(this);
        if (7 == this.pUC || 9 == this.pUC || 10 == this.pUC || 11 == this.pUC) {
            button = (Button) findViewById(R.h.cIQ);
            button.setVisibility(0);
            findViewById(R.h.cIS).setVisibility(8);
            findViewById(R.h.cJd).setVisibility(8);
            if (9 == this.pUC || 10 == this.pUC) {
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    button.setLayoutParams(marginLayoutParams);
                }
            }
        } else {
            button = (Button) findViewById(R.h.cIP);
        }
        if (button != null) {
            button.setOnClickListener(new 11(this));
        } else {
            setBackBtn(new 12(this));
        }
        this.pUA = (ImageView) findViewById(R.h.cIU);
        this.fqw = getIntent().getIntExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        this.pUf = (SelectScanModePanel) findViewById(R.h.cIY);
        this.pUc.setVisibility(0);
        if (!(7 == this.pUC || 9 == this.pUC || 10 == this.pUC || 11 == this.pUC || !yl())) {
            this.pUC = 1;
            this.pUu = true;
        }
        boY();
        setMMSubTitle(null);
        if (this.pUC == 2) {
            this.pUB = new k(this, this.pUe);
            setMMTitle(com.tencent.mm.plugin.scanner.util.p.dV(com.tencent.mm.plugin.scanner.util.p.qbg, getString(R.l.eHI)));
        } else if (this.pUC == 5) {
            this.pUB = new q(this, this.pUe);
            setMMTitle(R.l.eHB);
            x.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)), bh.cgy()});
        } else if (this.pUC == 3) {
            this.pUB = new o(this, this.pUe);
            setMMTitle(R.l.eHx);
        } else if (this.pUC == 4 && !yl()) {
            this.pUB = new p(this, this.pUe, this.fqw, 2);
            ((p) this.pUB).pYo = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            this.pUf.setVisibility(8);
            setMMTitle(R.l.eHC);
        } else if (this.pUC == 8) {
            this.pUB = new p(this, this.pUe, this.fqw, 1);
            ((p) this.pUB).pYo = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            this.pUf.setVisibility(8);
            setMMTitle(R.l.eHz);
        } else if (7 == this.pUC) {
            boolean z;
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.pUB = new j(this, this.pUe, r0, getWindowManager().getDefaultDisplay().getRotation());
            j jVar = (j) this.pUB;
            if (getIntent() == null || !getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false)) {
                z = false;
            } else {
                z = true;
            }
            jVar.pXx = z;
            setMMTitle(R.l.eHs);
            this.pUf.setVisibility(8);
        } else if (9 == this.pUC) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.pUB = new m(this, this.pUe, r0, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle(R.l.eHu);
            this.pUf.setVisibility(8);
        } else if (10 == this.pUC) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.pUB = new l(this, this.pUe, r0, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle(R.l.eHt);
            this.pUf.setVisibility(8);
        } else if (11 == this.pUC) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.pUB = new n(this, this.pUe, r0, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle(R.l.eHv);
            this.pUf.setVisibility(8);
        } else {
            this.pUC = 1;
            this.pUB = new p(this, this.pUe, this.fqw, yl() ? 1 : 0);
            ((p) this.pUB).pYo = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            if (com.tencent.mm.ar.b.PS()) {
                this.pUu = true;
                this.pUf.setVisibility(8);
            } else if (getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false)) {
                this.pUu = false;
                this.pUf.setVisibility(8);
            }
            if (this.pUu) {
                setMMTitle(R.l.eHz);
            } else {
                setMMTitle(R.l.eHA);
            }
        }
        this.pUq = this.pUB.boQ();
        this.pUA.setBackgroundResource(this.pUq ? R.g.bEV : R.g.bEW);
        int i = this.pUC;
        if (!(7 == this.pUC || 9 == this.pUC || 10 == this.pUC || 11 == this.pUC)) {
            this.pUf.pZl = new 13(this);
            this.pUf.vI(i);
        }
        if (this.pUd != null) {
            this.pUd.vL(this.pUC);
        }
        x.i("MicroMsg.scanner.BaseScanUI", "initView() done, fromSource=[%s], directSelectMode=[%s]", new Object[]{Integer.valueOf(this.fqw), Integer.valueOf(this.pUC)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        x.d("MicroMsg.scanner.BaseScanUI", "keyCode KEYCODE_BACK");
        this.pUj = true;
        bpd();
        overridePendingTransition(0, 0);
        return true;
    }

    protected void onResume() {
        super.onResume();
        if (!this.pUD) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            this.pUD = true;
        }
        if (this.pyw) {
            x.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkCamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 16, null, null))});
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 16, null, null)) {
                blL();
            } else {
                return;
            }
        }
        if (!this.pUj && (this.pUC == 1 || this.pUC == 8 || this.pUC == 4)) {
            l.pST.reset();
            l.pST.vE(l.pSQ);
        }
        SensorEventListener sensorEventListener = m.qbb;
        x.i("MicroMsg.ScanStableDetector", "start detect scan stable");
        if (sensorEventListener.bgR != null) {
            sensorEventListener.qaZ = 0;
            sensorEventListener.qaY[0] = 0.0f;
            sensorEventListener.qaY[1] = 0.0f;
            sensorEventListener.qaY[2] = 0.0f;
            x.i("MicroMsg.ScanStableDetector", "register accelerate listener");
            sensorEventListener.bgR.registerListener(sensorEventListener, sensorEventListener.qaX, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
        }
    }

    private void blL() {
        boolean z = true;
        if (com.tencent.mm.compatible.e.b.za()) {
            if (!this.pUv || this.pUk) {
                this.pUj = false;
                e(false, 0);
            } else {
                this.pUj = true;
                boT();
            }
            this.pUx = false;
            synchronized (this.hpF) {
                x.d("MicroMsg.scanner.BaseScanUI", "onResume open Camera");
                int i = this.pUC;
                if (!(7 == this.pUC || 9 == this.pUC || 10 == this.pUC || 11 == this.pUC)) {
                    z = false;
                }
                this.pUd = new h(this, i, z);
                boV();
            }
            if (this.pUB != null) {
                if (this.pUB.boM() != null) {
                    this.pUB.boM().bpv();
                }
                this.pUB.onResume();
            }
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
                this.wakeLock.acquire();
            }
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("classname", getClass().getName()), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
            if (this.pUv) {
                ar.a(this.pUH);
            }
            if (this.pUy != null) {
                this.pUy.onResume();
                return;
            }
            return;
        }
        com.tencent.mm.ui.base.h.a(this, getString(R.l.dGL), getString(R.l.dFM), getString(R.l.dFN), true, new 14(this));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.scanner.BaseScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr.length), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    this.pyw = false;
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.ezM), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 15(this), new 16(this));
                    return;
                }
                blL();
                return;
            case 64:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 17(this), null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        x.i("MicroMsg.scanner.BaseScanUI", "onPause(), scanMode: %s, mQBarStringHandler: %s", new Object[]{this.pUB, this.pUy});
        this.pUj = true;
        m.qbb.stop();
        if (this.pUB != null) {
            this.pUB.onPause();
            if (this.pUB.boM() != null) {
                this.pUB.boM().kL();
            }
        }
        if (this.pUd != null) {
            String focusMode = this.pUd.getFocusMode();
            if (bh.ov(focusMode) || !focusMode.equals("continuous-video")) {
                this.nZZ[2] = 0;
            } else {
                this.nZZ[2] = 1;
            }
        }
        boW();
        if (this.pUh != null) {
            this.pUh.bpt();
            this.pUh.hide();
        }
        if (this.wakeLock != null && this.wakeLock.isHeld()) {
            this.wakeLock.release();
            this.wakeLock = null;
        }
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
        if (this.pUv) {
            ar.b(this.pUH);
        }
        if (this.pUy != null) {
            this.pUy.onPause();
        }
        if (this.pUC == 1 || this.pUC == 8 || this.pUC == 4) {
            l.pST.aUb();
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.pUE);
            x.i("MicroMsg.scanner.BaseScanUI", "scan cost time:" + currentTimeMillis);
            if (l.pST.pSV) {
                this.nZZ[0] = 1;
            } else {
                this.nZZ[0] = 0;
            }
            this.nZZ[1] = currentTimeMillis;
            this.nZZ[3] = l.pST.pSW;
            if (m.qbb.bpO() > 0) {
                this.nZZ[6] = (int) (m.qbb.bpO() - this.pUE);
            }
            this.nZZ[7] = this.pUC;
            g.pQN.h(14176, new Object[]{Integer.valueOf(this.nZZ[0]), Integer.valueOf(this.nZZ[1]), Integer.valueOf(this.nZZ[2]), Integer.valueOf(this.nZZ[3]), Integer.valueOf(this.nZZ[4]), Integer.valueOf(this.nZZ[5]), Integer.valueOf(this.nZZ[6]), Integer.valueOf(this.nZZ[7])});
        }
        super.onPause();
    }

    protected void onDestroy() {
        x.i("MicroMsg.scanner.BaseScanUI", "onDestroy()");
        if (this.pUB != null) {
            this.pUB.onDestroy();
        }
        if (this.pUg != null) {
            this.pUg.bpm();
        }
        if (this.pTY != null) {
            this.pTY.setSurfaceTextureListener(null);
        }
        com.tencent.mm.sdk.b.a.xef.c(this.pUM);
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qaA;
        x.i("MicroMsg.ScanCameraLightDetector", "stop, isRegister: %s, sensorManager: %s, lightSensor: %s", new Object[]{Boolean.valueOf(scanCameraLightDetector.qaD), scanCameraLightDetector.hRa, scanCameraLightDetector.qaC});
        try {
            scanCameraLightDetector.qaB = -1;
            if (scanCameraLightDetector.qaF != null) {
                scanCameraLightDetector.qaF.quit();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "stop error: %s", new Object[]{e.getMessage()});
        }
        super.onDestroy();
    }

    private void e(boolean z, long j) {
        if (this.pUo >= 0 && this.pUp > 0) {
            if (this.pUB == null || this.pUB.boR()) {
                if (z) {
                    LayoutParams layoutParams = (LayoutParams) this.pUA.getLayoutParams();
                    if (this.pUq) {
                        layoutParams.width = this.pUm;
                        layoutParams.gravity = 1;
                    } else {
                        layoutParams.height = this.pUn;
                        layoutParams.gravity = 48;
                        layoutParams.topMargin = this.pUr.top;
                    }
                    this.pUA.setLayoutParams(layoutParams);
                    this.pUA.invalidate();
                    this.pUA.setVisibility(0);
                    if (this.pUq) {
                        this.pUz = new TranslateAnimation(0.0f, 0.0f, (float) this.pUo, (float) this.pUp);
                    } else {
                        this.pUz = new TranslateAnimation((float) this.pUo, (float) this.pUp, 0.0f, 0.0f);
                    }
                }
                this.pUI.removeMessages(1);
                if (j <= 0) {
                    this.pUI.sendEmptyMessage(1);
                    return;
                }
                boT();
                this.pUI.sendEmptyMessageDelayed(1, j);
            }
        }
    }

    public final void boT() {
        if (this.pUA != null && this.pUz != null) {
            this.pUA.setVisibility(8);
            this.pUA.clearAnimation();
            this.pUA.setAnimation(null);
        }
    }

    public final void boU() {
        if (!this.pUj) {
            com.tencent.mm.sdk.platformtools.ar.H(this, R.l.eBs);
        }
    }

    private void boV() {
        ag.h(new Runnable(this) {
            final /* synthetic */ BaseScanUI pUR;

            {
                this.pUR = r1;
            }

            public final void run() {
                try {
                    if (this.pUR.pUd == null) {
                        x.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in openCamera()");
                        return;
                    }
                    if (!this.pUR.pUw) {
                        this.pUR.pUx = true;
                    }
                    if (this.pUR.pUd.isOpen()) {
                        x.d("MicroMsg.scanner.BaseScanUI", "camera already open");
                    } else {
                        synchronized (this.pUR.hpF) {
                            h f = this.pUR.pUd;
                            if (f.mgX) {
                                x.w("MicroMsg.scanner.ScanCamera", "in open(), previewing");
                                f.release();
                            }
                            int yk = d.yk();
                            long Wq = bh.Wq();
                            d.a.a o = d.o(f.fAF, yk);
                            if (o == null) {
                                x.e("MicroMsg.scanner.ScanCamera", "in open(), openCameraRes == null");
                                throw new IOException();
                            }
                            f.osh = false;
                            f.qav = -1;
                            x.d("MicroMsg.scanner.ScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[]{Integer.valueOf(yk), Long.valueOf(bh.bA(Wq))});
                            f.mhc = o.fFy;
                            f.mhb = o.fFy % 180 != 0;
                            f.gEB = o.gEB;
                            if (f.gEB == null) {
                                x.e("MicroMsg.scanner.ScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[]{Boolean.valueOf(f.mhb)});
                                throw new IOException();
                            }
                            boolean z;
                            int i;
                            Parameters parameters = f.gEB.getParameters();
                            Point point = f.mgZ;
                            Point point2 = f.mha;
                            if (9 == f.qaq || 10 == f.qaq || 7 == f.qaq || 11 == f.qaq) {
                                z = true;
                            } else {
                                z = false;
                            }
                            f.mgY = h.a(parameters, point, point2, z);
                            x.d("MicroMsg.scanner.ScanCamera", "getCameraResolution: " + f.mgZ + " camera:" + f.mgY);
                            parameters.setPreviewSize(f.mgY.x, f.mgY.y);
                            f.bpH();
                            try {
                                h.c(parameters);
                            } catch (Exception e) {
                                x.e("MicroMsg.scanner.ScanCamera", "set focus mode error: %s", new Object[]{e.getMessage()});
                            }
                            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                            x.i("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat:" + supportedPreviewFormats);
                            if (supportedPreviewFormats.contains(Integer.valueOf(17))) {
                                yk = 0;
                                i = 1;
                            } else if (supportedPreviewFormats.contains(Integer.valueOf(842094169))) {
                                yk = 1;
                                i = 0;
                            } else {
                                yk = 0;
                                i = 0;
                            }
                            if (i != 0) {
                                x.i("MicroMsg.scanner.ScanCamera", "Preview support NV21");
                                parameters.setPreviewFormat(17);
                            } else if (yk != 0) {
                                x.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21, but support YV12");
                                parameters.setPreviewFormat(842094169);
                            } else {
                                x.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21 and YV12. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                                parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                            }
                            f.gEB.setParameters(parameters);
                            x.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
                            this.pUR.pUx = false;
                        }
                    }
                    ag.h(new 1(this), 50);
                    BaseScanUI.q(this.pUR);
                } catch (Throwable e2) {
                    x.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.open(), [%s]", new Object[]{e2.toString()});
                    x.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e2, "", new Object[0]);
                    this.pUR.boX();
                }
            }
        }, 25);
    }

    private void startPreview() {
        try {
            if (this.pUd == null) {
                x.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in startPreview");
            } else if (!this.pUd.isOpen()) {
                x.w("MicroMsg.scanner.BaseScanUI", "camera not open");
            } else if (this.pTZ == null) {
                x.w("MicroMsg.scanner.BaseScanUI", "preview surface in null in startPreview");
            } else if (this.pUd.mgX) {
                x.w("MicroMsg.scanner.BaseScanUI", "camera is previewing");
            } else {
                x.d("MicroMsg.scanner.BaseScanUI", "camera startPreview.");
                synchronized (this.hpF) {
                    h hVar = this.pUd;
                    SurfaceTexture surfaceTexture = this.pTZ;
                    long Wq = bh.Wq();
                    if (!(hVar.gEB == null || hVar.mgX)) {
                        if (surfaceTexture != null) {
                            hVar.gEB.setPreviewTexture(surfaceTexture);
                        }
                        hVar.gEB.startPreview();
                        hVar.mgX = true;
                        x.d("MicroMsg.scanner.ScanCamera", "startPreview done costTime=[%s]", new Object[]{Long.valueOf(bh.bA(Wq))});
                    }
                    x.d("MicroMsg.scanner.BaseScanUI", "camera startPreview. done");
                    this.nZZ[5] = (int) (System.currentTimeMillis() - this.pUE);
                    if (bh.ov(this.pUd.getFocusMode()) || !this.pUd.getFocusMode().equals("continuous-video")) {
                        if (q.gFU.gEq > 0) {
                            eg((long) ((int) (((float) q.gFU.gEq) * r.ied)));
                        }
                        eh(0);
                    } else {
                        hVar = this.pUd;
                        if (hVar.gEB != null) {
                            hVar.gEB.cancelAutoFocus();
                        }
                        eg(0);
                    }
                }
            }
        } catch (Throwable e) {
            x.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.startPreview(), [%s]", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
            boX();
        }
    }

    private void boW() {
        this.mlO = true;
        com.tencent.mm.sdk.f.e.post(new 4(this), "BaseScanUI_closeCamera");
    }

    private void boX() {
        if (!this.pUi) {
            this.pUi = true;
            hG(true);
            com.tencent.mm.sdk.b.b lpVar = new lp();
            lpVar.fDc.type = 2;
            com.tencent.mm.sdk.b.a.xef.m(lpVar);
            if (lpVar.fDd.fDb) {
                x.i("MicroMsg.scanner.BaseScanUI", "Permission dialog showed");
                this.pUj = true;
                boW();
                bpd();
                overridePendingTransition(0, 0);
                return;
            }
            i a = com.tencent.mm.ui.base.h.a(this, getString(R.l.eHT), getString(R.l.dGO), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ BaseScanUI pUR;

                {
                    this.pUR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pUR.pUj = true;
                    this.pUR.boW();
                    this.pUR.bpd();
                    this.pUR.overridePendingTransition(0, 0);
                }
            });
            if (a == null) {
                x.d("MicroMsg.scanner.BaseScanUI", "comfirmDialog == null");
                return;
            }
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public void onStart() {
        super.onStart();
    }

    private void boY() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.pUe = new Point(rect.width(), rect.height());
        x.d("MicroMsg.scanner.BaseScanUI", "update visible rect:%s", new Object[]{this.pUe});
    }

    public final void vG(int i) {
        this.pUK.removeMessages(0);
        this.pUK.sendEmptyMessageDelayed(i, 50);
    }

    public final void eg(long j) {
        x.i("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay: %s", new Object[]{Long.valueOf(j)});
        this.pUL.removeMessages(0);
        if (this.pUj) {
            x.w("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay() scanPause");
        } else {
            this.pUL.sendEmptyMessageDelayed(0, j);
        }
    }

    public final void eh(long j) {
        if (this.pUd != null && !this.pUj && this.pUd.mgX) {
            x.d("MicroMsg.scanner.BaseScanUI", "focus delay:" + j);
            String focusMode = this.pUd.getFocusMode();
            if (bh.ov(focusMode) || !focusMode.equals("continuous-video")) {
                this.pUN.removeMessages(0);
                this.pUN.sendEmptyMessageDelayed(0, j);
                return;
            }
            eg(0);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        boolean z = true;
        String str = "MicroMsg.scanner.BaseScanUI";
        String str2 = "onPreviewFrame, data==null: %s, camera: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bArr == null);
        objArr[1] = camera;
        x.i(str, str2, objArr);
        if (this.pUj || this.pUB == null || this.pUB.boM() == null || this.pUB.y(false, yl()) == null) {
            x.w("MicroMsg.scanner.BaseScanUI", "onPreviewFrame error state, scanPause = [%s]", new Object[]{Boolean.valueOf(this.pUj)});
        } else if (bArr == null || bArr.length <= 0) {
            String str3 = "MicroMsg.scanner.BaseScanUI";
            str = "onPreviewFrame, wrong data, data is null [%s]";
            Object[] objArr2 = new Object[1];
            if (bArr != null) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            x.e(str3, str, objArr2);
            boX();
        } else if (this.pUd == null) {
            x.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, scanCamera == null, finish this activity");
        } else {
            h hVar;
            if (this.pUd != null) {
                hVar = this.pUd;
                if (hVar.qav < 0) {
                    hVar.qav = hVar.bpJ() ? 1 : 0;
                }
                if (hVar.qav != 1) {
                    z = false;
                }
                if (z && !this.pUd.osh && this.pUk) {
                    ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qaA;
                    int i = this.pUd.mgY.x;
                    int i2 = this.pUd.mgY.y;
                    if (scanCameraLightDetector.qaB < 0 || (bh.bA(scanCameraLightDetector.qaB) >= 1000 && scanCameraLightDetector.handler != null && scanCameraLightDetector.qaF != null && scanCameraLightDetector.qaF.isAlive())) {
                        ScanCameraLightDetector.a aVar = new ScanCameraLightDetector.a(scanCameraLightDetector, (byte) 0);
                        aVar.otM = bArr;
                        aVar.width = i;
                        aVar.height = i2;
                        Message obtain = Message.obtain();
                        obtain.what = 233;
                        obtain.obj = aVar;
                        scanCameraLightDetector.handler.sendMessage(obtain);
                        scanCameraLightDetector.qaB = bh.Wq();
                    }
                }
            }
            if (this.pUd != null && !this.pUj) {
                i iVar = this.pUB;
                Point point = this.pUd.mgY;
                int i3 = this.pUd.mhc;
                hVar = this.pUd;
                hVar.mbm = hVar.a(this.pUB.hJ(yl()), this.pUC);
                x.i("MicroMsg.scanner.ScanCamera", "scanRect:" + hVar.mbm);
                iVar.a(bArr, point, i3, hVar.mbm);
            }
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        x.i("MicroMsg.scanner.BaseScanUI", "onAutoFocus, success: %s, camera: %s", new Object[]{Boolean.valueOf(z), camera});
        this.nZZ[4] = (int) (System.currentTimeMillis() - this.pUF);
        q.gFU.gEq = (long) this.nZZ[4];
        if (!this.pUj && this.pUB != null) {
            if (this.pUd != null && this.pUd.mgX && z) {
                eg(0);
            }
            if (this.pUB.pXh > 0) {
                eh(this.pUB.pXh);
            }
        }
    }

    public final void a(i.a aVar) {
        this.pUl = aVar;
    }

    public final void boZ() {
        Intent intent = new Intent();
        intent.putExtra("preview_ui_title", R.l.eIj);
        k.a(this, 4660, intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.pUl != null) {
            this.pUl.b(this, i, i2, intent);
        }
    }

    public final void hG(boolean z) {
        this.pUj = z;
        if (z) {
            boT();
            if (this.pUt != null) {
                this.pUt.setVisibility(0);
                return;
            }
            return;
        }
        eh(0);
        e(false, 0);
        if (this.pUt != null) {
            this.pUt.setVisibility(8);
        }
    }

    public final void b(int i, OnClickListener onClickListener) {
        if (this.pUa != null) {
            if (getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
                this.pUa.setVisibility(8);
            } else if (onClickListener != null) {
                this.pUa.setVisibility(i);
                this.pUa.setOnClickListener(onClickListener);
                this.pUb.setBackgroundDrawable(null);
                this.pUb.setText(getString(R.l.eJy));
            }
        } else if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
            if (onClickListener != null) {
                addIconOptionMenu(0, R.g.bDI, new 10(this, onClickListener));
            } else {
                removeOptionMenu(0);
            }
        }
    }

    public final boolean bpa() {
        if (this.pUd != null) {
            return this.pUd.mhb;
        }
        x.d("MicroMsg.scanner.BaseScanUI", "scanCamera == null, cameraNeedRotate return false");
        return false;
    }

    public final void bpb() {
        bpd();
    }

    public final void bpc() {
        super.finish();
    }

    private void bpd() {
        com.tencent.mm.sdk.b.b omVar = new om();
        omVar.fGu.fDt = 1;
        com.tencent.mm.sdk.b.a.xef.m(omVar);
        setResult(0);
        finish();
    }

    private boolean yl() {
        return 7 == this.pUC || 9 == this.pUC || 10 == this.pUC || 11 == this.pUC || d.yl();
    }

    public final void a(String str, int i, int i2, int i3, e.a aVar) {
        x.i("MicroMsg.scanner.BaseScanUI", "dealQBarString, qbarString: %s, codeType: %s, codeVersion: %s", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.pUy != null) {
            this.pUy.bpA();
        }
        Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
        this.pUy = new e();
        this.pUy.a(this, str, i, i2, i3, aVar, bundleExtra);
        if (this.pUC == 1 || this.pUC == 8 || this.pUC == 4) {
            int i4 = l.pST.pLa;
            i4 = l.pSQ;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureAvailable");
        this.pTY.cpK();
        this.pTZ = surfaceTexture;
        this.pUw = true;
        if (this.pUx) {
            boV();
            this.pUx = false;
        }
        startPreview();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureSizeChanged");
        this.pTZ = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureDestroyed");
        this.pUw = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void W(int i, int i2, int i3) {
        synchronized (this.hpF) {
            if (!(this.mlO || this.pUd == null || !this.pUd.mgX)) {
                x.i("MicroMsg.scanner.BaseScanUI", "zoom camera,action:%d,type:%d,scale:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                int bpI = this.pUd.bpI();
                if (this.pUC == 1 || this.pUC == 8 || this.pUC == 4) {
                    if (i2 != 1 || ((p) this.pUB).bpr()) {
                        if (i == 6) {
                            this.pUd.vM(i3);
                        } else {
                            this.pUd.vN(i);
                        }
                        if (i2 == 2) {
                            ((p) this.pUB).bpq();
                        }
                    } else {
                        x.d("MicroMsg.scanner.BaseScanUI", "auto zoom is disable");
                        return;
                    }
                } else if (i == 6) {
                    this.pUd.vM(i3);
                } else {
                    this.pUd.vN(i);
                }
                if (this.pUd.bpI() != bpI) {
                    l lVar = l.pST;
                    int bpI2 = this.pUd.bpI();
                    String str = "";
                    if (i2 == 1) {
                        str = String.format("(0@%.2f)", new Object[]{Double.valueOf(((double) bpI2) / 100.0d)});
                    } else if (i2 == 2) {
                        str = str + String.format("(1@%.2f)", new Object[]{Double.valueOf(((double) bpI2) / 100.0d)});
                    }
                    if (lVar.pTf.length() + str.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        lVar.pTf.append(str);
                    }
                }
            }
        }
    }

    public final void bpe() {
        if (this.pUd != null && !this.pUj) {
            String focusMode = this.pUd.getFocusMode();
            if (!bh.ov(focusMode) && !focusMode.equals("auto")) {
                h hVar = this.pUd;
                if (hVar.gEB != null && hVar.mgX) {
                    Parameters parameters = hVar.gEB.getParameters();
                    List supportedFocusModes = parameters.getSupportedFocusModes();
                    if (!(supportedFocusModes == null || !supportedFocusModes.contains("auto") || bh.ov(parameters.getFocusMode()) || parameters.getFocusMode().equals("auto"))) {
                        parameters.setFocusMode("auto");
                        hVar.gEB.setParameters(parameters);
                    }
                }
                eh(0);
            }
        }
    }
}
