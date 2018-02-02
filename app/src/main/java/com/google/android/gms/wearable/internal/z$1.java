package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.internal.an.h;
import com.google.android.gms.wearable.k.b;

class z$1 extends aw<b> {
    final /* synthetic */ String beN;
    final /* synthetic */ String beO;
    final /* synthetic */ byte[] beP;
    final /* synthetic */ z beQ;

    z$1(z zVar, c cVar, String str, String str2, byte[] bArr) {
        this.beQ = zVar;
        this.beN = str;
        this.beO = str2;
        this.beP = bArr;
        super(cVar);
    }

    protected final /* synthetic */ g b(Status status) {
        return new z$a(status, -1);
    }

    protected final /* synthetic */ void b(a.b bVar) {
        ao aoVar = (ao) bVar;
        ((x) aoVar.oK()).a(new h(this), this.beN, this.beO, this.beP);
    }
}
