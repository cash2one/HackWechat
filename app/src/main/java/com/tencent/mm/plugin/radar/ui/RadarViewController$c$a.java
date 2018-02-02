package com.tencent.mm.plugin.radar.ui;

import android.widget.ImageView;
import android.widget.TextView;
import b.c.b.e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.c;

public final class RadarViewController$c$a {
    TextView pAh;
    ImageView pAi;
    RadarStateView pAj;
    RadarStateChooseView pAk;
    ImageView pAl;
    final /* synthetic */ c pAm;

    public RadarViewController$c$a(c cVar, TextView textView, ImageView imageView, RadarStateView radarStateView, RadarStateChooseView radarStateChooseView, ImageView imageView2) {
        e.i(textView, "tvMemberName");
        e.i(imageView, "ivMemberAvatar");
        e.i(radarStateView, "vMemberState");
        e.i(radarStateChooseView, "vMemberChooseState");
        e.i(imageView2, "ivMemberAvatarMask");
        this.pAm = cVar;
        this.pAh = textView;
        this.pAi = imageView;
        this.pAj = radarStateView;
        this.pAk = radarStateChooseView;
        this.pAl = imageView2;
    }
}
