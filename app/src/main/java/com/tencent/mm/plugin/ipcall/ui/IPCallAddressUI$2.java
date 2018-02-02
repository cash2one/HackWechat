package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.ipcall.b;

class IPCallAddressUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallAddressUI nID;

    IPCallAddressUI$2(IPCallAddressUI iPCallAddressUI) {
        this.nID = iPCallAddressUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (IPCallAddressUI.b(this.nID) == 1) {
            b.ifs.s(new Intent(), this.nID);
        } else {
            this.nID.finish();
        }
        return true;
    }
}
