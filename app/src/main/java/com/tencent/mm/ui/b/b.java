package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.f;
import android.support.v7.widget.u;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public final class b extends a implements android.support.v7.view.menu.f.a, android.support.v7.view.menu.l.a {
    public ViewGroup Fl;
    private boolean Hf;
    private f eg;
    a xVu;
    boolean xVv;
    private final Runnable xVw = new Runnable(this) {
        final /* synthetic */ b xVx;

        {
            this.xVx = r1;
        }

        public final void run() {
            android.support.v7.view.menu.f.a aVar = this.xVx;
            Context context = aVar.mActivity;
            ActionBar supportActionBar = aVar.getSupportActionBar();
            if (supportActionBar != null) {
                context = supportActionBar.getThemedContext();
            }
            f fVar = new f(context);
            fVar.a(aVar);
            if (this.xVx.xVu != null) {
                this.xVx.xVu.d(fVar);
                this.xVx.xVu.c(fVar);
                b.a(this.xVx, fVar);
            } else {
                b.a(this.xVx, null);
            }
            fVar.h(true);
            this.xVx.xVv = false;
        }
    };

    public interface a {
        boolean c(Menu menu);

        boolean d(Menu menu);

        boolean j(MenuItem menuItem);
    }

    static /* synthetic */ void a(b bVar, f fVar) {
        if (fVar != bVar.eg) {
            bVar.eg = fVar;
            if (bVar.mActionBar != null) {
                ((d) bVar.mActionBar).HT.a((Menu) fVar, (android.support.v7.view.menu.l.a) bVar);
            }
        }
    }

    public b(Activity activity, a aVar) {
        super(activity);
        this.xVu = aVar;
    }

    public final ActionBar coB() {
        if (!this.Hf) {
            this.Hf = true;
            supportInvalidateOptionsMenu();
        }
        if (this.mActionBar == null) {
            this.mActionBar = new d(this.mActivity, this.Fl);
        }
        return this.mActionBar;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        if (this.xVu != null) {
            return this.xVu.j(menuItem);
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.mActionBar != null) {
            u uVar = ((d) this.mActionBar).HT;
            if (uVar != null && uVar.dU()) {
                if (uVar.isOverflowMenuShowing()) {
                    uVar.hideOverflowMenu();
                    return;
                } else if (uVar.getVisibility() == 0) {
                    uVar.showOverflowMenu();
                    return;
                } else {
                    return;
                }
            }
        }
        fVar.close();
    }

    public final void a(f fVar, boolean z) {
    }

    public final boolean d(f fVar) {
        return false;
    }

    public final void supportInvalidateOptionsMenu() {
        if (!this.xVv) {
            this.xVv = true;
            this.xVw.run();
        }
    }
}
