package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.a.b.i.5;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.bh.1;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.z.an;
import java.util.HashSet;
import java.util.Set;

public class SnsTimeLineUI extends WxPresenterActivity implements e, a, u, an {
    private static final Set<Activity> rIE = new HashSet();
    private int hEF;
    private String jKk;
    private long kCY;
    private ActionBar mActionBar;
    private int mScreenHeight;
    private int mScreenWidth;
    private int oNO;
    private c qXs;
    private final long rHI = 300;
    private long rHJ = SystemClock.elapsedRealtime();
    private b rHK = ((b) q(b.class));
    private com.tencent.mm.plugin.sns.j.a rHL;
    private ax rHM;
    private LinearLayout rHN;
    private QFadeImageView rHO;
    private boolean rHP;
    private boolean rHQ;
    private j rHR;
    private a rHS;
    private TestTimeForSns rHT;
    private int rHU;
    private boolean rHV;
    private String rHW;
    private com.tencent.mm.plugin.sns.h.a rHX;
    private au rHY;
    private as rHZ;
    private Runnable rIA;
    private bb.a rIB;
    private com.tencent.mm.vending.app.a.b rIC;
    boolean rID;
    private OnMenuItemClickListener rIF;
    private View rIG;
    private ImageView rIH;
    private View rII;
    private MenuItem rIJ;
    private ba rIK;
    private OnClickListener rIL;
    private boolean rIM;
    private String rIa;
    private boolean rIb;
    private int rIc;
    private bb rId;
    private Runnable rIe;
    private c rIf;
    private boolean rIg;
    private c rIh;
    private c rIi;
    private c rIj;
    private c rIk;
    private c rIl;
    private c rIm;
    private c rIn;
    private c rIo;
    private c rIp;
    private c rIq;
    private c rIr;
    private c rIs;
    private c rIt;
    private c rIu;
    private long rIv;
    boolean rIw;
    Runnable rIx;
    Runnable rIy;
    private Handler rIz;
    private boolean raY;
    private boolean rrB;
    private boolean rtl;
    protected g rzU;

    public SnsTimeLineUI() {
        this.rHL = this.rHK != null ? this.rHK.bCJ() : null;
        this.rHP = false;
        this.rHQ = false;
        this.rrB = false;
        this.rHU = 0;
        this.rHV = false;
        this.rHW = "";
        this.rHX = new com.tencent.mm.plugin.sns.h.a();
        this.rzU = new g(1);
        this.rHY = new au();
        this.rHZ = new as();
        this.rIe = new 1(this);
        this.rIf = new 12(this);
        this.rIg = false;
        this.raY = false;
        this.rIh = new c<km>(this) {
            final /* synthetic */ SnsTimeLineUI rIN;

            {
                this.rIN = r2;
                this.xen = km.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (((km) bVar) instanceof km) {
                    this.rIN.rHK.rRU.b(this.rIN.jKk, this.rIN.rIb, this.rIN.rtl, this.rIN.rIc);
                    this.rIN.rHM.notifyDataSetChanged();
                }
                return false;
            }
        };
        this.rIi = new 34(this);
        this.rIj = new 45(this);
        this.rIk = new 49(this);
        this.rIl = new 50(this);
        this.rIm = new 51(this);
        this.rIn = new 52(this);
        this.rIo = new 2(this);
        this.rIp = new 3(this);
        this.qXs = new 4(this);
        this.rIq = new 5(this);
        this.rIr = new 6(this);
        this.rIs = new 7(this);
        this.rIt = new 8(this);
        this.rIu = new 9(this);
        this.rIv = 0;
        this.rIw = false;
        this.oNO = 0;
        this.rIx = new 15(this);
        this.rIy = new 16(this);
        this.rIz = ((com.tencent.mm.vending.h.b) d.zCP.zCV).mHandler;
        this.rIA = new 17(this);
        this.rIB = new 18(this);
        this.rIC = new 19(this);
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.rID = true;
        this.kCY = 0;
        this.rIF = new 36(this);
        this.rIK = null;
        this.rIL = new 42(this);
        this.rIM = false;
    }

