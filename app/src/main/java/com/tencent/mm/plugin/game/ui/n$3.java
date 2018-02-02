package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.x;

class n$3 implements b {
    final /* synthetic */ n nsH;

    n$3(n nVar) {
        this.nsH = nVar;
    }

    public final void h(int i, String str, boolean z) {
        if (z && this.nsH.nsE != null && str != null) {
            try {
                for (o oVar : this.nsH.nsE.values()) {
                    if (!(oVar == null || oVar.nbT == null)) {
                        if (oVar.nbT.field_appId.equals(str) || oVar.nbT.field_packageName.equals(str)) {
                            oVar.cP(this.nsH.mContext);
                            oVar.aQj();
                        }
                    }
                }
                int i2 = 0;
                while (i2 < this.nsH.ndF.size()) {
                    d dVar = (d) this.nsH.ndF.get(i2);
                    if (dVar.type != 0 || (!(dVar.field_appId.equals(str) || dVar.field_packageName.equals(str)) || n.a(this.nsH) == null)) {
                        i2++;
                    } else {
                        n.a(this.nsH).qQ(i2);
                        return;
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.GameListAdapter", e.getMessage());
            }
        }
    }
}
