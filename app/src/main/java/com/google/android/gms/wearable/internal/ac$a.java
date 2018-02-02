package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.n.a;
import java.util.List;

public class ac$a implements a {
    private final Status bcR;
    private final List<m> beS;

    public ac$a(Status status, List<m> list) {
        this.bcR = status;
        this.beS = list;
    }

    public final Status og() {
        return this.bcR;
    }

    public final List<m> rs() {
        return this.beS;
    }
}
