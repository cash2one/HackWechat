package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class df extends BroadcastReceiver {
    final cr a;
    boolean b;

    public df(cr crVar) {
        this.a = crVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getBooleanExtra("noConnectivity", false)) {
                    this.a.c(Integer.valueOf(-1));
                } else if (j.b(context)) {
                    this.a.c(Integer.valueOf(1));
                } else {
                    this.a.c(Integer.valueOf(0));
                }
            } catch (Exception e) {
            }
        }
    }
}
