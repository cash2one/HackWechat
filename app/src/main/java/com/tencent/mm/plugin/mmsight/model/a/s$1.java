package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.mmsight.model.a.d.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s.2;
import com.tencent.mm.sdk.platformtools.af;
import java.lang.ref.WeakReference;

class s$1 extends af {
    final /* synthetic */ s own;

    s$1(s sVar, Looper looper) {
        this.own = sVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (257 == message.what) {
            c cVar = (c) message.obj;
            for (int i = 0; i < this.own.owl.size(); i++) {
                if (((b) ((WeakReference) this.own.owl.valueAt(i)).get()) != null) {
                    int[] iArr = 2.owo;
                    cVar.ordinal();
                }
            }
        } else if (258 == message.what) {
            r0 = (b) message.obj;
            if (r0 != null) {
                this.own.owl.put(r0.hashCode(), new WeakReference(r0));
            }
        } else if (259 == message.what) {
            r0 = (b) message.obj;
            if (r0 != null) {
                this.own.owl.remove(r0.hashCode());
            }
        }
    }
}
