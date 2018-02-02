package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$10 implements OnClickListener {
    final /* synthetic */ e tVw;

    public e$10(e eVar) {
        this.tVw = eVar;
    }

    public final void onClick(View view) {
        x.i("NoteSelectManager", "bold");
        this.tVw.bXl();
    }
}
