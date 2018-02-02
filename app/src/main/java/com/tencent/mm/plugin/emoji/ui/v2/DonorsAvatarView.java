package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.protocal.c.sl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class DonorsAvatarView extends LinearLayout {
    private int lFa;
    private int lFb;
    private int lFc;
    private int lFd;
    private LayoutParams lFe;
    private int mMaxCount;

    public DonorsAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DonorsAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(0);
        this.lFa = a.eA(getContext());
        this.lFb = a.aa(getContext(), R.f.bwZ);
        this.lFc = a.aa(getContext(), R.f.buo);
        this.lFd = a.aa(getContext(), R.f.bvJ);
        this.lFe = new LayoutParams(this.lFb, this.lFb);
        this.lFe.leftMargin = this.lFc;
        this.lFe.rightMargin = this.lFc;
        this.mMaxCount = (this.lFa - (this.lFd * 2)) / (this.lFb + (this.lFc * 2));
        x.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", Integer.valueOf(this.mMaxCount));
    }

    public final void b(String str, LinkedList<sl> linkedList) {
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size() > this.mMaxCount ? this.mMaxCount : linkedList.size();
            for (int i = 0; i < size; i++) {
                sl slVar = (sl) linkedList.get(i);
                if (slVar != null) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.lFe);
                    if (bh.ov(slVar.waN)) {
                        try {
                            imageView.setImageBitmap(b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", e, "", new Object[0]);
                        }
                    } else {
                        o.PA().a(slVar.waN, imageView, f.h(str, slVar.waN, new Object[0]));
                    }
                    addView(imageView);
                }
            }
        }
    }
}
