package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.internal.ao.2;
import java.util.concurrent.FutureTask;

class ChannelImpl$1 extends aw<Status> {
    final /* synthetic */ Uri bep;
    final /* synthetic */ boolean beq = false;
    final /* synthetic */ ChannelImpl ber;

    ChannelImpl$1(ChannelImpl channelImpl, c cVar, Uri uri, boolean z) {
        this.ber = channelImpl;
        this.bep = uri;
        super(cVar);
    }

    public final /* synthetic */ g b(Status status) {
        return status;
    }

    protected final /* synthetic */ void b(b bVar) {
        ao aoVar = (ao) bVar;
        String a = ChannelImpl.a(this.ber);
        Uri uri = this.bep;
        boolean z = this.beq;
        try {
            w.ag(this);
            w.ag(a);
            w.ag(uri);
            aoVar.beV.submit(new FutureTask(new 2(aoVar, uri, this, z, a), null));
        } catch (RuntimeException e) {
            c(new Status(8));
            throw e;
        }
    }
}
