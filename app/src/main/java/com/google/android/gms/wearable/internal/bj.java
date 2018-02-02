package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.g;

public final class bj implements g {
    private final String aEO;
    private final String aXw;

    public bj(g gVar) {
        this.aEO = gVar.getId();
        this.aXw = gVar.rr();
    }

    public final String getId() {
        return this.aEO;
    }

    public final /* synthetic */ Object oy() {
        return this;
    }

    public final String rr() {
        return this.aXw;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.aEO == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.aEO);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.aXw);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
