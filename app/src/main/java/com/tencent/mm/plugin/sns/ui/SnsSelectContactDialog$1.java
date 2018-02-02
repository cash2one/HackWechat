package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class SnsSelectContactDialog$1 implements OnItemClickListener {
    final /* synthetic */ SnsSelectContactDialog rEU;

    SnsSelectContactDialog$1(SnsSelectContactDialog snsSelectContactDialog) {
        this.rEU = snsSelectContactDialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == SnsSelectContactDialog.a(this.rEU).getCount() - 1) {
            SnsSelectContactDialog.b(this.rEU);
        } else {
            SnsSelectContactDialog.c(this.rEU).remove(i);
        }
        SnsSelectContactDialog.a(this.rEU).refresh();
    }
}
