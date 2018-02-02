package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ar.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MassSendMsgUI extends MMActivity implements e {
    private static String onN = "";
    private String filePath;
    private TextView nLo;
    private TextView onM;
    private i onO;
    private b onP;
    private a onQ = new a(this) {
        final /* synthetic */ MassSendMsgUI onR;

        {
            this.onR = r1;
        }

        public final void aYN() {
            Toast.makeText(this.onR, this.onR.getString(R.l.euQ), 0).show();
        }

        public final void aYO() {
            Toast.makeText(this.onR, this.onR.getString(R.l.euE), 0).show();
        }

        public final void aYP() {
            Toast.makeText(this.onR, this.onR.getString(R.l.euO), 0).show();
        }

        public final void aYQ() {
            Toast.makeText(this.onR, this.onR.getString(R.l.euK), 0).show();
        }

        public final void aYR() {
            Toast.makeText(this.onR, this.onR.getString(R.l.euE), 0).show();
        }

        public final void sq(int i) {
            switch (i) {
                case 0:
                    File file = new File(com.tencent.mm.compatible.util.e.gHu);
                    if (file.exists() || file.mkdir()) {
                        x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.onR.mController.xIM, "android.permission.CAMERA", 16, "", "")), bh.cgy(), this.onR.mController.xIM});
                        if (com.tencent.mm.pluginsdk.g.a.a(this.onR.mController.xIM, "android.permission.CAMERA", 16, "", "")) {
                            this.onR.arQ();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.onR, this.onR.getString(R.l.dTe), 1).show();
                    return;
                case 1:
                    k.a(this.onR, 1, 1, 0, 3, false, null);
                    return;
                default:
                    return;
            }
        }

        public final void b(f fVar) {
        }

        public final void aYS() {
            com.tencent.mm.plugin.masssend.a.ifs.av(this.onR);
        }

        public final void aYT() {
            Toast.makeText(this.onR, this.onR.getString(R.l.euE), 0).show();
        }

        public final void aYU() {
        }

        public final void aYV() {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            d.b(this.onR, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        }

        public final void sr(int i) {
            MassSendMsgUI.d(this.onR);
        }

        public final void aYW() {
            Toast.makeText(this.onR, this.onR.getString(R.l.euL), 0).show();
        }

        public final void aYX() {
        }

        public final void aYY() {
        }

        public final void aYZ() {
        }

        public final void aZa() {
        }
    };
    private ChatFooter one;
    private String ong;
    private List<String> onh;
    private boolean oni = false;
    private r tipDialog = null;

    static /* synthetic */ void a(MassSendMsgUI massSendMsgUI, String str, int i) {
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.omN = massSendMsgUI.ong;
        aVar.omO = massSendMsgUI.onh.size();
        aVar.filename = str;
        aVar.omP = i;
        aVar.omS = 2;
        aVar.msgType = 43;
        com.tencent.mm.ae.k fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, massSendMsgUI.oni);
        ar.CG().a(fVar, 0);
        if (massSendMsgUI.tipDialog != null && massSendMsgUI.tipDialog.isShowing()) {
            massSendMsgUI.tipDialog.setOnCancelListener(new 6(massSendMsgUI, fVar));
        }
    }

    static /* synthetic */ void d(MassSendMsgUI massSendMsgUI) {
        x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")), bh.cgy(), massSendMsgUI});
        if (com.tencent.mm.pluginsdk.g.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")) {
            x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")), bh.cgy(), massSendMsgUI});
            if (com.tencent.mm.pluginsdk.g.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")) {
                g.pQN.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                k.a(massSendMsgUI, 8, new Intent(), 1, massSendMsgUI.ong, 0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(JsApiChooseMedia.CTRL_INDEX, this);
        this.oni = getIntent().getBooleanExtra("mass_send_again", false);
        this.ong = getIntent().getStringExtra("mass_send_contact_list");
        String str = this.ong;
        this.onh = new ArrayList();
        if (!(str == null || str.equals(""))) {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                this.onh = bh.F(split);
            }
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.one != null) {
            this.one.p(onN, -1, true);
            this.one.a(this.mController.xIM, this);
        }
    }

    public static void Ek(String str) {
        onN = str;
    }

    protected void onDestroy() {
        ar.CG().b(JsApiChooseMedia.CTRL_INDEX, this);
        super.onDestroy();
        if (this.one != null) {
            this.one.destroy();
        }
    }

    protected void onPause() {
        this.one.aJO();
        this.one.onPause();
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dne;
    }

    protected final void initView() {
        CharSequence spannableString;
        boolean z = false;
        setMMTitle(R.l.dne);
        this.onM = (TextView) findViewById(R.h.cvo);
        this.nLo = (TextView) findViewById(R.h.cvn);
        TextView textView = this.onM;
        int textSize = (int) this.onM.getTextSize();
        if (this.onh == null) {
            spannableString = new SpannableString("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.onh.size(); i++) {
                String gu = com.tencent.mm.z.r.gu((String) this.onh.get(i));
                if (i == this.onh.size() - 1) {
                    stringBuilder.append(gu);
                } else {
                    stringBuilder.append(gu + ",  ");
                }
            }
            spannableString = com.tencent.mm.pluginsdk.ui.d.i.c(this, stringBuilder.toString(), textSize);
        }
        textView.setText(spannableString);
        this.nLo.setText(getResources().getQuantityString(R.j.duB, this.onh.size(), new Object[]{Integer.valueOf(this.onh.size())}));
        this.one = (ChatFooter) findViewById(R.h.cyG);
        ((MassSendLayout) findViewById(R.h.cvs)).jMa = this.one.vpX;
        this.one.Co(R.h.cvs);
        this.onP = new b(this, this.one, this.ong, this.onh, this.oni);
        this.one.vqe = this.onP;
        this.one.b(new d(this));
        ChatFooter chatFooter = this.one;
        ar.Hg();
        int intValue = ((Integer) c.CU().get(18, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = 1;
        }
        chatFooter.aa(intValue, true);
        this.one.SA("masssendapp");
        this.one.vpT.refresh();
        ar.Hg();
        if (((Boolean) c.CU().get(66832, Boolean.valueOf(false))).booleanValue()) {
            this.one.cbL();
            this.one.cbH();
        }
        this.one.addTextChangedListener(new 8(this));
        this.one.cbG();
        this.one.cby();
        this.one.cbF();
        this.one.cbB();
        this.one.cbE();
        this.one.lj(true);
        this.one.a(this.onQ);
        ChatFooter chatFooter2 = this.one;
        d.ccW();
        if (b.PP() || (q.Gd() & 33554432) != 0) {
            z = true;
        }
        chatFooter2.lk(z);
        this.one.cbA();
        this.one.cbK();
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendMsgUI onR;

            {
                this.onR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.onR.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0 || !this.one.cbN()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.one.cbP();
        return true;
    }

    private void arQ() {
        if (!k.c(this, com.tencent.mm.compatible.util.e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.l.eJu), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.MassSendMsgUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    arQ();
                    return;
                } else {
                    h.a(this, getString(R.l.ezM), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 10(this), null);
                    return;
                }
            default:
                return;
        }
    }

    private void N(Intent intent) {
        String stringExtra = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.omN = this.ong;
        aVar.omO = this.onh.size();
        aVar.filename = stringExtra;
        aVar.omP = intExtra;
        aVar.msgType = 43;
        com.tencent.mm.ae.k fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, this.oni);
        ar.CG().a(fVar, 0);
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.tipDialog = h.a(context, getString(R.l.eKe), true, new 11(this, fVar));
    }

    private void O(Intent intent) {
        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
        if (stringExtra != null) {
            int i = q.a(stringExtra, null, intent.getBooleanExtra("CropImage_Compress_Img", true)) ? 1 : 0;
            com.tencent.mm.plugin.masssend.a.h.aYD();
            com.tencent.mm.plugin.masssend.a.a i2 = com.tencent.mm.plugin.masssend.a.b.i(stringExtra, this.ong, this.onh.size(), i);
            if (i2 != null) {
                com.tencent.mm.ae.k fVar = new com.tencent.mm.plugin.masssend.a.f(i2, this.oni, i);
                ar.CG().a(fVar, 0);
                Context context = this.mController.xIM;
                getString(R.l.dGO);
                this.tipDialog = h.a(context, getString(R.l.eKe), true, new 12(this, fVar));
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            Context applicationContext;
            switch (i) {
                case 1:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("is_video", false)) {
                        String stringExtra = intent.getStringExtra("video_full_path");
                        Intent intent2 = new Intent();
                        intent2.setData(Uri.parse("file://" + stringExtra));
                        P(intent2);
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 4);
                    intent3.putExtra("CropImage_Filter", true);
                    n nVar = com.tencent.mm.plugin.masssend.a.ifs;
                    ar.Hg();
                    nVar.a(this, intent, intent3, c.Fi(), 4, null);
                    return;
                case 2:
                    applicationContext = getApplicationContext();
                    ar.Hg();
                    this.filePath = k.b(applicationContext, intent, c.Fi());
                    if (this.filePath != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("CropImageMode", 4);
                        intent4.putExtra("CropImage_Filter", true);
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        com.tencent.mm.plugin.masssend.a.ifs.a(this.mController.xIM, intent4, 4);
                        return;
                    }
                    return;
                case 4:
                    O(intent);
                    return;
                case 5:
                    N(intent);
                    return;
                case 6:
                    P(intent);
                    return;
                case 7:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("from_record", false)) {
                        N(intent);
                        return;
                    } else {
                        P(intent);
                        return;
                    }
                case 8:
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        return;
                    }
                    String str;
                    if (sightCaptureResult.oqz) {
                        str = sightCaptureResult.oqH;
                        if (!bh.ov(str)) {
                            try {
                                boolean z = sightCaptureResult.oqA;
                                x.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[]{str});
                                com.tencent.mm.plugin.masssend.a.h.aYD();
                                com.tencent.mm.plugin.masssend.a.a i3 = com.tencent.mm.plugin.masssend.a.b.i(str, this.ong, this.onh.size(), 0);
                                if (i3 != null) {
                                    final com.tencent.mm.ae.k fVar = new com.tencent.mm.plugin.masssend.a.f(i3, this.oni, 0);
                                    ar.CG().a(fVar, 0);
                                    applicationContext = this.mController.xIM;
                                    getString(R.l.dGO);
                                    this.tipDialog = h.a(applicationContext, getString(R.l.eKe), true, new OnCancelListener(this) {
                                        final /* synthetic */ MassSendMsgUI onR;

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            ar.CG().c(fVar);
                                        }
                                    });
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                x.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[]{e.getMessage()});
                                return;
                            }
                        }
                        return;
                    }
                    x.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[]{sightCaptureResult.oqB, sightCaptureResult.oqC});
                    o.TU();
                    str = s.nt(sightCaptureResult.oqD);
                    if (!sightCaptureResult.oqB.equals(str)) {
                        x.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[]{sightCaptureResult.oqB, str});
                        FileOp.at(sightCaptureResult.oqB, str);
                    }
                    str = sightCaptureResult.oqD;
                    final int i4 = sightCaptureResult.oqF;
                    com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
                    getString(R.l.dGO);
                    this.tipDialog = h.a(this, getString(R.l.dHc), true, new 14(this, cVar));
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ MassSendMsgUI onR;

                        public final void run() {
                            VideoTransPara MV = com.tencent.mm.modelcontrol.d.MU().MV();
                            aqc com_tencent_mm_protocal_c_aqc = new aqc();
                            com_tencent_mm_protocal_c_aqc.wwP = true;
                            if (l.a(str, MV, com_tencent_mm_protocal_c_aqc, new 1(this))) {
                                l.b(str, MV, com_tencent_mm_protocal_c_aqc, new 2(this));
                            }
                            ag.y(new 3(this));
                        }
                    }, "MassSend_Remux");
                    return;
                default:
                    x.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    private void P(Intent intent) {
        if (ab.bC(this)) {
            Q(intent);
        } else {
            h.a(this, R.l.eSZ, R.l.dGO, new 2(this, intent), new OnClickListener(this) {
                final /* synthetic */ MassSendMsgUI onR;

                {
                    this.onR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    private void Q(Intent intent) {
        com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        getString(R.l.dGO);
        this.tipDialog = h.a(this, getString(R.l.dHc), true, new 4(this, cVar));
        cVar.a(this, intent, new 5(this));
    }

    private boolean di(String str, String str2) {
        double d;
        boolean is2G = an.is2G(this);
        int i = is2G ? 10485760 : 26214400;
        if (is2G) {
            d = 60000.0d;
        } else {
            d = 300000.0d;
        }
        x.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", new Object[]{Integer.valueOf(SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, Constants.MAX_BUFFER_SIZE))});
        switch (SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, Constants.MAX_BUFFER_SIZE)) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                return false;
            case 0:
                String nu;
                Bitmap createVideoThumbnail;
                o.TU();
                String nt = s.nt(str);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str2);
                x.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", new Object[]{nt});
                int i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i3 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i4 = 0;
                i = i3;
                int i5 = i2;
                while (i4 < 3) {
                    if (i5 % 2 != 0 || i % 2 != 0) {
                        return false;
                    }
                    if ((i5 < i || (i5 > 640 && i > 480)) && (i5 > i || (i5 > 480 && i > 640))) {
                        i /= 2;
                        i4++;
                        i5 /= 2;
                    }
                    mediaMetadataRetriever.release();
                    if (SightVideoJNI.remuxing(str2, nt, i5, i, com.tencent.mm.plugin.sight.base.b.qsX, com.tencent.mm.plugin.sight.base.b.qsW, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qsY, null, 0, false) >= 0) {
                        x.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                        return false;
                    }
                    El(nt);
                    o.TU();
                    nu = s.nu(str);
                    if (!FileOp.bO(nu)) {
                        x.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[]{nu});
                        try {
                            createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(nt, 1);
                            if (createVideoThumbnail != null) {
                                com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, 60, CompressFormat.JPEG, nu, true);
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MassSendMsgUI", e, "", new Object[0]);
                            x.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", new Object[]{e.getMessage()});
                        }
                    }
                    x.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[]{nt, Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i2)});
                    return true;
                }
                i = i3;
                i5 = i2;
                mediaMetadataRetriever.release();
                if (SightVideoJNI.remuxing(str2, nt, i5, i, com.tencent.mm.plugin.sight.base.b.qsX, com.tencent.mm.plugin.sight.base.b.qsW, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qsY, null, 0, false) >= 0) {
                    El(nt);
                    o.TU();
                    nu = s.nu(str);
                    if (FileOp.bO(nu)) {
                        x.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[]{nu});
                        createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(nt, 1);
                        if (createVideoThumbnail != null) {
                            com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, 60, CompressFormat.JPEG, nu, true);
                        }
                    }
                    x.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[]{nt, Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i2)});
                    return true;
                }
                x.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                return false;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                o.TU();
                El(s.nt(str));
                return true;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.onP != null) {
            b bVar = this.onP;
            if (bVar.tipDialog != null) {
                bVar.tipDialog.dismiss();
                bVar.tipDialog = null;
            }
        }
        if (i == 0 && i2 == 0) {
            onN = "";
            Intent intent = new Intent(this, MassSendHistoryUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
        } else if (i == 4 && i2 == -24) {
            x.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
            Toast.makeText(this, R.l.euI, 0).show();
        } else {
            if (i == 2 || i == 1 || i == 3) {
                this.one.p(onN, -1, true);
            }
            com.tencent.mm.plugin.masssend.a.ift.a(this.mController.xIM, i, i2, str);
            switch (i2) {
                case -71:
                    int i3 = ((aqn) ((com.tencent.mm.plugin.masssend.a.f) kVar).gJQ.hmh.hmo).wxz;
                    h.a(this, getString(R.l.euP, new Object[]{Integer.valueOf(i3)}), getString(R.l.dGO), new 7(this));
                    return;
                case -34:
                    Toast.makeText(this, R.l.euH, 0).show();
                    return;
                default:
                    Toast.makeText(this, R.l.eKc, 0).show();
                    return;
            }
        }
    }

    private static void El(String str) {
        long bN = (long) com.tencent.mm.a.e.bN(str);
        int e = bh.e((Integer) g.a((int) (bN / 1024), new int[]{WXMediaMessage.TITLE_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, com.tencent.mm.plugin.appbrand.jsapi.an.CTRL_INDEX, 255));
        g.pQN.a(106, (long) e, 1, false);
        g.pQN.a(106, 246, 1, false);
        x.d("MicroMsg.MassSendMsgUI", "report video size res : " + e + " hadCompress : true fileLen : " + (bN / 1024) + "K");
    }
}
