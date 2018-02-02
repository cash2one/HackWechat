package c.t.m.g;

import android.os.Process;

public class al$a implements Runnable {
    private /* synthetic */ al a;

    private al$a(al alVar) {
        this.a = alVar;
    }

    public final void a(boolean z) {
        if (!z) {
            this.a.c.post(this);
        } else if (!this.a.c.postAtFrontOfQueue(this)) {
            this.a.c.post(this);
        }
    }

    public void run() {
        Process.setThreadPriority(10);
    }
}
