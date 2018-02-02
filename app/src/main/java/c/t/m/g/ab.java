package c.t.m.g;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class ab {
    private static ab a = new ab();
    private Timer b = new Timer("ConnectionTimer", true);
    private Map<Runnable, TimerTask> c = new ConcurrentHashMap();

    private ab() {
    }

    public static ab a() {
        return a;
    }

    public final void a(Runnable runnable, boolean z, long j) {
        synchronized (runnable) {
            a(runnable);
            TimerTask acVar = new ac(runnable);
            if (z) {
                this.b.schedule(acVar, j, j);
            } else {
                this.b.schedule(acVar, j);
            }
            this.c.put(runnable, acVar);
        }
    }

    public final boolean a(Runnable runnable) {
        synchronized (runnable) {
            TimerTask timerTask = (TimerTask) this.c.get(runnable);
            if (timerTask != null) {
                this.c.remove(runnable);
                boolean cancel = timerTask.cancel();
                return cancel;
            }
            return true;
        }
    }
}
