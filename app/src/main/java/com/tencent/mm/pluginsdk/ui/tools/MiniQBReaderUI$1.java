package com.tencent.mm.pluginsdk.ui.tools;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;

class MiniQBReaderUI$1 implements ValueCallback<String> {
    final /* synthetic */ MiniQBReaderUI vxK;

    MiniQBReaderUI$1(MiniQBReaderUI miniQBReaderUI) {
        this.vxK = miniQBReaderUI;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.MiniQBReaderUI", "startMiniQBToLoadUrl, onReceiveValue: %s", new Object[]{(String) obj});
        if ("fileReaderClosed".equals((String) obj)) {
            this.vxK.finish();
        }
    }
}
