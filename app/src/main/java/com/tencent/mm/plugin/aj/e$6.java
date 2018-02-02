package com.tencent.mm.plugin.aj;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

class e$6 implements ValueCallback<String> {
    final /* synthetic */ e tjF;
    final /* synthetic */ MMWebView tjH;

    e$6(e eVar, MMWebView mMWebView) {
        this.tjF = eVar;
        this.tjH = mMWebView;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        x.i(this.tjF.TAG, "loadJS, sys:attach_runOn3rd_apis callback %s,view %s", new Object[]{str, this.tjH.toString()});
        this.tjF.tjC = true;
        long currentTimeMillis = System.currentTimeMillis() - this.tjF.tjE;
        g.pQN.h(15005, new Object[]{Integer.valueOf(this.tjF.tjB), Integer.valueOf(2), Long.valueOf(currentTimeMillis)});
    }
}
