package com.tencent.mm.plugin.game.ui;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.c.bl;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

class GameIndexListView$2 implements a {
    final /* synthetic */ GameIndexListView nrj;

    GameIndexListView$2(GameIndexListView gameIndexListView) {
        this.nrj = gameIndexListView;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            Collection collection;
            GameIndexListView.a(this.nrj, (bl) bVar.hmh.hmo);
            bl b = GameIndexListView.b(this.nrj);
            boolean c = GameIndexListView.c(this.nrj);
            if (b == null || bh.cA(b.niv)) {
                collection = null;
            } else {
                LinkedList linkedList = new LinkedList();
                if (c && !bh.ov(b.nfO)) {
                    f fVar = new f();
                    fVar.type = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
                    fVar.nbr = b.nfO;
                    linkedList.add(fVar);
                }
                Iterator it = b.niv.iterator();
                while (it.hasNext()) {
                    ag agVar = (ag) it.next();
                    f fVar2;
                    if (agVar.nfS != 7) {
                        fVar2 = new f();
                        fVar2.type = agVar.nfS;
                        fVar2.position = agVar.nfP;
                        fVar2.nbs = agVar;
                        linkedList.add(fVar2);
                    } else if (!(agVar.ngK == null || bh.cA(agVar.ngK.nfN))) {
                        if (!bh.ov(agVar.ngK.fon)) {
                            fVar2 = new f();
                            fVar2.nbs = agVar;
                            fVar2.type = 1000;
                            linkedList.add(fVar2);
                        }
                        Iterator it2 = agVar.ngK.nfN.iterator();
                        while (it2.hasNext()) {
                            aa aaVar = (aa) it2.next();
                            f fVar3 = new f();
                            fVar3.nbs = agVar;
                            fVar3.type = 1001;
                            fVar3.nbt = agVar.ngK.nfN.indexOf(aaVar);
                            linkedList.add(fVar3);
                        }
                        fVar2 = new f();
                        fVar2.nbs = agVar;
                        fVar2.type = 1002;
                        linkedList.add(fVar2);
                    }
                }
                Object obj = linkedList;
            }
            GameIndexListView.d(this.nrj);
            ak.a(GameIndexListView.b(this.nrj));
            if (!GameIndexListView.b(this.nrj).nix) {
                this.nrj.dB(false);
            }
            if (!bh.cA(collection)) {
                RecyclerView.a e = GameIndexListView.e(this.nrj);
                e.nrk.addAll(collection);
                e.UR.notifyChanged();
            }
        }
        return 0;
    }
}
