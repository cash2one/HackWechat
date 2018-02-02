package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class d extends c {
    private final String TAG = "MicroMsg.emoji.EmojiListMineData";

    public d(f fVar) {
        super(fVar);
    }

    public final synchronized void notifyDataSetChanged() {
        List<EmojiGroupInfo> ckq = i.aBE().lwM.ckq();
        boolean aCY = a.aCY();
        this.mItemList = new ArrayList();
        x.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
        for (EmojiGroupInfo cjY : ckq) {
            so cjY2 = cjY.cjY();
            f fVar = new f(cjY2);
            if (a.d(cjY2) && aCY) {
                this.luJ.put(cjY2.vIR, new ak(cjY2.vIR));
            }
            fVar.eQ(9);
            this.mItemList.add(fVar);
        }
    }

    public final void clear() {
        super.clear();
    }

    public final void aAK() {
    }
}
