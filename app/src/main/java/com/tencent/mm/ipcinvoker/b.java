package com.tencent.mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.ipcinvoker.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b implements c {
    private static volatile b gMj;
    private Map<String, Class<?>> gMk = new HashMap();
    Map<String, a> gMl = new ConcurrentHashMap();
    private volatile boolean gMm;
    private af mHandler;

    private static class a {
        com.tencent.mm.ipcinvoker.b.a gMr;
        ServiceConnection gMs;
        volatile boolean gMt;
        Runnable gMu;

        private a() {
        }
    }

    public static b Bs() {
        if (gMj == null) {
            synchronized (b.class) {
                if (gMj == null) {
                    gMj = new b();
                }
            }
        }
        return gMj;
    }

    private b() {
        HandlerThread Wf = e.Wf("IPCBridgeThread#" + hashCode());
        Wf.start();
        this.mHandler = new af(Wf.getLooper());
    }

    public final com.tencent.mm.ipcinvoker.b.a ff(final String str) {
        a aVar = (a) this.gMl.get(str);
        if (aVar == null) {
            if (this.gMm) {
                x.i("IPC.IPCBridgeManager", "build IPCBridge(process : %s) failed, locked.", new Object[]{str});
                return null;
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                x.w("IPC.IPCBridgeManager", "getIPCBridge failed, can not create bridge on Main thread.");
                return null;
            } else {
                Class cls = (Class) this.gMk.get(str);
                if (cls == null) {
                    x.w("IPC.IPCBridgeManager", "getServiceClass by '%s', got null.", new Object[]{str});
                    return null;
                }
                final a aVar2 = new a();
                synchronized (this.gMl) {
                    this.gMl.put(str, aVar2);
                }
                final Context context = e.getContext();
                ServiceConnection anonymousClass1 = new ServiceConnection(this) {
                    final /* synthetic */ b gMp;

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        if (iBinder == null) {
                            x.i("IPC.IPCBridgeManager", "onServiceConnected(%s), but service is null", new Object[]{Integer.valueOf(aVar2.hashCode())});
                            context.unbindService(this);
                            this.gMp.gMl.remove(str);
                            synchronized (aVar2) {
                                aVar2.gMs = null;
                            }
                            aVar2.gMr = null;
                        } else {
                            x.i("IPC.IPCBridgeManager", "onServiceConnected(%s)", new Object[]{Integer.valueOf(aVar2.hashCode())});
                            aVar2.gMr = com.tencent.mm.ipcinvoker.b.a.a.z(iBinder);
                        }
                        if (aVar2.gMu != null) {
                            this.gMp.mHandler.removeCallbacks(aVar2.gMu);
                        }
                        synchronized (aVar2) {
                            aVar2.gMt = false;
                            aVar2.notifyAll();
                            aVar2.gMu = null;
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        x.i("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", new Object[]{Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId())});
                        this.gMp.fg(str);
                    }
                };
                synchronized (aVar2) {
                    aVar2.gMt = true;
                    aVar2.gMs = anonymousClass1;
                }
                try {
                    x.i("IPC.IPCBridgeManager", "bindService(bw : %s, tid : %s, intent : %s)", new Object[]{Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()), new Intent(context, cls)});
                    context.bindService(r5, anonymousClass1, 33);
                    aVar2.gMu = new 2(this, aVar2, str);
                    this.mHandler.postDelayed(aVar2.gMu, Looper.myLooper() == Looper.getMainLooper() ? 3000 : 10000);
                    synchronized (aVar2) {
                        if (aVar2.gMt) {
                            aVar2.wait();
                        }
                    }
                    synchronized (aVar2) {
                        aVar2.gMt = false;
                    }
                    aVar = aVar2;
                } catch (InterruptedException e) {
                    try {
                        x.e("IPC.IPCBridgeManager", "%s", new Object[]{e});
                        synchronized (this.gMl) {
                            this.gMl.remove(str);
                            synchronized (aVar2) {
                                aVar2.gMt = false;
                                return null;
                            }
                        }
                    } catch (Throwable th) {
                        synchronized (aVar2) {
                            aVar2.gMt = false;
                        }
                    }
                } catch (Throwable e2) {
                    x.e("IPC.IPCBridgeManager", "bindService error : %s", new Object[]{Log.getStackTraceString(e2)});
                    synchronized (this.gMl) {
                        this.gMl.remove(str);
                        synchronized (aVar2) {
                            aVar2.gMt = false;
                            return null;
                        }
                    }
                }
            }
        } else if (aVar.gMt) {
            try {
                synchronized (aVar) {
                    if (aVar.gMt) {
                        aVar.wait();
                    }
                }
            } catch (InterruptedException e3) {
                x.e("IPC.IPCBridgeManager", "%s", new Object[]{e3});
            }
        }
        return aVar.gMr;
    }

    public final void fg(String str) {
        if (e.fh(str)) {
            x.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", new Object[]{str});
            return;
        }
        synchronized (this.gMl) {
            a aVar = (a) this.gMl.get(str);
        }
        if (aVar == null) {
            x.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", new Object[]{str});
            return;
        }
        if (aVar.gMt) {
            synchronized (aVar) {
                aVar.gMt = false;
                aVar.notifyAll();
            }
        }
        if (aVar.gMs == null) {
            x.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[]{str});
            return;
        }
        this.mHandler.post(new 3(this, aVar, str));
    }

    public final synchronized void Bt() {
        this.gMm = true;
    }

    public final <T extends BaseIPCService> void c(String str, Class<T> cls) {
        this.gMk.put(str, cls);
    }
}
