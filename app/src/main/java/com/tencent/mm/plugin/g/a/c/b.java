package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.g.a.c.c.c;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public BluetoothDevice kxd;
    public long kzS;
    public c$a kzT = null;
    public com.tencent.mm.plugin.g.a.c.c.b kzU = null;
    public c kzV = null;
    public long mSessionId;
    public int mState = 0;

    public b(long j) {
        this.kzS = j;
        this.mSessionId = j;
        this.kxd = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.bM(j));
    }

    public final void disconnect() {
        x.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
        this.mState = 0;
        if (this.kzT != null) {
            this.kzT.disconnect();
            this.kzT = null;
        }
        if (this.kzU != null) {
            this.kzU.cancel();
            e.Q(this.kzU);
            this.kzU = null;
        }
        if (this.kzV != null) {
            this.kzV.cancel();
            e.Q(this.kzU);
            this.kzV = null;
        }
    }
}
