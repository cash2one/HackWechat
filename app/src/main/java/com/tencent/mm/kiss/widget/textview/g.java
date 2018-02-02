package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.R$styleable;

public final class g {
    protected f gTQ;
    public a gTR;
    protected StaticLayout gTS;
    protected boolean gTT = false;
    int gTU;
    int gTV;
    private boolean gTW = false;
    boolean gTX = false;
    private boolean gTY = false;
    private boolean gTZ = false;
    View gUa;
    private int gUb = 0;
    private int gUc = 0;
    protected CharSequence text = null;

    public g(View view, a aVar) {
        this.gUa = view;
        this.gTR = aVar;
    }

    public final void init() {
        this.text = "";
        this.gUa.setWillNotDraw(false);
    }

    public final void setSingleLine(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = Integer.MAX_VALUE;
        }
        if (this.gTR.maxLines != i) {
            this.gTR.maxLines = i;
            this.gTT = true;
            Ej();
            this.gUa.requestLayout();
            this.gUa.invalidate();
        }
    }

    public final void setLines(int i) {
        if (this.gTR.maxLines != i || this.gTR.minLines != i) {
            this.gTT = true;
            Ej();
            this.gTR.maxLines = i;
            this.gTR.minLines = i;
            this.gUa.requestLayout();
            this.gUa.invalidate();
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
            }
        }
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        Context context = ac.getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        if (applyDimension != 0.0f && this.gTR != null && applyDimension != this.gTR.gUh) {
            this.gTR.gUh = applyDimension;
            this.gTT = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
            }
        }
    }

    public final void b(f fVar) {
        if (fVar == null || fVar.gTO == null) {
            this.gTQ = null;
            return;
        }
        if (this.gTR == null) {
            b bVar = new b();
            bVar.gTR = new a();
            bVar.gTR.maxLines = fVar.maxLines;
            bVar.gTR.maxLength = fVar.maxLength;
            bVar.gTR.gTN = fVar.gTN;
            bVar.gTR.gTC = fVar.gTC;
            bVar.gTR.gTD = fVar.gTD;
            bVar.gTR.gravity = fVar.gravity;
            bVar.gTR.gUh = fVar.gTN.getTextSize();
            bVar.gTR.textColor = fVar.gTN.getColor();
            this.gTR = bVar.gTR;
        }
        Ej();
        this.gUa.setWillNotDraw(false);
        this.gTQ = fVar;
        this.gTS = fVar.gTO;
        this.text = fVar.text;
        this.gTW = this.text instanceof Spannable;
        if (this.gTW) {
            this.text = this.gTQ.text;
            com.tencent.mm.kiss.widget.textview.b.b.Em();
            com.tencent.mm.kiss.widget.textview.b.b.a((Spannable) this.text);
        }
        this.gUa.requestLayout();
        this.gUa.invalidate();
    }

    public final void setTextColor(int i) {
        if (this.gTR != null && i != this.gTR.textColor) {
            this.gTR.textColor = i;
            this.gTT = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
            }
        }
    }

    public final void setGravity(int i) {
        if (this.gTR != null && i != this.gTR.gravity) {
            this.gTR.gravity = i;
            this.gTT = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
            }
        }
    }

    public final void setMaxLines(int i) {
        if (this.gTR != null && i != this.gTR.maxLines) {
            this.gTR.maxLines = i;
            this.gTT = true;
            Ej();
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
            }
            this.gUa.requestLayout();
            this.gUa.invalidate();
        }
    }

    public final int getLineHeight() {
        TextPaint paint = this.gTQ.gTO.getPaint();
        if (paint == null) {
            paint = this.gTR.gTN;
        }
        return Math.round((((float) paint.getFontMetricsInt(null)) * this.gTR.gTH) + this.gTR.gTG);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        if (charSequence != null) {
            if (this.text == null || !this.text.equals(charSequence) || z) {
                this.text = charSequence;
                this.gTT = true;
                this.gUa.requestLayout();
                this.gUa.invalidate();
                if (h.DEBUG) {
                    x.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + charSequence + " hashcode " + hashCode() + " " + new ai().toString());
                }
            }
        }
    }

    final void Ej() {
        this.gUc = 0;
        this.gUb = 0;
        this.gTU = 0;
        this.gTV = 0;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final float getTextSize() {
        if (this.gTQ != null) {
            return this.gTQ.gTN.getTextSize();
        }
        if (this.gTR != null) {
            return this.gTR.gUh;
        }
        return 0.0f;
    }

    public final Layout Eh() {
        return this.gTS;
    }

    public final f Ei() {
        return this.gTQ;
    }

    public final int getLineCount() {
        if (this.gTS == null) {
            return 0;
        }
        return this.gTS.getLineCount();
    }

    public final boolean v(MotionEvent motionEvent) {
        int i = -1;
        boolean z = motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
        if (!this.gUa.isEnabled() || !this.gTW) {
            return false;
        }
        com.tencent.mm.kiss.widget.textview.b.b.Em();
        boolean a = com.tencent.mm.kiss.widget.textview.b.b.a(this.gUa, this.gTS, (Spannable) this.text, motionEvent);
        this.gTZ = a;
        if (this.gTY && z) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            boolean z2 = (x < ((float) this.gTU) || x > ((float) (this.gTS.getWidth() + this.gTU))) ? false : y >= ((float) this.gTV) && y <= ((float) (this.gTS.getHeight() + this.gTV));
            if (z2) {
                Spannable spannable = (Spannable) this.text;
                int selectionStart = this.text == null ? -1 : Selection.getSelectionStart(this.text);
                if (this.text != null) {
                    i = Selection.getSelectionEnd(this.text);
                }
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(selectionStart, i, ClickableSpan.class);
                if (clickableSpanArr.length > 0) {
                    x.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
                    clickableSpanArr[0].onClick(this.gUa);
                    return true;
                }
            }
        }
        return a;
    }

    public final boolean performClick() {
        if (this.gTZ || !this.gTX) {
            return false;
        }
        return true;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.gTS == null || this.gTQ == null) {
            boolean gE = gE(this.gUa.getMeasuredWidth());
            if (h.DEBUG) {
                x.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", this.gTS, this.gTQ, Boolean.valueOf(gE));
            }
            if (gE) {
                this.gUa.requestLayout();
                this.gUa.invalidate();
                return;
            }
            return;
        }
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        canvas.save();
        canvas.clipRect(this.gUa.getPaddingLeft(), this.gUa.getPaddingTop(), (this.gUa.getRight() - this.gUa.getLeft()) - this.gUa.getPaddingRight(), (this.gUa.getBottom() - this.gUa.getTop()) - this.gUa.getPaddingBottom());
        if (this.gTU == 0 || this.gTV == 0) {
            int paddingLeft = this.gUa.getPaddingLeft();
            int right = ((this.gUa.getRight() - this.gUa.getLeft()) - this.gUa.getPaddingLeft()) - this.gUa.getPaddingRight();
            int width = this.gTS.getWidth();
            if (width > right) {
                right = paddingLeft;
            } else {
                switch (this.gTQ.gravity & 8388615) {
                    case 1:
                    case 17:
                        right = (right / 2) - (width / 2);
                        break;
                    case 3:
                    case 8388611:
                        right = 0;
                        break;
                    case 5:
                    case 8388613:
                        right -= width;
                        break;
                    default:
                        right = 0;
                        break;
                }
                right += paddingLeft;
            }
            this.gTU = right;
            paddingLeft = this.gUa.getPaddingTop();
            width = ((this.gUa.getBottom() - this.gUa.getTop()) - this.gUa.getPaddingTop()) - this.gUa.getPaddingBottom();
            right = 0;
            int height = this.gTS.getHeight();
            if (height > width) {
                right = paddingLeft;
            } else {
                switch (this.gTQ.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                    case 16:
                        right = (width / 2) - (height / 2);
                        break;
                    case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        right = 0;
                        break;
                    case 80:
                        right = width - height;
                        break;
                }
                right += paddingLeft;
            }
            this.gTV = right;
        }
        canvas.translate((float) this.gTU, (float) this.gTV);
        this.gTS.draw(canvas, null, null, 0);
        canvas.restore();
        if (h.DEBUG) {
            x.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d), Integer.valueOf(hashCode()), this.text, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7));
        }
    }

    private boolean gE(int i) {
        if (this.gTT || this.gTQ == null || this.gTS == null) {
            if (this.gTR == null) {
                return false;
            }
            if (i > 0) {
                Ej();
                long j = 0;
                if (h.DEBUG) {
                    j = System.nanoTime();
                }
                this.gTQ = d.a(this.text, i, this.gTR).Ec();
                this.gTS = this.gTQ.gTO;
                this.gTT = false;
                if (h.DEBUG) {
                    long nanoTime = System.nanoTime();
                    x.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", Integer.valueOf(i), Integer.valueOf(hashCode()), Double.valueOf(((double) (nanoTime - j)) / 1000000.0d), this.text);
                }
                return true;
            }
        }
        return false;
    }

    public final Point aU(int i, int i2) {
        Point point;
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        gE(size);
        if (this.gTS != null) {
            int i3;
            int i4;
            if (mode != 1073741824) {
                i3 = 0;
                if (this.gTR.gTD == null) {
                    Layout layout = this.gTS;
                    if (this.gUb != 0) {
                        i3 = this.gUb;
                    } else {
                        int lineCount = layout.getLineCount();
                        CharSequence text = layout.getText();
                        float f = 0.0f;
                        for (i4 = 0; i4 < lineCount - 1; i4++) {
                            if (text.charAt(layout.getLineEnd(i4) - 1) != '\n') {
                                i3 = -1;
                                break;
                            }
                        }
                        for (i4 = 0; i4 < lineCount; i4++) {
                            f = Math.max(f, layout.getLineWidth(i4));
                        }
                        this.gUb = (int) Math.ceil((double) f);
                        this.gUb += this.gUa.getPaddingLeft() + this.gUa.getPaddingRight();
                        i3 = this.gUb;
                    }
                }
                i4 = (int) Math.ceil((double) Layout.getDesiredWidth(this.gTS.getText(), this.gTS.getPaint()));
                if (i4 > i3) {
                    i3 = i4;
                }
                if (h.DEBUG) {
                    x.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", Integer.valueOf(hashCode()), Integer.valueOf(i3), Integer.valueOf(i4));
                }
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min(size, i3);
                } else {
                    size = i3;
                }
            }
            if (mode2 == 1073741824) {
                i3 = size2;
            } else {
                Layout layout2 = this.gTS;
                if (this.gUc != 0) {
                    i3 = this.gUc;
                } else {
                    i3 = layout2.getLineCount();
                    if (this.gTQ.maxLines > 0 && this.gTQ.maxLines < i3) {
                        i3 = this.gTQ.maxLines;
                    }
                    mode = this.gUa.getPaddingTop() + this.gUa.getPaddingBottom();
                    i4 = layout2.getLineTop(i3);
                    if (this.gTR.minLines <= 0 || i3 >= this.gTR.minLines) {
                        i3 = i4;
                    } else {
                        i3 = ((this.gTR.minLines - i3) * getLineHeight()) + i4;
                    }
                    this.gUc = i3 + mode;
                    i3 = this.gUc;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    i3 = Math.min(i3, size2);
                }
            }
            point = new Point(size, i3);
        } else {
            point = null;
        }
        if (h.DEBUG) {
            String str = "MicroMsg.StaticTextViewHolder";
            String str2 = "onMeasure used: %fms, hashCode: %d, text: %s result: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d);
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = this.text;
            objArr[3] = point == null ? "" : point.toString();
            x.d(str, str2, objArr);
        }
        return point;
    }
}
