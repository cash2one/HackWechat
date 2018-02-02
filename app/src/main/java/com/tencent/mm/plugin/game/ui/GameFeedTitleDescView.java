package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.z;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

public class GameFeedTitleDescView extends LinearLayout {
    private TextView jJn;
    private TextView lkn;
    private LinearLayout nqG;

    public GameFeedTitleDescView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.i.dkr, this, true);
        this.nqG = (LinearLayout) inflate.findViewById(R.h.cUo);
        this.jJn = (TextView) inflate.findViewById(R.h.title);
        this.lkn = (TextView) inflate.findViewById(R.h.caP);
    }

    public final void a(String str, String str2, LinkedList<z> linkedList) {
        int i = 0;
        if (bh.ov(str) && bh.ov(str2)) {
            setVisibility(8);
            return;
        }
        int i2;
        setVisibility(0);
        if (!bh.cA(linkedList)) {
            this.nqG.setVisibility(0);
            while (this.nqG.getChildCount() < linkedList.size() + 1) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.f.bvm), getResources().getDimensionPixelSize(R.f.bvm));
                layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.f.bvj), 0);
                layoutParams.gravity = 16;
                imageView.setScaleType(ScaleType.FIT_XY);
                this.nqG.addView(imageView, 0, layoutParams);
            }
            int i3 = 0;
            while (i3 < linkedList.size()) {
                z zVar = (z) linkedList.get(i3);
                ImageView imageView2 = (ImageView) this.nqG.getChildAt(i3);
                e aRV = e.aRV();
                String str3 = zVar.nfZ;
                a aVar = new a();
                aVar.hDY = true;
                aRV.a(imageView2, str3, aVar.aRW(), null);
                imageView2.setVisibility(0);
                i3++;
            }
            while (i3 < this.nqG.getChildCount() - 1) {
                i2 = i3 + 1;
                this.nqG.getChildAt(i3).setVisibility(8);
                i3 = i2;
            }
            if (!bh.ov(str)) {
                ((TextView) this.nqG.getChildAt(i3)).setText(str);
            }
            this.jJn.setVisibility(8);
        } else if (bh.ov(str)) {
            this.jJn.setVisibility(8);
        } else {
            this.jJn.setText(str);
            this.jJn.setVisibility(0);
        }
        if (bh.ov(str2)) {
            this.lkn.setVisibility(8);
        } else {
            this.lkn.setText(str2);
            this.lkn.setVisibility(0);
        }
        TextView textView = this.jJn;
        i2 = (c.getScreenWidth(getContext()) - ((ViewGroup) getParent()).getPaddingLeft()) - ((ViewGroup) getParent()).getPaddingRight();
        if (!bh.ov(str)) {
            i = textView.getPaint().measureText(str) > ((float) i2) ? 2 : 1;
        }
        if (i > 1) {
            this.lkn.setMaxLines(1);
        } else {
            this.lkn.setMaxLines(2);
        }
    }
}
