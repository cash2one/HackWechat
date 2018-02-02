package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.R;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.a.is;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

public final class b implements d {
    public final com.tencent.mm.ae.d.b b(a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar == null || bwVar.ngq != 47) {
            x.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
        } else {
            String a = n.a(bwVar.vGX);
            String a2 = n.a(bwVar.vGY);
            ar.Hg();
            if (!((String) c.CU().get(2, null)).equals(a)) {
                a2 = a;
            }
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(a2, n.a(bwVar.vGZ), bwVar.vHe, bwVar.vHc, aVar);
            com.tencent.mm.z.ba.b hT = ba.hT(bwVar.vHc);
            if (hT != null) {
                x.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[]{hT.hgG});
                if (hT.hgI != null && hT.scene == 1) {
                    int i;
                    a2 = n.a(bwVar.vGX);
                    ar.Hg();
                    c.CU().set(73729, Integer.valueOf(1));
                    h hVar = new h();
                    hVar.field_content = ac.getContext().getString(R.l.exx);
                    hVar.field_createtime = bh.Wo();
                    hVar.field_imgpath = "";
                    hVar.field_sayhicontent = hVar.field_content;
                    hVar.field_sayhiuser = a2;
                    hVar.field_scene = 18;
                    if (bwVar.ktm > 3) {
                        i = bwVar.ktm;
                    } else {
                        i = 3;
                    }
                    hVar.field_status = i;
                    hVar.field_svrid = bwVar.vHe;
                    hVar.field_talker = a2;
                    hVar.field_type = bwVar.ngq;
                    hVar.field_isSend = 0;
                    hVar.field_sayhiencryptuser = a2;
                    hVar.field_ticket = hT.hgI;
                    l.Ty().a(hVar);
                    com.tencent.mm.sdk.b.b isVar = new is();
                    isVar.fzh.fzi = a2;
                    com.tencent.mm.sdk.b.a.xef.m(isVar);
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
