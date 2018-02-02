package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShowQRCodeStep1UI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShowQRCodeStep1UI qgN;

    ShowQRCodeStep1UI$2(ShowQRCodeStep1UI showQRCodeStep1UI) {
        this.qgN = showQRCodeStep1UI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Context context = this.qgN;
        h.a(context, "", new String[]{context.getString(R.l.eJw), context.getString(R.l.eJA)}, "", false, new ShowQRCodeStep1UI$4(context));
        return true;
    }
}
