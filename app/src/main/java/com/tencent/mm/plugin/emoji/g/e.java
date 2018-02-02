package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.z.bs.a;
import java.util.List;
import java.util.Map;

public final class e implements a {
    public final void a(d.a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar.ngq == 10002) {
            String a = n.a(bwVar.vGZ);
            if (bh.ov(a)) {
                x.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
                return;
            }
            Map y = bi.y(a, "sysmsg");
            if (y != null && y.size() > 0) {
                String str = (String) y.get(".sysmsg.$type");
                if (bh.ov(str) || !str.equalsIgnoreCase("NewRecommendEmotion")) {
                    x.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                }
                List yB = d.yB(a);
                String[] strArr = new String[]{"1", EmojiGroupInfo.xzY, "7"};
                i.aBE().lwM.gJP.delete("EmojiGroupInfo", "recommand=? and type!=? and status!=?", strArr);
                com.tencent.mm.storage.emotion.a aVar2 = i.aBE().lwM;
                x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[insertRecommendEmojiGroupInfo]");
                aVar2.cT(yB);
                return;
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(bwVar.ngq)});
    }
}
