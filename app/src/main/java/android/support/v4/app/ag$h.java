package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.ag.g;
import android.support.v4.app.ag.i;
import android.support.v4.app.s.a;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ag$h implements ServiceConnection, Callback {
    private final Context mContext;
    final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map<ComponentName, a> tf = new HashMap();
    private Set<String> tg = new HashSet();

    public ag$h(Context context) {
        this.mContext = context;
        this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
    }

    public final boolean handleMessage(Message message) {
        a aVar;
        switch (message.what) {
            case 0:
                Iterator it;
                i iVar = (i) message.obj;
                Set k = ag.k(this.mContext);
                if (!k.equals(this.tg)) {
                    this.tg = k;
                    List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                    Set<ComponentName> hashSet = new HashSet();
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (k.contains(resolveInfo.serviceInfo.packageName)) {
                            ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                            if (resolveInfo.serviceInfo.permission != null) {
                                new StringBuilder("Permission present on component ").append(componentName).append(", not adding listener record.");
                            } else {
                                hashSet.add(componentName);
                            }
                        }
                    }
                    for (ComponentName componentName2 : hashSet) {
                        if (!this.tf.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                new StringBuilder("Adding listener record for ").append(componentName2);
                            }
                            this.tf.put(componentName2, new a(componentName2));
                        }
                    }
                    it = this.tf.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        if (!hashSet.contains(entry.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                new StringBuilder("Removing listener record for ").append(entry.getKey());
                            }
                            a((a) entry.getValue());
                            it.remove();
                        }
                    }
                }
                for (a aVar2 : this.tf.values()) {
                    aVar2.tj.add(iVar);
                    c(aVar2);
                }
                return true;
            case 1:
                g gVar = (g) message.obj;
                ComponentName componentName3 = gVar.td;
                IBinder iBinder = gVar.te;
                aVar = (a) this.tf.get(componentName3);
                if (aVar != null) {
                    aVar.ti = a.a(iBinder);
                    aVar.retryCount = 0;
                    c(aVar);
                }
                return true;
            case 2:
                aVar = (a) this.tf.get((ComponentName) message.obj);
                if (aVar != null) {
                    a(aVar);
                }
                return true;
            case 3:
                aVar = (a) this.tf.get((ComponentName) message.obj);
                if (aVar != null) {
                    c(aVar);
                }
                return true;
            default:
                return false;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Connected to service ").append(componentName);
        }
        this.mHandler.obtainMessage(1, new g(componentName, iBinder)).sendToTarget();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Disconnected from service ").append(componentName);
        }
        this.mHandler.obtainMessage(2, componentName).sendToTarget();
    }

    private void a(a aVar) {
        if (aVar.th) {
            this.mContext.unbindService(this);
            aVar.th = false;
        }
        aVar.ti = null;
    }

    private void b(a aVar) {
        if (!this.mHandler.hasMessages(3, aVar.td)) {
            aVar.retryCount++;
            if (aVar.retryCount > 6) {
                new StringBuilder("Giving up on delivering ").append(aVar.tj.size()).append(" tasks to ").append(aVar.td).append(" after ").append(aVar.retryCount).append(" retries");
                aVar.tj.clear();
                return;
            }
            int i = (1 << (aVar.retryCount - 1)) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Scheduling retry for ").append(i).append(" ms");
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, aVar.td), (long) i);
        }
    }

    private void c(a aVar) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Processing component ").append(aVar.td).append(", ").append(aVar.tj.size()).append(" queued tasks");
        }
        if (!aVar.tj.isEmpty()) {
            boolean z;
            if (aVar.th) {
                z = true;
            } else {
                aVar.th = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.td), this, ag.bl());
                if (aVar.th) {
                    aVar.retryCount = 0;
                } else {
                    new StringBuilder("Unable to bind to listener ").append(aVar.td);
                    this.mContext.unbindService(this);
                }
                z = aVar.th;
            }
            if (!z || aVar.ti == null) {
                b(aVar);
                return;
            }
            while (true) {
                i iVar = (i) aVar.tj.peek();
                if (iVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        new StringBuilder("Sending task ").append(iVar);
                    }
                    iVar.a(aVar.ti);
                    aVar.tj.remove();
                } catch (DeadObjectException e) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        new StringBuilder("Remote service has died: ").append(aVar.td);
                    }
                } catch (RemoteException e2) {
                    new StringBuilder("RemoteException communicating with ").append(aVar.td);
                }
            }
            if (!aVar.tj.isEmpty()) {
                b(aVar);
            }
        }
    }
}
