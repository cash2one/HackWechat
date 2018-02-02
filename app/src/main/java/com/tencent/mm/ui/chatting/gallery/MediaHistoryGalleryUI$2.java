package com.tencent.mm.ui.chatting.gallery;

import android.os.Process;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.a.a.c;

class MediaHistoryGalleryUI$2 extends k {
    private Runnable mSS = new Runnable(this) {
        final /* synthetic */ MediaHistoryGalleryUI$2 yGP;

        {
            this.yGP = r1;
        }

        public final void run() {
            MediaHistoryGalleryUI.a(this.yGP.yGO).startAnimation(AnimationUtils.loadAnimation(this.yGP.yGO.mController.xIM, R.a.bqa));
            MediaHistoryGalleryUI.a(this.yGP.yGO).setVisibility(8);
        }
    };
    final /* synthetic */ MediaHistoryGalleryUI yGO;

    MediaHistoryGalleryUI$2(MediaHistoryGalleryUI mediaHistoryGalleryUI) {
        this.yGO = mediaHistoryGalleryUI;
    }

    private void fq(boolean z) {
        if (z) {
            MediaHistoryGalleryUI.a(this.yGO).removeCallbacks(this.mSS);
            if (MediaHistoryGalleryUI.a(this.yGO).getVisibility() != 0) {
                MediaHistoryGalleryUI.a(this.yGO).clearAnimation();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.yGO.mController.xIM, R.a.bpZ);
                MediaHistoryGalleryUI.a(this.yGO).setVisibility(0);
                MediaHistoryGalleryUI.a(this.yGO).startAnimation(loadAnimation);
                return;
            }
            return;
        }
        MediaHistoryGalleryUI.a(this.yGO).removeCallbacks(this.mSS);
        MediaHistoryGalleryUI.a(this.yGO).postDelayed(this.mSS, 256);
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        a aVar = (a) MediaHistoryGalleryUI.b(this.yGO).cug();
        c FC = aVar.FC(((LinearLayoutManager) MediaHistoryGalleryUI.b(this.yGO).fM(this.yGO)).eZ());
        if (FC != null) {
            MediaHistoryGalleryUI.a(this.yGO).setText(bh.az(aVar.gb(FC.hOG), ""));
        }
    }

    public final void e(RecyclerView recyclerView, int i) {
        if (1 == i) {
            fq(true);
            HardCoderJNI.stopPerformace(HardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.c(this.yGO));
            MediaHistoryGalleryUI.a(this.yGO, HardCoderJNI.startPerformance(HardCoderJNI.hcMediaGalleryScrollEnable, HardCoderJNI.hcMediaGalleryScrollDelay, HardCoderJNI.hcMediaGalleryScrollCPU, HardCoderJNI.hcMediaGalleryScrollIO, HardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, HardCoderJNI.hcMediaGalleryScrollTimeout, 703, HardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI"));
        } else if (i == 0) {
            fq(false);
        }
        if (recyclerView.TV instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) recyclerView.TV).eZ() == 0) {
                MediaHistoryGalleryUI.b(this.yGO).y(false, -1);
            }
            o.PA().bp(i);
        }
    }
}
