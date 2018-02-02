package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j$e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i$c;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b$b;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.z.d;
import com.tencent.mm.z.s;

@a(3)
public class SnsSightPlayerUI extends MMActivity implements b$b, d.a {
    public l contextMenuHelper;
    private int duration = 0;
    private aqr fHC = null;
    private int fJB = 0;
    private VelocityTracker ft;
    private String fus = "";
    private String fvC = "";
    private String hDC = "";
    private boolean hik = false;
    private String imagePath = "";
    private boolean isInit = false;
    private d jtl;
    private GestureDetector jtw;
    Bundle kRZ;
    private boolean kSa = false;
    g kSb;
    private int kSc = 0;
    private int kSd = 0;
    private int kSe = 0;
    private int kSf = 0;
    f kTe = null;
    private int msn = 0;
    private TextView mwd = null;
    private boolean mwg = false;
    private ImageView mxv;
    p.d onK = new 6(this);
    private boolean qQH = false;
    private int qtX = 0;
    private TextView quS = null;
    private boolean quT = false;
    ViewGroup qvc;
    private int qvk = 0;
    private int qvl = 0;
    public int qvs = 0;
    private float rEA = 0.0f;
    private boolean rEB = false;
    private boolean rEC = false;
    private boolean rED = false;
    private boolean rEx = false;
    private float rEz = 0.0f;
    private h rGn = new h("SnsSightPlayerUI");
    private String rGo = "";
    private TextView rGp = null;
    private MMPinProgressBtn rGq = null;
    private m rGr = null;
    private String rGs = "";
    private RelativeLayout rGt;
    OnCreateContextMenuListener rGu = new 5(this);
    private float rzi = 1.0f;
    private int rzj = 0;
    private int rzk = 0;
    private int scene = 0;

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.mController.hideTitleView();
        ae.bvq().a(this);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(i$c.black));
        }
        if (com.tencent.mm.compatible.util.d.fM(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.kRZ = bundle;
        this.jtl = new d();
        this.hDC = getIntent().getStringExtra("intent_videopath");
        this.imagePath = getIntent().getStringExtra("intent_thumbpath");
        this.fus = getIntent().getStringExtra("intent_localid");
        this.qQH = getIntent().getBooleanExtra("intent_isad", false);
        this.rGr = ae.bvv().Lm(this.fus);
        if (this.qQH) {
            boolean z;
            if (this.rGr == null) {
                z = false;
            } else {
                this.fHC = (aqr) this.rGr.bxV().wQo.vYd.get(0);
                String r = am.r(ae.getAccSnsPath(), this.fHC.nGJ);
                this.rGs = r + i.k(this.fHC);
                this.fvC = r + i.e(this.fHC);
                z = true;
            }
            if (!z) {
                finish();
                return;
            }
        }
        if (com.tencent.mm.p.a.ux() != null) {
            com.tencent.mm.p.a.ux().wB();
        }
        this.rGn.qPn = bh.Wq();
        this.rGt = (RelativeLayout) findViewById(com.tencent.mm.plugin.sns.i.f.ivC);
        this.rGt.setOnTouchListener(new 1(this));
        x.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.zg() + " initView: fullpath:" + this.hDC + ", imagepath:" + this.imagePath);
        this.kSb = new g(this.mController.xIM);
        this.mxv = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.ckv);
        this.mxv.setLayerType(2, null);
        this.quS = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.cSe);
        this.rGq = (MMPinProgressBtn) findViewById(com.tencent.mm.plugin.sns.i.f.cOp);
        this.qvc = (ViewGroup) findViewById(com.tencent.mm.plugin.sns.i.f.cUI);
        this.kTe = n.er(this.mController.xIM);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.mwd = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.cOg);
        this.qvc.addView((View) this.kTe, 0, layoutParams);
        this.rGp = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.qFK);
        this.rGp.setText("");
        if (!this.qQH) {
            this.rGp.setVisibility(8);
        }
        if (this.qQH) {
            if (this.fHC == null) {
                this.mwd.setVisibility(8);
            } else if (bh.ov(this.fHC.wxL)) {
                x.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
                final bnp bxV = this.rGr.bxV();
                b bxR = this.rGr.bxR();
                CharSequence charSequence = bxR.reE;
                final String str = bxR.reF;
                if (bh.ov(charSequence) || bh.ov(str)) {
                    this.mwd.setVisibility(8);
                } else {
                    this.mwd.setVisibility(0);
                    this.mwd.setText(charSequence);
                    this.mwd.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsSightPlayerUI rGv;

                        public final void onClick(View view) {
                            if (j.b.qPU.value != 0) {
                                j.a(j.a.qPO, bxV.nGJ, this.rGv.rGr.bxT() == null ? "" : this.rGv.rGr.bxT().qZM, 1, j.b.qPU.value, bxV.ksU, null, bxV.nGJ, 0, 0, 0);
                            }
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", bxV.rtA);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("useJs", true);
                            k cVar = new c(this.rGv.rGr.byz(), 18, 5, "", 2, this.rGv.rGr.bxW());
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(cVar, 0);
                            new af(Looper.getMainLooper()).post(new 1(this, intent));
                        }
                    });
                }
            } else {
                r = getResources().getString(com.tencent.mm.plugin.sns.i.j.ePM);
                if (this.fHC.rNe / 60 > 0) {
                    r = r + getResources().getString(com.tencent.mm.plugin.sns.i.j.ePO, new Object[]{Integer.valueOf(this.fHC.rNe / 60)});
                }
                if (this.fHC.rNe % 60 > 0) {
                    r = r + getResources().getString(com.tencent.mm.plugin.sns.i.j.ePP, new Object[]{Integer.valueOf(this.fHC.rNe % 60)});
                }
                this.mwd.setText(r + getResources().getString(com.tencent.mm.plugin.sns.i.j.ePN));
                this.mwd.setVisibility(0);
                this.mwd.setOnClickListener(new 8(this));
            }
            com.tencent.mm.pluginsdk.ui.tools.m.a(this.mwd, (VideoSightView) this.kTe);
        } else {
            this.mwd.setVisibility(8);
        }
        this.kTe.a(new f.a(this) {
            final /* synthetic */ SnsSightPlayerUI rGv;

            {
                this.rGv = r1;
            }

            public final void hX() {
                x.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.zg() + " onPrepared");
                this.rGv.ic(true);
            }

            public final void onError(int i, int i2) {
                x.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.rGv.kTe.stop();
                if (!this.rGv.mwg) {
                    this.rGv.mwg = true;
                    com.tencent.mm.sdk.a.b.z(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.bsC() + "[SnsSightPlayerUI] on play video error, what " + i + " extra " + i2 + ", path=" + bh.az(this.rGv.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                    String c = this.rGv.imagePath;
                    ag.y(new 1(this, o.Pw().a(c, com.tencent.mm.bv.a.getDensity(this.rGv.mController.xIM), this.rGv.mController.xIM, -1), c));
                }
            }

            public final void vh() {
                x.d("MicroMsg.SnsSightPlayerUI", "on completion");
                if (!this.rGv.qQH) {
                    this.rGv.quS.post(new 2(this));
                }
                this.rGv.kTe.cP(true);
                com.tencent.mm.plugin.sns.a.b.a.a aVar = this.rGv.rGn.qPt;
                aVar.qQq++;
                this.rGv.ic(false);
            }

            public final int cf(int i, int i2) {
                return 0;
            }

            public final void cg(int i, int i2) {
            }
        });
        findViewById(com.tencent.mm.plugin.sns.i.f.cUI).setOnClickListener(new 10(this));
        ((View) this.kTe).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSightPlayerUI rGv;

            {
                this.rGv = r1;
            }

            public final void onClick(View view) {
                this.rGv.avV();
            }
        });
        this.jtw = new GestureDetector(this.mController.xIM, new 12(this));
        ((View) this.kTe).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsSightPlayerUI rGv;

            {
                this.rGv = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 1.0f;
                this.rGv.jtw.onTouchEvent(motionEvent);
                if (this.rGv.ft == null) {
                    this.rGv.ft = VelocityTracker.obtain();
                }
                this.rGv.ft.addMovement(motionEvent);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.rGv.rEz = motionEvent.getX();
                        this.rGv.rEA = motionEvent.getY();
                        break;
                    case 1:
                        if (this.rGv.rEC) {
                            ((View) this.rGv.kTe).setPivotX((float) (this.rGv.qvc.getWidth() / 2));
                            ((View) this.rGv.kTe).setPivotY((float) (this.rGv.qvc.getHeight() / 2));
                            ((View) this.rGv.kTe).setScaleX(1.0f);
                            ((View) this.rGv.kTe).setScaleY(1.0f);
                            ((View) this.rGv.kTe).setTranslationX(0.0f);
                            ((View) this.rGv.kTe).setTranslationY(0.0f);
                            MMActivity mMActivity = this.rGv;
                            if (mMActivity.contextMenuHelper == null) {
                                mMActivity.contextMenuHelper = new l(mMActivity.mController.xIM);
                            }
                            mMActivity.contextMenuHelper.a((View) mMActivity.kTe, mMActivity.rGu, mMActivity.onK);
                            if (this.rGv.mwd != null) {
                                this.rGv.mwd.setVisibility(0);
                            }
                            this.rGv.rEB = false;
                            this.rGv.rED = false;
                            break;
                        } else if (!this.rGv.rEB || this.rGv.rED) {
                            this.rGv.rED = false;
                            break;
                        } else {
                            this.rGv.avV();
                            this.rGv.rED = false;
                            return true;
                        }
                        break;
                    case 2:
                        float translationX = ((View) this.rGv.kTe).getTranslationX();
                        float translationY = ((View) this.rGv.kTe).getTranslationY();
                        VelocityTracker n = this.rGv.ft;
                        n.computeCurrentVelocity(1000);
                        int xVelocity = (int) n.getXVelocity();
                        int yVelocity = (int) n.getYVelocity();
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || this.rGv.rED) && !this.rGv.rEB) {
                            this.rGv.rEB = false;
                        } else {
                            float height = 1.0f - (translationY / ((float) this.rGv.qvc.getHeight()));
                            if (height <= 1.0f) {
                                f = height;
                            }
                            if (((yVelocity > 0 && f < this.rGv.rzi) || yVelocity < 0) && ((double) f) >= 0.5d) {
                                this.rGv.rzj = (int) translationX;
                                this.rGv.rzk = (int) translationY;
                                this.rGv.rzi = f;
                                if (this.rGv.mwd != null) {
                                    this.rGv.mwd.setVisibility(8);
                                }
                                ((View) this.rGv.kTe).setPivotX((float) (this.rGv.qvc.getWidth() / 2));
                                ((View) this.rGv.kTe).setPivotY((float) (this.rGv.qvc.getHeight() / 2));
                                ((View) this.rGv.kTe).setScaleX(f);
                                ((View) this.rGv.kTe).setScaleY(f);
                                this.rGv.mxv.setAlpha(f);
                            }
                            this.rGv.rEB = true;
                        }
                        if (translationY > 200.0f) {
                            this.rGv.rEC = false;
                        } else if (translationY > 10.0f) {
                            this.rGv.rEC = true;
                        }
                        if (translationY > 50.0f) {
                            ((View) this.rGv.kTe).setOnLongClickListener(null);
                        }
                        if (this.rGv.ft != null) {
                            this.rGv.ft.recycle();
                            this.rGv.ft = null;
                        }
                        if (this.rGv.rEB) {
                            return true;
                        }
                        break;
                }
                return false;
            }
        });
        if (FileOp.bO(this.hDC)) {
            if (this.hDC != null) {
                this.kTe.stop();
                this.kTe.setVideoPath(this.hDC);
            }
            this.rGq.setVisibility(8);
            this.rGn.qPl = 1;
        } else {
            ae.bvq().a(this.fHC, 6, null, an.xyY);
            this.rGq.setVisibility(0);
            this.rGq.cyN();
            this.rGn.qPl = 0;
        }
        x.d("MicroMsg.SnsSightPlayerUI", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.type = 1;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new l(this.mController.xIM);
        }
        this.contextMenuHelper.a((View) this.kTe, this.rGu, this.onK);
        ((View) this.kTe).post(new 14(this));
    }

    public void finish() {
        if (!this.hik) {
            super.finish();
            this.hik = true;
        }
    }

    private void ic(boolean z) {
        this.kTe.start();
        this.duration = this.kTe.getDuration();
        x.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
        this.jtl.a(this);
        if (z) {
            this.rGn.qPt.qQu = getResources().getConfiguration().orientation == 2 ? 2 : 1;
            this.rGn.qPt.qQv = bh.Wq();
            this.rGn.qPt.qQt = 2;
        }
    }

    private void bxv() {
        x.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
        this.kTe.pause();
        this.kTe.onDetach();
        this.jtl.bx(false);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qHO;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.qQH) {
            String str;
            int i;
            int i2;
            if (this.rGr == null) {
                str = "";
            } else {
                str = this.rGr.byz();
            }
            String btZ = this.rGn.btZ();
            if (this.rGr == null) {
                i = 0;
            } else {
                i = this.rGr.byC();
            }
            long j = ((long) this.rGn.qPm) - this.rGn.hOD;
            if (j < 0) {
                x.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[]{Integer.valueOf(this.rGn.qPm), Long.valueOf(this.rGn.hOD)});
                j = (long) this.rGn.qPm;
            }
            int i3 = (int) j;
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.ae.n nVar = com.tencent.mm.kernel.g.Di().gPJ;
            if (this.scene == 0) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            nVar.a(new com.tencent.mm.plugin.sns.a.b.d(str, i2, 2, this.rGn.qPm, null, null, 2, btZ, -1, i, i3, i3, 0), 0);
        }
        x.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
        if (this.qQH && this.rGr != null && this.rGr.xl(32)) {
            j.a(j.b.qPU, j.a.qPP, this.rGr);
        }
        ae.bvq().b(this);
        com.tencent.mm.modelsns.b q = com.tencent.mm.modelsns.b.q(getIntent());
        if (q != null) {
            if (this.qQH) {
                q.bU(!bh.ov(this.fHC.wxL));
            } else {
                q.bU(false);
            }
            q.update();
            q.Sx();
        }
        if (com.tencent.mm.p.a.ux() != null) {
            com.tencent.mm.p.a.ux().wA();
        }
        if (this.kTe != null) {
            this.kTe.a(null);
            this.kTe.stop();
            this.kTe.onDetach();
        }
        if (!this.quT) {
            com.tencent.mm.sdk.b.b rtVar = new rt();
            rtVar.fJy.type = 0;
            rtVar.fJy.fJz = this.qtX;
            rtVar.fJy.fJA = this.msn;
            rtVar.fJy.fJB = this.fJB;
            com.tencent.mm.sdk.b.a.xef.m(rtVar);
        }
        this.jtl.bx(false);
    }

    public void onStart() {
        Bundle bundle = this.kRZ;
        if (!this.kSa) {
            this.kSa = true;
            if (VERSION.SDK_INT >= 12) {
                this.kSc = getIntent().getIntExtra("img_gallery_top", 0);
                this.kSd = getIntent().getIntExtra("img_gallery_left", 0);
                this.kSe = getIntent().getIntExtra("img_gallery_width", 0);
                this.kSf = getIntent().getIntExtra("img_gallery_height", 0);
                this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
                if (bundle == null) {
                    this.qvc.getViewTreeObserver().addOnPreDrawListener(new 3(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (!this.isInit) {
            x.i("MicroMsg.SnsSightPlayerUI", "initOrientation " + getResources().getConfiguration().orientation);
            if (getResources().getConfiguration().orientation == 2) {
                O(getResources().getConfiguration().orientation, true);
            }
            this.isInit = true;
        }
        if (this.qvl == 0 || this.qvk == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qvl = displayMetrics.heightPixels;
            this.qvk = displayMetrics.widthPixels;
        }
        if (this.rEx && FileOp.bO(this.hDC)) {
            ic(false);
            this.rEx = false;
        }
        if (this.rGn != null) {
            this.rGn.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        x.i("MicroMsg.SnsSightPlayerUI", "onpause  " + i);
        xL(i);
        if (this.rEx) {
            bxv();
        } else {
            bxv();
            x.v("check", "onclick");
            new af().post(new 2(this));
        }
        if (this.rGn != null) {
            this.rGn.hOC = bh.Wq();
        }
    }

    public final void avV() {
        int width = this.qvc.getWidth();
        int height = this.qvc.getHeight();
        if (!(this.kSe == 0 || this.kSf == 0)) {
            height = (int) ((((float) width) / ((float) this.kSe)) * ((float) this.kSf));
        }
        this.kSb.fg(width, height);
        this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
        if (((double) this.rzi) != 1.0d) {
            width = com.tencent.mm.ui.ae.fx(this.mController.xIM);
            this.kSb.zkM = 1.0f / this.rzi;
            if (!(this.rzj == 0 && this.rzk == 0)) {
                this.kSb.fh(((int) (((float) (this.qvc.getWidth() / 2)) * (1.0f - this.rzi))) + this.rzj, (int) ((((float) ((width + this.qvc.getHeight()) / 2)) - (((float) (height / 2)) * this.rzi)) + ((float) this.rzk)));
            }
        }
        this.kSb.a(this.qvc, this.mxv, new 4(this), null);
    }

    public void onBackPressed() {
        avV();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bh.F(stringExtra.split(","))) {
                    if (this.scene == 0) {
                        m Lm = ae.bvv().Lm(this.fus);
                        if (Lm != null) {
                            com.tencent.mm.sdk.b.b psVar;
                            if (s.eV(str)) {
                                psVar = new ps();
                                psVar.fHv.fzW = i.g(Lm);
                                psVar.fHv.frH = Lm.byq();
                                com.tencent.mm.sdk.b.a.xef.m(psVar);
                            } else {
                                psVar = new pt();
                                psVar.fHw.fzW = i.g(Lm);
                                psVar.fHw.frH = Lm.byq();
                                com.tencent.mm.sdk.b.a.xef.m(psVar);
                            }
                        }
                    }
                    bnp bxV = this.rGr.bxV();
                    if (this.qQH) {
                        b bxR = this.rGr.bxR();
                        bmf com_tencent_mm_protocal_c_bmf = new bmf();
                        com_tencent_mm_protocal_c_bmf.weC = this.fHC.rNe;
                        com_tencent_mm_protocal_c_bmf.hdo = this.fHC.wxL;
                        if (bxV.wQo.vYc == 15) {
                            com_tencent_mm_protocal_c_bmf.hdu = this.rGr.bxT().qZM;
                            com_tencent_mm_protocal_c_bmf.hdv = bxV.nGJ;
                        } else {
                            com_tencent_mm_protocal_c_bmf.hdu = bxV.wQt.hdu;
                            com_tencent_mm_protocal_c_bmf.hdv = bxV.wQt.hdv;
                        }
                        com_tencent_mm_protocal_c_bmf.hdq = bh.ov(this.fHC.wxP) ? bxV.wQl : this.fHC.wxP;
                        if (bh.ov(this.fHC.wxO)) {
                            stringExtra = this.fHC.wxE;
                        } else {
                            stringExtra = this.fHC.wxO;
                        }
                        com_tencent_mm_protocal_c_bmf.hdt = stringExtra;
                        if (bxR != null && bxR.reD == 0) {
                            com_tencent_mm_protocal_c_bmf.hds = bxR.reF;
                            com_tencent_mm_protocal_c_bmf.hdr = bxR.reE;
                        }
                        if (bxR != null) {
                            com_tencent_mm_protocal_c_bmf.hds = bxR.rdQ;
                        }
                        x.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[]{str, this.hDC, this.imagePath, this.fHC.wxL, Integer.valueOf(this.fHC.rNe), com_tencent_mm_protocal_c_bmf.hdt, Integer.valueOf(i.JS(this.hDC))});
                        com.tencent.mm.plugin.messenger.a.f.aZh().a(this, str, this.hDC, this.imagePath, 43, r7, com_tencent_mm_protocal_c_bmf, false, false, bxV.rtA);
                    } else {
                        x.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[]{str, this.hDC, this.imagePath, Integer.valueOf(i.JS(this.hDC))});
                        com.tencent.mm.plugin.messenger.a.f.aZh().a(this, str, this.hDC, this.imagePath, 43, r7, bxV.rtA);
                    }
                    if (stringExtra2 != null) {
                        com.tencent.mm.plugin.messenger.a.f.aZh().dj(stringExtra2, str);
                    }
                    com.tencent.mm.ui.snackbar.a.h(this, getString(com.tencent.mm.plugin.sns.i.j.epb));
                    if (this.qQH) {
                        j.c cVar;
                        int gl;
                        k cVar2 = new c(this.rGr.byz(), 12, 5, "", 2, this.rGr.bxW());
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                        boolean eV = s.eV(str);
                        j.d dVar = j.d.qQf;
                        if (eV) {
                            cVar = j.c.qQc;
                        } else {
                            cVar = j.c.qQb;
                        }
                        j$e com_tencent_mm_plugin_sns_a_b_j_e = j$e.Full;
                        if (eV) {
                            gl = com.tencent.mm.z.m.gl(str);
                        } else {
                            gl = 0;
                        }
                        j.a(dVar, cVar, com_tencent_mm_plugin_sns_a_b_j_e, gl, this.rGr);
                    }
                }
            } else if (this.qQH) {
                k cVar3 = new c(this.rGr.byz(), 13, 5, "", 2, this.rGr.bxW());
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(cVar3, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void JT(String str) {
    }

    public final void aE(String str, boolean z) {
    }

    public final void bun() {
    }

    public final void aF(String str, boolean z) {
        x.i("MicroMsg.SnsSightPlayerUI", "onSightFinish " + str);
        if (this.qQH && !bh.ov(str) && this.fHC != null && str.equals(this.fHC.nGJ) && FileOp.bO(this.hDC)) {
            this.rGn.qPl = 1;
            this.kTe.setVideoPath(this.hDC);
            ic(true);
            if (this.rGq != null) {
                this.rGq.setVisibility(8);
            }
        }
    }

    protected final int getForceOrientation() {
        return 7;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + configuration.orientation + " " + this.qvs);
        if (this.qvs != configuration.orientation) {
            int i = configuration.orientation;
            O(configuration.orientation, false);
            this.qvs = configuration.orientation;
        }
    }

    private void O(int i, boolean z) {
        if (this.qvl == 0 || this.qvk == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qvl = displayMetrics.heightPixels;
            this.qvk = displayMetrics.widthPixels;
        }
        LayoutParams layoutParams = this.qvc.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.rGp.getLayoutParams();
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (i == 1) {
            layoutParams3.width = this.qvk;
            layoutParams3.height = (int) (((((double) this.qvk) * 1.0d) * 240.0d) / 320.0d);
            layoutParams2.addRule(12, 0);
            layoutParams2.addRule(1, 0);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(3, this.qvc.getId());
            findViewById(com.tencent.mm.plugin.sns.i.f.cSe).setVisibility(0);
        } else {
            layoutParams3.height = this.qvk;
            layoutParams3.width = (int) (((((double) this.qvk) * 1.0d) * 320.0d) / 240.0d);
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(1, this.qvc.getId());
            findViewById(com.tencent.mm.plugin.sns.i.f.cSe).setVisibility(8);
        }
        x.i("MicroMsg.SnsSightPlayerUI", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.kTe).setLayoutParams(layoutParams3);
        if (this.kTe instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.kTe).dt(layoutParams3.width, layoutParams3.height);
        }
        layoutParams.height = layoutParams3.height;
        layoutParams.width = layoutParams3.width;
        this.quS.setLayoutParams(layoutParams2);
        this.qvc.setLayoutParams(layoutParams);
        ((View) this.kTe).requestLayout();
        if (!z) {
            xL(i);
        }
    }

    private void xL(int i) {
        if (this.qQH && this.kTe.isPlaying()) {
            if (this.duration == 0) {
                this.duration = this.kTe.getDuration();
            }
            this.rGn.wr(this.duration);
            this.rGn.qPt.qQv = bh.Wq();
            this.rGn.qPt.qQu = i == 2 ? 2 : 1;
            this.rGn.qPt.qQt = 2;
            x.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.rGn.qPt.qQu);
        }
    }
}
