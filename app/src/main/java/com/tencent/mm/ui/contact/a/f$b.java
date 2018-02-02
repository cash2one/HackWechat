package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;

public class f$b extends b {
    final /* synthetic */ f yVu;

    public f$b(f fVar) {
        this.yVu = fVar;
        super(fVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(f.qfA, viewGroup, false);
        f$a com_tencent_mm_ui_contact_a_f_a = (f$a) this.yVu.yVt;
        com_tencent_mm_ui_contact_a_f_a.iir = (TextView) inflate.findViewById(e.caS);
        com_tencent_mm_ui_contact_a_f_a.tEX = inflate.findViewById(e.qfo);
        inflate.setTag(com_tencent_mm_ui_contact_a_f_a);
        return inflate;
    }

    public final void a(Context context, a aVar, a aVar2, boolean z, boolean z2) {
        f$a com_tencent_mm_ui_contact_a_f_a = (f$a) aVar;
        com.tencent.mm.plugin.fts.d.e.a(f.a((f) aVar2), com_tencent_mm_ui_contact_a_f_a.iir);
        if (this.yVu.position == 0) {
            com_tencent_mm_ui_contact_a_f_a.tEX.setVisibility(8);
        } else {
            com_tencent_mm_ui_contact_a_f_a.tEX.setVisibility(0);
        }
    }

    public final boolean WS() {
        return false;
    }
}
