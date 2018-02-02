package com.tencent.magicbrush.engine;

import android.content.Context;
import android.util.DisplayMetrics;

public final class d {
    public MBRendererJNI bnG = new MBRendererJNI();

    public final void a(b bVar, Context context, String str) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.bnG.Created(context.getAssets(), str, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, true, bVar.bnB);
    }
}
