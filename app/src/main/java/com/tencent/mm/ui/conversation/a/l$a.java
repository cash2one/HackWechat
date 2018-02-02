package com.tencent.mm.ui.conversation.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.List;

final class l$a implements Runnable {
    WeakReference<l> zaX;

    private l$a() {
    }

    public final void run() {
        List Ul = o.TU().Ul();
        List Um = o.TU().Um();
        l lVar = (l) this.zaX.get();
        if (lVar == null) {
            x.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
            return;
        }
        x.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[]{Integer.valueOf(lVar.mContainer.getChildCount()), Integer.valueOf(Ul.size()), Integer.valueOf(Um.size())});
        if (lVar.mContainer.getChildCount() != 0 || !Ul.isEmpty() || !Um.isEmpty()) {
            Runnable com_tencent_mm_ui_conversation_a_l_c = new l$c();
            com_tencent_mm_ui_conversation_a_l_c.zaX = new WeakReference(this.zaX.get());
            com_tencent_mm_ui_conversation_a_l_c.zbg = Ul;
            com_tencent_mm_ui_conversation_a_l_c.zbh = Um;
            ag.y(com_tencent_mm_ui_conversation_a_l_c);
        }
    }
}
