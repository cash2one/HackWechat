package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AddAppUI$4 implements OnItemClickListener {
    final /* synthetic */ AddAppUI rXz;

    AddAppUI$4(AddAppUI addAppUI) {
        this.rXz = addAppUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AddAppUI.a(this.rXz, AddAppUI.b(this.rXz).yg(i).field_appId);
    }
}
