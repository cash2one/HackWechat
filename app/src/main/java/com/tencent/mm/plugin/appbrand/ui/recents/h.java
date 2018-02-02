package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;

abstract class h {
    a jQN;

    abstract void alu();

    abstract View alv();

    abstract void onDetached();

    abstract void onResume();

    h() {
    }

    protected final void dk(boolean z) {
        if (alv() != null) {
            if (z) {
                if (alv().getVisibility() != 0) {
                    alv().setVisibility(0);
                }
            } else if (alv().getVisibility() != 8) {
                alv().setVisibility(8);
            }
            if (this.jQN != null) {
                this.jQN.a(this, alv(), z);
            }
        }
    }

    protected final boolean alz() {
        if (alv() != null && alv().getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
