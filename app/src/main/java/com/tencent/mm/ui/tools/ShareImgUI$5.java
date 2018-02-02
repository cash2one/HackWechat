package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.ShareImgUI.b;
import java.util.ArrayList;

class ShareImgUI$5 implements Runnable {
    final /* synthetic */ ShareImgUI zmI;
    final /* synthetic */ b zmJ;
    final /* synthetic */ ArrayList zmQ;

    ShareImgUI$5(ShareImgUI shareImgUI, b bVar, ArrayList arrayList) {
        this.zmI = shareImgUI;
        this.zmJ = bVar;
        this.zmQ = arrayList;
    }

    public final void run() {
        this.zmJ.al(this.zmQ);
    }
}
