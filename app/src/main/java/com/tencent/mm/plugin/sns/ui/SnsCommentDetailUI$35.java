package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.af;

class SnsCommentDetailUI$35 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ bnp rAy;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$35(SnsCommentDetailUI snsCommentDetailUI, m mVar, bnp com_tencent_mm_protocal_c_bnp) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
        this.rAy = com_tencent_mm_protocal_c_bnp;
    }

    public final void onClick(View view) {
        if (!SnsCommentDetailUI.C(this.rAr)) {
            if (SnsCommentDetailUI.A(this.rAr) != null && this.rrO.field_likeFlag == 0) {
                SnsCommentDetailUI.A(this.rAr).ek(this.rrO.field_snsId);
            }
            new af().postDelayed(new 1(this, view), (long) SnsCommentDetailUI.a(this.rAr, this.rAy, this.rrO));
        }
    }
}
