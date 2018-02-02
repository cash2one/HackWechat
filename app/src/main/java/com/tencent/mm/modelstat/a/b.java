package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static Bundle mO(String str) {
        x.v("MicroMsg.WebViewMMReportUtil", "create webview bundle name[%s]", new Object[]{str});
        Bundle bundle = new Bundle();
        bundle.putString("mm_event_class", str);
        return bundle;
    }
}
