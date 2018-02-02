package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.webview.wepkg.model.c;
import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class WepkgProcessPreloadService extends Service {
    private static Messenger jaH = new Messenger(tMu);
    private static ServiceConnection jaK;
    private static final Handler mHandler = new Handler(d.Dm().oAt.getLooper()) {
        public final void handleMessage(Message message) {
            try {
                Messenger messenger = message.replyTo;
                Message obtain = Message.obtain();
                obtain.what = message.what;
                Bundle data = message.getData();
                switch (data.getInt("call_cmd_type")) {
                    case 0:
                        WepkgProcessPreloadService.a(data.getString("call_raw_url"), messenger, obtain);
                        return;
                    case 1:
                        WepkgProcessPreloadService.b(data.getString("call_pkg_id"), messenger, obtain);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    };
    private static Messenger mim;
    private static final LinkedList<Message> tMr = new LinkedList();
    private static f<Integer, c> tMt = new f(10);
    private static final Handler tMu = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            c cVar = (c) WepkgProcessPreloadService.tMt.remove(Integer.valueOf(message.what));
            if (cVar != null) {
                cVar.r(message);
                return;
            }
            x.e("MicroMsg.Wepkg.WepkgProcessPreloadService", "receive client msg, get null task by id %s", new Object[]{Integer.valueOf(r1)});
        }
    };
    private static final Messenger tMv = new Messenger(mHandler);

    static /* synthetic */ void a(String str, Messenger messenger, Message message) {
        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "preload entrance url:%s", new Object[]{str});
        if (WepkgMainProcessService.agP()) {
            x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "preload wepkg");
            g.Qd(str);
            a(messenger, message);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "prestart WepkgMainProcessService and preload wepkg");
        d.a(str, new 4(messenger, message));
    }

    static /* synthetic */ void ajM() {
        if (mim != null) {
            synchronized (tMr) {
                Iterator it = tMr.iterator();
                while (it.hasNext()) {
                    q((Message) it.next());
                }
                tMr.clear();
            }
        }
    }

    static /* synthetic */ void b(String str, Messenger messenger, Message message) {
        String str2 = "";
        if (!(b.tNV.Qn(str) == null || b.tNV.Qn(str).tMS == null)) {
            str2 = b.tNV.Qn(str).tMS.version;
        }
        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "pkgid:%s used_version:%s", new Object[]{str, str2});
        Bundle data = message.getData();
        data.putString("used_wepkg_version", str2);
        message.setData(data);
        a(messenger, message);
    }

    private static final void a(Messenger messenger, Message message) {
        if (messenger != null) {
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                x.e("MicroMsg.Wepkg.WepkgProcessPreloadService", "messenger callback err:%s", new Object[]{e.getMessage()});
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return tMv.getBinder();
    }

    public static synchronized void a(c cVar, Bundle bundle) {
        synchronized (WepkgProcessPreloadService.class) {
            tMt.put(Integer.valueOf(cVar.hashCode()), cVar);
            Message obtain = Message.obtain();
            obtain.what = cVar.hashCode();
            obtain.setData(bundle);
            q(obtain);
        }
    }

    private static void q(Message message) {
        message.replyTo = jaH;
        if (mim == null) {
            if (jaK == null) {
                jaK = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        WepkgProcessPreloadService.mim = new Messenger(iBinder);
                        WepkgProcessPreloadService.ajM();
                        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "onServiceConnected(%s)", new Object[]{ac.Br()});
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        WepkgProcessPreloadService.mim = null;
                        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "onServiceDisconnected(%s)", new Object[]{ac.Br()});
                    }
                };
            }
            x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "try bind WepkgProcessPreloadService");
            Context context = ac.getContext();
            context.bindService(new Intent(context, WepkgProcessPreloadService.class), jaK, 1);
            synchronized (tMr) {
                tMr.add(message);
            }
            return;
        }
        try {
            mim.send(message);
        } catch (RemoteException e) {
            x.e("MicroMsg.Wepkg.WepkgProcessPreloadService", e.getMessage());
        }
    }
}
