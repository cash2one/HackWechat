package com.tencent.mm.plugin.collect.b;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.g;

public final class u extends c<ol> {
    Dialog iib;

    public u() {
        this.xen = ol.class.getName().hashCode();
    }

    private boolean a(final ol olVar) {
        x.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[]{Integer.valueOf(olVar.fGq.type)});
        if (olVar.fGq.fqH == null || olVar.fGq.fqH.get() == null) {
            x.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
            olVar.fGq.fqI.run();
        } else {
            Context context = (Context) olVar.fGq.fqH.get();
            k kVar;
            if (olVar.fGq.type == 0) {
                this.iib = g.a(context, false, null);
                kVar = new k(olVar.fGq.fGs, olVar.fGq.scene);
                com.tencent.mm.kernel.g.CG().a(1800, new 1(this, olVar));
                com.tencent.mm.kernel.g.CG().a(kVar, 0);
            } else if (olVar.fGq.type == 1) {
                this.iib = g.a(context, false, null);
                kVar = new com.tencent.mm.plugin.collect.reward.a.c(olVar.fGq.fGs, olVar.fGq.scene);
                com.tencent.mm.kernel.g.CG().a(2811, new e(this) {
                    final /* synthetic */ u ljj;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (this.ljj.iib != null && this.ljj.iib.isShowing()) {
                            this.ljj.iib.dismiss();
                            this.ljj.iib = null;
                        }
                        com.tencent.mm.kernel.g.CG().b(2811, this);
                        com.tencent.mm.plugin.collect.reward.a.c cVar = (com.tencent.mm.plugin.collect.reward.a.c) kVar;
                        cVar.a(new 3(this)).b(new 2(this, cVar)).c(new 1(this));
                        olVar.fGq.fqI.run();
                    }
                });
                com.tencent.mm.kernel.g.CG().a(kVar, 0);
            } else {
                x.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[]{Integer.valueOf(olVar.fGq.type)});
            }
        }
        return false;
    }
}
