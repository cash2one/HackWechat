package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.internal.ac.a;
import com.google.android.gms.wearable.n$a;
import java.util.ArrayList;

class ac$1 extends aw<n$a> {
    final /* synthetic */ ac beR;

    ac$1(ac acVar, c cVar) {
        this.beR = acVar;
        super(cVar);
    }

    protected final /* synthetic */ g b(Status status) {
        return new a(status, new ArrayList());
    }

    protected final /* synthetic */ void b(b bVar) {
        ((x) ((ao) bVar).oK()).d(new an$c(this));
    }
}
