package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map.Entry;

public final class a {
    private static HashMap<Integer, GameMMToClientEvent> jbA = new HashMap();
    private static n mEF;

    static {
        n 1 = new 1();
        mEF = 1;
        ar.a(1);
    }

    public static void a(int i, GameMMToClientEvent gameMMToClientEvent) {
        jbA.put(Integer.valueOf(i), gameMMToClientEvent);
    }

    public static void qE(int i) {
        jbA.remove(Integer.valueOf(i));
    }

    public static synchronized void z(Bundle bundle) {
        synchronized (a.class) {
            x.d("MicroMsg.GameMMToClientEventCenter", "notifyToAllClint");
            for (Entry entry : jbA.entrySet()) {
                GameMMToClientEvent gameMMToClientEvent = (GameMMToClientEvent) entry.getValue();
                if (gameMMToClientEvent != null) {
                    gameMMToClientEvent.mVR = ((Integer) entry.getKey()).intValue();
                    gameMMToClientEvent.msB = bundle;
                    gameMMToClientEvent.afp();
                }
            }
        }
    }
}
