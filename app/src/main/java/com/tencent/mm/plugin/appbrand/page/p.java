package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q$e;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.report.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.appbrand.widget.input.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.v.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"ViewConstructor"})
public class p extends c {
    private volatile boolean Vx = true;
    public e irP;
    private d irQ;
    public boolean irU = false;
    private FrameLayout jCW;
    Set<g> jDH = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<d> jDI = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<f> jDJ = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<e> jDK = Collections.newSetFromMap(new ConcurrentHashMap());
    public Set<c> jDL = Collections.newSetFromMap(new ConcurrentHashMap());
    RelativeLayout jDM;
    public com.tencent.mm.plugin.appbrand.widget.actionbar.c jDN;
    AppBrandRecentView jDO;
    public com.tencent.mm.plugin.appbrand.widget.actionbar.d jDP;
    u jDQ;
    public f jDR;
    public t jDS;
    public r jDT;
    public boolean jDU = false;
    boolean jDV = false;
    int jDW;
    boolean jDX = false;
    String jDY = null;
    public boolean jDZ = false;
    protected List<l> jDh;
    public int jEa = 0;
    private c jEb;
    public final b jEc = new b(hashCode());
    public final com.tencent.mm.plugin.appbrand.widget.f.b jEd = new com.tencent.mm.plugin.appbrand.widget.f.b(this);
    public Runnable jEe = new 1(this);
    ViewGroup jEf = null;
    public String mAppId;
    public Context mContext;

    class AnonymousClass26 implements Runnable {
        final /* synthetic */ p jEg;
        final /* synthetic */ boolean jEp = false;

        AnonymousClass26(p pVar, boolean z) {
            this.jEg = pVar;
        }

        public final void run() {
            this.jEg.jDT.dd(this.jEp);
        }
    }

    public final void a(Context context, e eVar) {
        boolean z;
        boolean z2 = true;
        this.mContext = context;
        this.irP = eVar;
        this.mAppId = eVar.mAppId;
        String str = this.mAppId;
        List linkedList = new LinkedList();
        n.a(linkedList, m.jAG - 1, false);
        n.a(linkedList, m.jAH - 1, true);
        n.a(linkedList, m.jAO - 1, false);
        AppBrandSysConfig oS = a.oS(str);
        if (com.tencent.mm.sdk.a.b.ceK() || !(oS == null || oS.iOI.iGK == 1)) {
            z = false;
        } else {
            z = true;
        }
        n.a(linkedList, m.jAP - 1, z);
        n.a(linkedList, m.jAQ - 1, false);
        n.a(linkedList, m.jAJ - 1, false);
        n.a(linkedList, m.jAL - 1, false);
        n.a(linkedList, m.jAT - 1, false);
        n.a(linkedList, m.jAK - 1, false);
        int i = m.jAR - 1;
        if (com.tencent.mm.sdk.a.b.ceK()) {
            z2 = false;
        }
        n.a(linkedList, i, z2);
        n.a(linkedList, m.jAS - 1, false);
        n.a(linkedList, m.jAN - 1, false);
        this.jDh = linkedList;
        this.jEc.f(eVar);
        this.jDW = this.mContext.getResources().getColor(q.d.btS);
        initView();
    }

