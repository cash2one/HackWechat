package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import java.io.InputStream;

public class SmileySubGrid extends SmileyGrid {
    private int RT;
    int TC;
    private int To;
    Rect Tx = new Rect();
    int YQ;
    private int iN = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    float lEa;
    float lEb;
    private WindowManager lEi;
    private int lIA;
    private boolean lIB;
    private PopEmojiView lIE;
    private LayoutParams lIx;
    private int lIz;
    private af mHandler = new af();
    private LayoutInflater mLayoutInflater;
    int xYH = 6;
    int zDV = -1;
    boolean zDW;
    private c zDX;
    private int zDY;
    private a zDZ;
    private b zEa;
    public View zEb;
    private int zEc;
    private String zEd;
    public boolean zEe = false;
    public volatile int zEf = -1;
    public volatile boolean zEg = false;
    public boolean zEh = true;
    private final Object zEi = new Object();

    public SmileySubGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLayoutInflater = LayoutInflater.from(context);
        this.lEi = (WindowManager) context.getSystemService("window");
        this.lIE = new PopEmojiView(getContext());
        this.lIx = new LayoutParams(-1, -1, 2, 8, 1);
        this.zEc = context.getResources().getDimensionPixelSize(c.bxi);
        this.lIx.width = this.zEc;
        this.lIx.height = this.zEc;
        this.lIx.gravity = 17;
        this.To = aCT();
        this.zDY = ViewConfiguration.getPressedStateDuration();
        this.RT = getResources().getConfiguration().orientation;
        if (this.RT == 2) {
            this.lIz = this.lEi.getDefaultDisplay().getHeight();
            this.lIA = this.lEi.getDefaultDisplay().getWidth();
            return;
        }
        this.lIz = this.lEi.getDefaultDisplay().getWidth();
        this.lIA = this.lEi.getDefaultDisplay().getHeight();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zEh) {
            int action = motionEvent.getAction();
            View view = null;
            int i;
            switch (action) {
                case 0:
                    action = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.lEa = (float) action;
                    this.lEb = (float) y;
                    action = pointToPosition(action, y);
                    if (action >= 0 && getAdapter().isEnabled(action)) {
                        this.YQ = 0;
                    }
                    if (action >= 0) {
                        this.zDV = action;
                        view = getChildAt(action - getFirstVisiblePosition());
                    }
                    if (view != null) {
                        view.setPressed(true);
                        view.setSelected(true);
                        dP(view);
                    }
                    if (this.zDZ == null) {
                        this.zDZ = new a(this, (byte) 0);
                    }
                    this.zDZ.cxp();
                    this.TC = action;
                    if (this.zDl == 25 && this.kaS == 0 && action == 0) {
                        return true;
                    }
                    this.mHandler.postDelayed(this.zDZ, (long) this.To);
                    return true;
                case 1:
                case 3:
                    i = this.TC;
                    View childAt = getChildAt(i - getFirstVisiblePosition());
                    if (action == 1 && this.YQ != -1) {
                        if (this.zEa == null) {
                            this.zEa = new b(this, (byte) 0);
                        }
                        Runnable runnable = this.zEa;
                        runnable.zEk = childAt;
                        runnable.zfh = i;
                        runnable.cxp();
                        this.mHandler.post(runnable);
                    }
                    this.mHandler.removeCallbacks(this.zDZ);
                    ew(true);
                    cAq();
                    if (this.zDV >= 0) {
                        view = getChildAt(this.zDV - getFirstVisiblePosition());
                        if (view != null) {
                            view.setPressed(false);
                            view.setSelected(false);
                            dP(view);
                        }
                    }
                    this.xYH = 6;
                    return true;
                case 2:
                    i = (int) motionEvent.getX();
                    action = (int) motionEvent.getY();
                    if (this.xYH == 5) {
                        i = pointToPosition(i, action);
                        this.TC = i;
                        if ((i < 0 || (this.zDl == 25 && i == 0 && this.kaS == 0)) && !this.zEe) {
                            cAq();
                            if (this.zDV >= 0) {
                                view = getChildAt(this.zDV - getFirstVisiblePosition());
                                if (view != null) {
                                    view.setPressed(false);
                                    view.setSelected(false);
                                    dP(view);
                                }
                            }
                        } else if (this.zDV != i) {
                            this.zDV = i;
                            view = getChildAt(i - getFirstVisiblePosition());
                            layoutChildren();
                            if (view != null) {
                                view.setPressed(true);
                                view.setSelected(true);
                                dP(view);
                                P(view, this.zDV);
                            }
                        }
                        this.mHandler.removeCallbacks(this.zDZ);
                        return true;
                    }
                    if (Math.abs(this.lEa - ((float) i)) > ((float) this.iN)) {
                        this.YQ = -1;
                        this.mHandler.removeCallbacks(this.zDZ);
                    }
                    cAq();
                    return true;
                default:
                    return true;
            }
        }
        cAq();
        return super.onTouchEvent(motionEvent);
    }

    private void P(View view, int i) {
        boolean z = i == this.zEf && this.lIE.isShown();
        if (z) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[]{Integer.valueOf(i)});
        } else {
            x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[]{Integer.valueOf(i)});
            EmojiInfo emojiInfo = (EmojiInfo) getAdapter().getItem(i);
            if (this.zDX == null) {
                this.zDX = new c(this, (byte) 0);
            }
            r(emojiInfo);
            this.lIE.setBackgroundResource(d.lJe);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (this.RT == 1) {
                this.lIx.x = (iArr[0] - ((this.lIz - view.getMeasuredWidth()) / 2)) + 0;
                this.lIx.y = ((iArr[1] - (this.lIA / 2)) - view.getMeasuredHeight()) + 0;
            } else {
                this.lIx.x = (iArr[0] - ((this.lIA - view.getMeasuredWidth()) / 2)) + 0;
                this.lIx.y = ((iArr[1] - (this.lIz / 2)) - view.getMeasuredHeight()) + 0;
            }
            if (this.lIB) {
                this.lEi.updateViewLayout(this.lIE, this.lIx);
            } else {
                this.zEg = true;
                this.mHandler.postDelayed(this.zDX, (long) this.zDY);
            }
        }
        this.zEf = i;
    }

    private void cAq() {
        if (this.zDX != null) {
            this.mHandler.removeCallbacks(this.zDX);
        }
        if (this.lIB) {
            this.lEi.removeView(this.lIE);
            this.lIB = false;
            this.zEg = false;
        }
        this.zEd = "";
    }

    private void dP(View view) {
        Rect rect = this.Tx;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        this.Tx.set(rect.left - getPaddingLeft(), rect.top - getPaddingTop(), rect.right + getPaddingRight(), rect.bottom + getPaddingBottom());
        boolean z = this.zDW;
        if (view.isEnabled() != z) {
            this.zDW = !z;
            refreshDrawableState();
        }
    }

    public void ew(boolean z) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[]{Boolean.valueOf(z)});
        if (this.zEb == null) {
            return;
        }
        if (this.zEb instanceof MMFlipper) {
            ((MMFlipper) this.zEb).xYM = z;
        } else if (this.zEb instanceof CustomViewPager) {
            ((CustomViewPager) this.zEb).DN = z;
        }
    }

    public int aCT() {
        return ViewConfiguration.getLongPressTimeout();
    }

    public final void r(EmojiInfo emojiInfo) {
        Object obj = 1;
        synchronized (this.zEi) {
            if (this.lIE == null) {
                x.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
            } else if (emojiInfo == null) {
                this.lIE.Ct(a.vsF);
                x.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "emoji is null. set null");
            } else if (!emojiInfo.Nr().equals(this.zEd)) {
                this.lIE.Ct(a.vsG);
                this.zEd = emojiInfo.Nr();
                if (!(emojiInfo.field_catalog == EmojiGroupInfo.xAc && (emojiInfo.field_content.equals(String.valueOf(EmojiInfo.xAj)) || emojiInfo.field_content.equals(String.valueOf(EmojiInfo.xAi))))) {
                    obj = null;
                }
                if (obj != null) {
                    x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "emoji drawable name is %s", new Object[]{emojiInfo.getName().split("\\.")[0]});
                    int identifier = getResources().getIdentifier(r0, "drawable", ac.getPackageName());
                    PopEmojiView popEmojiView = this.lIE;
                    if (popEmojiView.vsC != null) {
                        popEmojiView.vsC.setImageResource(identifier);
                    }
                } else {
                    PopEmojiView popEmojiView2;
                    if (emojiInfo.ckv()) {
                        popEmojiView2 = this.lIE;
                        InputStream bk = EmojiInfo.bk(ac.getContext(), emojiInfo.getName());
                        String name = emojiInfo.getName();
                        if (popEmojiView2.vsC != null) {
                            popEmojiView2.vsC.a(bk, name);
                        }
                    } else {
                        popEmojiView2 = this.lIE;
                        if (popEmojiView2.vsC != null) {
                            popEmojiView2.vsC.a(emojiInfo, "");
                        }
                    }
                    popEmojiView2 = this.lIE;
                    if (popEmojiView2.vsC != null) {
                        popEmojiView2.vsC.resume();
                    }
                }
            }
        }
    }

    public final void release() {
        super.release();
        cAq();
        if (this.lIE != null) {
            this.lIE = null;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cAq();
    }
}
