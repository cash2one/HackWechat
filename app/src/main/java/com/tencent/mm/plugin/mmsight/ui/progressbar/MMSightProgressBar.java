package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.List;

public class MMSightProgressBar extends View {
    public static final int lXU = a.fromDPToPix(ac.getContext(), 3);
    public static final int oDE = a.fromDPToPix(ac.getContext(), 5);
    private static final int[] oDF = new int[]{-1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340")};
    private int centerX = 0;
    private int centerY = 0;
    private boolean fAs = false;
    private af handler = null;
    private Paint iYm;
    private List<a> oDG = new ArrayList(5);
    private int oDH = 0;
    private b oDI;
    private boolean oDJ = false;
    private a oDK;

    public MMSightProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iYm = new Paint();
        this.iYm.setColor(-65536);
        this.iYm.setAntiAlias(true);
        this.handler = new 1(this, Looper.getMainLooper());
        Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[]{Integer.valueOf(lXU), Integer.valueOf(oDE)});
    }

    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.fAs && (this.centerX <= 0 || this.centerY <= 0)) {
            int left = getLeft();
            int right = getRight();
            int top = getTop();
            int bottom = getBottom();
            this.centerX = (right - left) / 2;
            this.centerY = (bottom - top) / 2;
            Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", new Object[]{Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY)});
            Log.i("MicroMsg.MMSightProgressBar", "add init point");
            this.oDG.add(new a(0, this.centerX, this.centerY, -1));
        }
        int save = canvas.save();
        this.oDH = this.oDG.size();
        if (this.oDH % 2 == 0) {
            f = -(((((float) oDE) / 2.0f) + ((float) (((this.oDH / 2) - 1) * oDE))) + ((float) ((this.oDH / 2) * lXU)));
        } else {
            f = -(((((float) lXU) / 2.0f) + ((float) ((this.oDH / 2) * oDE))) + ((float) ((this.oDH / 2) * lXU)));
        }
        if (this.oDI != null && this.oDI.oDU) {
            float f2;
            right = this.oDH + 1;
            if (right % 2 == 0) {
                f2 = -(((float) ((right / 2) * lXU)) + ((((float) oDE) / 2.0f) + ((float) (((right / 2) - 1) * oDE))));
            } else {
                f2 = -(((float) ((right / 2) * lXU)) + ((((float) lXU) / 2.0f) + ((float) ((right / 2) * oDE))));
            }
            Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[]{Float.valueOf(f2), Float.valueOf(this.oDI.oDR)});
            f -= (Math.abs(f2) - Math.abs(f)) * (this.oDI.oDR / 100.0f);
        }
        Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[]{Float.valueOf(f), Integer.valueOf(this.oDH)});
        canvas.translate(f, 0.0f);
        if (this.oDI != null && this.oDI.oDU) {
            b bVar = this.oDI;
            Paint paint = this.iYm;
            x.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[]{Float.valueOf(bVar.oDR), Float.valueOf(((float) (oDE + (lXU * 2))) * (bVar.oDR / 100.0f))});
            if (bVar.oEc > bVar.oEe) {
                float f3 = bVar.oDS.oDN - ((float) lXU);
                f = bVar.oDS.oDO - ((float) lXU);
                paint.setColor(bVar.oDT.color);
                bVar.oEg.reset();
                bVar.oEg.moveTo(bVar.oDW.x + f3, bVar.oDW.y + f);
                bVar.oEg.quadTo(bVar.oDX.x + f3, bVar.oDX.y + f, bVar.oDY.x + f3, bVar.oDY.y + f);
                bVar.oEg.lineTo(bVar.oEb.x + f3, bVar.oEb.y + f);
                bVar.oEg.quadTo(bVar.oEa.x + f3, bVar.oEa.y + f, bVar.oDZ.x + f3, f + bVar.oDZ.y);
                if (bVar.oDT.color != bVar.oDS.color) {
                    paint.setShader(new LinearGradient(bVar.oDW.x + f3, bVar.oDS.oDO - ((float) lXU), f3 + bVar.oDY.x, bVar.oDS.oDO - ((float) lXU), new int[]{bVar.oDS.color, bVar.oDT.color}, null, TileMode.REPEAT));
                }
                canvas.drawPath(bVar.oEg, paint);
                paint.setShader(null);
            }
            a aVar = bVar.oDT;
            paint.setColor(aVar.color);
            aVar.oDO = (float) aVar.oDQ;
            aVar.oDN = ((float) (aVar.oDP + ((aVar.index - 1) * (oDE + (lXU * 2))))) + r11;
            Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[]{Integer.valueOf(aVar.index), Float.valueOf(r11), Float.valueOf(aVar.oDN)});
            canvas.drawCircle(aVar.oDN, aVar.oDO, (float) lXU, paint);
            paint.setShader(null);
        }
        for (a aVar2 : this.oDG) {
            Paint paint2 = this.iYm;
            paint2.setColor(aVar2.color);
            aVar2.oDN = (float) (aVar2.oDP + (aVar2.index * (oDE + (lXU * 2))));
            aVar2.oDO = (float) aVar2.oDQ;
            Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[]{Integer.valueOf(aVar2.index), Float.valueOf(aVar2.oDN)});
            canvas.drawCircle(aVar2.oDN, aVar2.oDO, (float) lXU, paint2);
            paint2.setShader(null);
        }
        canvas.restoreToCount(save);
        if (this.fAs && !this.oDJ && this.oDG.size() > 0) {
            Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
            this.oDJ = true;
            this.handler.sendEmptyMessage(233);
        }
    }
}
