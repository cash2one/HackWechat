package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.u.b;

class u$a implements c {
    public final int aLT;
    public final c aLU;
    public final c aLV;
    final /* synthetic */ u aLW;

    public u$a(u uVar, int i, c cVar, c cVar2) {
        this.aLW = uVar;
        this.aLT = i;
        this.aLU = cVar;
        this.aLV = cVar2;
        cVar.a(this);
    }

    public final void a(ConnectionResult connectionResult) {
        u.e(this.aLW).post(new b(this.aLW, this.aLT, connectionResult));
    }
}
