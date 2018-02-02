package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.ArrayList;

public class AutoResizeTextView extends TextView {
    private a nxy;

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(attributeSet);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(attributeSet);
    }

    private void d(AttributeSet attributeSet) {
        a aVar = new a(this);
        if (attributeSet != null) {
            int i = (int) aVar.nxE;
            float f = aVar.nxG;
            float f2 = (float) i;
            Context context = aVar.kO.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            float applyDimension = TypedValue.applyDimension(0, f2, system.getDisplayMetrics());
            if (applyDimension != aVar.nxE) {
                aVar.nxE = applyDimension;
                aVar.aRX();
            }
            if (aVar.nxG != f) {
                aVar.nxG = f;
                aVar.aRX();
            }
        }
        if (!aVar.AW) {
            aVar.AW = true;
            aVar.kO.addTextChangedListener(aVar.XD);
            aVar.aRX();
        }
        if (aVar.mListeners == null) {
            aVar.mListeners = new ArrayList();
        }
        aVar.mListeners.add(this);
        this.nxy = aVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nxy != null) {
            this.nxy.aRX();
        }
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        if (this.nxy != null) {
            a aVar = this.nxy;
            if (!aVar.nxH) {
                Context context = aVar.kO.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                aVar.ai(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
            }
        }
    }

    public void setLines(int i) {
        super.setLines(i);
        if (this.nxy != null) {
            this.nxy.rc(i);
        }
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        if (this.nxy != null) {
            this.nxy.rc(i);
        }
    }
}
