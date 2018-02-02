package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.bm.d;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.protocal.c.nm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.z.ar;

public class CheckSmsCanAddCardUI extends MMActivity implements e {
    private b gJQ;
    private String xEh;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!ar.Hi() || ar.Cs()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        int i;
        Uri data = getIntent().getData();
        if (data != null) {
            String host = data.getHost();
            if (bh.ov(host) || !host.equals("cardpackage")) {
                x.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", new Object[]{host});
            } else {
                this.xEh = data.getQueryParameter("encrystr");
                x.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", new Object[]{this.xEh});
                if (!bh.ov(this.xEh)) {
                    i = 1;
                    if (i == 0) {
                        ar.CG().a(1038, this);
                        a aVar = new a();
                        aVar.hmj = new nl();
                        aVar.hmk = new nm();
                        aVar.hmi = 1038;
                        aVar.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
                        this.gJQ = aVar.JZ();
                        ((nl) this.gJQ.hmg.hmo).vWr = this.xEh;
                        x.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[]{this.xEh});
                        this.gJQ = u.a(this.gJQ);
                    }
                    clT();
                    return;
                }
            }
        }
        i = 0;
        if (i == 0) {
            clT();
            return;
        }
        ar.CG().a(1038, this);
        a aVar2 = new a();
        aVar2.hmj = new nl();
        aVar2.hmk = new nm();
        aVar2.hmi = 1038;
        aVar2.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
        this.gJQ = aVar2.JZ();
        ((nl) this.gJQ.hmg.hmo).vWr = this.xEh;
        x.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[]{this.xEh});
        this.gJQ = u.a(this.gJQ);
    }

    protected final int getLayoutId() {
        return R.i.dmv;
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(1038, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            nm nmVar = (nm) this.gJQ.hmh.hmo;
            x.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", new Object[]{nmVar.fGU, nmVar.fGV});
            Intent intent = new Intent();
            intent.putExtra("key_card_id", r1);
            intent.putExtra("key_card_ext", r0);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_is_sms_add_card", true);
            d.a((Context) this, "card", ".ui.CardDetailUI", intent, false);
            finish();
            return;
        }
        clT();
    }

    private void clT() {
        Toast.makeText(this, getString(R.l.eSH), 1).show();
        LauncherUI.fr(this);
        finish();
    }
}
