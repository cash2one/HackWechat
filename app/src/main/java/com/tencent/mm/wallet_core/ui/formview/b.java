package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class b {
    private static int zIM = 0;
    private static int zIN = 0;
    private static final int zJE = f.uyI;

    static void a(TenpaySecureEditText tenpaySecureEditText, int i) {
        if (tenpaySecureEditText == null) {
            x.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
        } else if (i == 1) {
            tenpaySecureEditText.setIsPasswordFormat(true);
        } else if (i == 2) {
            tenpaySecureEditText.setIsSecurityAnswerFormat(true);
        } else if (i == 3) {
            tenpaySecureEditText.setIsCvvPaymentFormat(true);
        } else if (i == 4) {
            tenpaySecureEditText.setIsCvv4PaymentFormat(true);
        } else if (i == 5) {
            tenpaySecureEditText.setIsValidThru(true);
        } else if (i == 6) {
            tenpaySecureEditText.setIsBankcardFormat(true);
        } else if (i == 7) {
            tenpaySecureEditText.setIsMoneyAmountFormat(true);
        } else if (i == 8) {
            tenpaySecureEditText.setIsIdCardTailFormat(true);
        } else {
            tenpaySecureEditText.setIsCvv4PaymentFormat(false);
        }
    }

    public static void f(MMActivity mMActivity, WalletFormView walletFormView) {
        walletFormView.setOnClickListener(new 1(walletFormView, mMActivity));
    }

    public static void a(MMActivity mMActivity, int i, int i2) {
        if (i != -1) {
            mMActivity.addDialog(com.tencent.mm.wallet_core.ui.b.a(mMActivity, i, mMActivity.getResources().getString(i2), mMActivity.getResources().getString(i.uRP), new 2()));
        }
    }
}
