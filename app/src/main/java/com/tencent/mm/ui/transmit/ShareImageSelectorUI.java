package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;

public class ShareImageSelectorUI extends MMActivity implements OnItemClickListener {
    private static int zpI = 1;
    private ListView Fv;
    private View lCQ;
    private ImageView lIo;
    private af mHandler = new 2(this);
    private String oja;
    private int yUa = 2;
    private a zpJ;
    private Dialog zpK;
    private OnClickListener zpL = new 1(this);

    class a extends BaseAdapter {
        final /* synthetic */ ShareImageSelectorUI zpM;
        public a[] zpN = new a[]{new a(this, R.l.dXW, R.k.dAF), new a(this, R.l.dXX, R.k.dyB), new a(this, R.l.dXV, R.k.dzb)};

        a(ShareImageSelectorUI shareImageSelectorUI) {
            this.zpM = shareImageSelectorUI;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.zpN[i];
        }

        public final int getCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.zpM.mController.xIM).inflate(R.i.dsy, null);
                bVar = new b(this.zpM, view);
            } else {
                bVar = (b) view.getTag();
            }
            a aVar = this.zpN[i];
            if (aVar != null) {
                bVar.zpR.setText(aVar.zpO);
                bVar.mvZ.setImageResource(aVar.zpP);
            }
            return view;
        }
    }

    class b {
        MMImageView mvZ;
        final /* synthetic */ ShareImageSelectorUI zpM;
        TextView zpR;

        public b(ShareImageSelectorUI shareImageSelectorUI, View view) {
            this.zpM = shareImageSelectorUI;
            this.mvZ = (MMImageView) view.findViewById(R.h.cry);
            this.zpR = (TextView) view.findViewById(R.h.crQ);
        }
    }

    static /* synthetic */ void a(ShareImageSelectorUI shareImageSelectorUI) {
        Intent intent = new Intent(shareImageSelectorUI, ShowImageUI.class);
        intent.putExtra("key_image_path", shareImageSelectorUI.oja);
        intent.putExtra("show_menu", false);
        shareImageSelectorUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.dsx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.Hg();
        Object obj = c.CU().get(229635, null);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 0 || intValue == 1) {
                zpI = intValue;
            }
        }
        setMMTitle(R.l.euV);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareImageSelectorUI zpM;

            {
                this.zpM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.zpM.aWh();
                return false;
            }
        });
        this.yUa = getIntent().getIntExtra("Select_Conv_Type", 2);
        this.oja = getIntent().getStringExtra("intent_extra_image_path");
        this.lCQ = findViewById(R.h.cuK);
        this.lIo = (ImageView) findViewById(R.h.image);
        this.lIo.setOnClickListener(this.zpL);
        this.Fv = (ListView) findViewById(R.h.list);
        this.zpJ = new a(this);
        this.Fv.setAdapter(this.zpJ);
        this.Fv.setOnItemClickListener(this);
        x.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[]{this.yUa, this.oja});
        if (zpI == 1) {
            setTitleVisibility(8);
            this.Fv.setVisibility(8);
            this.lIo.setLayoutParams(new LayoutParams(-1, -1));
            this.lIo.setPadding(0, 0, 0, 0);
            this.lIo.setOnClickListener(null);
            this.lCQ.setBackgroundColor(getResources().getColor(R.e.brV));
            cyr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap op = j.op(this.oja);
        x.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[]{Integer.valueOf(ExifHelper.UJ(this.oja))});
        op = d.b(op, (float) r3);
        if (!(op == null || op.isRecycled())) {
            this.lIo.setImageBitmap(op);
        }
        x.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis) + "'"});
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (zpI != 1) {
            return;
        }
        if (this.zpK == null || !this.zpK.isShowing()) {
            cyr();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                cys();
                return;
            case 1:
                cyt();
                return;
            case 2:
                cyu();
                return;
            default:
                x.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1001:
                if (i2 == -1) {
                    ArrayList arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getStringArrayListExtra("Select_Contact");
                    }
                    if (arrayList != null && arrayList.size() == 1) {
                        Intent intent2 = new Intent(this, ChattingUI.class);
                        intent2.putExtra("Chat_User", (String) arrayList.get(0));
                        startActivity(intent2);
                    }
                    finish();
                    return;
                }
                x.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            case 1002:
                if (i2 == -1) {
                    Toast.makeText(this.mController.xIM, R.l.dUd, 0).show();
                    finish();
                    return;
                }
                x.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            default:
                x.w("MicroMsg.ShareImageSelectorUI", "unknow result");
                return;
        }
    }

    public void onBackPressed() {
        aWh();
    }

    private void aWh() {
        h.a(this.mController.xIM, getString(R.l.dXS), getString(R.l.dXU), true, new 4(this), new 5(this));
    }

    private void cyr() {
        if (this.zpK == null || !this.zpK.isShowing()) {
            this.zpK = h.a(this.mController.xIM, getString(R.l.euV), new String[]{getString(R.l.dXW), getString(R.l.dXX), getString(R.l.dXV)}, null, new 6(this), new 7(this));
        }
    }

    private void cys() {
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.yTK);
        intent.putExtra("titile", getString(R.l.dDl));
        intent.putExtra("list_type", 11);
        intent.putExtra("shareImage", true);
        intent.putExtra("shareImagePath", this.oja);
        startActivityForResult(intent, 1001);
    }

    private void cyt() {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", this.oja);
        intent.putExtra("need_result", true);
        com.tencent.mm.bm.d.b(this.mController.xIM, "sns", ".ui.SnsUploadUI", intent, 1002);
    }

    private void cyu() {
        com.tencent.mm.sdk.b.b cfVar = new cf();
        f.a(cfVar, 6, this.oja);
        cfVar.fqp.activity = this;
        cfVar.fqp.fqw = 52;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
        g.pQN.h(11048, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0)});
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(0, 800);
        }
    }
}
