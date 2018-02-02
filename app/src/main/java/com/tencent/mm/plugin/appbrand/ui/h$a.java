package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;

class h$a extends TextView {
    final /* synthetic */ h jNe;

    public h$a(h hVar, Context context) {
        this.jNe = hVar;
        super(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int fromDPToPix = a.fromDPToPix(getContext(), 5);
        layoutParams.setMargins(0, fromDPToPix, 0, fromDPToPix);
        setLayoutParams(layoutParams);
        setTextSize(1, 12.0f);
        setTextColor(-7171438);
    }
}
