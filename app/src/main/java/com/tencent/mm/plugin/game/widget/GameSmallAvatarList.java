package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

public class GameSmallAvatarList extends LinearLayout {
    public GameSmallAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void H(LinkedList<String> linkedList) {
        if (bh.cA(linkedList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            View imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.f.bvm), getResources().getDimensionPixelSize(R.f.bvm));
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.f.bvj), 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            addView(imageView);
        }
        int i = 0;
        while (i < linkedList.size()) {
            a aVar = new a();
            aVar.hDY = true;
            e.aRV().a((ImageView) getChildAt(i), (String) linkedList.get(i), aVar.aRW());
            getChildAt(i).setVisibility(0);
            i++;
        }
        while (i < getChildCount()) {
            int i2 = i + 1;
            getChildAt(i).setVisibility(8);
            i = i2;
        }
    }
}
