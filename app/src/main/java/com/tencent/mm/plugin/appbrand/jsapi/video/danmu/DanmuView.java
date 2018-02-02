package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DanmuView extends View {
    public int jtV;
    public int jtW;
    public int jtX;
    public float jtY;
    public float jtZ;
    private boolean jua;
    private boolean jub;
    public c juc;
    public HashMap<Integer, ArrayList<d>> jud;
    public final Deque<d> jue;
    public List<d> juf;
    private int[] jug;
    private volatile boolean juh;
    private LinkedList<Long> jui;
    private Paint juj;
    private long juk;
    private LinkedList<Float> jul;
    private final Context mContext;
    public volatile int status;

    public DanmuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DanmuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jtV = 5;
        this.jtW = 500;
        this.jtX = 10;
        this.jtY = 0.0f;
        this.jtZ = 0.6f;
        this.jua = false;
        this.jub = false;
        this.jue = new LinkedList();
        this.juf = new LinkedList();
        this.status = 3;
        this.juk = 0;
        this.mContext = context;
    }

    public final void prepare() {
        float f = this.jtY;
        float f2 = this.jtZ;
        if (f >= f2) {
            throw new IllegalArgumentException("start_Y_offset must < end_Y_offset");
        } else if (f < 0.0f || f >= 1.0f || f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
        } else {
            setBackgroundColor(0);
            setDrawingCacheBackgroundColor(0);
            ahs();
        }
    }

    public final void ahs() {
        this.jud = new HashMap(this.jtV);
        for (int i = 0; i < this.jtV; i++) {
            this.jud.put(Integer.valueOf(i), new ArrayList(this.jtX));
        }
        aht();
    }

    private void aht() {
        int i = 0;
        this.jug = new int[this.jtV];
        float bX = b.bX(this.mContext);
        float height = this.jtY * ((float) getHeight());
        for (int i2 = 0; i2 < this.jtV; i2++) {
            this.jug[i2] = (int) (((((float) (i2 + 1)) * bX) + height) - ((3.0f * bX) / 4.0f));
        }
        if (this.jub) {
            this.jul.clear();
            this.jul.add(Float.valueOf(height));
            while (i < this.jtV) {
                this.jul.add(Float.valueOf((((float) (i + 1)) * bX) + height));
                i++;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.juh) {
            x.i("MicroMsg.DanmuView", "inTransition");
        } else if (this.status == 1) {
            d dVar;
            canvas.drawColor(0);
            for (r1 = 0; r1 < this.jud.size(); r1++) {
                r2 = ((ArrayList) this.jud.get(Integer.valueOf(r1))).iterator();
                while (r2.hasNext()) {
                    dVar = (d) r2.next();
                    if (dVar.ahp()) {
                        r2.remove();
                    } else {
                        try {
                            dVar.b(canvas, false);
                        } catch (Exception e) {
                            x.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", e);
                        }
                    }
                }
            }
            if (System.currentTimeMillis() - this.juk > ((long) this.jtW)) {
                this.juk = System.currentTimeMillis();
                synchronized (this.jue) {
                    if (this.jue.size() > 0) {
                        dVar = (d) this.jue.getFirst();
                        int MP = this.juc.MP();
                        d dVar2 = dVar;
                        while (dVar2 != null && dVar2.kK(MP)) {
                            this.jue.pollFirst();
                            dVar2 = (d) this.jue.getFirst();
                        }
                        if (dVar2 != null && dVar2.kJ(MP)) {
                            int b = b(dVar2);
                            if (b >= 0) {
                                dVar2.bJ(canvas.getWidth() - 2, this.jug[b]);
                                dVar2.b(canvas, false);
                                ((ArrayList) this.jud.get(Integer.valueOf(b))).add(dVar2);
                                this.jue.pollFirst();
                            }
                        }
                    }
                }
            }
            if (this.jua && this.jui != null) {
                canvas.drawText("FPS:" + ((int) ahx()), 5.0f, 20.0f, this.juj);
            }
            if (this.jub && this.jul != null) {
                r7 = this.jul.iterator();
                while (r7.hasNext()) {
                    r2 = ((Float) r7.next()).floatValue();
                    canvas.drawLine(0.0f, r2, (float) getWidth(), r2, this.juj);
                }
            }
            invalidate();
        } else if (this.status == 2) {
            try {
                canvas.drawColor(0);
                for (r1 = 0; r1 < this.jud.size(); r1++) {
                    r2 = ((ArrayList) this.jud.get(Integer.valueOf(r1))).iterator();
                    while (r2.hasNext()) {
                        ((d) r2.next()).b(canvas, true);
                    }
                }
                if (this.jua && this.jui != null) {
                    canvas.drawText("FPS:" + ((int) ahx()), 5.0f, 20.0f, this.juj);
                }
                if (this.jub && this.jul != null) {
                    r7 = this.jul.iterator();
                    while (r7.hasNext()) {
                        r2 = ((Float) r7.next()).floatValue();
                        canvas.drawLine(0.0f, r2, (float) getWidth(), r2, this.juj);
                    }
                }
            } catch (Exception e2) {
                x.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", e2);
            }
            invalidate();
        }
    }

    private int b(d dVar) {
        int i = 0;
        while (i < this.jtV) {
            try {
                int i2 = (i + 0) % this.jtV;
                ArrayList arrayList = (ArrayList) this.jud.get(Integer.valueOf(i2));
                if (arrayList.size() == 0) {
                    return i2;
                }
                if (arrayList.size() <= this.jtX && !dVar.a((d) arrayList.get(arrayList.size() - 1))) {
                    return i2;
                }
                i++;
            } catch (Exception e) {
                x.w("MicroMsg.DanmuView", "findVacant,Exception:" + e.getMessage());
            }
        }
        return -1;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aht();
    }

    public final void ahu() {
        if (isMainThread()) {
            this.juh = true;
        } else {
            post(new 1(this));
        }
    }

    public final void ahv() {
        if (isMainThread()) {
            this.juh = false;
            invalidate();
            return;
        }
        post(new 2(this));
    }

    public final void show() {
        this.status = 1;
        invalidate();
    }

    public final void pause() {
        this.status = 2;
        invalidate();
    }

    public final void hide() {
        this.status = 4;
        invalidate();
    }

    public final void ahw() {
        if (!(this.jud == null || this.jud.isEmpty())) {
            this.jud.clear();
        }
        synchronized (this.jue) {
            if (!this.jue.isEmpty()) {
                this.jue.clear();
            }
        }
    }

    private double ahx() {
        long nanoTime = System.nanoTime();
        this.jui.addLast(Long.valueOf(nanoTime));
        double longValue = ((double) (nanoTime - ((Long) this.jui.getFirst()).longValue())) / 1.0E9d;
        if (this.jui.size() > 100) {
            this.jui.removeFirst();
        }
        return longValue > 0.0d ? ((double) this.jui.size()) / longValue : 0.0d;
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
