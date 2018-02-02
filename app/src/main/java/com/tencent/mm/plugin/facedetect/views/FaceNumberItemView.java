package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;

public class FaceNumberItemView extends View {
    static final long mmP = 29;
    Timer mmO;
    private boolean mmQ;
    private Paint mmR;
    private RectF mmS;
    private Bitmap mmT;
    public int mmU;
    int mmV;
    Runnable mmW;

    public FaceNumberItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mmO = null;
        this.mmQ = false;
        this.mmR = null;
        this.mmS = null;
        this.mmT = null;
        this.mmU = 17;
        this.mmV = 0;
        this.mmW = new 1(this);
        setLayerType(1, null);
        this.mmR = new Paint();
        this.mmR.setColor(context.getResources().getColor(b.mcu));
        this.mmR.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.mmS = new RectF();
    }

    public final void setImageResource(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (i == d.mcO) {
            int dimensionPixelSize = (getResources().getDimensionPixelSize(c.mcy) - a.fromDPToPix(getContext(), 8)) / 2;
            Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth() + (dimensionPixelSize * 2), decodeResource.getHeight() + 0, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 255, 255, 255);
            canvas.drawBitmap(decodeResource, (float) dimensionPixelSize, 0.0f, null);
            this.mmT = createBitmap;
            return;
        }
        this.mmT = Bitmap.createScaledBitmap(decodeResource, a.fromDPToPix(getContext(), 48), decodeResource.getHeight(), false);
    }

    public final void aHG() {
        if (this.mmO != null) {
            this.mmO.cancel();
            this.mmO = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        float width;
        float height;
        super.onDraw(canvas);
        if (this.mmU == 17) {
            width = (float) ((getWidth() - this.mmT.getWidth()) >> 1);
            height = (float) ((getHeight() - this.mmT.getHeight()) >> 1);
        } else if (this.mmU == 3) {
            height = (float) ((getHeight() - this.mmT.getHeight()) >> 1);
            width = 0.0f;
        } else if (this.mmU == 5) {
            width = (float) (getWidth() - this.mmT.getWidth());
            height = (float) ((getHeight() - this.mmT.getHeight()) >> 1);
        } else {
            x.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
            width = (float) ((getWidth() - this.mmT.getWidth()) >> 1);
            height = (float) ((getHeight() - this.mmT.getHeight()) >> 1);
        }
        if (!this.mmQ) {
            canvas.drawBitmap(this.mmT, width, height, null);
        }
        this.mmS.set(width, 0.0f, ((((float) this.mmT.getWidth()) * ((float) this.mmV)) / 30.0f) + width, (float) getHeight());
        canvas.drawRect(this.mmS, this.mmR);
    }
}
