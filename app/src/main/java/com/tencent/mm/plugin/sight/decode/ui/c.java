package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.plugin.ah.a.b;
import com.tencent.mm.plugin.ah.a.e;
import com.tencent.mm.plugin.ah.a.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.z.d;
import com.tencent.mm.z.d.a;

public final class c extends k implements a {
    public int fJB = 0;
    public String hDC;
    public String imagePath;
    private d jtl = new d();
    private f kTe = null;
    public int msn = 0;
    public int qtX = 0;
    private TextView quS = null;
    private boolean quT = false;

    static /* synthetic */ void a(c cVar) {
        if (cVar.kTe.start()) {
            cVar.jtl.a(cVar);
        } else {
            cVar.btc();
        }
    }

    public c(Context context) {
        super(context, i.sdH);
    }

    protected final void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        x.d("MicroMsg.VideoPopupHelper", currentTimeMillis + " initView beg");
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        setContentView(com.tencent.mm.plugin.ah.a.f.sdy);
        if (com.tencent.mm.booter.a.wz() != null) {
            com.tencent.mm.booter.a.wz().wB();
        }
        x.d("MicroMsg.VideoPopupHelper", g.zg() + " initView: fullpath:" + this.hDC + ", imagepath:" + this.imagePath);
        this.quS = (TextView) findViewById(e.cSe);
        findViewById(e.cOg).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) findViewById(e.cUI);
        viewGroup.setBackgroundResource(b.black);
        x.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
        if (com.tencent.mm.compatible.util.d.fM(14)) {
            this.kTe = new VideoTextureView(getContext());
        } else {
            this.kTe = new VideoSurfaceView(getContext());
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        viewGroup.addView((View) this.kTe, layoutParams);
        this.kTe.a(new 1(this));
        findViewById(e.cUI).setOnClickListener(new 2(this));
        ((View) this.kTe).setOnClickListener(new 3(this));
        if (this.hDC != null) {
            this.kTe.stop();
            this.kTe.setVideoPath(this.hDC);
        }
        x.d("MicroMsg.VideoPopupHelper", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.type = 1;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
    }

    private void btc() {
        x.v("check", "onclick");
        if (this.kTe.isPlaying()) {
            this.kTe.pause();
            this.jtl.bx(false);
        }
        new af().post(new 4(this));
    }

    public final void dismiss() {
        x.d("MicroMsg.VideoPopupHelper", "on dismiss");
        if (com.tencent.mm.booter.a.wz() != null) {
            com.tencent.mm.booter.a.wz().wA();
        }
        if (this.kTe != null) {
            this.kTe.a(null);
            this.kTe.stop();
            this.kTe.onDetach();
            findViewById(e.cUI).setOnClickListener(null);
        }
        if (!this.quT && isShowing()) {
            com.tencent.mm.sdk.b.b rtVar = new rt();
            rtVar.fJy.type = 0;
            rtVar.fJy.fJz = this.qtX;
            rtVar.fJy.fJA = this.msn;
            rtVar.fJy.fJB = this.fJB;
            com.tencent.mm.sdk.b.a.xef.m(rtVar);
        }
        super.dismiss();
        this.jtl.bx(true);
    }
}
