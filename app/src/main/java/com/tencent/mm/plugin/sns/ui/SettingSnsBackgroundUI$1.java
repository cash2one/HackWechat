package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.ui.tools.a.a;

class SettingSnsBackgroundUI$1 implements a {
    final /* synthetic */ SettingSnsBackgroundUI rwG;

    SettingSnsBackgroundUI$1(SettingSnsBackgroundUI settingSnsBackgroundUI) {
        this.rwG = settingSnsBackgroundUI;
    }

    public final String LU(String str) {
        return ae.getAccSnsTmpPath() + g.s((this.rwG.filePath + System.currentTimeMillis()).getBytes());
    }
}
