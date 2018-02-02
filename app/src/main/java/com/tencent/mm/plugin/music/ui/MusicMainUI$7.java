package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.model.g.c.a;

class MusicMainUI$7 implements a {
    final /* synthetic */ MusicMainUI oNP;

    MusicMainUI$7(MusicMainUI musicMainUI) {
        this.oNP = musicMainUI;
    }

    public final void cj(int i, int i2) {
        if (MusicMainUI.l(this.oNP) == 1 && !MusicMainUI.m(this.oNP)) {
            float floatExtra = this.oNP.getIntent().getFloatExtra("key_offset", 0.0f);
            floatExtra *= 1000.0f;
            long currentTimeMillis = (long) (floatExtra + ((float) (System.currentTimeMillis() - this.oNP.getIntent().getLongExtra("music_player_beg_time", 0))));
            if (currentTimeMillis >= 0) {
                MusicMainUI.h(this.oNP).C(MusicMainUI.i(this.oNP).yF, currentTimeMillis + 200);
            }
        } else if (i >= 0 && i2 > 0) {
            MusicMainUI.h(this.oNP).C(MusicMainUI.i(this.oNP).yF, (long) i);
        }
    }
}
