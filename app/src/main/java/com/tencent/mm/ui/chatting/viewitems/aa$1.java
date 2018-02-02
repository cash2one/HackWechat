package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.ax.a;
import com.tencent.mm.ax.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

class aa$1 extends az {
    final /* synthetic */ au heR;
    final /* synthetic */ int kI;
    final /* synthetic */ a yBX;
    final /* synthetic */ int yLk;
    final /* synthetic */ b yMN;
    final /* synthetic */ ac.b yMO;
    final /* synthetic */ aa yMP;

    aa$1(aa aaVar, int i, int i2, a aVar, b bVar, ac.b bVar2, au auVar, int i3, int i4) {
        this.yMP = aaVar;
        this.yBX = aVar;
        this.yMN = bVar;
        this.yMO = bVar2;
        this.heR = auVar;
        this.kI = i3;
        this.yLk = i4;
        super(i, i2);
    }

    public final void onClick(View view) {
        x.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[]{this.yBX});
        this.yMN.a(this.yMO.mUL, this.heR, this.yBX, this.yLk);
    }
}
