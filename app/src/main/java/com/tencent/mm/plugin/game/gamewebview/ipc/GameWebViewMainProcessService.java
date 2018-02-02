package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.b.a;
import com.tencent.mm.plugin.game.gamewebview.model.e;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GameWebViewMainProcessService extends Service {
    private static ServiceConnection jaK;
    private static final LinkedList<Parcel> jaL = new LinkedList();
    private static Map<String, WeakReference<GWMainProcessTask>> jaM = new ConcurrentHashMap();
    private static Handler jaN = new 3();
    private static Messenger jaO = new Messenger(jaN);
    private static b mVX;
    private static Set<Object> mVY = new HashSet();
    private final Messenger jaH = new Messenger(this.mHandler);
    private final Handler mHandler = new 1(this, d.Dm().oAt.getLooper());
    private com.tencent.mm.plugin.game.gamewebview.model.d mVU;
    private e mVV;
    private final a mVW = new 2(this);

    static /* synthetic */ GWMainProcessTask BE(String str) {
        if (jaM.containsKey(str)) {
            return ((WeakReference) jaM.get(str)).get() == null ? null : (GWMainProcessTask) ((WeakReference) jaM.get(str)).get();
        } else {
            return null;
        }
    }

    static /* synthetic */ void aOF() {
        if (mVX != null) {
            synchronized (jaL) {
                Iterator it = jaL.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    Bundle bundle = new Bundle();
                    bundle.setClassLoader(GWMainProcessTask.class.getClassLoader());
                    parcel.setDataPosition(0);
                    bundle.readFromParcel(parcel);
                    r(bundle);
                    parcel.recycle();
                }
                jaL.clear();
            }
        }
    }

    static /* synthetic */ void aOG() {
        Iterator it = mVY.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static /* synthetic */ void aOH() {
        Iterator it = mVY.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void onCreate() {
        x.i("MicroMsg.GameWebViewMainProcessService", "onCreate");
        super.onCreate();
        if (g.Dh().Cy()) {
            this.mVU = new com.tencent.mm.plugin.game.gamewebview.model.d();
            f.bRA().a(this.mVU);
        }
        this.mVV = new e();
        com.tencent.mm.plugin.downloader.model.f.aAd();
        c.a(this.mVV);
    }

    public void onDestroy() {
        x.i("MicroMsg.GameWebViewMainProcessService", "onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.f.aAd();
        c.b(this.mVV);
        if (ar.Hj()) {
            f.bRA().b(this.mVU);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mVW;
    }

    public static void a(GWMainProcessTask gWMainProcessTask) {
        jaM.put(gWMainProcessTask.jbo, new WeakReference(gWMainProcessTask));
        r(a(gWMainProcessTask, true));
    }

    public static boolean b(GWMainProcessTask gWMainProcessTask) {
        Bundle a = a(gWMainProcessTask, false);
        if (!q(a)) {
            return false;
        }
        a(d(a, false), gWMainProcessTask);
        gWMainProcessTask.Ys();
        return true;
    }

    private static boolean q(Bundle bundle) {
        try {
            mVX.t(bundle);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void r(Bundle bundle) {
        if (mVX == null) {
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
            mVX.s(bundle);
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMainProcessService", e.getMessage());
        }
    }

    private static void afb() {
        if (jaK == null) {
            jaK = new 4();
        }
        x.i("MicroMsg.GameWebViewMainProcessService", "tryBindService");
        Context context = ac.getContext();
        context.bindService(new Intent(context, GameWebViewMainProcessService.class), jaK, 1);
    }

    private static void a(GWMainProcessTask gWMainProcessTask, GWMainProcessTask gWMainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        gWMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        gWMainProcessTask2.f(obtain);
        obtain.recycle();
    }

    static Bundle a(GWMainProcessTask gWMainProcessTask, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", gWMainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", jaO);
        }
        bundle.putString("task_id", gWMainProcessTask.jbo);
        return bundle;
    }

    private static GWMainProcessTask d(Bundle bundle, boolean z) {
        bundle.setClassLoader(GWMainProcessTask.class.getClassLoader());
        GWMainProcessTask gWMainProcessTask = (GWMainProcessTask) bundle.getParcelable("task_object");
        if (z) {
            gWMainProcessTask.jbC = (Messenger) bundle.getParcelable("task_client");
        }
        gWMainProcessTask.jbo = bundle.getString("task_id");
        return gWMainProcessTask;
    }
}
