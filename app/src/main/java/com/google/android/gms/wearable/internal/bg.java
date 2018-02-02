package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.e;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.c$d;
import com.google.android.gms.wearable.c.a;
import com.google.android.gms.wearable.h;

public final class bg implements c {
    public final e<h> a(com.google.android.gms.common.api.c cVar) {
        return cVar.a(new 2(this, cVar));
    }

    public final e<c$d> a(com.google.android.gms.common.api.c cVar, Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.bdh == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.bdg == null) {
            return cVar.a(new 4(this, cVar, asset));
        } else {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public final e<a> a(com.google.android.gms.common.api.c cVar, PutDataRequest putDataRequest) {
        return cVar.a(new 1(this, cVar, putDataRequest));
    }

    public final e<c.c> b(com.google.android.gms.common.api.c cVar, Uri uri) {
        return cVar.a(new 3(this, cVar, uri, 0));
    }
}
