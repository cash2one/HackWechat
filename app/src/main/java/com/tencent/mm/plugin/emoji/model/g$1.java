package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;

class g$1 extends c<fp> {
    final /* synthetic */ g lxK;

    g$1(g gVar) {
        this.lxK = gVar;
        this.xen = fp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fp fpVar = (fp) bVar;
        EmojiInfo emojiInfo = new EmojiInfo();
        emojiInfo.field_designerID = fpVar.fuV.fuX;
        emojiInfo.field_name = fpVar.fuV.name;
        emojiInfo.field_aeskey = fpVar.fuV.aeskey;
        emojiInfo.field_encrypturl = fpVar.fuV.fuY;
        emojiInfo.field_thumbUrl = fpVar.fuV.thumbUrl;
        emojiInfo.field_md5 = fpVar.fuV.fqR;
        emojiInfo.field_groupId = fpVar.fuV.fqV;
        EmojiInfo XU = i.aBE().lwL.XU(emojiInfo.Nr());
        if (fpVar.fuV.fpr == 3) {
            String ckB = emojiInfo.ckB();
            if (XU == null || (XU.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
                fpVar.fuW.path = ckB;
            } else {
                String absolutePath = new File(ac.getContext().getCacheDir(), g.s(fpVar.fuV.fqR.getBytes())).getAbsolutePath();
                if (FileOp.bO(ckB) && !FileOp.bO(absolutePath)) {
                    e.d(absolutePath, ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(XU));
                }
                fpVar.fuW.path = absolutePath;
            }
            x.i("MicroMsg.FTS.FTSEmojiLogic", "gen path: %s", new Object[]{fpVar.fuW.path});
        } else if (fpVar.fuV.fpr == 1) {
            x.i("MicroMsg.FTS.FTSEmojiLogic", "emoji download: %s", new Object[]{emojiInfo.Nr()});
            this.lxK.lxH.add(emojiInfo.Nr());
            i.aBy().g(emojiInfo);
        }
        return false;
    }
}
