package com.tencent.mm.plugin.music.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.b;
import com.tencent.mm.plugin.music.model.h;

class MusicMainUI$1 implements OnClickListener {
    final /* synthetic */ MusicMainUI oNP;

    MusicMainUI$1(MusicMainUI musicMainUI) {
        this.oNP = musicMainUI;
    }

    public final void onClick(View view) {
        MusicMainUI.a(this.oNP);
        if (MusicMainUI.b(this.oNP).isChecked()) {
            b.xS();
            MusicMainUI.b(this.oNP).setChecked(true);
            MusicMainUI.beO();
            return;
        }
        MusicMainUI.c(this.oNP);
        if (h.bdz().bdn().Qr()) {
            h.bdz().bdn().resume();
        } else {
            h.bdz().e(null);
        }
        this.oNP.beN();
        MusicMainUI.b(this.oNP).setChecked(false);
    }
}
