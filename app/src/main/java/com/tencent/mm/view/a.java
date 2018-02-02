package com.tencent.mm.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.api.b;
import com.tencent.mm.api.d;
import com.tencent.mm.api.o;
import com.tencent.mm.bj.a$a;
import com.tencent.mm.bj.a$c;
import com.tencent.mm.bj.a$f;
import com.tencent.mm.bj.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.view.footer.a.2;

public abstract class a extends b implements OnGlobalLayoutListener {
    private com.tencent.mm.api.m.a fdC;
    public boolean fdG = true;
    private com.tencent.mm.view.b.a fdj;
    private com.tencent.mm.bo.b fhY;
    private View jNv;
    protected d[] zDb;
    private View zDc;
    private com.tencent.mm.view.footer.a zDd;
    private View zDe;
    private View zDf;
    public ChatFooterPanel zDg;
    private EditText zDh;
    private boolean zDi = true;

    protected abstract com.tencent.mm.view.b.a cAc();

    protected abstract com.tencent.mm.view.footer.a cAd();

    public abstract d[] cde();

    public a(Context context, com.tencent.mm.api.m.a aVar) {
        super(context);
        this.fdC = aVar;
        cAl().a(this.fdC);
        removeAllViews();
        addView(cAf(), new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, (int) getResources().getDimension(a$c.vbj));
        layoutParams.gravity = 80;
        addView(cAg(), layoutParams);
        addView(cAe(), layoutParams);
        layoutParams = new LayoutParams(-1, -1);
        cAi().setVisibility(8);
        addView(cAi(), layoutParams);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        cAj().setVisibility(8);
        addView(cAj(), layoutParams);
        layoutParams = new LayoutParams(-1, (int) getResources().getDimension(a$c.vbh));
        layoutParams.gravity = 80;
        addView(cAk(), layoutParams);
        layoutParams = new LayoutParams(-1, (int) getResources().getDimension(a$c.buF));
        layoutParams.gravity = 48;
        if (this.fdC.fdG) {
            addView(cAh(), layoutParams);
        }
    }

    public final <T extends com.tencent.mm.view.footer.a> T cAe() {
        if (this.zDd == null) {
            this.zDd = cAd();
        }
        return this.zDd;
    }

    public final <T extends com.tencent.mm.view.b.a> T cAf() {
        if (this.fdj == null) {
            this.fdj = cAc();
        }
        return this.fdj;
    }

    public final View cAg() {
        if (this.zDc == null) {
            this.zDc = LayoutInflater.from(getContext()).inflate(a$f.vbE, null);
            this.zDc.setVisibility(0);
        }
        return this.zDc;
    }

