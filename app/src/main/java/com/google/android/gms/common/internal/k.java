package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.l.a;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k<T extends IInterface> implements b, a {
    public static final String[] aOi = new String[]{"service_esmobile", "service_googleme"};
    private final Account aIz;
    private final h aKY;
    private final Looper aKf;
    private final com.google.android.gms.common.b aKg;
    private final Set<Scope> aKo;
    private final m aNW;
    private final Object aNX;
    private s aNY;
    private e aNZ;
    private T aOa;
    private final ArrayList<c<?>> aOb;
    private e aOc;
    private int aOd;
    private final c.b aOe;
    private final c.c aOf;
    private final int aOg;
    protected AtomicInteger aOh;
    public final Context mContext;
    final Handler mHandler;

    public k(Context context, Looper looper, int i, h hVar, c.b bVar, c.c cVar) {
        this(context, looper, m.H(context), com.google.android.gms.common.b.nR(), i, hVar, (c.b) w.ag(bVar), (c.c) w.ag(cVar));
    }

    private k(Context context, Looper looper, m mVar, com.google.android.gms.common.b bVar, int i, h hVar, c.b bVar2, c.c cVar) {
        this.aNX = new Object();
        this.aOb = new ArrayList();
        this.aOd = 1;
        this.aOh = new AtomicInteger(0);
        this.mContext = (Context) w.i(context, "Context must not be null");
        this.aKf = (Looper) w.i(looper, "Looper must not be null");
        this.aNW = (m) w.i(mVar, "Supervisor must not be null");
        this.aKg = (com.google.android.gms.common.b) w.i(bVar, "API availability must not be null");
        this.mHandler = new b(this, looper);
        this.aOg = i;
        this.aKY = (h) w.ag(hVar);
        this.aIz = hVar.aIz;
        this.aKo = a(hVar.aNP);
        this.aOe = bVar2;
        this.aOf = cVar;
    }

    private static Set<Scope> a(Set<Scope> set) {
        if (set != null) {
            for (Scope contains : set) {
                if (!set.contains(contains)) {
                    throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
                }
            }
        }
        return set;
    }

    private void a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        w.as(z);
        synchronized (this.aNX) {
            this.aOd = i;
            this.aOa = t;
            switch (i) {
                case 1:
                    if (this.aOc != null) {
                        this.aNW.b(nX(), oF(), this.aOc, this.aKY.aJY);
                        this.aOc = null;
                        break;
                    }
                    break;
                case 2:
                    if (this.aOc != null) {
                        new StringBuilder("Calling connect() while still connected, missing disconnect() for ").append(nX()).append(" on ").append(oF());
                        this.aNW.b(nX(), oF(), this.aOc, this.aKY.aJY);
                        this.aOh.incrementAndGet();
                    }
                    this.aOc = new e(this, this.aOh.get());
                    if (!this.aNW.a(nX(), oF(), this.aOc, this.aKY.aJY)) {
                        new StringBuilder("unable to connect to service: ").append(nX()).append(" on ").append(oF());
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aOh.get(), 9));
                        break;
                    }
                    break;
            }
        }
    }

    private boolean a(int i, int i2, T t) {
        boolean z;
        synchronized (this.aNX) {
            if (this.aOd != i) {
                z = false;
            } else {
                a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    protected static void oG() {
    }

    protected static void oH() {
    }

    private void oI() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.aOh.get(), 1));
    }

    public void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new g(this, i, iBinder, bundle)));
    }

    public void a(e eVar) {
        this.aNZ = (e) w.i(eVar, "Connection progress callbacks cannot be null.");
        a(2, null);
    }

    public final void a(e eVar, ConnectionResult connectionResult) {
        this.aNZ = (e) w.i(eVar, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aOh.get(), connectionResult.aJD, connectionResult.aJE));
    }

    public final void a(p pVar) {
        try {
            this.aNY.a(new d(this, this.aOh.get()), new ValidateAccountRequest(pVar, (Scope[]) this.aKo.toArray(new Scope[this.aKo.size()]), this.mContext.getPackageName(), null));
        } catch (DeadObjectException e) {
            oI();
        } catch (RemoteException e2) {
        }
    }

    public final void a(p pVar, Set<Scope> set) {
        try {
            Bundle oJ = oJ();
            GetServiceRequest getServiceRequest = new GetServiceRequest(this.aOg);
            getServiceRequest.aNf = this.mContext.getPackageName();
            getServiceRequest.aNi = oJ;
            if (set != null) {
                getServiceRequest.aNh = (Scope[]) set.toArray(new Scope[set.size()]);
            }
            if (nV()) {
                getServiceRequest.aNj = this.aIz != null ? this.aIz : new Account("<<default account>>", "com.google");
                if (pVar != null) {
                    getServiceRequest.aNg = pVar.asBinder();
                }
            }
            this.aNY.a(new d(this, this.aOh.get()), getServiceRequest);
        } catch (DeadObjectException e) {
            oI();
        } catch (RemoteException e2) {
        }
    }

    public final void a(String str, PrintWriter printWriter) {
        synchronized (this.aNX) {
            int i = this.aOd;
            IInterface iInterface = this.aOa;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print(TMAssistantDownloadSDKClientBase.CONNTECTSTATE_CONNECTING);
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(nY()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
    }

    public void disconnect() {
        this.aOh.incrementAndGet();
        synchronized (this.aOb) {
            int size = this.aOb.size();
            for (int i = 0; i < size; i++) {
                ((c) this.aOb.get(i)).oN();
            }
            this.aOb.clear();
        }
        a(1, null);
    }

    public abstract T f(IBinder iBinder);

    public final boolean isConnected() {
        boolean z;
        synchronized (this.aNX) {
            z = this.aOd == 3;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.aNX) {
            z = this.aOd == 2;
        }
        return z;
    }

    public boolean nV() {
        return false;
    }

    public boolean nW() {
        return true;
    }

    public abstract String nX();

    public abstract String nY();

    public String oF() {
        return "com.google.android.gms";
    }

    public Bundle oJ() {
        return new Bundle();
    }

    public final T oK() {
        T t;
        synchronized (this.aNX) {
            if (this.aOd == 4) {
                throw new DeadObjectException();
            } else if (isConnected()) {
                w.d(this.aOa != null, "Client is connected but service is null");
                t = this.aOa;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t;
    }
}
