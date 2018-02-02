package com.tencent.mm.plugin.aj;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

class e$5 implements ValueCallback<String> {
    final /* synthetic */ e tjF;
    final /* synthetic */ MMWebView tjH;

    e$5(e eVar, MMWebView mMWebView) {
        this.tjF = eVar;
        this.tjH = mMWebView;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        x.i(this.tjF.TAG, "loadJS, sys:bridged callback %s,view %s", new Object[]{str, this.tjH.toString()});
    }
}
