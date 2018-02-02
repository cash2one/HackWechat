package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Observable;

class cm extends Observable implements OnSharedPreferenceChangeListener {
    private static String a = "cc_c_t_m_l_";
    private static volatile cm b = null;
    private static volatile Context c = null;
    private static volatile SharedPreferences d = null;

    protected static void a(Context context, String str) {
        if (context == null || context.getApplicationContext() == null) {
            throw new NullPointerException("context cannot be null!");
        }
        c = context.getApplicationContext();
        a = "cc_c_t_m_l_" + str;
    }

    protected static synchronized cm a() {
        cm cmVar;
        synchronized (cm.class) {
            if (b == null) {
                synchronized (cm.class) {
                    b = new cm();
                }
            }
            cmVar = b;
        }
        return cmVar;
    }

    private cm() {
        if (c != null) {
            d = c.getSharedPreferences(a, 0);
        }
    }

    protected final synchronized SharedPreferences b() {
        SharedPreferences sharedPreferences;
        if (c == null) {
            sharedPreferences = null;
        } else {
            if (d == null) {
                d = c.getSharedPreferences(a, 0);
            }
            sharedPreferences = d;
        }
        return sharedPreferences;
    }

    protected final synchronized void c() {
        if (d != null) {
            addObserver(cl.a());
            d.registerOnSharedPreferenceChangeListener(this);
        }
    }

    protected final synchronized void d() {
        if (d != null) {
            d.unregisterOnSharedPreferenceChangeListener(this);
            deleteObserver(cl.a());
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        setChanged();
        notifyObservers(str);
    }
}
