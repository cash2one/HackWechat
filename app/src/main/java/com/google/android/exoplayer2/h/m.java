package com.google.android.exoplayer2.h;

import android.content.Context;
import com.google.android.exoplayer2.h.f.a;

public final class m implements a {
    private final t<? super f> aAB;
    private final a aBm;
    private final Context context;

    public final /* synthetic */ f lo() {
        return new l(this.context, this.aAB, this.aBm.lo());
    }

    public m(Context context, t<? super f> tVar, a aVar) {
        this.context = context.getApplicationContext();
        this.aAB = tVar;
        this.aBm = aVar;
    }
}
