package com.tencent.mm.pluginsdk.ui.chat;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements Runnable {
    final /* synthetic */ i vry;
    final /* synthetic */ af vrz;

    i$3(i iVar, af afVar) {
        this.vry = iVar;
        this.vrz = afVar;
    }

    public final void run() {
        boolean z = true;
        i iVar = this.vry;
        String cca = iVar.cca();
        if (cca == null) {
            z = false;
        } else {
            int Cp = (int) iVar.Cp(70);
            int Cp2 = (int) iVar.Cp(120);
            int UJ = ExifHelper.UJ(cca);
            if (UJ == 90 || UJ == 270) {
                int i = Cp;
                Cp = Cp2;
                Cp2 = i;
            }
            int Cp3 = (int) iVar.Cp(4);
            Bitmap a = d.a(cca, Cp2, Cp, true, null, 0);
            if (a != null) {
                iVar.bitmap = d.a(d.b(a, (float) UJ), true, (float) Cp3);
                iVar.gZO.edit().putString("chattingui_recent_shown_image_path", iVar.vrt.vrr).commit();
                x.d("MicroMsg.RecentImageBubble", "check ok");
            } else {
                x.e("MicroMsg.RecentImageBubble", "image hits hole.");
                z = false;
            }
        }
        if (z) {
            this.vrz.sendEmptyMessage(0);
        } else {
            x.d("MicroMsg.RecentImageBubble", "check false");
        }
    }

    public final String toString() {
        return super.toString() + "|checkIfShow";
    }
}
