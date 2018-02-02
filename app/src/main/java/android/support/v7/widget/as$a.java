package android.support.v7.widget;

import android.support.v4.e.i$a;
import android.support.v4.e.i.b;
import android.support.v7.widget.RecyclerView.e.c;

class as$a {
    static i$a<as$a> aaw = new b(20);
    c aau;
    c aav;
    int flags;

    private as$a() {
    }

    static as$a hd() {
        as$a android_support_v7_widget_as_a = (as$a) aaw.bG();
        return android_support_v7_widget_as_a == null ? new as$a() : android_support_v7_widget_as_a;
    }

    static void a(as$a android_support_v7_widget_as_a) {
        android_support_v7_widget_as_a.flags = 0;
        android_support_v7_widget_as_a.aau = null;
        android_support_v7_widget_as_a.aav = null;
        aaw.j(android_support_v7_widget_as_a);
    }

    static void he() {
        do {
        } while (aaw.bG() != null);
    }
}
