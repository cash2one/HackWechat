package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.support.v4.view.ViewPager.e;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;

public class EmojiStoreV2UI extends MMActivity {
    private int lHX = 0;
    private HashMap<Integer, a> lIg = new HashMap();
    EmojiStoreV2TabView lIh;
    private EmojiStoreV2ViewPager lIi;
    private a lIj;
    private boolean lIk = true;
    private boolean lIl = false;

    class a extends p implements e, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.a {
        private boolean lIk = false;
        final /* synthetic */ EmojiStoreV2UI lIm;
        private WxViewPager lIn;

        public final /* synthetic */ Fragment R(int i) {
            return oY(i);
        }

        public a(EmojiStoreV2UI emojiStoreV2UI, FragmentActivity fragmentActivity, WxViewPager wxViewPager, boolean z) {
            this.lIm = emojiStoreV2UI;
            super(fragmentActivity.getSupportFragmentManager());
            this.lIk = z;
            this.lIn = wxViewPager;
            this.lIn.a(this);
            this.lIn.b(this);
            this.lIn.ah(emojiStoreV2UI.lHX);
            d.fN(11);
            if (emojiStoreV2UI.lIh != null) {
                emojiStoreV2UI.lIh.lId = this;
            }
        }

        public final a oY(int i) {
            return this.lIm.oX(i);
        }

        public final int getCount() {
            if (this.lIk) {
                return 2;
            }
            return 1;
        }

        public final void a(int i, float f, int i2) {
            if (this.lIm.lIh != null) {
                this.lIm.lIh.h(i, f);
            }
        }

        public final void ae(int i) {
            x.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", new Object[]{Integer.valueOf(i)});
            this.lIm.lHX = i;
            if (this.lIm.lIh != null) {
                this.lIm.lIh.oV(i);
            }
            if (this.lIm.lHX == 1 && !this.lIm.lIl) {
                g.pQN.h(12090, new Object[0]);
                EmojiStoreV2UI emojiStoreV2UI = this.lIm;
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xnn, Boolean.valueOf(false));
                if (emojiStoreV2UI.lIh != null) {
                    emojiStoreV2UI.lIh.eF(false);
                }
                this.lIm.lIl = true;
            }
        }

        public final void af(int i) {
            x.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[]{Integer.valueOf(i)});
            if (i == 0 && this.lIm.oX(this.lIm.lHX) != null) {
                a oX = this.lIm.oX(this.lIm.lHX);
                if (oX.Fv != null && oX.lxL != null && oX.aDq()) {
                    oX.lxL.amg();
                }
            }
        }

        public final void oW(int i) {
            if (i != this.lIm.lHX) {
                this.lIn.d(i, false);
            }
            this.lIm.lHX = i;
        }
    }

    static /* synthetic */ void a(EmojiStoreV2UI emojiStoreV2UI) {
        Intent QM = b.QM();
        b.p(QM);
        QM.putExtra("ftsneedkeyboard", true);
        QM.putExtra("key_load_js_without_delay", true);
        com.tencent.mm.bm.d.b(emojiStoreV2UI.mController.xIM, "webview", ".ui.tools.fts.FTSSOSMoreWebViewUI", QM);
        int i = emojiStoreV2UI.lHX == 0 ? 0 : 1;
        g.pQN.h(13054, new Object[]{Integer.valueOf(i), Integer.valueOf(0), ""});
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        String value = com.tencent.mm.k.g.zY().getValue("ShowPersonalEmotion");
        x.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[]{value});
        if (bh.ov(value) || bh.VI(value) != 1) {
            this.lIk = false;
        } else {
            this.lIk = true;
        }
        if (this.lIk) {
            this.lHX = getIntent().getIntExtra("emoji_tab", 0);
        }
        initView();
        ar.Dm().F(new 3(this));
        ar.Hg();
        boolean booleanValue = ((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xnn, Boolean.valueOf(false))).booleanValue();
        if (this.lIh != null) {
            this.lIh.eF(booleanValue);
        }
        g.pQN.a(406, 0, 1, false);
        g.pQN.a(406, 2, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        Looper.myQueue().addIdleHandler(new IdleHandler(this) {
            final /* synthetic */ EmojiStoreV2UI lIm;

            {
                this.lIm = r1;
            }

            public final boolean queueIdle() {
                x.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                this.lIm.sendBroadcast(intent);
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dgg;
    }

    protected final void initView() {
        addIconOptionMenu(0, R.k.dvb, new 1(this));
        addIconOptionMenu(1, R.k.dvc, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2UI lIm;

            {
                this.lIm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("10931", 1);
                intent.setClass(this.lIm, EmojiMineUI.class);
                this.lIm.startActivity(intent);
                return false;
            }
        });
        this.lIh = (EmojiStoreV2TabView) findViewById(R.h.cdW);
        this.lIi = (EmojiStoreV2ViewPager) findViewById(R.h.cdV);
        this.lIi.xe(0);
        this.lIj = new a(this, this, this.lIi, this.lIk);
        if (this.lIk) {
            this.lIh.setVisibility(0);
        } else {
            this.lIh.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lIg != null) {
            this.lIg.clear();
        }
    }

    public final a oX(int i) {
        a aVar = null;
        if (i < 0) {
            return null;
        }
        if (this.lIg.containsKey(Integer.valueOf(i))) {
            return (a) this.lIg.get(Integer.valueOf(i));
        }
        switch (i) {
            case 0:
                aVar = (a) Fragment.instantiate(this, b.class.getName(), null);
                break;
            case 1:
                aVar = (a) Fragment.instantiate(this, c.class.getName(), null);
                break;
            default:
                x.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
                break;
        }
        x.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", new Object[]{Integer.valueOf(i)});
        if (aVar != null) {
            aVar.setParent(this);
        }
        this.lIg.put(Integer.valueOf(i), aVar);
        return aVar;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (this.lIj != null && this.lIj.oY(this.lHX) != null) {
            this.lIj.oY(this.lHX).onActivityResult(i, i2, intent);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
