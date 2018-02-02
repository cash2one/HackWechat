package com.tencent.mm.plugin.music.ui;

import android.view.View;
import com.tencent.mm.av.a;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.ui.MusicMainUI.2;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map.Entry;

class MusicMainUI$2$4 implements Runnable {
    final /* synthetic */ js oNQ;
    final /* synthetic */ 2 oNR;

    MusicMainUI$2$4(2 2, js jsVar) {
        this.oNR = 2;
        this.oNQ = jsVar;
    }

    public final void run() {
        b h = this.oNR.oNP.oNK;
        a aVar = this.oNQ.fAz.fAA;
        boolean z = false;
        for (Entry value : h.oNm.entrySet()) {
            boolean z2;
            b$a com_tencent_mm_plugin_music_ui_b_a = (b$a) ((View) value.getValue()).getTag();
            if (com_tencent_mm_plugin_music_ui_b_a.fAA.field_musicId.equals(aVar.field_musicId)) {
                com_tencent_mm_plugin_music_ui_b_a.h(aVar, true);
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (!z) {
            x.i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
            h.notifyDataSetChanged();
        }
    }
}
