package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.c.m;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.h.a;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class c$a {
    private Account aIz;
    public final Set<Scope> aJU = new HashSet();
    private int aJV;
    private View aJW;
    private String aJX;
    private String aJY;
    private final Map<a<?>, a> aJZ = new m();
    public final Map<a<?>, Object> aKa = new m();
    public FragmentActivity aKb;
    public int aKc = -1;
    public int aKd = -1;
    public c$c aKe;
    public Looper aKf;
    public b aKg = b.nR();
    public a.a<? extends d, e> aKh = com.google.android.gms.signin.b.baV;
    public final ArrayList<c.b> aKi = new ArrayList();
    public final ArrayList<c$c> aKj = new ArrayList();
    private e.a aKk = new e.a();
    public final Context mContext;

    public c$a(Context context) {
        this.mContext = context;
        this.aKf = context.getMainLooper();
        this.aJX = context.getPackageName();
        this.aJY = context.getClass().getName();
    }

    public final void a(u uVar, c cVar) {
        int i = this.aKc;
        c$c com_google_android_gms_common_api_c_c = this.aKe;
        w.i(cVar, "GoogleApiClient instance cannot be null");
        w.d(uVar.aLS.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        uVar.aLS.put(i, new u.a(uVar, i, cVar, com_google_android_gms_common_api_c_c));
        if (uVar.oO && !uVar.aLO) {
            cVar.connect();
        }
    }

    public final h oc() {
        return new h(this.aIz, this.aJU, this.aJZ, this.aJV, this.aJW, this.aJX, this.aJY, this.aKk.qv());
    }
}
