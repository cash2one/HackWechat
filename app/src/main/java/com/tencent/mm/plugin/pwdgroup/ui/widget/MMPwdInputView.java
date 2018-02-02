package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMPwdInputView extends LinearLayout {
    public StringBuilder let;
    public int mna;
    private boolean pnf;
    private ImageView png;
    private ImageView pnh;
    private ImageView pni;
    private ImageView pnj;
    public a pnk;
    private int pnl;

    public interface a {
        void h(boolean z, String str);
    }

    public enum b {
        ;

        static {
            pnm = 1;
            pnn = 2;
            pno = new int[]{pnm, pnn};
        }
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.let = new StringBuilder();
        this.pnf = false;
        this.pnl = b.pnn;
        View inflate = inflate(getContext(), R.i.dpN, null);
        this.png = (ImageView) inflate.findViewById(R.h.cid);
        this.pnh = (ImageView) inflate.findViewById(R.h.second);
        this.pni = (ImageView) inflate.findViewById(R.h.cQN);
        this.pnj = (ImageView) inflate.findViewById(R.h.cje);
        this.png.setImageResource(R.g.bzj);
        this.pnh.setImageResource(R.g.bzj);
        this.pni.setImageResource(R.g.bzj);
        this.pnj.setImageResource(R.g.bzj);
        addView(inflate);
    }

    public final void bjU() {
        for (int i = 0; i < 4; i++) {
            String str;
            if (this.mna > i) {
                str = this.let.toString().charAt(i);
            } else {
                str = "";
            }
            switch (i) {
                case 0:
                    n(this.png, str);
                    break;
                case 1:
                    n(this.pnh, str);
                    break;
                case 2:
                    n(this.pni, str);
                    break;
                case 3:
                    n(this.pnj, str);
                    break;
                default:
                    break;
            }
        }
    }

    private static void n(ImageView imageView, String str) {
        if (imageView != null) {
            if (str.equals("0")) {
                imageView.setImageResource(R.g.byZ);
            } else if (str.equals("1")) {
                imageView.setImageResource(R.g.bza);
            } else if (str.equals("2")) {
                imageView.setImageResource(R.g.bzb);
            } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                imageView.setImageResource(R.g.bzc);
            } else if (str.equals("4")) {
                imageView.setImageResource(R.g.bzd);
            } else if (str.equals("5")) {
                imageView.setImageResource(R.g.bze);
            } else if (str.equals("6")) {
                imageView.setImageResource(R.g.bzf);
            } else if (str.equals("7")) {
                imageView.setImageResource(R.g.bzg);
            } else if (str.equals("8")) {
                imageView.setImageResource(R.g.bzh);
            } else if (str.equals("9")) {
                imageView.setImageResource(R.g.bzi);
            } else {
                imageView.setImageResource(R.g.bzj);
            }
        }
    }

    public final void bjV() {
        if (this.let != null) {
            this.mna = this.let.length();
        } else {
            this.mna = 0;
        }
        if (this.mna >= 4) {
            this.pnf = true;
        } else {
            this.pnf = false;
        }
        if (this.pnk != null) {
            this.pnk.h(this.pnf, this.let.toString());
        }
    }

    public final void Tt() {
        if (this.mna > 0) {
            this.let.delete(0, this.mna);
        }
        bjV();
        bjU();
    }

    public final void input(String str) {
        if (!TextUtils.isEmpty(str) && !this.pnf) {
            this.let.append(str);
            bjV();
            bjU();
        }
    }
}
