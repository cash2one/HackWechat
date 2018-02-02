package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.R;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ar;

class MusicMainUI$2 extends c<js> {
    final /* synthetic */ MusicMainUI oNP;

    MusicMainUI$2(MusicMainUI musicMainUI) {
        this.oNP = musicMainUI;
        this.xen = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        switch (jsVar.fAz.action) {
            case 0:
            case 1:
                MusicMainUI.b(this.oNP).setChecked(false);
                ag.y(new 1(this, jsVar));
                break;
            case 2:
            case 3:
            case 4:
                MusicMainUI.b(this.oNP).setChecked(true);
                break;
            case 5:
                ar.H(this.oNP.mController.xIM, R.l.eOB);
                ag.y(new 3(this));
                break;
            case 6:
                ag.y(new 4(this, jsVar));
                break;
            case 7:
                if (h.bdz().mode == 2) {
                    ag.y(new 2(this));
                    break;
                }
                break;
            case 13:
                if (h.bdz().mode == 2) {
                    ag.y(new 5(this));
                    break;
                }
                break;
            case 14:
                if (h.bdz().mode == 2) {
                    ag.y(new 6(this));
                    break;
                }
                break;
        }
        return false;
    }
}
