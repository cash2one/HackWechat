package com.tencent.mm.ui.applet;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.mm.R;

public final class c {
    public static void fB(Context context) {
        a aVar = new a(context, LayoutInflater.from(context).inflate(R.i.dtg, null));
        aVar.xWe.addView(aVar.xWd, aVar.xWf);
    }
}
