package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.masssend.a;

class MassSendHistoryUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$2(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (MassSendHistoryUI.g(this.onL)) {
            this.onL.finish();
        } else {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            a.ifs.s(intent, this.onL);
            this.onL.finish();
        }
        return true;
    }
}
