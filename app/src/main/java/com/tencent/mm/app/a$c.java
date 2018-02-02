package com.tencent.mm.app;

import android.os.Debug;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class a$c implements Runnable {
    int feF = 0;
    private final Runnable feG = new 1(this);

    a$c() {
    }

    public final void run() {
        g.pQN.a(510, 0, 1, true);
        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread[%s]", new Object[]{Thread.currentThread()});
        int i = -1;
        while (!r10.isInterrupted()) {
            int i2 = this.feF;
            a.tv().post(this.feG);
            try {
                Thread.sleep((long) a.tt());
                if (this.feF == i2) {
                    if (a.tx() || !Debug.isDebuggerConnected()) {
                        a$a j;
                        a.tv().removeCallbacks(this.feG);
                        long yC = (long) a.ty().yC();
                        long yD = (long) a.ty().yD();
                        long yB = (long) a.ty().yB();
                        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr CpuUsage[%d, %d, %d]", new Object[]{Long.valueOf(yC), Long.valueOf(yD), Long.valueOf(yB)});
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr wait for GetCpuUsage interrupted[%b]", new Object[]{Boolean.valueOf(r10.isInterrupted())});
                        }
                        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr new sThreadNamePrefix[%s],lastTick tick[%d, %d], current[%d]", new Object[]{a.tz(), Integer.valueOf(i2), Integer.valueOf(this.feF), Long.valueOf(System.currentTimeMillis())});
                        if (a.tz() != null) {
                            j = a$a.j(a.tz(), a.tA());
                        } else {
                            j = a$a.tG();
                        }
                        g.pQN.a(510, 1, 1, true);
                        switch (a.tB()) {
                            case 1:
                                g.pQN.a(510, 2, 1, true);
                                break;
                            case 2:
                                g.pQN.a(510, 3, 1, true);
                                break;
                            case 4:
                                g.pQN.a(510, 4, 1, true);
                                break;
                            case 8:
                                g.pQN.a(510, 5, 1, true);
                                break;
                            case 16:
                                g.pQN.a(510, 6, 1, true);
                                break;
                            case 32:
                                g.pQN.a(510, 13, 1, true);
                                break;
                        }
                        if (a.tC() > 0) {
                            g.pQN.a(510, 7, 1, true);
                        }
                        a.tD().c(j);
                        a.tE();
                        if (a.tC() >= 10) {
                            a.tF();
                        }
                        yC = ((long) ((a.em(a.tC()) * 5) * 60)) * 1000;
                        this.feF = 0;
                        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d]", new Object[]{Integer.valueOf(a.tC()), Long.valueOf(yC), Integer.valueOf(0), Integer.valueOf(this.feF)});
                        try {
                            Thread.sleep(yC);
                            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d] wakeup", new Object[]{Integer.valueOf(a.tC()), Long.valueOf(yC), Integer.valueOf(0), Integer.valueOf(this.feF)});
                        } catch (InterruptedException e2) {
                            a.tw().a(e2);
                            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted when wait for next detect[%b]", new Object[]{Boolean.valueOf(r10.isInterrupted())});
                            return;
                        }
                    }
                    if (this.feF != i) {
                        x.w("MicroMsg.ANRWatchDog.summeranr", "summeranr An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    i = this.feF;
                }
            } catch (InterruptedException e22) {
                a.tw().a(e22);
                x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted[%b]", new Object[]{Boolean.valueOf(r10.isInterrupted())});
                return;
            }
        }
        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread isInterrupted[%b]", new Object[]{Boolean.valueOf(r10.isInterrupted())});
    }
}
