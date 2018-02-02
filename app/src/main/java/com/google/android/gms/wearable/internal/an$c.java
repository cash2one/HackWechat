package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.k.b;
import com.google.android.gms.wearable.internal.ac.a;
import com.google.android.gms.wearable.n$a;
import java.util.ArrayList;
import java.util.List;

final class an$c extends an$a<n$a> {
    public an$c(b<n$a> bVar) {
        super(bVar);
    }

    public final void a(GetConnectedNodesResponse getConnectedNodesResponse) {
        List arrayList = new ArrayList();
        arrayList.addAll(getConnectedNodesResponse.beC);
        ap(new a(ak.dN(getConnectedNodesResponse.statusCode), arrayList));
    }
}
