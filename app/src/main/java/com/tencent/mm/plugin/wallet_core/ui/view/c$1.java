package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.d;

class c$1 implements b {
    final /* synthetic */ c sXz;

    c$1(c cVar) {
        this.sXz = cVar;
    }

    public final Bitmap oo(String str) {
        return d.decodeFile(str, null);
    }
}
