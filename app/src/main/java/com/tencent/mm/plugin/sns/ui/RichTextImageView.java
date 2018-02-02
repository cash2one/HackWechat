package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class RichTextImageView extends LinearLayout {
    private Activity fAF;
    private TextView ihS;
    private ImageView olF;
    private TextView rsl;
    private TextView rwB;
    private boolean rwC = false;
    private String rwD;

    public RichTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAF = (Activity) context;
        View inflate = inflate(this.fAF, g.qHL, this);
        this.rsl = (TextView) inflate.findViewById(f.qDj);
        this.ihS = (TextView) inflate.findViewById(f.qFN);
        this.rwB = (TextView) inflate.findViewById(f.qBx);
        this.olF = (ImageView) inflate.findViewById(f.qCp);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.rwC && this.rwD != null) {
            x.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.rsl.getHeight() + " LineHeight:" + this.rsl.getLineHeight());
            int height = this.rsl.getHeight() / this.rsl.getLineHeight();
            int lineCount = this.rsl.getLineCount();
            Rect rect = new Rect();
            int i5 = 0;
            int i6 = 0;
            while (i5 < height) {
                try {
                    this.rsl.getLineBounds(i5, rect);
                    i6 += rect.height();
                    if (i6 > this.rsl.getHeight()) {
                        break;
                    }
                    i5++;
                } catch (IndexOutOfBoundsException e) {
                }
            }
            if (lineCount >= i5 && this.rwC) {
                if (i5 <= 0) {
                    i5 = 1;
                }
                i5 = this.rsl.getLayout().getLineVisibleEnd(i5 - 1);
                x.e("test", "bottomH:" + this.rwB.getHeight() + "length" + this.rwD.substring(i5, this.rwD.length()).length());
                x.e("test", "bottomH:" + this.rwB.getHeight());
                if (this.rwB.getText().length() > 0) {
                    this.rwB.setVisibility(0);
                    this.rwC = false;
                    new af().post(new Runnable(this) {
                        final /* synthetic */ RichTextImageView rwF;

                        public final void run() {
                            this.rwF.rsl.setText(this.rwF.rwD.substring(0, i5));
                            this.rwF.rwB.setText(this.rwF.rwD.substring(i5, this.rwF.rwD.length()));
                            this.rwF.rwB.invalidate();
                            this.rwF.rwC = false;
                            x.e("test", "bottomH:" + this.rwF.rwB.getHeight());
                        }
                    });
                }
                x.e("test", "bottom:" + i4 + "   mesH:" + this.rwB.getMeasuredHeight());
            }
        }
    }
}
