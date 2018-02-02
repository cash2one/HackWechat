package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h$c;

class VideoAdPlayerUI$3 implements OnClickListener {
    final /* synthetic */ VideoAdPlayerUI rNx;

    VideoAdPlayerUI$3(VideoAdPlayerUI videoAdPlayerUI) {
        this.rNx = videoAdPlayerUI;
    }

    public final void onClick(View view) {
        String[] l;
        Context context = this.rNx;
        if (VideoAdPlayerUI.k(this.rNx)) {
            l = VideoAdPlayerUI.l(this.rNx);
        } else {
            l = VideoAdPlayerUI.m(this.rNx);
        }
        h.a(context, null, l, null, new h$c(this) {
            final /* synthetic */ VideoAdPlayerUI$3 rNy;

            {
                this.rNy = r1;
            }

            public final void jl(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        intent.putExtra("mutil_select_is_ret", true);
                        intent.putExtra("ad_video_title", VideoAdPlayerUI.n(this.rNy.rNx));
                        intent.putExtra("Retr_Msg_Type", 2);
                        d.a(this.rNy.rNx, ".ui.transmit.SelectConversationUI", intent, 4097);
                        return;
                    case 1:
                        VideoAdPlayerUI.o(this.rNy.rNx);
                        return;
                    case 2:
                        VideoAdPlayerUI.p(this.rNy.rNx);
                        return;
                    default:
                        return;
                }
            }
        });
    }
}
