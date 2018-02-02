package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class AppPreference$2 implements OnItemLongClickListener {
    final /* synthetic */ AppPreference rXK;

    AppPreference$2(AppPreference appPreference) {
        this.rXK = appPreference;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppPreference appPreference = this.rXK;
        if (appPreference.rXD != null) {
            appPreference.rXD.iR(!appPreference.rXD.rXA);
        }
        return true;
    }
}
