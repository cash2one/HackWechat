package com.tencent.mm.platformtools;

import android.os.Build.VERSION;
import android.widget.ListView;

public class a$b {
    public static void a(ListView listView) {
        if (VERSION.SDK_INT >= 8) {
            p pVar = new p();
            if (listView.getFirstVisiblePosition() > 10) {
                listView.setSelection(10);
            }
            if (VERSION.SDK_INT >= 8) {
                listView.smoothScrollToPosition(0);
                return;
            }
            return;
        }
        o oVar = new o();
        listView.setSelection(0);
    }
}
