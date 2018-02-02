package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class IPCallCountryCodeSelectUI$5 implements OnItemClickListener {
    final /* synthetic */ IPCallCountryCodeSelectUI nJx;

    IPCallCountryCodeSelectUI$5(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        this.nJx = iPCallCountryCodeSelectUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        if (i >= IPCallCountryCodeSelectUI.b(this.nJx).getHeaderViewsCount()) {
            a aVar = (a) IPCallCountryCodeSelectUI.c(this.nJx).getItem(i - IPCallCountryCodeSelectUI.b(this.nJx).getHeaderViewsCount());
            intent.putExtra("country_name", aVar.hEx);
            intent.putExtra("couttry_code", aVar.countryCode);
            this.nJx.setResult(100, intent);
        }
        this.nJx.finish();
    }
}
