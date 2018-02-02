package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import c.t.m.g.ck.b;

class ck$a extends BroadcastReceiver {
    private /* synthetic */ ck a;

    private ck$a(ck ckVar) {
        this.a = ckVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ck.d().equals(action)) {
                ch.a("CC_Receiver", "action=" + action);
                try {
                    new Thread(new b(this.a), "Th_CC").start();
                } catch (Throwable th) {
                    ch.a("CC_Receiver", "new pull runnable failed!", th);
                    ck.a(this.a);
                }
            }
        }
    }
}
