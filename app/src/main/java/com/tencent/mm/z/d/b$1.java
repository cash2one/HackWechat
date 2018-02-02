package com.tencent.mm.z.d;

import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$1 implements Runnable {
    final /* synthetic */ b hjn;

    public b$1(b bVar) {
        this.hjn = bVar;
    }

    public final void run() {
        File file = new File(b.by() + "MMSQL.trace");
        if (!file.exists()) {
            x.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
        } else if (g.Dh().Cy()) {
            long currentTimeMillis = System.currentTimeMillis();
            long ba = b.ba(ac.getContext());
            boolean z = false;
            if (ba > currentTimeMillis) {
                z = true;
            } else if (currentTimeMillis - ba > 86400000) {
                z = true;
            } else if (currentTimeMillis - ba > b.a(this.hjn) && b.b(this.hjn)) {
                z = true;
            }
            x.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", new Object[]{Long.valueOf(file.length()), Boolean.valueOf(z)});
            if (z && r2 > b.c(this.hjn)) {
                b bVar = this.hjn;
                Context context = ac.getContext();
                String packageName = ac.getContext().getPackageName();
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new b$2(bVar)});
                } catch (Exception e) {
                    bVar.ffu[0] = -1;
                    bVar.ffu[1] = -1;
                    bVar.ffu[2] = -1;
                }
                if (b.d(this.hjn)[1] != 0 || b.e(this.hjn) > 1) {
                    x.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", new Object[]{Long.valueOf(file.length())});
                    if (file.length() > b.f(this.hjn)) {
                        x.e("MicroMsg.SQLTraceManager", "log file invaild format");
                    } else {
                        String is = b.is(b.by() + "MMSQL.trace");
                        x.i("MicroMsg.SQLTraceManager", "read content success");
                        this.hjn.ir(is);
                    }
                    x.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", new Object[]{Long.valueOf(System.currentTimeMillis())});
                    b.a(this.hjn, file);
                    b.g(this.hjn);
                    b.h(this.hjn);
                    b.c(ac.getContext(), System.currentTimeMillis());
                    return;
                }
                x.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
                b.i(this.hjn);
            }
        } else {
            x.w("MicroMsg.SQLTraceManager", "acc not ready ");
        }
    }
}
