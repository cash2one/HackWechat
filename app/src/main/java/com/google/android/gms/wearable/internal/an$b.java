package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.k.b;
import com.google.android.gms.wearable.c.c;
import com.google.android.gms.wearable.internal.an.a;

final class an$b extends a<c> {
    public an$b(b<c> bVar) {
        super(bVar);
    }

    public final void a(DeleteDataItemsResponse deleteDataItemsResponse) {
        ap(new bg.b(ak.dN(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.bet));
    }
}
