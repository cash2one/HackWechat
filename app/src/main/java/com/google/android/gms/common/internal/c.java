package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c$c;
import com.google.android.gms.common.api.c.b;

public final class c<T extends IInterface> extends k<T> {
    private final d<T> aNr;

    public c(Context context, Looper looper, int i, b bVar, c$c com_google_android_gms_common_api_c_c, h hVar, d dVar) {
        super(context, looper, i, hVar, bVar, com_google_android_gms_common_api_c_c);
        this.aNr = dVar;
    }

    protected final T f(IBinder iBinder) {
        return this.aNr.nZ();
    }

    protected final String nX() {
        return this.aNr.nX();
    }

    protected final String nY() {
        return this.aNr.nY();
    }
}
