package com.tencent.mm.pluginsdk.ui.applet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.ui.applet.e.10;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.p;
import java.util.LinkedList;

public final class b implements a, a.a, m {
    private String gLS;
    private int irz;
    String jKk;
    x lFr;
    ProgressDialog ltM;
    Context mContext;
    private l vmZ;
    i vna;
    e vnb;
    private boolean vnc;

    public b(Context context, String str, int i, l lVar) {
        this(context, str, 0, lVar, true, "");
    }

    public b(Context context, String str, int i, l lVar, String str2) {
        this(context, str, i, lVar, true, str2);
    }

    public b(Context context, String str, int i, l lVar, boolean z, String str2) {
        this.vnb = null;
        this.vnc = true;
        this.mContext = context;
        this.jKk = str;
        this.irz = i;
        this.vmZ = lVar;
        this.vnc = z;
        this.gLS = str2;
    }

    public final void show() {
        g.Dk();
        this.lFr = ((h) g.h(h.class)).EY().WO(this.jKk);
        if (this.lFr != null && ((int) this.lFr.gJd) <= 0) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[]{this.jKk});
            g.Dk();
            this.lFr = ((h) g.h(h.class)).EY().WL(this.jKk);
        }
        if (this.lFr == null || ((int) this.lFr.gJd) <= 0) {
            Context context = this.mContext;
            this.mContext.getString(R.l.dGO);
            this.ltM = com.tencent.mm.ui.base.h.a(context, this.mContext.getString(R.l.eYm), true, new 1(this));
            Sl(this.jKk);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
        if (this.lFr == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
            fW(-1);
            return;
        }
        String str = this.lFr.field_username;
        if (this.lFr.cia()) {
            if (com.tencent.mm.l.a.fZ(this.lFr.field_type)) {
                com.tencent.mm.ui.base.h.bu(this.mContext, this.mContext.getResources().getString(R.l.eYp));
                fW(-2);
                return;
            }
            M(this.lFr);
        } else if (((com.tencent.mm.api.h) g.h(com.tencent.mm.api.h.class)).cc(str)) {
            context = this.mContext;
            this.mContext.getString(R.l.dGO);
            this.ltM = com.tencent.mm.ui.base.h.a(context, this.mContext.getString(R.l.eYm), true, null);
            Sl(str);
        } else {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bBz);
            if (this.mContext instanceof MMActivity) {
                OnCancelListener onCancelListener;
                p pVar = ((MMActivity) this.mContext).mController;
                CharSequence string = this.mContext.getResources().getString(R.l.eYr);
                o.a 5 = new 5(this);
                View V = e.V(pVar.xIM, R.i.deF);
                q cX = e.cX(V);
                e.a(V, 5, cX);
                if (bh.ov(string)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
                    onCancelListener = null;
                } else {
                    TextView textView = (TextView) V.findViewById(R.h.bWT);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, string, textView.getTextSize()));
                    Button button = (Button) V.findViewById(R.h.bWM);
                    ImageView imageView = (ImageView) V.findViewById(R.h.bWV);
                    if (imageView != null) {
                        if (decodeResource == null || decodeResource.isRecycled()) {
                            imageView.setVisibility(8);
                        } else {
                            imageView.setImageBitmap(decodeResource);
                            cX.setOnDismissListener(new e$6(decodeResource));
                        }
                    }
                    button.setOnClickListener(new 10(5, V, cX));
                    e.a(pVar, cX);
                    Object obj = cX;
                }
                if (onCancelListener == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
                    fW(-1);
                }
            }
        }
    }

    final void M(x xVar) {
        if (xVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
            fW(-1);
            return;
        }
        Bitmap bitmap;
        CharSequence string = this.mContext.getString(R.l.eYk);
        Bitmap a = com.tencent.mm.ad.b.a(xVar.field_username, false, -1);
        if (a == null) {
            n.Jz().a(this);
        }
        if (a == null || !xVar.cia()) {
            bitmap = a;
        } else {
            bitmap = d.a(a, false, (float) (a.getWidth() / 2));
        }
        CharSequence charSequence = xVar.field_nickname;
        this.vna = null;
        if (this.mContext instanceof MMActivity) {
            if (this.vnc) {
                i iVar;
                p pVar = ((MMActivity) this.mContext).mController;
                CharSequence charSequence2 = "";
                int i = R.l.dUt;
                xVar.cia();
                o.a 2 = new 2(this, xVar);
                if ((string == null || string.length() == 0) && (charSequence == null || charSequence.length() == 0)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
                    iVar = null;
                } else {
                    View V = e.V(pVar.xIM, R.i.deE);
                    i$a com_tencent_mm_ui_base_i_a = new i$a(pVar.xIM);
                    com_tencent_mm_ui_base_i_a.mi(false);
                    com_tencent_mm_ui_base_i_a.mj(false);
                    e.l(V, false);
                    e.a(pVar, com_tencent_mm_ui_base_i_a, 2, V, pVar.xIM.getResources().getString(i));
                    TextView textView = (TextView) V.findViewById(R.h.bWW);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, string, textView.getTextSize()));
                    textView = (TextView) V.findViewById(R.h.bWT);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, charSequence, textView.getTextSize()));
                    if (charSequence2.length() == 0) {
                        V.findViewById(R.h.bWQ).setVisibility(8);
                    } else {
                        ((TextView) V.findViewById(R.h.bWQ)).setText(charSequence2);
                    }
                    ImageView imageView = (ImageView) V.findViewById(R.h.bWV);
                    if (imageView != null) {
                        if (bitmap == null || bitmap.isRecycled()) {
                            imageView.setVisibility(4);
                        } else {
                            imageView.setImageBitmap(bitmap);
                            e.a(com_tencent_mm_ui_base_i_a, bitmap);
                        }
                    }
                    com_tencent_mm_ui_base_i_a.dk(V);
                    iVar = com_tencent_mm_ui_base_i_a.akx();
                    iVar.show();
                }
                this.vna = iVar;
            } else {
                N(xVar);
                return;
            }
        }
        if (this.vna == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
            fW(-1);
        }
    }

    final void N(x xVar) {
        if (this.ltM != null) {
            this.ltM.dismiss();
        }
        Context context = this.mContext;
        this.mContext.getString(R.l.dGO);
        this.ltM = com.tencent.mm.ui.base.h.a(context, this.mContext.getString(R.l.eYm), true, null);
        a aVar = new a(this.mContext, this);
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.irz));
        aVar.a(xVar.field_username, linkedList, this.gLS);
    }

    public final void jh(String str) {
        Object obj = 1;
        if (this.lFr != null) {
            Object obj2 = (this.lFr.field_username == null || !this.lFr.field_username.equals(str)) ? null : 1;
            if (this.lFr.vN() == null || !this.lFr.vN().equals(str)) {
                obj = null;
            }
            if (obj2 == null && r1 == null) {
                return;
            }
        } else if (this.jKk == null || !this.jKk.equals(str)) {
            return;
        }
        if (this.vna != null && this.vna.isShowing()) {
            ag.y(new 3(this));
        }
    }

    private void Sl(String str) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[]{str});
        if (this.vnb == null) {
            this.vnb = new 4(this);
        }
        g.Dk();
        g.Di().gPJ.a(106, this.vnb);
        k acVar = new ac(str);
        g.Dk();
        g.Di().gPJ.a(acVar, 0);
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        if (this.ltM != null) {
            this.ltM.dismiss();
        }
        if (z) {
            this.lFr.Ag();
            g.Dk();
            ((h) g.h(h.class)).EY().a(this.lFr.field_username, this.lFr);
            com.tencent.mm.ui.base.h.bu(this.mContext, this.mContext.getResources().getString(R.l.eYp));
            fW(1);
            return;
        }
        fW(-1);
    }

    final void fW(int i) {
        if (this.vmZ != null) {
            this.vmZ.kp(i);
        }
    }
}
