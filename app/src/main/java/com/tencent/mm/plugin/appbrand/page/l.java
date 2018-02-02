package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.page.n.18;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class l extends SwipeBackLayout implements a, com.tencent.mm.ui.widget.l.a {
    private View Iv;
    public n iqC;
    private boolean jDf;
    public boolean mSwiping = false;

    public abstract View aep();

    public abstract String aeq();

    public abstract p aex();

    public abstract void b(String str, String str2, int[] iArr);

    public abstract void loadUrl(String str);

    public abstract boolean rO(String str);

    public abstract boolean rP(String str);

    public l(Context context, n nVar) {
        super(context);
        this.iqC = nVar;
        setLayoutParams(new LayoutParams(-1, -1));
        init();
        nE(false);
        nD(true);
        this.Iv = aeo();
        ((ViewGroup) this.Iv).addView(aep(), new LayoutParams(-1, -1));
        addView(this.Iv);
        this.Iv = this.Iv;
        View view = this.Iv;
        boolean abN = this.iqC.irP.iqy.iMy.abN();
        b dL = com.tencent.mm.ui.statusbar.a.dL(view);
        if (dL != null) {
            dL.nn(abN);
        }
        this.zwz = this;
    }

    public void cleanup() {
        com.tencent.mm.ui.widget.l.b(this);
    }

    public void aes() {
        boolean z = true;
        x.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[]{aeq()});
        com.tencent.mm.ui.widget.l.b(this);
        this.zsB = false;
        n nVar = this.iqC;
        if (nVar.irP.Yu() == null && nVar.jDj.size() <= 1) {
            if (nVar.irP.Yy()) {
                nVar.aiT().nE(true);
                nVar.aiT().nD(false);
            } else {
                z = false;
            }
        }
        this.mEnable = z;
        onSwipe(1.0f);
        this.jDf = false;
        setVisibility(0);
        aeu();
    }

    public void aet() {
        x.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[]{aeq()});
        com.tencent.mm.ui.widget.l.a(this);
        this.jDf = true;
    }

    public void aer() {
        x.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[]{aeq()});
    }

    public final void hide() {
        if (this.jDf) {
            setVisibility(4);
        }
    }

    public View aeo() {
        return new b(getContext());
    }

    public final d aiP() {
        return this.iqC.irP.iqy.qz(com.tencent.mm.plugin.appbrand.p.l.uB(aeq()));
    }

    public void aeu() {
        d aiP = aiP();
        p aex = aex();
        String str = aiP.iMU;
        String str2 = aiP.iMR;
        if (!aex.jDV) {
            aex.jDW = j.aK(str, aex.jDW);
        }
        if (!aex.jDX) {
            aex.jDY = str2;
        }
        aex.M(aex.jDW, aex.jDY);
    }

    public void aev() {
        d aiP = aiP();
        aex().rS(aiP.iMQ);
        aex().i(aiP.iMS);
        aex().rR(aiP.iMU);
        aex().i(aiP.iMS);
        aex().rT(aiP.iMR);
        aex().jDN.do(true);
        aex().cC(aiP.iMZ);
        aex().be(aiP.iNa, aiP.iMN);
        if (c.b(aex(), b.b.jCK)) {
            p aex = aex();
            String str = aiP.iMV;
            String str2 = aiP.iMW;
            boolean z = aiP.iMX;
            if (aex != null) {
                if (bh.ov(str) && bh.ov(str2) && !z) {
                    aex.jDN.amm();
                } else {
                    b.a(aex, z);
                }
            }
        }
    }

    private void a(String str, aa aaVar) {
        Map hashMap = new HashMap();
        hashMap.put("path", com.tencent.mm.plugin.appbrand.p.l.uB(aeq()));
        hashMap.put("query", com.tencent.mm.plugin.appbrand.p.l.uC(aeq()));
        if (aaVar != null) {
            hashMap.put("openType", aaVar.toString());
        }
        com.tencent.mm.plugin.appbrand.q.c.m(hashMap);
        aex().a(str, new JSONObject(hashMap).toString(), null);
    }

    public final void a(aa aaVar) {
        a("onAppRoute", aaVar);
        x.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[]{aaVar.toString(), aeq()});
    }

    public final void aiQ() {
        a("onAppRouteDone", null);
        x.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[]{aeq()});
    }

    protected static boolean c(int[] iArr, int i) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public void onSwipe(float f) {
        if (this.jDf) {
            if (f != 1.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.j.n(this.Iv, 0.0f);
            return;
        }
        com.tencent.mm.ui.tools.j.n(this.Iv, (((float) (this.Iv.getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }

    public void onSettle(boolean z, int i) {
        long j = 120;
        if (z) {
            View view = this.Iv;
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(view, j, 0.0f, null);
            return;
        }
        view = this.Iv;
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(view, j, (float) ((this.Iv.getWidth() * -1) / 4), null);
    }

    public boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public void onSwipeBack() {
        if (getContext() instanceof MMActivity) {
            ((MMActivity) getContext()).aWs();
        }
        n nVar = this.iqC;
        nVar.runOnUiThread(new 18(nVar, this));
        com.tencent.mm.plugin.appbrand.report.a.a(this.iqC.mAppId, aeq(), 23, null, bh.Wo(), 1, 0);
        MMActivity mMActivity = this.iqC.irP.iqt;
        if (mMActivity != null && mMActivity.isFinishing()) {
            mMActivity.onSwipeBack();
        }
    }

    public void onDrag() {
        this.mSwiping = true;
    }

    public void onCancel() {
        this.mSwiping = false;
    }

    public void aew() {
    }
}
