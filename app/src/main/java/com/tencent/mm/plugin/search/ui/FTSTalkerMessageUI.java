package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.a.b;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI extends FTSBaseUI {
    private String fDj;
    private String mLT;
    private int mOz;
    private j qdn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.aNx().aNt();
        a aVar = new a(this, (byte) 0);
        a.a(aVar, this.mLT);
        List arrayList = new ArrayList();
        arrayList.add(aVar);
        l(this.fDj, arrayList);
        bpV();
    }

    protected final void bpY() {
        super.bpY();
        this.mLT = getIntent().getStringExtra("key_talker_query");
        this.fDj = getIntent().getStringExtra("key_query");
        this.mOz = getIntent().getIntExtra("Search_Scene", 0);
        x.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", this.fDj, this.mLT);
    }

    protected final b a(c cVar) {
        if (this.qdn == null) {
            this.qdn = new j(this, this.mLT, this.mOz);
        }
        return this.qdn;
    }

    protected final int getLayoutId() {
        return R.i.djj;
    }

    protected void onDestroy() {
        this.qdn.finish();
        h.aNx().aNr();
        super.onDestroy();
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        super.a(str2, str2, list, bVar);
    }
}
