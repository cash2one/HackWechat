package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@a(19)
public class AlbumPreviewUI extends MMActivity implements b {
    static long start = 0;
    private String fzO;
    private int hEF;
    private ProgressDialog iln;
    private ServiceConnection lrm = new ServiceConnection(this) {
        final /* synthetic */ AlbumPreviewUI mSQ;

        {
            this.mSQ = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.d("MicroMsg.AlbumPreviewUI", "onServiceConnected");
            this.mSQ.mRJ = com.tencent.mm.plugin.gallery.stub.a.a.Q(iBinder);
            if (this.mSQ.mSm != null) {
                this.mSQ.mSm.mRJ = this.mSQ.mRJ;
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.d("MicroMsg.AlbumPreviewUI", "onServiceDisconnected");
            this.mSQ.mRJ = null;
        }
    };
    private com.tencent.mm.plugin.gallery.stub.a mRJ = null;
    private boolean mSA = false;
    private boolean mSB = false;
    private boolean mSC = false;
    private boolean mSD = false;
    private int mSE;
    private int mSF;
    boolean mSG = false;
    private int mSH = 0;
    private int mSI = 0;
    private long mSJ = 0;
    private long mSK;
    private int mSL = -1;
    private long mSM = -1;
    private a.a mSN = new 7(this);
    private boolean mSO = false;
    private HashMap<String, Integer> mSP = new HashMap();
    private GridView mSh;
    private TextView mSi;
    private boolean mSj;
    private boolean mSk;
    private TextView mSl;
    private a mSm;
    private TextView mSn;
    private TextView mSp;
    private ImageFolderMgrView mSq;
    private TextView mSr;
    private ImageButton mSs;
    private String mSt;
    private String mSu;
    private int mSv;
    private String mSw;
    private boolean mSx = false;
    private boolean mSy = false;
    private boolean mSz = false;
    private String toUser;

    static /* synthetic */ void A(ArrayList arrayList) {
        if (arrayList == null) {
            x.e("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] mMediaItems is null!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] size:%s", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            Iterator it2 = c.aNH().iterator();
            while (it2.hasNext()) {
                MediaItem mediaItem2 = (MediaItem) it2.next();
                if (mediaItem2.mRd.equals(mediaItem.hOo)) {
                    x.d("MicroMsg.AlbumPreviewUI", "item:%s replace editItem:%s", new Object[]{mediaItem, mediaItem2});
                    arrayList.set(i, mediaItem2);
                }
                if (mediaItem2.hOo.equals(mediaItem.hOo)) {
                    x.d("MicroMsg.AlbumPreviewUI", "remove editItem:%s", new Object[]{mediaItem2});
                    arrayList2.add(Integer.valueOf(i));
                }
            }
            i++;
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList.remove(((Integer) it3.next()).intValue());
        }
        x.d("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] cost%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    static /* synthetic */ int D(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mSH + 1;
        albumPreviewUI.mSH = i;
        return i;
    }

    static /* synthetic */ void a(AlbumPreviewUI albumPreviewUI, MediaItem mediaItem) {
        if (c.aNE().aOh() == 3 && albumPreviewUI.mSB && 26214400 < e.bN(mediaItem.hOo)) {
            x.w("MicroMsg.AlbumPreviewUI", "[checkRawImageItem] item:%s file size:%s", new Object[]{mediaItem, Integer.valueOf(e.bN(mediaItem.hOo))});
            h.bt(albumPreviewUI, albumPreviewUI.getString(R.l.elz));
        }
    }

    static /* synthetic */ void e(AlbumPreviewUI albumPreviewUI) {
        if (albumPreviewUI.mSB) {
            Iterator it = albumPreviewUI.mSm.mRL.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                MediaItem mediaItem = (MediaItem) it.next();
                if (mediaItem == null || mediaItem.getType() != 1) {
                    i3 = i;
                    i = i2;
                } else {
                    if (26214400 < e.bN(mediaItem.hOo)) {
                        x.w("MicroMsg.AlbumPreviewUI", "[onClick] item:%s file size:%s", new Object[]{mediaItem, Integer.valueOf(e.bN(mediaItem.hOo))});
                        i2++;
                    }
                    i3 = i + 1;
                    i = i2;
                }
                i2 = i;
                i = i3;
            }
            if (i2 <= 0) {
                return;
            }
            if (i == i2) {
                h.bt(albumPreviewUI, albumPreviewUI.getString(R.l.elz));
            } else {
                h.bt(albumPreviewUI, albumPreviewUI.getString(R.l.elw));
            }
        }
    }

    static /* synthetic */ void g(AlbumPreviewUI albumPreviewUI) {
        if (albumPreviewUI.mSm.mRL.size() > 0) {
            albumPreviewUI.enableOptionMenu(true);
        } else {
            albumPreviewUI.enableOptionMenu(false);
        }
    }

    static /* synthetic */ void s(AlbumPreviewUI albumPreviewUI) {
        h.h(albumPreviewUI, R.l.eSX, R.l.elH);
        x.w("MicroMsg.AlbumPreviewUI", "video is import error");
    }

    static /* synthetic */ void t(AlbumPreviewUI albumPreviewUI) {
        h.h(albumPreviewUI, R.l.elG, R.l.elH);
        x.w("MicroMsg.AlbumPreviewUI", "video is over size");
    }

    static /* synthetic */ int u(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mSI + 1;
        albumPreviewUI.mSI = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSK = System.currentTimeMillis();
        x.i("MicroMsg.AlbumPreviewUI", "onCreate");
        if (bundle != null) {
            x.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
            this.mSF = bundle.getInt("constants_key");
            c.aNE().qp(this.mSF);
        }
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.dHc), true, new OnCancelListener(this) {
            final /* synthetic */ AlbumPreviewUI mSQ;

            {
                this.mSQ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        int intExtra = getIntent().getIntExtra("query_source_type", 3);
        int intExtra2 = getIntent().getIntExtra("query_media_type", 1);
        x.i("MicroMsg.AlbumPreviewUI", "query souce: " + intExtra + ", queryType: " + intExtra2);
        c.aNE().qo(intExtra2);
        c.aNE().qp(intExtra);
        initView();
        c.aNE().mRv.add(this);
        this.mSM = System.currentTimeMillis();
        l aNE = c.aNE();
        aNE.d(this.mSu, aNE.mRx, this.mSM);
        bindService(new Intent(this.mController.xIM, GalleryStubService.class), this.lrm, 1);
    }

    protected void onPause() {
        super.onPause();
        this.mSD = true;
        c.aNF().aNT().removeCallbacksAndMessages(null);
        c.aNF().aNU();
        x.d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.mSy);
        if (this.mSy) {
            aOp();
        }
        if (this.mSq.Od) {
            ImageFolderMgrView imageFolderMgrView = this.mSq;
            if (!imageFolderMgrView.Od) {
                x.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
            } else if (imageFolderMgrView.mTy) {
                x.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
            } else {
                imageFolderMgrView.mTu.setVisibility(8);
                imageFolderMgrView.Od = false;
            }
        }
        try {
            this.mRJ.qq(this.hEF);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
        }
        this.hEF = 0;
    }

    protected void onResume() {
        super.onResume();
        x.d("MicroMsg.AlbumPreviewUI", "on resume");
        this.mSD = false;
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.AlbumPreviewUI", "onDestroy");
        c.aNE().b(this.mSq);
        c.aNE().mRv.remove(this);
        if (this.mSH > 0 || this.mSI > 0) {
            x.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[]{Integer.valueOf(this.mSH), Integer.valueOf(this.mSI)});
            try {
                this.mRJ.aj(11187, this.mSH + "," + this.mSI);
            } catch (Throwable e) {
                x.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        } else {
            x.w("MicroMsg.AlbumPreviewUI", "do not click camera or folder!");
        }
        try {
            if (this.mSJ > 0 || this.mSk) {
                c.a(this.mRJ, this.mSw, z(this.mSm.mRL), this.mSB, this.mSj);
            }
            c.a(this.mRJ, this.mSm.mRL.size(), this.mSB);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
        }
        sendBroadcast(new Intent("com.tencent.mm.plugin.photoedit.action.clear"));
        c.aNH().clear();
        c.aNI().clear();
        c.aNJ().clear();
        try {
            unbindService(this.lrm);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e22, "Failed to unbindService when Activity.onDestroy is invoked.", new Object[0]);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mSF = c.aNE().aOh();
        bundle.putInt("constants_key", this.mSF);
    }

    protected final int getLayoutId() {
        return R.i.drj;
    }

    private void updateTitle() {
        if (c.aNE().aOi() == 3) {
            setMMTitle(R.l.ekW);
            this.mSl.setText(R.l.ekW);
        } else if (c.aNE().aOi() == 1) {
            setMMTitle(R.l.elF);
            this.mSl.setText(R.l.ekV);
        } else {
            setMMTitle(R.l.ekX);
            this.mSl.setText(R.l.ekX);
        }
    }

    private static int[] z(ArrayList<MediaItem> arrayList) {
        int[] iArr = new int[4];
        iArr[0] = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem != null) {
                if (!bh.ov(mediaItem.mMimeType) && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                    iArr[2] = iArr[2] + 1;
                } else if (mediaItem.getType() == 2) {
                    iArr[3] = iArr[3] + 1;
                } else if (mediaItem.getType() == 1) {
                    iArr[1] = iArr[1] + 1;
                }
            }
        }
        return iArr;
    }

