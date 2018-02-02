package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.h;

class c$b implements OnClickListener {
    private String id;
    final /* synthetic */ c onu;

    public c$b(c cVar, String str) {
        this.onu = cVar;
        this.id = str;
    }

    public final void onClick(View view) {
        a Ee = h.aYD().Ee(this.id);
        Intent intent = new Intent(c.a(this.onu), MassSendMsgUI.class);
        intent.putExtra("mass_send_contact_list", Ee.aYy());
        intent.putExtra("mass_send_again", true);
        c.a(this.onu).startActivity(intent);
    }
}
