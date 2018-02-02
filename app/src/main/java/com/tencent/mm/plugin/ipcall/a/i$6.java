package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.g.a.ig;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class i$6 extends c<ig> {
    final /* synthetic */ i nDs;

    i$6(i iVar) {
        this.nDs = iVar;
        this.xen = ig.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ig igVar = (ig) bVar;
        if (igVar instanceof ig) {
            if (igVar.fyJ.fyM && i.a(this.nDs) == igVar.fyJ.fyL && i.b(this.nDs) != null) {
                i.a(this.nDs, null);
                i.a(this.nDs, 0);
            }
            if (!igVar.fyJ.fyM) {
                if (igVar.fyJ.fyL == 0) {
                    i.a(this.nDs, null);
                    i.a(this.nDs, 0);
                } else {
                    i.a(this.nDs, igVar.fyJ.fyK);
                    i.a(this.nDs, igVar.fyJ.fyL);
                }
            }
        }
        return false;
    }
}
