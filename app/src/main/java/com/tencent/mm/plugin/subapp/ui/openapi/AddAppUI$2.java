package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AddAppUI$2 implements OnItemClickListener {
    final /* synthetic */ AddAppUI rXz;

    AddAppUI$2(AddAppUI addAppUI) {
        this.rXz = addAppUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AddAppUI.a(this.rXz, AddAppUI.a(this.rXz).yg(i).field_appId);
    }
}
