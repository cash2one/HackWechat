package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class NotInterestMenu$1 implements OnItemClickListener {
    final /* synthetic */ NotInterestMenu qNB;

    NotInterestMenu$1(NotInterestMenu notInterestMenu) {
        this.qNB = notInterestMenu;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (NotInterestMenu.a(this.qNB) != null) {
            NotInterestMenu.a(this.qNB).btS();
        }
        if (NotInterestMenu.b(this.qNB) != null) {
            switch (i) {
                case 0:
                    NotInterestMenu.b(this.qNB).c(NotInterestMenu.c(this.qNB));
                    return;
                case 1:
                    NotInterestMenu.b(this.qNB).d(NotInterestMenu.c(this.qNB));
                    return;
                case 2:
                    NotInterestMenu.b(this.qNB).e(NotInterestMenu.c(this.qNB));
                    return;
                default:
                    return;
            }
        }
    }
}
