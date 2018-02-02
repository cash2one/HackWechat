package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import android.support.v4.app.o;
import java.util.ArrayList;
import java.util.List;

public final class c extends o {
    public List<Fragment> qj = new ArrayList();

    public c(m mVar, List<Fragment> list) {
        super(mVar);
        this.qj = list;
    }

    public final Fragment R(int i) {
        return (Fragment) this.qj.get(i);
    }

    public final int getCount() {
        return this.qj.size();
    }

    public final CharSequence bL() {
        return "";
    }

    public final void a(Fragment fragment, int i) {
        this.qj.remove(fragment);
        if (i >= this.qj.size()) {
            this.qj.add(fragment);
        } else {
            this.qj.add(i, fragment);
        }
    }
}
