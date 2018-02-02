package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.pluginsdk.ui.tools.i$a;

class ReadMailProxy$2 implements i$a {
    final /* synthetic */ ReadMailProxy pqi;

    ReadMailProxy$2(ReadMailProxy readMailProxy) {
        this.pqi = readMailProxy;
    }

    public final void vb(int i) {
        this.pqi.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[]{Integer.valueOf(i)});
    }

    public final void bkx() {
        this.pqi.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
    }
}
