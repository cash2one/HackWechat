package com.tencent.mm.plugin.zero;

import com.tencent.mm.k.e;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class a implements c, com.tencent.mm.plugin.zero.b.a {
    private e vax = new e();
    private com.tencent.mm.k.c vay = new com.tencent.mm.k.c();

    public final e zY() {
        g.Dk();
        g.Dh().Ct();
        return this.vax;
    }

    public final com.tencent.mm.k.c zZ() {
        g.Dk();
        g.Dh().Ct();
        return this.vay;
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (cVar.gQA) {
            com.tencent.mm.k.c cVar2 = this.vay;
            File file = new File(com.tencent.mm.compatible.util.e.bnF + "configlist/");
            if (file.exists()) {
                File file2 = new File(com.tencent.mm.k.c.gId);
                if (!file2.exists()) {
                    x.d("MicroMsg.ConfigListDecoder", "bugfix");
                    cVar2.b(file, file2);
                }
            }
        }
        this.vax.ks();
        this.vay.init();
    }

    public final void onAccountRelease() {
    }
}
