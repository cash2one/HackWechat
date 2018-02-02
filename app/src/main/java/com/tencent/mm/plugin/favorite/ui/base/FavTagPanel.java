package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel extends MMTagPanel {
    public LinkedList<d> mvo = new LinkedList();
    a mvp = null;
    public OnClickListener mvq = new 1(this);

    public FavTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void aJB() {
        if (this.wfh.size() <= 0 && !this.mvo.isEmpty()) {
            String str = ((d) this.mvo.getLast()).yec;
            At(str);
            if (this.mvp != null) {
                this.mvp.Ar(str);
            }
            cpJ();
        }
    }

    public final void At(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.FavTagPanel", "want to remove type, but it is null or empty");
            return;
        }
        Iterator it = this.mvo.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.yec)) {
                this.mvo.remove(dVar);
                removeView(dVar.yed);
                a(dVar);
                cpJ();
                return;
            }
        }
        x.w("MicroMsg.FavTagPanel", "want to remove type %s, but it not exsited!", new Object[]{str});
    }
}
