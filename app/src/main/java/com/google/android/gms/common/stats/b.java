package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.c.aa;
import com.google.android.gms.c.u;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.stats.c.a;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b {
    private static final Object aOw = new Object();
    private static b aPI;
    private static final ComponentName aPN = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
    private static Integer aPP;
    private final List<String> aPJ;
    private final List<String> aPK;
    private final List<String> aPL;
    private final List<String> aPM;
    private e aPO;

    private b() {
        if (getLogLevel() == d.LOG_LEVEL_OFF) {
            this.aPJ = Collections.EMPTY_LIST;
            this.aPK = Collections.EMPTY_LIST;
            this.aPL = Collections.EMPTY_LIST;
            this.aPM = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) a.aPS.get();
        this.aPJ = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aPT.get();
        this.aPK = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aPU.get();
        this.aPL = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aPV.get();
        this.aPM = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.aPO = new e(((Long) a.aPW.get()).longValue());
    }

    private static ServiceInfo c(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, FileUtils.S_IWUSR);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), aa.dt(20)});
            return null;
        }
        if (queryIntentServices.size() > 1) {
            String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), aa.dt(20)});
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                String str = ((ResolveInfo) it.next()).serviceInfo.name;
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    private static int getLogLevel() {
        if (aPP == null) {
            try {
                aPP = Integer.valueOf(u.pG() ? ((Integer) a.aPR.get()).intValue() : d.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                aPP = Integer.valueOf(d.LOG_LEVEL_OFF);
            }
        }
        return aPP.intValue();
    }

    public static b pi() {
        synchronized (aOw) {
            if (aPI == null) {
                aPI = new b();
            }
        }
        return aPI;
    }

    public final void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        a(context, serviceConnection, null, null, 1);
    }

    public final void a(Context context, ServiceConnection serviceConnection, String str, Intent intent, int i) {
        if (f.aNs) {
            Object obj;
            String valueOf = String.valueOf((Process.myPid() << 32) | System.identityHashCode(serviceConnection));
            int logLevel = getLogLevel();
            if (logLevel == d.LOG_LEVEL_OFF || this.aPO == null) {
                obj = null;
            } else if (i == 4 || i == 1) {
                obj = this.aPO.aR(valueOf) ? 1 : null;
            } else {
                ServiceInfo c = c(context, intent);
                if (c == null) {
                    String.format("Client %s made an invalid request %s", new Object[]{str, intent.toUri(0)});
                    obj = null;
                } else {
                    String Q = aa.Q(context);
                    String str2 = c.processName;
                    String str3 = c.name;
                    if (this.aPJ.contains(Q) || this.aPK.contains(str) || this.aPL.contains(str2) || this.aPM.contains(str3) || (str2.equals(Q) && (logLevel & d.aQb) != 0)) {
                        obj = null;
                    } else {
                        this.aPO.aQ(valueOf);
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                Parcelable connectionEvent;
                long currentTimeMillis = System.currentTimeMillis();
                String str4 = null;
                if ((getLogLevel() & d.aQa) != 0) {
                    str4 = aa.dt(5);
                }
                long j = 0;
                if ((getLogLevel() & d.aQc) != 0) {
                    j = Debug.getNativeHeapAllocatedSize();
                }
                if (i == 1 || i == 4) {
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str4, valueOf, SystemClock.elapsedRealtime(), j);
                } else {
                    ServiceInfo c2 = c(context, intent);
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, aa.Q(context), str, c2.processName, c2.name, str4, valueOf, SystemClock.elapsedRealtime(), j);
                }
                context.startService(new Intent().setComponent(aPN).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
            }
        }
    }

    public final boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        boolean g = (component == null || (f.aNs && "com.google.android.gms".equals(component.getPackageName()))) ? false : u.g(context, component.getPackageName());
        if (g) {
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            a(context, serviceConnection, str, intent, 2);
        }
        return bindService;
    }
}
