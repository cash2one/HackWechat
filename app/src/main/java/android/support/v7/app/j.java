package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.a.a.a;
import android.support.v7.view.b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class j extends Dialog implements d {
    private e mDelegate;

    public j(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(a.dialogTheme, typedValue, true);
            i = typedValue.resourceId;
        }
        super(context, i);
        getDelegate().onCreate(null);
        getDelegate().cT();
    }

    public void onCreate(Bundle bundle) {
        getDelegate().cS();
        super.onCreate(bundle);
        getDelegate().onCreate(bundle);
    }

    public void setContentView(int i) {
        getDelegate().setContentView(i);
    }

    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    public View findViewById(int i) {
        return getDelegate().findViewById(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().setTitle(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().setTitle(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public final boolean da() {
        return getDelegate().requestWindowFeature(1);
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    private e getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = e.a((Dialog) this, (d) this);
        }
        return this.mDelegate;
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }
}
