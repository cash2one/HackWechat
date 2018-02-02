package com.tencent.mm.plugin.accountsync.ui;

import android.accounts.AccountAuthenticatorResponse;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.plugin.accountsync.model.b;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.z.ar;
import org.xwalk.core.R$styleable;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public final class ContactsSyncUI extends MMActivity {
    private AccountAuthenticatorResponse ilc = null;
    Bundle ild = null;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        int a = t.a(getIntent(), "wizard_activity_result_code", 0);
        x.i("MicroMsg.ContactsSyncUI", "onCreate() resultCode[%d]", new Object[]{Integer.valueOf(a)});
        switch (a) {
            case -1:
            case 0:
                x.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts read[%b],stack[%s]", new Object[]{Boolean.valueOf(a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy()});
                if (a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                    x.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts write[%b],stack[%s]", new Object[]{Boolean.valueOf(a.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)), bh.cgy()});
                    if (a.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)) {
                        initView();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                finish();
                return;
            default:
                x.e("MicroMsg.ContactsSyncUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        boolean z = false;
        if (!ar.Hi() || ar.Cs()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
        } else if (getIntent() == null) {
            x.e("MicroMsg.ContactsSyncUI", "initView fail, intent is null");
            finish();
        } else {
            int a = t.a(getIntent(), "contact_sync_scene", -1);
            if (getIntent().getAction() == null || !getIntent().getAction().equalsIgnoreCase("com.tencent.mm.login.ACTION_LOGIN")) {
                String resolveType = getIntent().resolveType(this);
                x.i("MicroMsg.ContactsSyncUI", "scheme = " + resolveType + ", action = " + getIntent().getAction());
                if (!bh.ov(resolveType)) {
                    a = resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile") ? 2 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip") ? 12 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") ? 13 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline") ? 3 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.phonenum") ? 6 : -1;
                }
            } else {
                a = 4;
            }
            if (a == -1) {
                x.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
                finish();
                return;
            }
            b.a aVar;
            Parcelable parcelableExtra;
            switch (a) {
                case 1:
                    parcelableExtra = getIntent().getParcelableExtra("accountAuthenticatorResponse");
                    this.ilc = null;
                    if (parcelableExtra != null && (parcelableExtra instanceof AccountAuthenticatorResponse)) {
                        this.ilc = (AccountAuthenticatorResponse) parcelableExtra;
                    }
                    if (this.ilc != null) {
                        this.ilc.onRequestContinued();
                    }
                    if (!t.a(getIntent(), "k_login_without_bind_mobile", false)) {
                        z = true;
                    }
                    aVar = new a(this, z);
                    break;
                case 2:
                case 6:
                    aVar = new b.b(1, t.j(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 3:
                    aVar = new b.b(2, t.j(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 4:
                    parcelableExtra = getIntent().getParcelableExtra("accountAuthenticatorResponse");
                    this.ilc = null;
                    if (parcelableExtra != null && (parcelableExtra instanceof AccountAuthenticatorResponse)) {
                        this.ilc = (AccountAuthenticatorResponse) parcelableExtra;
                    }
                    if (this.ilc != null) {
                        this.ilc.onRequestContinued();
                    }
                    if (!getSharedPreferences(ac.cfs(), 0).getBoolean("upload_contacts_already_displayed", false)) {
                        Object aVar2 = new a(this, !t.a(getIntent(), "k_login_without_bind_mobile", false));
                        break;
                    }
                case 12:
                    aVar = new b.b(3, t.j(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 13:
                    aVar = new b.b(4, t.j(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                default:
                    aVar = null;
                    break;
            }
            if (aVar != null) {
                Intent intent;
                Intent intent2;
                switch (aVar.bJ(this)) {
                    case 2:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        Intent intent3 = new Intent();
                        intent3.setClass(this, BindMContactIntroUI.class);
                        intent3.putExtra("key_upload_scene", 2);
                        intent3.putExtra("is_bind_for_contact_sync", true);
                        MMWizardActivity.b(this, intent3, intent);
                        finish();
                        break;
                    case 3:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        intent2 = new Intent();
                        intent2.setClass(this, SimpleLoginUI.class);
                        MMWizardActivity.b(this, intent2, intent);
                        finish();
                        break;
                    case 4:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        intent2 = new Intent();
                        intent2.setClass(this, SimpleLoginUI.class);
                        intent2.putExtra("accountAuthenticatorResponse", this.ilc);
                        MMWizardActivity.b(this, intent2, intent);
                        finish();
                        break;
                    case 5:
                        return;
                }
            }
            x.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
            finish();
        }
    }

    public final void finish() {
        if (this.ilc != null) {
            if (this.ild != null) {
                this.ilc.onResult(this.ild);
            } else {
                this.ilc.onError(4, "canceled");
            }
            this.ilc = null;
        }
        super.finish();
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ContactsSyncUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.ContactsSyncUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    new af().post(new 1(this, strArr[0]));
                    return;
                } else {
                    h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
