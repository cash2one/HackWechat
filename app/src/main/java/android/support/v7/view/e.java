package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class e extends b implements a {
    private b.a IS;
    private WeakReference<View> IT;
    private ActionBarContextView Iu;
    private boolean Jw;
    private f eg;
    private Context mContext;
    private boolean mFinished;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.mContext = context;
        this.Iu = actionBarContextView;
        this.IS = aVar;
        f fVar = new f(actionBarContextView.getContext());
        this.eg = fVar;
        this.eg.a((a) this);
        this.Jw = z;
    }

    public final void setTitle(CharSequence charSequence) {
        this.Iu.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.Iu.setSubtitle(charSequence);
    }

    public final void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public final void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public final void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.Iu.J(z);
    }

    public final boolean isTitleOptional() {
        return this.Iu.ML;
    }

    public final void setCustomView(View view) {
        this.Iu.setCustomView(view);
        this.IT = view != null ? new WeakReference(view) : null;
    }

    public final void invalidate() {
        this.IS.b(this, this.eg);
    }

    public final void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.Iu.sendAccessibilityEvent(32);
            this.IS.a(this);
        }
    }

    public final Menu getMenu() {
        return this.eg;
    }

    public final CharSequence getTitle() {
        return this.Iu.uU;
    }

    public final CharSequence getSubtitle() {
        return this.Iu.uV;
    }

    public final View getCustomView() {
        return this.IT != null ? (View) this.IT.get() : null;
    }

    public final MenuInflater getMenuInflater() {
        return new g(this.Iu.getContext());
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        return this.IS.a((b) this, menuItem);
    }

    public final void b(f fVar) {
        invalidate();
        this.Iu.showOverflowMenu();
    }
}
