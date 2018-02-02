package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.d.f;
import com.tencent.mm.pluginsdk.i.a.d.f.b;
import com.tencent.mm.pluginsdk.i.a.d.t;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k extends f<a> {
    private final a vhl = new a(this, 0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new t());

    protected final /* synthetic */ d a(b bVar) {
        return new a((a) bVar);
    }

    k() {
    }

    final void a(a aVar) {
        if (RU(aVar.vgd)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[]{aVar.vgd});
            return;
        }
        int i;
        if (!(aVar.vge && aVar.fpo == aVar.vgh && aVar.vgh >= 0) && (aVar.vge || !aVar.vgf)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[]{aVar.vgd});
            super.b(aVar);
        }
    }

    protected final a bZq() {
        return this.vhl;
    }
}
