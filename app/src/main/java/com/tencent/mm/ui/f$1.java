package com.tencent.mm.ui;

import android.util.SparseArray;
import com.tencent.mm.by.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.d;
import java.util.HashSet;

class f$1 implements d {
    final /* synthetic */ f xED;

    f$1(f fVar) {
        this.xED = fVar;
    }

    public final void cmc() {
        if (f.a(this.xED, f.b(this.xED))) {
            HashSet hashSet = new HashSet(f.b(this.xED).size());
            for (b bVar : f.b(this.xED).values()) {
                hashSet.add(bVar.object);
            }
            x.i(this.xED.TAG, "newcursor all event is delete");
            f.c(this.xED).c(hashSet.toArray(), null);
        } else if (f.b(this.xED).containsKey(this.xED.xEC)) {
            r2 = System.currentTimeMillis();
            f.a(this.xED, new f$c(this.xED, this.xED.clX()), true, false);
            x.i(this.xED.TAG, "cache unuseful,reset cursor,last : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - r2)});
        } else {
            r2 = System.currentTimeMillis();
            SparseArray[] clY = this.xED.clY();
            SparseArray[] a = this.xED.a(new HashSet(f.b(this.xED).values()), clY);
            int length = clY.length;
            if (length > 1) {
                for (int i = 0; i < length; i++) {
                    x.i(this.xED.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - r2), Integer.valueOf(clY[i].size()), Integer.valueOf(a[i].size())});
                }
            } else {
                x.i(this.xED.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[]{Long.valueOf(System.currentTimeMillis() - r2), Integer.valueOf(clY[0].size()), Integer.valueOf(a[0].size())});
            }
            for (b bVar2 : f.b(this.xED).values()) {
                if (bVar2 != null) {
                    if (bVar2.xEG != null) {
                        x.i(this.xED.TAG, "newcursor notify cache update : key : %s ", new Object[]{bVar2.object});
                    }
                    f.c(this.xED).c(bVar2.object, (a) bVar2.xEG);
                } else {
                    x.e(this.xED.TAG, "newcursor event is null ! ");
                }
            }
            this.xED.a(a);
            x.i(this.xED.TAG, "newcursor after resort new pos size :%d  ", new Object[]{Integer.valueOf(f.c(this.xED).ckN()[0].size())});
        }
        f.b(this.xED).clear();
    }
}
