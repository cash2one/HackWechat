package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;

public final class c {
    public q inJ;
    private ImageView inK;
    private View inL;
    private OnClickListener inN;
    public boolean kRg;
    private Bitmap kUY;
    private View kVb;
    private ImageView kVc;
    private MMVerticalTextView kVd;
    private ArrayList<Bitmap> kVf;
    private MMActivity kaY;
    private String oVO;
    public Bitmap oXQ;
    public Bitmap oXR;
    private String oYl;
    ViewGroup zIU;
    private boolean zIV;

    public c(MMActivity mMActivity, boolean z) {
        this.oXQ = null;
        this.oXR = null;
        this.kUY = null;
        this.oYl = "";
        this.oVO = "";
        this.kRg = true;
        this.kVf = new ArrayList();
        this.inJ = null;
        this.zIV = false;
        this.inN = new OnClickListener(this) {
            final /* synthetic */ c zIW;

            {
                this.zIW = r1;
            }

            public final void onClick(View view) {
                if ((view.getId() == f.cDg || view.getId() == f.cDe) && this.zIW.inJ != null && this.zIW.inJ.isShowing()) {
                    this.zIW.inJ.dismiss();
                }
            }
        };
        this.kaY = mMActivity;
        this.zIV = z;
    }

    public c(MMActivity mMActivity) {
        this(mMActivity, false);
    }

    public final void fS(String str, String str2) {
        this.oYl = str;
        this.oVO = str2;
    }

    public final void init() {
        if (this.inJ == null) {
            View view;
            if (this.zIV) {
                View inflate = View.inflate(this.kaY, g.uFq, null);
                MMVerticalTextView mMVerticalTextView = (MMVerticalTextView) inflate.findViewById(f.urC);
                this.zIU = (ViewGroup) inflate.findViewById(f.utC);
                mMVerticalTextView.setOnClickListener(new 2(this));
                inflate.findViewById(f.utB).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ c zIW;

                    {
                        this.zIW = r1;
                    }

                    public final void onClick(View view) {
                        x.d("MicroMsg.OfflinePopupWindow", "root on click");
                        if (this.zIW.inJ != null && this.zIW.inJ.isShowing()) {
                            this.zIW.inJ.dismiss();
                        }
                    }
                });
                view = inflate;
            } else {
                View inflate2 = View.inflate(this.kaY, g.uFt, null);
                inflate2.setOnClickListener(new 4(this));
                view = inflate2;
            }
            this.inL = view.findViewById(f.cDh);
            this.inK = (ImageView) view.findViewById(f.cDg);
            this.kVb = view.findViewById(f.cDf);
            this.kVc = (ImageView) view.findViewById(f.cDe);
            this.kVd = (MMVerticalTextView) view.findViewById(f.cUB);
            this.inJ = new q(view, -1, -1, true);
            this.inJ.setClippingEnabled(false);
            this.inJ.update();
            this.inJ.setBackgroundDrawable(new ColorDrawable(16777215));
            this.inJ.setOnDismissListener(new 5(this));
        }
    }

    public final void release() {
        if (this.inJ != null && this.inJ.isShowing()) {
            this.inJ.dismiss();
        }
        e.u(this.kUY);
        e.an(this.kVf);
        this.kVf.clear();
        this.kaY = null;
    }

    public final void u(View view, boolean z) {
        this.kRg = z;
        if (this.inJ != null && !this.inJ.isShowing()) {
            this.inJ.showAtLocation(view.getRootView(), 17, 0, 0);
            this.inJ.setFocusable(true);
            this.inJ.setTouchable(true);
            this.inJ.setBackgroundDrawable(new ColorDrawable(16777215));
            this.inJ.setOutsideTouchable(true);
            if (this.kRg) {
                cBW();
            }
            cBX();
        }
    }

    public final void cBV() {
        if (this.inJ != null && this.inJ.isShowing()) {
            cBX();
        }
    }

    public final void cBW() {
        if (this.zIU != null) {
            this.zIU.setVisibility(0);
        }
    }

    private void cBX() {
        if (this.kRg) {
            this.kVc.setOnClickListener(this.inN);
            Bitmap bitmap = this.kUY;
            if (this.oXR != null) {
                this.kUY = e.t(this.oXR);
                x.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
            } else {
                this.kUY = null;
                x.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
            }
            this.kVc.setImageBitmap(this.kUY);
            this.kVf.add(0, bitmap);
            if (this.kVf.size() >= 2) {
                for (int size = this.kVf.size() - 1; size > 1; size--) {
                    e.u((Bitmap) this.kVf.remove(size));
                }
            }
            this.inL.setVisibility(8);
            this.kVb.setVisibility(0);
            this.kVd.setText(e.aaF(this.oVO));
        } else {
            this.inK.setOnClickListener(this.inN);
            this.inK.setImageBitmap(this.oXQ);
            if (this.oXQ != null) {
                x.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                x.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.inL.setVisibility(0);
            this.kVb.setVisibility(8);
        }
        this.inJ.update();
    }

    public final void dismiss() {
        if (this.inJ != null && this.inJ.isShowing()) {
            this.inJ.dismiss();
        }
    }
}
