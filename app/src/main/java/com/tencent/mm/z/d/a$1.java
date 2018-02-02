package com.tencent.mm.z.d;

import android.os.Message;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.af.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.d.a.a;
import java.util.Date;

class a$1 implements b {
    final /* synthetic */ a hiZ;

    public a$1(a aVar) {
        this.hiZ = aVar;
    }

    public final void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f) {
        if (thread != null) {
            long id = thread.getId();
            String str = null;
            if (j > a.a(this.hiZ)) {
                if (message != null) {
                    str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                } else if (runnable != null) {
                    str = "|HMonitor run task|" + af.dump(runnable, true);
                }
            } else if (j > a.b(this.hiZ) && id == a.IL()) {
                if (message != null) {
                    str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                } else if (runnable != null) {
                    str = "|HMonitor run task|" + af.dump(runnable, true);
                }
            }
            if (ar.Dm().oAt.getLooper() == null) {
                x.w("MicroMsg.HandlerTraceManager", "worker thread's looper is dead");
                return;
            }
            long id2 = ar.Dm().oAt.getLooper().getThread().getId();
            if (runnable != null && j > a.c(this.hiZ) && id == id2) {
                a aVar = new a();
                aVar.hjb = j;
                aVar.info = af.dump(runnable, false);
                if (a.d(this.hiZ).size() >= a.e(this.hiZ)) {
                    a.d(this.hiZ).pop();
                }
                a.d(this.hiZ).add(aVar);
            }
            if (runnable != null && id == id2 && f > 0.0f && f <= 100.0f) {
                Long[] f2;
                if (f < 30.0f) {
                    f2 = a.f(this.hiZ);
                    int i = (int) (f / 2.0f);
                    f2[i] = Long.valueOf(f2[i].longValue() + 1);
                } else if (f < 40.0f) {
                    f2 = a.f(this.hiZ);
                    f2[15] = Long.valueOf(f2[15].longValue() + 1);
                } else if (f < 50.0f) {
                    f2 = a.f(this.hiZ);
                    f2[16] = Long.valueOf(f2[16].longValue() + 1);
                } else {
                    f2 = a.f(this.hiZ);
                    f2[17] = Long.valueOf(f2[17].longValue() + 1);
                }
            }
            if (System.currentTimeMillis() - a.g(this.hiZ) > ((long) a.h(this.hiZ))) {
                a.a(this.hiZ, System.currentTimeMillis());
                for (int i2 = 0; i2 < 18; i2++) {
                    if (a.f(this.hiZ)[i2].longValue() > 0) {
                        g.pQN.a(230, (long) i2, a.f(this.hiZ)[i2].longValue(), false);
                    }
                }
            }
            if (str != null) {
                if (!com.tencent.mm.sdk.a.b.foreground) {
                    x.i("MicroMsg.HandlerTraceManager", str);
                }
                if (!a.i(this.hiZ)) {
                    a.a(this.hiZ, a.IM().format(new Date()) + str + "\n");
                }
            }
        }
    }
}
