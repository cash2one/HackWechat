package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class CardShopUI$6 implements OnClickListener {
    final /* synthetic */ CardShopUI kVo;

    CardShopUI$6(CardShopUI cardShopUI) {
        this.kVo = cardShopUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.kVo.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
