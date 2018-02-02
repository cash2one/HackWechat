package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ag.h.a;
import com.tencent.mm.ag.y;
import com.tencent.mm.protocal.c.cai;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.q;
import java.util.LinkedList;

class b$b implements a {
    private String tJG;
    q ysf;

    protected b$b(q qVar, String str) {
        this.tJG = str;
        this.ysf = qVar;
    }

    public final void c(LinkedList<cai> linkedList) {
        int i = 0;
        y.Mg().b((a) this);
        x.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
        if (linkedList != null && linkedList.size() > 0) {
            x.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[]{Integer.valueOf(linkedList.size()), this.tJG});
            if (this.ysf != null) {
                if (linkedList != null && linkedList.size() != 0) {
                    for (int i2 = 0; i2 < linkedList.size(); i2++) {
                        cai com_tencent_mm_protocal_c_cai = (cai) linkedList.get(i2);
                        if (!(com_tencent_mm_protocal_c_cai == null || bh.ov(com_tencent_mm_protocal_c_cai.wZT) || !com_tencent_mm_protocal_c_cai.wZT.equals(this.tJG))) {
                            x.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
                            if (!bh.ov(com_tencent_mm_protocal_c_cai.wvW)) {
                                x.i("MicroMsg.ChattingItem", "needCallback: true");
                                i = 1;
                                break;
                            }
                        }
                    }
                }
                if (i != 0) {
                    ag.y(new 1(this));
                }
            }
        }
    }

    public final String LX() {
        return this.tJG;
    }
}
