package com.tencent.mm.console.a.a;

import android.content.Context;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.bh;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public final boolean a(Context context, String[] strArr) {
        if (strArr.length <= 1) {
            return false;
        }
        if (bh.getInt(strArr[1], 0) > 0) {
            f.vco = true;
        } else {
            f.vco = false;
        }
        return true;
    }
}
