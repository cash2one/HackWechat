package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends i {
    int riB;
    private RecyclerView riC;
    private b riD;
    Map<Integer, a> riE = new HashMap();
    LinearLayoutManager riF;
    Set<Integer> riG = new HashSet();

    private class a {
        int count;
        boolean isVisible;
        long riH;
        final /* synthetic */ c riI;
        long time;

        private a(c cVar) {
            this.riI = cVar;
        }

        final void bwY() {
            if (this.isVisible) {
                this.isVisible = false;
                if (this.riH > 0) {
                    this.time += System.currentTimeMillis() - this.riH;
                    this.riH = 0;
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar) {
        cVar.bwX();
        int eZ = cVar.riF.eZ();
        int fa = cVar.riF.fa();
        for (Entry entry : cVar.riE.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < eZ || ((Integer) entry.getKey()).intValue() > fa) {
                ((a) entry.getValue()).bwY();
            }
        }
    }

    public c(Context context, m mVar, ViewGroup viewGroup) {
        super(context, mVar, viewGroup);
        this.riB = com.tencent.mm.bv.a.fromDPToPix(context, 12);
    }

    protected final int bjK() {
        return g.qGN;
    }

    public final View bwW() {
        this.riC = (RecyclerView) this.contentView.findViewById(f.qDh);
        this.riC.setBackgroundColor(((m) this.rji).backgroundColor);
        Iterator it = ((m) this.rji).rgv.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            s sVar = (s) it.next();
            if (sVar instanceof p) {
                p pVar = (p) sVar;
                i2 = ((int) ((sVar.rgM + sVar.rgN) + pVar.height)) + (this.riB << 1);
                if (i <= i2) {
                    i = i2;
                }
                i2 = i;
            } else {
                i2 = i;
            }
            i = i2;
        }
        LayoutParams layoutParams = this.riC.getLayoutParams();
        layoutParams.height = i;
        this.riC.setLayoutParams(layoutParams);
        this.riD = new b(this, (byte) 0);
        this.riC.a(this.riD);
        this.riF = new LinearLayoutManager();
        this.riF.setOrientation(0);
        this.riC.a(this.riF);
        this.riC.a(new c(this, this.riC, this.riF));
        this.riC.setNestedScrollingEnabled(false);
        this.riC.Ub = true;
        return this.contentView;
    }

    private void bwX() {
        if (this.riF != null) {
            dx(this.riF.eZ(), this.riF.fa());
        }
    }

    final void dx(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.riE.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a();
                this.riE.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.isVisible) {
                aVar.isVisible = true;
                aVar.riH = System.currentTimeMillis();
                aVar.count++;
            }
            i++;
        }
    }

    public final void bwH() {
        super.bwH();
        bwX();
    }

    public final void bwI() {
        super.bwI();
        if (this.riF != null) {
            int eZ = this.riF.eZ();
            int fa = this.riF.fa();
            for (int i = eZ; i <= fa; i++) {
                a aVar = (a) this.riE.get(Integer.valueOf(i));
                if (aVar != null) {
                    aVar.bwY();
                }
            }
        }
    }

    public final boolean s(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.S(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        try {
            Map map = this.riE;
            Set set = this.riG;
            this.riG = new HashSet();
            this.riE = new HashMap();
            for (Entry entry : map.entrySet()) {
                s sVar = (s) ((m) this.rji).rgv.get(((Integer) entry.getKey()).intValue());
                if (!sVar.rgX && (sVar instanceof p)) {
                    p pVar = (p) sVar;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ((s) ((m) this.rji).rgv.get(((Integer) entry.getKey()).intValue())).rgK);
                    jSONObject2.put("exposureCount", ((a) entry.getValue()).count);
                    jSONObject2.put("stayTime", ((a) entry.getValue()).time);
                    if (set.contains(entry.getKey())) {
                        String UZ = ab.UZ(pVar.rgz);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("urlMd5", UZ);
                        jSONObject3.put("needDownload", 1);
                        jSONObject2.put("imgUrlInfo", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            return true;
        } catch (Throwable e) {
            x.e("AdLandingCarouselComp", bh.i(e));
            return false;
        }
    }
}
