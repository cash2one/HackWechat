package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.ipcall.a.d.d;
import com.tencent.mm.protocal.c.ahx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class IPCallMyGiftCardUI extends MMActivity implements e {
    private ListView Fv;
    private View kgl;
    private ProgressDialog ltM;
    private a nKO;
    private d nKP;

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(288, this);
        setMMTitle(R.l.erG);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallMyGiftCardUI nKQ;

            {
                this.nKQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nKQ.finish();
                return true;
            }
        });
        addTextOptionMenu(0, this.mController.xIM.getString(R.l.erF), new 2(this));
        this.kgl = findViewById(R.h.crj);
        this.Fv = (ListView) findViewById(R.h.crk);
        this.nKO = new a(this);
        this.Fv.setAdapter(this.nKO);
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.ltM = h.a(context, getString(R.l.eqO), true, new 3(this));
        this.nKP = new d();
        ar.CG().a(this.nKP, 0);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(288, this);
    }

    protected final int getLayoutId() {
        return R.i.dmn;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (!(kVar instanceof d)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            ahx com_tencent_mm_protocal_c_ahx = ((d) kVar).nFv;
            if (this.ltM != null && this.ltM.isShowing()) {
                this.ltM.dismiss();
            }
            this.nKO.not = com_tencent_mm_protocal_c_ahx.wph;
            this.nKO.nKS = com_tencent_mm_protocal_c_ahx;
            this.nKO.notifyDataSetChanged();
            if (com_tencent_mm_protocal_c_ahx.wph.size() == 0) {
                this.kgl.setVisibility(0);
                return;
            }
            return;
        }
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
        this.kgl.setVisibility(0);
        Toast.makeText(this.mController.xIM, getString(R.l.eqL), 0).show();
    }
}
