package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.File;

public final class c extends com.tencent.mm.sdk.b.c<bd> {
    public c() {
        this.xen = bd.class.getName().hashCode();
    }

    private static boolean a(bd bdVar) {
        if (bdVar.fpq.fpm == 37) {
            if (bdVar.fpq.fpn == 5 && bdVar.fpq.fpr == 2) {
                i aBg = i.aBg();
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    ar.Hg();
                    b.deleteFile(stringBuilder.append(com.tencent.mm.z.c.FB()).append("eggingfo.ini").toString());
                    e.g(new File(i.aBh(), i.lvR));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                }
                aBg.lwi = null;
            }
            if (bdVar.fpq.fpr == 0) {
                x.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[]{Integer.valueOf(bdVar.fpq.fpm), Integer.valueOf(bdVar.fpq.fpn)});
            }
        }
        return false;
    }
}
