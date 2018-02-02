package com.tencent.wework.api;

import android.content.Context;

public class WWAPIFactory {
    public static IWWAPI iN(Context context) {
        return new WWAPIImpl(context);
    }
}
