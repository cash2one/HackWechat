package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.aqr;

class b$18 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$18(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof r) {
            r rVar = (r) view.getTag();
            aqr com_tencent_mm_protocal_c_aqr = (aqr) rVar.rsq.wQo.vYd.get(0);
            ae.bvv().Ll(rVar.frH);
            String str = "";
            String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
            String str2 = "";
            String j = i.j(com_tencent_mm_protocal_c_aqr);
            if (FileOp.bO(r + j)) {
                str = r + j;
                str2 = r + i.e(com_tencent_mm_protocal_c_aqr);
            }
            if (FileOp.bO(r + i.p(com_tencent_mm_protocal_c_aqr))) {
                str = r + i.p(com_tencent_mm_protocal_c_aqr);
                str2 = r + i.n(com_tencent_mm_protocal_c_aqr);
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            Intent intent = new Intent();
            intent.setClass(this.rPY.activity, SnsOnlineVideoActivity.class);
            intent.putExtra("intent_videopath", str);
            intent.putExtra("intent_thumbpath", str2);
            intent.putExtra("intent_localid", rVar.frH);
            intent.putExtra("intent_isad", false);
            intent.putExtra("intent_from_scene", this.rPY.scene);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            this.rPY.activity.startActivity(intent);
            this.rPY.activity.overridePendingTransition(0, 0);
            b.a(this.rPY, rVar.rsq);
        }
    }
}
