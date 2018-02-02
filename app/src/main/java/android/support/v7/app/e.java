package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.a.a;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class e {
    static int GE = -1;
    private static boolean GF = false;

    public abstract void addContentView(View view, LayoutParams layoutParams);

    public abstract void cR();

    public abstract void cS();

    public abstract boolean cT();

    public abstract View findViewById(int i);

    public abstract a getDrawerToggleDelegate();

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract void invalidateOptionsMenu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, LayoutParams layoutParams);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charSequence);

    public abstract b startSupportActionMode(b.a aVar);

    public static e a(Activity activity, d dVar) {
        return a(activity, activity.getWindow(), dVar);
    }

    public static e a(Dialog dialog, d dVar) {
        return a(dialog.getContext(), dialog.getWindow(), dVar);
    }

    private static e a(Context context, Window window, d dVar) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return new i(context, window, dVar);
        }
        if (i >= 14) {
            return new h(context, window, dVar);
        }
        if (i >= 11) {
            return new g(context, window, dVar);
        }
        return new AppCompatDelegateImplV7(context, window, dVar);
    }

    e() {
    }

    public static boolean cU() {
        return GF;
    }
}
