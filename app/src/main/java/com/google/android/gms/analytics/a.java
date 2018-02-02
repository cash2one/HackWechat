package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends c {
    private static List<Runnable> aEH = new ArrayList();
    public boolean aEI;
    public boolean aEJ;
    private Set<Object> aEK = new HashSet();
    public boolean aEL;
    volatile boolean aEM;

    public a(q qVar) {
        super(qVar);
    }

    public static void me() {
        synchronized (a.class) {
            if (aEH != null) {
                for (Runnable run : aEH) {
                    run.run();
                }
                aEH = null;
            }
        }
    }
}
