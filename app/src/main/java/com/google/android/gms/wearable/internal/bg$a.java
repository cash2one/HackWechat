package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.c$a;
import com.google.android.gms.wearable.f;

public class bg$a implements c$a {
    private final Status bcR;
    private final f bfx;

    public bg$a(Status status, f fVar) {
        this.bcR = status;
        this.bfx = fVar;
    }

    public final Status og() {
        return this.bcR;
    }
}
