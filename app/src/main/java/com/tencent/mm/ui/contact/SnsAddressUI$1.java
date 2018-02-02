package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

class SnsAddressUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsAddressUI yUF;

    SnsAddressUI$1(SnsAddressUI snsAddressUI) {
        this.yUF = snsAddressUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        List F = bh.F((String[]) SnsAddressUI.a(this.yUF).toArray(new String[0]));
        if (F == null || F.size() == 0) {
            intent.putExtra("Select_Contact", "");
        } else {
            intent.putExtra("Select_Contact", bh.d(F, ","));
        }
        this.yUF.setResult(-1, intent);
        this.yUF.finish();
        ag.h(new 1(this), 100);
        return true;
    }
}
