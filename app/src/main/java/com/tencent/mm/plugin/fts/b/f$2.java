package com.tencent.mm.plugin.fts.b;

import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.b.f.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class f$2 implements e {
    final /* synthetic */ f mOg;

    f$2(f fVar) {
        this.mOg = fVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[]{cVar.vdy.toString()});
                return;
            }
            x.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            List list = cVar.vdy;
            if (i2 == -44) {
                List linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(1));
                Map hashMap = new HashMap();
                hashMap.put(list.get(0), Integer.valueOf(0));
                g.CG().a(new c(this.mOg, list, linkedList, "你好，我是珍惜", cVar.mOi, hashMap, cVar.mOi), 0);
            }
            if (i == 4 && i2 == -24 && !bh.ov(str)) {
                Toast.makeText(ac.getContext(), str, 1).show();
            }
        }
    }
}
