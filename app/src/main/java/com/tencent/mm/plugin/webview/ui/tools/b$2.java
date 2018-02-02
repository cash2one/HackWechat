package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.h;
import java.util.List;

class b$2 implements OnClickListener {
    final /* synthetic */ String twA;
    final /* synthetic */ b twB;

    b$2(b bVar, String str) {
        this.twB = bVar;
        this.twA = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        List<h> list = (List) this.twB.twy.get(this.twA);
        if (list == null) {
            x.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
            return;
        }
        this.twB.twz.put(this.twA, Boolean.valueOf(false));
        x.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", new Object[]{Integer.valueOf(list.size())});
        for (h cancel : list) {
            cancel.cancel();
        }
        list.clear();
        this.twB.twx.clearSslPreferences();
    }
}
