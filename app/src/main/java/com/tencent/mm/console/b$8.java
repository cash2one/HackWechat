package com.tencent.mm.console;

import android.content.Context;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$8 implements e {
    final /* synthetic */ boolean gIy;
    final /* synthetic */ Context val$context;

    b$8(boolean z, Context context) {
        this.gIy = z;
        this.val$context = context;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 4 || i2 == -102 || this.gIy) {
            new m().a(g.Di().gPJ.hmV, new 2(this));
        } else {
            ag.y(new 1(this));
        }
    }
}