    public void initView() {
        int i = 2;
        initActionBar();
        if (this.jDS == null) {
            this.jDS = new t(this.mContext);
            aiW();
        } else if (this.jDS.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.jDS.getContext()).setBaseContext(this.mContext);
        }
        this.jDS.jEb = aiX();
        MMWebView mMWebView = this.jDS;
        e eVar = this.irP;
        x.i("MicroMsg.AppBrandWebView", "onRuntimeReady, preLoadWebView %b", new Object[]{Boolean.valueOf(mMWebView.jFb)});
        mMWebView.irP = eVar;
        mMWebView.mAppId = eVar.mAppId;
        if (bh.ov(mMWebView.mAppId)) {
            x.d("MicroMsg.AppBrandWebView", "doInitWebView mAppId is null");
        } else {
            if (!(!mMWebView.jFb || mMWebView.irP == null || mMWebView.getX5WebViewExtension() == null)) {
                x.i("MicroMsg.AppBrandWebView", "setReferer %s", new Object[]{"https://servicewechat.com/" + mMWebView.mAppId + "/" + mMWebView.irP.iqx.iOI.iGL + "/page-frame.html"});
                new Bundle().putString(SlookSmartClipMetaTag.TAG_TYPE_URL, r0);
                try {
                    a.a.cB(mMWebView.getX5WebViewExtension()).n("invokeMiscMethod", new Object[]{"setReferer", new Bundle()});
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandWebView", "setReferer error " + e);
                }
            }
            i pm = i.pm(mMWebView.mAppId);
            if (pm != null) {
                pm.irK.set(true);
            }
            boolean z = mMWebView.isX5Kernel;
            g gVar = g.pQN;
            if (!z) {
                i = 3;
            }
            gVar.a(482, 482, 1, i, 1, 1, false);
            mMWebView.jEW = com.tencent.mm.plugin.appbrand.j.i.ty(mMWebView.mAppId);
        }
        if (mMWebView.iTU) {
            mMWebView.ajo();
        }
        this.jDS.jEV = new 4(this);
        if (this.irU) {
            h("onWxConfigReady", "", 0);
        } else {
            this.jDS.init();
        }
        this.jDT = new r(this.mContext, this.jDS);
        this.jDT.jEI = new r.a(this) {
            final /* synthetic */ p jEg;

            {
                this.jEg = r1;
            }

            public final void ajd() {
                this.jEg.a("onPullDownRefresh", null, null);
            }
        };
        this.jDT.jEJ = new 6(this);
        this.jCW = new FrameLayout(this.mContext);
        this.jCW.addView(this.jDT);
        FrameLayout frameLayout = this.jCW;
        View fVar = new f(this.mContext, this);
        this.jDR = fVar;
        frameLayout.addView(fVar);
        this.jDT.jEJ = this.jDR;
        this.jDS.jEU = this.jDR;
        this.jDM = new 12(this, this.mContext);
        this.jDM.setLayoutParams(new LayoutParams(-1, -1));
        if (this.irP.iqy.iMy.abN()) {
            this.jDM.addView(this.jCW, new LayoutParams(-1, -1));
            cD(true);
        } else {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10, -1);
            this.jDN.getActionView().setId(q$g.action_bar_root);
            this.jDM.addView(this.jDN.getActionView(), layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, q$g.action_bar_root);
            this.jDM.addView(this.jCW, layoutParams);
        }
        this.jDQ = new u(this.jDR);
        ViewGroup viewGroup = (ViewGroup) this.jDS.getView();
        f fVar2 = this.jDR;
        viewGroup.setOnTouchListener(new 22(this, fVar2, new ad(fVar2)));
        this.jDQ.a(aiX());
        com.tencent.mm.plugin.appbrand.widget.input.m.m(this);
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final e YQ() {
        return this.irP;
    }

    public com.tencent.mm.plugin.appbrand.g.b YR() {
        return this.jDS;
    }

    public View getContentView() {
        return this.jDM;
    }

    public final void initActionBar() {
        com.tencent.mm.plugin.appbrand.widget.actionbar.c bVar;
        Context context = this.mContext;
        e eVar = this.irP;
        int i = (eVar.iqy == null || eVar.iqy.iMy == null || !eVar.iqy.iMy.abN()) ? 0 : 1;
        if (i != 0 || eVar.Yz()) {
            boolean z;
            if (!eVar.Yz() || eVar.iqy.iMC.iMH) {
                z = true;
            } else {
                z = false;
            }
            bVar = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(context, z);
        } else {
            bVar = new com.tencent.mm.plugin.appbrand.widget.actionbar.a(context);
        }
        this.jDN = bVar;
        LayoutParams layoutParams = this.jDN.getLayoutParams();
        layoutParams.height = com.tencent.mm.plugin.appbrand.widget.a.ci(this.mContext);
        this.jDN.setLayoutParams(layoutParams);
        this.jDN.a(new 31(this));
        this.jDN.b(new 33(this));
        this.jDN.c(new 34(this));
        this.jDN.d(new 35(this));
        this.jDN.e(new 36(this));
        this.jDN.amm();
        com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
        this.jDO = ((com.tencent.mm.plugin.appbrand.widget.recentview.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).a(this.mContext, com.tencent.mm.plugin.appbrand.widget.recentview.d.b.kfH, new 37(this));
        this.jDP = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(this.mContext);
        this.jDP.setWidth(-1);
        this.jDP.setBackgroundDrawable(new ColorDrawable());
        if (this.jDO != null) {
            this.jDO.refresh();
            this.jDP.setHeight(this.jDO.getLayoutParams().height);
            this.jDO.setBackground(com.tencent.mm.bv.a.b(this.mContext, q.f.itc));
            this.jDP.setContentView(this.jDO);
            this.jDO.a(new 2(this));
        } else {
            x.w("MicroMsg.AppBrandPageView", "AppBrandRecentView is null, appId: %s", new Object[]{this.mAppId});
        }
        this.jDN.a(new 3(this));
    }

    public final void aiW() {
        t tVar = this.jDS;
        d dVar = new d(this, this.jDS);
        this.irQ = dVar;
        tVar.addJavascriptInterface(dVar, "WeixinJSCore");
        this.jDS.addJavascriptInterface(new a(this, (byte) 0), "__deviceInfo");
    }

    public final c aiX() {
        if (this.jEb != null) {
            return this.jEb;
        }
        this.jEb = new c(this.mContext);
        this.jEb.a(new x(this) {
            final /* synthetic */ p jEg;

            {
                this.jEg = r1;
            }

            final void agt() {
                this.jEg.aiY();
            }
        });
        return this.jEb;
    }

    public FrameLayout aeM() {
        return this.jCW;
    }

    public void aeI() {
        ViewGroup viewGroup = (ViewGroup) this.jDN.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.jDN.getActionView());
        }
    }

    public u aeF() {
        return this.jDQ;
    }

    public String getURL() {
        return this.jDS.iZW;
    }

    public String aeO() {
        return this.jDS.jET;
    }

    public void rQ(String str) {
        boolean z;
        boolean z2 = false;
        t tVar = this.jDS;
        tVar.iZW = com.tencent.mm.plugin.appbrand.p.l.uB(str);
        tVar.jET = str;
        tVar.jFd = false;
        if (ah.b(tVar.irP, tVar.iZW)) {
            tVar.jFf = System.currentTimeMillis();
            if (tVar.iTU) {
                tVar.tN(tVar.iZW);
                x.i("MicroMsg.AppBrandWebView", "Frame ready, inject page");
            } else {
                x.i("MicroMsg.AppBrandWebView", "Frame not ready, wait for it");
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (com.tencent.mm.plugin.appbrand.permission.c.b(this, b.jEu)) {
                x.i("MicroMsg.AppBrandPageView", "publishPageNotFound url:%s", new Object[]{str});
                Map hashMap = new HashMap();
                hashMap.put("path", com.tencent.mm.plugin.appbrand.p.l.uB(str));
                hashMap.put("query", com.tencent.mm.plugin.appbrand.p.l.uC(str));
                if (!(this.irP == null || this.irP.iqw == null || !str.equals(bh.az(this.irP.iqw.iNW, "")))) {
                    z2 = true;
                }
                hashMap.put("isEntryPage", Boolean.valueOf(z2));
                com.tencent.mm.plugin.appbrand.q.c.m(hashMap);
                a("onPageNotFound", new h(hashMap).toString(), null);
                ag.h(this.jEe, 2000);
                z2 = true;
            }
            if (!z2) {
                aiZ();
            }
            onReady();
        }
        this.jEc.ua(str);
    }

    public void a(String str, String str2, int[] iArr) {
        if (this.irP == null) {
            if (this.irU) {
                j akk = com.tencent.mm.plugin.appbrand.task.c.akk();
                if (akk != null) {
                    akk.h(str, str2, hashCode());
                    return;
                }
            }
            x.i("MicroMsg.AppBrandPageView", "publish runtime is null, event %s", new Object[]{str});
            return;
        }
        this.irP.iqB.h(str, str2, hashCode());
    }

    public boolean isRunning() {
        return this.Vx;
    }

    public final void cleanup() {
        super.cleanup();
        aeE();
        this.jDH.clear();
        this.jDK.clear();
        this.jDI.clear();
        this.jDJ.clear();
        this.jDL.clear();
        if (this.jDO != null) {
            this.jDO.release();
        }
        if (this.jDP != null) {
            com.tencent.mm.plugin.appbrand.widget.actionbar.d dVar = this.jDP;
            dVar.dismiss();
            if (dVar.jWd != null) {
                dVar.jWd.removeAllViews();
                dVar.jWd = null;
            }
        }
    }

    public void aeE() {
        this.jDS.destroy();
        this.irQ.cleanup();
    }

    static void runOnUiThread(Runnable runnable) {
        if (ag.isMainThread()) {
            runnable.run();
        } else {
            ag.y(runnable);
        }
    }

    public void show() {
        this.jDM.setVisibility(0);
    }

    public void hide() {
        this.jDM.setVisibility(4);
    }

    public final void a(g gVar) {
        this.jDH.add(gVar);
    }

    public final void b(g gVar) {
        this.jDH.remove(gVar);
    }

    public final void onReady() {
        aez();
        runOnUiThread(new 9(this));
    }

    public void aez() {
        runOnUiThread(new 8(this));
    }

    public final void aga() {
        aeA();
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ p jEg;

            {
                this.jEg = r1;
            }

            public final void run() {
                for (f aga : this.jEg.jDJ) {
                    aga.aga();
                }
            }
        });
    }

    public void aeA() {
        this.jDS.onResume();
        if (!this.jDU) {
            if (this.irP.iqH.scene == 1023) {
                aja();
            } else if (this.irP.Yy() || this.irP.iqC.getPageCount() != 1) {
                this.jDN.dp(false);
                this.jDN.amp();
            } else {
                aja();
            }
        }
        if (!this.jDU) {
            String str = this.irP.iqw.iNW;
            String abM = this.irP.iqy.abM();
            l aiT = this.irP.iqC.aiT();
            if (!(this.irP.Yy() || this.irP.iqC.getPageCount() != 1 || aiT.rO(abM))) {
                aiT.rP(str);
            }
        }
        a.c(this);
        cB(this.jDU);
        if (this.jDS.jFd) {
            x.i("MicroMsg.AppBrandPageView", "reload page %s", new Object[]{this.jDS.jET});
            this.jDS.init();
            rQ(this.jDS.jET);
            i iVar = new i();
            Map hashMap = new HashMap();
            hashMap.put("path", getURL());
            iVar.v(hashMap).az(this.mAppId, hashCode()).afs();
        }
        this.jEc.aga();
        this.jDS.tM(tK("VISIBLE"));
    }

    public final void a(f fVar) {
        this.jDJ.add(fVar);
    }

    public final void b(f fVar) {
        this.jDJ.remove(fVar);
    }

    public final void afA() {
        aeB();
        runOnUiThread(new 11(this));
    }

    public void aeB() {
        this.jDS.onPause();
        this.jEc.afA();
        this.jDS.tM(tK("INVISIBLE"));
        this.jEb.aiK();
        if (this.jDP != null) {
            this.jDP.dismiss();
        }
    }

    public final void a(d dVar) {
        this.jDI.add(dVar);
    }

    public final void b(d dVar) {
        this.jDI.remove(dVar);
    }

    public boolean aeG() {
        if (this.jEb.aiK()) {
            return true;
        }
        if (this.jDL.size() == 0) {
            return false;
        }
        boolean z = false;
        for (c aeG : this.jDL) {
            boolean z2;
            if (aeG.aeG()) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    public final void onDestroy() {
        aeC();
        runOnUiThread(new 13(this));
    }

    public void aeC() {
        this.Vx = false;
        this.jEc.onDestroy();
    }

    public final void a(e eVar) {
        this.jDK.add(eVar);
    }

    public final void b(e eVar) {
        this.jDK.remove(eVar);
    }

    public final void i(double d) {
        runOnUiThread(new 14(this, d));
    }

    public void rR(String str) {
        runOnUiThread(new 15(this, str));
    }

    public void kg(int i) {
        runOnUiThread(new 16(this, i));
    }

    public void rS(String str) {
        runOnUiThread(new 17(this, str));
    }

    public String aeH() {
        CharSequence amk = this.jDN.amk();
        return amk != null ? amk.toString() : "";
    }

    public void rT(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ p jEg;

            public final void run() {
                this.jEg.jDN.uV(str);
            }
        });
    }

    public void kh(int i) {
        runOnUiThread(new 20(this, i));
    }

    public void cA(final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ p jEg;

            public final void run() {
                this.jEg.jDN.dq(z);
            }
        });
    }

    public void cD(boolean z) {
        if (z) {
            aeI();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.rightMargin = com.tencent.mm.bv.a.ab(this.mContext, q$e.isJ);
            this.jDM.addView(this.jDN.getActionView(), layoutParams);
        }
    }

    public void cB(boolean z) {
        if (this.mContext instanceof Activity) {
            this.jDU = z;
            Window window = ((Activity) this.mContext).getWindow();
            if (z) {
                com.tencent.mm.plugin.appbrand.ui.j.c(window, true);
            } else {
                com.tencent.mm.plugin.appbrand.ui.j.c(window, false);
            }
        }
    }

    public void aeJ() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ p jEg;

            {
                this.jEg = r1;
            }

            public final void run() {
                this.jEg.jDT.cC(true);
                this.jEg.jDT.ajf();
            }
        });
    }

    public void aeK() {
        runOnUiThread(new 24(this));
    }

    public void cC(boolean z) {
        runOnUiThread(new 25(this, z));
    }

    public void be(String str, String str2) {
        runOnUiThread(new 27(this, str2, str));
    }

    public final void tJ(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ p jEg;

            public final void run() {
                this.jEg.jDT.dd(true);
                this.jEg.jDT.cC(false);
                r rVar = this.jEg.jDT;
                CharSequence charSequence = str;
                if (bh.ov(charSequence)) {
                    rVar.jEM.setVisibility(8);
                    return;
                }
                rVar.lh(com.tencent.mm.bv.a.c(rVar.getContext(), q.d.buh));
                rVar.jEM.setTextColor(com.tencent.mm.bv.a.c(rVar.getContext(), q.d.isD));
                rVar.jEM.setVisibility(0);
                rVar.jEM.setText(charSequence);
            }
        });
    }

    public final void x(int i, boolean z) {
        if (i != 0) {
            List<l> list = this.jDh;
            int i2 = i - 1;
            if (list != null && !list.isEmpty()) {
                for (l lVar : list) {
                    if (lVar != null && lVar.id == i2) {
                        lVar.jAF = z;
                        return;
                    }
                }
            }
        }
    }

    public final l le(int i) {
        return n.d(this.jDh, i - 1);
    }

    public final void aiY() {
        M(this.jDW, this.jDY);
    }

    public void rU(String str) {
        this.jDX = true;
        this.jDY = str;
        runOnUiThread(new 29(this));
    }

    public void ki(int i) {
        this.jDV = true;
        this.jDW = i;
        runOnUiThread(new 30(this));
    }

    final void M(int i, String str) {
        com.tencent.mm.ui.statusbar.a.d(getContentView(), i, "black".equals(str));
    }

    public final void aiZ() {
        boolean z = true;
        runOnUiThread(new AnonymousClass26(this, false));
        if (this.irP.iqC.getPageCount() < 2) {
            this.irP.iqU = true;
        }
        View dVar = new d(this.mContext);
        e eVar = this.irP;
        d.inflate(dVar.getContext(), q.h.iwP, dVar);
        dVar.jCP = (ImageView) dVar.findViewById(q$g.itE);
        dVar.jCQ = (TextView) dVar.findViewById(q$g.itG);
        dVar.jCR = (Button) dVar.findViewById(q$g.itD);
        dVar.jCQ.setText(dVar.getResources().getString(q.j.iyW, new Object[]{eVar.iqx.frn}));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.jCP.getLayoutParams();
        if (eVar.iqy == null || eVar.iqy.iMy == null || !eVar.iqy.iMy.abN()) {
            z = false;
        }
        if (z || eVar.Yz()) {
            layoutParams.topMargin = com.tencent.mm.bv.a.ab(dVar.getContext(), q$e.isI);
            dVar.jCP.setLayoutParams(layoutParams);
            dVar.requestLayout();
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        dVar.jCP.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        com.tencent.mm.modelappbrand.a.b.Jj().a(dVar.jCP, eVar.iqx.iOg, com.tencent.mm.modelappbrand.a.a.Ji(), com.tencent.mm.modelappbrand.a.f.hkr);
        dVar.jCR.setVisibility(8);
        dVar.setBackgroundColor(-1);
        com.tencent.mm.plugin.appbrand.report.a.z(eVar.iqx.appId, 27, 0);
        this.jCW.addView(dVar);
    }

    private String tK(String str) {
        return this.mAppId + ":" + this.jDS.iZW + ":" + str;
    }

    private void aja() {
        if (this.irP.iqC.getPageCount() == 1) {
            this.jDN.dp(true);
            return;
        }
        this.jDN.dp(false);
        this.jDN.amp();
    }

    public boolean aeL() {
        if (this.jDU) {
            return false;
        }
        String str = this.irP.iqw.iNW;
        String abM = this.irP.iqy.abM();
        l aiT = this.irP.iqC.aiT();
        if (this.irP.Yy() || this.irP.iqC.getPageCount() != 1 || aiT.rO(abM) || !aiT.rP(str)) {
            return false;
        }
        return true;
    }

    public final void tL(String str) {
        if (str.equalsIgnoreCase("dark")) {
            this.jDZ = true;
        } else {
            this.jDZ = false;
        }
    }

    public View aeN() {
        if (this.jEa <= 0) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(q.h.ixz, null);
        ((TextView) inflate.findViewById(q$g.iuY)).setText(this.mContext.getResources().getString(this.jEa));
        return inflate;
    }

    public void kj(int i) {
        this.jEa = i;
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.n.a ajb() {
        View findViewById = getContentView().findViewById(q$g.iuz);
        if (findViewById instanceof com.tencent.mm.plugin.appbrand.jsapi.n.a) {
            return (com.tencent.mm.plugin.appbrand.jsapi.n.a) findViewById;
        }
        return null;
    }

    public <T> T a(int i, Bundle bundle, Object... objArr) {
        return null;
    }

    public Bitmap aeP() {
        Bitmap bitmap = null;
        final View view = this.jDS.getView();
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        final int scrollX = view.getScrollX();
        final int scrollY = view.getScrollY();
        if (width == 0 || height == 0) {
            return null;
        }
        view.scrollTo(0, 0);
        if (this.jDS.isXWalkKernel()) {
            Bitmap bitmap2 = this.jDS.getBitmap();
            bitmap = Bitmap.createBitmap(bitmap2, 0, 0, width, height);
            bitmap2.recycle();
            view.postDelayed(new Runnable(this) {
                final /* synthetic */ p jEg;

                public final void run() {
                    view.scrollTo(scrollX, scrollY);
                }
            }, 500);
            return bitmap;
        }
        View view2 = this.jDR;
        if (view != null) {
            bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Drawable background = view.getBackground();
            if (background != null) {
                background.draw(canvas);
            }
            view.draw(canvas);
            if (!(view instanceof com.tencent.mm.plugin.appbrand.jsapi.coverview.m)) {
                com.tencent.mm.sdk.platformtools.d.a(canvas, view2);
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        bitmap.recycle();
        view.scrollTo(scrollX, scrollY);
        return createBitmap;
    }
}
