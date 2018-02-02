package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class AlbumPreviewUI$4 implements OnScrollListener {
    final /* synthetic */ AlbumPreviewUI mSQ;
    private Runnable mSS = new 1(this);

    AlbumPreviewUI$4(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    private void fq(boolean z) {
        if (z) {
            AlbumPreviewUI.x(this.mSQ).removeCallbacks(this.mSS);
            if (AlbumPreviewUI.x(this.mSQ).getVisibility() != 0) {
                AlbumPreviewUI.x(this.mSQ).setText(AlbumPreviewUI.a(this.mSQ).qt(AlbumPreviewUI.y(this.mSQ).getFirstVisiblePosition()));
                AlbumPreviewUI.x(this.mSQ).clearAnimation();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mSQ.mController.xIM, R.a.bpZ);
                AlbumPreviewUI.x(this.mSQ).setVisibility(0);
                AlbumPreviewUI.x(this.mSQ).startAnimation(loadAnimation);
                return;
            }
            return;
        }
        AlbumPreviewUI.x(this.mSQ).removeCallbacks(this.mSS);
        AlbumPreviewUI.x(this.mSQ).postDelayed(this.mSS, 256);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        x.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[]{Integer.valueOf(i)});
        if (1 == i) {
            fq(true);
        } else if (i == 0) {
            fq(false);
        }
        if (2 == i) {
            try {
                AlbumPreviewUI.b(this.mSQ).qq(AlbumPreviewUI.z(this.mSQ));
                AlbumPreviewUI.c(this.mSQ, AlbumPreviewUI.b(this.mSQ).aOl());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlbumPreviewUI.x(this.mSQ).setText(AlbumPreviewUI.a(this.mSQ).qt(i));
    }
}
