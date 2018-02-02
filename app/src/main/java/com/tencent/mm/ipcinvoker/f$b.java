package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.x;

class f$b implements l {
    private f$b() {
    }

    public final Bundle j(Bundle bundle) {
        if (bundle == null) {
            x.e("IPC.IPCInvoker", "proxy SyncInvoke failed, data is null.");
            return null;
        }
        Parcelable parcelable = bundle.getParcelable("__remote_task_data");
        String string = bundle.getString("__remote_task_class");
        if (string == null || string.length() == 0) {
            x.e("IPC.IPCInvoker", "proxy SyncInvoke failed, class is null or nil.");
            return null;
        }
        j jVar = (j) o.d(string, j.class);
        if (jVar == null) {
            x.w("IPC.IPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", new Object[]{string});
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("__remote_task_result_data", (Parcelable) jVar.at(parcelable));
        return bundle2;
    }
}
