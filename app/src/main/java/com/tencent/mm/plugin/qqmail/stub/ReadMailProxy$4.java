package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.plugin.qqmail.b.p$a;
import java.util.Map;

class ReadMailProxy$4 extends p$a {
    final /* synthetic */ ReadMailProxy pqi;

    ReadMailProxy$4(ReadMailProxy readMailProxy) {
        this.pqi = readMailProxy;
    }

    public final boolean onReady() {
        return ((Boolean) this.pqi.CLIENT_CALL("onReady", new Object[0])).booleanValue();
    }

    public final void onSuccess(String str, Map<String, String> map) {
        this.pqi.CLIENT_CALL("onSuccess", new Object[]{str, map});
    }

    public final void onError(int i, String str) {
        this.pqi.CLIENT_CALL("onError", new Object[]{Integer.valueOf(i), str});
    }

    public final void onComplete() {
        this.pqi.CLIENT_CALL("onComplete", new Object[0]);
    }
}
