package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMKeyBoardView extends LinearLayout implements OnClickListener, OnLongClickListener {
    private ColorStateList ek;
    private Context mContext;
    private float nxC;
    private Button pmD;
    private Button pmE;
    private Button pmF;
    private Button pmG;
    private Button pmH;
    private Button pmI;
    private Button pmJ;
    private Button pmK;
    private Button pmL;
    private Button pmM;
    private ImageButton pmN;
    private View pmO;
    private View pmP;
    private View pmQ;
    private View pmR;
    private View pmS;
    private View pmT;
    private boolean pmU;
    private int pmV;
    private int pmW;
    private int pmX;
    private int pmY;
    private int pmZ;
    public a pml;
    private int pna;
    private int pnb;
    private int pnc;
    private int pnd;

    public MMKeyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.pmU = true;
        this.mContext = context;
        this.pmV = getResources().getDimensionPixelSize(R.f.bxG);
        this.pmW = getResources().getDimensionPixelSize(R.f.bxH);
        this.nxC = (float) getResources().getDimensionPixelSize(R.f.bxI);
        this.ek = getResources().getColorStateList(R.e.bsW);
        this.pmX = getResources().getColor(R.e.bsV);
        this.pmD = new Button(this.mContext);
        this.pmE = new Button(this.mContext);
        this.pmF = new Button(this.mContext);
        this.pmG = new Button(this.mContext);
        this.pmH = new Button(this.mContext);
        this.pmI = new Button(this.mContext);
        this.pmJ = new Button(this.mContext);
        this.pmK = new Button(this.mContext);
        this.pmL = new Button(this.mContext);
        this.pmM = new Button(this.mContext);
        this.pmN = new ImageButton(this.mContext);
        this.pmO = new View(this.mContext);
        this.pmO = new View(this.mContext);
        this.pmP = new View(this.mContext);
        this.pmQ = new View(this.mContext);
        this.pmR = new View(this.mContext);
        this.pmS = new View(this.mContext);
        this.pmT = new View(this.mContext);
        this.pmD.setBackgroundResource(R.g.bDm);
        this.pmE.setBackgroundResource(R.g.bDm);
        this.pmF.setBackgroundResource(R.g.bDm);
        this.pmG.setBackgroundResource(R.g.bDm);
        this.pmH.setBackgroundResource(R.g.bDm);
        this.pmI.setBackgroundResource(R.g.bDm);
        this.pmJ.setBackgroundResource(R.g.bDm);
        this.pmK.setBackgroundResource(R.g.bDm);
        this.pmL.setBackgroundResource(R.g.bDm);
        this.pmI.setBackgroundResource(R.g.bDm);
        this.pmM.setBackgroundResource(R.g.bDm);
        this.pmN.setBackgroundResource(R.g.bDm);
        this.pmN.setImageResource(R.g.bDn);
        this.pmD.setText("0");
        this.pmE.setText("1");
        this.pmF.setText("2");
        this.pmG.setText(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        this.pmH.setText("4");
        this.pmI.setText("5");
        this.pmJ.setText("6");
        this.pmK.setText("7");
        this.pmL.setText("8");
        this.pmM.setText("9");
        this.pmD.setGravity(17);
        this.pmE.setGravity(17);
        this.pmF.setGravity(17);
        this.pmG.setGravity(17);
        this.pmH.setGravity(17);
        this.pmI.setGravity(17);
        this.pmJ.setGravity(17);
        this.pmK.setGravity(17);
        this.pmL.setGravity(17);
        this.pmM.setGravity(17);
        this.pmD.setTextSize(0, this.nxC);
        this.pmE.setTextSize(0, this.nxC);
        this.pmF.setTextSize(0, this.nxC);
        this.pmG.setTextSize(0, this.nxC);
        this.pmH.setTextSize(0, this.nxC);
        this.pmI.setTextSize(0, this.nxC);
        this.pmJ.setTextSize(0, this.nxC);
        this.pmK.setTextSize(0, this.nxC);
        this.pmL.setTextSize(0, this.nxC);
        this.pmM.setTextSize(0, this.nxC);
        this.pmD.setTextColor(this.ek);
        this.pmE.setTextColor(this.ek);
        this.pmF.setTextColor(this.ek);
        this.pmG.setTextColor(this.ek);
        this.pmH.setTextColor(this.ek);
        this.pmI.setTextColor(this.ek);
        this.pmJ.setTextColor(this.ek);
        this.pmK.setTextColor(this.ek);
        this.pmL.setTextColor(this.ek);
        this.pmM.setTextColor(this.ek);
        this.pmD.setOnClickListener(this);
        this.pmE.setOnClickListener(this);
        this.pmF.setOnClickListener(this);
        this.pmG.setOnClickListener(this);
        this.pmH.setOnClickListener(this);
        this.pmI.setOnClickListener(this);
        this.pmJ.setOnClickListener(this);
        this.pmK.setOnClickListener(this);
        this.pmL.setOnClickListener(this);
        this.pmM.setOnClickListener(this);
        this.pmN.setOnClickListener(this);
        this.pmN.setOnLongClickListener(this);
        this.pmO.setBackgroundColor(this.pmX);
        this.pmO.setBackgroundColor(this.pmX);
        this.pmP.setBackgroundColor(this.pmX);
        this.pmQ.setBackgroundColor(this.pmX);
        this.pmR.setBackgroundColor(this.pmX);
        this.pmS.setBackgroundColor(this.pmX);
        this.pmT.setBackgroundColor(this.pmX);
        addView(this.pmD);
        addView(this.pmE);
        addView(this.pmF);
        addView(this.pmG);
        addView(this.pmH);
        addView(this.pmI);
        addView(this.pmJ);
        addView(this.pmK);
        addView(this.pmL);
        addView(this.pmM);
        addView(this.pmN);
        addView(this.pmO);
        addView(this.pmP);
        addView(this.pmQ);
        addView(this.pmR);
        addView(this.pmS);
        addView(this.pmT);
        post(new 1(this));
    }

    protected void onDraw(Canvas canvas) {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.pmY = getWidth();
        this.pmZ = getHeight();
        int i5 = -this.pmW;
        int i6 = (this.pnc - this.pmW) + 1;
        int i7 = ((this.pnc * 2) - this.pmW) + 2;
        int i8 = this.pnd + 2;
        int i9 = (this.pnd * 2) + 3;
        int i10 = (this.pnd * 3) + 4;
        this.pmE.layout(i5, 1, this.pna + i5, this.pnb + 1);
        this.pmF.layout(i6, 1, this.pna + i6, this.pnb + 1);
        this.pmG.layout(i7, 1, this.pna + i7, this.pnb + 1);
        this.pmH.layout(i5, i8, this.pna + i5, this.pnb + i8);
        this.pmI.layout(i6, i8, this.pna + i6, this.pnb + i8);
        this.pmJ.layout(i7, i8, this.pna + i7, this.pnb + i8);
        this.pmK.layout(i5, i9, this.pna + i5, this.pnb + i9);
        this.pmL.layout(i6, i9, this.pna + i6, this.pnb + i9);
        this.pmM.layout(i7, i9, this.pna + i7, this.pnb + i9);
        this.pmD.layout(i6, i10, this.pna + i6, this.pnb + i10);
        this.pmN.layout(i7, i10, this.pna + i7, this.pnb + i10);
        this.pmO.layout(0, this.pmV + 1, this.pmY, (this.pmV + 1) + 1);
        this.pmP.layout(0, this.pmV + i8, this.pmY, (i8 + this.pmV) + 1);
        this.pmQ.layout(0, this.pmV + i9, this.pmY, (i9 + this.pmV) + 1);
        this.pmR.layout(0, this.pmV + i10, this.pmY, (this.pmV + i10) + 1);
        this.pmS.layout(this.pnc + 1, this.pmV, this.pnc + 2, this.pmZ);
        this.pmT.layout((this.pnc * 2) + 2, this.pmV, (this.pnc * 2) + 3, this.pmZ);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.pmY = getWidth();
        this.pmZ = getHeight();
        if (!(this.pmY == 0 || this.pmZ == 0)) {
            this.pnc = (this.pmY - 2) / 3;
            this.pnd = ((this.pmZ - this.pmV) - 4) / 4;
            this.pna = this.pnc + (this.pmW * 2);
            this.pnb = this.pnd + (this.pmV * 2);
        }
        this.pmE.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmF.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmG.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmH.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmI.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmJ.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmK.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmL.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmM.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmD.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmN.measure(MeasureSpec.makeMeasureSpec(this.pna, 1073741824), MeasureSpec.makeMeasureSpec(this.pnb, 1073741824));
        this.pmO.measure(MeasureSpec.makeMeasureSpec(this.pmY, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.pmP.measure(MeasureSpec.makeMeasureSpec(this.pmY, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.pmQ.measure(MeasureSpec.makeMeasureSpec(this.pmY, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.pmR.measure(MeasureSpec.makeMeasureSpec(this.pmY, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.pmS.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.pmZ, 1073741824));
        this.pmT.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.pmZ, 1073741824));
    }

    public void onClick(View view) {
        if (!this.pmU) {
            x.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
        } else if (view == this.pmD) {
            input("0");
        } else if (view == this.pmE) {
            input("1");
        } else if (view == this.pmF) {
            input("2");
        } else if (view == this.pmG) {
            input(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (view == this.pmH) {
            input("4");
        } else if (view == this.pmI) {
            input("5");
        } else if (view == this.pmJ) {
            input("6");
        } else if (view == this.pmK) {
            input("7");
        } else if (view == this.pmL) {
            input("8");
        } else if (view == this.pmM) {
            input("9");
        } else if (view == this.pmN && this.pml != null && this.pmU) {
            this.pml.delete();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.pmN && this.pml != null && this.pmU) {
            this.pml.Tt();
        }
        return false;
    }

    public final void hm(boolean z) {
        this.pmU = z;
        this.pmD.setEnabled(z);
        this.pmE.setEnabled(z);
        this.pmF.setEnabled(z);
        this.pmG.setEnabled(z);
        this.pmH.setEnabled(z);
        this.pmI.setEnabled(z);
        this.pmJ.setEnabled(z);
        this.pmK.setEnabled(z);
        this.pmL.setEnabled(z);
        this.pmM.setEnabled(z);
        this.pmN.setEnabled(z);
    }

    private void input(String str) {
        if (this.pml != null && this.pmU) {
            this.pml.input(str);
        }
    }
}
