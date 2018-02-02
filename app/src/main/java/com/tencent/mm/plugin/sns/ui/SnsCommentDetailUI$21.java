package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.util.LinkedList;

class SnsCommentDetailUI$21 implements OnAttachStateChangeListener {
    final /* synthetic */ SnsCommentDetailUI rAr;
    boolean rAx = false;
    final /* synthetic */ bnp rAy;
    final /* synthetic */ LinkedList rAz;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$21(SnsCommentDetailUI snsCommentDetailUI, bnp com_tencent_mm_protocal_c_bnp, m mVar, LinkedList linkedList) {
        this.rAr = snsCommentDetailUI;
        this.rAy = com_tencent_mm_protocal_c_bnp;
        this.rrO = mVar;
        this.rAz = linkedList;
    }

    public final void onViewAttachedToWindow(View view) {
        x.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[]{Boolean.valueOf(this.rAx)});
        if (this.rAx) {
            this.rAx = false;
            if (this.rAy != null && this.rrO != null && this.rAr.rAn != null) {
                ar z = SnsCommentDetailUI.z(this.rAr);
                PhotosContent photosContent = this.rAr.rAn;
                bnp com_tencent_mm_protocal_c_bnp = this.rAy;
                String byq = this.rrO.byq();
                SnsCommentDetailUI.x(this.rAr);
                int hashCode = this.rAr.hashCode();
                int y = SnsCommentDetailUI.y(this.rAr);
                this.rrO.xl(32);
                z.a(photosContent, com_tencent_mm_protocal_c_bnp, byq, hashCode, y, -1, false, an.xyX, this.rAz);
            }
        }
    }

    public final void onViewDetachedFromWindow(View view) {
        x.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
        this.rAx = true;
    }
}
