package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.ui.tools.a.a;

class bb$13 implements a {
    final /* synthetic */ bb rLm;

    bb$13(bb bbVar) {
        this.rLm = bbVar;
    }

    public final String LU(String str) {
        return ae.getAccSnsTmpPath() + g.s((this.rLm.filePath + System.currentTimeMillis()).getBytes());
    }
}
