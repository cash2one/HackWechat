package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;

public class GetQRCodeInfoUI extends MMBaseActivity implements e {
    private ProgressDialog iln = null;
    private ac qgC;

    static /* synthetic */ void a(GetQRCodeInfoUI getQRCodeInfoUI, String str) {
        if (!bh.ov(str)) {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            ar.CG().a(106, getQRCodeInfoUI);
            getQRCodeInfoUI.qgC = new ac(str2, 5);
            ar.CG().a(getQRCodeInfoUI.qgC, 0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.empty);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            return;
        }
        String ou = bh.ou(data.getHost());
        String ou2 = bh.ou(data.getScheme());
        if (("http".equals(ou2) && "weixin.qq.com".equals(ou)) || ("weixin".equals(ou2) && "qr".equals(ou))) {
            ar.CG().a(new bd(new 1(this)), 0);
        } else {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.dDg), true, new 2(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qgC != null) {
            ar.CG().c(this.qgC);
        }
        ar.CG().b(106, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (i == 4 && i2 == -2004) {
            h.a(this, R.l.eBr, R.l.dGO, new 3(this));
        } else if (i == 0 && i2 == 0) {
            bem So = ((ac) kVar).So();
            String a = n.a(So.vYI);
            com.tencent.mm.ad.n.Jz().f(a, n.a(So.vHb));
            ((j) g.h(j.class)).a(new Intent(), So, 30);
            if (bh.ou(a).length() > 0) {
                if ((So.wvf & 8) > 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(10298, a + ",30");
                }
                d.c(this, "profile", ".ui.ContactInfoUI", 1);
            }
        } else {
            h.a(this, getString(R.l.eje, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dGO), new 4(this));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        a.ifs.s(new Intent(), this);
        finish();
    }
}