    private void a(AlbumItem albumItem) {
        if (albumItem != null) {
            if (bh.az(this.mSu, "").equals(albumItem.mRb)) {
                x.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
                return;
            }
            c.aNJ().addAll(this.mSm.mRL);
            x.d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[]{albumItem.mRb, albumItem.aNV()});
            this.mSt = albumItem.aNV();
            this.mSu = albumItem.mRb;
            if (albumItem.mRc != null) {
                this.mSv = albumItem.mRc.getType();
            }
            if (bh.ov(this.mSt)) {
                x.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
                this.mSt = this.mSu;
            }
            if (bh.ov(this.mSu)) {
                if (getIntent().getBooleanExtra("show_header_view", true)) {
                    this.mSm.a(this.mSN);
                }
                updateTitle();
                this.mSv = c.aNE().aOi();
            } else {
                a aVar = this.mSm;
                a.a aVar2 = this.mSN;
                if (aVar2 == null) {
                    x.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
                } else {
                    aVar.mRO.remove(aVar2);
                }
                this.mSl.setText(this.mSu);
            }
            this.mSm.mRK.clear();
            qu(this.mSm.mRL.size());
            this.mSm.notifyDataSetChanged();
            if (this.iln != null) {
                this.iln.dismiss();
            }
            getString(R.l.dGO);
            this.iln = h.a(this, getString(R.l.dHc), true, new OnCancelListener(this) {
                final /* synthetic */ AlbumPreviewUI mSQ;

                {
                    this.mSQ = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            start = System.currentTimeMillis();
            String str = this.mSu;
            if (albumItem.mRc != null) {
                int type = albumItem.mRc.getType();
                x.i("MicroMsg.AlbumPreviewUI", "folder type[%d] queryType[%d]", new Object[]{Integer.valueOf(type), Integer.valueOf(c.aNE().aOi())});
                if (c.aNE().aOi() != 2 && albumItem.mRc.getType() == 2) {
                    str = "";
                }
                if (bh.ov(albumItem.mRb)) {
                    type = 3;
                }
                this.mSM = System.currentTimeMillis();
                c.aNE().d(str, type, this.mSM);
            }
        }
    }

    public final void E(int i, boolean z) {
        boolean z2 = true;
        switch (c.aNE().aOi()) {
            case 3:
                if (!bh.ov(this.fzO) && !"medianote".equals(this.toUser)) {
                    if (bh.Wq() - this.mSJ < 1000) {
                        x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                        return;
                    }
                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    MediaItem mediaItem = (MediaItem) this.mSm.mRK.get(i);
                    if (mediaItem.getType() != 2) {
                        try {
                            com.tencent.mm.plugin.gallery.stub.a aVar = this.mRJ;
                            String str = mediaItem.hOo;
                            String str2 = this.toUser;
                            if (!this.mSx && this.mSB) {
                                z2 = false;
                            }
                            aVar.a(str, str2, z2, 0, z);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final void initView() {
        boolean z;
        for (String str : getIntent().getExtras().keySet()) {
            x.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[]{str, getIntent().getExtras().get(str)});
        }
        this.fzO = getIntent().getStringExtra("GalleryUI_FromUser");
        this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
        this.mSE = getIntent().getIntExtra("max_select_count", 9);
        this.mSx = c.aNE().aOh() == 4;
        if (c.aNE().aOh() == 5) {
            z = true;
        } else {
            z = false;
        }
        this.mSz = z;
        if (c.aNE().aOh() == 9) {
            z = true;
        } else {
            z = false;
        }
        this.mSA = z;
        this.mSt = getIntent().getStringExtra("folder_path");
        this.mSu = getIntent().getStringExtra("folder_name");
        if (bh.ov(this.mSt)) {
            x.e("MicroMsg.AlbumPreviewUI", "get folder path failed");
            this.mSt = this.mSu;
        }
        this.mSB = getIntent().getBooleanExtra("key_send_raw_image", false);
        this.mSC = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
        this.mSr = (TextView) findViewById(R.h.cBQ);
        this.mSs = (ImageButton) findViewById(R.h.cBP);
        this.mSr.setOnClickListener(new 12(this));
        if (c.aNE().aOh() == 3) {
            this.mSs.setVisibility(0);
            this.mSr.setVisibility(0);
        } else {
            this.mSs.setVisibility(8);
            this.mSr.setVisibility(8);
        }
        if (this.mSB) {
            this.mSs.setImageResource(R.k.dAr);
        } else {
            this.mSs.setImageResource(R.k.dAq);
        }
        this.mSs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AlbumPreviewUI mSQ;

            {
                this.mSQ = r1;
            }

            public final void onClick(View view) {
                this.mSQ.mSB = !this.mSQ.mSB;
                AlbumPreviewUI.e(this.mSQ);
                this.mSQ.mSr.setText(this.mSQ.mController.xIM.getString(R.l.elh) + "");
                if (this.mSQ.mSB) {
                    this.mSQ.mSs.setImageResource(R.k.dAr);
                } else {
                    this.mSQ.mSs.setImageResource(R.k.dAq);
                }
                AlbumPreviewUI.g(this.mSQ);
            }
        });
        this.mSn = (TextView) findViewById(R.h.bJU);
        this.mSp = (TextView) findViewById(R.h.bJT);
        this.mSi = (TextView) findViewById(R.h.cvE);
        if (c.aNE().aOh() == 0 || c.aNE().aOh() == 5 || c.aNE().aOh() == 10 || c.aNE().aOh() == 11) {
            findViewById(R.h.ciZ).setVisibility(8);
            this.mSi.setVisibility(8);
        } else {
            this.mSi.setVisibility(0);
            this.mSi.setOnClickListener(new 14(this));
            if ((c.aNE().aOi() == 1 || c.aNE().aOi() == 2 || c.aNE().aOi() == 3) && this.mSE > 0) {
                OnMenuItemClickListener 15 = new 15(this);
                if (bh.ov(this.mSw)) {
                    a(0, qv(0), 15, p.b.xJz);
                } else {
                    addTextOptionMenu(0, this.mSw, 15);
                }
            }
        }
        this.mSq = (ImageFolderMgrView) findViewById(R.h.coY);
        g.a aVar = this.mSq;
        c.aNE().b(aVar);
        c.aNE().a(aVar);
        c.aNE().aOj();
        this.mSq.mTt = new 16(this);
        this.mSw = getIntent().getStringExtra("send_btn_string");
        findViewById(R.h.cvx).setOnClickListener(new 17(this));
        this.mSl = (TextView) findViewById(R.h.cvy);
        if (this.mSz) {
            showOptionMenu(false);
        }
        enableOptionMenu(false);
        this.mSh = (GridView) findViewById(R.h.cvz);
        this.mSh.setOnItemClickListener(new 2(this));
        this.mSm = new a(this, new a.b(this) {
            final /* synthetic */ AlbumPreviewUI mSQ;

            {
                this.mSQ = r1;
            }

            public final void K(int i, int i2, int i3) {
                if (i3 == 0) {
                    MediaItem qs = this.mSQ.mSm.qs(this.mSQ.mSm.mRO.size() + i2);
                    if (qs != null && qs.getType() == 1) {
                        AlbumPreviewUI.a(this.mSQ, qs);
                    } else if (qs != null && qs.getType() == 2) {
                        if (this.mSQ.b(qs)) {
                            this.mSQ.qu(i);
                            this.mSQ.E(i2, true);
                            return;
                        }
                        this.mSQ.mSm.mRL.remove(qs);
                        this.mSQ.mSm.notifyDataSetChanged();
                        return;
                    }
                    this.mSQ.qu(i);
                    this.mSQ.E(i2, true);
                    return;
                }
                this.mSQ.qu(i);
                this.mSQ.E(i2, false);
            }
        });
        if (this.mSx) {
            this.mSm.mRP = true;
        }
        if (this.mSC) {
            this.mSm.mRP = true;
        }
        this.mSh.setNumColumns(4);
        this.mSh.setOnScrollListener(new 4(this));
        if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.mSm.a(this.mSN);
        }
        this.mSm.mRN = c.aNE().aOi();
        this.mSm.mRI = this.mSE;
        x.i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
        this.mSh.setAdapter(this.mSm);
        updateTitle();
        setBackBtn(new 5(this));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.h.cIu);
        if (viewGroup instanceof DrawedCallBackFrameLayout) {
            ((DrawedCallBackFrameLayout) viewGroup).xXK = new DrawedCallBackFrameLayout.a(this) {
                final /* synthetic */ AlbumPreviewUI mSQ;

                {
                    this.mSQ = r1;
                }

                public final void aOk() {
                    try {
                        this.mSQ.mRJ.aOk();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                    }
                    if (this.mSQ.mSG) {
                        try {
                            this.mSQ.unbindService(this.mSQ.lrm);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
                        }
                        this.mSQ.mSG = false;
                    }
                }
            };
        }
    }

    private void arQ() {
        if (k.c(this.mController.xIM, com.tencent.mm.compatible.util.e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 4369)) {
            c.aNF().qn(0);
            System.gc();
            return;
        }
        Toast.makeText(this.mController.xIM, getString(R.l.eJu), 1).show();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            x.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
            setResult(-2);
            if (this.mSq.Od) {
                this.mSq.aOs();
                return true;
            }
            finish();
            return true;
        } else if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        } else {
            this.mSI++;
            this.mSq.aOs();
            return true;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ArrayList arrayList;
        if (4369 != i) {
            ArrayList stringArrayListExtra;
            if (4370 != i) {
                if (4371 != i) {
                    if (4372 != i) {
                        if (4373 != i) {
                            if (4375 != i) {
                                if (4376 != i) {
                                    switch (i2) {
                                        case -2:
                                            x.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
                                            finish();
                                            break;
                                        case -1:
                                            if (intent == null) {
                                                intent = new Intent();
                                                intent.putExtra("CropImage_Compress_Img", true);
                                                intent.putStringArrayListExtra("CropImage_OutputPath_List", this.mSm.aOm());
                                            }
                                            x.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
                                            this.mSk = true;
                                            setResult(-1, intent);
                                            aOp();
                                            finish();
                                            break;
                                        case 0:
                                            if (intent != null) {
                                                boolean z;
                                                stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                                                if (stringArrayListExtra != null) {
                                                    this.mSm.y(stringArrayListExtra);
                                                    this.mSm.notifyDataSetChanged();
                                                    qu(stringArrayListExtra.size());
                                                }
                                                if (intent.getBooleanExtra("CropImage_Compress_Img", true)) {
                                                    z = false;
                                                } else {
                                                    z = true;
                                                }
                                                this.mSB = z;
                                                if (!this.mSB) {
                                                    this.mSs.setImageResource(R.k.dAq);
                                                    break;
                                                } else {
                                                    this.mSs.setImageResource(R.k.dAr);
                                                    break;
                                                }
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                } else if (-1 != i2) {
                                    x.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
                                    finish();
                                } else if (intent != null) {
                                    AlbumItem albumItem = (AlbumItem) intent.getParcelableExtra("select_folder_name");
                                    a(albumItem);
                                    setMMTitle(bh.az(albumItem.mRb, getString(R.l.ekW)));
                                }
                            } else if (-1 == i2) {
                                if (intent == null) {
                                    intent = new Intent();
                                }
                                x.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[]{intent});
                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                if (sightCaptureResult == null) {
                                    x.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                                    setResult(1);
                                    finish();
                                    return;
                                }
                                Serializable arrayList2 = new ArrayList();
                                String str = sightCaptureResult.oqB;
                                if (!bh.ov(str)) {
                                    arrayList2.add(str);
                                    intent.putExtra("key_select_video_list", arrayList2);
                                }
                                if (sightCaptureResult.oqz && !bh.ov(sightCaptureResult.oqH)) {
                                    arrayList = new ArrayList();
                                    arrayList.add(sightCaptureResult.oqH);
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                                }
                                setResult(-1, intent);
                                finish();
                            } else {
                                return;
                            }
                        }
                        if (intent != null) {
                            intent.putExtra("GalleryUI_IsSendImgBackground", true);
                            x.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
                        }
                        x.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
                        setResult(-1, intent);
                        this.mSG = true;
                        finish();
                    } else if (-1 == i2) {
                        if (intent == null) {
                            intent = new Intent();
                        }
                        x.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[]{intent});
                        Serializable arrayList3 = new ArrayList();
                        String stringExtra = getIntent().getStringExtra("video_full_path");
                        if (!bh.ov(stringExtra)) {
                            arrayList3.add(stringExtra);
                            intent.putExtra("key_select_video_list", arrayList3);
                            intent.putExtra("key_selected_video_is_from_sys_camera", true);
                        }
                        setResult(-1, intent);
                        finish();
                    } else {
                        return;
                    }
                } else if (-1 == i2) {
                    if (intent != null) {
                        intent.putExtra("from_record", true);
                    }
                    x.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[]{intent});
                    setResult(-1, intent);
                    finish();
                } else {
                    return;
                }
            } else if (-1 != i2) {
                return;
            } else {
                if (intent.getBooleanExtra("GalleryUI_IsSendImgBackground", false)) {
                    x.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
                    setResult(-1, intent);
                    finish();
                    return;
                }
                stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    x.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
                    return;
                }
                x.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[]{stringArrayListExtra});
                setResult(-1, intent);
                finish();
            }
        } else if (-1 == i2) {
            String b = k.b(this.mController.xIM.getApplicationContext(), intent, com.tencent.mm.compatible.util.e.gHu);
            if (bh.ov(b)) {
                x.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
                return;
            }
            x.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[]{b});
            if (c.aNE().aOh() == 0 || c.aNE().aOh() == 5 || c.aNE().aOh() == 11) {
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse("file://" + Uri.encode(b)));
                x.i("MicroMsg.AlbumPreviewUI", "take photo finish");
                setResult(-1, intent2);
                finish();
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(b);
                Intent intent3 = new Intent(this, ImagePreviewUI.class);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("max_select_count", 1);
                intent3.putExtra("send_raw_img", this.mSB);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("GalleryUI_FromUser", this.fzO);
                intent3.putExtra("GalleryUI_ToUser", this.toUser);
                startActivityForResult(intent3, 4370);
            }
        } else {
            return;
        }
        if (intent != null && intent.getBooleanExtra("show_photo_edit_tip", false)) {
            SharedPreferences sharedPreferences = getSharedPreferences("photo_edit_pref", 0);
            if (!sharedPreferences.getBoolean("has_show_tip", false)) {
                this.mSp.setVisibility(0);
                this.mSp.setText(getString(R.l.eAb));
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mController.xIM, R.a.bpZ);
                this.mSp.startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new 8(this));
                sharedPreferences.edit().putBoolean("has_show_tip", true).commit();
            }
        }
    }

    private void qu(int i) {
        if (i == 0) {
            this.mSi.setEnabled(false);
            enableOptionMenu(false);
        } else {
            this.mSi.setEnabled(true);
            enableOptionMenu(true);
        }
        if (i == 0) {
            this.mSi.setText(R.l.eli);
        } else {
            this.mSi.setText(getString(R.l.eli) + "(" + i + ")");
        }
        updateOptionMenuText(0, qv(i));
    }

    private String qv(int i) {
        switch (c.aNE().aOh()) {
            case 4:
            case 7:
            case 8:
            case 13:
                if (i == 0 || this.mSE <= 1) {
                    return getString(R.l.elj);
                }
                return getString(R.l.elj) + "(" + i + "/" + this.mSE + ")";
            default:
                if (i == 0 || this.mSE <= 1) {
                    return getString(R.l.dGA);
                }
                return getString(R.l.eld, new Object[]{Integer.valueOf(i), Integer.valueOf(this.mSE)});
        }
    }

    public final void a(ArrayList<MediaItem> arrayList, long j) {
        if (j != this.mSM) {
            x.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[]{Long.valueOf(j), Long.valueOf(this.mSM)});
            x.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((MediaItem) it.next());
            }
        }
        if (this.mSm != null) {
            Runnable aVar = new a((byte) 0);
            aVar.mSX = new WeakReference(this.mSm);
            aVar.mSY = new WeakReference(this.iln);
            aVar.mSZ = arrayList2;
            c.aNF().y(aVar);
        }
    }

    private void aOp() {
        if (this.mSO) {
            SharedPreferences sharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
            x.i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.mSu + ", " + this.mSt);
            sharedPreferences.edit().putString(c.aNE().aOi(), this.mSu + "|" + this.mSt + "|" + this.mSv).commit();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.AlbumPreviewUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    arQ();
                    return;
                } else {
                    h.a(this, getString(R.l.ezM), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 9(this), null);
                    return;
                }
            default:
                return;
        }
    }

    private boolean b(MediaItem mediaItem) {
        if (mediaItem == null) {
            x.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
            return false;
        } else if (this.mRJ == null) {
            x.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] invoker is null!");
            return false;
        } else if (c.aNE().aOh() != 3) {
            return true;
        } else {
            if (new File(mediaItem.hOo).exists()) {
                try {
                    if (this.mRJ.Bw(mediaItem.hOo) > 300) {
                        h.bt(this, getString(R.l.elB));
                        return false;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                }
                return true;
            }
            h.bt(this, getString(R.l.elA));
            return false;
        }
    }
}
