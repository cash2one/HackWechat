package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class CountryCodeUI$7 implements OnItemClickListener {
    final /* synthetic */ CountryCodeUI zgY;

    CountryCodeUI$7(CountryCodeUI countryCodeUI) {
        this.zgY = countryCodeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        if (i >= CountryCodeUI.b(this.zgY).getHeaderViewsCount()) {
            c cVar = (c) CountryCodeUI.c(this.zgY).getItem(i - CountryCodeUI.b(this.zgY).getHeaderViewsCount());
            intent.putExtra("country_name", cVar.hEx);
            intent.putExtra("couttry_code", cVar.countryCode);
            this.zgY.setResult(100, intent);
        }
        this.zgY.finish();
    }
}
