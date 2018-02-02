package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.gt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class SubCoreGameCenter$10 extends c<gt> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$10(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = gt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gt gtVar = (gt) bVar;
        x.i("MicroMsg.SubCoreGameCenter", "opType = %d, opStatus = %d, appId = %s", new Object[]{Integer.valueOf(gtVar.fwS.opType), Integer.valueOf(gtVar.fwS.fwT), gtVar.fwS.appId});
        if (gtVar.fwS.opType != 0) {
            switch (gtVar.fwS.opType) {
                case 2:
                    n.aQg();
                    n.a(gtVar.fwS.appId, gtVar.fwS.fwT, false, gtVar.fwS.fqf);
                    break;
                case 6:
                    n.aQg();
                    n.cK(gtVar.fwS.appId, gtVar.fwS.fqf);
                    break;
                default:
                    SubCoreGameCenter.aRg();
                    z.b(gtVar.fwS.appId, gtVar.fwS.opType, gtVar.fwS.fwT, gtVar.fwS.openId, gtVar.fwS.fqf);
                    break;
            }
        }
        return false;
    }
}
