package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;

public final class l implements OnTouchListener {
    private static boolean DEBUG = false;
    private static int vuX;
    private static int wR = ViewConfiguration.getTapTimeout();
    String iKB;
    private View view;
    private m vuT = null;
    private boolean vuU = false;
    private View vuV = null;
    private boolean vuW = false;
    private Context vuY = null;
    private af vuZ = new af(Looper.getMainLooper());
    private b vva = new b();
    private a vvb = new a(this);

    class a implements Runnable {
        final /* synthetic */ l vvc;

        a(l lVar) {
            this.vvc = lVar;
        }

        public final void run() {
            if (this.vvc.view != null && this.vvc.view.isPressed()) {
                x.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
                this.vvc.vuW = true;
                this.vvc.aTU();
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ l vvc;

        private b(l lVar) {
            this.vvc = lVar;
        }

        public final void run() {
            this.vvc.Cw(l.wR);
        }
    }

    static {
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        vuX = longPressTimeout;
        if (longPressTimeout > wR * 2) {
            vuX -= wR;
        }
        x.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", Integer.valueOf(vuX));
    }

    public l(Context context) {
        this.vuY = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(view instanceof TextView) && !(view instanceof StaticTextView)) {
            return false;
        }
        CharSequence text;
        Layout layout;
        if (motionEvent.getAction() == 0) {
            view.setTag(e.cSF, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        }
        this.view = view;
        Layout layout2;
        if (view instanceof TextView) {
            layout2 = ((TextView) view).getLayout();
            text = ((TextView) view).getText();
            layout = layout2;
        } else {
            layout2 = ((StaticTextView) view).Eh();
            text = ((StaticTextView) view).getText();
            layout = layout2;
        }
        if (DEBUG) {
            x.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + layout + " " + (text instanceof Spanned) + " " + new ai().toString(), Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(this.vuW));
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if ((text instanceof Spanned) && layout != null) {
            Spanned spanned = (Spanned) text;
            int action = obtain.getAction();
            view.invalidate();
            if (action == 1 || action == 0 || action == 2 || action == 3) {
                int x = (int) obtain.getX();
                int y = (int) obtain.getY();
                if (view instanceof StaticTextView) {
                    if (x >= ((StaticTextView) view).DZ()) {
                        if (x <= ((StaticTextView) view).DZ() + layout.getWidth()) {
                            if (y >= ((StaticTextView) view).Ea()) {
                            }
                            G(obtain);
                        }
                    }
                    G(obtain);
                } else if (view instanceof TextView) {
                    if (x >= ((TextView) view).getTotalPaddingLeft()) {
                        if (x <= ((TextView) view).getTotalPaddingLeft() + layout.getWidth()) {
                            if (y >= ((TextView) view).getTotalPaddingTop()) {
                            }
                            G(obtain);
                        }
                    }
                    G(obtain);
                }
                if (view instanceof TextView) {
                    x -= ((TextView) view).getTotalPaddingLeft();
                    action = y - ((TextView) view).getTotalPaddingTop();
                } else if (view instanceof StaticTextView) {
                    x -= ((StaticTextView) view).DZ();
                    action = y - ((StaticTextView) view).Ea();
                } else {
                    x -= view.getPaddingLeft();
                    action = y - view.getPaddingTop();
                }
                action = layout.getOffsetForHorizontal(layout.getLineForVertical(action + view.getScrollY()), (float) (x + view.getScrollX()));
                if ((view instanceof TextView) && action < spanned.length()) {
                    action++;
                }
                x = obtain.getAction();
                m[] mVarArr = (m[]) spanned.getSpans(action, action, m.class);
                action = mVarArr.length - 1;
                if (DEBUG) {
                    x.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + mVarArr.length + " " + this.vuT + " " + new ai().toString(), Integer.valueOf(obtain.getAction()), Boolean.valueOf(this.vuW));
                }
                if (mVarArr.length == 0) {
                    aTU();
                } else if (x == 1) {
                    this.vuZ.removeCallbacks(this.vva);
                    this.vuZ.removeCallbacks(this.vvb);
                    if (this.vuW) {
                        aTU();
                        this.vuW = false;
                        view.setClickable(this.vuU);
                        if (DEBUG) {
                            x.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + obtain.getAction());
                        }
                    } else {
                        this.vuW = false;
                        if (this.vuT != null) {
                            m mVar = this.vuT;
                            mVar.iKB = this.iKB;
                            if (mVar.vve != null) {
                                mVar.vve.iKB = mVar.iKB;
                            }
                            if (this.vuY != null) {
                                this.vuT.setContext(this.vuY);
                            }
                            this.vuT.onClick(view);
                        } else {
                            x.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
                        }
                        view.setClickable(this.vuU);
                        aTU();
                        if (DEBUG) {
                            x.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + obtain.getAction());
                        }
                    }
                } else if (x == 0 || x == 2) {
                    if (x == 0 && vuX > 0) {
                        Cw(0);
                    }
                    if (x == 0) {
                        this.vuU = view.isClickable();
                    }
                    aTU();
                    this.vuT = mVarArr[action];
                    this.vuV = view;
                    mVarArr[action].setContext(null);
                    mVarArr[action].ozA = true;
                    mVarArr[action].mEnable = true;
                    view.invalidate();
                    if (this.vuW) {
                        mVarArr[action].ozA = false;
                        mVarArr[action].mEnable = false;
                        view.setClickable(this.vuU);
                        if (DEBUG) {
                            x.i("MicroMsg.PressSpanTouchListener", "processPress action3 " + obtain.getAction());
                        }
                    } else if (DEBUG) {
                        x.i("MicroMsg.PressSpanTouchListener", "processPress action4 " + obtain.getAction());
                    }
                } else if (x == 3) {
                    this.vuZ.removeCallbacks(this.vva);
                    this.vuZ.removeCallbacks(this.vvb);
                    view.setClickable(this.vuU);
                    aTU();
                    if (DEBUG) {
                        x.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + obtain.getAction());
                    }
                }
                if (x == 1) {
                    this.vuW = false;
                }
                if (DEBUG) {
                    x.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + obtain.getAction());
                }
            }
            if (DEBUG) {
                x.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + obtain.getAction());
            }
        }
        obtain.recycle();
        if (DEBUG) {
            x.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + layout + " " + (text instanceof Spanned) + " processResult: false" + " " + new ai().toString(), Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(this.vuW));
        }
        return false;
    }

    private void G(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            aTU();
        }
    }

    public final void aTU() {
        if (this.vuT != null) {
            this.vuT.ozA = false;
            this.vuT.setContext(null);
            this.vuV.invalidate();
            this.vuV = null;
            this.vuT = null;
        }
    }

    private void Cw(int i) {
        if (this.view != null) {
            this.vuZ.postDelayed(this.vvb, (long) (vuX - i));
        }
    }
}
