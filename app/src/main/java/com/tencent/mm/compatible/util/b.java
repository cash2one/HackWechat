package com.tencent.mm.compatible.util;

import android.content.Context;
import com.tencent.mm.compatible.a.a;

public final class b {
    b gHk = null;
    private final String gHl = "audio_lock";
    Context mContext = null;

    public b(Context context) {
        this.mContext = context;
        a.a(8, new 1(this));
    }

    public final boolean requestFocus() {
        boolean z;
        synchronized ("audio_lock") {
            if (this.gHk == null) {
                z = false;
            } else {
                z = this.gHk.requestFocus();
            }
        }
        return z;
    }

    public final boolean zd() {
        boolean z;
        synchronized ("audio_lock") {
            if (this.gHk == null) {
                z = false;
            } else {
                z = this.gHk.zd();
            }
        }
        return z;
    }

    public final void a(a aVar) {
        if (this.gHk != null) {
            this.gHk.a(aVar);
        }
    }
}
