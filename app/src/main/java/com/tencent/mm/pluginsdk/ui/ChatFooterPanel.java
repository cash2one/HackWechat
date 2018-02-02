package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel extends LinearLayout {
    public static int SCENE_SNS = 2;
    public static int vjE = 0;
    public static int vjF = 1;
    public static int vjG = 3;
    public a vjB;
    public f vjC;
    protected int vjD;

    public static abstract class RecommendView extends LinearLayout {
        public abstract void yN(String str);

        public RecommendView(Context context) {
            super(context);
        }

        public RecommendView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public RecommendView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    public abstract void aE(boolean z);

    public abstract void aF(boolean z);

    public abstract void ce(String str);

    public abstract void cf(String str);

    public abstract void ei(int i);

    public abstract void ej(int i);

    public abstract void g(boolean z, boolean z2);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void refresh();

    public abstract void th();

    public abstract void ti();

    public abstract void tj();

    public abstract void tk();

    public abstract void tl();

    public abstract void tm();

    public ChatFooterPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(f fVar) {
        this.vjC = fVar;
    }

    public final void BQ(int i) {
        this.vjD = i;
    }

    public void destroy() {
    }
}
