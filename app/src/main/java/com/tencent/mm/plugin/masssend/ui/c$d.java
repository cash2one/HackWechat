package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class c$d implements OnClickListener {
    private String id;
    final /* synthetic */ c onu;

    public c$d(c cVar, String str) {
        this.onu = cVar;
        this.id = str;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
        if (c.b(this.onu) != null) {
            c.a(this.onu, c.b(this.onu).Ei(this.id));
            this.onu.notifyDataSetChanged();
        }
    }
}
