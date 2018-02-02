package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.ipcall.a.d.j;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.protocal.c.bwp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class IPCallPackageUI extends MMActivity implements e {
    private ListView nKZ = null;
    private TextView nLa = null;
    private ProgressDialog nLb = null;
    private ProgressDialog nLc = null;
    private a nLd = null;
    private com.tencent.mm.plugin.ipcall.a.d.e nLe = null;
    private j nLf = null;
    private f nLg = new f();

    static /* synthetic */ void a(IPCallPackageUI iPCallPackageUI, String str) {
        x.i("MicroMsg.IPCallPackageUI", "startPurchasePackage productID:%s", new Object[]{str});
        if (iPCallPackageUI.nLc == null) {
            Context context = iPCallPackageUI.mController.xIM;
            iPCallPackageUI.getString(R.l.dGO);
            iPCallPackageUI.nLc = h.a(context, iPCallPackageUI.getString(R.l.erT), false, new 3(iPCallPackageUI));
        } else {
            iPCallPackageUI.nLc.show();
        }
        iPCallPackageUI.nLf = new j(str);
        ar.CG().a(iPCallPackageUI.nLf, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(831, this);
        ar.CG().a(277, this);
        this.nLg.start();
        f fVar = this.nLg;
        fVar.nGa++;
        this.nLg.finish();
        setMMTitle(R.l.erS);
        setBackBtn(new 1(this));
        this.nKZ = (ListView) findViewById(R.h.cCh);
        this.nLd = new a(this);
        this.nKZ.setAdapter(this.nLd);
        this.nLa = (TextView) findViewById(R.h.cAv);
        aUA();
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(831, this);
        ar.CG().b(277, this);
    }

    protected final int getLayoutId() {
        return R.i.dmp;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void aUA() {
        x.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
        if (this.nLd != null) {
            this.nLd.not = null;
            this.nLd.notifyDataSetChanged();
        }
        if (this.nKZ != null) {
            this.nKZ.setVisibility(8);
        }
        if (this.nLa != null) {
            this.nLa.setVisibility(8);
        }
        if (this.nLb == null) {
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.nLb = h.a(context, getString(R.l.eqO), true, new 2(this));
        } else {
            this.nLb.show();
        }
        this.nLe = new com.tencent.mm.plugin.ipcall.a.d.e();
        ar.CG().a(this.nLe, 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.nLb != null && this.nLb.isShowing()) {
            this.nLb.dismiss();
        }
        if (this.nLc != null && this.nLc.isShowing()) {
            this.nLc.dismiss();
        }
        if (kVar instanceof com.tencent.mm.plugin.ipcall.a.d.e) {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                ahz com_tencent_mm_protocal_c_ahz = ((com.tencent.mm.plugin.ipcall.a.d.e) kVar).nFx;
                if (com_tencent_mm_protocal_c_ahz == null || com_tencent_mm_protocal_c_ahz.wpf == null || com_tencent_mm_protocal_c_ahz.wpf.size() <= 0) {
                    this.nLd.not = null;
                    this.nLd.notifyDataSetChanged();
                    this.nLa.setVisibility(0);
                    return;
                }
                this.nLd.not = com_tencent_mm_protocal_c_ahz.wpf;
                this.nLd.notifyDataSetChanged();
                this.nKZ.setVisibility(0);
                return;
            }
            Toast.makeText(this.mController.xIM, getString(R.l.eqL), 0).show();
            finish();
        } else if (kVar instanceof j) {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
            this.nLg.nGe = i2;
            if (i == 0 && i2 == 0) {
                this.nLg.finish();
                Toast.makeText(this.mController.xIM, getString(R.l.erU), 0).show();
                aUA();
            } else if (i2 == 101) {
                bwp com_tencent_mm_protocal_c_bwp;
                a aVar = this.nLd;
                j jVar = (j) kVar;
                String str2 = jVar.nFH != null ? jVar.nFH.vIR : "";
                if (!(bh.ov(str2) || aVar.not == null)) {
                    for (bwp com_tencent_mm_protocal_c_bwp2 : aVar.not) {
                        if (com_tencent_mm_protocal_c_bwp2 != null && com_tencent_mm_protocal_c_bwp2.vIR.equals(str2)) {
                            com_tencent_mm_protocal_c_bwp = com_tencent_mm_protocal_c_bwp2;
                            break;
                        }
                    }
                }
                com_tencent_mm_protocal_c_bwp = null;
                if (com_tencent_mm_protocal_c_bwp == null) {
                    x.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
                    this.nLg.finish();
                    Toast.makeText(this.mController.xIM, getString(R.l.erP), 0).show();
                    return;
                }
                h.a(this.mController.xIM, this.mController.xIM.getString(R.l.erQ, new Object[]{com_tencent_mm_protocal_c_bwp.wEW, com_tencent_mm_protocal_c_bwp.fon}), this.mController.xIM.getString(R.l.erR), this.mController.xIM.getString(R.l.eqY), this.mController.xIM.getString(R.l.erM), false, new 4(this), new 5(this));
            } else {
                this.nLg.finish();
                Toast.makeText(this.mController.xIM, getString(R.l.erP), 0).show();
                aUA();
            }
        } else {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        }
    }
}
