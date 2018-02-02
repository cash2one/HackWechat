package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class b extends a {
    private static final int kaN = a.fromDPToPix(ac.getContext(), 48);
    private static final int kaO = a.fromDPToPix(ac.getContext(), 43);

    public final View mj(int i) {
        View view = null;
        Context context = this.kaK;
        c cVar = this.kaL;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.kbh = this;
        dVar.mContext = context;
        dVar.kaL = cVar;
        if (!(dVar.mContext == null || dVar.kbh == null)) {
            view = View.inflate(dVar.mContext, h.ixF, null);
            if (view instanceof AppBrandSmileyGrid) {
                ((AppBrandSmileyGrid) view).kaL = dVar.kaL;
                AppBrandSmileyGrid appBrandSmileyGrid = (AppBrandSmileyGrid) view;
                int i2 = dVar.mIndex;
                int ans = dVar.kbh.ans();
                int ant = dVar.kbh.ant();
                int anu = dVar.kbh.anu();
                int rowCount = dVar.kbh.getRowCount();
                int anv = dVar.kbh.anv();
                appBrandSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                appBrandSmileyGrid.setBackgroundResource(0);
                appBrandSmileyGrid.setStretchMode(2);
                appBrandSmileyGrid.setOnItemClickListener(appBrandSmileyGrid.XC);
                appBrandSmileyGrid.kaS = i2;
                appBrandSmileyGrid.kaQ = ans;
                appBrandSmileyGrid.kaR = ant;
                appBrandSmileyGrid.kaT = anv;
                appBrandSmileyGrid.kaU = anu;
                appBrandSmileyGrid.kaV = rowCount;
                appBrandSmileyGrid.setNumColumns(anu);
                i2 = appBrandSmileyGrid.kaT;
                anv = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                ans = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                }
                appBrandSmileyGrid.setPadding(anv, i2, ans, 0);
                appBrandSmileyGrid.kaP = new AppBrandSmileyGrid.a(appBrandSmileyGrid, (byte) 0);
                appBrandSmileyGrid.setAdapter(appBrandSmileyGrid.kaP);
                appBrandSmileyGrid.kaP.notifyDataSetChanged();
            }
        }
        return view;
    }

    public final int ans() {
        return this.kaL.ank().anm();
    }

    public final int ant() {
        return anu() * getRowCount();
    }

    public final int getPageCount() {
        if (ant() <= 0) {
            return 0;
        }
        return (int) Math.ceil(((double) ans()) / ((double) ant()));
    }

    public final int anu() {
        if (this.kaL.kbb) {
            return 7;
        }
        c cVar = this.kaL;
        if (cVar.kbg <= 1) {
            cVar.kbg = c.akV()[0];
        }
        return cVar.kbg / kaO;
    }

    public final int anv() {
        return (this.kaL.kbf - (kaN * getRowCount())) / (getRowCount() + 1);
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.kaL.kbf / kaN;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }
}
