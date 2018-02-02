package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.c.c;

public class bg$b implements c {
    private final Status bcR;
    private final int bfy;

    public bg$b(Status status, int i) {
        this.bcR = status;
        this.bfy = i;
    }

    public final Status og() {
        return this.bcR;
    }
}
