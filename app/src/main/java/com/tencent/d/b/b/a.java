package com.tencent.d.b.b;

import android.content.SharedPreferences;
import android.util.SparseArray;

public class a {
    private static volatile a AcC = null;
    private SparseArray<String> AcD = new SparseArray(10);
    public SharedPreferences AcE = null;
    private boolean fpe = false;
    private boolean isInit = false;

    public static a cFX() {
        if (AcC != null) {
            return AcC;
        }
        a aVar;
        synchronized (a.class) {
            if (AcC == null) {
                AcC = new a();
            }
            aVar = AcC;
        }
        return aVar;
    }

    public final boolean isInit() {
        boolean z;
        synchronized (a.class) {
            z = this.isInit;
        }
        return z;
    }

    public final void cFY() {
        synchronized (a.class) {
            this.isInit = true;
        }
    }

    public final boolean cFW() {
        boolean z;
        synchronized (a.class) {
            z = this.fpe;
        }
        return z;
    }

    public final void nU(boolean z) {
        synchronized (a.class) {
            this.fpe = z;
        }
    }

    public final SparseArray<String> cFZ() {
        SparseArray<String> sparseArray;
        synchronized (a.class) {
            sparseArray = this.AcD;
        }
        return sparseArray;
    }

    public final SharedPreferences cGa() {
        SharedPreferences sharedPreferences;
        synchronized (a.class) {
            sharedPreferences = this.AcE;
        }
        return sharedPreferences;
    }
}
