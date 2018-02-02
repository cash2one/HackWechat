package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mm.plugin.mmsight.model.a.d.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class s {
    public c owk = c.oud;
    SparseArray<WeakReference<b>> owl = new SparseArray();
    private af owm = new 1(this, Looper.getMainLooper());

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] owo = new int[c.values().length];

        static {
            try {
                owo[c.oua.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                owo[c.oud.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                owo[c.ouf.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                owo[c.oug.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(c cVar) {
        x.i("MicroMsg.SightMediaStatusHandler", "status change to %s", new Object[]{cVar.toString()});
        this.owk = cVar;
        this.owm.sendMessage(this.owm.obtainMessage(257, cVar));
    }
}
