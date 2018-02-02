package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.c.d;
import com.google.android.gms.wearable.internal.an.e;

class bg$4 extends aw<d> {
    final /* synthetic */ bg bfu;
    final /* synthetic */ Asset bfw;

    bg$4(bg bgVar, c cVar, Asset asset) {
        this.bfu = bgVar;
        this.bfw = asset;
        super(cVar);
    }

    protected final /* synthetic */ g b(Status status) {
        return new bg.c(status, null);
    }

    protected final /* synthetic */ void b(b bVar) {
        ao aoVar = (ao) bVar;
        ((x) aoVar.oK()).a(new e(this), this.bfw);
    }
}
