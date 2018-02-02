package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

public class AutoScrollTextView extends LinearLayout {
    private int lHX = 0;
    private ak nlD = new ak(new 1(this), true);
    private ArrayList<String> nnS = new ArrayList();
    private Animation nnZ;
    private Animation noa;
    private TextView nxA;
    private TextView nxz;

    static /* synthetic */ void a(AutoScrollTextView autoScrollTextView) {
        if (autoScrollTextView.nnS.size() >= 2) {
            CharSequence charSequence;
            if (autoScrollTextView.lHX < autoScrollTextView.nnS.size() - 1) {
                autoScrollTextView.lHX++;
                charSequence = (String) autoScrollTextView.nnS.get(autoScrollTextView.lHX);
            } else {
                autoScrollTextView.lHX = 0;
                String str = (String) autoScrollTextView.nnS.get(autoScrollTextView.lHX);
            }
            TextView textView = autoScrollTextView.nxA;
            textView.setText(new SpannableString(i.b(autoScrollTextView.getContext(), charSequence, textView.getTextSize())));
            autoScrollTextView.nxz.startAnimation(autoScrollTextView.noa);
            autoScrollTextView.nxz.setVisibility(8);
            autoScrollTextView.nxA.startAnimation(autoScrollTextView.nnZ);
            autoScrollTextView.nxA.setVisibility(0);
            TextView textView2 = autoScrollTextView.nxz;
            autoScrollTextView.nxz = autoScrollTextView.nxA;
            autoScrollTextView.nxA = textView2;
        }
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nxz = new TextView(context, attributeSet);
        this.nxz.setVisibility(8);
        this.nxA = new TextView(context, attributeSet);
        this.nxA.setVisibility(8);
        addView(this.nxz);
        addView(this.nxA);
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.nnZ = AnimationUtils.loadAnimation(context, R.a.bqy);
        this.noa = AnimationUtils.loadAnimation(context, R.a.bqE);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nlD.TG();
    }
}
