package com.d.a.a;

import android.os.Handler;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z {
    private static z bmY;
    private static final SparseArray<z> bmZ = new SparseArray();
    private final ExecutorService bna;
    private final Handler handler;

    private z(Handler handler) {
        if (handler != null) {
            this.bna = null;
        } else {
            this.bna = Executors.newSingleThreadExecutor();
        }
        this.handler = handler;
    }

    static z a(Handler handler) {
        if (handler != null) {
            int hashCode = handler.getLooper().hashCode();
            z zVar = (z) bmZ.get(hashCode);
            if (zVar != null) {
                return zVar;
            }
            zVar = new z(handler);
            bmZ.put(hashCode, zVar);
            return zVar;
        }
        if (bmY == null) {
            bmY = new z(null);
        }
        return bmY;
    }

    final void execute(Runnable runnable) {
        if (this.handler != null) {
            this.handler.post(runnable);
        } else {
            this.bna.execute(runnable);
        }
    }
}
