package com.tencent.mm.s;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.w.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class a$1 extends af {
    final /* synthetic */ a gLy;

    a$1(a aVar, Looper looper) {
        this.gLy = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 0 && (message.obj instanceof a$b)) {
            a$b com_tencent_mm_s_a_b = (a$b) message.obj;
            if (com_tencent_mm_s_a_b.gLA != null) {
                a aVar = this.gLy;
                a aVar2 = com_tencent_mm_s_a_b.gLA;
                ArrayList arrayList = null;
                Iterator it = aVar.gLv.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || weakReference.get() == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(weakReference);
                    } else {
                        ((a.a) weakReference.get()).b(aVar2);
                    }
                }
                if (arrayList != null) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        aVar.gLv.remove((WeakReference) it2.next());
                    }
                    arrayList.clear();
                }
            } else {
                a.a(this.gLy, com_tencent_mm_s_a_b.gLz, com_tencent_mm_s_a_b.type, com_tencent_mm_s_a_b.value);
            }
        }
        if (message.what == 1 && (message.obj instanceof a$c)) {
            a$c com_tencent_mm_s_a_c = (a$c) message.obj;
            if (com_tencent_mm_s_a_c.gLA != null) {
                a.a(this.gLy, com_tencent_mm_s_a_c.gLC, com_tencent_mm_s_a_c.gLA);
            } else {
                a.a(this.gLy, com_tencent_mm_s_a_c.gLB, com_tencent_mm_s_a_c.gLz);
            }
        }
    }
}
