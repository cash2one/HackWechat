package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView extends GridLayout {
    private static int qmW;
    public String qgX;
    public boolean qmX;
    public boolean qmY;
    public boolean qmZ;
    public String qna;
    public boolean qnb;
    public AnimatorSet qnc;
    public List<String> qnd = new ArrayList();
    public List<d> qne = new ArrayList();
    public List<View> qnf = new ArrayList();
    public b qng;
    public a qnh;
    public c qni;

    class AnonymousClass4 implements AnimatorUpdateListener {
        final /* synthetic */ SwitchAccountGridView qnk;
        final /* synthetic */ int qnl;

        public AnonymousClass4(SwitchAccountGridView switchAccountGridView, int i) {
            this.qnk = switchAccountGridView;
            this.qnl = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            x.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(floatValue));
            while (i < this.qnl) {
                if (!((String) this.qnk.qnd.get(i)).equals(this.qnk.qna)) {
                    ((View) this.qnk.qnf.get(i)).setAlpha(1.0f - floatValue);
                }
                i++;
            }
            if (this.qnl < this.qnk.getChildCount()) {
                ((View) this.qnk.qnf.get(this.qnl)).setTranslationX(((float) ((View) this.qnk.qnf.get(this.qnl)).getWidth()) * floatValue);
            }
        }
    }

    class AnonymousClass5 implements AnimatorUpdateListener {
        final /* synthetic */ SwitchAccountGridView qnk;
        final /* synthetic */ int qnl;

        public AnonymousClass5(SwitchAccountGridView switchAccountGridView, int i) {
            this.qnk = switchAccountGridView;
            this.qnl = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            x.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(((Float) valueAnimator.getAnimatedValue()).floatValue()));
            for (int i = 0; i < this.qnl; i++) {
                if (((String) this.qnk.qnd.get(i)).equals(this.qnk.qna)) {
                    ((View) this.qnk.qnf.get(i)).setTranslationX(((float) (((this.qnk.getWidth() / 2) - (((View) this.qnk.qnf.get(i)).getWidth() * i)) - (((View) this.qnk.qnf.get(i)).getWidth() / 2))) * r3);
                    return;
                }
            }
        }
    }

    public interface a {
        void bqZ();
    }

    public interface b {
        void Jb(String str);
    }

    public interface c {
        void Jc(String str);
    }

    private class d {
        public ImageView ijr;
        public TextView nuZ;
        public ImageView qlw;
        final /* synthetic */ SwitchAccountGridView qnk;
        public View qnm;

        private d(SwitchAccountGridView switchAccountGridView) {
            this.qnk = switchAccountGridView;
        }
    }

    public SwitchAccountGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        qmW = getResources().getDimensionPixelOffset(R.f.bup) * 2;
    }

    public final void O(Map<String, SwitchAccountModel> map) {
        ImageView imageView;
        ImageView imageView2;
        if (!(map == null || map.isEmpty())) {
            this.qnd.addAll(map.keySet());
            Collections.sort(this.qnd);
        }
        x.i("MicroMsg.SwitchAccountGridView", "account count %d", Integer.valueOf(this.qnd.size()));
        for (int i = 0; i < this.qnd.size(); i++) {
            View inflate = ((Activity) getContext()).getLayoutInflater().inflate(R.i.dsk, null);
            imageView = (ImageView) inflate.findViewById(R.h.bIs);
            imageView2 = (ImageView) inflate.findViewById(R.h.bIv);
            View findViewById = inflate.findViewById(R.h.caf);
            final String str = (String) this.qnd.get(i);
            TextView textView = (TextView) inflate.findViewById(R.h.bIz);
            d dVar = new d();
            dVar.ijr = imageView;
            dVar.qlw = imageView2;
            dVar.nuZ = textView;
            dVar.qnm = findViewById;
            imageView.setScaleType(ScaleType.FIT_XY);
            String str2 = ((SwitchAccountModel) map.get(str)).moS;
            try {
                if (!bh.ov(str2)) {
                    Bitmap decodeByteArray;
                    if (this.qmZ) {
                        x.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
                        byte[] d = e.d(str2, 0, e.bN(str2));
                        if (d != null) {
                            decodeByteArray = BitmapFactory.decodeByteArray(d, 0, d.length);
                            if (decodeByteArray != null) {
                                imageView.setImageBitmap(decodeByteArray);
                            }
                        }
                    } else {
                        decodeByteArray = com.tencent.mm.ad.d.jg(str2);
                        if (decodeByteArray != null) {
                            imageView.setImageBitmap(decodeByteArray);
                        } else {
                            com.tencent.mm.pluginsdk.ui.a.b.a(dVar.ijr, str);
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SwitchAccountGridView", e, "get avatar error", new Object[0]);
            }
            textView.setText(i.b(getContext(), ((SwitchAccountModel) map.get(str)).username, textView.getTextSize()));
            imageView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SwitchAccountGridView qnk;

                public final void onClick(View view) {
                    x.i("MicroMsg.SwitchAccountGridView", "click %s", str);
                    if (!this.qnk.qmX && this.qnk.qng != null) {
                        this.qnk.qng.Jb(str);
                    }
                }
            });
            imageView2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SwitchAccountGridView qnk;

                public final void onClick(View view) {
                    if (this.qnk.qni != null) {
                        this.qnk.qni.Jc(str);
                    }
                }
            });
            this.qne.add(dVar);
            this.qnf.add(inflate);
        }
        View inflate2 = ((Activity) getContext()).getLayoutInflater().inflate(R.i.dsk, null);
        imageView = (ImageView) inflate2.findViewById(R.h.bIs);
        imageView2 = (ImageView) inflate2.findViewById(R.h.bIv);
        TextView textView2 = (TextView) inflate2.findViewById(R.h.bIz);
        d dVar2 = new d();
        dVar2.ijr = imageView;
        dVar2.qlw = imageView2;
        dVar2.nuZ = textView2;
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setImageResource(R.g.bzk);
        textView2.setText(getContext().getResources().getString(R.l.dsj));
        imageView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SwitchAccountGridView qnk;

            {
                this.qnk = r1;
            }

            public final void onClick(View view) {
                x.i("MicroMsg.SwitchAccountGridView", "click addBtn");
                if (this.qnk.qng != null) {
                    this.qnk.qng.Jb(null);
                }
            }
        });
        this.qne.add(dVar2);
        this.qnf.add(inflate2);
    }

    public final void brm() {
        if (this.qnb) {
            x.i("MicroMsg.SwitchAccountGridView", "playing animation");
            return;
        }
        removeAllViews();
        int min = Math.min(2, this.qnd.size());
        int i = 0;
        while (i < min) {
            if (!this.qmX || ((String) this.qnd.get(i)).equals(this.qgX)) {
                ((d) this.qne.get(i)).qlw.setVisibility(4);
            } else {
                ((d) this.qne.get(i)).qlw.setVisibility(0);
            }
            ((d) this.qne.get(i)).qnm.setVisibility(4);
            if (!bh.ov(this.qgX) && ((String) this.qnd.get(i)).equals(this.qgX)) {
                if (this.qmY) {
                    ((ImageView) ((d) this.qne.get(i)).qnm.findViewById(R.h.cag)).setImageResource(R.g.bCQ);
                } else {
                    ((ImageView) ((d) this.qne.get(i)).qnm.findViewById(R.h.cag)).setImageResource(R.g.bCP);
                }
                if (this.qmY) {
                    ((TextView) ((d) this.qne.get(i)).qnm.findViewById(R.h.cah)).setText(getContext().getResources().getString(R.l.eYH));
                } else {
                    ((TextView) ((d) this.qne.get(i)).qnm.findViewById(R.h.cah)).setText(getContext().getResources().getString(R.l.eNl));
                }
                ((d) this.qne.get(i)).qnm.setVisibility(0);
            }
            if (!bh.ov(this.qna) && ((String) this.qnd.get(i)).equals(this.qna)) {
                ((ImageView) ((d) this.qne.get(i)).qnm.findViewById(R.h.cag)).setImageResource(R.g.bEO);
                ((TextView) ((d) this.qne.get(i)).qnm.findViewById(R.h.cah)).setText(getContext().getResources().getString(R.l.etF));
                ((d) this.qne.get(i)).qnm.setVisibility(0);
            }
            LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = qmW;
            addView((View) this.qnf.get(i), layoutParams);
            i++;
        }
        if (getChildCount() < 2) {
            ((d) this.qne.get(this.qne.size() - 1)).qlw.setVisibility(4);
            LayoutParams layoutParams2 = new GridLayout.LayoutParams();
            layoutParams2.width = qmW;
            addView((View) this.qnf.get(this.qnf.size() - 1), layoutParams2);
        }
    }
}
