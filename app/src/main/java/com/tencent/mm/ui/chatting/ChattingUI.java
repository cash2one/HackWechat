package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.permission.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.d;
import com.tencent.mm.ui.chatting.b.h.1;
import com.tencent.mm.ui.chatting.b.h.10;
import com.tencent.mm.ui.chatting.b.h.3;
import com.tencent.mm.ui.chatting.b.h.4;
import com.tencent.mm.ui.chatting.b.h.5;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass6;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass7;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass8;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass9;
import com.tencent.mm.ui.contact.v;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import java.util.List;

@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI extends MMFragmentActivity {
    public af ypN = new af();
    public u yvF;

    public void onCreate(Bundle bundle) {
        boolean z;
        getWindow().setFormat(-2);
        e.O(this);
        super.onCreate(null);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("Chat_User");
        boolean booleanExtra = intent.getBooleanExtra("key_is_biz_chat", false);
        if (!booleanExtra && stringExtra == null) {
            x.e("MicroMsg.ChattingUI.BizMgr", "talker is null !!!");
            z = true;
        } else if (booleanExtra && intent.getLongExtra("key_biz_chat_id", -1) == -1) {
            x.e("MicroMsg.ChattingUI.BizMgr", "bizChatId is null !!");
            z = true;
        } else {
            z = false;
        }
        if (z) {
            finish();
            return;
        }
        setContentView(R.i.der);
        this.yvF = new a(true);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_CHATTING_ACTIVITY", true);
        this.yvF.setArguments(extras);
        getSupportFragmentManager().aS().a(R.h.cws, this.yvF).commit();
        getSupportActionBar().show();
        d dVar = ((a) this.yvF).yvW;
        intent = getIntent();
        stringExtra = intent.getStringExtra("Chat_User");
        String stringExtra2 = intent.getStringExtra("send_card_username");
        if (!bh.ov(stringExtra2)) {
            booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
            String stringExtra3 = intent.getStringExtra("send_card_edittext");
            if (booleanExtra) {
                ar.CG().a(new j(bh.az(stringExtra, ""), v.ZE(stringExtra2), 42), 0);
            } else {
                List F = bh.F(bh.az(stringExtra, "").split(","));
                String ZE = v.ZE(stringExtra2);
                for (int i = 0; i < F.size(); i++) {
                    ar.CG().a(new j((String) F.get(i), ZE, 42), 0);
                }
            }
            if (stringExtra3 != null) {
                f.aZh().dj(stringExtra3, stringExtra);
            }
        }
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            ag.h(new 1(this), 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        a.VZ().Wa();
        initNavigationSwipeBack();
        this.ypN.post(new Runnable(this) {
            final /* synthetic */ ChattingUI yvG;

            {
                this.yvG = r1;
            }

            public final void run() {
                if (this.yvG.yvF != null) {
                    e.a(this.yvG, this.yvG.yvF.getBodyView());
                }
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        x.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[]{keyEvent});
        if (this.yvF == null || !this.yvF.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        x.d("MicroMsg.ChattingUI", "chatting ui on key up");
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        x.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", new Object[]{Integer.valueOf(i), keyEvent});
        return super.onKeyDown(i, keyEvent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        u uVar = this.yvF;
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ChattingUI.ChattingPermissionsLogic";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.ChattingUI.ChattingPermissionsLogic", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        int i2;
        switch (i) {
            case 18:
                if (iArr[0] != 0) {
                    i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezM : R.l.ezQ;
                    if (iArr[0] != 0) {
                        h.a((Context) this, getString(i2), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 4(this), new 5());
                        return;
                    }
                    return;
                } else if (uVar instanceof a) {
                    ((a) uVar).ywe.ctQ();
                    return;
                } else {
                    return;
                }
            case 19:
            case 21:
            case 22:
                if (iArr[0] != 0) {
                    i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezM : R.l.ezQ;
                    if (iArr[0] != 0) {
                        h.a((Context) this, getString(i2), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new AnonymousClass6(this), new AnonymousClass7());
                        return;
                    }
                    return;
                } else if (!(uVar instanceof a)) {
                    return;
                } else {
                    if (i == 19) {
                        ((a) uVar).ywe.bjC();
                        return;
                    } else if (i == 21) {
                        ((a) uVar).ywe.crC();
                        return;
                    } else {
                        ((a) uVar).ywe.crA();
                        return;
                    }
                }
            case 20:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.l.ezM), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new AnonymousClass8(this), null);
                    return;
                } else if (uVar instanceof a) {
                    ((a) uVar).ywe.crE();
                    return;
                } else {
                    return;
                }
            case 67:
            case 68:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new AnonymousClass9(this), null);
                    return;
                } else if (!(uVar instanceof a)) {
                    return;
                } else {
                    if (i == 67) {
                        ((a) uVar).yvX.ctS();
                        return;
                    } else {
                        ((a) uVar).yvX.ctT();
                        return;
                    }
                }
            case 80:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.l.ezQ), "", getString(R.l.est), getString(R.l.cancel), false, new 1(this), new 3());
                    return;
                } else if (uVar instanceof a) {
                    ((a) uVar).ywe.ctP();
                    return;
                } else {
                    return;
                }
            case 81:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 10(this), null);
                    return;
                } else if (uVar instanceof a) {
                    ((a) uVar).ywe.crD();
                    return;
                } else {
                    return;
                }
            case 82:
            case 83:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new com.tencent.mm.ui.chatting.b.h.AnonymousClass2(this), null);
                    return;
                } else if (!(uVar instanceof a)) {
                    return;
                } else {
                    if (i == 82) {
                        ((a) uVar).ywe.bjB();
                        return;
                    } else {
                        ((a) uVar).ywe.crB();
                        return;
                    }
                }
            default:
                return;
        }
    }
}
