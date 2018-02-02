package com.tencent.mm.plugin.card.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;

@a(3)
public class CardGiftImageUI extends MMActivity implements com.tencent.mm.plugin.card.b.a.a {
    private String fzs;
    private l juS;
    private CardGiftInfo kRT;
    private ImageView kRU;
    private RelativeLayout kRV;
    private MMGestureGallery kRW;
    private ProgressBar kRX;
    private af kRY = new af(Looper.getMainLooper());
    private Bundle kRZ;
    private boolean kSa = false;
    private g kSb;
    private int kSc = 0;
    private int kSd = 0;
    private int kSe = 0;
    private int kSf = 0;
    private a kSg;

    static /* synthetic */ void g(CardGiftImageUI cardGiftImageUI) {
        cardGiftImageUI.juS = new l(cardGiftImageUI);
        cardGiftImageUI.juS.rKC = new 3(cardGiftImageUI);
        cardGiftImageUI.juS.rKD = new d(cardGiftImageUI) {
            final /* synthetic */ CardGiftImageUI kSh;

            {
                this.kSh = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        k.h(this.kSh.fzs, this.kSh);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.kRZ = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.kRT = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        String str = "MicroMsg.CardGiftImageUI";
        String str2 = "cardGiftInfo:%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.kRT == null ? "null" : this.kRT.toString();
        x.d(str, str2, objArr);
        x.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[]{this.fzs});
        initView();
        com.tencent.mm.plugin.card.b.a.a(this);
        if (this.kRT == null || bh.ov(this.kRT.kKh)) {
            x.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
        } else {
            com.tencent.mm.plugin.card.b.a.g(this.kRT.kKh, this.kRT.kKk, this.kRT.kKt, 2);
        }
    }

    protected final void initView() {
        this.kRU = (ImageView) findViewById(R.h.ckv);
        this.kRU.setLayerType(2, null);
        this.kRX = (ProgressBar) findViewById(R.h.cpp);
        this.kRV = (RelativeLayout) findViewById(R.h.cpx);
        this.kRW = (MMGestureGallery) findViewById(R.h.ckt);
        this.kRW.setVerticalFadingEdgeEnabled(false);
        this.kRW.setHorizontalFadingEdgeEnabled(false);
        this.kSg = new a(this, (byte) 0);
        this.kRW.setAdapter(this.kSg);
        this.kRW.zlf = new 1(this);
        this.kRW.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CardGiftImageUI kSh;

            {
                this.kSh = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                h.a(this.kSh, this.kSh.juS.bBX());
                return true;
            }
        });
        this.kSb = new g(this);
    }

    public void onStart() {
        Bundle bundle = this.kRZ;
        if (!this.kSa) {
            this.kSa = true;
            if (VERSION.SDK_INT < 12) {
                x.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            } else {
                this.kSc = getIntent().getIntExtra("img_top", 0);
                this.kSd = getIntent().getIntExtra("img_left", 0);
                this.kSe = getIntent().getIntExtra("img_width", 0);
                this.kSf = getIntent().getIntExtra("img_height", 0);
                this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
                if (bundle == null) {
                    this.kRV.getViewTreeObserver().addOnPreDrawListener(new 5(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (this.kSg != null) {
            this.kSg.notifyDataSetChanged();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.card.b.a.b(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
        avV();
        return true;
    }

    public final void avV() {
        this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
        this.kSb.a(this.kRV, this.kRU, new 6(this), null);
    }

    protected final int getLayoutId() {
        return R.i.dcc;
    }

    public final void aW(String str, int i) {
        this.kRY.post(new 7(this));
    }

    public final void fail(String str) {
    }

    public final void bU(String str, String str2) {
        this.kRY.post(new 8(this, str2));
    }
}
