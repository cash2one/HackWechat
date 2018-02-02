package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.e;

public abstract class d {
    boolean AcN = false;
    public b Ada;

    abstract boolean cGg();

    abstract void cGh();

    abstract void execute();

    final synchronized void b(final e eVar) {
        if (this.AcN) {
            c.w("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
        } else {
            f cGi = f.cGi();
            String str = "Soter.SoterTaskManager";
            String str2 = "soter: removing task: %d";
            Object[] objArr = new Object[1];
            objArr[0] = this != null ? Integer.valueOf(hashCode()) : "null";
            c.i(str, str2, objArr);
            if (this == null) {
                c.e("Soter.SoterTaskManager", "soter: task is null", new Object[0]);
            } else {
                synchronized (cGi.Adl) {
                    if (f.Adk.get(hashCode()) == null) {
                        c.i("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", new Object[]{Integer.valueOf(hashCode())});
                    } else {
                        f.Adk.remove(hashCode());
                    }
                }
            }
            g.cGk().y(new Runnable(this) {
                final /* synthetic */ d Adc;

                public final void run() {
                    d dVar = this.Adc;
                    e eVar = eVar;
                    if (dVar.Ada != null && !dVar.AcN) {
                        dVar.Ada.a(eVar);
                        dVar.AcN = true;
                    }
                }
            });
        }
    }
}
