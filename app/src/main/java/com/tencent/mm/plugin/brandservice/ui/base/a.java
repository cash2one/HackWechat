package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c$b;
import java.util.List;

public abstract class a extends com.tencent.mm.ui.base.sortview.a {
    protected c$b kFx;
    public List<String> kHa;
    protected int kHb;
    protected int position;

    public a(int i, Object obj) {
        super(i, obj);
    }

    public final void a(c$b com_tencent_mm_plugin_brandservice_ui_c_b) {
        this.kFx = com_tencent_mm_plugin_brandservice_ui_c_b;
    }

    public final c$b asC() {
        return this.kFx;
    }

    public final void nz(int i) {
        this.kHb = i;
    }

    public final int asD() {
        return this.kHb;
    }

    public final void cR(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }
}
