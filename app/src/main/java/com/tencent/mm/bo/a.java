package com.tencent.mm.bo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.api.d;
import com.tencent.mm.api.e;
import com.tencent.mm.api.j;
import com.tencent.mm.api.l;
import com.tencent.mm.bj.a.h;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.d.b;
import com.tencent.mm.d.c;
import com.tencent.mm.d.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    com.tencent.mm.api.m.a fdC;
    Bitmap vAa;
    private boolean vAb = true;
    d vAc = d.fdu;
    d vAd = d.fdu;
    b vAe = null;
    com.tencent.mm.view.a vzW;
    HashMap<d, b> vzX;
    LinkedList<b> vzY;
    private e vzZ;

    class a implements com.tencent.mm.x.a {
        final /* synthetic */ a vAf;
        View vAi = this.vAf.vzW.cAj();
        TextView vAj = ((TextView) this.vAi.findViewById(com.tencent.mm.bj.a.e.vbB));
        ImageView vAk = ((ImageView) this.vAi.findViewById(com.tencent.mm.bj.a.e.vbA));

        a(a aVar) {
            this.vAf = aVar;
        }

        public final void Q(float f) {
            x.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[]{Float.valueOf(f)});
            this.vAj.setText(this.vAf.vzW.getContext().getString(h.vca));
            this.vAk.setImageResource(com.tencent.mm.bj.a.d.vby);
        }

        public final void Ep() {
            x.i("MicroMsg.DrawingPresenter", "[onUnReach]");
            this.vAk.setImageResource(com.tencent.mm.bj.a.d.vbx);
            this.vAj.setText(this.vAf.vzW.getContext().getString(h.vcb));
        }

        public final void onShow() {
            a.a(this.vAf, true);
        }

        public final void onHide() {
            a.a(this.vAf, false);
        }

        public final void a(com.tencent.mm.t.e eVar) {
            EditText editText = (EditText) this.vAf.vzW.cAi().findViewById(com.tencent.mm.bj.a.e.gWv);
            editText.setText(eVar.gOe);
            editText.setTextColor(eVar.su);
            editText.setTag(eVar);
            this.vAf.lr(true);
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(aVar.vzW.getContext(), com.tencent.mm.bj.a.a.bqo);
            loadAnimation.setAnimationListener(new 5(aVar));
            aVar.vzW.cAj().startAnimation(loadAnimation);
            return;
        }
        aVar.vzW.cAj().setAlpha(0.82f);
        loadAnimation = AnimationUtils.loadAnimation(aVar.vzW.getContext(), com.tencent.mm.bj.a.a.bqm);
        loadAnimation.setAnimationListener(new 6(aVar));
        aVar.vzW.cAj().startAnimation(loadAnimation);
    }

    public final void a(com.tencent.mm.view.a aVar) {
        this.vzW = aVar;
    }

    public final void a(com.tencent.mm.api.m.a aVar) {
        boolean z;
        this.fdC = aVar;
        this.vzX = new HashMap();
        this.vzY = new LinkedList();
        String str = aVar.path;
        if (bh.ov(str) || !new File(str).exists()) {
            x.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[]{str});
            z = false;
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                x.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), str});
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            this.vAa = com.tencent.mm.sdk.platformtools.d.a(bh.az(aVar.path, ""), 1280, 1280, true, false, 0);
        }
        cdo();
    }

    public final d[] cde() {
        return this.vzW.cde();
    }

    public final l cdf() {
        return new 1(this);
    }

    public final void a(e eVar) {
        this.vzZ = eVar;
    }

    public final void aA(boolean z) {
        this.vAb = z;
    }

    public final void sW() {
        if (this.vzZ != null) {
            this.vzZ.sW();
        }
    }

    public final boolean sS() {
        if (this.vzW.cAi().getVisibility() == 0) {
            lr(false);
            this.vzW.aB(true);
            return true;
        } else if (this.vzW.cAk() == null || this.vzW.cAk().getVisibility() != 0) {
            return false;
        } else {
            this.vzW.nH(true);
            this.vzW.aB(true);
            return true;
        }
    }

    public final void onFinish() {
        if (this.vzZ != null) {
            this.vzZ.onFinish();
        }
    }

    public final void a(Editable editable, int i) {
        lr(false);
        this.vzW.aB(true);
        b cdj = cdj();
        if (cdj.uG() == com.tencent.mm.d.a.fhU) {
            com.tencent.mm.d.e eVar = (com.tencent.mm.d.e) cdj;
            EditText editText = (EditText) this.vzW.cAi().findViewById(com.tencent.mm.bj.a.e.gWv);
            if (editText.getTag() == null || !(editText.getTag() instanceof com.tencent.mm.t.e)) {
                eVar.a(i.a(this.vzW.getContext(), editable), i);
            } else {
                eVar.a((com.tencent.mm.t.e) editText.getTag(), i.a(this.vzW.getContext(), editable), i);
            }
            editText.setTag(null);
        }
    }

    public final void cdg() {
        this.vzW.aB(true);
        lr(false);
    }

    public final com.tencent.mm.view.a cdh() {
        return this.vzW;
    }

    public final Context getContext() {
        return this.vzW.getContext();
    }

    public final com.tencent.mm.api.m.a cdi() {
        return this.fdC;
    }

    public final <T extends b> T cdj() {
        if (this.vAe != null) {
            return this.vAe;
        }
        x.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
        return b.fie;
    }

    public final float cdk() {
        com.tencent.mm.view.b.a cAf = this.vzW.cAf();
        return cAf.cAt() ? cAf.gNH : 1.0f;
    }

    public final float cdl() {
        return this.vzW.cAf().cdl();
    }

    public final void a(j jVar, boolean z) {
        com.tencent.mm.sdk.f.e.post(new b(this, jVar, z), "onFinalGenerate");
    }

    public final void onDestroy() {
        Iterator it = this.vzY.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onDestroy();
        }
        this.vzY.clear();
        this.vzX.clear();
    }

    public final void onAttachedToWindow() {
        x.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
        Iterator it = this.vzY.iterator();
        while (it.hasNext()) {
            boolean z;
            b bVar = (b) it.next();
            ArtistCacheManager xu = ArtistCacheManager.xu();
            com.tencent.mm.d.a uG = bVar.uG();
            if (ArtistCacheManager.gBo.containsKey(xu.gBq) && ((com.tencent.mm.cache.ArtistCacheManager.a) ArtistCacheManager.gBo.get(xu.gBq)).gBt.containsKey(uG)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bVar.uJ();
                bVar.aI(true);
                x.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[]{bVar.uG()});
            }
        }
        if (this.vzW.cAf().cAt()) {
            this.vzW.cAf().cAv();
            this.vzW.cAf().invalidate();
        }
    }

    public final Bitmap cdm() {
        return this.vAa;
    }

    public final boolean cdn() {
        return cdj().uG() != com.tencent.mm.d.a.fhV && this.vAb;
    }

    public final <T extends b> T b(d dVar) {
        return (b) this.vzX.get(dVar);
    }

    public final void c(com.tencent.mm.api.i iVar) {
        ((com.tencent.mm.d.e) b(d.fdx)).b(iVar);
    }

    public final boolean H(MotionEvent motionEvent) {
        b bVar;
        boolean z = false;
        if (!(cdj().uG() == com.tencent.mm.d.a.fhV || cdj().uG() == com.tencent.mm.d.a.fhW)) {
            bVar = null;
            if (this.vzX.containsKey(d.fdw)) {
                bVar = (b) this.vzX.get(d.fdw);
            } else if (this.vzX.containsKey(d.fdx)) {
                bVar = (b) this.vzX.get(d.fdx);
            }
            if (bVar != null) {
                z = bVar.q(motionEvent);
            }
            if (z) {
                this.vAe = bVar;
            }
        }
        if (!z) {
            this.vAe = (b) this.vzX.get(this.vzW.cAe().cAH());
            Iterator it = this.vzY.iterator();
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (bVar.uG() != com.tencent.mm.d.a.fhU && bVar.q(motionEvent)) {
                    return true;
                }
            }
        }
        return z;
    }

    public final void onDraw(Canvas canvas) {
        Iterator it = this.vzY.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.isAlive()) {
                if (cdj().uG() == bVar.uG()) {
                    bVar.onDraw(canvas);
                } else {
                    canvas.save();
                    canvas.clipRect(this.vzW.cAf().cAu());
                    bVar.b(canvas);
                    canvas.restore();
                }
            }
        }
    }

    public final com.tencent.mm.cache.d a(com.tencent.mm.d.a aVar) {
        return ArtistCacheManager.xu().a(aVar);
    }

    private void cdo() {
        this.vzY.clear();
        this.vzX.clear();
        this.vzX.put(d.fdu, b.fie);
        for (d dVar : this.vzW.cde()) {
            b bVar = null;
            switch (7.vAh[dVar.ordinal()]) {
                case 1:
                case 2:
                    int i;
                    Iterator it = this.vzY.iterator();
                    while (it.hasNext()) {
                        b bVar2 = (b) it.next();
                        if (bVar2.uG() == com.tencent.mm.d.a.fhU) {
                            bVar = bVar2;
                            i = 1;
                            if (i == 0) {
                                bVar = new com.tencent.mm.d.e();
                                ((com.tencent.mm.d.e) bVar).fjk = new a(this);
                                break;
                            }
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        bVar = new com.tencent.mm.d.e();
                        ((com.tencent.mm.d.e) bVar).fjk = new a(this);
                    }
                    break;
                case 3:
                    bVar = new c();
                    break;
                case 4:
                    bVar = new com.tencent.mm.d.d();
                    break;
                case 5:
                    bVar = new f();
                    break;
            }
            if (bVar != null) {
                if (!this.vzX.containsKey(dVar)) {
                    this.vzX.put(dVar, bVar);
                }
                if (!this.vzY.contains(bVar)) {
                    this.vzY.add(bVar);
                    bVar.a(this, this.vzW.cAf().uR(), this.vzW.cAf().cAu());
                }
            }
        }
        Collections.sort(this.vzY, new 2(this));
        x.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[]{Integer.valueOf(this.vzX.size() - 1)});
    }

    final void lr(boolean z) {
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.vzW.getContext(), com.tencent.mm.bj.a.a.bqo);
            loadAnimation.setAnimationListener(new 3(this));
            this.vzW.cAi().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(this.vzW.getContext(), com.tencent.mm.bj.a.a.bqm);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ a vAf;

            {
                this.vAf = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.vAf.vzW.fds.aD(false);
            }

            public final void onAnimationEnd(Animation animation) {
                ((EditText) this.vAf.vzW.cAi().findViewById(com.tencent.mm.bj.a.e.gWv)).setText("");
                this.vAf.vzW.cAi().setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.vzW.cAi().startAnimation(loadAnimation);
    }
}
