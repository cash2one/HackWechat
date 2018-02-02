package com.google.android.gms.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import com.google.android.gms.c.d;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.w;
import java.io.IOException;

public final class a {
    private static boolean aEp = false;
    h aEj;
    d aEk;
    boolean aEl;
    Object aEm = new Object();
    b aEn;
    final long aEo;
    private final Context mContext;

    private a(Context context) {
        w.ag(context);
        this.mContext = context;
        this.aEl = false;
        this.aEo = -1;
    }

    private static d a(h hVar) {
        try {
            return com.google.android.gms.c.d.a.n(hVar.pk());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void ma() {
        w.aO("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.aEl) {
                finish();
            }
            this.aEj = w(this.mContext);
            this.aEk = a(this.aEj);
            this.aEl = true;
        }
    }

    private a mb() {
        a aVar;
        w.aO("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.aEl) {
                synchronized (this.aEm) {
                    if (this.aEn == null || !this.aEn.aEv) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    ma();
                    if (!this.aEl) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            w.ag(this.aEj);
            w.ag(this.aEk);
            aVar = new a(this.aEk.getId(), this.aEk.at(true));
        }
        synchronized (this.aEm) {
            if (this.aEn != null) {
                this.aEn.aEu.countDown();
                try {
                    this.aEn.join();
                } catch (InterruptedException e3) {
                }
            }
            if (this.aEo > 0) {
                this.aEn = new b(this, this.aEo);
            }
        }
        return aVar;
    }

    private static h w(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            if (aEp) {
                b.nR();
                switch (b.C(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                e.E(context);
            } catch (Throwable e) {
                throw new IOException(e);
            }
            Object hVar = new h();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (com.google.android.gms.common.stats.b.pi().a(context, intent, hVar, 1)) {
                    return hVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e2) {
                IOException iOException = new IOException(e2);
            }
        } catch (NameNotFoundException e3) {
            throw new c(9);
        }
    }

    public static a x(Context context) {
        a aVar = new a(context);
        try {
            aVar.ma();
            a mb = aVar.mb();
            return mb;
        } finally {
            aVar.finish();
        }
    }

    protected final void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void finish() {
        w.aO("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.aEj == null) {
            } else {
                try {
                    if (this.aEl) {
                        com.google.android.gms.common.stats.b.pi().a(this.mContext, this.aEj);
                    }
                } catch (IllegalArgumentException e) {
                }
                this.aEl = false;
                this.aEk = null;
                this.aEj = null;
            }
        }
    }
}
