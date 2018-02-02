package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private List<b> ohS = new LinkedList();
    private boolean ohT = false;
    private boolean ohU = false;
    private TextView ohV;

    public final void a(b bVar) {
        if (bVar != null) {
            this.ohS.add(bVar);
        }
    }

    public final void g(TextView textView) {
        if (textView != null) {
            this.ohV = textView;
        }
    }

    public final void clear() {
        this.ohS.clear();
        this.ohV = null;
    }

    public final boolean aXE() {
        this.ohU = false;
        this.ohT = false;
        for (int i = 0; i < this.ohS.size(); i++) {
            b bVar = (b) this.ohS.get(i);
            int aXG = bVar.aXG();
            if (aXG != 0) {
                bVar.onError();
                CharSequence sg = bVar.sg(aXG);
                if (!(this.ohV == null || bh.ov(sg))) {
                    if (!this.ohT) {
                        this.ohV.setText(sg);
                    }
                    this.ohV.setVisibility(0);
                    this.ohT = true;
                }
                this.ohU = true;
            } else {
                bVar.restore();
            }
        }
        if (!(this.ohU || this.ohV == null)) {
            this.ohV.setVisibility(8);
            this.ohT = false;
        }
        return this.ohU;
    }

    public final boolean aXF() {
        for (int i = 0; i < this.ohS.size(); i++) {
            if (((b) this.ohS.get(i)).aXG() != 0) {
                return true;
            }
        }
        return false;
    }

    public final void sh(String str) {
        if (this.ohV != null && !bh.ov(str)) {
            this.ohV.setText(str);
            this.ohV.setVisibility(0);
            this.ohT = true;
        } else if (this.ohV != null) {
            this.ohV.setVisibility(8);
            this.ohT = false;
        }
    }
}
