package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.i.a;

public final class e$a {
    final e afB;
    final Handler handler;

    public e$a(Handler handler, e eVar) {
        this.handler = eVar != null ? (Handler) a.Y(handler) : null;
        this.afB = eVar;
    }

    public final void e(d dVar) {
        if (this.afB != null) {
            this.handler.post(new 5(this, dVar));
        }
    }
}
