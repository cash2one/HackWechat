package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart extends Chart {
    private Context context;
    public ArrayList<a> ric;
    public c rid = new c();
    public TextView rie;
    public RadarGrid rif;
    private RadarDataLayer[] rig;
    private a rih;
    private boolean rii = true;
    private boolean rij = true;
    public int rik = 3;
    public int ril = 0;
    public int rim = 4;
    public Spannable[] rin;
    private float rio = 1.0f;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public final void a(a... aVarArr) {
        int i;
        int i2 = 0;
        removeAllViews();
        for (a size : aVarArr) {
            if (size.size() <= 0) {
                throw new Exception("Not enough elements.");
            }
        }
        for (a size2 : aVarArr) {
            i = 0;
            while (i < aVarArr.length) {
                if (size2.a(aVarArr[i])) {
                    i++;
                } else {
                    throw new Error("Layer not compatible.");
                }
            }
        }
        this.rin = aVarArr[0].bwP();
        this.ril = aVarArr[0].size();
        if (this.ric == null) {
            this.ric = new ArrayList();
        }
        for (Object add : aVarArr) {
            this.ric.add(add);
        }
        this.rif = new RadarGrid(this.context, this.ril, this.rim, this.rio, this.rin, this.rid);
        addView(this.rif);
        this.rig = new RadarDataLayer[this.rik];
        while (i2 < this.rig.length && this.ric.size() > i2) {
            this.rig[i2] = new RadarDataLayer(this.context, this.rio, (a) this.ric.get(i2));
            addView(this.rig[i2]);
            i2++;
        }
        if (this.rih == null) {
            this.rih = new a(this.context, this.rid);
        }
        addView(this.rih);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }
}
