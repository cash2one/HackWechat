package com.c.a;

import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;

public final class a {
    public c bfY;
    public b bfZ;
    public a bga;
    private int bgb;
    b bgc;
    int bgd = -1;
    public DeathRecipient bge = new 1(this);

    public static a rM() {
        c rP = rP();
        if (rP == null) {
            return null;
        }
        try {
            return new a(rP, Looper.getMainLooper(), 1);
        } catch (Exception e) {
            return null;
        }
    }

    private a(c cVar, Looper looper, int i) {
        this.bfY = cVar;
        a aVar = new a(this, looper);
        this.bgb = 1;
        this.bfZ = new 2(this);
        if (this.bfY.a(this.bfZ, 1)) {
            this.bga = aVar;
            cVar.asBinder().linkToDeath(this.bge, 0);
            return;
        }
        throw new RuntimeException();
    }

    public final int[] rN() {
        try {
            return this.bfY.c(this.bfZ);
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    public final int a(b bVar, int i, int[] iArr) {
        int i2 = -1;
        if (!(iArr == null || bVar == null)) {
            if (i > 0) {
                new StringBuilder("startIdentify send message timeout after ").append(i).append(" ms");
                this.bga.sendMessageDelayed(this.bga.obtainMessage(8), (long) i);
            }
            this.bgc = bVar;
            this.bgd = 0;
            try {
                i2 = this.bfY.a(this.bfZ, iArr, null);
            } catch (RemoteException e) {
            }
        }
        return i2;
    }

    public final void abort() {
        if (this.bga != null) {
            this.bga.removeMessages(8);
        }
        try {
            this.bfY.a(this.bfZ);
        } catch (RemoteException e) {
        }
    }

    public static int[] rO() {
        c rP = rP();
        if (rP == null) {
            return new int[0];
        }
        try {
            return rP.rQ();
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    private static c rP() {
        return com.c.a.c.a.x(ServiceManager.getService("authentication_service"));
    }
}
