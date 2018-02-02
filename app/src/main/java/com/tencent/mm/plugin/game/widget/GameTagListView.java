package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class GameTagListView extends LinearLayout {
    private int textColor;
    private int textSize;

    public GameTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.textColor = getResources().getColor(R.e.bsy);
        this.textSize = getResources().getDimensionPixelSize(R.f.bvk);
    }

    public final void e(LinkedList<String> linkedList, int i) {
        if (bh.cA(linkedList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            View textView = new TextView(getContext());
            textView.setBackgroundResource(R.g.bCI);
            textView.setMaxLines(1);
            textView.setTextColor(this.textColor);
            textView.setTextSize(0, (float) this.textSize);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.f.bvj), 0);
            textView.setLayoutParams(layoutParams);
            addView(textView);
        }
        int i2 = 0;
        float f = 0.0f;
        while (i2 < linkedList.size()) {
            String str = (String) linkedList.get(i2);
            x.d("MicroMsg.GameTagListView", str);
            TextView textView2 = (TextView) getChildAt(i2);
            textView2.setVisibility(0);
            textView2.setText(str);
            f = ((float) getResources().getDimensionPixelSize(R.f.bvj)) + (((textView2.getPaint().measureText(str) + ((float) textView2.getPaddingLeft())) + ((float) textView2.getPaddingRight())) + f);
            if (f > ((float) i)) {
                textView2.setVisibility(8);
                break;
            }
            i2++;
        }
        while (i2 < getChildCount()) {
            int i3 = i2 + 1;
            getChildAt(i2).setVisibility(8);
            i2 = i3;
        }
    }
}
