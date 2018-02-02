package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.c;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI extends MMActivity implements b {
    private p kFi;
    private BizSearchResultItemContainer kFj;
    private long kFk;
    private String kFl;
    private int kFm;
    private int kFn;
    private Runnable kFo = new 1(this);
    private int wn;

    protected final int getLayoutId() {
        return R.i.dbp;
    }

    public final void Xt() {
    }

    public final void Xu() {
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        setBackBtn(new 2(this));
        Intent intent = getIntent();
        this.kFk = intent.getLongExtra("businessType", 0);
        boolean booleanExtra = intent.getBooleanExtra("showEditText", false);
        this.kFm = intent.getIntExtra("fromScene", 0);
        this.kFn = intent.getIntExtra("addContactScene", 35);
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("keyword");
        boolean booleanExtra2 = intent.getBooleanExtra("showCatalog", false);
        this.wn = intent.getIntExtra("offset", 0);
        if (this.kFk == 0 || bh.ov(stringExtra2)) {
            x.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[]{Long.valueOf(this.kFk)});
            finish();
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("result");
        if (byteArrayExtra != null) {
            try {
                je jeVar = (je) new je().aF(byteArrayExtra);
                boolean z2 = jeVar != null;
                je jeVar2 = jeVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", e, "", new Object[0]);
                finish();
                return;
            }
        }
        z2 = false;
        jeVar2 = null;
        this.kFj = (BizSearchResultItemContainer) findViewById(R.h.cJm);
        this.kFj.a(new c(this));
        this.kFj.d(new long[]{this.kFk});
        this.kFj.kFN = 1;
        this.kFj.dW(booleanExtra2);
        this.kFj.lw(this.kFm);
        BizSearchResultItemContainer bizSearchResultItemContainer = this.kFj;
        int i = this.kFn;
        bizSearchResultItemContainer.kFn = i;
        bizSearchResultItemContainer.kFE.nu(i);
        bizSearchResultItemContainer = this.kFj;
        c.b 3 = new 3(this);
        if (bizSearchResultItemContainer.kFE != null) {
            bizSearchResultItemContainer.kFE.a(3);
        }
        if (booleanExtra) {
            this.kFi = new p();
            a(this.kFi);
            this.kFi.nu(false);
            this.kFi.clearFocus();
            this.kFi.ZR(stringExtra2);
            this.kFi.zms = this;
            this.kFj.setOnTouchListener(new 4(this));
        } else if (!bh.ov(stringExtra)) {
            setMMTitle(stringExtra);
        }
        if (z2) {
            bizSearchResultItemContainer = this.kFj;
            int i2 = this.wn;
            bizSearchResultItemContainer.reset();
            if (jeVar2 == null) {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
                return;
            }
            bizSearchResultItemContainer.kFG.fod = stringExtra2;
            bizSearchResultItemContainer.d(new long[]{jeVar2.vPp});
            bizSearchResultItemContainer.kFG.hEP = jeVar2.vPq;
            bizSearchResultItemContainer.kFL = i2;
            List linkedList = new LinkedList();
            linkedList.add(jeVar2);
            bizSearchResultItemContainer.kFE.c(stringExtra2, linkedList);
            bizSearchResultItemContainer.kFG.offset = i2 + jeVar2.vNW;
            c cVar = bizSearchResultItemContainer.kFG;
            if (bizSearchResultItemContainer.kFE.isEmpty()) {
                z = false;
            }
            cVar.kFU = z;
            return;
        }
        oL(stringExtra2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.kFi != null) {
            this.kFi.a(this, menu);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.kFi != null) {
            this.kFi.a(this, menu);
        }
        return true;
    }

    protected void onPause() {
        super.onPause();
        if (this.kFi != null) {
            this.kFi.clearFocus();
        }
    }

    public final boolean oK(String str) {
        return false;
    }

    public final void oL(String str) {
        if (!bh.ov(str)) {
            String trim = str.trim();
            if (!trim.equals(this.kFl)) {
                ag.K(this.kFo);
                this.kFl = trim;
                ag.h(this.kFo, 400);
            }
        }
    }

    public final void Xr() {
        finish();
    }

    public final void Xs() {
    }
}
