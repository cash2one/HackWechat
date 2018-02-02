package com.tencent.mm.plugin.wear.ui;

import com.tencent.mm.g.a.tn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WearYoUI$2 extends c<tn> {
    final /* synthetic */ WearYoUI tjp;

    WearYoUI$2(WearYoUI wearYoUI) {
        this.tjp = wearYoUI;
        this.xen = tn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tn tnVar = (tn) bVar;
        if (tnVar instanceof tn) {
            switch (tnVar.fMc.fpr) {
                case 1:
                    if (!WearYoUI.a(this.tjp).equals(tnVar.fMc.username)) {
                        tnVar.fMd.fMe = 2;
                        break;
                    }
                    tnVar.fMd.fMe = 1;
                    break;
                case 2:
                    if (WearYoUI.a(this.tjp).equals(tnVar.fMc.username)) {
                        WearYoUI.b(this.tjp);
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
