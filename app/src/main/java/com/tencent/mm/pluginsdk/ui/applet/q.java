package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import java.util.LinkedList;
import junit.framework.Assert;

public final class q implements e {
    Context context;
    EditText pqM;
    LinkedList<Integer> pwE;
    i pyk = null;
    View pyl;
    TextView pym;
    r tipDialog;
    String vmQ;
    a vot;
    LinkedList<String> vou;
    boolean vov = true;

    public q(Context context, a aVar) {
        this.context = context;
        this.vot = aVar;
    }

    final void onStart() {
        g.Di().gPJ.a(30, this);
    }

    final void onStop() {
        g.Di().gPJ.b(30, this);
        if (this.pyk != null) {
            this.pyk.dismiss();
            this.pyk = null;
        }
    }

    public final void g(LinkedList<String> linkedList, LinkedList<Integer> linkedList2) {
        boolean z;
        Assert.assertTrue(linkedList.size() > 0);
        if (linkedList2.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        onStart();
        this.vou = linkedList;
        this.pwE = linkedList2;
        this.pyl = View.inflate(this.context, f.drP, null);
        String str = "MicroMsg.SendVerifyRequest";
        String str2 = "verifyTip is null: %b, length : %d, value : [%s]";
        Object[] objArr = new Object[3];
        if (this.vmQ == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(this.vmQ == null ? 0 : this.vmQ.length());
        objArr[2] = this.vmQ;
        x.i(str, str2, objArr);
        if (!bh.ov(this.vmQ)) {
            ((TextView) this.pyl.findViewById(a.e.cLB)).setText(this.vmQ);
        }
        this.pqM = (EditText) this.pyl.findViewById(a.e.cLA);
        this.pym = (TextView) this.pyl.findViewById(a.e.cZH);
        this.pym.setVisibility(0);
        this.pqM.setText(null);
        this.pym.setText("50");
        this.pqM.setFilters(h.vxH);
        this.pqM.addTextChangedListener(new 1(this));
        this.pyk = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(a.h.eKf), this.pyl, new OnClickListener(this) {
            final /* synthetic */ q vow;

            {
                this.vow = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.vow.pyk != null) {
                    this.vow.pyk.dismiss();
                    this.vow.pyk = null;
                }
                new ak(new ak.a(this) {
                    final /* synthetic */ AnonymousClass2 vox;

                    {
                        this.vox = r1;
                    }

                    public final boolean uF() {
                        if (this.vox.vow.pyl != null) {
                            q qVar = this.vox.vow;
                            String trim = this.vox.vow.pqM.getText().toString().trim();
                            Context context = qVar.context;
                            qVar.context.getString(a.h.dGO);
                            qVar.tipDialog = com.tencent.mm.ui.base.h.a(context, qVar.context.getString(a.h.eKe), true, new 5(qVar));
                            g.Di().gPJ.a(new o(2, qVar.vou, qVar.pwE, trim, ""), 0);
                        }
                        return false;
                    }
                }, false).J(500, 500);
            }
        }, new 3(this));
        if (this.pyk == null) {
            onStop();
        }
        this.pqM.post(new Runnable(this) {
            final /* synthetic */ q vow;

            {
                this.vow = r1;
            }

            public final void run() {
                if (this.vow.context instanceof MMActivity) {
                    ((MMActivity) this.vow.context).showVKB();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != 30) {
            x.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + kVar.getType());
            return;
        }
        x.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        onStop();
        if (i == 0 && i2 == 0) {
            if (this.vov) {
                com.tencent.mm.ui.base.h.bu(this.context, this.context.getString(a.h.eKd));
            }
            this.vot.el(true);
            return;
        }
        if (i == 4 && i2 == -34) {
            str = this.context.getString(a.h.eik);
        } else if (i == 4 && i2 == -94) {
            str = this.context.getString(a.h.eil);
        } else if (!(i == 4 && i2 == -24 && !bh.ov(str)) && (i != 4 || bh.ov(str))) {
            str = this.context.getString(a.h.eKc);
        }
        if (this.vov) {
            Toast.makeText(this.context, str, 1).show();
        }
        this.vot.el(false);
    }
}
