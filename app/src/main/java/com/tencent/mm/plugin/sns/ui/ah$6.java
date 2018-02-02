package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.ui.tools.a.a;

class ah$6 implements a {
    final /* synthetic */ ah rvK;

    ah$6(ah ahVar) {
        this.rvK = ahVar;
    }

    public final String LU(String str) {
        return ae.getAccSnsTmpPath() + g.s((str + System.currentTimeMillis()).getBytes());
    }
}
