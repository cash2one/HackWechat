package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.f.e;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public final class aa extends a {
    private static final int rlE = Color.parseColor("#26eae9e2");
    private CountDownLatch lPT;
    private RadarChart rlF;
    private Bitmap rlG;
    private Bitmap rlH;

    static /* synthetic */ void a(aa aaVar, Bitmap bitmap, Bitmap bitmap2) {
        y yVar = (y) aaVar.bwV();
        RadarChart radarChart = aaVar.rlF;
        radarChart.ril = 0;
        radarChart.rin = null;
        radarChart.rie = null;
        radarChart.ric = null;
        aaVar.rlF.rim = 5;
        c cVar = new c();
        cVar.rhH = 0;
        int parseColor = Color.parseColor(yVar.rhr);
        int i = 1442840575 & parseColor;
        parseColor &= Integer.MAX_VALUE;
        cVar.backgroundColor = i;
        cVar.rhM = rlE;
        cVar.rhQ = 1.0f;
        cVar.rib = bitmap2;
        cVar.rhN = rlE;
        cVar.rhO = rlE;
        cVar.rhP = (float) a.fromDPToPix(aaVar.context, 1);
        cVar.rhR = -1;
        cVar.rhT = 30.0f;
        cVar.rhS = 40.0f;
        cVar.rhX = bitmap;
        cVar.rhY = yVar.rhq;
        cVar.rhZ = Color.parseColor("#7feae9e2");
        cVar.ria = a.fromDPToPix(aaVar.context, 1);
        RadarChart radarChart2 = aaVar.rlF;
        radarChart2.rid = cVar;
        if (radarChart2.rif != null) {
            RadarGrid radarGrid = radarChart2.rif;
            radarGrid.rip = cVar;
            radarGrid.invalidate();
        }
        b bVar = new b();
        bVar.rhB = rlE;
        bVar.rhC = 1.0f;
        bVar.rhD = parseColor;
        bVar.rhE = 127;
        bVar.rhF = Color.parseColor("#00fcff");
        bVar.rhG = a.fromDPToPix(aaVar.context, 2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(yVar.rhs);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(yVar.rhu);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(yVar.rht);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(yVar.rhv);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a(bVar);
        StringBuilder stringBuilder = new StringBuilder();
        for (y.a aVar2 : yVar.pYN) {
            if (aVar2 != null) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(aVar2.label).append(":").append(aVar2.rhx);
                Spannable spannableString = new SpannableString(stringBuilder.toString());
                a(spannableString, 0, aVar2.label.length() + 1, foregroundColorSpan, absoluteSizeSpan);
                a(spannableString, aVar2.label.length() + 1, stringBuilder.length(), foregroundColorSpan2, absoluteSizeSpan2);
                aVar.put(spannableString, Float.valueOf(aVar2.value));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        try {
            aaVar.rlF.a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[]) arrayList.toArray(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[arrayList.size()]));
        } catch (Throwable e) {
            Log.getStackTraceString(e);
        }
        aaVar.rlF.rik = 2;
    }

    public aa(Context context, y yVar, ViewGroup viewGroup) {
        super(context, yVar, viewGroup);
    }

    public final View bwW() {
        this.rlF = (RadarChart) this.contentView.findViewById(f.qBC);
        return this.contentView;
    }

    protected final void bxa() {
        this.lPT = new CountDownLatch(2);
        e.b(new 1(this), "AdlandingRadarComp").start();
        y yVar = (y) bwV();
        if (yVar != null) {
            d.a(yVar.rhp, yVar.rgL, new 2(this));
            d.a(yVar.rhw, yVar.rgL, new 3(this));
            return;
        }
        Log.wtf("AdlandingRadarChartComp", "null info");
    }

    protected final int bjK() {
        return i$g.qGJ;
    }

    private static void a(Spannable spannable, int i, int i2, Object... objArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            spannable.setSpan(objArr[i3], i, i2, 18);
        }
    }
}
