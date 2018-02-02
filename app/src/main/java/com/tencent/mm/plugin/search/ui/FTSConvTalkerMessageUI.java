package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.a.b;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI extends FTSBaseUI {
    private String fDj;
    private String mLS;
    private String mLT;
    private int mOz;
    private f qcp;
    private int showType;
    private String talker;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.aNx().aNt();
        a aVar = new a(this, (byte) 0);
        a.a(aVar, this.mLT);
        a aVar2 = new a(this, (byte) 0);
        a.a(aVar2, ">");
        a aVar3 = new a(this, (byte) 0);
        a.a(aVar3, r.gu(this.mLS));
        List arrayList = new ArrayList();
        if (this.showType == 2) {
            arrayList.add(aVar);
            arrayList.add(aVar2);
            arrayList.add(aVar3);
        } else {
            arrayList.add(aVar3);
            arrayList.add(aVar2);
            arrayList.add(aVar);
        }
        l(this.fDj, arrayList);
        bpV();
    }

    protected final void bpY() {
        super.bpY();
        this.mLS = getIntent().getStringExtra("key_conv");
        this.talker = getIntent().getStringExtra("key_talker");
        this.fDj = getIntent().getStringExtra("key_query");
        this.mLT = getIntent().getStringExtra("key_talker_query");
        this.showType = getIntent().getIntExtra("detail_type", 1);
        this.mOz = getIntent().getIntExtra("Search_Scene", 0);
        x.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[]{this.fDj, this.talker, this.mLS, Integer.valueOf(this.showType)});
    }

    protected final b a(c cVar) {
        if (this.qcp == null) {
            this.qcp = new f(this, this.talker, this.mLT, this.mLS, this.mOz, this.showType);
        }
        return this.qcp;
    }

    protected final int getLayoutId() {
        return R.i.djj;
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        super.a(str2, str2, list, bVar);
    }
}
