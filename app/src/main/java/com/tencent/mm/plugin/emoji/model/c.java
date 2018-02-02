package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a;
import com.tencent.mm.g.a.q;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class c implements e {
    private com.tencent.mm.aq.a.c.c lxp = new 1(this);

    static /* synthetic */ void a(c cVar, rw rwVar, boolean z) {
        x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to download by cgi.emojiMd5:%s", new Object[]{rwVar.vZL});
        if (z) {
            com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 3, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.cm(8);
        } else {
            com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 2, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.cm(3);
        }
        bf(rwVar.vZL, 2);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 221:
                return;
            case 697:
                String str2 = "";
                com.tencent.mm.plugin.emoji.f.e eVar = (com.tencent.mm.plugin.emoji.f.e) kVar;
                if (eVar.lyE == com.tencent.mm.plugin.emoji.f.e.lyC) {
                    fl flVar = eVar.gJQ == null ? null : (fl) eVar.gJQ.hmg.hmo;
                    if (!(flVar == null || flVar.vLi == null || flVar.vLi.size() <= 0)) {
                        str2 = (String) flVar.vLi.get(0);
                    }
                    if (i == 0 && i2 == 0) {
                        fm fmVar = eVar.gJQ == null ? null : (fm) eVar.gJQ.hmh.hmo;
                        if (fmVar == null || fmVar.vLk == null || fmVar.vLk.size() <= 0) {
                            bf(str2, 2);
                            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "NetSceneBatchEmojiDownLoad MD5 to URL failed.");
                            return;
                        }
                        rw rwVar = (rw) fmVar.vLk.get(0);
                        ar.Hg();
                        String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", rwVar.vZL);
                        a aBe;
                        String str3;
                        String str4;
                        if (!bh.ov(rwVar.vZN) && !bh.ov(rwVar.vZO)) {
                            aBe = i.aBe();
                            str3 = rwVar.vZN;
                            str4 = rwVar.vZN;
                            aBe.a(str3, f.i(H + "_encrypt", new Object[]{rwVar, Boolean.valueOf(true)}), this.lxp);
                            com.tencent.mm.plugin.emoji.c.cm(6);
                            return;
                        } else if (bh.ov(rwVar.nfX)) {
                            x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no url info. download faild.");
                            bf(str2, 2);
                            return;
                        } else {
                            aBe = i.aBe();
                            str3 = rwVar.nfX;
                            str4 = rwVar.nfX;
                            aBe.a(str3, f.h(H, new Object[]{rwVar, Boolean.valueOf(false)}), this.lxp);
                            com.tencent.mm.plugin.emoji.c.cm(1);
                            return;
                        }
                    }
                    bf(str2, 2);
                    return;
                }
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no request type ");
                return;
            default:
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no download app attach scene");
                return;
        }
    }

    public static void bf(String str, int i) {
        b qVar = new q();
        qVar.fnx.fny = str;
        qVar.fnx.status = i;
        qVar.fnx.fnz = 0;
        com.tencent.mm.sdk.b.a.xef.m(qVar);
        x.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "attachid:%s percentage:%d status:%d", new Object[]{str, Integer.valueOf(0), Integer.valueOf(i)});
    }
}
