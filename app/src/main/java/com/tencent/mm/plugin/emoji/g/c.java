package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;
import java.util.Map;

public final class c implements a {
    public final void a(d.a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar.ngq == 10002) {
            String a = n.a(bwVar.vGZ);
            if (bh.ov(a)) {
                x.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
                return;
            }
            Map y = bi.y(a, "sysmsg");
            if (y != null && y.size() > 0) {
                a = (String) y.get(".sysmsg.$type");
                if (bh.ov(a) || !a.equalsIgnoreCase("emotionstore")) {
                    x.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :" + a);
                    return;
                }
                try {
                    int i;
                    int i2;
                    String str = (String) y.get(".sysmsg.emotionstore.productid");
                    a = (String) y.get(".sysmsg.emotionstore.newcount");
                    String str2 = (String) y.get(".sysmsg.emotionstore.freecount");
                    String str3 = (String) y.get(".sysmsg.emotionstore.thumburl");
                    if (bh.ov(a)) {
                        i = 0;
                    } else {
                        i = Integer.valueOf(a).intValue();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        i2 = 0;
                    } else {
                        i2 = Integer.valueOf(str2).intValue();
                    }
                    a aVar2 = new a(this, i, i2, str3, str);
                    if (bh.ov(str)) {
                        a(aVar2);
                    } else {
                        x.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[]{str});
                        ar.CG().a(new k(str, aVar2), 0);
                    }
                    a = (String) y.get(".sysmsg.personalemotion.newcount");
                    if (!bh.ov(a) && Integer.valueOf(a).intValue() > 0) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.xnn, Boolean.valueOf(true));
                    }
                    a = (String) y.get(".sysmsg.personalemoji.emojicount");
                    if (!bh.ov(a) && Integer.valueOf(a).intValue() > 0) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.xnq, Boolean.valueOf(true));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[]{bh.i(e)});
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(bwVar.ngq)});
    }

    public static void a(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
            return;
        }
        if (aVar.lzm > 0) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(208899, Boolean.valueOf(true));
            com.tencent.mm.s.c.Bq().o(262147, true);
        }
        if (aVar.lzn > 0) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(208913, Boolean.valueOf(true));
            com.tencent.mm.s.c.Bq().o(262149, true);
        }
        if (bh.ov(aVar.thumburl)) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(229633, "");
            ar.Hg();
            com.tencent.mm.z.c.CU().set(229634, "");
            return;
        }
        x.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[]{aVar.thumburl});
        ar.Hg();
        com.tencent.mm.z.c.CU().set(229633, aVar.thumburl);
        ar.Hg();
        com.tencent.mm.z.c.CU().set(229634, System.currentTimeMillis());
    }
}
