package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.w.a.j;
import java.lang.ref.WeakReference;

public enum a {
    ;
    
    private static volatile WeakReference<Bitmap> hjJ;

    public static Drawable Ji() {
        if (hjJ == null || hjJ.get() == null || ((Bitmap) hjJ.get()).isRecycled()) {
            hjJ = new WeakReference(com.tencent.mm.compatible.f.a.decodeResource(ac.getResources(), j.bBB));
        }
        Drawable a = k.a(ac.getResources(), (Bitmap) hjJ.get());
        a.br();
        return a;
    }
}
