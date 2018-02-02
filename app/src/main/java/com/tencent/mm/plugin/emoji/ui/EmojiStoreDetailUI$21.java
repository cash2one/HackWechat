package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.bv.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class EmojiStoreDetailUI$21 implements i {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$21(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        if (bitmap != null && objArr != null && objArr.length > 0 && EmojiStoreDetailUI.o(this.lDM) != null) {
            Object obj;
            int intValue = ((Integer) objArr[0]).intValue();
            ar.Hg();
            String G = EmojiLogic.G(c.Fp(), EmojiStoreDetailUI.a(this.lDM), str);
            String a = EmojiStoreDetailUI.a(this.lDM);
            String str2 = ((avh) EmojiStoreDetailUI.b(this.lDM).waH.get(intValue)).wCX;
            a.getDensity(EmojiStoreDetailUI.p(this.lDM));
            EmojiInfo a2 = EmojiLogic.a(a, 8, str2, true);
            e aAR = e.aAR();
            if (com.tencent.mm.a.e.bO(G)) {
                long currentTimeMillis = System.currentTimeMillis();
                int bN = com.tencent.mm.a.e.bN(G);
                int i = bN > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT ? WXMediaMessage.DESCRIPTION_LENGTH_LIMIT : bN;
                Object d = com.tencent.mm.a.e.d(G, 0, bN);
                Object aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.d(G, 0, i), aAR.aAS().getBytes(), true, false);
                if (bh.bw(aesCryptEcb) || bh.bw(d)) {
                    i = -1;
                } else {
                    System.arraycopy(aesCryptEcb, 0, d, 0, i);
                    i = com.tencent.mm.a.e.b(G, d, bN);
                }
                if (i == 0) {
                    g.pQN.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                    g.pQN.a(252, 6, 1, false);
                    x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(d.length), Long.valueOf(r10)});
                    obj = 1;
                } else {
                    x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    g.pQN.a(252, 3, 1, false);
                    obj = null;
                }
            } else {
                x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file do no exsit.");
                obj = null;
            }
            if (a2 != null) {
                if (obj != null) {
                    a2.field_reserved4 = EmojiInfo.xAz;
                } else {
                    a2.field_reserved4 = 0;
                }
                EmojiStoreDetailUI.o(this.lDM).post(new 1(this, a2, intValue));
                return;
            }
            x.i("MicroMsg.emoji.EmojiStoreDetailUI", "ignore no call back preview loader. ");
        }
    }
}
