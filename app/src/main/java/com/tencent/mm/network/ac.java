package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import com.tencent.mm.network.i.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ac extends a {
    private ak hkO = new ak(new ak.a(this) {
        final /* synthetic */ ac ibc;

        {
            this.ibc = r1;
        }

        public final boolean uF() {
            x.i("MicroMsg.NetworkEvent", "listeners ct : %d", Integer.valueOf(this.ibc.ibb.beginBroadcast()));
            for (int i = r0 - 1; i >= 0; i--) {
                try {
                    ((n) this.ibc.ibb.getBroadcastItem(i)).eq(this.ibc.iaY);
                } catch (Throwable e) {
                    x.e("MicroMsg.NetworkEvent", "exception:%s", bh.i(e));
                }
            }
            this.ibc.ibb.finishBroadcast();
            return false;
        }
    }, false);
    private int iaY = 4;
    private long iaZ;
    private int iba = 0;
    private final RemoteCallbackList<n> ibb = new RemoteCallbackList();

    public final int Vr() {
        x.i("MicroMsg.NetworkEvent", "getNowStatus = %d", Integer.valueOf(0 > bh.by(this.iaZ) ? 5 : this.iaY));
        return 0 > bh.by(this.iaZ) ? 5 : this.iaY;
    }

    public final boolean c(n nVar) {
        try {
            this.ibb.register(nVar);
        } catch (Throwable e) {
            x.e("MicroMsg.NetworkEvent", "addListener %s", e);
            x.e("MicroMsg.NetworkEvent", "exception:%s", bh.i(e));
        }
        return true;
    }

    public final boolean d(n nVar) {
        boolean z = false;
        try {
            z = this.ibb.unregister(nVar);
        } catch (Throwable e) {
            x.e("MicroMsg.NetworkEvent", "removeListener %s", e);
            x.e("MicroMsg.NetworkEvent", "exception:%s", bh.i(e));
        }
        return z;
    }

    public final void Vs() {
        this.ibb.kill();
    }

    public final void iT(int i) {
        int i2 = 0;
        x.i("MicroMsg.NetworkEvent", "networkChange : %d", Integer.valueOf(i));
        if (i != this.iaY) {
            if (3 != i) {
                if (2 == i) {
                    if (!(this.iaY == 0 || this.iaY == 1)) {
                        this.iba++;
                        if (this.iba > 0) {
                            this.iaY = 2;
                            i2 = 1;
                        }
                    }
                } else if (4 == i) {
                    this.iba = 0;
                    this.iaY = 4;
                    i2 = 1;
                }
                this.iaY = i;
                i2 = 1;
            } else if (this.iaY == 2) {
                this.iaY = i;
                i2 = 1;
            }
        }
        if (i2 != 0) {
            if (i == 0 || i == 6) {
                this.hkO.J(1000, 1000);
            }
        }
    }

    public final long Vt() {
        return this.iaZ;
    }
}
