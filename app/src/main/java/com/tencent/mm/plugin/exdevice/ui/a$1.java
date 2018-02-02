package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class a$1 implements OnClickListener {
    final /* synthetic */ a lVf;

    a$1(a aVar) {
        this.lVf = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", a.a(this.lVf));
        d.b(a.b(this.lVf), "profile", ".ui.ContactInfoUI", intent);
    }
}
