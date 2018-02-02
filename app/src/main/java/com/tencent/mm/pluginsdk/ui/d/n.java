package com.tencent.mm.pluginsdk.ui.d;

import android.view.View;

public class n extends m {
    private Object tag;
    private a vvg;

    public interface a {
        void bJ(Object obj);
    }

    public n(Object obj, a aVar) {
        super(2, null);
        this.vvg = aVar;
        this.tag = obj;
    }

    public n(Object obj, a aVar, int i) {
        super(2, null);
        this.vvg = aVar;
        this.tag = obj;
        zs(i);
    }

    public void onClick(View view) {
        if (this.vvg != null) {
            this.vvg.bJ(this.tag);
        }
    }
}
