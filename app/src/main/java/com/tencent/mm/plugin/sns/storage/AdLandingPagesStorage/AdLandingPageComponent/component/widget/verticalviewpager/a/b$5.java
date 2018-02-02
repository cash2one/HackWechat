package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.animation.AlphaAnimation;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements d$a {
    final /* synthetic */ b rnf;
    final /* synthetic */ AlphaAnimation rnk;

    b$5(b bVar, AlphaAnimation alphaAnimation) {
        this.rnf = bVar;
        this.rnk = alphaAnimation;
    }

    public final void bxc() {
    }

    public final void bxd() {
        x.d("ContentFragment", "onDownloadError show nextBtn");
        b.a(this.rnf).rnq.setVisibility(0);
        b.a(this.rnf).rnq.startAnimation(this.rnk);
    }

    public final void KY(String str) {
        x.d("ContentFragment", "onDownloaded show nextBtn");
        b.a(this.rnf, str, b.a(this.rnf).rnq);
        b.a(this.rnf).rnq.setVisibility(0);
        b.a(this.rnf).rnq.startAnimation(this.rnk);
    }
}
