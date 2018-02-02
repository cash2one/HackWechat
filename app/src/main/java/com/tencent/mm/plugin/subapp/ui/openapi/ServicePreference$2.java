package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class ServicePreference$2 implements OnItemLongClickListener {
    final /* synthetic */ ServicePreference rXZ;

    ServicePreference$2(ServicePreference servicePreference) {
        this.rXZ = servicePreference;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ServicePreference servicePreference = this.rXZ;
        if (servicePreference.rXY != null) {
            servicePreference.rXY.iR(!servicePreference.rXY.rXA);
        }
        return true;
    }
}
