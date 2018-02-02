package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

public class GameMessageListContainerView extends LinearLayout {
    private Context mContext;

    public GameMessageListContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public final void a(t tVar, LinkedList<h> linkedList, int i, int i2, f<String, Bitmap> fVar) {
        if (tVar == null || bh.cA(linkedList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int i3 = i > linkedList.size() ? 1 : 2;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.buo);
        while (getChildCount() < i3) {
            View gameMessageListUserIconView = new GameMessageListUserIconView(this.mContext);
            if (getChildCount() > 0) {
                gameMessageListUserIconView.setPadding(0, dimensionPixelSize, 0, 0);
            }
            if (gameMessageListUserIconView.ntd != null) {
                gameMessageListUserIconView.ntd.ndn = i2;
            } else {
                gameMessageListUserIconView.ntd = new u(gameMessageListUserIconView.mContext, i2);
            }
            addView(gameMessageListUserIconView);
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (i4 < i3) {
                getChildAt(i4).setVisibility(0);
                GameMessageListUserIconView gameMessageListUserIconView2 = (GameMessageListUserIconView) getChildAt(i4);
                LinkedList linkedList2 = new LinkedList();
                int i5 = i4 * i;
                while (i5 < (i4 + 1) * i && i5 < linkedList.size()) {
                    linkedList2.add(linkedList.get(i5));
                    i5++;
                }
                gameMessageListUserIconView2.a(tVar, linkedList2, fVar);
            } else {
                getChildAt(i4).setVisibility(8);
            }
        }
    }
}
