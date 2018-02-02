package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.h;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;

public final class i {
    static a Aqc = ((a) h.a(c.AqB).excute("STR_CMD_GET_UPDATER", null));

    public static void iP(Context context) {
        e.cIS();
        if (Aqc != null) {
            Aqc.iP(context);
        } else {
            Log.e("WCWebUpdater", "no sWebviewUpdater");
        }
    }

    public static boolean isBusy() {
        if (Aqc != null) {
            return Aqc.isBusy();
        }
        Log.e("WCWebUpdater", "check is busy : no sWebviewUpdater");
        return false;
    }
}
