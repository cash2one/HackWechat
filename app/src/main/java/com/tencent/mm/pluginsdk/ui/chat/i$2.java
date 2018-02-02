package com.tencent.mm.pluginsdk.ui.chat;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;

class i$2 extends af {
    final /* synthetic */ i vry;

    i$2(i iVar, Looper looper) {
        this.vry = iVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        i iVar = this.vry;
        if (iVar.fyg != null && iVar.vrt != null && iVar.bitmap != null && iVar.vru != null && iVar.rno != null && iVar.nVo != null) {
            iVar.fyg.setImageBitmap(iVar.bitmap);
            int i = iVar.vrv ? 83 : 85;
            int i2 = iVar.vrv ? 0 : 10;
            int cbW = iVar.vrw != null ? iVar.vrw.cbW() : iVar.nVo.getHeight();
            if (VERSION.SDK_INT >= 21) {
                Rect cnF = ae.cnF();
                i2 = iVar.vrv ? 0 : i2 + cnF.right;
                cbW += cnF.bottom;
                x.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", new Object[]{Integer.valueOf(cnF.right), Integer.valueOf(cnF.bottom)});
            }
            iVar.vru.showAtLocation(iVar.rno, i, i2, cbW);
            new ak(new i$4(iVar), false).J(10000, 10000);
        }
    }
}
