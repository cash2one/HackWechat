package com.tencent.mm.plugin.game.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.ui.GameBannerView.a;
import com.tencent.mm.sdk.platformtools.x;

final class GameBannerView$b extends u {
    final /* synthetic */ GameBannerView nlF;

    private GameBannerView$b(GameBannerView gameBannerView) {
        this.nlF = gameBannerView;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        int size = i % GameBannerView.b(this.nlF).size();
        viewGroup.removeView((View) obj);
        x.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
    }

    public final Object b(ViewGroup viewGroup, int i) {
        int size = i % GameBannerView.b(this.nlF).size();
        View inflate = View.inflate(GameBannerView.d(this.nlF), R.i.djr, null);
        inflate.setTag(GameBannerView.b(this.nlF).get(size));
        inflate.setOnClickListener(this.nlF);
        ImageView imageView = (ImageView) inflate.findViewById(R.h.ckD);
        String str = ((a) GameBannerView.b(this.nlF).get(size)).hkg;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof k)) {
            imageView.setImageDrawable(new k(str));
        } else {
            ((k) drawable).setUrl(str);
        }
        try {
            viewGroup.addView(inflate, 0);
        } catch (Exception e) {
            x.e("MicroMsg.GameBannerView", "add view failed, " + e.getMessage());
        }
        x.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
        return inflate;
    }

    public final int getCount() {
        return GameBannerView.b(this.nlF).size() <= 1 ? GameBannerView.b(this.nlF).size() : (GameBannerView.b(this.nlF).size() * 1000) * 2;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }
}
