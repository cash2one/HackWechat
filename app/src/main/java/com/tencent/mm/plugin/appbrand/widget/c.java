package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.ui.j;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends FrameLayout {
    private int jUA = 0;
    public b jUB;
    public LinearLayout jUu;
    private ImageView jUv;
    public String jUw;
    private int jUx;
    private int jUy;
    public LinkedList<a> jUz = new LinkedList();
    private int mHeight = 0;

    static /* synthetic */ void a(c cVar, String str, String str2) {
        cVar.jUx = j.aK(str, cVar.getResources().getColor(d.btv));
        cVar.jUy = j.aK(str2, cVar.getResources().getColor(d.bui));
    }

    static /* synthetic */ void b(c cVar, String str, String str2) {
        float fromDPToPix = (float) a.fromDPToPix(cVar.getContext(), 1);
        int i = fromDPToPix / 2.0f > 1.0f ? (int) (fromDPToPix / 2.0f) : 1;
        new GradientDrawable().setColor(j.aK(str, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        if ("white".equals(str2)) {
            gradientDrawable.setStroke(i, Color.parseColor("#33ffffff"));
        } else {
            gradientDrawable.setStroke(i, Color.parseColor("#33000000"));
        }
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{r2, gradientDrawable});
        if ("top".equals(cVar.jUw)) {
            layerDrawable.setLayerInset(1, -i, -i, -i, -i);
        } else {
            layerDrawable.setLayerInset(1, -i, 0, -i, -i);
        }
        cVar.jUv.setImageDrawable(layerDrawable);
    }

    static /* synthetic */ void c(c cVar) {
        if (cVar.jUB != null) {
            cVar.jUB.L(cVar.jUA, ((a) cVar.jUz.get(cVar.jUA)).mUrl);
        }
    }

    public c(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -2));
        this.jUv = new ImageView(context);
        this.jUv.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.jUv);
        this.jUu = new LinearLayout(context);
        this.jUu.setOrientation(0);
        this.jUu.setGravity(16);
        this.jUu.setLayoutParams(new LayoutParams(-1, -2));
        addView(this.jUu);
    }

    public final void g(String str, String str2, String str3, String str4) {
        post(new 1(this, str, str2, str3, str4));
    }

    public static Bitmap uQ(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public final void lR(int i) {
        ((a) this.jUz.get(this.jUA)).jUK = false;
        if (i <= 0 || i >= this.jUz.size()) {
            this.jUA = 0;
        } else {
            this.jUA = i;
        }
        ((a) this.jUz.get(this.jUA)).jUK = true;
        amg();
    }

    public final void a(Animator animator, Runnable runnable) {
        animator.addListener(new 5(this, runnable));
        animator.start();
    }

    public final void amg() {
        post(new 6(this));
    }

    public final void a(View view, a aVar) {
        int i;
        int i2 = 0;
        ImageView imageView = (ImageView) view.findViewById(q$g.icon);
        TextView textView = (TextView) view.findViewById(q$g.ivi);
        ImageView imageView2 = (ImageView) view.findViewById(q$g.iwr);
        TextView textView2 = (TextView) view.findViewById(q$g.text);
        View findViewById = view.findViewById(q$g.cpL);
        if ("top".equals(this.jUw)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 40), 1.0f));
            imageView.setVisibility(8);
            textView2.setTextSize(1, 14.0f);
            if (aVar.jUK) {
                findViewById.setBackgroundColor(this.jUy);
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(4);
            }
        } else {
            if (aVar.uX != null) {
                if (aVar.jUJ != null) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 54), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = a.fromDPToPix(getContext(), 32);
                    imageView.getLayoutParams().height = a.fromDPToPix(getContext(), 28);
                    textView2.setVisibility(0);
                    textView2.setTextSize(1, 12.0f);
                } else {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 48), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = a.fromDPToPix(getContext(), 36);
                    imageView.getLayoutParams().height = a.fromDPToPix(getContext(), 36);
                    textView2.setVisibility(8);
                }
            } else if (aVar.uX == null && aVar.jUJ != null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 49), 1.0f));
                imageView.setVisibility(8);
                textView2.setVisibility(0);
                textView2.setTextSize(1, 16.0f);
            }
            findViewById.setVisibility(4);
        }
        Drawable background = textView.getBackground();
        if (background != null) {
            background.setColorFilter(aVar.jUN, Mode.SRC_ATOP);
        }
        if (aVar.jUM.isEmpty()) {
            i = 4;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        textView.setText(aVar.jUM);
        textView.setTextColor(aVar.jUO);
        if (!aVar.jUL) {
            i2 = 4;
        }
        imageView2.setVisibility(i2);
        if (!aVar.jUK || aVar.jUI == null) {
            imageView.setImageBitmap(aVar.uX);
        } else {
            imageView.setImageBitmap(aVar.jUI);
        }
        textView2.setText(aVar.jUJ);
        if (aVar.jUK) {
            textView2.setTextColor(this.jUy);
        } else {
            textView2.setTextColor(this.jUx);
        }
    }

    public final int uR(String str) {
        Object obj;
        LinkedList linkedList = this.jUz;
        String uB = l.uB(str);
        Iterator it = this.jUz.iterator();
        while (it.hasNext()) {
            obj = (a) it.next();
            if (l.uB(obj.mUrl).equals(uB)) {
                break;
            }
        }
        obj = null;
        return linkedList.indexOf(obj);
    }
}
