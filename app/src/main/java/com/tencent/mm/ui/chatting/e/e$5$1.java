package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.ac$a;
import com.tencent.mm.ui.chatting.e.e.5;

class e$5$1 implements ac {
    final /* synthetic */ 5 yHD;

    e$5$1(5 5) {
        this.yHD = 5;
    }

    public final void crT() {
    }

    public final void a(ac$a com_tencent_mm_ui_chatting_ac_a) {
        if (com_tencent_mm_ui_chatting_ac_a == ac$a.del) {
            e.a(this.yHD.yHA).removeAll(this.yHD.juo);
        }
    }

    public final void b(ac$a com_tencent_mm_ui_chatting_ac_a) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", new Object[]{Thread.currentThread(), Integer.valueOf(this.yHD.juo.size()), com_tencent_mm_ui_chatting_ac_a});
        if (com_tencent_mm_ui_chatting_ac_a == ac$a.del) {
            e.c(this.yHD.yHA).cuj();
        }
    }

    public final boolean crU() {
        return true;
    }
}
