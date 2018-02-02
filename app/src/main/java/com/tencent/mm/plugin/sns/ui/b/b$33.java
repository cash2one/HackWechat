package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.i;

class b$33 implements OnLongClickListener {
    final /* synthetic */ b rPY;

    b$33(b bVar) {
        this.rPY = bVar;
    }

    public final boolean onLongClick(View view) {
        String str = (String) view.getTag();
        x.d("MicroMsg.TimelineClickListener", "onCommentLongClick:" + str);
        if (bh.ov(str)) {
            return true;
        }
        if (str.equals(ae.bvb())) {
            return true;
        }
        String str2;
        int i;
        if (((MaskImageButton) view).zlH == null || !(((MaskImageButton) view).zlH instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) ((MaskImageButton) view).zlH;
        }
        Intent intent = new Intent();
        m Lm = ae.bvv().Lm(str2);
        if (Lm == null || !Lm.xl(32)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            return false;
        }
        i iVar = new i(this.rPY.activity, view);
        iVar.zum = new 1(this);
        iVar.rKD = new 2(this, Lm, str, str2);
        int[] iArr = new int[2];
        if (view.getTag(e.cSF) instanceof int[]) {
            iArr = (int[]) view.getTag(e.cSF);
        }
        iVar.bQ(iArr[0], iArr[1]);
        return false;
    }
}
