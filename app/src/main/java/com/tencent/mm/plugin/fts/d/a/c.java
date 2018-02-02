package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class c extends b {
    public String mPH;
    private b mPI = new b(this);
    private a mPJ = new a(this);

    public class a extends b$a {
        public View contentView;
        public TextView lgs;
        public View mPK;
        final /* synthetic */ c mPL;

        public a(c cVar) {
            this.mPL = cVar;
            super(cVar);
        }
    }

    public c(int i) {
        super(0, i);
    }

    public void a(Context context, b$a com_tencent_mm_plugin_fts_d_a_b_a, Object... objArr) {
        this.mPH = bh.az(e.qg(this.mPx), "");
        x.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[]{this.mPH});
    }

    public b adp() {
        return this.mPI;
    }

    public b$a adq() {
        return this.mPJ;
    }
}
