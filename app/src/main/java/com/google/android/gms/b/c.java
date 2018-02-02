package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;

public abstract class c<T> {
    private final String aQu;
    private T aQv;

    public c(String str) {
        this.aQu = str;
    }

    public final T I(Context context) {
        if (this.aQv == null) {
            w.ag(context);
            Context F = e.F(context);
            if (F == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.aQv = e((IBinder) F.getClassLoader().loadClass(this.aQu).newInstance());
            } catch (Throwable e) {
                throw new a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new a("Could not access creator.", e22);
            }
        }
        return this.aQv;
    }

    public abstract T e(IBinder iBinder);
}
