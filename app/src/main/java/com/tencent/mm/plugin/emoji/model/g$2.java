package com.tencent.mm.plugin.emoji.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;

class g$2 implements a {
    final /* synthetic */ g lxK;

    g$2(g gVar) {
        this.lxK = gVar;
    }

    public final void h(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !this.lxK.lxH.remove(emojiInfo.Nr())) {
            x.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
            return;
        }
        x.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[]{emojiInfo.Nr()});
        b fpVar = new fp();
        fpVar.fuV.fpr = 2;
        fpVar.fuV.fuX = emojiInfo.field_designerID;
        fpVar.fuV.name = emojiInfo.field_name;
        fpVar.fuV.aeskey = emojiInfo.field_aeskey;
        fpVar.fuV.fuY = emojiInfo.field_encrypturl;
        fpVar.fuV.thumbUrl = emojiInfo.field_thumbUrl;
        fpVar.fuV.fqR = emojiInfo.field_md5;
        fpVar.fuV.fqV = emojiInfo.field_groupId;
        String ckB = emojiInfo.ckB();
        EmojiInfo XU = i.aBE().lwL.XU(emojiInfo.Nr());
        if (XU == null || (XU.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
            fpVar.fuW.path = ckB;
        } else {
            String absolutePath = new File(ac.getContext().getExternalCacheDir(), g.s(emojiInfo.Nr().getBytes())).getAbsolutePath();
            if (FileOp.bO(ckB) && !FileOp.bO(absolutePath)) {
                e.d(absolutePath, ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().a(XU));
            }
            fpVar.fuW.path = absolutePath;
        }
        com.tencent.mm.sdk.b.a.xef.a(fpVar, Looper.getMainLooper());
    }
}
