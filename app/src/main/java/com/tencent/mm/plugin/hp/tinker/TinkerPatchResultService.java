package com.tencent.mm.plugin.hp.tinker;

import android.os.Looper;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public class TinkerPatchResultService extends DefaultTinkerResultService {
    public final void a(a aVar) {
        int i = 1;
        if (aVar == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!", new Object[0]);
            return;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", new Object[]{aVar.toString()});
        new af(Looper.getMainLooper()).postDelayed(new 1(this), 10000);
        if (aVar.fsH) {
            ApplicationLike tinkerApplicationLike = MMApplicationLike.getTinkerApplicationLike();
            if (b.c(tinkerApplicationLike)) {
                String d = b.d(tinkerApplicationLike);
                if (!(ShareTinkerInternals.ov(d) || aVar.Aiu == null || !aVar.Aiu.equals(d))) {
                    i = 0;
                }
            }
            if (i != 0) {
                n nVar = new n(ac.getContext(), new 2(this));
            } else {
                com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }
}
