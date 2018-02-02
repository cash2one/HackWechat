package com.tencent.mm.v;

import android.util.Log;
import org.json.JSONException;

public final class f extends JSONException {
    public f(String str) {
        super(str);
    }

    public f(Throwable th) {
        super(Log.getStackTraceString(th));
    }
}
