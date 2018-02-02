package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(1)
public class WalletLqtSimpleCheckPwdUI extends WalletBaseUI {
    private EditHintPasswdView sBG;
    private r sBH;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(u.gg(this));
        setBackBtn(new 1(this));
        ((TextView) findViewById(f.ula)).setText(a$i.uQW);
        this.sBG = (EditHintPasswdView) findViewById(f.ukY);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sBG);
        this.sBG.zJC = new 2(this);
        e(this.sBG, 0, false);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof r) {
            if (i == 0 && i2 == 0) {
                String text = this.sBG.getText();
                Intent intent = new Intent();
                intent.putExtra("lqt_enc_pwd", text);
                setResult(-1, intent);
                finish();
                return true;
            } else if (this.sBG != null) {
                this.sBG.bmK();
            }
        }
        return false;
    }

    public final void uw(int i) {
        super.uw(i);
        if (this.sBG != null) {
            this.sBG.bmK();
        }
    }

    protected final int getLayoutId() {
        return a$g.uFj;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
