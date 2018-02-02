package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.h;
import com.google.android.gms.wearable.internal.an.d;

class bg$2 extends aw<h> {
    final /* synthetic */ bg bfu;

    bg$2(bg bgVar, c cVar) {
        this.bfu = bgVar;
        super(cVar);
    }

    protected final /* synthetic */ g b(Status status) {
        return new h(DataHolder.dm(status.aJD));
    }

    protected final /* synthetic */ void b(b bVar) {
        ((x) ((ao) bVar).oK()).b(new d(this));
    }
}
