package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.plugin.emoji.model.a;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader extends LinearLayout implements e {
    private View kND;
    private MMDotView kba;
    private ViewPager lDX;
    private LinkedList<a> lDY;
    private i lDZ;
    private float lEa;
    private float lEb;
    private a lEc;
    private volatile boolean lEd;
    private final int lEe = 5;
    private final int lEf = 0;
    private View ltB;

    public EmojiStoreVpHeader(Context context) {
        super(context);
        setOrientation(1);
    }

    public EmojiStoreVpHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    public static int[] aT(Context context) {
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    private synchronized void aDg() {
        if (this.lDY == null) {
            throw new IllegalAccessError("must has emoji baner list first");
        }
        if (this.kND == null) {
            this.kND = inflate(getContext(), R.i.dgh, null);
            this.ltB = this.kND.findViewById(R.h.cdN);
            this.kba = (MMDotView) this.kND.findViewById(R.h.cdM);
            this.lDX = (ViewPager) this.kND.findViewById(R.h.cdO);
            this.lEc = new a(this, (byte) 0);
            int i = ((aT(getContext())[0] * 3) / 8) + 1;
            if (this.ltB != null) {
                this.ltB.setLayoutParams(new LayoutParams(-1, i));
            }
            addView(this.kND, new LayoutParams(-1, -2));
        }
        if (this.kba != null) {
            this.kba.EH(this.lDY == null ? 0 : this.lDY.size());
            this.kba.EI(0);
            this.kba.setVisibility(8);
        }
        if (!(this.lDX == null || this.lDY == null)) {
            if (this.lDY.size() > 0) {
                if (this.ltB != null) {
                    this.ltB.setVisibility(0);
                }
                this.lDX.zo = this;
                if (this.lDZ == null) {
                    this.lDZ = new i(getContext(), this.lDY);
                    this.lDX.a(this.lDZ);
                    ViewPager viewPager = this.lDX;
                    if (1 != viewPager.yW) {
                        viewPager.yW = 1;
                        viewPager.populate();
                    }
                    aDh();
                } else {
                    post(new 1(this));
                }
            } else if (this.ltB != null) {
                this.ltB.setVisibility(8);
            }
        }
    }

    private void aDh() {
        if (this.lDX != null) {
            this.lDX.d((i.lur / 2) * this.lDY.size(), false);
        }
    }

    public final void aDi() {
        if (this.lEc == null) {
            this.lEc = new a(this, (byte) 0);
        }
        this.lEd = true;
        this.lEc.removeMessages(0);
        this.lEc.sendEmptyMessageDelayed(0, 5000);
    }

    public final void aDj() {
        if (this.lEc != null) {
            this.lEd = false;
            this.lEc.removeMessages(0);
        }
    }

    public final void clear() {
        if (this.lDZ != null) {
            i iVar = this.lDZ;
            if (iVar.luq != null) {
                iVar.luq.clear();
            }
            if (iVar.luu != null) {
                iVar.luu.clear();
            }
            iVar.lut = true;
            this.lDZ = null;
        }
        this.lEc = null;
    }

    public final void c(LinkedList<sd> linkedList, LinkedList<sf> linkedList2) {
        if (linkedList != null) {
            if (this.lDY == null) {
                this.lDY = new LinkedList();
            } else {
                this.lDY.clear();
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                sf sfVar = (sf) it.next();
                if (!(sfVar == null || sfVar.wag == null || bh.ov(sfVar.wag.wah))) {
                    this.lDY.add(new a(null, sfVar, true));
                }
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                sd sdVar = (sd) it.next();
                if (!(sdVar == null || sdVar.wag == null || bh.ov(sdVar.wag.wah))) {
                    this.lDY.add(new a(sdVar, null, false));
                }
            }
            aDg();
        }
    }

    public final void af(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        if (this.lDY != null && this.lDY.size() > 1) {
            if (i == 0 || i == this.lDZ.getCount() - 1) {
                this.kND.postDelayed(new 2(this), 350);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int action2 = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action2) {
            case 0:
                this.lEa = rawX;
                this.lEb = rawY;
                break;
            case 1:
            case 3:
                this.lEa = 0.0f;
                this.lEb = 0.0f;
                ey(false);
                break;
            case 2:
                if (Math.abs((int) (rawX - this.lEa)) > Math.abs((int) (rawY - this.lEb))) {
                    ey(true);
                    break;
                }
                break;
        }
        switch (action) {
            case 0:
                aDj();
                break;
            case 1:
            case 3:
                aDi();
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void ey(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }
}
