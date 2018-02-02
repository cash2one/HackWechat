package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.pluginsdk.ui.tools.g.c;
import com.tencent.mm.sdk.platformtools.x;

class g$5 implements Runnable {
    final /* synthetic */ g vxl;
    final /* synthetic */ SparseArray vxm;
    final /* synthetic */ c vxn;

    g$5(g gVar, SparseArray sparseArray, c cVar) {
        this.vxl = gVar;
        this.vxm = sparseArray;
        this.vxn = cVar;
    }

    public final void run() {
        x.i("MicroMsg.ImageEngine", "begin do recycled");
        for (int i = 0; i < this.vxm.size(); i++) {
            Bitmap bitmap = (Bitmap) this.vxm.valueAt(i);
            if (bitmap != null) {
                x.d("MicroMsg.ImageEngine", "recycled def bmp %s", new Object[]{bitmap.toString()});
                bitmap.recycle();
            }
        }
        this.vxm.clear();
        x.i("MicroMsg.ImageEngine", "clear drawable cache");
        this.vxn.clear();
        x.i("MicroMsg.ImageEngine", "end do recycled");
    }
}
