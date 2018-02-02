package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.mmsight.segment.d.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;

public class RecyclerThumbSeekBar extends RelativeLayout implements c {
    public int hOr = -1;
    private int hbn;
    private int hbo;
    private RecyclerView jNw;
    private n oyA;
    private int oyB;
    private a oyC = new a(new 1(this));
    private Runnable oyD = new 2(this);
    private k oyE = new 5(this);
    private n.a oyF = new 6(this);
    private int oyw;
    public c.a oyx;
    public b oyy;
    private c oyz;
    private String path;

    private class d {
        af handler = new af();
        int otB = 4;
        final /* synthetic */ RecyclerThumbSeekBar oyG;
        HandlerThread[] oyP = new HandlerThread[this.otB];
        int oyQ = 0;
        private BlockingDeque<b> oyR = new LinkedBlockingDeque();

        public d(RecyclerThumbSeekBar recyclerThumbSeekBar) {
            this.oyG = recyclerThumbSeekBar;
            for (int i = 0; i < this.oyP.length; i++) {
                this.oyP[i] = e.cZ("RecyclerThumbSeekBar_SimpleImageLoader_" + i, -1);
                this.oyP[i].start();
            }
            this.oyQ = 0;
        }
    }

    static /* synthetic */ int e(RecyclerThumbSeekBar recyclerThumbSeekBar, int i) {
        if (recyclerThumbSeekBar.oyz == null) {
            throw new IllegalStateException("recyclerAdapter is null");
        } else if (recyclerThumbSeekBar.hOr <= 0) {
            throw new IllegalStateException("durationMs <= 0");
        } else {
            recyclerThumbSeekBar.oyz.getItemCount();
            return (int) ((Math.min(Math.max(0.0f, ((float) i) / ((float) recyclerThumbSeekBar.hOr)), 1.0f) * ((float) recyclerThumbSeekBar.hbo)) * ((float) (recyclerThumbSeekBar.oyz.getItemCount() - 2)));
        }
    }

    public RecyclerThumbSeekBar(Context context) {
        super(context);
        init();
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jNw = new RecyclerView(getContext());
        getContext();
        this.jNw.a(new LinearLayoutManager(0, false));
        this.jNw.Ub = true;
        int aa = com.tencent.mm.bv.a.aa(getContext(), k.b.oyo);
        this.oyB = com.tencent.mm.bv.a.aa(getContext(), k.b.oyn);
        addView(this.jNw, new LayoutParams(-1, aa));
        this.oyA = new n(getContext());
        addView(this.oyA, new LayoutParams(-1, -1));
        this.oyA.oyS = this.oyF;
        this.jNw.a(this.oyE);
    }

    public final void al(float f) {
        float f2 = 0.0f;
        n nVar = this.oyA;
        if (!(this.oyz == null || this.jNw == null)) {
            float itemCount = ((float) (this.oyz.getItemCount() - 2)) * f;
            int floor = (int) Math.floor((double) itemCount);
            itemCount -= (float) floor;
            t bi = this.jNw.bi(floor + 1);
            if (bi != null) {
                View view = bi.VU;
                f2 = ((((float) view.getWidth()) * itemCount) + ((float) view.getLeft())) / ((float) getWidth());
            }
        }
        nVar.am(f2);
    }

    public final void Fl(String str) {
        if (bh.ov(str) || !FileOp.bO(str)) {
            bbl();
            return;
        }
        this.path = str;
        post(this.oyD);
    }

    public final int getDurationMs() {
        return this.hOr;
    }

    public final void gE(boolean z) {
        if (z) {
            this.oyA.oyU = true;
        } else {
            this.oyA.oyU = false;
        }
    }

    private void bbl() {
        ag.y(new Runnable(this) {
            final /* synthetic */ RecyclerThumbSeekBar oyG;

            {
                this.oyG = r1;
            }

            public final void run() {
                if (this.oyG.oyx != null) {
                    this.oyG.oyx.gF(true);
                }
            }
        });
    }

    public final void release() {
        Lock lock = null;
        this.hOr = -1;
        this.path = null;
        if (this.oyC != null) {
            a aVar = this.oyC;
            if (aVar.oxv != null) {
                aVar.mBP.lock();
                if (aVar.oxv == null) {
                    aVar.mBP.unlock();
                } else {
                    try {
                        Iterator it = aVar.oxv.iterator();
                        while (it.hasNext()) {
                            ((d) it.next()).release();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("FetcherPool", e, "destroy fetcher %s", new Object[]{e.getMessage()});
                    } finally {
                        aVar.oxv = null;
                        lock = aVar.mBP;
                        lock.unlock();
                    }
                }
            }
        }
        if (!(this.oyz == null || this.oyz.oyK == null)) {
            d dVar = this.oyz.oyK;
            if (!(dVar.oyP == null || dVar.oyP.length == 0)) {
                for (int i = lock; i < dVar.oyP.length; i++) {
                    if (dVar.oyP[i] != null) {
                        dVar.oyP[i].quit();
                        dVar.oyP[i] = null;
                    }
                }
            }
            this.oyz.oyK = null;
            this.oyz = null;
        }
        if (this.oyA != null) {
            n nVar = this.oyA;
            if (nVar.ozp != null && nVar.ozq != null) {
                nVar.oyX.setBounds(nVar.ozp);
                nVar.oyY.setBounds(nVar.ozq);
                nVar.ozc = -1.0f;
                nVar.postInvalidate();
            }
        }
    }

    public final void a(c.a aVar) {
        this.oyx = aVar;
    }

    public final void a(b bVar) {
        this.oyy = bVar;
    }

    public final float baZ() {
        if (this.oyA == null) {
            return 0.0f;
        }
        return sU(this.oyA.bbo());
    }

    public final float bba() {
        if (this.oyA == null) {
            return 0.0f;
        }
        return sU(this.oyA.bbp());
    }

    private float sU(int i) {
        if (this.oyz == null || this.jNw == null) {
            return 0.0f;
        }
        View j = this.jNw.j((float) i, 0.0f);
        int aZ = RecyclerView.aZ(j);
        int itemCount = this.oyz.getItemCount();
        if (aZ <= 0) {
            return 0.0f;
        }
        if (aZ >= itemCount - 1) {
            return 1.0f;
        }
        return (((float) (aZ - 1)) + (((float) (i - j.getLeft())) / ((float) j.getWidth()))) / ((float) (itemCount - 2));
    }
}
