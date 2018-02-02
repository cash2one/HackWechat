package com.tencent.mm.ui.widget.celltextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Selection;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.cb.a.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.celltextview.b.a$b;
import com.tencent.mm.ui.widget.celltextview.b.a.a;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.LinkedList;

public class CellTextView extends View implements a$b {
    private static final LruCache<String, Boolean> zwX = new LruCache(200);
    private GestureDetector jtw;
    protected Context mContext;
    private TextView zwQ;
    private boolean zwR;
    private a zwS;
    protected ArrayList<d> zwT;
    protected LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> zwU;
    private b zwV;
    private c zwW;

    public interface b {
    }

    public CellTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public CellTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i);
    }

    public final a czg() {
        if (this.zwS == null) {
            this.zwS = new com.tencent.mm.ui.widget.celltextview.d.a(this.mContext, this.zwQ.getPaint());
            this.zwS.a(this);
        }
        return this.zwS;
    }

    protected void onMeasure(int i, int i2) {
        if (this.zwR) {
            this.zwQ.measure(i, i2);
            setMeasuredDimension(this.zwQ.getMeasuredWidth(), this.zwQ.getMeasuredHeight());
        } else {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            if (mode == 0 && size == 0) {
                i = Integer.MIN_VALUE;
            }
            try {
                czg().onMeasure(i, i2);
                setMeasuredDimension(czg().getMeasuredWidth(), czg().getMeasuredHeight());
                x.i("Changelcai", "[onMeasure] %s - %s", new Object[]{Integer.valueOf(czg().getMeasuredWidth()), Integer.valueOf(czg().getMeasuredHeight())});
            } catch (Exception e) {
                x.e("MicroMsg.CellTextView", "break err!!! change to use sys textview", new Object[]{e});
                zwX.put(czg().getText(), Boolean.valueOf(true));
                this.zwR = true;
                this.zwQ.setText(this.zwS.getText());
                this.zwQ.measure(i, i2);
                setMeasuredDimension(this.zwQ.getMeasuredWidth(), this.zwQ.getMeasuredHeight());
                return;
            }
        }
        setContentDescription(czg().getText());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.zwR) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            this.zwQ.getLayout().draw(canvas);
            canvas.restore();
            return;
        }
        czg().onDraw(canvas);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (this.mContext != null) {
            czg().setPadding(i, i2, i3, i4);
            this.zwQ.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.jtw.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void requestLayout() {
        if (this.mContext != null) {
            czg().requestLayout();
        }
        super.requestLayout();
    }

    public int getPaddingBottom() {
        return czg().getPaddingBottom();
    }

    public int getPaddingLeft() {
        return czg().getPaddingLeft();
    }

    public int getPaddingRight() {
        return czg().getPaddingRight();
    }

    public int getPaddingTop() {
        return czg().getPaddingTop();
    }

    public final View getView() {
        return this;
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        this.mContext = context;
        this.zwT = new ArrayList();
        this.zwU = new LinkedList();
        this.jtw = new GestureDetector(context, new a(this, (byte) 0));
        TextView textView = new TextView(context);
        textView.setClickable(true);
        textView.setFocusable(true);
        this.zwQ = textView;
        czg();
        setOnTouchListener(new com.tencent.mm.ui.widget.celltextview.e.a());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.eZx, i, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i6 < indexCount) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == j.zzG) {
                    float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) com.tencent.mm.ui.widget.celltextview.g.b.i(context, 13.0f));
                    this.zwQ.setTextSize(1, (float) ((int) ((dimensionPixelSize / this.mContext.getResources().getDisplayMetrics().density) + 0.5f)));
                    czg().setTextSize(dimensionPixelSize);
                    requestLayout();
                    invalidate();
                    index = i5;
                    i5 = i4;
                    i4 = i3;
                    i3 = i2;
                } else if (index == j.zzH) {
                    index = obtainStyledAttributes.getColor(index, -1);
                    this.zwQ.setTextColor(index);
                    czg().setTextColor(index);
                    invalidate();
                    index = i5;
                    i5 = i4;
                    i4 = i3;
                    i3 = i2;
                } else {
                    if (index == j.zzU) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            Hb(1);
                            index = i5;
                            i5 = i4;
                            i4 = i3;
                            i3 = i2;
                        }
                    } else if (index == j.zzI) {
                        index = obtainStyledAttributes.getInt(index, 16);
                        this.zwQ.setGravity(index);
                        czg().Hc(index);
                        index = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else if (index == j.zzO) {
                        index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                        this.zwQ.setMaxWidth(index);
                        czg().setMaxWidth(index);
                        index = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else if (index == j.zzP) {
                        index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                        this.zwQ.setMaxHeight(index);
                        czg().setMaxHeight(index);
                        index = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else if (index == j.zzV) {
                        index = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        this.zwQ.setLineSpacing((float) index, 1.0f);
                        czg().Hd(index);
                        invalidate();
                        index = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else if (index == j.zzQ) {
                        index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                        this.zwQ.setMinWidth(index);
                        czg().setMinWidth(index);
                        index = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else if (index == j.zzR) {
                        index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                        this.zwQ.setMinHeight(index);
                        czg().setMinHeight(index);
                        index = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else if (index == j.zzT) {
                        Hb(obtainStyledAttributes.getInt(index, -1));
                        index = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else if (index == j.zzS) {
                        CharSequence string = obtainStyledAttributes.getString(index);
                        if (string != null) {
                            setContentDescription(string);
                            if (this.zwV != null) {
                                BufferType bufferType = BufferType.NORMAL;
                            }
                            if (zwX.get(string) == null) {
                                zwX.put(string, Boolean.valueOf(!string.matches("^[[^\u0000-￿]\\u000A-\\u00b7\\u4E00-\\u9FA5\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uff1f\\uff5e\\ue107-\\ue14c\\ue403-\\ue41D\\ue312]+$")));
                            }
                            this.zwT.clear();
                            boolean booleanValue = ((Boolean) zwX.get(string)).booleanValue();
                            this.zwR = booleanValue;
                            if (booleanValue) {
                                this.zwQ.setLayoutParams(getLayoutParams());
                                this.zwQ.setText(string);
                            } else {
                                this.zwT.add(new d(czg().getPaint(), string, czg().getTextSize()));
                                czg().a(this.zwT, string);
                            }
                            requestLayout();
                            invalidate();
                            index = i5;
                            i5 = i4;
                            i4 = i3;
                            i3 = i2;
                        }
                    } else if (index == j.zzK) {
                        r15 = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        index = r15;
                    } else if (index == j.zzM) {
                        i3 = i2;
                        r15 = i4;
                        i4 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        index = i5;
                        i5 = r15;
                    } else if (index == j.zzL) {
                        i4 = i3;
                        i3 = i2;
                        r15 = i5;
                        i5 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        index = r15;
                    } else if (index == j.zzN) {
                        index = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else if (index == j.zzJ) {
                        index = obtainStyledAttributes.getResourceId(index, -1);
                        Drawable drawable = getResources().getDrawable(index);
                        if (drawable != null) {
                            czg().setBackgroundDrawable(drawable);
                        } else {
                            czg().He(getResources().getColor(index));
                        }
                        this.zwQ.setBackground(drawable);
                    }
                    index = i5;
                    i5 = i4;
                    i4 = i3;
                    i3 = i2;
                }
                i6++;
                i2 = i3;
                i3 = i4;
                i4 = i5;
                i5 = index;
            }
            setPadding(i2, i4, i3, i5);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void Hb(int i) {
        this.zwQ.setMaxLines(i);
        czg().Hb(i);
    }

    private String czh() {
        if (this.zwR) {
            return this.zwQ.getText().toString();
        }
        return czg().czk();
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!TextUtils.isEmpty(czh())) {
            accessibilityEvent.getText().add(czh());
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(czh()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(czh()));
            if (!TextUtils.isEmpty(czh())) {
                accessibilityEvent.setItemCount(czh().length());
            }
        }
    }

    @TargetApi(19)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!TextUtils.isEmpty(czh())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(WXMediaMessage.TITLE_LENGTH_LIMIT);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (VERSION.SDK_INT >= 18) {
                accessibilityNodeInfo.addAction(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            }
        }
        if (isFocused() && VERSION.SDK_INT >= 18) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(WXMediaMessage.THUMB_LENGTH_LIMIT);
            accessibilityNodeInfo.addAction(65536);
        }
        if (VERSION.SDK_INT >= 19 && czg().getMaxLines() > 1) {
            accessibilityNodeInfo.setMultiLine(true);
        }
    }
}
