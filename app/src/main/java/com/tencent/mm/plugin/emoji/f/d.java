package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.fj;
import com.tencent.mm.protocal.c.fk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private ArrayList<String> lyA;

    public d(ArrayList<String> arrayList) {
        a aVar = new a();
        aVar.hmj = new fj();
        aVar.hmk = new fk();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
        aVar.hmi = 696;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lyA = arrayList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i3 == -434) {
            x.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
            ar.Hg();
            c.CU().a(w.a.xng, Boolean.valueOf(true));
            g.pQN.a(164, 4, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            c.CU().a(w.a.xng, Boolean.valueOf(false));
            com.tencent.mm.storage.emotion.d dVar = i.aBE().lwL;
            List list = this.lyA;
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
            } else {
                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", new Object[]{Integer.valueOf(list.size())});
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE");
                stringBuilder.append(" EmojiInfo ");
                stringBuilder.append(" SET ");
                stringBuilder.append("source");
                stringBuilder.append("=");
                stringBuilder.append(EmojiInfo.xAw);
                stringBuilder.append(" where ");
                stringBuilder.append("md5");
                stringBuilder.append(" IN (");
                for (int i4 = 0; i4 < list.size(); i4++) {
                    stringBuilder.append("'" + ((String) list.get(i4)) + "'");
                    if (i4 < list.size() - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append(")");
                x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                dVar.gJP.fx("EmojiInfo", stringBuilder.toString());
            }
            g.pQN.a(164, 2, 1, false);
        } else {
            g.pQN.a(164, 3, 1, false);
        }
        fk fkVar = (fk) this.gJQ.hmh.hmo;
        if (fkVar.vJM != null && fkVar.vJM.size() > 0) {
            x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
            i.aBE().lwL.ax(fkVar.vJM);
            ar.Hg();
            c.CU().set(348165, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.c.a.et(true);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 696;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        ((fj) this.gJQ.hmg.hmo).vJK = new LinkedList(this.lyA);
        if (this.lyA != null && this.lyA.size() > 0) {
            return a(eVar, this.gJQ, this);
        }
        x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
        ar.Hg();
        c.CU().set(348162, Boolean.valueOf(false));
        return -1;
    }
}
