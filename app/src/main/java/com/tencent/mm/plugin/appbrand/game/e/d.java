package com.tencent.mm.plugin.appbrand.game.e;

import android.content.Context;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static boolean iYp = false;

    public static void bS(Context context) {
        String str = q.gGc.gCF;
        if (iYp) {
            x.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
            return;
        }
        String string = ac.getResources().getString(j.iBB);
        String string2 = ac.getResources().getString(j.dGO);
        if (bh.ov(str)) {
            str = string;
        }
        a.a(context, str, string2, ac.getResources().getString(j.dFU), "", new 1(), new 2(), new 3());
        iYp = true;
    }
}
