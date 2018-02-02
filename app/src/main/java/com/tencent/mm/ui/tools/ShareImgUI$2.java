package com.tencent.mm.ui.tools;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

class ShareImgUI$2 implements ShareImgUI$b {
    final /* synthetic */ ShareImgUI zmI;

    ShareImgUI$2(ShareImgUI shareImgUI) {
        this.zmI = shareImgUI;
    }

    public final void al(ArrayList<String> arrayList) {
        this.zmI.zgG = arrayList;
        if (this.zmI.zgG == null || this.zmI.zgG.size() == 0) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
            ShareImgUI.b(this.zmI);
            this.zmI.finish();
            return;
        }
        Iterator it = this.zmI.zgG.iterator();
        while (it.hasNext()) {
            if (p.UR((String) it.next())) {
                x.i("MicroMsg.ShareImgUI", "%s is not image", new Object[]{(String) it.next()});
                ShareImgUI.b(this.zmI);
                this.zmI.finish();
                return;
            }
        }
        String resolveType = this.zmI.getIntent().resolveType(this.zmI);
        if (resolveType == null || !resolveType.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            x.i("MicroMsg.ShareImgUI", "mime type is no timage, try to set it");
            this.zmI.getIntent().setDataAndType(this.zmI.getIntent().getData(), "image/*");
        }
        ShareImgUI.c(this.zmI);
    }
}
