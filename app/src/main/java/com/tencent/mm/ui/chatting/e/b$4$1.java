package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.ac$a;
import com.tencent.mm.ui.chatting.e.b.4;

class b$4$1 implements ac {
    final /* synthetic */ 4 yHo;

    b$4$1(4 4) {
        this.yHo = 4;
    }

    public final void crT() {
    }

    public final void a(ac$a com_tencent_mm_ui_chatting_ac_a) {
        if (com_tencent_mm_ui_chatting_ac_a == ac$a.del) {
            b 1 = new 1(this);
            1.fqm = this.yHo.heZ.field_msgId;
            this.yHo.yHl.jRt.remove(1);
            this.yHo.yHl.yHi.remove(1);
        }
    }

    public final void b(ac$a com_tencent_mm_ui_chatting_ac_a) {
        x.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[]{Thread.currentThread(), com_tencent_mm_ui_chatting_ac_a});
        if (com_tencent_mm_ui_chatting_ac_a == ac$a.del) {
            this.yHo.yHl.yHg.UR.notifyChanged();
        }
    }

    public final boolean crU() {
        return true;
    }
}
