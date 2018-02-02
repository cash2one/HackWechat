package com.tencent.mm.plugin.soter_mp.a;

import android.app.Activity;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class a {
    public static final int rSU = 1;
    private static final /* synthetic */ int[] rSV = new int[]{rSU};

    public static c a(Activity activity, d dVar, e eVar) {
        if ((dVar.rTm & 1) != 0 && com.tencent.d.a.a.ic(ac.getContext())) {
            return new b(new WeakReference(activity), dVar, eVar);
        }
        x.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", Byte.valueOf(dVar.rTm));
        return null;
    }
}
