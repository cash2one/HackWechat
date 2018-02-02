package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel$a;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView extends LinearLayout {
    public FavTagPanel mtA;
    public List<Integer> mur = new LinkedList();
    private ImageButton mvg;
    public List<String> mvh = new LinkedList();
    public List<String> mvi = new LinkedList();
    public a mvj;

    public FavSearchActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mvg = (ImageButton) findViewById(R.h.cJt);
        this.mtA = (FavTagPanel) findViewById(R.h.chj);
        if (this.mtA != null) {
            MMTagPanel mMTagPanel = this.mtA;
            int color = getResources().getColor(R.e.white);
            if (mMTagPanel.ydO != null) {
                mMTagPanel.ydO.setTextColor(color);
            }
            this.mtA.ydF = 0;
            this.mtA.ydH = 0;
            this.mtA.nKq = 0;
            this.mtA.nKr = R.e.bui;
            this.mtA.muC = 0;
            this.mtA.muB = R.e.white;
            this.mtA.YL(getResources().getString(R.l.dGz));
            this.mtA.ms(true);
            this.mtA.ydC = false;
            this.mtA.ydD = true;
            mMTagPanel = this.mtA;
            MMTagPanel$a 1 = new 1(this);
            mMTagPanel.mvp = 1;
            mMTagPanel.ydL = 1;
        }
        if (this.mvg != null) {
            this.mvg.setOnClickListener(new 2(this));
        }
    }

    public final void Aq(String str) {
        this.mvi.clear();
        for (String str2 : bh.az(str, "").split(" ")) {
            if (!bh.ov(str2)) {
                this.mvi.add(str2);
            }
        }
    }

    public final void aJA() {
        if (this.mur.isEmpty() && this.mvh.isEmpty()) {
            this.mtA.YL(getResources().getString(R.l.dGz));
        } else {
            this.mtA.YL("");
        }
    }
}
