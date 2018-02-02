package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.c.a.b;
import android.support.v4.e.j;
import android.support.v7.view.menu.n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public final class f extends ActionMode {
    final b Jx;
    final Context mContext;

    public static class a implements android.support.v7.view.b.a {
        final j<Menu, Menu> JA = new j();
        final Callback Jy;
        final ArrayList<f> Jz = new ArrayList();
        final Context mContext;

        public a(Context context, Callback callback) {
            this.mContext = context;
            this.Jy = callback;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.Jy.onCreateActionMode(b(bVar), b(menu));
        }

        public final boolean b(b bVar, Menu menu) {
            return this.Jy.onPrepareActionMode(b(bVar), b(menu));
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.Jy.onActionItemClicked(b(bVar), n.a(this.mContext, (b) menuItem));
        }

        public final void a(b bVar) {
            this.Jy.onDestroyActionMode(b(bVar));
        }

        private Menu b(Menu menu) {
            Menu menu2 = (Menu) this.JA.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = n.a(this.mContext, (android.support.v4.c.a.a) menu);
            this.JA.put(menu, menu2);
            return menu2;
        }

        public final ActionMode b(b bVar) {
            int size = this.Jz.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.Jz.get(i);
                if (fVar != null && fVar.Jx == bVar) {
                    return fVar;
                }
            }
            ActionMode fVar2 = new f(this.mContext, bVar);
            this.Jz.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.mContext = context;
        this.Jx = bVar;
    }

    public final Object getTag() {
        return this.Jx.Jt;
    }

    public final void setTag(Object obj) {
        this.Jx.Jt = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.Jx.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.Jx.setSubtitle(charSequence);
    }

    public final void invalidate() {
        this.Jx.invalidate();
    }

    public final void finish() {
        this.Jx.finish();
    }

    public final Menu getMenu() {
        return n.a(this.mContext, (android.support.v4.c.a.a) this.Jx.getMenu());
    }

    public final CharSequence getTitle() {
        return this.Jx.getTitle();
    }

    public final void setTitle(int i) {
        this.Jx.setTitle(i);
    }

    public final CharSequence getSubtitle() {
        return this.Jx.getSubtitle();
    }

    public final void setSubtitle(int i) {
        this.Jx.setSubtitle(i);
    }

    public final View getCustomView() {
        return this.Jx.getCustomView();
    }

    public final void setCustomView(View view) {
        this.Jx.setCustomView(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.Jx.getMenuInflater();
    }

    public final boolean getTitleOptionalHint() {
        return this.Jx.Ju;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.Jx.setTitleOptionalHint(z);
    }

    public final boolean isTitleOptional() {
        return this.Jx.isTitleOptional();
    }
}
