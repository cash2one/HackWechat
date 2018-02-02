package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.mm.R;
import com.tencent.mm.az.k;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;

@a(3)
public class BrandServiceLocalSearchUI extends MMActivity implements BrandServiceSortView.a, p.a {
    private p kGa;
    private BrandServiceSortView kGb;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.CG().a(new k(18), 0);
    }

    public final void Xt() {
    }

    public final void Xu() {
    }

    protected final void initView() {
        this.kGb = (BrandServiceSortView) findViewById(R.h.cOV);
        this.kGb.cqr();
        this.kGb.kFY = getIntent().getBooleanExtra("is_return_result", false);
        this.kGb.cqs();
        this.kGb.my(false);
        this.kGb.K(false);
        this.kGb.kHl = this;
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
        x.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", str);
        this.kGb.YR(str);
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

    protected void onDestroy() {
        super.onDestroy();
        this.kGb.release();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kGa.a((FragmentActivity) this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kGa.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return R.i.dbC;
    }

    public final boolean asu() {
        aWs();
        return false;
    }
}
