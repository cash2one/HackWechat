package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI extends WalletBaseUI {
    private Button npM;
    private TenpaySegmentEditText sTx;
    private boolean sTy = true;

    static /* synthetic */ void g(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        TenpaySegmentEditText.setSalt(n.cBr());
        walletConfirmCardIDUI.l(new t(walletConfirmCardIDUI.bJQ(), walletConfirmCardIDUI.sTx.getEncryptDataWithHash(false), (PayInfo) walletConfirmCardIDUI.vf.getParcelable("key_pay_info"), walletConfirmCardIDUI.vf.getInt("entry_scene", -1)));
    }

    protected final int getLayoutId() {
        return g.uEP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        Object string = this.vf.getString("key_bankcard_id");
        String string2 = this.vf.getString("key_bankcard_des");
        Bitmap bitmap = (Bitmap) this.vf.getParcelable("key_bankcard_cropimg");
        if (TextUtils.isEmpty(string)) {
            x.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
            finish();
        } else if (bitmap == null) {
            x.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
            finish();
        } else {
            setMMTitle(i.uRb);
            this.npM = (Button) findViewById(f.cAg);
            this.sTx = (TenpaySegmentEditText) findViewById(f.ujO);
            this.sTx.setText(string, string2);
            this.mKeyboard = (MyKeyboardWindow) findViewById(f.uwN);
            this.ofs = findViewById(f.uwM);
            ((ImageView) findViewById(f.uht)).setImageBitmap(bitmap);
            this.sTx.setKeyboard(this.mKeyboard);
            this.mKeyboard.setXMode(0);
            ((InputMethodManager) this.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(this.sTx.getWindowToken(), 0);
            this.ofs.setVisibility(8);
            this.sTx.setOnClickListener(new 2(this));
            final String str = this.sTx.get3DesEncrptData();
            this.npM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletConfirmCardIDUI sTz;

                public final void onClick(View view) {
                    String str = this.sTz.sTx.get3DesEncrptData();
                    if (str == null || !str.equals(str)) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(11353, new Object[]{Integer.valueOf(0), Integer.valueOf(2)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.h(11353, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                    }
                    WalletConfirmCardIDUI.g(this.sTz);
                }
            });
            this.mKeyboard = (MyKeyboardWindow) findViewById(f.uwN);
            this.ofs = findViewById(f.uwM);
            View findViewById = findViewById(f.itm);
            if (!(this.mKeyboard == null || this.ofs == null)) {
                findViewById.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletConfirmCardIDUI sTz;

                    {
                        this.sTz = r1;
                    }

                    public final void onClick(View view) {
                        this.sTz.Xa();
                    }
                });
            }
            this.sTx.setFocusable(false);
            this.sTx.setFocusableInTouchMode(true);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Bundle bundle = new Bundle();
        boolean z = this.vf.getBoolean("key_is_reset_with_new_card", false);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                bundle.putBoolean("key_need_area", tVar.bKJ());
                bundle.putBoolean("key_need_profession", tVar.bKK());
                bundle.putParcelableArray("key_profession_list", tVar.sIM);
                if (tVar.sII == null) {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.sTx.getEncryptDataWithHash(false));
                    a.j(this, bundle);
                } else if (tVar.sII.sMx && tVar.sII.isError()) {
                    h.h(this, i.uPD, i.dGO);
                    return true;
                } else {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", tVar.sII.nBM);
                    bundle.putParcelable("elemt_query", tVar.sII);
                    bundle.putString("key_card_id", this.sTx.getEncryptDataWithHash(false));
                    a.j(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (kVar instanceof t)) {
            bundle.putString("bank_name", "");
            bundle.putBoolean("key_is_reset_with_new_card", z);
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.sTx.getEncryptDataWithHash(false));
            a.j(this, bundle);
            return true;
        }
        return false;
    }
}
