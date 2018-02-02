package com.tencent.mm.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.a.d;
import com.tencent.mm.view.f.a;

public class SmileyPanelViewPager extends CustomViewPager {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
    private int kbi = 0;
    private int kbj = 0;
    public a zDT;
    private boolean zDU = j.aS(getContext());
    public a zDs;

    public SmileyPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (bh.getInt(VERSION.SDK, 0) >= 9) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        boolean aS = j.aS(getContext());
        if (this.zDs != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.kbi) || (i > 0 && i != this.kbj)))) {
            if (this.zDs.kbf <= 0) {
                this.zDs.Hw(i2);
            }
            this.zDs.kbg = i;
            this.zDs.zeR = 0;
            if (!(this.zDT == null || (this.zDs.zGN && !this.zDs.zGO && this.zDU == aS))) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
                this.zDs.zGO = false;
                this.zDT.Hq(i2);
            }
        }
        this.zDU = aS;
        if (i2 > 0) {
            this.kbi = i2;
        }
        if (i > 0) {
            this.kbj = i;
        }
    }

    public final void a(u uVar) {
        super.a(uVar);
    }

    public final void a(d dVar) {
        if (dVar != null) {
            dVar.cAr();
            dVar.zEt = false;
        }
        super.a(dVar);
    }
}
