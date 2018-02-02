package com.tencent.mm.plugin.wallet_core.ui.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import d.a.a.d;

@a(3)
public class WalletSuccPageAwardLuckyMoneyDialog extends MMActivity {
    private ViewGroup sYa;
    private ImageView sYb;
    private d sYc;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (com.tencent.mm.compatible.util.d.fM(19)) {
            getWindow().setFlags(67108864, 67108864);
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_layer_info");
        if (byteArrayExtra == null) {
            x.e("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", "WalletSuccPageAwardLuckyMoneyDialog onCreate error! cannot get layerInfoBytes!");
            finish();
        }
        this.sYc = new d();
        try {
            this.sYc.aF(byteArrayExtra);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", e, "parse layer info byte error! %s", new Object[]{e.getMessage()});
            finish();
        }
        this.sYa = (ViewGroup) findViewById(f.bYO);
        this.sYb = (ImageView) findViewById(f.bWk);
        this.sYb.setOnClickListener(new 1(this));
        final View view = this.sYa;
        AnimationListener 2 = new 2(this);
        Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ WalletSuccPageAwardLuckyMoneyDialog sYd;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                view.startAnimation(scaleAnimation2);
            }
        });
        scaleAnimation2.setAnimationListener(2);
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    protected final int getLayoutId() {
        return g.uFR;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
