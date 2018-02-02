package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$a implements OnClickListener {
    private String fileName;
    private int omT;
    final /* synthetic */ c onu;

    public c$a(c cVar, String str, int i) {
        this.onu = cVar;
        this.fileName = str;
        this.omT = i;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
        ar.Hg();
        if (c.isSDCardAvailable()) {
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            String stringBuilder2 = stringBuilder.append(c.Fi()).append(this.fileName).toString();
            if (stringBuilder2 == null || stringBuilder2.equals("") || !e.bO(stringBuilder2)) {
                x.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_compress_type", this.omT);
            intent.putExtra("key_favorite", false);
            intent.putExtra("key_image_path", stringBuilder2);
            a.ifs.d(c.a(this.onu), intent);
            return;
        }
        u.fI(c.a(this.onu));
    }
}
