package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.ui.widget.i;

class SettingCheckUnProcessWalletConvUI$4 implements OnItemLongClickListener {
    final /* synthetic */ SettingCheckUnProcessWalletConvUI zaj;

    SettingCheckUnProcessWalletConvUI$4(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.zaj = settingCheckUnProcessWalletConvUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        aj Gt = SettingCheckUnProcessWalletConvUI.b(this.zaj).Gt(i - SettingCheckUnProcessWalletConvUI.c(this.zaj).getHeaderViewsCount());
        if (Gt == null) {
            return true;
        }
        String str = Gt.field_username;
        i iVar = new i(this.zaj);
        iVar.zum = new 1(this);
        iVar.a(view, i, j, this.zaj, new 2(this, str, Gt), SettingCheckUnProcessWalletConvUI.a(this.zaj)[0], SettingCheckUnProcessWalletConvUI.a(this.zaj)[1]);
        return true;
    }
}
