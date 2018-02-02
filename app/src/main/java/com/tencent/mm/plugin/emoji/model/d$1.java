package com.tencent.mm.plugin.emoji.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.z.ar;

class d$1 implements Runnable {
    final /* synthetic */ String lwx;
    final /* synthetic */ d lxy;

    d$1(d dVar, String str) {
        this.lxy = dVar;
        this.lwx = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        String str;
        int i = 1;
        c cVar = i.aBE().lwN;
        String str2 = this.lwx;
        if (!(TextUtils.isEmpty(str2) || str2.equals(EmojiGroupInfo.xAb))) {
            long j = cVar.xAA.getLong("274544" + str2, 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j < 86400000) {
                if (!cVar.XT(str2)) {
                }
            }
            if (i != 0) {
                i.aBA();
                str = this.lwx;
                if (bh.ov(str)) {
                    ar.CG().a(new k(str), 0);
                    return;
                }
                x.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
            }
        }
        i = 0;
        if (i != 0) {
            i.aBA();
            str = this.lwx;
            if (bh.ov(str)) {
                ar.CG().a(new k(str), 0);
                return;
            }
            x.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
        }
    }
}
