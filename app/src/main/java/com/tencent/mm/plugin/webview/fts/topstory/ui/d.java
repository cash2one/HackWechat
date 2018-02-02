package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.fts.topstory.a.b;
import com.tencent.mm.plugin.webview.fts.topstory.ui.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    static d tof;
    boolean nbV;
    b tog;
    boolean toh;
    f toi;
    ViewGroup toj;

    public static d bPB() {
        if (tof == null) {
            tof = new d();
        }
        return tof;
    }

    public final void a(f fVar, boolean z) {
        if (this.nbV) {
            bPD();
            return;
        }
        this.nbV = true;
        this.toh = z;
        this.toi = fVar;
        this.toi.tpa.bQi();
        this.toj.removeAllViews();
        if (this.toi.getParent() != null) {
            ((ViewGroup) this.toi.getParent()).removeView(this.toi);
        }
        this.toj.addView(this.toi, new LayoutParams(-1, -1));
        this.toi.setX(0.0f);
        this.toi.setY(0.0f);
        bPC();
        if (b.tnD || !b.tnE || this.toi.position + 1 < b.tnu.size()) {
            this.toi.tpF = true;
        } else {
            this.toi.tpF = false;
        }
        g.pQN.h(791, 6);
        if (com.tencent.mm.plugin.webview.fts.topstory.a.d.tnO != null) {
            com.tencent.mm.plugin.webview.fts.topstory.a.d.tnO.seu = 1;
        }
    }

    public final void bPC() {
        if (this.toj != null) {
            if (com.tencent.mm.compatible.util.d.fN(19)) {
                this.toj.setSystemUiVisibility(2);
            } else {
                this.toj.setSystemUiVisibility(4098);
            }
        }
        this.tog.bPx().getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (this.toh) {
            this.tog.bPx().setRequestedOrientation(0);
        } else {
            this.tog.bPx().setRequestedOrientation(8);
        }
        if (this.tog.bPx().getSupportActionBar() != null) {
            this.tog.bPx().getSupportActionBar().hide();
        }
    }

    public final void bPD() {
        this.toi.bPW();
        this.toi.tpa.ags();
        this.toj.setSystemUiVisibility(0);
        this.toj.removeView(this.toi);
        this.tog.bPx().getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (this.tog.bPx().getRequestedOrientation() == 0 || this.tog.bPx().getRequestedOrientation() == 6 || this.tog.bPx().getRequestedOrientation() == 8) {
            this.tog.bPx().setRequestedOrientation(1);
            if (this.tog.bPx().getSupportActionBar() != null) {
                this.tog.bPx().getSupportActionBar().hide();
            }
        }
        x.i("MicroMsg.WebSearch.TopStoryVideoFullScreenMgr", "exitFullScreen %d", new Object[]{Integer.valueOf(this.toi.position + this.tog.getListView().getHeaderViewsCount())});
        this.tog.getListView().smoothScrollToPositionFromTop(r0, this.tog.bPx().getResources().getDimensionPixelSize(R.f.bxo));
        ag.h(new Runnable(this) {
            final /* synthetic */ d tok;

            {
                this.tok = r1;
            }

            public final void run() {
                TopStoryVideoItemView a = a.a(this.tok.tog);
                if (a != null) {
                    ((com.tencent.mm.plugin.topstory.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.topstory.a.a.class)).yp(a.hashCode());
                    View view = this.tok.toi;
                    a.ton = view.tpG;
                    String str = "MicroMsg.WebSearch.TopStoryVideoItemView";
                    String str2 = "setVideoInfoFromResumeFullScreenView, videoInfo: %s, videoViewPosition: %s, position: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = a.ton != null ? a.ton.title : "";
                    objArr[1] = Integer.valueOf(view.position);
                    objArr[2] = Integer.valueOf(a.position);
                    x.i(str, str2, objArr);
                    if (a.ton != null) {
                        if (bh.ov(a.ton.title)) {
                            a.tom.ihS.setVisibility(8);
                        } else {
                            a.tom.ihS.setText(a.ton.title);
                            a.tom.ihS.setVisibility(0);
                        }
                        a.tom.pXZ.setText(a.ton.bhd);
                        if (bh.ov(a.ton.seA)) {
                            a.tom.tqj.setVisibility(8);
                        } else {
                            a.tom.tqj.setText(a.ton.seA);
                            a.tom.tqj.setVisibility(0);
                        }
                        if (bh.ov(a.ton.seF)) {
                            a.tom.tqk.setVisibility(8);
                        } else {
                            a.tom.tqk.setText(a.ton.seF);
                            a.tom.tqk.setVisibility(0);
                        }
                        a.tom.tqg.removeAllViews();
                        if (view.getParent() != null) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        a.tom.tqg.addView(view, a.b(a.ton));
                        a.tom.tqf = view;
                        view.toW = a;
                        if (g.bQd().tpZ) {
                            view.bPO();
                        } else {
                            view.bPP();
                        }
                        a.bPE();
                        a.bPz();
                        a.bPy();
                        a.position = view.position;
                        ((com.tencent.mm.plugin.topstory.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.topstory.a.a.class)).yp(a.hashCode());
                    }
                    g bQd = g.bQd();
                    if (bQd.tpX != null) {
                        bQd.tpX.bX(true);
                    }
                }
            }
        }, 300);
        this.nbV = false;
    }
}
