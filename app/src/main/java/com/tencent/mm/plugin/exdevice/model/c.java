package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.i.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c implements d {
    public static c lKv;
    private byte[] gym = new byte[0];
    private ag hOa = new ag("ExdeviceHandlerThread");
    private final Map<Integer, Set<d>> hmZ = new HashMap();
    public m lKw;
    a lKx;
    Vector<ae> lKy = new Vector();

    public final boolean a(ae aeVar) {
        this.hOa.F(new 2(this, aeVar));
        return true;
    }

    final void aDQ() {
        x.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[]{Integer.valueOf(this.lKy.size())});
        if (!this.lKy.isEmpty()) {
            a((ae) this.lKy.remove(0));
        }
    }

    public final void a(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(this.lKy.size())});
        synchronized (this.gym) {
            aDQ();
        }
    }
}
