package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k.b;
import com.google.android.gms.wearable.internal.an.a;

final class an$i extends a<Status> {
    public an$i(b<Status> bVar) {
        super(bVar);
    }

    public final void a(ChannelReceiveFileResponse channelReceiveFileResponse) {
        ap(new Status(channelReceiveFileResponse.statusCode));
    }
}
