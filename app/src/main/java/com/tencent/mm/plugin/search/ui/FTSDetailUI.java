package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.sdk.platformtools.x;

public class FTSDetailUI extends FTSBaseUI {
    private int mOz;
    private int mPx;
    private g qcx;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.bpQ().aNt();
        String stringExtra = getIntent().getStringExtra("detail_query");
        this.fDj = stringExtra;
        this.qca.zet.t(stringExtra, null);
        x.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[]{this.fDj, Integer.valueOf(this.mPx), Integer.valueOf(this.mOz)});
        bpV();
    }

    protected final void bpY() {
        this.mPx = getIntent().getIntExtra("detail_type", 0);
        this.mOz = getIntent().getIntExtra("Search_Scene", 0);
    }

    protected final b a(c cVar) {
        if (this.qcx == null) {
            this.qcx = new g(cVar, this.mPx, this.mOz);
        }
        return this.qcx;
    }

    public final void a(b bVar) {
    }

    protected final int getLayoutId() {
        return R.i.diT;
    }

    protected void onDestroy() {
        this.qcx.finish();
        c.bpQ().aNq();
        super.onDestroy();
    }

    public final String getHint() {
        String qg = e.qg(this.mPx);
        if (qg == null) {
            return getString(R.l.dGz);
        }
        return qg;
    }
}