    static /* synthetic */ void C(SnsTimeLineUI snsTimeLineUI) {
        int i = 1;
        if (snsTimeLineUI.rHU <= 3) {
            int firstVisiblePosition = snsTimeLineUI.rId.nKG.getFirstVisiblePosition();
            if (System.currentTimeMillis() - snsTimeLineUI.rIv > 1000 || firstVisiblePosition > snsTimeLineUI.oNO) {
                snsTimeLineUI.rIv = 0;
                snsTimeLineUI.oNO = snsTimeLineUI.rId.nKG.getFirstVisiblePosition();
            }
            snsTimeLineUI.rIv = System.currentTimeMillis();
            if (snsTimeLineUI.oNO - firstVisiblePosition >= 10 && firstVisiblePosition > 10) {
                x.i("MicroMsg.SnsTimeLineUI", "showTopTip %d", Integer.valueOf(snsTimeLineUI.rHU));
                if (snsTimeLineUI.rHU <= 3) {
                    p pVar = snsTimeLineUI.mController;
                    if (pVar.mActionBar == null || pVar.mActionBar.getCustomView() == null || pVar.mActionBar.getCustomView().findViewById(com.tencent.mm.w.a.g.gVh) == null) {
                        i = 0;
                    }
                    if (i == 0) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snsTimeLineUI.mController.xIM, i.a.qyt);
                        CharSequence string = snsTimeLineUI.getString(j.qKo);
                        p pVar2 = snsTimeLineUI.mController;
                        if (pVar2.mActionBar != null) {
                            pVar2.mActionBar.setCustomView(p.xJe);
                            TextView textView = (TextView) pVar2.mActionBar.getCustomView().findViewById(com.tencent.mm.w.a.g.gVh);
                            if (textView != null) {
                                textView.clearAnimation();
                                if (loadAnimation != null) {
                                    textView.startAnimation(loadAnimation);
                                }
                                if (!bh.ov(string)) {
                                    textView.setText(string);
                                }
                            }
                        }
                        snsTimeLineUI.mController.removeAllOptionMenu();
                        snsTimeLineUI.removeOptionMenu(16908332);
                        snsTimeLineUI.bBF();
                        snsTimeLineUI.rHU++;
                        ae.aNT().removeCallbacks(snsTimeLineUI.rIA);
                        ae.aNT().postDelayed(snsTimeLineUI.rIA, 4000);
                    }
                }
            }
        }
    }

    static /* synthetic */ void E(SnsTimeLineUI snsTimeLineUI) {
        x.i("MicroMsg.SnsTimeLineUI", "double click");
        BackwardSupportUtil.c.a(snsTimeLineUI.rId.nKG);
        snsTimeLineUI.rHO.setVisibility(0);
        snsTimeLineUI.rIA.run();
        snsTimeLineUI.rHR.bze();
        snsTimeLineUI.bzr();
        new af().postDelayed(new 43(snsTimeLineUI), 300);
    }

    static /* synthetic */ void F(SnsTimeLineUI snsTimeLineUI) {
        snsTimeLineUI.bBH();
        if (!(snsTimeLineUI.rHR == null || snsTimeLineUI.rHR.rrt == null)) {
            snsTimeLineUI.rHR.rrt.qWT.ip(true);
        }
        com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(705);
        iu.iy(iu.hOF).mC(System.currentTimeMillis()).iy(iu.hOH).iy(1);
        snsTimeLineUI.rIK = new ba(snsTimeLineUI);
        snsTimeLineUI.rIK.rKC = new 40(snsTimeLineUI);
        snsTimeLineUI.rIK.d(3, snsTimeLineUI.mController.xIM.getString(j.qJt));
        snsTimeLineUI.rIK.rKD = new 41(snsTimeLineUI, iu);
        snsTimeLineUI.rIK.bBX();
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i) {
        com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(507);
        int firstVisiblePosition = snsTimeLineUI.rId.nKG.getFirstVisiblePosition() - 1;
        int lastVisiblePosition = snsTimeLineUI.rId.nKG.getLastVisiblePosition() - 1;
        int count = snsTimeLineUI.rHM.getCount();
        while (firstVisiblePosition <= lastVisiblePosition) {
            if (firstVisiblePosition < count && firstVisiblePosition >= 0 && firstVisiblePosition != i) {
                if (i > firstVisiblePosition) {
                    String g = com.tencent.mm.plugin.sns.data.i.g(snsTimeLineUI.rHR.qZU.xt(firstVisiblePosition));
                    if (iu.St()) {
                        if (iu.hON.length() != 0) {
                            iu.hON.append("||" + g);
                        } else if (bh.ov(g)) {
                            iu.hON.append(" ");
                        } else {
                            iu.hON.append(g);
                        }
                    }
                } else {
                    iu.mB(com.tencent.mm.plugin.sns.data.i.g(snsTimeLineUI.rHR.qZU.xt(firstVisiblePosition)));
                }
            }
            firstVisiblePosition++;
        }
        iu.Sx();
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i, int i2, gl glVar) {
        int firstVisiblePosition = snsTimeLineUI.rHR.nKG.getFirstVisiblePosition();
        int headerViewsCount = snsTimeLineUI.rHR.nKG.getHeaderViewsCount();
        m xt = snsTimeLineUI.rHR.qZU.xt(i2);
        if (xt != null) {
            bnp bxV = xt.bxV();
            if (bxV.wQo.vYc == 1 && bxV.wQo.vYd.size() == 4 && i > 1) {
                i++;
            }
        } else {
            x.e("MicroMsg.SnsTimeLineUI", "snsInfo is null");
        }
        View childAt = snsTimeLineUI.rHR.nKG.getChildAt((i2 - firstVisiblePosition) + headerViewsCount);
        if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c)) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) childAt.getTag();
            if (cVar.rOg != null) {
                TagImageView xy = cVar.rOg.xy(i);
                if (xy != null) {
                    int[] iArr = new int[2];
                    xy.getLocationInWindow(iArr);
                    glVar.fwz.foL = iArr[0];
                    glVar.fwz.foM = iArr[1];
                    glVar.fwz.foN = xy.getWidth();
                    glVar.fwz.foO = xy.getHeight();
                }
            }
        }
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, com.tencent.mm.plugin.sns.j.c.b bVar) {
        snsTimeLineUI.rHN.setVisibility(0);
        ((TextView) snsTimeLineUI.findViewById(f.qFd)).setText(snsTimeLineUI.getResources().getQuantityString(h.qIv, bVar.rRY, new Object[]{Integer.valueOf(bVar.rRY)}));
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) snsTimeLineUI.findViewById(f.qFb), bVar.rRX);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        this.rIz.removeCallbacks(this.rIe);
        com.tencent.mm.vending.g.g.czW().c(new 11(this, str)).e(new 10(this, z2, z));
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
        this.rIz.removeCallbacks(this.rIe);
        com.tencent.mm.vending.g.g.czW().c(new 14(this, str)).e(new 13(this, z));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        x.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", keyEvent.toString());
        int i2 = this.mController.xJg;
        j jVar = this.rHR;
        if (keyEvent.getKeyCode() == 4 && jVar.rrw.getVisibility() == 0) {
            jVar.rrw.setVisibility(8);
            i = 1;
        }
        if (i == 0 || i2 != 2) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        if (this.mController != null) {
            this.mController.ad(2, true);
        }
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        com.tencent.mm.pluginsdk.e.h(this);
        super.onCreate(bundle);
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            int da = com.tencent.mm.z.c.c.IG().da("Sns_Private_Recent_Setting_Guide", 0);
            x.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = " + da);
            if (da == 1) {
                com.tencent.mm.kernel.g.Dk();
                if (!com.tencent.mm.kernel.g.Dj().CU().getBoolean(w.a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, false)) {
                    Intent intent = getIntent();
                    intent.setClass(this.mController.xIM, SnsSettingIntroduceUI.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, Boolean.valueOf(true));
                }
            }
            com.tencent.mm.ca.b.clp();
            this.rHL.a(com.tencent.mm.plugin.sns.j.c.b.class, this.rIC);
            this.rHL.a(this);
            com.tencent.mm.plugin.sns.j.c.a aVar = (com.tencent.mm.plugin.sns.j.c.a) this.rHL.J(com.tencent.mm.plugin.sns.j.c.a.class);
            this.jKk = aVar.jKk;
            this.rIa = aVar.rIa;
            this.rIb = aVar.rIb;
            this.rtl = aVar.rtl;
            this.rIc = aVar.rIc;
            String str = aVar.nlp;
            String str2 = aVar.rLk;
            this.rId = new bb(this);
            this.rId.rLj = this.rIB;
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().fm(2);
            com.tencent.mm.plugin.sns.ui.widget.d.bCF().rRJ = 0;
            com.tencent.mm.plugin.sns.ui.widget.b.bCD().rRJ = 0;
            com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.hOR;
            com.tencent.mm.modelsns.c.Sy();
            this.rHR = new j(this, getIntent().getBooleanExtra("is_sns_notify_open", true) ? 1 : 0, bh.az(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0));
            this.rrB = getIntent().getBooleanExtra("sns_resume_state", true);
            if (ae.bve()) {
                this.rrB = false;
            } else if (this.rrB) {
                this.rrB = ae.bvC().bAa();
            }
            this.rHP = this.rrB;
            this.rId.a(this.rIa, this.jKk, str, str2, this.rIb, this.rtl, this.rIc);
            this.rId.onCreate();
            ae.bvm().init();
            this.mActionBar = getSupportActionBar();
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(682, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(218, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a((int) com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(683, (e) this);
            initView();
            com.tencent.mm.plugin.sns.f.c bvm = ae.bvm();
            ListView listView = this.rId.nKG;
            av avVar = this.rHM.rJu;
            bvm.qZT = listView;
            bvm.qZU = avVar;
            e bvm2 = ae.bvm();
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a((int) JsApiCreateAudioInstance.CTRL_INDEX, bvm2);
            this.rHQ = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
            this.rHR.mxl = (ClipboardManager) getSystemService("clipboard");
            if (ae.bve()) {
                this.rrB = false;
            } else if (this.rrB) {
                this.rrB = ae.bvC().bAa();
            }
            com.tencent.mm.vending.app.a aVar2 = this.rHL;
            aVar2.rJv = this.rHM.rJv;
            aVar2.zAS.keep(aVar2.rJv);
            if (this.rrB) {
                this.rHQ = false;
                da = ae.bvC().position;
                aw awVar = this.rHM.rJv;
                String str3 = ae.bvC().maQ;
                synchronized (awVar.rJp) {
                    awVar.maQ = str3;
                }
                this.rHM.rJv.rwz = ae.bvC().rwz;
                this.rHM.rJv.rJo = true;
                this.rHM.ks();
                if (da >= this.rHM.getCount()) {
                    da = this.rHM.getCount() - 1;
                    x.e("MicroMsg.SnsTimeLineUI", "error position %s", Integer.valueOf(this.rHM.getCount()));
                }
                this.rId.nKG.setAdapter(this.rHM);
                x.d("MicroMsg.SnsTimeLineUI", "resume position %s", Integer.valueOf(ae.bvC().rwA));
                this.rId.nKG.setSelectionFromTop(da, ae.bvC().rwA);
                this.rHO.setVisibility(4);
            } else {
                this.rId.nKG.setAdapter(this.rHM);
                this.rHO.setVisibility(0);
                this.rHM.ks();
            }
            int count = this.rHM.getCount();
            da = this.rId.nKG.getFirstVisiblePosition();
            if (da < count) {
                this.rHW = com.tencent.mm.plugin.sns.data.i.g(this.rHM.xt(da));
            }
            com.tencent.mm.kernel.g.Dk();
            this.rHU = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(327776, Integer.valueOf(0))).intValue();
            this.rHR.rrD = new bh(this, this.rHM.rJu, this.rHR.qZp);
            this.rHR.rrF = new com.tencent.mm.plugin.sns.f.b(this, this.rHM.rJu.qZo, this.rHR.qZp);
            this.rHR.rrE = new c(this, this.rHM.rJu.qZo, this.rHR.qZp, this.rHR.rrF);
            if (this.rHZ != null) {
                this.rHZ.a(this.rHR.rrF);
            }
            if (count > 0) {
                m xt = this.rHM.xt(0);
                if (!(this.rHR.rrt == null || this.rHR.rrt.qWT == null)) {
                    this.rHR.rrt.qWT.rbt = xt.field_snsId;
                }
                com.tencent.mm.plugin.sns.h.d dVar = com.tencent.mm.plugin.sns.h.d.rdA;
                if (dVar.gLV != 0) {
                    if (dVar.rdB.isEmpty()) {
                        dVar.gyV.setLong(2, bh.Wo());
                        dVar.rdC.clear();
                    }
                    x.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", Integer.valueOf(dVar.rdB.size()));
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.k(13312, "1," + bh.Wp());
            com.tencent.mm.sdk.b.a.xef.b(this.rIf);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false)) {
                ag.h(new Runnable(this) {
                    final /* synthetic */ SnsTimeLineUI rIN;

                    {
                        this.rIN = r1;
                    }

                    public final void run() {
                        com.tencent.mm.ui.base.h.a(this.rIN, this.rIN.getString(j.eyT), "", this.rIN.getString(j.eyU), this.rIN.getString(j.dEn), new 1(this), new 2(this));
                    }
                }, 500);
                getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Dh().Cy()) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().CU().set(589825, Boolean.valueOf(false));
            }
            this.rHR.rrs = this.rzU;
            g gVar = this.rzU;
            count = this.rId.qOh;
            View customView = this.mActionBar.getCustomView();
            gVar.qOh = count;
            gVar.qPa = customView;
            gVar.activity = this;
            com.tencent.mm.sdk.b.a.xef.b(this.rIj);
            com.tencent.mm.sdk.b.a.xef.b(this.rIk);
            com.tencent.mm.sdk.b.a.xef.b(this.rIl);
            com.tencent.mm.sdk.b.a.xef.b(this.rIm);
            com.tencent.mm.sdk.b.a.xef.b(this.rIn);
            com.tencent.mm.sdk.b.a.xef.b(this.rIp);
            com.tencent.mm.sdk.b.a.xef.b(this.rIo);
            com.tencent.mm.sdk.b.a.xef.b(this.qXs);
            com.tencent.mm.sdk.b.a.xef.b(this.rIq);
            com.tencent.mm.sdk.b.a.xef.b(this.rIr);
            com.tencent.mm.sdk.b.a.xef.b(this.rIt);
            com.tencent.mm.sdk.b.a.xef.b(this.rIs);
            com.tencent.mm.sdk.b.a.xef.b(this.rIu);
            com.tencent.mm.plugin.sns.abtest.c.btU();
            com.tencent.mm.plugin.sns.abtest.a.d(this, this.rHR.qZp);
            if (this.rHX != null) {
                com.tencent.mm.plugin.sns.h.a aVar3 = this.rHX;
                listView = this.rId.nKG;
                SnsHeader snsHeader = this.rId.raX;
                aVar3.inm = listView;
                aVar3.raX = snsHeader;
            }
            if (!(this.rHR == null || this.rHR.rrt == null)) {
                com.tencent.mm.plugin.sns.h.b bVar = this.rHR.rrt.qWT;
                x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
                bVar.rbs = true;
                bVar.rdp = System.currentTimeMillis();
            }
            boolean booleanExtra = getIntent().getBooleanExtra("enter_by_red", false);
            if (!(this.rHR == null || this.rHR.rrt == null)) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.rHR.rrt.qWT;
                if (!booleanExtra) {
                    i = 0;
                }
                bVar2.rbF = i;
            }
            ae.bvs().qSV.clear();
            com.tencent.mm.pluginsdk.e.i(this);
            return;
        }
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
        com.tencent.mm.sdk.b.a.xef.m(new bt());
        com.tencent.mm.pluginsdk.e.i(this);
        com.tencent.mm.plugin.sns.ui.widget.d.bCF().rRJ = 0;
        com.tencent.mm.plugin.sns.ui.widget.b.bCD().rRJ = 0;
        com.tencent.mm.kiss.widget.textview.c.gTj.Eb();
        this.rHM.rJu.bBx();
        this.rHM.rJv.resolvedClear();
    }

    public void onDestroy() {
        long j;
        int i;
        String str;
        int i2;
        this.rHV = true;
        x.i("MicroMsg.SnsTimeLineUI", "timeline on destory");
        com.tencent.mm.sdk.b.a.xef.c(this.rIj);
        com.tencent.mm.sdk.b.a.xef.c(this.rIk);
        com.tencent.mm.sdk.b.a.xef.c(this.rIl);
        com.tencent.mm.sdk.b.a.xef.c(this.rIm);
        com.tencent.mm.sdk.b.a.xef.c(this.rIn);
        com.tencent.mm.sdk.b.a.xef.c(this.rIp);
        com.tencent.mm.sdk.b.a.xef.c(this.rIo);
        com.tencent.mm.sdk.b.a.xef.c(this.qXs);
        com.tencent.mm.sdk.b.a.xef.c(this.rIq);
        com.tencent.mm.sdk.b.a.xef.c(this.rIr);
        com.tencent.mm.sdk.b.a.xef.c(this.rIs);
        com.tencent.mm.sdk.b.a.xef.c(this.rIt);
        com.tencent.mm.sdk.b.a.xef.c(this.rIu);
        if (!(this.rHR == null || this.rHR.rrt == null)) {
            this.rHR.rrt.qWT.rbG = this.rIg ? 1 : 0;
        }
        com.tencent.mm.plugin.sns.h.d dVar = com.tencent.mm.plugin.sns.h.d.rdA;
        if (dVar.gLV != 0) {
            x.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", Integer.valueOf(dVar.rdB.size()), Integer.valueOf(dVar.rdC.size()));
            j = dVar.gyV.getLong(2, 0);
            if (dVar.rdB.isEmpty() || (dVar.rdB.size() <= dVar.rdD && bh.by(j) <= ((long) dVar.rdE))) {
                dVar.gyV.set(3, dVar.rdB);
                dVar.gyV.set(4, dVar.rdC);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                i = 0;
                for (String str2 : dVar.rdB.keySet()) {
                    String str3 = (String) dVar.rdC.get(str2);
                    if (bh.ov(str3)) {
                        int i3 = i;
                        str = "";
                        i2 = i3;
                    } else {
                        str = str3;
                        i2 = 1;
                    }
                    stringBuffer.append(str2 + "#" + dVar.rdB.get(str2) + "#" + str + "|");
                    i = i2;
                }
                stringBuffer.append("," + j + "," + bh.Wo() + ",1," + i);
                x.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", Integer.valueOf(13226), stringBuffer);
                com.tencent.mm.plugin.report.service.g.pQN.k(13226, stringBuffer.toString());
                dVar.gyV.set(3, null);
                dVar.gyV.set(4, null);
                dVar.rdB.clear();
                dVar.rdC.clear();
                dVar.gyV.setLong(2, bh.Wo());
            }
        }
        com.tencent.mm.kernel.g.Dk();
        String str22 = (String) com.tencent.mm.kernel.g.Dj().CU().get(68377, null);
        int count = this.rHM.getCount();
        str = "";
        m mVar = null;
        if (count > 0) {
            mVar = this.rHM.xt(count - 1);
            str = com.tencent.mm.plugin.sns.data.i.g(mVar);
        }
        if (!(this.rHR == null || this.rHR.rrt == null)) {
            com.tencent.mm.plugin.sns.h.b bVar = this.rHR.rrt.qWT;
            i2 = mVar == null ? -1 : mVar.field_createTime;
            x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
            j = System.currentTimeMillis() - bVar.rdp;
            bVar.rbu += j;
            x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + j + " BrowseTime: " + bVar.rbu + "BackgroundTime: " + bVar.rcd);
            com.tencent.mm.sdk.f.e.b(new b$2(bVar, i2), "onTimelineDestroy_report", 1);
            bVar.rbs = false;
        }
        com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(704);
        if (iu.St()) {
            iu.bU(this.rIg);
            iu.bU(!bh.ov(str22));
            iu.mB(this.rHW);
            iu.mB(str);
            iu.mB(str);
            iu.ix(this.rId.rLi);
            iu.mB("");
            com.tencent.mm.modelsns.b.Sw();
            iu.Sx();
        }
        AdListView adListView = (AdListView) this.rId.bBK();
        this.rHZ.qXL.clear();
        ae.bvm().clean();
        ae.bvi().post(new 5(ae.bvp()));
        adListView.rpX.clear();
        adListView.rpX = null;
        adListView.rpY.buI();
        adListView.rpY = null;
        t.buQ();
        if (!ae.bve()) {
            this.rIz.removeCallbacks(this.rIe);
        }
        com.tencent.mm.kernel.g.Dk();
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b(682, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b(218, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b(683, (e) this);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().CU().set(327776, Integer.valueOf(this.rHU));
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().CU().set(589825, Boolean.valueOf(false));
        }
        if (this.rHR != null) {
            j jVar = this.rHR;
            jVar.rrG.aBM();
            if (jVar.rrw != null) {
                jVar.rrw.aXS();
            }
            com.tencent.mm.sdk.b.a.xef.c(jVar.rrI);
        }
        ae.aNT().removeCallbacks(this.rIA);
        if (this.rHM != null) {
            int i4;
            i = this.rId.nKG.getFirstVisiblePosition();
            i2 = 0;
            for (i4 = 0; i4 < this.rId.nKG.getCount(); i4++) {
                View childAt = this.rId.nKG.getChildAt(i4);
                if (childAt != null && this.rId.nKG.getPositionForView(childAt) == i) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    x.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", Integer.valueOf(r4), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                    i2 = iArr[1];
                }
            }
            i4 = BackwardSupportUtil.b.b((Context) this, 50.0f);
            if (!(ae.bve() || this.rHL.bvl() == null)) {
                aj bvC = ae.bvC();
                String str4 = this.rHM.rJv.maQ;
                String str5 = this.rHM.rJv.rwz;
                long j2 = this.rHL.bvl().qXh;
                int i5 = i2 - i4;
                bvC.rwy = bh.Wq();
                bvC.maQ = str4;
                bvC.rwz = str5;
                bvC.qXh = j2;
                bvC.position = i;
                bvC.rwA = i5;
                x.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", Long.valueOf(bvC.rwy), str4, str5, Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(bvC.rwA));
            }
            x.d("MicroMsg.SnsTimeLineUI", "top h %d", Integer.valueOf(i2 - i4));
            com.tencent.mm.sdk.b.a.xef.c(this.rHM.rJu.jeX);
            if (ae.bve()) {
                x.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
            } else {
                ae.bvs();
            }
            av avVar = this.rHM.rJu;
            if (avVar.rzL != null) {
                avVar.rzL.activity = null;
            }
            com.tencent.mm.sdk.b.a.xef.c(this.rHM.rJu.jeX);
            this.rHM.rJu.bBA();
        }
        az.clean();
        com.tencent.mm.sdk.b.a.xef.c(this.rIf);
        com.tencent.mm.kernel.g.Dk();
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            ae.bvs().qSV.clear();
        }
        this.rHM = null;
        this.rHR = null;
        ax.bBV();
        com.tencent.mm.plugin.sns.abtest.c.btV();
        e bvm = ae.bvm();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b((int) JsApiCreateAudioInstance.CTRL_INDEX, bvm);
        com.tencent.mm.plugin.sns.abtest.a.clean();
        this.rId.onDestroy();
        super.onDestroy();
        com.tencent.mm.kiss.widget.textview.c.gTj.Eb();
    }

    public void onResume() {
        int count;
        if (com.tencent.mm.sdk.a.b.ceK() && com.tencent.mm.sdk.a.b.ceI()) {
            rIE.add(this);
        }
        bb.onResume();
        super.onResume();
        this.kCY = bh.Wo();
        if (this.rID) {
            this.rID = false;
            count = this.rHM.getCount();
            if (getIntent().getBooleanExtra("is_from_find_more", false)) {
                com.tencent.mm.modelsns.b c = com.tencent.mm.modelsns.b.c(getIntent(), "enter_log");
                if (c != null) {
                    if (count > 0) {
                        String str;
                        m xt = this.rHM.xt(0);
                        if (xt == null) {
                            str = "0";
                        } else {
                            str = com.tencent.mm.plugin.sns.data.i.eq(xt.field_snsId);
                        }
                        c.mB(str);
                        if (xt == null) {
                            str = "0";
                        } else {
                            str = xt.field_createTime;
                        }
                        c.mB(str);
                        c.mB(String.valueOf(count));
                    } else {
                        c.mB("");
                        c.mB("");
                        c.mB("0");
                    }
                    c.Sx();
                }
            }
        }
        if (this.mScreenWidth == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            com.tencent.mm.plugin.sns.h.a aVar = this.rHX;
            count = this.mScreenWidth;
            int i = this.mScreenHeight;
            aVar.mScreenWidth = count;
            aVar.mScreenHeight = i;
        }
        if (ae.bve()) {
            finish();
        }
        ae.bvs().qSX = this.rHM.rJu;
        DW().K(com.tencent.mm.plugin.sns.j.c.b.class);
        t.a((an) this);
        if (this.rHQ) {
            this.rHO.post(new Runnable(this) {
                final /* synthetic */ SnsTimeLineUI rIN;

                {
                    this.rIN = r1;
                }

                public final void run() {
                    x.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + this.rIN.rHQ);
                    if (this.rIN.rHQ) {
                        this.rIN.rHQ = false;
                        this.rIN.rHS.bBS();
                    }
                }
            });
        } else {
            a aVar2 = this.rHS;
            if (aVar2.rIN.rHO.getVisibility() == 0) {
                aVar2.init();
                LayoutParams layoutParams = (LayoutParams) aVar2.rIN.rHO.getLayoutParams();
                layoutParams.y = (int) aVar2.rJb;
                aVar2.rIN.rHO.setLayoutParams(layoutParams);
                aVar2.rIN.rHO.invalidate();
            }
        }
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.fJz = this.rId.nKG.getFirstVisiblePosition();
        rtVar.fJy.fJA = this.rId.nKG.getLastVisiblePosition();
        rtVar.fJy.fJB = this.rId.nKG.getHeaderViewsCount();
        rtVar.fJy.type = 0;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        if (!(this.rHR == null || this.rHR.rrs == null)) {
            this.rHR.rrs.onResume();
        }
        if (this.rHM != null) {
            av avVar = this.rHM.rJu;
            com.tencent.mm.sdk.b.a.xef.b(avVar.rAc);
            com.tencent.mm.sdk.b.a.xef.b(avVar.rAb);
            com.tencent.mm.sdk.b.a.xef.b(avVar.rAd);
        }
        if (!(this.rHR == null || this.rHR.rrt == null)) {
            this.rHR.rrt.qWT.il(true);
            this.rHR.rrt.qWT.im(false);
            this.rHR.rrt.qWT.in(false);
            this.rHR.rrt.qWT.io(false);
            this.rHR.rrt.qWT.iy(false);
            com.tencent.mm.plugin.sns.h.b bVar = this.rHR.rrt.qWT;
            bVar.iw(false);
            bVar.ix(false);
            bVar.iq(false);
            bVar.iv(false);
            bVar.it(false);
            bVar.iv(false);
            bVar.iz(false);
            bVar.iu(false);
            bVar.iv(false);
            bVar.ir(false);
            bVar.is(false);
        }
        com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
        bvs.qSY = 0;
        bvs.qSZ = 0;
        com.tencent.mm.sdk.b.a.xef.b(this.rIi);
        com.tencent.mm.sdk.b.a.xef.b(this.rIh);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        this.rHO.clearAnimation();
        HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSScrollEnable, this.hEF);
        this.hEF = 0;
        t.b(this);
        ae.bvs().qSX = null;
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.type = 1;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        if (this.rHM != null) {
            av avVar = this.rHM.rJu;
            com.tencent.mm.sdk.b.a.xef.c(avVar.rAc);
            com.tencent.mm.sdk.b.a.xef.c(avVar.rAb);
            com.tencent.mm.sdk.b.a.xef.c(avVar.rAd);
        }
        if (!(this.rHR == null || this.rHR.rrs == null)) {
            this.rHR.rrs.onPause();
        }
        if (!(this.rHR == null || this.rHR.rrt == null)) {
            this.rHR.rrt.qWT.il(false);
        }
        com.tencent.mm.modelstat.d.f("SnsTimeLineUI", this.kCY, bh.Wo());
        bb.onPause();
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.rIi);
        com.tencent.mm.sdk.b.a.xef.c(this.rIh);
    }

    protected final int getLayoutId() {
        return i.g.qIf;
    }

    protected final void initView() {
        this.rId.raX.setDrawingCacheEnabled(false);
        this.rHR.qZp = (FrameLayout) findViewById(f.qFL);
        setMMTitle(j.qMv);
        int i = ae.bvC().position;
        AdListView adListView = (AdListView) this.rId.bBK();
        adListView.rpX = this.rzU;
        adListView.rpY = this.rHY;
        adListView.rpZ = this.rHZ;
        this.rHZ.a(ae.bvm());
        x.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.rrB, Integer.valueOf(i));
        this.rHO = (QFadeImageView) findViewById(f.qFo);
        this.rHO.setImageResource(i.i.qIN);
        this.rHS = new a(this, this.rId.bBK());
        this.rHS.setInterpolator(new LinearInterpolator());
        this.rHS.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ SnsTimeLineUI rIN;

            {
                this.rIN = r1;
            }

            public final void onAnimationStart(Animation animation) {
                x.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
            }

            public final void onAnimationRepeat(Animation animation) {
                x.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
            }

            public final void onAnimationEnd(Animation animation) {
                x.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
            }
        });
        this.rHM = new ax(this, this.rId.bBK(), this.rHR.rrG, this.rHR, this.rIa);
        this.rHR.rrG.rPV = new 24(this);
        this.rHR.qZU = this.rHM.rJu;
        this.rHM.rJv.zAP = new 25(this);
        this.rHT = (TestTimeForSns) this.rHR.qZp;
        this.rHT.setListener(new 26(this));
        this.rId.nKG.setOnTouchListener(new 27(this));
        this.rId.nKG.post(new 28(this));
        this.rId.onH.ycI = new 29(this);
        this.rHR.rrw = (SnsCommentFooter) findViewById(f.qBF);
        this.rHR.rrw.post(new 30(this));
        this.rHR.rrx = new bi(this.rId.nKG, this.rHR.rrw);
        this.rHN = (LinearLayout) this.rId.raX.findViewById(f.qFc);
        this.rHN.findViewById(f.qFa).setOnClickListener(new 31(this));
        SnsHeader snsHeader = this.rId.raX;
        OnClickListener 32 = new 32(this);
        if (!(snsHeader.rBF == null || snsHeader.rBF.ihQ == null)) {
            snsHeader.rBF.ihQ.setOnClickListener(32);
        }
        this.rHR.rry = new ao(this);
        bBG();
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        ag.y(new 33(this));
        if (this.mController.xJg == 2) {
            if (this.rHR != null && this.rHR.rrw != null && !this.rHR.rrw.bAN()) {
                x.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
            }
        } else if (this.mController.xJg == 1 && this.rHR != null) {
            j jVar = this.rHR;
            if (jVar.rru) {
                jVar.rru = false;
                jVar.rrx.bCl();
            }
        }
    }

    private void bBF() {
        aa(new 35(this));
    }

    public boolean supportNavigationSwipeBack() {
        return super.supportNavigationSwipeBack();
    }

    private void bBG() {
        bBF();
        setBackBtn(this.rIF, i.e.byy);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        this.rIJ = menu.add(0, 0, 0, j.qJS);
        if (this.rIG == null) {
            int dimensionPixelSize;
            int height = getSupportActionBar().getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(i.d.buF) : getResources().getDimensionPixelSize(i.d.buG);
            } else {
                dimensionPixelSize = height;
            }
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this, 56);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(fromDPToPix, dimensionPixelSize);
            this.rIG = View.inflate(this, i.g.qHX, null);
            this.rIH = (ImageView) this.rIG.findViewById(f.icon);
            this.rII = this.rIG.findViewById(f.cRY);
            this.rIG.setLayoutParams(layoutParams);
            this.rIG.setBackgroundResource(i.e.byA);
            this.rIG.setMinimumHeight(dimensionPixelSize);
            this.rIG.setMinimumWidth(fromDPToPix);
            this.rIH.setImageResource(i.i.dxi);
            this.rIG.setContentDescription(getString(j.eRi));
            this.rIG.setOnClickListener(new 37(this));
            this.rIG.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ SnsTimeLineUI rIN;

                {
                    this.rIN = r1;
                }

                public final boolean onLongClick(View view) {
                    if (!(this.rIN.rHR == null || this.rIN.rHR.rrt == null)) {
                        this.rIN.rHR.rrt.qWT.ip(true);
                    }
                    com.tencent.mm.kernel.g.Dk();
                    if (((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(7490, Boolean.valueOf(true))).booleanValue()) {
                        this.rIN.startActivity(new Intent().setClass(this.rIN, SnsLongMsgUI.class));
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().set(7490, Boolean.valueOf(false));
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(this.rIN, SnsUploadUI.class);
                        intent.putExtra("KSnsPostManu", true);
                        intent.putExtra("KTouchCameraTime", bh.Wo());
                        intent.putExtra("sns_comment_type", 1);
                        intent.putExtra("Ksnsupload_type", 9);
                        com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(705);
                        iu.iy(iu.hOF).mC(System.currentTimeMillis()).iy(iu.hOH).iy(1);
                        iu = com.tencent.mm.plugin.sns.h.e.rdF.b(iu);
                        iu.Sx();
                        iu.b(intent, "intent_key_StatisticsOplog");
                        this.rIN.startActivityForResult(intent, 9);
                    }
                    return true;
                }
            });
            this.rIG.post(new Runnable(this) {
                final /* synthetic */ SnsTimeLineUI rIN;

                {
                    this.rIN = r1;
                }

                public final void run() {
                    this.rIN.supportInvalidateOptionsMenu();
                }

                public final String toString() {
                    return super.toString() + "|supportInvalidateOptionsMenu";
                }
            });
        }
        android.support.v4.view.m.a(this.rIJ, this.rIG);
        android.support.v4.view.m.a(this.rIJ, 2);
        this.rIJ.setVisible(true);
        bBH();
        return onCreateOptionsMenu;
    }

    private void bBH() {
        if (this.rII != null) {
            this.rII.setVisibility(8);
        }
    }

    private void bBI() {
        if (!com.tencent.mm.p.a.aU(this)) {
            x.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 18, "", "")), bh.cgy(), this);
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                x.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bh.cgy(), this);
                if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(13822, Integer.valueOf(1), Integer.valueOf(2));
                    k.x(this.mController.xIM, new Intent());
                }
            }
        }
    }

    public final boolean cH(View view) {
        this.rHR.rrE.bwm();
        bh bhVar = this.rHR.rrD;
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
            String str = cVar.frH;
            if (bhVar.rMK != null) {
                if (bhVar.rMK.getTag() instanceof bh$a) {
                    bh$a com_tencent_mm_plugin_sns_ui_bh_a = (bh$a) bhVar.rMK.getTag();
                    if (com_tencent_mm_plugin_sns_ui_bh_a.qZJ.equals(str)) {
                        bhVar.cJ(com_tencent_mm_plugin_sns_ui_bh_a.qOe);
                        return true;
                    }
                    bhVar.bzr();
                }
                bhVar.rMK = null;
            }
            bhVar.rMK = new SnsCommentShowAbLayout(bhVar.mContext);
            l.bC(bhVar.rMK);
            bhVar.rMK.setId(f.daa);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            bhVar.qZp.addView(bhVar.rMK);
            int b = BackwardSupportUtil.b.b(bhVar.mContext, 192.0f);
            int b2 = BackwardSupportUtil.b.b(bhVar.mContext, 76.0f);
            BackwardSupportUtil.b.b(bhVar.mContext, 20.0f);
            int b3 = BackwardSupportUtil.b.b(bhVar.mContext, 12.0f);
            int b4 = BackwardSupportUtil.b.b(bhVar.mContext, 40.0f);
            View inflate = v.fv(bhVar.mContext).inflate(i.g.qHg, null);
            Rect rect = new Rect();
            int[] iArr = new int[2];
            int ea = com.tencent.mm.pluginsdk.e.ea(bhVar.mContext);
            view.getLocationInWindow(iArr);
            bhVar.qPd = com.tencent.mm.pluginsdk.e.eb(bhVar.mContext);
            x.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + ea + " height_hardcode:" + b2 + " statusBarHeight: " + bhVar.qPd);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2, (iArr[0] - b) + b3, ((iArr[1] - bhVar.qPd) - ea) - ((b4 / 2) - (view.getMeasuredHeight() / 2)));
            bhVar.rMK.setTag(new bh$a(bhVar, str, inflate));
            bhVar.rMK.addView(inflate, layoutParams2);
            if (cVar.kTK == 11) {
                inflate.findViewById(f.qAz).setBackgroundResource(i.e.qzc);
            }
            inflate.setVisibility(8);
            new af().post(new 1(bhVar, view, inflate));
            return true;
        }
        x.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
        return false;
    }

    public final boolean bzr() {
        if (this.rHR == null || this.rHR.rrD == null) {
            return false;
        }
        if (!(this.rHR == null || this.rHR.rrE == null)) {
            this.rHR.rrE.bwm();
        }
        com.tencent.mm.plugin.sns.abtest.a.btP();
        return this.rHR.rrD.bzr();
    }

    public final void GT() {
        DW().K(com.tencent.mm.plugin.sns.j.c.b.class);
    }

    public final void GU() {
    }

    public final void GV() {
        if (!this.rIM) {
            x.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
            this.rIM = true;
            ae.aNT().postDelayed(new 44(this), 1000);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (kVar.getType() == 218) {
            q qVar = (q) kVar;
            if ((qVar.type == 1 || qVar.type == 6 || qVar.type == 4) && this.rHR.rrH != null) {
                this.rHR.rrH.dismiss();
            }
            if (qVar.type == 11) {
                if (this.rId.tipDialog != null) {
                    this.rId.tipDialog.dismiss();
                }
                if (this.rIH != null) {
                    this.rIH.setImageResource(i.i.dxi);
                }
            }
        }
        if (this.rHM != null) {
            this.rHM.rJv.notifyVendingDataChange();
        }
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX) {
            com.tencent.mm.plugin.sns.model.x xVar = (com.tencent.mm.plugin.sns.model.x) kVar;
            com.tencent.mm.modelsns.b iu;
            if (xVar.qTK) {
                iu = com.tencent.mm.modelsns.b.iu(727);
                iu.ix(this.rHM.getCount()).ix(xVar.Pb);
                iu.Sx();
            } else {
                iu = com.tencent.mm.modelsns.b.iu(728);
                iu.ix(this.rHM.getCount()).ix(xVar.Pb).ix(0);
                iu.Sx();
            }
            if (this.rHS != null) {
                this.rHQ = false;
                Animation animation = this.rHS;
                x.i("MicroMsg.SnsTimeLineUI", "play end vis: %d, sumY %f MAX_Y %f", Integer.valueOf(animation.rIN.rHO.getVisibility()), Float.valueOf(animation.rJc), Float.valueOf(animation.rJa));
                if (animation.rIN.rHO.getVisibility() == 0) {
                    animation.init();
                    if (animation.rJc >= animation.rJa) {
                        animation.rIN.rHO.clearAnimation();
                        animation.rIN.rHO.startAnimation(animation);
                        animation.setDuration(1200);
                        animation.rJe = false;
                    }
                }
            }
        }
    }

    protected void finalize() {
        x.d("MicroMsg.SnsTimeLineUI", "finalize");
        super.finalize();
    }

    public final void GW() {
        DW().K(com.tencent.mm.plugin.sns.j.c.b.class);
    }

    public void onBackPressed() {
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 15) {
            if (this.rHR != null && this.rHR.rrG != null && this.rHR.rrG.rPp != null) {
                this.rHR.rrG.rPp.onActivityResult(i, i2, intent);
                ag.h(new 46(this), 300);
            }
        } else if (i == 16) {
            x.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
        } else {
            super.onActivityResult(i, i2, intent);
            this.rId.onActivityResult(i, i2, intent);
            if (i == 11) {
                this.rHK.rRU.b(this.jKk, this.rIb, this.rtl, this.rIc);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsTimeLineUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    bBI();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? j.ezM : j.ezQ;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(i2), getString(j.ezT), getString(j.est), getString(j.dEn), false, new 47(this), new 48(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
