package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.f;

public final class h extends com.google.android.gms.common.data.h<f> implements g {
    private final Status bcR;

    public h(DataHolder dataHolder) {
        super(dataHolder);
        this.bcR = new Status(dataHolder.aJD);
    }

    protected final /* synthetic */ Object av(int i, int i2) {
        return new f(this.aMc, i, i2);
    }

    public final Status og() {
        return this.bcR;
    }

    protected final String oz() {
        return "path";
    }
}
