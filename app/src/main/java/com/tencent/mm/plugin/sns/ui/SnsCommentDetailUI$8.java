package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;

class SnsCommentDetailUI$8 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$8(SnsCommentDetailUI snsCommentDetailUI, m mVar) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
    }

    public final void onClick(View view) {
        if (!this.rrO.xl(32)) {
            ai.wJ(this.rrO.roJ);
            ai.wH(this.rrO.roJ);
            ae.bvr().buj();
            Intent intent = new Intent();
            this.rAr.setResult(-1, intent);
            if (SnsCommentDetailUI.r(this.rAr)) {
                intent.putExtra("sns_gallery_force_finish", true);
            }
            this.rAr.finish();
            this.rAr.finish();
        }
    }
}
