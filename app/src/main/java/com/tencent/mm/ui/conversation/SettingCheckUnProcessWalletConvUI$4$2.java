package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.4;

class SettingCheckUnProcessWalletConvUI$4$2 implements p$d {
    final /* synthetic */ String gIx;
    final /* synthetic */ ae xym;
    final /* synthetic */ 4 zak;

    SettingCheckUnProcessWalletConvUI$4$2(4 4, String str, ae aeVar) {
        this.zak = 4;
        this.gIx = str;
        this.xym = aeVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 1) {
            b.a(this.gIx, this.zak.zaj, this.xym, new Runnable(this) {
                final /* synthetic */ SettingCheckUnProcessWalletConvUI$4$2 zal;

                {
                    this.zal = r1;
                }

                public final void run() {
                    SettingCheckUnProcessWalletConvUI.d(this.zal.zak.zaj).remove(this.zal.gIx);
                    SettingCheckUnProcessWalletConvUI.b(this.zal.zak.zaj).notifyDataSetChanged();
                }
            }, false, true);
        }
    }
}
