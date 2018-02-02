package com.tencent.mm.plugin.chatroom.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.chatroom.d.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.smtt.utils.TbsLog;

public class RoomCardUI extends MMActivity implements e {
    private r jmO;
    private c lae = new 2(this);
    private long lbA;
    private TextView lbB;
    private MMEditText lbC;
    private TextView lbD;
    private TextView lbE;
    private ImageView lbF;
    private LinearLayout lbG;
    private LinearLayout lbH;
    private LinearLayout lbI;
    private LinearLayout lbJ;
    private boolean lbK = false;
    private String lbf;
    private b lbk;
    private String lbu;
    private int lbv;
    private String lbw;
    private boolean lbx;
    private String lby;
    private String lbz;

    static /* synthetic */ void a(RoomCardUI roomCardUI) {
        if (roomCardUI.axN()) {
            String str = roomCardUI.lbC.getText().toString();
            String zI = com.tencent.mm.k.b.zI();
            if (bh.ov(zI) || !str.matches(".*[" + zI + "].*")) {
                int i;
                int i2;
                roomCardUI.showVKB();
                if (bh.ov(roomCardUI.lbC.getText().toString())) {
                    i = R.l.eQn;
                    i2 = R.l.eQm;
                } else {
                    i = R.l.eyr;
                    i2 = R.l.eyt;
                }
                h.a((Context) roomCardUI, i, 0, i2, R.l.eys, new 9(roomCardUI), new OnClickListener(roomCardUI) {
                    final /* synthetic */ RoomCardUI lbL;

                    {
                        this.lbL = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.lbL.axO();
                    }
                });
                return;
            }
            h.b(roomCardUI.mController.xIM, roomCardUI.getString(R.l.epE, new Object[]{zI}), roomCardUI.getString(R.l.dGO), true);
            return;
        }
        roomCardUI.axP();
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, final TextView textView) {
        l lVar = new l(roomCardUI);
        lVar.rKC = new 4(roomCardUI);
        lVar.rKD = new d(roomCardUI) {
            final /* synthetic */ RoomCardUI lbL;

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (i == 0) {
                    ((ClipboardManager) textView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, textView.getText().toString()));
                }
            }
        };
        lVar.bBX();
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, String str) {
        if (roomCardUI.axN()) {
            ar.CG().a(new m(roomCardUI.lbf, str), 0);
        }
    }

    protected final int getLayoutId() {
        return R.i.dqP;
    }

    protected final void initView() {
        setMMTitle(R.l.eFO);
        a(0, getString(R.l.dEF), new 1(this), p.b.xJz);
        enableOptionMenu(true);
        this.lbI = (LinearLayout) findViewById(R.h.cot);
        this.lbJ = (LinearLayout) findViewById(R.h.cIm);
        this.lbC = (MMEditText) findViewById(R.h.cBk);
        this.lbD = (TextView) findViewById(R.h.cBn);
        this.lbE = (TextView) findViewById(R.h.cBm);
        this.lbG = (LinearLayout) findViewById(R.h.cIp);
        this.lbF = (ImageView) findViewById(R.h.cBl);
        this.lbH = (LinearLayout) findViewById(R.h.cIr);
        this.lbC.setText(this.lby);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.lbC.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) - 100);
        i.b(this.lbC, Integer.valueOf(31));
        this.lbB = (TextView) findViewById(R.h.csN);
        this.lbB.setText(Integer.toString(com.tencent.mm.ui.tools.h.aY(280, this.lby)));
        this.lbH.setVisibility(8);
        this.lbC.setCursorVisible(false);
        this.lbC.setFocusable(false);
        if (this.lbx) {
            this.lbJ.setVisibility(8);
        } else {
            removeOptionMenu(0);
            this.lbJ.setVisibility(0);
            this.lbC.setFocusable(false);
            this.lbC.setCursorVisible(false);
            this.lbC.setOnLongClickListener(new 3(this));
        }
        if (this.lbA != 0) {
            this.lbD.setVisibility(0);
            this.lbD.setText(n.ag("yyyy-MM-dd HH:mm", this.lbA));
        } else {
            this.lbD.setVisibility(8);
        }
        if (bh.ov(this.lby)) {
            this.lbC.setEnabled(true);
            this.lbC.setFocusableInTouchMode(true);
            this.lbC.setFocusable(true);
            this.lbI.setVisibility(8);
            this.lbC.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) + 100);
            this.lbC.requestFocus();
            this.lbC.setCursorVisible(true);
            updateOptionMenuText(0, this.mController.xIM.getString(R.l.dFl));
            axO();
            this.lbC.performClick();
            showVKB();
        } else {
            this.lbI.setVisibility(0);
        }
        this.lbE.setText(i.b(this, com.tencent.mm.z.r.gu(this.lbz), this.lbE.getTextSize()));
        ImageView imageView = this.lbF;
        String str = this.lbz;
        if (bh.ov(str)) {
            imageView.setImageResource(R.g.bBB);
        } else {
            a.b.a(imageView, str);
        }
        this.lbC.addTextChangedListener(new a(this, (byte) 0));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.pQN.a(219, 0, 1, true);
        ar.CG().a(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, this);
        this.lbf = getIntent().getStringExtra("RoomInfo_Id");
        this.lby = getIntent().getStringExtra("room_notice");
        this.lbz = getIntent().getStringExtra("room_notice_editor");
        this.lbA = getIntent().getLongExtra("room_notice_publish_time", 0);
        this.lbu = getIntent().getStringExtra("room_name");
        this.lbv = getIntent().getIntExtra("room_member_count", 0);
        this.lbw = getIntent().getStringExtra("room_owner_name");
        this.lbx = getIntent().getBooleanExtra("Is_RoomOwner", false);
        initView();
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomCardUI lbL;

            {
                this.lbL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lbL.goBack();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, this);
        if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
        }
    }

    private void goBack() {
        if (!this.lbx) {
            setResult(0);
            finish();
        } else if (axN()) {
            h.a((Context) this, getString(R.l.eEN), null, getString(R.l.eEP), getString(R.l.eEO), new 7(this), new 8(this));
        } else {
            setResult(0);
            finish();
        }
    }

    private boolean axN() {
        String obj = this.lbC.getText().toString();
        if (bh.ov(obj)) {
            if (bh.ov(this.lby)) {
                return false;
            }
            return true;
        } else if (this.lby == null || !this.lby.equals(obj)) {
            return true;
        } else {
            return false;
        }
    }

    private void axO() {
        if (axN()) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        super.onKeyDown(i, keyEvent);
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1) {
            this.lbx = false;
            if (!this.lbx) {
                this.lbH.setVisibility(8);
                this.lbC.setFocusableInTouchMode(false);
                this.lbC.setFocusable(false);
                this.lbH.setVisibility(8);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
        }
        if (kVar.getType() == TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE) {
            if (this.jmO != null && this.jmO.isShowing()) {
                this.jmO.dismiss();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
                this.lby = this.lbC.getText().toString();
                g.pQN.a(219, 15, 1, true);
                axP();
                return;
            }
            x.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[]{str});
            u.makeText(this, R.l.eFX, 1).show();
            x.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        x.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[]{Integer.valueOf(kVar.getType())});
    }

    private void axP() {
        Intent intent = new Intent();
        intent.putExtra("room_name", this.lbu);
        intent.putExtra("room_notice", this.lby);
        setResult(-1, intent);
        finish();
    }
}
