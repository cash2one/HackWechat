package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.plugin.traceroute.b.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map.Entry;
import java.util.Set;

class a$j implements Runnable {
    final /* synthetic */ a seZ;

    private a$j(a aVar) {
        this.seZ = aVar;
    }

    public final void run() {
        long Wp;
        this.seZ.iZ(false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long Wp2 = bh.Wp();
        x.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + simpleDateFormat.format(new Date(Wp2)));
        for (Entry entry : this.seZ.seT.entrySet()) {
            Runnable iVar = new i(this.seZ, (String) entry.getKey());
            if (a.seP != null) {
                a.seP.execute(iVar);
            }
            iVar = new a$a(this.seZ, (String) entry.getKey(), (Set) entry.getValue());
            if (a.seP != null) {
                a.seP.execute(iVar);
            }
        }
        while (!this.seZ.bFt() && a.seP.getActiveCount() > 0) {
            x.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.seP.getActiveCount()));
            Wp = bh.Wp();
            if (Wp - Wp2 >= 120000) {
                x.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + ((Wp - Wp2) / 1000));
                this.seZ.iZ(true);
                this.seZ.stop();
                if (this.seZ.seU != null) {
                    this.seZ.seU.bFy();
                    return;
                }
                return;
            }
            try {
                Thread.sleep(500);
            } catch (Throwable e) {
                x.e("MicroMsg.MMTraceRoute", "wait for command end err: " + e.getMessage());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
            }
        }
        Wp = bh.Wp();
        x.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + simpleDateFormat.format(new java.util.Date(Wp)));
        x.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + ((Wp - Wp2) / 1000));
        if (this.seZ.seV != null && !this.seZ.bFt()) {
            this.seZ.seV.bFx();
        }
    }
}
