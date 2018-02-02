package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.fts.topstory.a.f;
import com.tencent.mm.plugin.webview.fts.topstory.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.u;

public class TopStoryVideoItemView extends LinearLayout implements h {
    public static c tol;
    private Context context;
    long id;
    private OnClickListener pGO = new 4(this);
    public int position;
    public Point qWe;
    b tog;
    public b tom;
    com.tencent.mm.plugin.topstory.a.a.c ton;
    public int too;

    static /* synthetic */ void a(TopStoryVideoItemView topStoryVideoItemView, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        d.b(topStoryVideoItemView.context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void d(TopStoryVideoItemView topStoryVideoItemView) {
        if (g.bQd().tpZ) {
            topStoryVideoItemView.tom.tqf.bPU();
            g.bQd().bxv();
        }
    }

    static {
        a aVar = new a();
        aVar.hDA = true;
        aVar.hDz = true;
        aVar.hDY = true;
        aVar.hDP = R.g.bBB;
        tol = aVar.PK();
    }

    public TopStoryVideoItemView(Context context) {
        super(context);
        init(context);
    }

    public TopStoryVideoItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public TopStoryVideoItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    final void au() {
        if (bh.ov(this.ton.title)) {
            this.tom.ihS.setVisibility(8);
        } else {
            this.tom.ihS.setText(this.ton.title);
            this.tom.ihS.setVisibility(0);
        }
        this.tom.ihS.setOnClickListener(this.pGO);
        this.tom.pXZ.setText(this.ton.bhd);
        if (bh.ov(this.ton.seA)) {
            this.tom.tqj.setVisibility(8);
        } else {
            this.tom.tqj.setText(this.ton.seA);
            this.tom.tqj.setVisibility(0);
        }
        this.tom.tqj.setOnClickListener(this.pGO);
        if (bh.ov(this.ton.seF)) {
            this.tom.tqk.setVisibility(8);
        } else {
            this.tom.tqk.setText(this.ton.seF);
            this.tom.tqk.setVisibility(0);
        }
        this.tom.tqk.setOnClickListener(this.pGO);
        if (bh.ov(this.ton.seJ)) {
            this.tom.tqi.setVisibility(8);
        } else {
            o.PA().a(this.ton.seJ, this.tom.tqi, tol);
            this.tom.tqi.setVisibility(0);
        }
        this.tom.lNu.setOnClickListener(this.pGO);
        this.tom.tql.setVisibility(0);
        this.tom.tqm.setVisibility(0);
        this.tom.tqn.setVisibility(0);
        this.tom.tqh.setOnClickListener(this.pGO);
        if (this.tom.tqf == null) {
            this.tom.tqf = new f(this.context);
            this.tom.tqg.removeAllViews();
            this.tom.tqg.addView(this.tom.tqf, b(this.ton));
        }
        this.tom.tqf.toV = this.tog;
        this.tom.tqf.toW = this;
        f fVar = this.tom.tqf;
        com.tencent.mm.plugin.topstory.a.a.c cVar = this.ton;
        fVar.position = this.position;
        fVar.tpG = cVar;
        fVar.au();
        if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFr() != hashCode()) {
            this.tom.bQh();
        }
    }

    public final void kf(boolean z) {
        bPE();
        ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).yp(hashCode());
        if (this.tom.tqf.kg(z)) {
            bPz();
            bPy();
        }
    }

    private void init(Context context) {
        Point point;
        this.context = context;
        LayoutInflater.from(context).inflate(R.i.dtc, this);
        this.tom = new b();
        b bVar = this.tom;
        bVar.tqg = (FrameLayout) findViewById(R.h.cVD);
        bVar.tqh = findViewById(R.h.cPa);
        bVar.tqi = (ImageView) findViewById(R.h.cOZ);
        bVar.pXZ = (TextView) findViewById(R.h.cPc);
        bVar.ihS = (TextView) findViewById(R.h.cSu);
        bVar.tqj = (TextView) findViewById(R.h.cNJ);
        bVar.tqk = (TextView) findViewById(R.h.cCE);
        bVar.lNu = findViewById(R.h.cNM);
        bVar.tql = findViewById(R.h.bNV);
        bVar.tqm = findViewById(R.h.cos);
        bVar.tqn = findViewById(R.h.cja);
        this.qWe = ae.fz(context);
        if (ae.fy(context)) {
            point = this.qWe;
            point.y -= ae.fx(context);
        }
        point = this.qWe;
        point.y -= u.fK(context);
        this.too = com.tencent.mm.bv.a.fromDPToPix(context, 24);
    }

    public final void bPy() {
        this.tom.bPy();
        this.tog.bPy();
    }

    public final void bPz() {
        this.tom.bPz();
        this.tog.bPz();
    }

    final LayoutParams b(com.tencent.mm.plugin.topstory.a.a.c cVar) {
        int min = Math.min(this.qWe.x, this.qWe.y);
        return new LayoutParams(min, (cVar.hbn * min) / cVar.hbo);
    }

    public final void bPE() {
        x.d("MicroMsg.WebSearch.TopStoryVideoItemView", "hideDarkMask, position: %s", Integer.valueOf(this.position));
        b bVar = this.tom;
        x.d("MicroMsg.WebSearch.TopStoryTimeLineItemViewHolder", "hideMaskView %d", Integer.valueOf(bVar.hashCode()));
        bVar.tqn.animate().cancel();
        bVar.tqm.animate().cancel();
        bVar.tql.animate().cancel();
        bVar.tql.setAlpha(0.0f);
        bVar.tqn.setAlpha(0.0f);
        bVar.tqm.setAlpha(0.0f);
    }

    public static boolean agN() {
        return d.bPB().nbV;
    }

    public static void a(Context context, f fVar, int i) {
        f.tob.iRN = com.tencent.mm.plugin.webview.fts.topstory.a.b.tnv.lEK;
        com.tencent.mm.plugin.topstory.a.a.c cVar = (com.tencent.mm.plugin.topstory.a.a.c) com.tencent.mm.plugin.webview.fts.topstory.a.b.tnu.get(i);
        if (cVar != null) {
            com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(context, com.tencent.mm.ui.widget.g.ztp, false);
            gVar.rKC = new 1();
            gVar.rKD = new 2(fVar, context, cVar);
            gVar.ztB = new 3();
            gVar.bUk();
        }
    }

    public boolean hasTransientState() {
        return false;
    }

    public void setHasTransientState(boolean z) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.tom.tqf != null) {
            f fVar = this.tom.tqf;
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onUIDestroy %d", Integer.valueOf(fVar.position));
            fVar.tpa.onDestroy();
            fVar.bPW();
        }
        this.ton = null;
        this.position = -1;
    }

    public final void bPF() {
        this.tom.tqf = null;
        ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).yp(0);
        au();
    }
}
