package c.t.m.g;

import java.util.TimerTask;

final class ac extends TimerTask {
    private /* synthetic */ Runnable a;

    ac(Runnable runnable) {
        this.a = runnable;
    }

    public final void run() {
        this.a.run();
    }
}
