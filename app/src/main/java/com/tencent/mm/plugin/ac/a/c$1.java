package com.tencent.mm.plugin.ac.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.b;

class c$1 implements OnClickListener {
    final /* synthetic */ l pvd;
    final /* synthetic */ int pve;
    final /* synthetic */ int pvf;
    final /* synthetic */ c$a pvg;
    final /* synthetic */ Intent val$intent;

    c$1(Intent intent, l lVar, int i, int i2, c$a com_tencent_mm_plugin_ac_a_c_a) {
        this.val$intent = intent;
        this.pvd = lVar;
        this.pve = i;
        this.pvf = i2;
        this.pvg = com_tencent_mm_plugin_ac_a_c_a;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.val$intent.putExtra("title", this.pvd.getTitle());
        this.val$intent.putExtra("rawUrl", this.pvd.RE());
        if (this.pve == 2) {
            this.val$intent.putExtra("stastic_scene", 13);
        } else if (this.pve == 1) {
            this.val$intent.putExtra("stastic_scene", 14);
        } else {
            this.val$intent.putExtra("stastic_scene", 11);
        }
        this.val$intent.putExtra("pay_channel", c.vg(this.pvf));
        this.val$intent.putExtra("geta8key_session_id", this.pvd.RM());
        this.val$intent.putExtra("geta8key_cookie", this.pvd.RN());
        b.ifs.j(this.val$intent, this.pvg.getContext());
    }
}
