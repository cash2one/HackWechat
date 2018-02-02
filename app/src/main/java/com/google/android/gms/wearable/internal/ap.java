package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.a$a;
import com.google.android.gms.wearable.b$a;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.n.c;
import com.google.android.gms.wearable.q.a;
import com.google.android.gms.wearable.r;
import java.util.List;

final class ap<T> extends w$a {
    a bfi;
    r.a bfj;
    b bfk;
    k.a bfl;
    n.b bfm;
    c bfn;
    b$a bfo;
    a$a bfp;
    final IntentFilter[] bfq;
    final String bfr;
    final String bfs;

    public final void a(DataHolder dataHolder) {
        if (this.bfk != null) {
            try {
                this.bfk.a(new e(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public final void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
    }

    public final void a(AncsNotificationParcelable ancsNotificationParcelable) {
    }

    public final void a(CapabilityInfoParcelable capabilityInfoParcelable) {
    }

    public final void a(ChannelEventParcelable channelEventParcelable) {
        if (this.bfo != null) {
            channelEventParcelable.a(this.bfo);
        }
    }

    public final void a(MessageEventParcelable messageEventParcelable) {
        if (this.bfl != null) {
            this.bfl.a(messageEventParcelable);
        }
    }

    public final void a(NodeParcelable nodeParcelable) {
        if (this.bfm != null) {
            this.bfm.a(nodeParcelable);
        }
    }

    public final void b(NodeParcelable nodeParcelable) {
        if (this.bfm != null) {
            this.bfm.b(nodeParcelable);
        }
    }

    public final void u(List<NodeParcelable> list) {
    }
}
