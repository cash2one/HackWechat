package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.card.a.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.z.ar;

class CardShopUI$3 implements OnCancelListener {
    final /* synthetic */ CardShopUI kVo;

    CardShopUI$3(CardShopUI cardShopUI) {
        this.kVo = cardShopUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        n auD = am.auD();
        auD.a(CardShopUI.d(this.kVo), this.kVo);
        if (auD.kJK != null) {
            ar.CG().c(auD.kJK);
        }
    }
}
