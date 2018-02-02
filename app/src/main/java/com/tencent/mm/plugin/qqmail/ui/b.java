package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.qqmail.b.h.d;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    int mode;
    private TextView pqI;
    private ImageView pqJ;
    ComposeUI psk;
    ViewGroup psl;
    Map<String, y> psm;
    Map<String, o> psn;
    Map<String, String> pso;
    Map<String, String> psp;
    b psq;
    private OnClickListener psr;

    public interface b {
        void bkI();

        void onComplete();
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.bkQ()) {
            Object obj;
            for (String str : bVar.psm.keySet()) {
                if (((y) bVar.psm.get(str)).state != 2) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null && bVar.psq != null) {
                bVar.psq.onComplete();
            }
        } else if (bVar.psq != null) {
            b bVar2 = bVar.psq;
            bVar.psm.size();
            for (String str2 : bVar.psm.keySet()) {
                if (((y) bVar.psm.get(str2)).state != 2) {
                    break;
                }
            }
            bVar2.bkI();
        }
    }

    private b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        this.psm = new HashMap();
        this.psn = new HashMap();
        this.pso = new LinkedHashMap();
        this.psp = new LinkedHashMap();
        this.psq = null;
        this.psr = null;
        this.mode = 5;
        this.psk = composeUI;
        this.psl = viewGroup;
        this.psr = null;
        this.pqI = textView;
        this.pqJ = imageView;
        bkR();
        ar.CG().a(484, (e) this);
    }

    public b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup, byte b) {
        this(composeUI, textView, imageView, viewGroup);
    }

    public final void br(List<y> list) {
        if (list != null) {
            for (y yVar : list) {
                a(yVar);
                this.psm.put(yVar.path, yVar);
            }
            if (this.mode == 6) {
                for (y yVar2 : list) {
                    this.pso.put(yVar2.path, yVar2.pqa);
                    this.psp.put(yVar2.path, yVar2.name);
                }
            }
        }
    }

    public final void dI(String str, String str2) {
        if (str != null && str.length() != 0 && !this.psm.containsKey(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                y yVar = new y();
                yVar.path = str;
                if (str2 == null) {
                    yVar.name = file.getName();
                } else {
                    yVar.name = str2;
                }
                yVar.size = file.length();
                yVar.state = 0;
                this.psm.put(str, yVar);
                a(yVar);
            }
        }
    }

    private void a(final y yVar) {
        LinearLayout linearLayout = (LinearLayout) ((ViewGroup) View.inflate(this.psk, R.i.dpS, null)).findViewById(R.h.cCS);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.cCR);
        TextView textView = (TextView) linearLayout.findViewById(R.h.cCT);
        TextView textView2 = (TextView) linearLayout.findViewById(R.h.cCV);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.h.cCW);
        TextView textView3 = (TextView) linearLayout.findViewById(R.h.cCX);
        final ImageView imageView2 = (ImageView) linearLayout.findViewById(R.h.cCU);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(R.h.cCQ);
        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
        imageView.setImageResource(FileExplorerUI.SM(yVar.name));
        textView.setText(yVar.name);
        textView2.setText(bh.bx(yVar.size));
        a aVar = new a(this, (byte) 0);
        aVar.jCP = imageView;
        aVar.lgz = textView;
        aVar.prT = textView2;
        aVar.psA = progressBar;
        aVar.psB = textView3;
        aVar.psC = imageView2;
        aVar.psD = imageView3;
        linearLayout.setTag(aVar);
        linearLayout.setId(Math.abs(yVar.path.hashCode() / 2));
        if (this.psr != null) {
            linearLayout.setOnClickListener(this.psr);
        }
        this.psl.addView(linearLayout);
        bkR();
        linearLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b pst;

            public final void onClick(View view) {
                if (imageView2.getVisibility() == 0) {
                    imageView2.performClick();
                }
            }
        });
        imageView2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b pst;

            public final void onClick(View view) {
                if (this.pst.mode == 5) {
                    yVar.ppZ = this.pst.HS(yVar.path);
                } else if (this.pst.mode == 6) {
                    yVar.ppZ = this.pst.dJ(yVar.path, yVar.name);
                }
            }
        });
        imageView3.setOnClickListener(new 3(this, yVar, linearLayout));
        this.psl.post(new 4(this, yVar));
        if (yVar.state != 0) {
            return;
        }
        if (this.mode == 5) {
            yVar.ppZ = HS(yVar.path);
        } else if (this.mode == 6) {
            yVar.ppZ = dJ(yVar.path, yVar.name);
        }
    }

    public final String bkN() {
        String str = "";
        for (String str2 : this.psm.keySet()) {
            if (str.length() > 0) {
                str = str + "|";
            }
            str = str + ((y) this.psm.get(str2)).pqa;
        }
        return str;
    }

    public final LinkedList<y> bkO() {
        LinkedList<y> linkedList = new LinkedList();
        for (String str : this.psm.keySet()) {
            linkedList.add(this.psm.get(str));
        }
        return linkedList;
    }

    public final void bkP() {
        y yVar;
        if (this.mode == 5) {
            for (String str : this.psm.keySet()) {
                yVar = (y) this.psm.get(str);
                if (yVar.state != 2) {
                    w.bks().cancel(yVar.ppZ);
                    yVar.state = 3;
                    b(yVar);
                }
            }
        } else if (this.mode == 6) {
            for (String str2 : this.psm.keySet()) {
                yVar = (y) this.psm.get(str2);
                if (yVar.state != 2) {
                    k kVar = (o) this.psn.get(yVar.path);
                    if (kVar != null) {
                        ar.CG().c(kVar);
                        yVar.state = 3;
                        b(yVar);
                    }
                    this.pso.remove(yVar.path);
                    this.psp.remove(yVar.path);
                    this.psn.remove(yVar.path);
                }
            }
        }
    }

    final long HS(final String str) {
        c cVar = new c();
        cVar.ppk = false;
        cVar.ppj = true;
        return w.bks().a("/cgi-bin/uploaddata", 1, null, new d("UploadFile", str), cVar, new a(this) {
            final /* synthetic */ b pst;

            public final boolean onReady() {
                y yVar = (y) this.pst.psm.get(str);
                if (yVar != null) {
                    yVar.state = 1;
                    this.pst.b(yVar);
                }
                return true;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                String str2 = (String) map.get(".Response.result.DataID");
                y yVar = (y) this.pst.psm.get(str);
                if (yVar != null) {
                    yVar.state = 2;
                    yVar.pqa = str2;
                    this.pst.b(yVar);
                }
            }

            public final void onError(int i, String str) {
                x.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", Integer.valueOf(i), str);
                y yVar = (y) this.pst.psm.get(str);
                if (yVar != null) {
                    yVar.state = 3;
                    this.pst.b(yVar);
                }
                if (i == -5) {
                    this.pst.psk.pqQ.a(new 1(this));
                }
            }

            public final void onComplete() {
                b.a(this.pst);
            }
        });
    }

    final long dJ(final String str, final String str2) {
        if (this.psn.containsKey(str)) {
            return (long) ((o) this.psn.get(str)).hashCode();
        }
        k oVar = new o(str, str, new f(this) {
            final /* synthetic */ b pst;

            public final void a(int i, int i2, k kVar) {
                x.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", Integer.valueOf(i), Integer.valueOf(i2));
                final y yVar;
                if (i < i2) {
                    x.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                    yVar = (y) this.pst.psm.get(str);
                    if (yVar != null) {
                        yVar.state = 1;
                        ag.y(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 psz;

                            public final void run() {
                                this.psz.pst.b(yVar);
                            }
                        });
                    }
                } else if (i >= i2) {
                    yVar = (y) this.pst.psm.get(str);
                    String str = ((o) kVar).bkm().vYg;
                    this.pst.pso.put(str, str);
                    this.pst.psp.put(str, str2);
                    this.pst.psn.remove(str);
                    x.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", str, str);
                    if (yVar != null) {
                        yVar.state = 2;
                        yVar.pqa = str;
                        ag.y(new 2(this, yVar));
                    }
                    b.a(this.pst);
                }
            }
        });
        y yVar = (y) this.psm.get(str);
        if (yVar != null) {
            yVar.state = 1;
        }
        b(yVar);
        ar.CG().a(oVar, 0);
        this.psn.put(str, oVar);
        return (long) oVar.hashCode();
    }

    public final boolean bkQ() {
        for (String str : this.psm.keySet()) {
            y yVar = (y) this.psm.get(str);
            if (yVar.state != 2 && yVar.state != 3) {
                return false;
            }
        }
        return true;
    }

    public final void bkR() {
        if (this.psm.size() == 0) {
            this.pqI.setText(this.psk.getString(R.l.eAo) + " " + this.psk.getString(R.l.eAr));
            this.pqJ.setImageResource(R.k.dAo);
            ((View) this.psl.getParent()).setVisibility(8);
        } else {
            this.pqI.setText(this.psk.getString(R.l.eAo) + this.psk.getResources().getQuantityString(R.j.duH, this.psm.size(), new Object[]{Integer.valueOf(this.psm.size()), bh.bx((long) bkS())}));
            this.pqJ.setImageResource(R.k.dAp);
            ((View) this.psl.getParent()).setVisibility(0);
        }
        int childCount = this.psl.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (childCount == 1) {
                this.psl.getChildAt(i).setBackgroundResource(R.g.bDA);
            } else if (i == 0) {
                this.psl.getChildAt(i).setBackgroundResource(R.g.bDB);
            } else if (i <= 0 || i >= childCount - 1) {
                this.psl.getChildAt(i).setBackgroundResource(R.g.bDD);
            } else {
                this.psl.getChildAt(i).setBackgroundResource(R.g.bDC);
            }
            i++;
        }
    }

    public final int bkS() {
        int i = 0;
        for (String str : this.psm.keySet()) {
            long j = (long) i;
            i = (int) (((y) this.psm.get(str)).size + j);
        }
        return i;
    }

    final void b(y yVar) {
        LinearLayout linearLayout = (LinearLayout) this.psl.findViewById(Math.abs(yVar.path.hashCode() / 2));
        if (linearLayout != null) {
            a aVar = (a) linearLayout.getTag();
            switch (yVar.state) {
                case 0:
                case 1:
                    aVar.lgz.setTextColor(WebView.NIGHT_MODE_COLOR);
                    aVar.psA.setVisibility(0);
                    aVar.psB.setVisibility(8);
                    aVar.psC.setVisibility(8);
                    aVar.psD.setVisibility(0);
                    return;
                case 2:
                    aVar.lgz.setTextColor(WebView.NIGHT_MODE_COLOR);
                    aVar.psA.setVisibility(8);
                    aVar.psB.setVisibility(8);
                    aVar.psC.setVisibility(8);
                    aVar.psD.setVisibility(0);
                    return;
                case 3:
                    aVar.lgz.setTextColor(com.tencent.mm.bv.a.c(this.psk, R.e.btc));
                    aVar.psA.setVisibility(8);
                    aVar.psB.setVisibility(0);
                    aVar.psC.setVisibility(0);
                    aVar.psD.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 484) {
            kVar = (o) kVar;
            String str2 = kVar.filePath;
            final y yVar = (y) this.psm.get(str2);
            if (yVar == null) {
                return;
            }
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", Integer.valueOf(i), Integer.valueOf(i2), str2);
                yVar.state = 3;
                this.psn.remove(str2);
                ar.CG().c(kVar);
                ag.y(new Runnable(this) {
                    final /* synthetic */ b pst;

                    public final void run() {
                        this.pst.b(yVar);
                    }
                });
            }
        }
    }
}
