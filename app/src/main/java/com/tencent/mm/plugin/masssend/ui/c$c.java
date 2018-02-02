package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$c implements OnClickListener {
    private String fileName;
    private int length;
    private int omS;
    final /* synthetic */ c onu;
    private int size;

    public c$c(c cVar, String str, int i, int i2, int i3) {
        this.onu = cVar;
        this.fileName = str;
        this.omS = i;
        this.length = i3;
        this.size = i2;
    }

    public final void onClick(View view) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            boolean z = this.omS == 2;
            o.TU();
            x.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", this.fileName, Boolean.valueOf(z), Boolean.valueOf(q.nm(s.nt(this.fileName))));
            a.ifs.a(z, r2, c.a(this.onu), this.fileName, this.length, this.size);
            return;
        }
        u.fI(c.a(this.onu));
    }
}
