package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.a.b;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI extends FTSBaseUI {
    private String fDj;
    private String mLS;
    private int mOz;
    private e qcm;

    private class a implements b {
        private String gBL;
        final /* synthetic */ FTSConvMessageUI qcn;

        private a(FTSConvMessageUI fTSConvMessageUI) {
            this.qcn = fTSConvMessageUI;
        }

        public final String getTagName() {
            return this.gBL;
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    protected final void bpY() {
        super.bpY();
        this.mLS = getIntent().getStringExtra("key_conv");
        this.fDj = getIntent().getStringExtra("key_query");
        this.mOz = getIntent().getIntExtra("Search_Scene", 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a();
        aVar.gBL = r.gu(this.mLS);
        List arrayList = new ArrayList();
        arrayList.add(aVar);
        l(this.fDj, arrayList);
        bpV();
    }

    protected final int getLayoutId() {
        return R.i.diT;
    }

    protected void onDestroy() {
        this.qcm.finish();
        super.onDestroy();
    }

    protected final b a(c cVar) {
        if (this.qcm == null) {
            this.qcm = new e(cVar, this.mLS, this.mOz);
        }
        return this.qcm;
    }

    public final boolean akL() {
        return false;
    }

    public final String getHint() {
        return getString(R.l.eJd);
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        super.a(str2, str2, list, bVar);
    }
}
