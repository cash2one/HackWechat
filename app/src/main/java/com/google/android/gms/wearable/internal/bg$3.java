package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.c$c;
import com.google.android.gms.wearable.internal.bg.b;

class bg$3 extends aw<c$c> {
    final /* synthetic */ Uri bep;
    final /* synthetic */ bg bfu;
    final /* synthetic */ int bfv = 0;

    bg$3(bg bgVar, c cVar, Uri uri, int i) {
        this.bfu = bgVar;
        this.bep = uri;
        super(cVar);
    }

    protected final /* synthetic */ g b(Status status) {
        return new b(status, 0);
    }

    protected final /* synthetic */ void b(a.b bVar) {
        ao aoVar = (ao) bVar;
        ((x) aoVar.oK()).b(new an.b(this), this.bep, this.bfv);
    }
}
