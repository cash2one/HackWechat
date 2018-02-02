package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class ContactLabelManagerUI$12 implements OnItemLongClickListener {
    final /* synthetic */ ContactLabelManagerUI nPj;

    ContactLabelManagerUI$12(ContactLabelManagerUI contactLabelManagerUI) {
        this.nPj = contactLabelManagerUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ContactLabelManagerUI.f(this.nPj).a(view, i, j, this.nPj, this.nPj, ContactLabelManagerUI.d(this.nPj), ContactLabelManagerUI.e(this.nPj));
        return true;
    }
}
