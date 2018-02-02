package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class i$3 implements d {
    final /* synthetic */ i nai;

    i$3(i iVar) {
        this.nai = iVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (!this.nai.mYx.isFinishing() && !this.nai.mYx.xIq) {
            if (i.h(menuItem)) {
                menuItem.getMenuInfo();
                return;
            }
            switch (menuItem.getItemId()) {
                case 1:
                    this.nai.aPD();
                    return;
                case 2:
                    this.nai.aPE();
                    return;
                case 3:
                    this.nai.aPK();
                    return;
                case 6:
                    this.nai.aPF();
                    return;
                case 7:
                    this.nai.aPI();
                    return;
                case 9:
                    this.nai.aPL();
                    return;
                case 10:
                    this.nai.aPM();
                    return;
                case 12:
                    i.a(this.nai);
                    return;
                case 27:
                    this.nai.aPC();
                    return;
                case 28:
                    this.nai.refresh();
                    return;
                case 29:
                    this.nai.aPJ();
                    return;
                case 30:
                    this.nai.aPG();
                    return;
                case 31:
                    this.nai.mZP.mWG.fy(true);
                    return;
                case 32:
                    this.nai.aPH();
                    return;
                default:
                    return;
            }
        }
    }
}
