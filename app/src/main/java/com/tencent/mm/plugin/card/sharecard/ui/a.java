package com.tencent.mm.plugin.card.sharecard.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.q;

public final class a {
    private final String TAG = "MicroMsg.CardConsumeCodeController";
    Bitmap inI;
    OnClickListener inN = new 1(this);
    b kIK;
    View kND;
    private View kNE;
    private View kNF;
    private View kNG;
    Bitmap kNH;
    TextView kNI;
    TextView kNJ;
    CheckBox kNK;
    String kNL;
    int kNM = 1;
    boolean kNN = false;
    a kNO;
    float kNP = 0.0f;
    private OnLongClickListener kNQ = new 2(this);
    MMActivity kaY;

    public a(MMActivity mMActivity, View view) {
        this.kaY = mMActivity;
        this.kND = view;
    }

    final void ae(float f) {
        LayoutParams attributes = this.kaY.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.kaY.getWindow().setAttributes(attributes);
    }

    public final void ava() {
        x.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
        if (this.kNN) {
            String str;
            ImageView imageView;
            if (!bh.ov(this.kIK.atC().vRr)) {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[]{this.kIK.atC().vRr});
                str = r0;
            } else if (this.kIK.atv()) {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[]{am.auN().getCode()});
                str = r0;
            } else {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[]{this.kIK.atC().code});
                str = r0;
            }
            View view;
            TextView textView;
            switch (this.kIK.atC().vRe) {
                case 0:
                    if (this.kNG == null) {
                        this.kNG = ((ViewStub) this.kND.findViewById(R.h.bQg)).inflate();
                    }
                    TextView textView2 = (TextView) this.kNG.findViewById(R.h.bWC);
                    textView2.setText(m.wW(str));
                    textView2.setOnLongClickListener(this.kNQ);
                    if (!this.kIK.ati()) {
                        textView2.setTextColor(l.wO(this.kIK.atB().hbM));
                    }
                    if (str.length() <= 12) {
                        textView2.setTextSize(1, 33.0f);
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView2.setTextSize(1, 30.0f);
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView2.setTextSize(1, 24.0f);
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView2.setTextSize(1, 18.0f);
                    } else if (str.length() > 40) {
                        textView2.setVisibility(8);
                    }
                    cj(this.kNG);
                    break;
                case 1:
                    if (this.kNF == null) {
                        this.kNF = ((ViewStub) this.kND.findViewById(R.h.bQa)).inflate();
                    }
                    view = this.kNF;
                    imageView = (ImageView) view.findViewById(R.h.bWm);
                    textView = (TextView) view.findViewById(R.h.bWC);
                    if (!this.kIK.ati()) {
                        textView.setTextColor(l.wO(this.kIK.atB().hbM));
                    }
                    if (TextUtils.isEmpty(str) || str.length() > 40) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(m.wW(str));
                        if (this.kIK.atr()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.kNQ);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                    if (this.kNM != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        l.u(this.kNH);
                        if (TextUtils.isEmpty(str)) {
                            this.kNH = null;
                            imageView.setImageBitmap(this.kNH);
                        } else {
                            this.kNH = com.tencent.mm.bs.a.a.b(this.kaY, str, 5, 0);
                            a(imageView, this.kNH);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardConsumeCodeController", e, "", new Object[0]);
                    }
                    cj(this.kNF);
                    break;
                case 2:
                    if (this.kNE == null) {
                        this.kNE = ((ViewStub) this.kND.findViewById(R.h.bQe)).inflate();
                    }
                    view = this.kNE;
                    imageView = (ImageView) view.findViewById(R.h.bWv);
                    textView = (TextView) view.findViewById(R.h.bWC);
                    if (!this.kIK.ati()) {
                        textView.setTextColor(l.wO(this.kIK.atB().hbM));
                    }
                    if (str.length() <= 40) {
                        textView.setText(m.wW(str));
                        if (this.kIK.atr()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.kNQ);
                        } else {
                            textView.setVisibility(8);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                    if (this.kNM != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        l.u(this.inI);
                        if (TextUtils.isEmpty(str)) {
                            this.inI = null;
                            imageView.setImageBitmap(this.inI);
                        } else {
                            this.inI = com.tencent.mm.bs.a.a.b(this.kaY, str, 0, 3);
                            a(imageView, this.inI);
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardConsumeCodeController", e2, "", new Object[0]);
                    }
                    cj(this.kNE);
                    break;
            }
            if (bh.ov(this.kIK.atB().liT)) {
                this.kNI.setVisibility(8);
                this.kNJ.setVisibility(8);
            } else if (this.kIK.atB().vSm != null) {
                this.kNJ.setText(this.kIK.atB().liT);
                this.kNJ.setVisibility(0);
                this.kNI.setVisibility(8);
                if (this.kNE != null) {
                    imageView = (ImageView) this.kNE.findViewById(R.h.bWv);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = com.tencent.mm.bv.a.fromDPToPix(this.kaY, 180);
                    layoutParams.width = com.tencent.mm.bv.a.fromDPToPix(this.kaY, 180);
                    imageView.setLayoutParams(layoutParams);
                }
            } else {
                this.kNI.setText(this.kIK.atB().liT);
                this.kNI.setVisibility(0);
            }
            if (!this.kIK.ath() || TextUtils.isEmpty(this.kIK.atH()) || this.kIK.atH().equals(q.FS())) {
                this.kNK.setChecked(false);
                this.kNK.setVisibility(8);
                return;
            }
            this.kNK.setVisibility(0);
            this.kNK.setText(i.f(this.kaY, " " + this.kaY.getString(R.l.dNS, new Object[]{l.wR(this.kIK.atH())}), this.kaY.getResources().getDimensionPixelOffset(R.f.bvU)));
            return;
        }
        x.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null && !bitmap.isRecycled()) {
            imageView.setImageBitmap(bitmap);
            if (this.kNM != 1) {
                imageView.setAlpha(10);
            } else {
                imageView.setAlpha(255);
            }
        }
    }

    private void cj(View view) {
        Button button = (Button) view.findViewById(R.h.bWu);
        if (this.kNM == 1) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        if (this.kNM == -1) {
            button.setText(R.l.dOC);
        }
    }
}
