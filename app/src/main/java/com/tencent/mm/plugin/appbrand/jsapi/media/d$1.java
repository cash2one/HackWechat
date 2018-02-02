package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;
import java.io.File;

class d$1 implements a {
    final /* synthetic */ String[] jnG;
    final /* synthetic */ d jnH;

    d$1(d dVar, String[] strArr) {
        this.jnH = dVar;
        this.jnG = strArr;
    }

    public final void b(int i, int i2, Intent intent) {
        String[] strArr = this.jnG;
        for (String file : strArr) {
            try {
                new File(file).delete();
            } catch (Exception e) {
            }
        }
    }
}
