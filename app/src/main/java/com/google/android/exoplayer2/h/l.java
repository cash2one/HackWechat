package com.google.android.exoplayer2.h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.lang.reflect.InvocationTargetException;

public final class l implements f {
    private final t<? super f> aAB;
    private final f aBh;
    private f aBi;
    private f aBj;
    private f aBk;
    private f aBl;
    private f aiB;
    private final Context context;

    public l(Context context, t<? super f> tVar, f fVar) {
        this.context = context.getApplicationContext();
        this.aAB = tVar;
        this.aBh = (f) a.Y(fVar);
    }

    public final long a(i iVar) {
        a.an(this.aiB == null);
        String scheme = iVar.uri.getScheme();
        if (t.d(iVar.uri)) {
            if (iVar.uri.getPath().startsWith("/android_asset/")) {
                this.aiB = lu();
            } else {
                if (this.aBi == null) {
                    this.aBi = new p(this.aAB);
                }
                this.aiB = this.aBi;
            }
        } else if ("asset".equals(scheme)) {
            this.aiB = lu();
        } else if ("content".equals(scheme)) {
            if (this.aBk == null) {
                this.aBk = new e(this.context, this.aAB);
            }
            this.aiB = this.aBk;
        } else if ("rtmp".equals(scheme)) {
            this.aiB = lv();
        } else {
            this.aiB = this.aBh;
        }
        return this.aiB.a(iVar);
    }

    public final int read(byte[] bArr, int i, int i2) {
        return this.aiB.read(bArr, i, i2);
    }

    public final Uri getUri() {
        return this.aiB == null ? null : this.aiB.getUri();
    }

    public final void close() {
        if (this.aiB != null) {
            try {
                this.aiB.close();
            } finally {
                this.aiB = null;
            }
        }
    }

    private f lu() {
        if (this.aBj == null) {
            this.aBj = new c(this.context, this.aAB);
        }
        return this.aBj;
    }

    private f lv() {
        if (this.aBl == null) {
            try {
                this.aBl = (f) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
            } catch (InstantiationException e2) {
            } catch (IllegalAccessException e3) {
            } catch (NoSuchMethodException e4) {
            } catch (InvocationTargetException e5) {
            }
            if (this.aBl == null) {
                this.aBl = this.aBh;
            }
        }
        return this.aBl;
    }
}
