package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.f.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class WalletVerifyIdCardUI extends WalletBaseUI {
    private TextView jJn;
    private boolean sWO = false;
    private h sWP = new h();
    private a sWQ = new 4(this);
    private EditHintPasswdView sWT;

    static /* synthetic */ boolean a(WalletVerifyIdCardUI walletVerifyIdCardUI, a aVar) {
        if (walletVerifyIdCardUI.sWO) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "isCertInstalled passed");
            return false;
        }
        String string = walletVerifyIdCardUI.vf.getString("key_cre_type");
        String text = walletVerifyIdCardUI.sWT.getText();
        if (walletVerifyIdCardUI.sWP.bLa()) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall %s", new Object[]{aVar});
            if (bh.ov(text)) {
                x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall sms error %s", new Object[]{aVar});
                return false;
            }
            g.pQN.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyIdCardUI.l(new f(string, text, walletVerifyIdCardUI.bJQ(), aVar, true));
            return true;
        } else if (walletVerifyIdCardUI.sWP.bKZ()) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isNeedInstall %s", new Object[]{aVar});
            g.pQN.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyIdCardUI.l(new f(string, text, walletVerifyIdCardUI.bJQ(), aVar, false));
            return true;
        } else {
            x.i("MicroMsg.WalletVerifyIdCardUI", "no need installcert");
            return false;
        }
    }

    static /* synthetic */ void b(WalletVerifyIdCardUI walletVerifyIdCardUI) {
        if (walletVerifyIdCardUI.cCd() != null) {
            x.d("MicroMsg.WalletVerifyIdCardUI", "3des text: %s", new Object[]{walletVerifyIdCardUI.sWT.getText()});
            p pVar = new p();
            pVar.sPj = walletVerifyIdCardUI.vf.getString("key_pwd1");
            pVar.pCn = (PayInfo) walletVerifyIdCardUI.vf.getParcelable("key_pay_info");
            pVar.fCz = 1;
            pVar.sPn = walletVerifyIdCardUI.vf.getString("key_cre_type");
            pVar.sPm = walletVerifyIdCardUI.sWT.getText();
            pVar.token = bh.az(walletVerifyIdCardUI.vf.getString("kreq_token"), "");
            switch (walletVerifyIdCardUI.vf.getInt("key_pay_flag", 0)) {
                case 1:
                    pVar.flag = "1";
                    break;
                case 2:
                    if (!walletVerifyIdCardUI.bMX()) {
                        pVar.flag = "2";
                        break;
                    } else {
                        pVar.flag = "5";
                        break;
                    }
                case 3:
                    if (!walletVerifyIdCardUI.bMX()) {
                        pVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                        break;
                    } else {
                        pVar.flag = "6";
                        break;
                    }
            }
            Bankcard bankcard = (Bankcard) walletVerifyIdCardUI.vf.getParcelable("key_bankcard");
            if (bankcard != null) {
                pVar.oZz = bankcard.field_bankcardType;
                pVar.oZA = bankcard.field_bindSerial;
                pVar.sKA = bh.az(bankcard.field_arrive_type, "");
            } else {
                pVar.oZz = walletVerifyIdCardUI.vf.getString("key_bank_type");
                if (bh.ov(pVar.oZz)) {
                    pVar.oZz = walletVerifyIdCardUI.vf.getString("key_bind_card_type", "");
                }
            }
            walletVerifyIdCardUI.cCd().k(new Object[]{pVar});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sWP = new h(this.vf);
        initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.white)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            customView = customView.findViewById(com.tencent.mm.plugin.wxpay.a.f.divider);
            if (customView != null) {
                customView.setBackgroundColor(getResources().getColor(c.transparent));
            }
        }
        if (d.fM(21)) {
            if (d.fM(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletVerifyIdCardUI sWU;

            {
                this.sWU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sWU.finish();
                return false;
            }
        }, com.tencent.mm.plugin.wxpay.a.h.dvO);
    }

    protected final void initView() {
        this.jJn = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uAK);
        this.sWT = (EditHintPasswdView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uAJ);
        String string = this.vf.getString("key_true_name");
        String string2 = this.vf.getString("key_cre_name");
        String string3 = this.vf.getString("key_cre_type");
        this.jJn.setText(getString(i.uRR, new Object[]{string, string2}));
        EditHintPasswdView editHintPasswdView = this.sWT;
        if (editHintPasswdView.zJy != null) {
            InputFilter[] filters = editHintPasswdView.zJy.getFilters();
            InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
            for (int i = 0; i < filters.length; i++) {
                inputFilterArr[i] = filters[i];
            }
            inputFilterArr[inputFilterArr.length - 1] = new LengthFilter(4);
            editHintPasswdView.zJy.setFilters(inputFilterArr);
        }
        EditHintPasswdView editHintPasswdView2 = this.sWT;
        if (editHintPasswdView2.zJy != null) {
            editHintPasswdView2.zJy.setTextSize(34.0f);
        }
        this.sWT.zJC = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletVerifyIdCardUI sWU;

            {
                this.sWU = r1;
            }

            public final void hx(boolean z) {
                this.sWU.sWT.postDelayed(new 1(this, z), 50);
            }
        };
        if ("1".equals(string3)) {
            e(this.sWT, 1, false);
        } else {
            e(this.sWT, 1, true);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof f)) {
            return false;
        }
        if (i2 == 0 || !((f) kVar).fHt) {
            this.sWT.bmK();
        } else {
            com.tencent.mm.ui.base.h.a(this.mController.xIM, str, null, false, new OnClickListener(this) {
                final /* synthetic */ WalletVerifyIdCardUI sWU;

                {
                    this.sWU = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return true;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFZ;
    }

    private boolean bMX() {
        return this.vf.getBoolean("key_is_oversea", false);
    }

    public final boolean j(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", new Object[]{Integer.valueOf(i2), kVar});
        if ((kVar instanceof f) && i2 == 0) {
            this.sWO = true;
            u.makeText(this, i.uUe, 0).show();
            x.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
        }
        return true;
    }
}
