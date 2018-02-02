package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.cb.a$c;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.cb.a.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.p.b;
import com.tencent.mm.ui.base.p.c;
import com.tencent.wcdb.FileUtils;

public final class g implements OnGlobalLayoutListener {
    public static int zto = 0;
    public static int ztp = 1;
    public static int ztq = 2;
    private ViewTreeObserver Md;
    private RecyclerView Va;
    private View hH;
    public View lCk;
    public Context mContext;
    public boolean pEa = false;
    public c rKC;
    public p$d rKD;
    private n rKE;
    private boolean tGi = false;
    private boolean tGj;
    public boolean tGk;
    public boolean tGl = false;
    private int yIf;
    private BottomSheetBehavior yIg;
    public com.tencent.mm.ui.base.p.a zlt;
    public b zlu;
    private boolean ztA = false;
    public a ztB;
    private Dialog ztc;
    private p$d ztd;
    private n zte;
    public Boolean ztf = Boolean.valueOf(false);
    private LinearLayout ztg;
    private LinearLayout zth;
    private b zti;
    private boolean ztj = false;
    private boolean ztk = false;
    private boolean ztl = false;
    private int ztm;
    public ImageView ztn;
    private int ztr = 4;
    private int zts = (this.ztr * 3);
    private int ztt = 6;
    private int ztu;
    private boolean ztv;
    private boolean ztw = false;
    public boolean ztx = false;
    private boolean zty = false;
    public int ztz = 0;

    public interface a {
        void onDismiss();
    }

