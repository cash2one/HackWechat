package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.cd.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.p.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.LinkedList;

public final class f implements com.tencent.mm.plugin.zero.a.f {
    private r ooJ;

    public final void bv(Object obj) {
        c aZj = s.aZj();
        if (aZj != null) {
            this.ooJ = (r) aZj.get();
        }
        if (this.ooJ == null) {
            this.ooJ = new a((byte) 0);
        }
        if (obj instanceof l) {
            ((h) g.h(h.class)).aZi().Et(((l) obj).TAG);
        } else if (obj instanceof String) {
            if (obj.equals("NetSceneInit")) {
                ((h) g.h(h.class)).aZi().Et((String) obj);
            }
        } else if (obj instanceof com.tencent.mm.modelmulti.r.c) {
            ((h) g.h(h.class)).aZi().Et(obj.toString());
        }
    }

    public final void a(ol olVar, byte[] bArr, boolean z) {
        p st = a.st(olVar.vXp);
        if (st != null) {
            try {
                st.a(olVar, bArr, z, this.ooJ);
                return;
            } catch (IOException e) {
                x.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + e.getMessage());
                throw new RuntimeException("docmd: parse protobuf error");
            }
        }
        x.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[]{Integer.valueOf(olVar.vXp)});
    }

    public final void bw(Object obj) {
        if (obj instanceof l) {
            this.ooJ.are();
            ((h) g.h(h.class)).aZi().Eu(((l) obj).TAG);
            ag Dm = g.Dm();
            String str = ((l) obj).TAG;
            com.tencent.mm.modelmulti.s sVar = ((l) obj).hFL;
            l lVar = (l) obj;
            LinkedList linkedList = (lVar.hFT == null || lVar.hFT.vBR.vRD == null) ? null : lVar.hFT.vBR.vRD.ksP;
            Dm.F(new b(str, sVar, linkedList));
        } else if ((obj instanceof String) && obj.equals("NetSceneInit")) {
            this.ooJ.are();
            ((h) g.h(h.class)).aZi().Eu((String) obj);
        } else if (obj instanceof com.tencent.mm.modelmulti.r.c) {
            this.ooJ.are();
            ((h) g.h(h.class)).aZi().Eu(obj.toString());
        }
    }

    public final void bx(Object obj) {
        if (obj instanceof l) {
            ((h) g.h(h.class)).aZi().Eu(((l) obj).TAG);
        }
    }
}
