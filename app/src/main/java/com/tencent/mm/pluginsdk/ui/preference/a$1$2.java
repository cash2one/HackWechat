package com.tencent.mm.pluginsdk.ui.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.pluginsdk.ui.preference.a.1;

class a$1$2 implements OnClickListener {
    final /* synthetic */ 1 vta;
    final /* synthetic */ EditText vtb;

    a$1$2(1 1, EditText editText) {
        this.vta = 1;
        this.vtb = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String trim = this.vtb.getText().toString().trim();
        if (trim != null && trim.length() > 0) {
            a.a(this.vta.vsY, trim);
        }
    }
}
