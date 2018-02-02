package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.2;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e extends l {
    private String jCS;
    private LinearLayout jCT;
    private FrameLayout jCU;
    public c jCV;
    private FrameLayout jCW;
    private p jCX = this.iqC.aiU();
    private Map<String, p> jCY = new HashMap();
    private LinkedList<b> jCZ = new LinkedList();

    public e(Context context, n nVar) {
        super(context, nVar);
    }

    protected final View aep() {
        if (this.jCT == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            this.jCU = new FrameLayout(getContext());
            this.jCU.setLayoutParams(new LayoutParams(-1, -2));
            this.jCW = new FrameLayout(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.jCW.setLayoutParams(layoutParams);
            this.jCV = aiM();
            if ("top".equals(this.iqC.irP.iqy.iMA.iML)) {
                linearLayout.addView(this.jCU);
                linearLayout.addView(this.jCV);
                linearLayout.addView(this.jCW);
            } else {
                linearLayout.addView(this.jCU);
                linearLayout.addView(this.jCW);
                linearLayout.addView(this.jCV);
            }
            this.jCT = linearLayout;
        }
        return this.jCT;
    }

    private c aiM() {
        c cVar = new c(getContext());
        com.tencent.mm.plugin.appbrand.config.a.e eVar = this.iqC.irP.iqy.iMA;
        cVar.jUw = eVar.iML;
        cVar.g(eVar.hbM, eVar.iMM, eVar.iMN, eVar.iMO);
        Iterator it = eVar.fBU.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            String str = fVar.url;
            String str2 = fVar.text;
            String str3 = fVar.fDI;
            String str4 = fVar.iMP;
            c$a com_tencent_mm_plugin_appbrand_widget_c_a = new c$a();
            try {
                com_tencent_mm_plugin_appbrand_widget_c_a.uX = c.uQ(str3);
                com_tencent_mm_plugin_appbrand_widget_c_a.jUI = c.uQ(str4);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandPageTabBar", e.getMessage());
            }
            com_tencent_mm_plugin_appbrand_widget_c_a.jUJ = str2;
            com_tencent_mm_plugin_appbrand_widget_c_a.mUrl = str;
            if (com_tencent_mm_plugin_appbrand_widget_c_a.jUJ == null && (com_tencent_mm_plugin_appbrand_widget_c_a.uX == null || com_tencent_mm_plugin_appbrand_widget_c_a.jUI == null)) {
                x.e("MicroMsg.AppBrandPageTabBar", "illegal data");
            } else {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(cVar.getContext()).inflate(h.ixt, cVar.jUu, false);
                cVar.a(viewGroup, com_tencent_mm_plugin_appbrand_widget_c_a);
                viewGroup.setOnClickListener(new 2(cVar));
                cVar.jUz.add(com_tencent_mm_plugin_appbrand_widget_c_a);
                cVar.jUu.addView(viewGroup);
            }
        }
        cVar.jUB = new 1(this, eVar);
        return cVar;
    }

    public final void loadUrl(String str) {
        if (!str.equals(this.jCS)) {
            int uR = this.jCV.uR(str);
            if (uR >= 0) {
                this.jCS = str;
                this.jCV.lR(uR);
                if (this.jCY.get(l.uB(str)) == null) {
                    p tC = tC(l.uB(str));
                    aev();
                    Runnable 2 = new 2(this, str);
                    tC.a(new 3(this, tC, 2, System.currentTimeMillis()));
                    if (this.jCY.size() > 1) {
                        this.jCZ.add(2);
                        postDelayed(2, 500);
                    }
                    tC.rQ(str);
                    return;
                }
                aiN();
                tD(str);
            }
        }
    }

    private synchronized p tC(String str) {
        p pVar;
        if (this.jCX != null) {
            pVar = this.jCX;
            this.jCX = null;
        } else {
            pVar = this.iqC.aiU();
        }
        this.jCY.put(str, pVar);
        pVar.aeI();
        this.jCW.addView(pVar.getContentView(), 0);
        return pVar;
    }

    private void tD(String str) {
        p pVar = (p) this.jCY.get(l.uB(str));
        pVar.getContentView().setVisibility(4);
        p pVar2 = null;
        for (p pVar3 : this.jCY.values()) {
            p pVar32;
            if (pVar32.getContentView().getVisibility() != 0) {
                pVar32 = pVar2;
            }
            pVar2 = pVar32;
        }
        pVar.getContentView().setVisibility(0);
        pVar.jDM.removeView(pVar.jDN.getActionView());
        if (pVar.jEf != null) {
            pVar.jEf.addView(pVar.jDN.getActionView(), 0);
        }
        pVar.jEf = null;
        if (this.jCU.indexOfChild(pVar.jDN.getActionView()) == -1) {
            this.jCU.addView(pVar.jDN.getActionView(), 0);
        }
        if (pVar2 != null) {
            pVar2.getContentView().setVisibility(4);
            this.jCU.removeView(pVar2.jDN.getActionView());
        }
        pVar.aga();
        if (pVar2 != null) {
            pVar2.afA();
        }
        aeu();
    }

    private void aiN() {
        Iterator it = this.jCZ.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            removeCallbacks(bVar);
            bVar.Mu = true;
        }
        this.jCZ.clear();
    }

    protected final void aeu() {
        super.aeu();
        boolean abN = this.iqC.irP.iqy.iMy.abN();
        aex().cD(abN);
        if ("top".equals(this.iqC.irP.iqy.iMA.iML) && abN) {
            b bVar = (b) aex().jDN;
            if (bVar.jVR) {
                bVar.jVR = false;
                bVar.amq();
            }
        }
    }

    public final boolean rO(String str) {
        return this.jCV.uR(str) != -1;
    }

    public final boolean rP(String str) {
        Object obj;
        for (p pVar : this.jCY.values()) {
            if (pVar.aeO() != null && pVar.aeO().equals(str)) {
                return true;
            }
        }
        c cVar = this.jCV;
        LinkedList linkedList = cVar.jUz;
        Iterator it = cVar.jUz.iterator();
        while (it.hasNext()) {
            obj = (c$a) it.next();
            if (obj.mUrl != null && obj.mUrl.equals(str)) {
                break;
            }
        }
        obj = null;
        return linkedList.indexOf(obj) != -1;
    }

    public final void aes() {
        super.aes();
        aex().aga();
    }

    public final void aet() {
        super.aet();
        aex().afA();
    }

    protected final void aer() {
        super.aer();
        if (this.jCX != null) {
            this.jCX.onDestroy();
        }
        for (p onDestroy : this.jCY.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void b(String str, String str2, int[] iArr) {
        if (this.jCX != null && c(iArr, this.jCX.hashCode())) {
            this.jCX.h(str, str2, 0);
        }
        for (p pVar : this.jCY.values()) {
            if (c(iArr, pVar.hashCode())) {
                pVar.h(str, str2, 0);
            }
        }
    }

    public final void cleanup() {
        super.cleanup();
        if (this.jCX != null) {
            this.jCX.cleanup();
        }
        for (p cleanup : this.jCY.values()) {
            cleanup.cleanup();
        }
        aiN();
    }

    public final synchronized p aex() {
        p pVar;
        if (this.jCX != null) {
            pVar = this.jCX;
        } else {
            pVar = (p) this.jCY.get(l.uB(this.jCS));
        }
        return pVar;
    }

    public final String aeq() {
        return this.jCS;
    }
}