    public final void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hH;
            if (view == null || !view.isShown()) {
                bxh();
            } else if (!isShowing()) {
            } else {
                if (this.tGi != aZW() || this.ztm != getRotation()) {
                    bxh();
                }
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        if (this.mContext instanceof Activity) {
            return ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        return 0;
    }

    public g(Context context, int i, boolean z) {
        this.ztu = i;
        this.mContext = context;
        this.ztv = z;
        this.zty = false;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hH = viewGroup.getChildAt(0);
            } else {
                this.hH = viewGroup;
            }
        }
        cd(this.mContext);
    }

    public g(Context context, int i) {
        this.ztu = i;
        this.mContext = context;
        this.ztA = true;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hH = viewGroup.getChildAt(0);
            } else {
                this.hH = viewGroup;
            }
        }
        cd(this.mContext);
    }

    private void cd(Context context) {
        int ab;
        this.rKE = new n();
        this.zte = new n();
        if (this.ztA) {
            this.ztc = new a(context);
        } else {
            this.ztc = new android.support.design.widget.c(context);
        }
        this.lCk = View.inflate(context, f.zzt, null);
        this.ztg = (LinearLayout) this.lCk.findViewById(e.qBw);
        this.zth = (LinearLayout) this.lCk.findViewById(e.zzf);
        this.ztn = (ImageView) this.lCk.findViewById(e.zzi);
        this.Va = (RecyclerView) this.lCk.findViewById(e.zzg);
        this.Va.Ub = true;
        this.tGi = aZW();
        if (this.ztu == zto) {
            if (this.tGi) {
                this.ztr = 7;
                this.zts = this.ztr * 2;
                this.yIf = com.tencent.mm.bv.a.ab(this.mContext, a$c.zyR) + com.tencent.mm.bv.a.ab(this.mContext, a$c.bxB);
            } else {
                this.yIf = com.tencent.mm.bv.a.ab(this.mContext, a$c.zyQ) + com.tencent.mm.bv.a.ab(this.mContext, a$c.bxB);
            }
            if (this.ztv) {
                this.yIf += com.tencent.mm.bv.a.ab(this.mContext, a$c.bxB);
            }
        } else if (this.ztu == ztq) {
            this.ztk = true;
            ab = com.tencent.mm.bv.a.ab(this.mContext, a$c.zyY);
            if (this.tGi) {
                this.ztt = 2;
                this.yIf = ((int) (((double) ab) * 2.5d)) + com.tencent.mm.bv.a.ab(this.mContext, a$c.zyX);
            } else {
                this.ztt = 3;
                this.yIf = ((int) (((double) ab) * 3.5d)) + com.tencent.mm.bv.a.ab(this.mContext, a$c.zyX);
            }
            if (this.ztv) {
                this.yIf += com.tencent.mm.bv.a.fromDPToPix(this.mContext, 88);
            }
        } else {
            this.ztl = true;
            ab = com.tencent.mm.bv.a.ab(this.mContext, a$c.zyZ);
            if (this.tGi) {
                this.ztt = 4;
                this.yIf = ((int) (((double) ab) * 4.5d)) + com.tencent.mm.bv.a.ab(this.mContext, a$c.zyX);
            } else {
                this.ztt = 6;
                this.yIf = ((int) (((double) ab) * 6.5d)) + com.tencent.mm.bv.a.ab(this.mContext, a$c.zyX);
            }
            if (this.ztv) {
                this.yIf += com.tencent.mm.bv.a.ab(this.mContext, a$c.bxB);
            }
            if (this.ztA) {
                ab = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 24);
                this.ztn.setPadding(ab, 0, ab, 0);
            }
        }
        if (this.ztv && this.ztn != null && this.zty) {
            this.ztn.setVisibility(0);
        }
        if (this.ztu == zto) {
            this.Va.a(new GridLayoutManager(this.mContext, this.ztr));
            int ab2 = com.tencent.mm.bv.a.ab(this.mContext, a$c.bxA);
            ab = com.tencent.mm.bv.a.ab(this.mContext, a$c.bxB);
            if (this.ztv) {
                ab = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 0);
            }
            this.Va.setPadding(ab2, ab, ab2, 0);
        } else {
            this.Va.a(new LinearLayoutManager());
        }
        this.zti = new b(this);
        this.zti.SY = new 1(this);
        this.Va.a(this.zti);
        this.Va.setOverScrollMode(1);
        this.ztc.setContentView(this.lCk);
        if (!this.ztA) {
            this.yIg = BottomSheetBehavior.i((View) this.lCk.getParent());
            this.yIg.q(this.yIf);
            this.yIg.fs = new 2(this);
        }
        this.ztc.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ g ztC;

            {
                this.ztC = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.ztC.ztc = null;
            }
        });
    }

    public final void dO(View view) {
        if (view != null) {
            this.ztv = true;
            if (this.ztn != null) {
                this.ztn.setVisibility(0);
            }
            if (this.ztg != null) {
                this.ztg.setVisibility(0);
                this.ztg.removeAllViews();
                this.ztg.setGravity(17);
                this.ztg.addView(view, -1, -2);
            }
        }
    }

    public final void e(CharSequence charSequence, int i) {
        if (this.ztg != null && this.ztv) {
            this.ztg.setVisibility(0);
            this.ztg.removeAllViews();
            this.ztg.setGravity(i);
            View inflate = LayoutInflater.from(this.mContext).inflate(f.zzx, null);
            TextView textView = (TextView) inflate.findViewById(e.gWR);
            textView.setText(charSequence);
            textView.setGravity(i | 80);
            this.ztg.addView(inflate, -1, -2);
        }
    }

    public final void bUk() {
        this.tGi = aZW();
        this.ztm = getRotation();
        if (this.rKC != null) {
            this.rKC.a(this.rKE);
        }
        if (this.ztc != null) {
            int ab;
            LayoutParams layoutParams = (LayoutParams) this.lCk.getLayoutParams();
            int size = this.rKE.size();
            if (this.ztj) {
                size++;
            } else if (this.zte.size() > 0) {
                size += this.zte.size();
            }
            if (this.ztA) {
                ab = com.tencent.mm.bv.a.ab(this.mContext, a$c.zyZ);
                if (this.ztv) {
                    this.yIf = (((int) (((double) ab) * 4.5d)) + com.tencent.mm.bv.a.fromDPToPix(this.mContext, 132)) + com.tencent.mm.bv.a.ab(this.mContext, a$c.zyX);
                } else {
                    this.yIf = (int) (((double) ab) * 6.5d);
                }
            }
            if (this.ztu == zto) {
                if (this.zti.getItemCount() > this.zts) {
                    layoutParams.height = this.yIf;
                }
            } else if (size > this.ztt) {
                layoutParams.height = this.yIf;
            }
            if (this.tGi && this.hH != null) {
                Rect rect = new Rect();
                this.hH.getWindowVisibleDisplayFrame(rect);
                if (this.ztA) {
                    layoutParams.width = (int) ((((float) rect.right) * 1.0f) / 2.0f);
                    layoutParams.height = rect.bottom;
                    if (this.ztv) {
                        ab = com.tencent.mm.bv.a.ab(this.mContext, a$c.zyZ);
                        if (size <= this.ztt) {
                            size = layoutParams.height - (size * ab);
                        } else {
                            size = layoutParams.height - ((int) (((double) ((float) ab)) * (((double) this.ztt) + 0.5d)));
                            if (size > com.tencent.mm.bv.a.fromDPToPix(this.mContext, 150)) {
                                size -= ab;
                            }
                        }
                        if (this.ztg != null) {
                            this.ztg.setMinimumHeight(size);
                        }
                    }
                } else {
                    layoutParams.width = rect.right;
                }
            }
            this.lCk.setLayoutParams(layoutParams);
            if (!(this.zte == null || this.zti == null)) {
                this.zti.UR.notifyChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.ztc.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.tGj && VERSION.SDK_INT >= 23 && this.ztc != null) {
                this.ztc.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.ztc.getWindow().setStatusBarColor(0);
            }
            if (this.tGk) {
                this.ztc.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            if (this.tGl) {
                this.ztc.getWindow().setFlags(8, 8);
                this.ztc.getWindow().addFlags(131200);
                this.ztc.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.ztc.getWindow().clearFlags(8);
                this.ztc.getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                this.ztc.getWindow().clearFlags(FileUtils.S_IWUSR);
                this.ztc.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.yIg != null) {
                this.yIg.fj = false;
            }
            if (this.ztB != null) {
                this.ztc.setOnDismissListener(new 4(this));
            }
            if (this.hH != null) {
                boolean z = this.Md == null;
                this.Md = this.hH.getViewTreeObserver();
                if (z) {
                    this.Md.addOnGlobalLayoutListener(this);
                }
            }
            this.ztc.show();
        }
    }

    public final void cyK() {
        if (this.ztc != null) {
            if (!(this.zte == null || this.zti == null)) {
                this.zti.UR.notifyChanged();
            }
            this.ztc.show();
        }
    }

    public final void bxh() {
        if (this.Md != null) {
            if (!this.Md.isAlive()) {
                this.Md = this.hH.getViewTreeObserver();
            }
            this.Md.removeGlobalOnLayoutListener(this);
            this.Md = null;
        }
        if (this.ztc != null) {
            if (this.yIg != null) {
                this.yIg.fj = true;
            }
            this.ztc.dismiss();
        }
    }

    public final boolean isShowing() {
        if (this.ztc == null || !this.ztc.isShowing()) {
            return false;
        }
        return true;
    }

    private boolean aZW() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
