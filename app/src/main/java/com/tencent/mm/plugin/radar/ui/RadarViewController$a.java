package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import b.c.b.e;
import b.i;
import com.tencent.mm.sdk.platformtools.af;

final class RadarViewController$a {
    private int pzV;
    final boolean pzW;
    final a pzX = new a(this);
    final /* synthetic */ RadarViewController pzY;

    public static final class a extends af {
        final /* synthetic */ RadarViewController$a pzZ;

        a(RadarViewController$a radarViewController$a) {
            this.pzZ = radarViewController$a;
        }

        public final void handleMessage(Message message) {
            e.i(message, "msg");
            if (message.obj instanceof View) {
                Object obj = message.obj;
                if (obj == null) {
                    throw new i("null cannot be cast to non-null type android.view.View");
                }
                View view = (View) obj;
                view.setVisibility(0);
                view.clearAnimation();
                if (!this.pzZ.pzW) {
                    Object tag = view.getTag(RadarViewController.b(this.pzZ.pzY));
                    if (!(tag instanceof Animation)) {
                        tag = null;
                    }
                    Animation animation = (Animation) tag;
                    if (animation == null) {
                        animation = this.pzZ.getInAnimation();
                    }
                    view.startAnimation(animation);
                }
            }
        }
    }

    public RadarViewController$a(RadarViewController radarViewController) {
        this.pzY = radarViewController;
        g gVar = g.pzC;
        Context context = radarViewController.getContext();
        e.h(context, "context");
        this.pzW = g.do(context);
    }

    public final Animation getInAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.pzY.getContext(), com.tencent.mm.plugin.radar.a.a.pvr);
        e.h(loadAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
        return loadAnimation;
    }

    public final int bmj() {
        this.pzV++;
        return this.pzV;
    }

    public final void h(int i, View view) {
        e.i(view, "view");
        Message obtainMessage = this.pzX.obtainMessage();
        obtainMessage.what = cq(view);
        obtainMessage.obj = view;
        view.setVisibility(4);
        this.pzX.sendMessageDelayed(obtainMessage, (long) ((i + 1) * 500));
    }

    final int cq(View view) {
        Object tag = view.getTag(RadarViewController.a(this.pzY));
        if (!(tag instanceof Integer)) {
            tag = null;
        }
        Integer num = (Integer) tag;
        return num != null ? num.intValue() : -1;
    }
}
