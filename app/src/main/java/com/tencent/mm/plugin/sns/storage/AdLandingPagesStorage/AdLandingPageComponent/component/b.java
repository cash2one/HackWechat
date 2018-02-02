package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b extends i {
    public b(Context context, c cVar, ViewGroup viewGroup) {
        super(context, cVar, viewGroup);
    }

    protected final void a(LinearLayout linearLayout) {
        c cVar = (c) this.rji;
        if (linearLayout != null) {
            View linearLayout2;
            int i = (int) cVar.rfU;
            int i2 = (int) cVar.rfV;
            if (Double.compare(cVar.rfU, cVar.rfV) != 0) {
                if (i == 0 && cVar.rfU != 0.0d) {
                    i = 1;
                }
                if (i2 == 0 && cVar.rfV != 0.0d) {
                    i2 = 1;
                }
            } else if (i == 0) {
                i2 = 1;
                i = 1;
            }
            x.i("AdLandingBorderedComp", "border width top %d,bottom %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i > 0) {
                linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setBackgroundColor(cVar.rfW);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
                layoutParams.gravity = 48;
                linearLayout.addView(linearLayout2, 0, layoutParams);
            }
            if (i2 > 0) {
                linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setBackgroundColor(cVar.rfW);
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i2);
                layoutParams2.gravity = 80;
                linearLayout.addView(linearLayout2, layoutParams2);
            }
        }
    }
}
