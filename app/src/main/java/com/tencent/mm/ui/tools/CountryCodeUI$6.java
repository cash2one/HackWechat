package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CountryCodeUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ CountryCodeUI zgY;

    CountryCodeUI$6(CountryCodeUI countryCodeUI) {
        this.zgY = countryCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zgY.aWs();
        Intent intent = new Intent();
        intent.putExtra("country_name", CountryCodeUI.d(this.zgY));
        intent.putExtra("couttry_code", CountryCodeUI.e(this.zgY));
        this.zgY.setResult(100, intent);
        this.zgY.finish();
        return true;
    }
}
