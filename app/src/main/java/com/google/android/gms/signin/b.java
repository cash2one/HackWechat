package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.signin.internal.i;
import java.util.concurrent.Executors;

public final class b {
    public static final c<i> baT = new c();
    public static final c<i> baU = new c();
    public static final a<i, e> baV = new 1();
    static final a<i, Object> baW = new a<i, Object>() {
        public final /* synthetic */ com.google.android.gms.common.api.a.b a(Context context, Looper looper, h hVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
            e eVar = e.bbc;
            return new i(context, looper, false, hVar, bVar, cVar, Executors.newSingleThreadExecutor());
        }
    };
    public static final Scope baX = new Scope("profile");
    public static final Scope baY = new Scope("email");
    public static final com.google.android.gms.common.api.a<e> baZ = new com.google.android.gms.common.api.a("SignIn.API", baV, baT);
    public static final com.google.android.gms.common.api.a<Object> bba = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", baW, baU);
    public static final c bbb = new com.google.android.gms.signin.internal.h();
}
