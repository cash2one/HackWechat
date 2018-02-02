package com.tencent.mm.app;

import android.content.Context;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;

class WorkerProfile$27 implements b {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$27(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
    }

    public final void a(au auVar, PString pString, PString pString2, PInt pInt, boolean z) {
        h.b(auVar, pString, pString2, pInt, z);
    }

    public final String a(int i, String str, String str2, int i2, Context context) {
        return h.a(i, str, str2, i2, context);
    }
}
