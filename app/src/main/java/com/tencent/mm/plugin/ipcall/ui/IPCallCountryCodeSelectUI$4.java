package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallCountryCodeSelectUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallCountryCodeSelectUI nJx;

    IPCallCountryCodeSelectUI$4(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        this.nJx = iPCallCountryCodeSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nJx.aWs();
        Intent intent = new Intent();
        intent.putExtra("country_name", IPCallCountryCodeSelectUI.d(this.nJx));
        intent.putExtra("couttry_code", IPCallCountryCodeSelectUI.e(this.nJx));
        this.nJx.setResult(100, intent);
        this.nJx.finish();
        return true;
    }
}
