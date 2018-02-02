package com.tencent.mm.plugin.collect.b;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.d;

class c$1 implements b {
    final /* synthetic */ c lig;

    c$1(c cVar) {
        this.lig = cVar;
    }

    public final Bitmap oo(String str) {
        return d.decodeFile(str, null);
    }
}
