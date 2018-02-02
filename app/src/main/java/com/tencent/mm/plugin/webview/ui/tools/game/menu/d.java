package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView.1;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.ui.base.n;
import com.tencent.wcdb.FileUtils;

public final class d implements OnGlobalLayoutListener {
    private ViewTreeObserver Md;
    private View hH;
    private Context mContext;
    private n rKE;
    private e tGe;
    public b tGf;
    private GameMenuView tGg;
    private f tGh;
    private boolean tGi = false;
    private boolean tGj;
    public boolean tGk;
    public boolean tGl = false;

    public final void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hH;
            if (view == null || !view.isShown()) {
                bxh();
            } else if (isShowing() && this.tGi != aZW()) {
                bxh();
            }
        }
    }

    public d(Context context) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hH = viewGroup.getChildAt(0);
            } else {
                this.hH = viewGroup;
            }
        }
        Context context2 = this.mContext;
        this.rKE = new n();
        this.tGe = new e(context2);
        this.tGg = new GameMenuView(context2);
        this.tGh = new f(context2);
        GameMenuView gameMenuView = this.tGg;
        f fVar = this.tGh;
        gameMenuView.tGq = fVar;
        fVar.registerDataSetObserver(new 1(gameMenuView));
        fVar.notifyDataSetChanged();
        this.tGi = aZW();
        this.tGe.setContentView(this.tGg);
    }

    public final void bUk() {
        int i = 0;
        this.tGi = aZW();
        if (this.tGf != null) {
            this.tGf.a(this.rKE);
        }
        if (this.tGe != null) {
            if (this.tGh != null) {
                f fVar = this.tGh;
                fVar.rKE = this.rKE;
                fVar.notifyDataSetChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.tGe.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.tGj && VERSION.SDK_INT >= 23 && this.tGe != null) {
                this.tGe.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.tGe.getWindow().setStatusBarColor(0);
            }
            if (this.tGk) {
                this.tGe.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            if (this.tGl) {
                this.tGe.getWindow().setFlags(8, 8);
                this.tGe.getWindow().addFlags(131200);
                this.tGe.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.tGe.getWindow().clearFlags(8);
                this.tGe.getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                this.tGe.getWindow().clearFlags(FileUtils.S_IWUSR);
                this.tGe.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.hH != null) {
                if (this.Md == null) {
                    i = 1;
                }
                this.Md = this.hH.getViewTreeObserver();
                if (i != 0) {
                    this.Md.addOnGlobalLayoutListener(this);
                }
            }
            this.tGe.setOnDismissListener(new 1(this));
            if (this.tGg != null) {
                this.tGg.tGs = new a(this) {
                    final /* synthetic */ d tGm;

                    {
                        this.tGm = r1;
                    }

                    public final void onDismiss() {
                        this.tGm.bxh();
                    }
                };
            }
            this.tGe.show();
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
        if (this.tGe != null) {
            this.tGe.dismiss();
        }
    }

    private boolean isShowing() {
        if (this.tGe == null || !this.tGe.isShowing()) {
            return false;
        }
        return true;
    }

    public final void a(c cVar) {
        if (this.tGg != null) {
            this.tGg.tGr = cVar;
        }
    }

    private boolean aZW() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
