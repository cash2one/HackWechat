package com.tencent.mm.console;

import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.console.b.8;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$8$2 implements e {
    final /* synthetic */ 8 gIz;

    b$8$2(8 8) {
        this.gIz = 8;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 4 && i2 == -102) {
            ag.y(new 1(this));
            return;
        }
        Toast.makeText(this.gIz.val$context, "DefaultRSA check pass", 0).show();
        b.w(this.gIz.val$context, "");
    }
}
