package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.g;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.protocal.c.bmb;
import com.tencent.mm.protocal.c.ccb;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.wcdb.FileUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class ExdeviceProfileUI extends MMActivity implements e, c {
    private static int lVR = 0;
    private boolean GO = false;
    private int gUf = 0;
    private TextPaint gu = new TextPaint(1);
    private String jKk;
    private String jsF;
    private String lOU;
    private boolean lPh;
    private List<String> lPx;
    private List<String> lPy;
    private r lTm = null;
    private boolean lUY;
    private boolean lUZ;
    private ListView lVA;
    private ExdeviceProfileListHeader lVB;
    private MMSwitchBtn lVC;
    private SportChartView lVD;
    private a lVE;
    private View lVF;
    private volatile boolean lVG;
    private String lVH;
    private String lVI;
    private List<com.tencent.mm.plugin.sport.b.e> lVJ;
    private ArrayList<c> lVK;
    private List<wb> lVL;
    private int lVM;
    private b<i> lVN = new 1(this);
    private d lVO = new 29(this);
    private b<h> lVP = new 31(this);
    private b<g> lVQ = new b<g>(this) {
        final /* synthetic */ ExdeviceProfileUI lVZ;

        {
            this.lVZ = r1;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneAddFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                this.lVZ.finish();
            }
        }
    };
    private Runnable lVS = new Runnable(this) {
        final /* synthetic */ ExdeviceProfileUI lVZ;

        {
            this.lVZ = r1;
        }

        public final void run() {
            BackwardSupportUtil.c.a(this.lVZ.lVA);
            if (this.lVZ.lVA.getCount() > 0) {
                BackwardSupportUtil.c.b(this.lVZ.lVA, this.lVZ.lVA.getCount() - 1);
            }
        }
    };
    private b<g> lVT = new 15(this);
    private List<String> lVU;
    private b<com.tencent.mm.plugin.exdevice.f.a.k> lVV = new 17(this);
    private com.tencent.mm.sdk.b.c<lj> lVW = new com.tencent.mm.sdk.b.c<lj>(this) {
        final /* synthetic */ ExdeviceProfileUI lVZ;

        {
            this.lVZ = r2;
            this.xen = lj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lj ljVar = (lj) bVar;
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "count: %d ret: %s title: %s content: %s", new Object[]{Integer.valueOf(ljVar.fCK.count), Integer.valueOf(ljVar.fCK.ret), ljVar.fCK.fCL, ljVar.fCK.fCM});
            if (this.lVZ.lTm != null && this.lVZ.lTm.isShowing()) {
                this.lVZ.lTm.dismiss();
            }
            this.lVZ.lVW.dead();
            Intent intent = new Intent();
            intent.putExtra("KeyNeedUpdateRank", true);
            this.lVZ.setResult(-1, intent);
            this.lVZ.finish();
            return false;
        }
    };
    private GestureDetector lVX;
    private a lVY = new a(this) {
        final /* synthetic */ ExdeviceProfileUI lVZ;

        {
            this.lVZ = r1;
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return this.lVZ.lVX.onTouchEvent(motionEvent);
        }
    };
    private int lVa;
    private List<jm> lVd;
    private String lVu;
    private com.tencent.mm.plugin.exdevice.f.b.a.a lVv;
    private ArrayList<String> lVw;
    private ccb lVx;
    private ExdeviceProfileAffectedUserView lVy;
    private ImageView lVz;
    private String mAppName;
    private Context mContext;

    static /* synthetic */ void A(ExdeviceProfileUI exdeviceProfileUI) {
        if (VERSION.SDK_INT >= 11) {
            View childAt = exdeviceProfileUI.lVA.getChildAt(0);
            int[] iArr = new int[2];
            if (childAt != null && exdeviceProfileUI.lVA.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (lVR == 0) {
                    lVR = iArr[1];
                }
                int i = iArr[1];
                if (i > (-lVR) / 2) {
                    exdeviceProfileUI.lVy.setAlpha(i > 0 ? ((float) (i * 2)) / (((float) lVR) * 2.0f) : ((float) i) / ((float) lVR));
                    exdeviceProfileUI.lVy.setVisibility(0);
                    return;
                }
                exdeviceProfileUI.lVy.setAlpha(0.0f);
                exdeviceProfileUI.lVy.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void B(ExdeviceProfileUI exdeviceProfileUI) {
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(exdeviceProfileUI.mController.xIM, com.tencent.mm.ui.widget.g.ztp, false);
        gVar.rKC = new 30(exdeviceProfileUI);
        gVar.rKD = exdeviceProfileUI.lVO;
        gVar.bUk();
    }

    static /* synthetic */ void E(ExdeviceProfileUI exdeviceProfileUI) {
        Intent intent = new Intent();
        String d = bh.d(exdeviceProfileUI.lVU, ",");
        intent.putExtra("wechat_sport_contact", bh.d(exdeviceProfileUI.lPx, ","));
        intent.putExtra("wechat_sport_recent_like", d);
        d = bh.d(exdeviceProfileUI.lPy, ",");
        intent.putExtra("titile", exdeviceProfileUI.getString(R.l.ecr));
        intent.putExtra("list_type", 12);
        intent.putExtra("max_limit_num", 10);
        intent.putExtra("too_many_member_tip_string", exdeviceProfileUI.getString(R.l.ecs, new Object[]{Integer.valueOf(10)}));
        intent.putExtra("list_attr", s.p(new int[]{2, 4, 1, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, FileUtils.S_IWUSR, 64, 16384}));
        intent.putExtra("always_select_contact", d);
        com.tencent.mm.bm.d.a(exdeviceProfileUI, ".ui.contact.SelectContactUI", intent, 3);
    }

    static /* synthetic */ List aF(List list) {
        List arrayList = new ArrayList();
        for (bmb com_tencent_mm_protocal_c_bmb : list) {
            com.tencent.mm.plugin.sport.b.e eVar = new com.tencent.mm.plugin.sport.b.e();
            eVar.field_step = com_tencent_mm_protocal_c_bmb.jer;
            eVar.field_timestamp = ((long) com_tencent_mm_protocal_c_bmb.cRJ) * 1000;
            eVar.field_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(eVar.field_timestamp));
            arrayList.add(eVar);
        }
        return arrayList;
    }

    static /* synthetic */ void d(ExdeviceProfileUI exdeviceProfileUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.bm.d.a(exdeviceProfileUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void g(ExdeviceProfileUI exdeviceProfileUI) {
        exdeviceProfileUI.mController.removeAllOptionMenu();
        if (q.FS().equals(exdeviceProfileUI.jKk)) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.bDI, new 12(exdeviceProfileUI));
            return;
        }
        ar.Hg();
        boolean WK = com.tencent.mm.z.c.EY().WK(exdeviceProfileUI.jKk);
        ar.Hg();
        boolean AG = com.tencent.mm.z.c.EY().WO(exdeviceProfileUI.jKk).AG();
        if (exdeviceProfileUI.lUZ && WK) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.bDI, new OnMenuItemClickListener(exdeviceProfileUI) {
                final /* synthetic */ ExdeviceProfileUI lVZ;

                {
                    this.lVZ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this.lVZ.mController.xIM, com.tencent.mm.ui.widget.g.ztp, false);
                    gVar.rKC = new p.c(this) {
                        final /* synthetic */ AnonymousClass23 lWf;

                        {
                            this.lWf = r1;
                        }

                        public final void a(n nVar) {
                            nVar.f(2, this.lWf.lVZ.getString(R.l.edy));
                        }
                    };
                    gVar.rKD = this.lVZ.lVO;
                    gVar.bUk();
                    return true;
                }
            });
        } else if (!AG) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.bDI, new 26(exdeviceProfileUI));
        }
    }

    static /* synthetic */ void k(ExdeviceProfileUI exdeviceProfileUI) {
        if (exdeviceProfileUI.lVD == null) {
            exdeviceProfileUI.lVD = (SportChartView) exdeviceProfileUI.findViewById(R.h.cfv);
        }
        if (exdeviceProfileUI.lVC == null) {
            exdeviceProfileUI.lVC = (MMSwitchBtn) exdeviceProfileUI.findViewById(R.h.cfx);
        }
        if (exdeviceProfileUI.lVJ == null || exdeviceProfileUI.lVJ.size() <= 0) {
            exdeviceProfileUI.lVD.rUJ = false;
            exdeviceProfileUI.lVC.setVisibility(8);
            exdeviceProfileUI.lVD.cc(null);
            return;
        }
        if (exdeviceProfileUI.lUY) {
            exdeviceProfileUI.lVD.rUJ = true;
            exdeviceProfileUI.lVC.setVisibility(0);
            exdeviceProfileUI.lVC.zvp = new 22(exdeviceProfileUI);
        } else {
            exdeviceProfileUI.lVD.rUJ = false;
            exdeviceProfileUI.lVC.setVisibility(8);
            exdeviceProfileUI.lVD.ye(SportChartView.a.rUN);
            exdeviceProfileUI.lVD.cc(exdeviceProfileUI.lVJ);
        }
        exdeviceProfileUI.lVD.rUI = ((com.tencent.mm.plugin.sport.b.e) exdeviceProfileUI.lVJ.get(exdeviceProfileUI.lVJ.size() - 1)).field_step;
        exdeviceProfileUI.lVD.cc(exdeviceProfileUI.lVJ);
        com.tencent.mm.plugin.sport.b.e bDg = ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).bDg();
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        instance.set(10, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        long timeInMillis = instance.getTimeInMillis();
        instance.add(5, -120);
        instance.set(10, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis2 = instance.getTimeInMillis();
        if (bDg != null) {
            instance.setTimeInMillis(bDg.field_timestamp);
            instance.add(5, 2);
            if (instance.getTimeInMillis() > timeInMillis) {
                exdeviceProfileUI.r(timeInMillis2, timeInMillis);
                return;
            }
        }
        ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).a(timeInMillis2, timeInMillis, new 24(exdeviceProfileUI, timeInMillis2, timeInMillis));
    }

    static /* synthetic */ void r(ExdeviceProfileUI exdeviceProfileUI) {
        ac acVar = new ac();
        String valueOf = String.valueOf(exdeviceProfileUI.lVM);
        String str = "0";
        if (exdeviceProfileUI.lVx != null) {
            str = String.valueOf(exdeviceProfileUI.lVx.score);
        }
        acVar.a(exdeviceProfileUI, valueOf, str, exdeviceProfileUI.jsF, new 19(exdeviceProfileUI));
    }

    static /* synthetic */ void s(ExdeviceProfileUI exdeviceProfileUI) {
        String valueOf = String.valueOf(exdeviceProfileUI.lVM);
        String str = "0";
        if (exdeviceProfileUI.lVx != null) {
            str = String.valueOf(exdeviceProfileUI.lVx.score);
        }
        new ac().a(exdeviceProfileUI, valueOf, str, exdeviceProfileUI.jsF, new ac.a(exdeviceProfileUI) {
            final /* synthetic */ ExdeviceProfileUI lVZ;

            {
                this.lVZ = r1;
            }

            public final void yU(String str) {
                ExdeviceProfileUI.d(this.lVZ, str);
            }
        });
    }

    static /* synthetic */ void t(ExdeviceProfileUI exdeviceProfileUI) {
        x.i("MicroMsg.Sport.ExdeviceProfileUI", "ap: start to del: %s", new Object[]{exdeviceProfileUI.jKk});
        ar.CG().a(new h(exdeviceProfileUI.jKk, exdeviceProfileUI.lVP), 0);
    }

    public void onCreate(Bundle bundle) {
        CharSequence string;
        super.onCreate(bundle);
        this.mContext = this.mController.xIM;
        Intent intent = getIntent();
        aFb();
        this.jKk = intent.getStringExtra("username");
        this.lVu = intent.getStringExtra("usernickname");
        String FS = q.FS();
        if (FS != null) {
            this.lUY = FS.equals(this.jKk);
        }
        this.mAppName = getIntent().getStringExtra("app_username");
        this.lUZ = ad.aEm().za(this.jKk);
        x.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[]{Boolean.valueOf(this.lUZ)});
        Assert.assertTrue(!bh.ov(this.jKk));
        this.lVv = ad.aEo().zc(this.jKk);
        this.lVw = getIntent().getStringArrayListExtra("key_affected_semi");
        getString(R.l.dGO);
        this.lTm = com.tencent.mm.ui.base.h.a(this, getString(R.l.ctB), new OnCancelListener(this) {
            final /* synthetic */ ExdeviceProfileUI lVZ;

            {
                this.lVZ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.lVZ.lTm != null) {
                    this.lVZ.lTm.dismiss();
                    this.lVZ.lTm = null;
                }
                this.lVZ.finish();
            }
        });
        this.lVy = (ExdeviceProfileAffectedUserView) findViewById(R.h.ceT);
        this.lVz = (ImageView) findViewById(R.h.ceW);
        this.lVA = (ListView) findViewById(R.h.cfs);
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.h.cEh);
        this.lVy.v(this.lVw);
        aFf();
        this.lVF = findViewById(R.h.cLE);
        this.lVX = new GestureDetector(this.mController.xIM, new a(this, (byte) 0));
        mMPullDownView.mn(false);
        mMPullDownView.mp(false);
        mMPullDownView.mo(false);
        mMPullDownView.mn(false);
        mMPullDownView.mm(false);
        mMPullDownView.ycJ = true;
        mMPullDownView.ycM = this.lVY;
        mMPullDownView.ycB = new 5(this);
        mMPullDownView.ycC = new 6(this);
        mMPullDownView.ycq = new 7(this);
        mMPullDownView.ycU = new 8(this);
        ExdeviceProfileListHeader exdeviceProfileListHeader = new ExdeviceProfileListHeader(this);
        int A = com.tencent.mm.plugin.exdevice.j.b.A(this, getResources().getDimensionPixelSize(R.f.buO));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(R.f.buF) : getResources().getDimensionPixelSize(R.f.buG);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.buQ);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.f.buP);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        dimensionPixelSize2 = ((((defaultDisplay.getHeight() / 2) - A) - dimensionPixelSize) - (dimensionPixelSize2 / 2)) - dimensionPixelSize3;
        if (defaultDisplay.getHeight() <= 0 || dimensionPixelSize2 <= 0) {
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.buN);
        }
        exdeviceProfileListHeader.setMinimumHeight(dimensionPixelSize2);
        exdeviceProfileListHeader.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceProfileListHeader.setTag(Integer.valueOf(((defaultDisplay.getHeight() / 2) - A) - dimensionPixelSize));
        this.lVB = exdeviceProfileListHeader;
        this.lVA.addHeaderView(this.lVB, null, false);
        this.lVE = new a(this.mController.xIM, this.mAppName, this.lUY, this.jKk);
        this.lVE.lUX = this;
        this.lVA.setAdapter(this.lVE);
        this.lVA.setOnScrollListener(new 9(this));
        this.lVy.jKk = this.jKk;
        this.lVF.setOnClickListener(new 10(this));
        mMPullDownView.ycJ = false;
        this.lVz.setLayoutParams(new LayoutParams(com.tencent.mm.bv.a.eA(this), ((Integer) this.lVB.getTag()).intValue()));
        aFe();
        ad.aEt().a(this);
        ar.CG().a(new i(this.jKk, bh.ou(this.mAppName), this.lVN), 0);
        try {
            this.gUf = getResources().getDimensionPixelSize(R.f.buU);
            if (this.gUf <= 0) {
                this.gUf = 60;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", e, "", new Object[0]);
            if (this.gUf <= 0) {
                this.gUf = 60;
            }
        } catch (Throwable th) {
            if (this.gUf <= 0) {
                this.gUf = 60;
            }
        }
        x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[]{Integer.valueOf(this.gUf)});
        if (this.lUY) {
            string = getString(R.l.edB);
        } else {
            dimensionPixelSize = R.l.edE;
            Object[] objArr = new Object[1];
            FS = this.jKk;
            int i = this.gUf;
            CharSequence gu = com.tencent.mm.z.r.gu(FS);
            string = (!FS.equalsIgnoreCase(gu) || bh.ov(this.lVu)) ? com.tencent.mm.pluginsdk.ui.d.i.a(this.mController.xIM, gu) : com.tencent.mm.pluginsdk.ui.d.i.a(this.mController.xIM, this.lVu);
            x.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[]{Integer.valueOf(i), string, TextUtils.ellipsize(string, this.gu, (float) i, TruncateAt.END)});
            objArr[0] = gu;
            string = com.tencent.mm.pluginsdk.ui.d.i.a(this, getString(dimensionPixelSize, objArr));
        }
        O(string);
        setBackBtn(new 28(this));
        x.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.jKk);
        if (q.FS().equals(this.jKk)) {
            com.tencent.mm.sdk.b.b qoVar = new qo();
            qoVar.fIh.action = 3;
            com.tencent.mm.sdk.b.a.xef.a(qoVar, Looper.getMainLooper());
        }
    }

    private void aFb() {
        this.lVK = ad.aEm().aEy();
        if (this.lVK != null) {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[]{Integer.valueOf(this.lVK.size()), this.lVK.toString()});
        } else {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
        }
        if (bh.cA(this.lVK)) {
            this.lVa = 0;
        } else {
            this.lVa = this.lVK.size();
        }
    }

    private void aFc() {
        runOnUiThread(new 27(this));
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        x.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
        aFb();
        aFc();
        if (!this.lUY) {
            ad.aEm().za(this.jKk);
            aFd();
        }
    }

    private void aFd() {
        runOnUiThread(new 3(this));
    }

    protected void onDestroy() {
        this.lVW.dead();
        this.GO = true;
        super.onDestroy();
        ad.aEt().b(this);
    }

    private void aFe() {
        String FS = q.FS();
        if (this.lVF != null) {
            this.lVF.setVisibility(8);
        }
        if (!bh.ov(FS) && FS.equals(this.jKk)) {
            if (!(this.lVv == null || !bh.ov(this.lVv.field_championUrl) || this.lVF == null)) {
                this.lVF.setVisibility(0);
            }
            if (this.lVB != null) {
                this.lVB.setOnClickListener(new 11(this));
            }
        } else if (this.lVv != null && !bh.ov(this.lVv.field_championUrl) && this.lVB != null) {
            this.lVB.setOnClickListener(new 13(this));
        }
    }

    private void aFf() {
        if (this.lVv == null) {
            this.lVz.setImageResource(R.e.brW);
            this.jsF = null;
        } else if (this.jsF == this.lVv.field_championUrl) {
        } else {
            if (this.jsF == null || !this.jsF.equals(this.lVv.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.lVz, this.lVv.field_championUrl, R.e.brW);
                this.jsF = this.lVv.field_championUrl;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.mAppName)) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        String str;
                        if (intent == null) {
                            str = null;
                        } else {
                            str = intent.getStringExtra("Select_Conv_User");
                        }
                        String cw = ac.cw(this);
                        if (str == null || str.length() == 0) {
                            x.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
                            return;
                        }
                        ac.a(this, str, cw, intent.getStringExtra("custom_send_text"), this.lVI);
                        com.tencent.mm.ui.base.h.bu(this.mController.xIM, getResources().getString(R.l.dGG));
                        return;
                    }
                    return;
                case 2:
                    if (i2 == -1) {
                        Toast.makeText(this, R.l.ePi, 1).show();
                        return;
                    }
                    return;
                case 3:
                    if (i2 == -1) {
                        List F = bh.F(intent.getStringExtra("Select_Contact").split(","));
                        if (F != null) {
                            if (this.lTm != null) {
                                this.lTm.show();
                            }
                            ar.CG().a(new g(F, this.lVT), 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dgW;
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        if ("HardDeviceChampionInfo".equals(str) && this.jKk.equals(dVar.username)) {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
            this.lVv = ad.aEo().zc(this.jKk);
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceProfileUI lVZ;

                {
                    this.lVZ = r1;
                }

                public final void run() {
                    this.lVZ.aFe();
                    this.lVZ.lVE.notifyDataSetChanged();
                    this.lVZ.aFf();
                }
            });
        }
    }

    public final void aFg() {
        runOnUiThread(new 18(this));
        ar.CG().a(new com.tencent.mm.plugin.exdevice.f.a.k(this.lVV), 0);
    }

    public final void aFh() {
        com.tencent.mm.plugin.sport.b.d.pY(17);
        List arrayList = new ArrayList();
        arrayList.add(this.jKk);
        ar.CG().a(new g(arrayList, this.lVQ), 0);
    }

    private void r(long j, long j2) {
        List<com.tencent.mm.plugin.sport.b.e> B = ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).B(j, j2);
        HashSet hashSet = new HashSet();
        List arrayList = new ArrayList();
        if (this.lVJ != null) {
            for (com.tencent.mm.plugin.sport.b.e eVar : this.lVJ) {
                if (hashSet.add(eVar.field_date)) {
                    arrayList.add(eVar);
                }
            }
        }
        for (com.tencent.mm.plugin.sport.b.e eVar2 : B) {
            if (hashSet.add(eVar2.field_date)) {
                arrayList.add(eVar2);
            }
        }
        Collections.sort(arrayList);
        this.lVJ = arrayList;
        this.lVD.cc(this.lVJ);
    }
}
