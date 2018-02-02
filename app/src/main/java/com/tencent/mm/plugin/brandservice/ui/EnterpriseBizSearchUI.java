package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.b;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class EnterpriseBizSearchUI extends MMActivity implements b, p.a {
    private String kGH;
    private p kGa;
    private EnterpriseBizContactListView kGf;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kGf != null) {
            EnterpriseBizContactListView.release();
        }
    }

    public final void Xt() {
    }

    public final void Xu() {
    }

    protected final void initView() {
        if (bh.ov(this.kGH)) {
            this.kGH = getIntent().getStringExtra("enterprise_biz_name");
            if (bh.ov(this.kGH)) {
                finish();
            }
        }
        this.kGf = (EnterpriseBizContactListView) findViewById(R.h.cOV);
        this.kGf.kGd = this.kGH;
        this.kGf.kGk = true;
        this.kGf.refresh();
        this.kGf.cqr();
        this.kGf.asv();
        this.kGf.cqs();
        this.kGf.my(false);
        this.kGf.kGn = this;
        ((TextView) this.kGf.asx()).setText(R.l.ebZ);
        this.kGa = new p();
        this.kGa.nu(true);
        this.kGa.a(this);
        this.kGa.vyU = false;
    }

    public final void Xs() {
    }

    public final void Xr() {
        finish();
    }

    public final void oL(String str) {
        x.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[]{str});
        this.kGf.YR(str);
    }

    public final boolean oK(String str) {
        aWs();
        return true;
    }

    public final void ass() {
        aWs();
    }

    public final void ast() {
    }

    protected void onPause() {
        super.onPause();
        this.kGa.cancel();
        this.kGa.clearFocus();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kGa.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kGa.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return R.i.dgr;
    }

    public final boolean asu() {
        aWs();
        return false;
    }
}
