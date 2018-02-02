package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.hx;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$2 extends c<hx> {
    final /* synthetic */ b lvv;

    b$2(b bVar) {
        this.lvv = bVar;
        this.xen = hx.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        switch (((hx) bVar).fyq.errorCode) {
            case 101:
                g.pQN.a(401, 3, 1, false);
                break;
            case 102:
                g.pQN.a(401, 4, 1, false);
                break;
            case 104:
                g.pQN.a(401, 6, 1, false);
                break;
            case 105:
                g.pQN.a(401, 7, 1, false);
                break;
            case 106:
                g.pQN.a(401, 8, 1, false);
                break;
            case 107:
                g.pQN.a(401, 9, 1, false);
                break;
            case 108:
                g.pQN.a(401, 10, 1, false);
                break;
            case 109:
                g.pQN.a(401, 11, 1, false);
                break;
            case 110:
                g.pQN.a(401, 12, 1, false);
                break;
            case 111:
                g.pQN.a(401, 13, 1, false);
                break;
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                g.pQN.a(401, 14, 1, false);
                break;
            case 113:
                g.pQN.a(401, 15, 1, false);
                break;
        }
        return false;
    }
}
