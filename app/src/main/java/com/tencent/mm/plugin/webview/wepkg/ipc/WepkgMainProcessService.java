package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.plugin.webview.wepkg.ipc.a.a;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WepkgMainProcessService extends Service {
    private static ServiceConnection jaK;
    private static Map<Integer, WeakReference<WepkgMainProcessTask>> jaM = new ConcurrentHashMap();
    private static Handler jaN = new 3(Looper.getMainLooper());
    private static Messenger jaO = new Messenger(jaN);
    private static a tMq;
    private static final LinkedList<Message> tMr = new LinkedList();
    private final Messenger jaH = new Messenger(this.mHandler);
    private final Handler mHandler = new 1(this, d.Dm().oAt.getLooper());
    private final a tMp = new 2(this);

    static /* synthetic */ WepkgMainProcessTask Bh(int i) {
        if (jaM.containsKey(Integer.valueOf(i))) {
            return ((WeakReference) jaM.get(Integer.valueOf(i))).get() == null ? null : (WepkgMainProcessTask) ((WeakReference) jaM.get(Integer.valueOf(i))).get();
        } else {
            return null;
        }
    }

    static /* synthetic */ void aOF() {
        if (tMq != null) {
            synchronized (tMr) {
                Iterator it = tMr.iterator();
                while (it.hasNext()) {
                    q((Message) it.next());
                }
                tMr.clear();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.tMp;
    }

    public static void a(WepkgMainProcessTask wepkgMainProcessTask) {
        jaM.put(Integer.valueOf(wepkgMainProcessTask.hashCode()), new WeakReference(wepkgMainProcessTask));
        Message obtain = Message.obtain();
        obtain.what = wepkgMainProcessTask.hashCode();
        obtain.replyTo = jaO;
        obtain.setData(c(wepkgMainProcessTask));
        q(obtain);
    }

    public static boolean b(WepkgMainProcessTask wepkgMainProcessTask) {
        Bundle c = c(wepkgMainProcessTask);
        if (!q(c)) {
            return false;
        }
        a(ac(c), wepkgMainProcessTask);
        wepkgMainProcessTask.Ys();
        return true;
    }

    private static boolean q(Bundle bundle) {
        try {
            tMq.t(bundle);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void q(Message message) {
        message.replyTo = jaO;
        if (tMq == null) {
            afb();
            synchronized (tMr) {
                tMr.add(message);
            }
            return;
        }
        try {
            tMq.p(message);
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
        }
    }

    private static void afb() {
        if (jaK == null) {
            jaK = new 4();
        }
        x.i("MicroMsg.Wepkg.WepkgMainProcessService", "tryBindService");
        Context context = ac.getContext();
        context.bindService(new Intent(context, WepkgMainProcessService.class), jaK, 1);
    }

    public static boolean agP() {
        if (tMq != null) {
            return true;
        }
        return false;
    }

    static Bundle c(WepkgMainProcessTask wepkgMainProcessTask) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("task_object", wepkgMainProcessTask);
        return bundle;
    }

    private static WepkgMainProcessTask ac(Bundle bundle) {
        bundle.setClassLoader(WepkgMainProcessTask.class.getClassLoader());
        return (WepkgMainProcessTask) bundle.getParcelable("task_object");
    }

    private static void a(WepkgMainProcessTask wepkgMainProcessTask, WepkgMainProcessTask wepkgMainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        wepkgMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        wepkgMainProcessTask2.f(obtain);
        obtain.recycle();
    }
}
