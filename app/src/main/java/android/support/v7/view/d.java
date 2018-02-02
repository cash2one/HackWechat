package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.a.a.j;
import android.view.LayoutInflater;

public final class d extends ContextWrapper {
    private LayoutInflater DF;
    public int Jv;
    private Theme mTheme;

    public d(Context context, int i) {
        super(context);
        this.Jv = i;
    }

    public final void setTheme(int i) {
        if (this.Jv != i) {
            this.Jv = i;
            dh();
        }
    }

    public final Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        if (this.Jv == 0) {
            this.Jv = j.Theme_AppCompat_Light;
        }
        dh();
        return this.mTheme;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.DF == null) {
            this.DF = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.DF;
    }

    private void dh() {
        if (this.mTheme == null) {
            this.mTheme = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        this.mTheme.applyStyle(this.Jv, true);
    }
}
