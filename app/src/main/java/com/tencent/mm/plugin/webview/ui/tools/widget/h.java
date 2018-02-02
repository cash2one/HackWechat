package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;

public final class h {
    private Context context;
    AuthorizeItemListView iVA;
    private LinearLayout iVC;
    private String iVz;
    private String mAppName = "";
    private b tKG;

    private class b extends BaseAdapter {
        private LinkedList<bec> iVH;
        final /* synthetic */ h tKI;

        private class a {
            ImageView iVL;
            TextView iVM;
            final /* synthetic */ b tKJ;

            private a(b bVar) {
                this.tKJ = bVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return ka(i);
        }

        public b(h hVar, LinkedList<bec> linkedList) {
            this.tKI = hVar;
            this.iVH = linkedList;
        }

        public final int getCount() {
            return this.iVH == null ? 0 : this.iVH.size();
        }

        private bec ka(int i) {
            return (bec) this.iVH.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.iVH == null || this.iVH.size() <= 0) {
                return null;
            }
            a aVar;
            final bec ka = ka(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.daG, null);
                aVar2.iVL = (ImageView) view.findViewById(R.h.bKp);
                aVar2.iVM = (TextView) view.findViewById(R.h.bKo);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (ka.wJQ == 1) {
                aVar.iVL.setImageResource(R.k.dyV);
            } else if (ka.wJQ == 3) {
                aVar.iVL.setImageResource(R.k.dyU);
            } else {
                aVar.iVL.setImageResource(R.k.dyT);
            }
            aVar.iVM.setText(ka.nfe);
            final ImageView imageView = aVar.iVL;
            aVar.iVL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b tKJ;

                public final void onClick(View view) {
                    if (ka.wJQ == 2) {
                        imageView.setImageResource(R.k.dyV);
                        ka.wJQ = 1;
                    } else if (ka.wJQ == 1) {
                        imageView.setImageResource(R.k.dyT);
                        ka.wJQ = 2;
                    }
                }
            });
            return view;
        }
    }

    public h(Context context) {
        this.context = context;
    }

    public final boolean a(LinkedList<bec> linkedList, String str, String str2, String str3, a aVar) {
        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
        this.mAppName = str;
        this.iVz = str2;
        return a(str3, linkedList, aVar);
    }

    public final boolean a(LinkedList<bec> linkedList, String str, String str2, a aVar) {
        return a(linkedList, str, str2, null, aVar);
    }

    private boolean a(String str, LinkedList<bec> linkedList, final a aVar) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
            return false;
        }
        k kVar = new k(this.context, R.m.eYX);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.i.daF, null);
        TextView textView = (TextView) linearLayout.findViewById(R.h.cZi);
        if (!bh.ov(str)) {
            textView.setText(str);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.bKz);
        Drawable a = android.support.v4.b.a.k.a(ac.getResources(), a.decodeResource(ac.getResources(), R.k.bBB));
        a.br();
        if (imageView != null) {
            com.tencent.mm.modelappbrand.a.b.Jj().a(imageView, this.iVz, a, f.hkr);
        }
        textView = (TextView) linearLayout.findViewById(R.h.bKE);
        if (this.mAppName == null) {
            this.mAppName = "";
        }
        textView.setText(this.context.getString(R.l.etq, new Object[]{this.mAppName}));
        this.iVA = (AuthorizeItemListView) linearLayout.findViewById(R.h.bLt);
        this.tKG = new b(this, linkedList);
        this.iVA.setAdapter(this.tKG);
        if (linkedList.size() > 5) {
            this.iVA.Pb = linkedList.size();
            this.iVC = (LinearLayout) linearLayout.findViewById(R.h.bLw);
            LayoutParams layoutParams = (LayoutParams) this.iVC.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(R.f.bxJ);
            this.iVC.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(R.h.cug)).setOnClickListener(new 1(this, linkedList, aVar, kVar));
        ((Button) linearLayout.findViewById(R.h.cus)).setOnClickListener(new 2(this, linkedList, aVar, kVar));
        kVar.setCanceledOnTouchOutside(false);
        kVar.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ h tKI;

            {
                this.tKI = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                if (this.tKI.iVA != null) {
                    this.tKI.iVA.setAdapter(null);
                }
            }
        });
        kVar.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ h tKI;

            public final void onCancel(DialogInterface dialogInterface) {
                x.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                aVar.d(3, null);
            }
        });
        kVar.setContentView(linearLayout);
        try {
            kVar.show();
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
