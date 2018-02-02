package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.ipc.c.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService extends Service {
    private static c jaJ;
    private static ServiceConnection jaK;
    private static final LinkedList<Parcel> jaL = new LinkedList();
    private static Map<String, WeakReference<MainProcessTask>> jaM = new ConcurrentHashMap();
    private static Handler jaN = new 3();
    private static Messenger jaO = new Messenger(jaN);
    private static final Set<a> jaP = Collections.newSetFromMap(new ConcurrentHashMap());
    private final HashMap<String, DeathRecipient> jaG = new HashMap();
    private final Messenger jaH = new Messenger(this.mHandler);
    private final a jaI = new 2(this);
    private final Handler mHandler = new 1(this, c.Dm().oAt.getLooper());

    static /* synthetic */ void afc() {
        if (jaJ != null) {
            synchronized (jaL) {
                Iterator it = jaL.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    Bundle bundle = new Bundle();
                    bundle.setClassLoader(MainProcessTask.class.getClassLoader());
                    parcel.setDataPosition(0);
                    bundle.readFromParcel(parcel);
                    r(bundle);
                    parcel.recycle();
                }
                jaL.clear();
            }
        }
    }

    static /* synthetic */ void pK(String str) {
        for (a onDisconnected : jaP) {
            onDisconnected.onDisconnected(str);
        }
    }

    static /* synthetic */ void rW(String str) {
        for (a YH : jaP) {
            YH.YH();
        }
    }

    static /* synthetic */ MainProcessTask rX(String str) {
        if (jaM.containsKey(str)) {
            return ((WeakReference) jaM.get(str)).get() == null ? null : (MainProcessTask) ((WeakReference) jaM.get(str)).get();
        } else {
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.jaI;
    }

    public static void a(MainProcessTask mainProcessTask) {
        jaM.put(mainProcessTask.jbo, new WeakReference(mainProcessTask));
        r(a(mainProcessTask, true));
    }

    public static boolean b(MainProcessTask mainProcessTask) {
        Bundle a = a(mainProcessTask, false);
        if (!q(a)) {
            return false;
        }
        a(a(a, false), mainProcessTask);
        mainProcessTask.Ys();
        return true;
    }

    private static boolean q(Bundle bundle) {
        try {
            jaJ.t(bundle);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void r(Bundle bundle) {
        if (jaJ == null) {
            afb();
            synchronized (jaL) {
                LinkedList linkedList = jaL;
                Parcel obtain = Parcel.obtain();
                bundle.writeToParcel(obtain, 0);
                linkedList.add(obtain);
            }
            return;
        }
        try {
            jaJ.s(bundle);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
        }
    }

    public static void afb() {
        if (jaK == null) {
            jaK = new 4();
        }
        x.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
        Context context = ac.getContext();
        context.bindService(new Intent(context, AppBrandMainProcessService.class), jaK, 1);
    }

    public static void a(a aVar) {
        jaP.add(aVar);
    }

    public static void b(a aVar) {
        jaP.remove(aVar);
    }

    private static void a(MainProcessTask mainProcessTask, MainProcessTask mainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        mainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        mainProcessTask2.f(obtain);
        obtain.recycle();
    }

    static Bundle a(MainProcessTask mainProcessTask, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", mainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", jaO);
        }
        bundle.putString("task_id", mainProcessTask.jbo);
        return bundle;
    }

    private static MainProcessTask a(Bundle bundle, boolean z) {
        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
        MainProcessTask mainProcessTask = (MainProcessTask) bundle.getParcelable("task_object");
        if (z) {
            mainProcessTask.jbC = (Messenger) bundle.getParcelable("task_client");
        }
        mainProcessTask.jbo = bundle.getString("task_id");
        return mainProcessTask;
    }
}
