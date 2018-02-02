package com.google.android.exoplayer2.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.t;

class q$1 implements l<String> {
    q$1() {
    }

    public final /* synthetic */ boolean X(Object obj) {
        String ai = t.ai((String) obj);
        return (TextUtils.isEmpty(ai) || ((ai.contains("text") && !ai.contains("text/vtt")) || ai.contains("html") || ai.contains("xml"))) ? false : true;
    }
}
