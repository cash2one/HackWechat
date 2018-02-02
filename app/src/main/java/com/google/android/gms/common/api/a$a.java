package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.h;
import java.util.Collections;
import java.util.List;

public abstract class a$a<T extends b, O> {
    public abstract T a(Context context, Looper looper, h hVar, O o, c.b bVar, c cVar);

    public List<Scope> nU() {
        return Collections.emptyList();
    }
}
