package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

public class aj$a {
    public Bundle msB = null;
    final /* synthetic */ aj tsT;

    public aj$a(aj ajVar, Bundle bundle) {
        this.tsT = ajVar;
        this.msB = bundle;
    }

    public final void putValue(String str, Object obj) {
        if (this.msB == null) {
            return;
        }
        if (obj instanceof String) {
            this.msB.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            this.msB.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            this.msB.putInt(str, ((Integer) obj).intValue());
        } else {
            x.w("MicroMsg.WebviewReporter", "put unknow type value.");
        }
    }
}
