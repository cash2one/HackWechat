package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.au;

public abstract class a {
    protected b yCR;

    public a(b bVar) {
        this.yCR = bVar;
    }

    public void detach() {
        this.yCR = null;
    }

    public boolean a(j jVar, au auVar, int i) {
        return false;
    }

    public final j FJ(int i) {
        if (this.yCR == null) {
            return null;
        }
        View EQ = this.yCR.EQ(i);
        return EQ == null ? null : (j) EQ.getTag();
    }

    public final void FK(int i) {
        if (this.yCR != null) {
            View EQ = this.yCR.EQ(i);
            if (EQ != null && EQ.getTag() != null) {
                a((j) EQ.getTag(), this.yCR.FL(i), i);
            }
        }
    }
}
