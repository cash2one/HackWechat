package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.m;

public final class a extends m {
    private a ihM;

    public a(a aVar) {
        super(2, null);
        this.ihM = aVar;
    }

    public final void onClick(View view) {
        if (this.ihM != null) {
            this.ihM.WO();
        }
    }
}
