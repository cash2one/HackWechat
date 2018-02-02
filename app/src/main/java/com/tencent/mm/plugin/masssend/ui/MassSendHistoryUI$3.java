package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.masssend.a;

class MassSendHistoryUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$3(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "masssendapp");
        a.ifs.d(intent, this.onL);
        return true;
    }
}
