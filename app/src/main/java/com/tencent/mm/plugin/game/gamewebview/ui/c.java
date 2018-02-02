package com.tencent.mm.plugin.game.gamewebview.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.22;
import com.tencent.mm.plugin.game.widget.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.wepkg.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends FrameLayout {
    private b mYu;
    private b mYv;
    b<b> mYw;
    private GameWebViewUI mYx;
    private Intent mYy;
    private long mYz;

    static /* synthetic */ void a(c cVar, b bVar) {
        if (bVar != null) {
            x.d("MicroMsg.GameWebPageContainer", "bringToFront begin : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - cVar.mYz)});
            bVar.bringToFront();
            x.d("MicroMsg.GameWebPageContainer", "bringToFront end : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - cVar.mYz)});
            cVar.requestLayout();
            cVar.invalidate();
            bVar.aes();
            Runnable 6 = new 6(cVar);
            Animator ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{(float) bVar.getWidth(), 0.0f});
            ofFloat.setDuration(200);
            cVar.a(ofFloat, 6);
        }
    }

    static /* synthetic */ void a(c cVar, b bVar, b bVar2, boolean z) {
        if (bVar2 != null && bVar != null) {
            if (z) {
                Runnable 8;
                Animator ofFloat;
                if (bVar2.mSwiping) {
                    cVar.a(bVar2);
                } else {
                    8 = new 8(cVar, bVar2);
                    ofFloat = ObjectAnimator.ofFloat(bVar2, "translationX", new float[]{0.0f, (float) bVar2.getWidth()});
                    ofFloat.setDuration(200);
                    cVar.a(ofFloat, 8);
                }
                bVar.aes();
                if (!bVar2.mSwiping) {
                    8 = new Runnable(cVar) {
                        final /* synthetic */ c mYA;

                        {
                            this.mYA = r1;
                        }

                        public final void run() {
                        }
                    };
                    ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{-(((float) bVar.getWidth()) * 0.25f), 0.0f});
                    ofFloat.setDuration(200);
                    cVar.a(ofFloat, 8);
                    return;
                }
                return;
            }
            cVar.a(bVar2);
            bVar.aes();
        }
    }

    static /* synthetic */ void a(c cVar, b bVar, boolean z, boolean z2) {
        if (bVar != null) {
            if (z) {
                cVar.mYw.remove(bVar);
            }
            Runnable 5 = new 5(cVar, z2, bVar, z);
            ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f, -(((float) bVar.getWidth()) * 0.25f)}).setDuration(200);
            ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f}).setDuration(0);
            Animator animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{r1, r2});
            cVar.a(animatorSet, 5);
        }
    }

    static /* synthetic */ void d(c cVar) {
        cVar.mYv = new b(cVar.mYx, cVar);
        cVar.addView(cVar.mYv, 0);
    }

    public c(GameWebViewUI gameWebViewUI) {
        super(gameWebViewUI);
        this.mYx = gameWebViewUI;
        this.mYw = new b(new 1(this, gameWebViewUI));
    }

    public final void cleanup() {
        while (!this.mYw.isEmpty()) {
            ((b) this.mYw.pop()).aer();
        }
        if (this.mYv != null) {
            this.mYv.aer();
        }
    }

    public final void c(Intent intent, boolean z) {
        this.mYy = intent;
        String stringExtra = intent.getStringExtra("rawUrl");
        if (!bh.ov(stringExtra)) {
            b bVar = (b) this.mYw.peek();
            if (bVar != null && bh.ou(bVar.mWG.mXZ).equals(stringExtra)) {
                bVar.vf.putBoolean("is_from_keep_top", aOY());
            } else if (!aOY() || this.mYu == null) {
                View view;
                Object obj = (z || !intent.getBooleanExtra("needAnimation", true)) ? null : 1;
                x.d("MicroMsg.GameWebPageContainer", "createPage start : " + System.currentTimeMillis());
                this.mYz = System.currentTimeMillis();
                View view2;
                if (this.mYv != null) {
                    view2 = this.mYv;
                    this.mYv = null;
                    view = view2;
                } else {
                    x.d("MicroMsg.GameWebPageContainer", "createPage begin: " + System.currentTimeMillis());
                    view2 = new b(this.mYx, this);
                    x.d("MicroMsg.GameWebPageContainer", "createPage end: " + System.currentTimeMillis());
                    view = view2;
                }
                Bundle extras = this.mYy.getExtras();
                view.vf = extras;
                d aOV = view.aOV();
                aOV.vf = extras;
                aOV.mYM.mWi = aOV.aPe();
                aOV.gAb = aOV.vf.getString("geta8key_username");
                aOV.mZr = aOV.vf.getString("KPublisherId");
                aOV.scene = aOV.vf.getInt("geta8key_scene", 0);
                aOV.mZq = d.ak(aOV.scene, aOV.gAb);
                aOV.mZk = aOV.vf.getBoolean("neverGetA8Key", false);
                aOV.mZv = aOV.vf.getString("game_hv_menu_appid");
                x.d("MicroMsg.GameWebPageContainer", "LoadUrl begin : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.mYz)});
                x.d("MicroMsg.GameWebPage", "loadUrl, url = %s, pageViewId = %d, this = %d", new Object[]{stringExtra, Integer.valueOf(view.mWG.hashCode()), Integer.valueOf(view.hashCode())});
                d dVar = view.mWG;
                if (bh.ov(stringExtra)) {
                    x.e("MicroMsg.GameWebPageView", "rawUrl is null");
                } else {
                    x.d("MicroMsg.GameWebPageView", "loadUrl, rawUrl = %s, this = %d", new Object[]{stringExtra, Integer.valueOf(dVar.hashCode())});
                    g.pQN.a(611, 1, 1, false);
                    dVar.mXZ = stringExtra;
                    dVar.mYZ = new a(dVar.mYx, dVar.mYN, dVar.mYN.hashCode());
                    dVar.mYZ.tLt = new 22(dVar);
                    dVar.mYZ.PN(dVar.mXZ);
                    if (dVar.mYZ.PO(dVar.mXZ)) {
                        dVar.mYS.setVisibility(0);
                    }
                    dVar.aPd();
                }
                x.d("MicroMsg.GameWebPageContainer", "LoadUrl end : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.mYz)});
                bVar = (b) this.mYw.peek();
                this.mYw.push(view);
                if (obj != null) {
                    x.d("MicroMsg.GameWebPageContainer", "addView start : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.mYz)});
                    if (view.getParent() == null) {
                        addView(view, 0);
                    }
                    x.d("MicroMsg.GameWebPageContainer", "addView end : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.mYz)});
                    boolean[] zArr = new boolean[]{false};
                    Runnable 2 = new 2(this, zArr, bVar, view);
                    view.mWG.mZo = new 3(this, zArr, 2);
                    x.d("MicroMsg.GameWebPageContainer", "post : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.mYz)});
                    postDelayed(2, 300);
                    return;
                }
                addView(view);
                view.aes();
            } else {
                while (!this.mYw.isEmpty()) {
                    a((b) this.mYw.pop());
                }
                if (this.mYu.getParent() == null) {
                    addView(this.mYu);
                }
                this.mYu.aes();
                this.mYw.push(this.mYu);
            }
        }
    }

    public final void fw(boolean z) {
        if (this.mYw.size() <= 1) {
            this.mYx.finish();
            return;
        }
        Runnable 4 = new 4(this, z);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            4.run();
        } else {
            post(4);
        }
    }

    final void a(b bVar) {
        if (bVar != null) {
            bVar.fv(false);
            bVar.setVisibility(8);
            removeView(bVar);
            if (bVar != this.mYu) {
                bVar.aer();
                return;
            }
            Animator ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f});
            ofFloat.setDuration(0);
            a(ofFloat, null);
        }
    }

    private void a(Animator animator, Runnable runnable) {
        animator.addListener(new 7(this, runnable));
        animator.start();
    }

    private boolean aOY() {
        return this.mYy.getBooleanExtra("is_from_keep_top", false);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b bVar = (b) this.mYw.peek();
        if (bVar != null) {
            if (bVar.mWG.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (i == 4 && bVar.mWG.aPo()) {
                return true;
            }
        }
        return false;
    }

    public final void b(b bVar) {
        x.d("MicroMsg.GameWebPageContainer", "keepPageTop");
        if (this.mYu != bVar) {
            if (this.mYu != null && !this.mYw.contains(this.mYu)) {
                this.mYu.aer();
            } else if (this.mYu != null) {
                this.mYu.aOX();
            }
            this.mYu = bVar;
        }
    }

    public final void aPa() {
        x.d("MicroMsg.GameWebPageContainer", "cancelPageTop");
        if (this.mYu != null && !this.mYw.contains(this.mYu)) {
            this.mYu.aer();
        } else if (this.mYu != null) {
            this.mYu.aOX();
        }
        this.mYu = null;
    }
}
