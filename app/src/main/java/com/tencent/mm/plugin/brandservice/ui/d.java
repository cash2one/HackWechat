package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a$a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class d extends a {
    private static b kFf;
    String kFg;

    public d(Object obj) {
        super(1, obj);
    }

    public final b asm() {
        if (kFf == null) {
            kFf = new 1(this);
        }
        return kFf;
    }

    public final a$a asn() {
        return new a();
    }

    public final void a(Context context, a$a com_tencent_mm_ui_base_sortview_a_a, Object... objArr) {
        if (this.data instanceof String) {
            this.kFg = (String) this.data;
        }
    }
}
