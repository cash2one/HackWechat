package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.i.a.c.c;
import com.tencent.mm.pluginsdk.i.a.c.e;
import com.tencent.mm.pluginsdk.i.a.d.j;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.m.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class d extends a<c> {
    public d(c cVar) {
        super(cVar);
    }

    public final String aab() {
        return "CheckResUpdate";
    }

    public final boolean bD(long j) {
        if (((c) aai()).fileSize <= 0 || ((c) aai()).fileSize == com.tencent.mm.pluginsdk.i.a.e.a.Gr(getFilePath()) + j) {
            return super.bD(j);
        }
        return false;
    }

    public final boolean aah() {
        if (super.aah()) {
            j.I(((c) aai()).vgl, 12);
            return true;
        }
        j.I(((c) aai()).vgl, 27);
        return false;
    }

    protected final l a(j jVar) {
        c cVar = (c) aai();
        String RR = i.RR(cVar.vgd);
        String str = cVar.fqR;
        if (cVar.tmA && bh.ou(g.bV(i.RR(cVar.vgd))).equals(str)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
            return new l(cVar, com.tencent.mm.pluginsdk.i.a.e.a.Gr(RR));
        } else if (!bh.bw(((c) aai()).vgL) && com.tencent.mm.pluginsdk.i.a.e.a.u(i.RR(((c) aai()).vgd), ((c) aai()).vgL) && bh.ou(g.bV(i.RR(((c) aai()).vgd))).equals(((c) aai()).fqR)) {
            return new l((k) aai(), com.tencent.mm.pluginsdk.i.a.e.a.Gr(i.RR(((c) aai()).vgd)));
        } else {
            l a = super.a(jVar);
            x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = " + a, new Object[]{cVar.vgd});
            if (a == null) {
                return new l("CheckResUpdate", bZj(), getURL(), getFilePath(), 0, "", new e());
            }
            if (a.status == 2) {
                if (bh.ov(((c) aai()).fqR) || !((c) aai()).fqR.equals(g.bV(getFilePath()))) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[]{cVar.vgd});
                    return new l("CheckResUpdate", bZj(), getURL(), getFilePath(), a.fMk, a.aBD, new c());
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[]{cVar.vgd});
            }
            return a;
        }
    }
}
