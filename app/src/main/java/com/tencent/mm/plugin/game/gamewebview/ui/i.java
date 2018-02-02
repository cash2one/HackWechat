package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.game.gamewebview.ipc.AddShortcutTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameKeepPageTopTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.model.FavUrlTask;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.g;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

public class i {
    public static b nah = new 9();
    private boolean mEnable = false;
    protected GameWebViewUI mYx;
    protected b mZP;
    private a nad;
    public HashSet<Integer> nae = new HashSet();
    public Map<String, Integer> naf = new HashMap();
    public HashSet<Integer> nag = new HashSet();

    static /* synthetic */ void a(i iVar) {
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 2);
        intent.putExtra("key_fav_item_id", iVar.getBundle().getLong("fav_local_id", -1));
        d.b(iVar.mYx, "favorite", ".ui.FavTagEditUI", intent);
    }

    static /* synthetic */ boolean a(i iVar, int i) {
        return !iVar.nae.contains(Integer.valueOf(i));
    }

    static /* synthetic */ boolean aPN() {
        GWMainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 3;
        GameWebViewMainProcessService.b(favUrlTask);
        return favUrlTask.mXI;
    }

    static /* synthetic */ boolean h(MenuItem menuItem) {
        return menuItem.getItemId() >= 10000;
    }

    public i(b bVar) {
        this.mZP = bVar;
        this.mYx = (GameWebViewUI) bVar.getContext();
        this.naf.clear();
        this.naf.put("menuItem:share:brand", Integer.valueOf(0));
        this.naf.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.naf.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.naf.put("menuItem:share:timeline", Integer.valueOf(2));
        this.naf.put("menuItem:favorite", Integer.valueOf(3));
        this.naf.put("menuItem:profile", Integer.valueOf(5));
        this.naf.put("menuItem:addContact", Integer.valueOf(5));
        this.naf.put("menuItem:copyUrl", Integer.valueOf(6));
        this.naf.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.naf.put("menuItem:share:email", Integer.valueOf(8));
        this.naf.put("menuItem:delete", Integer.valueOf(9));
        this.naf.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.naf.put("menuItem:setFont", Integer.valueOf(11));
        this.naf.put("menuItem:editTag", Integer.valueOf(12));
        this.naf.put("menuItem:readMode", Integer.valueOf(14));
        this.naf.put("menuItem:originPage", Integer.valueOf(14));
        this.naf.put("menuItem:share:qq", Integer.valueOf(20));
        this.naf.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.naf.put("menuItem:share:QZone", Integer.valueOf(22));
        this.naf.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.naf.put("menuItem:refresh", Integer.valueOf(28));
        this.naf.put("menuItem:share:wework", Integer.valueOf(25));
        this.naf.put("menuItem:share:weread", Integer.valueOf(26));
        this.naf.put("menuItem:keepTop", Integer.valueOf(30));
        this.naf.put("menuItem:cancelKeepTop", Integer.valueOf(32));
        this.naf.put("menuItem:addShortcut", Integer.valueOf(29));
        this.naf.put("menuItem:search", Integer.valueOf(31));
        this.nag.clear();
        this.nag.add(Integer.valueOf(28));
        this.nag.add(Integer.valueOf(6));
        this.nag.add(Integer.valueOf(27));
        this.nag.add(Integer.valueOf(30));
        this.nag.add(Integer.valueOf(32));
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.nad == null || !a.b(this.mYx, i, i2, intent)) {
            return false;
        }
        return true;
    }

    public void aPz() {
        g gVar;
        Boolean valueOf = Boolean.valueOf(false);
        if (valueOf.booleanValue()) {
            gVar = new g(this.mYx, g.ztp, false);
        } else {
            gVar = new g(this.mYx, g.zto, true);
        }
        gVar.zlt = new 1(this);
        gVar.zlu = new 2(this);
        gVar.rKD = new 3(this);
        gVar.rKC = new 4(this, valueOf, null);
        String aPk = this.mZP.mWG.aPk();
        if (!bh.ov(aPk)) {
            if (!bh.ov(Uri.parse(aPk).getHost())) {
                gVar.e(this.mYx.getString(R.l.eWX, new Object[]{aPk}), 1);
            }
        }
        if (this.mZP.isFullScreen()) {
            gVar.tGk = true;
            gVar.tGl = true;
        } else {
            gVar.tGk = false;
            gVar.tGl = false;
        }
        if (this.mZP.mWG.mYP.isShown()) {
            this.mZP.mWG.fy(false);
            ag.h(new 5(this, gVar), 100);
            return;
        }
        this.mYx.aWs();
        ag.h(new 6(this, gVar), 100);
    }

    protected final void aPC() {
        if (!this.mZP.mWG.aPo()) {
            this.mZP.aOZ();
        }
    }

    protected final void aPD() {
        h.c(this.mZP.mWG);
    }

    protected final void aPE() {
        d dVar = this.mZP.mWG;
        if (dVar.bq("shareTimeline", 88)) {
            dVar.BR("shareTimeline");
            dVar.cH("menu:share:timeline", "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String RI = dVar.RI();
            jSONObject.put("link", RI);
            jSONObject.put("desc", RI);
            jSONObject.put("title", dVar.getTitle());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
        }
        dVar.cI("shareTimeline", jSONObject.toString());
    }

    protected final void aPF() {
        CharSequence RI = this.mZP.mWG.RI();
        ClipboardManager clipboardManager = (ClipboardManager) this.mYx.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(RI);
                Toast.makeText(this.mYx, this.mYx.getString(R.l.eXW), 0).show();
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OptionMenuBtnHelp", e, "clip.setText error", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.OptionMenuBtnHelp", "clipboard manager is null");
    }

    protected final void aPG() {
        x.i("MicroMsg.OptionMenuBtnHelp", "doKeepPageTopLogic");
        String string = getBundle().getString("custom_keep_top_url");
        String string2 = getBundle().getString("custom_keep_top_title");
        String string3 = getBundle().getString("shortcut_user_name");
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 2;
        if (bh.ov(string2) || bh.ov(string)) {
            gameKeepPageTopTask.url = bh.ou(this.mZP.mWG.mXZ);
            gameKeepPageTopTask.title = this.mZP.mWG.getTitle();
            gameKeepPageTopTask.username = "";
        } else {
            gameKeepPageTopTask.url = string;
            gameKeepPageTopTask.title = string2;
            gameKeepPageTopTask.username = string3;
        }
        GameWebViewMainProcessService.a(gameKeepPageTopTask);
        SwipeBackLayout swipeBackLayout = this.mZP;
        swipeBackLayout.mYt = true;
        swipeBackLayout.mEnable = swipeBackLayout.aOW();
        swipeBackLayout.mYs.b(swipeBackLayout);
        com.tencent.mm.ui.snackbar.a.h(this.mYx, this.mYx.getString(R.l.eBS));
    }

    protected final void aPH() {
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 2;
        gameKeepPageTopTask.url = "";
        gameKeepPageTopTask.title = "";
        gameKeepPageTopTask.username = "";
        GameWebViewMainProcessService.a(gameKeepPageTopTask);
        SwipeBackLayout swipeBackLayout = this.mZP;
        swipeBackLayout.mYt = false;
        swipeBackLayout.mEnable = swipeBackLayout.aOW();
        swipeBackLayout.mYs.aPa();
        com.tencent.mm.ui.snackbar.a.h(this.mYx, this.mYx.getString(R.l.eBN));
    }

    protected final boolean Vb() {
        if (this.mZP.aOY() || this.mZP.mYt) {
            return true;
        }
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 1;
        GameWebViewMainProcessService.b(gameKeepPageTopTask);
        if (bh.ou(this.mZP.mWG.mXZ).equals(bh.ou(gameKeepPageTopTask.url))) {
            return true;
        }
        return false;
    }

    protected final void aPI() {
        String RI = this.mZP.mWG.RI();
        if (this.nad == null) {
            this.nad = new a();
        }
        a.d(this.mYx, RI);
    }

    protected final void aPJ() {
        String string = getBundle().getString("shortcut_user_name");
        String aPl = this.mZP.mWG.aPl();
        if (bh.ov(string) || bh.ov(aPl)) {
            x.e("MicroMsg.OptionMenuBtnHelp", "addShortcut,appid or username is null");
            return;
        }
        GWMainProcessTask addShortcutTask = new AddShortcutTask();
        addShortcutTask.username = string;
        addShortcutTask.appId = aPl;
        addShortcutTask.jcI = new 7(this, addShortcutTask);
        addShortcutTask.afi();
        GameWebViewMainProcessService.a(addShortcutTask);
    }

    protected final void refresh() {
        if (this.mZP.mWG.mYN != null) {
            this.mZP.mWG.mYN.reload();
        }
    }

    protected final void aPK() {
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", getBundle().getLong("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", getBundle().getString("sns_local_id"));
        bundle.putInt("news_svr_id", getBundle().getInt("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", getBundle().getString("news_svr_tweetid"));
        bundle.putInt("message_index", getBundle().getInt("message_index", 0));
        String ou = bh.ou(this.mZP.mWG.mXZ);
        bundle.putString("rawUrl", ou);
        String aPk = this.mZP.mWG.aPk();
        if (!bh.ov(ou) && ou.endsWith("#rd")) {
            ou = ou.substring(0, ou.length() - 3);
            if (!(bh.ov(aPk) || aPk.startsWith(ou))) {
                bundle.putString("rawUrl", aPk);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bh.ov(aPk) || aPk.startsWith(ou))) {
            bundle.putString("rawUrl", aPk);
            bundle.putLong("msg_id", Long.MIN_VALUE);
            bundle.putString("sns_local_id", "");
        }
        if (getBundle() != null) {
            bundle.putString("preChatName", getBundle().getString("preChatName"));
            bundle.putInt("preMsgIndex", getBundle().getInt("preMsgIndex", 0));
            bundle.putString("prePublishId", getBundle().getString("prePublishId"));
            bundle.putString("preUsername", getBundle().getString("preUsername"));
        }
        GWMainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 1;
        favUrlTask.msB = bundle;
        GameWebViewMainProcessService.b(favUrlTask);
        if (favUrlTask.mXH) {
            d dVar = this.mZP.mWG;
            GameJsApiSendAppMessage.fMx = 1;
            h.c(dVar);
            x.i("MicroMsg.OptionMenuBtnHelp", "on favorite simple url");
            return;
        }
        c.a(favUrlTask.ret, 35, this.mYx, nah);
    }

    protected final void aPL() {
        com.tencent.mm.ui.base.h.a(this.mYx, this.mYx.getString(R.l.dEx), null, null, this.mYx.getString(R.l.dEw), new 8(this));
    }

    protected final void aPM() {
        String str = null;
        String string = getBundle().getString("geta8key_username");
        String aPk = this.mZP.mWG.aPk();
        Intent intent = new Intent(this.mYx, GameWebViewUI.class);
        intent.putExtra("k_username", string);
        intent.putExtra("k_expose_url", aPk);
        intent.putExtra("showShare", false);
        if (bh.ov(aPk)) {
            string = null;
        } else {
            string = Uri.parse(aPk).getHost();
        }
        if (bh.ov(string) || !string.startsWith("mp.weixin.qq.com")) {
            intent.putExtra("k_expose_current_url", aPk);
        } else {
            try {
                string = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", new Object[]{p.encode(aPk, ProtocolPackage.ServerEncoding)});
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.OptionMenuBtnHelp", e.getMessage());
                string = null;
            }
            if (string != null) {
                str = string;
            }
        }
        if (bh.ov(str)) {
            str = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)});
        }
        intent.putExtra("rawUrl", str);
        this.mYx.startActivity(intent);
    }

    protected final Bundle getBundle() {
        return this.mZP != null ? this.mZP.vf : new Bundle();
    }
}
