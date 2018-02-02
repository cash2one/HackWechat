package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.x;

class f$a implements a {
    private f$a() {
    }

    public final void a(Bundle bundle, c cVar) {
        Parcelable parcelable = bundle.getParcelable("__remote_task_data");
        String string = bundle.getString("__remote_task_class");
        if (string == null || string.length() == 0) {
            x.e("IPC.IPCInvoker", "proxy AsyncInvoke failed, class is null or nil.");
            return;
        }
        h hVar = (h) o.d(string, h.class);
        if (hVar == null) {
            x.w("IPC.IPCInvoker", "proxy AsyncInvoke failed, newInstance(%s) return null.", string);
            return;
        }
        hVar.a(parcelable, new 1(this, cVar));
    }
}
