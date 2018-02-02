package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.6;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c.a;

class SnsCommentFooter$6$1 implements a {
    final /* synthetic */ 6 rBo;

    SnsCommentFooter$6$1(6 6) {
        this.rBo = 6;
    }

    public final void uY(String str) {
        this.rBo.rBn.LK(SnsCommentFooter.a(this.rBo.rBl).getText().toString());
        SnsCommentFooter.a(this.rBo.rBl).setText("");
    }

    public final void amI() {
    }

    public final void aem() {
        h.h(SnsCommentFooter.l(this.rBo.rBl), j.qMH, j.qMI);
    }
}