    public final View cAh() {
        if (this.jNv == null) {
            this.jNv = LayoutInflater.from(getContext()).inflate(a$f.vbF, null);
            this.jNv.findViewById(e.oEB).setOnClickListener(new 1(this));
            this.jNv.findViewById(e.oEA).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a zDj;

                {
                    this.zDj = r1;
                }

                public final void onClick(View view) {
                    if (this.zDj.cAi().getVisibility() == 0) {
                        this.zDj.cAl().cdg();
                    } else {
                        this.zDj.cAl().sW();
                    }
                }
            });
        }
        return this.jNv;
    }

    public final View cAi() {
        if (this.zDe == null) {
            this.zDe = LayoutInflater.from(getContext()).inflate(a$f.vbD, null);
            this.zDh = (EditText) this.zDe.findViewById(e.gWv);
            SelectColorBar selectColorBar = (SelectColorBar) this.zDe.findViewById(e.vbC);
            this.zDh.setTextColor(-1);
            selectColorBar.Hu(-1);
            selectColorBar.zFM = new 6(this);
        }
        return this.zDe;
    }

    public final View cAj() {
        if (this.zDe == null) {
            this.zDf = LayoutInflater.from(getContext()).inflate(a$f.vbG, null);
        }
        return this.zDf;
    }

    public final View cAk() {
        boolean z = false;
        if (this.zDg == null) {
            try {
                this.zDg = o.fdN.ak(getContext());
                this.zDg.ej(ChatFooterPanel.vjG);
                this.zDg.setBackgroundResource(com.tencent.mm.bj.a.d.bzY);
                this.zDg.tk();
                this.zDg.aF(true);
                this.zDg.g(true, true);
                this.zDg.setVisibility(8);
                this.zDg.onResume();
                f tn = o.fdN.tn();
                tn.fdM = new 7(this);
                this.zDg.a(tn);
            } catch (Exception e) {
                String str = "MicroMsg.BaseDrawingView";
                String str2 = "exception:%s,getContext() is null?";
                Object[] objArr = new Object[2];
                objArr[0] = e.getMessage();
                if (getContext() == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.e(str, str2, objArr);
                throw e;
            }
        }
        return this.zDg;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new 8(this));
    }

    public final com.tencent.mm.bo.b cAl() {
        if (this.fhY == null) {
            this.fhY = new com.tencent.mm.bo.a();
            this.fhY.a(this);
        }
        return this.fhY;
    }

    public final void a(com.tencent.mm.api.e eVar) {
        cAl().a(eVar);
    }

    public final void aA(boolean z) {
        cAl().aA(z);
    }

    public final void aB(boolean z) {
        if (this.zDi != z) {
            com.tencent.mm.view.footer.a cAe = cAe();
            Animation loadAnimation;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(cAe.getContext(), a$a.bpO);
                loadAnimation.setAnimationListener(new AnimationListener(cAe) {
                    final /* synthetic */ a zFp;

                    {
                        this.zFp = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        this.zFp.setVisibility(0);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                cAe.startAnimation(loadAnimation);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(cAe.getContext(), a$a.bpP);
                loadAnimation.setAnimationListener(new 2(cAe));
                cAe.startAnimation(loadAnimation);
            }
            Animation loadAnimation2;
            if (z) {
                loadAnimation2 = AnimationUtils.loadAnimation(getContext(), a$a.bpO);
                loadAnimation2.setAnimationListener(new 11(this));
                cAh().startAnimation(loadAnimation2);
            } else {
                loadAnimation2 = AnimationUtils.loadAnimation(getContext(), a$a.bpP);
                loadAnimation2.setAnimationListener(new 12(this));
                cAh().startAnimation(loadAnimation2);
            }
            this.zDi = z;
        }
    }

    public final void aC(boolean z) {
        if (this.fdG == z) {
            x.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
            return;
        }
        this.fdG = z;
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a$a.bpO);
            loadAnimation.setAnimationListener(new 9(this));
            cAh().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), a$a.bpP);
        loadAnimation.setAnimationListener(new 10(this));
        cAh().startAnimation(loadAnimation);
    }

    public final void nH(boolean z) {
        x.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[]{Boolean.valueOf(z)});
        Animation loadAnimation;
        if (this.zDg.getVisibility() == 0 && z) {
            this.zDg.setVisibility(8);
            loadAnimation = AnimationUtils.loadAnimation(getContext(), a$a.bqm);
            loadAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ a zDj;

                {
                    this.zDj = r1;
                }

                public final void onAnimationStart(Animation animation) {
                    this.zDj.zDg.setVisibility(0);
                }

                public final void onAnimationEnd(Animation animation) {
                    this.zDj.zDg.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.zDg.startAnimation(loadAnimation);
        } else if (this.zDg.getVisibility() == 8 && !z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), a$a.bqo);
            loadAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ a zDj;

                {
                    this.zDj = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.zDj.zDg.setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.zDg.startAnimation(loadAnimation);
        }
    }

    public void onGlobalLayout() {
        if (cAi().getVisibility() == 0) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.zDh.postDelayed(new 4(this), 160);
        }
    }
}
