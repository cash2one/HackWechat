package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.GridView;
import android.widget.ImageButton;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog extends MMBaseActivity {
    private List<String> hiv = new LinkedList();
    private GridView rES = null;
    private a rET = null;

    static /* synthetic */ void b(SnsSelectContactDialog snsSelectContactDialog) {
        Intent intent = new Intent();
        String str = bh.d(snsSelectContactDialog.hiv, ",") + ", " + q.FS();
        intent.putExtra("Contact_Compose", true);
        intent.putExtra("Add_get_from_sns", snsSelectContactDialog.bBq());
        intent.putExtra("List_Type", 1);
        intent.putExtra("Add_address_titile", snsSelectContactDialog.getString(j.dDo));
        intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
        intent.putExtra("Block_list", str);
        intent.putExtra("sns_address_count", snsSelectContactDialog.hiv.size());
        a.ifs.a(intent, snsSelectContactDialog, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.qHf);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (stringExtra == null || stringExtra.equals("")) {
            this.hiv.clear();
        } else {
            this.hiv = bh.F(stringExtra.split(","));
        }
        this.rES = (GridView) findViewById(f.qBL);
        this.rET = new a(this, this, this.hiv);
        this.rES.setAdapter(this.rET);
        this.rES.setOnItemClickListener(new 1(this));
        this.rES.setSelection(this.rET.getCount() - 1);
        ((ImageButton) findViewById(f.bWk)).setOnClickListener(new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", bh.d(this.hiv, ","));
            setResult(-1, intent);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean Ma(String str) {
        for (Object equals : s.hfr) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (s.eV(str) || s.gF(str)) {
            return false;
        }
        if (this.hiv == null || !this.hiv.contains(str)) {
            return true;
        }
        return false;
    }

    private String bBq() {
        as Fd = ((h) com.tencent.mm.kernel.g.h(h.class)).Fd();
        String str = s.hfk;
        List linkedList = new LinkedList();
        for (Object add : s.hfr) {
            linkedList.add(add);
        }
        linkedList.add("weixin");
        linkedList.add("officialaccounts");
        linkedList.add("helper_entry");
        linkedList.add("filehelper");
        Cursor c = Fd.c(str, linkedList, "*");
        if (c.getCount() == 0) {
            c.close();
            return "";
        }
        List linkedList2 = new LinkedList();
        c.moveToFirst();
        do {
            aj aeVar = new ae();
            aeVar.b(c);
            if (Ma(aeVar.field_username)) {
                linkedList2.add(aeVar.field_username);
                if (linkedList2.size() >= 10) {
                    break;
                }
            }
        } while (c.moveToNext());
        c.close();
        return bh.d(linkedList2, ";");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> F = bh.F(intent.getStringExtra("Select_Contact").split(","));
                        if (F != null) {
                            if (this.hiv == null) {
                                this.hiv = new LinkedList();
                            }
                            for (String str : F) {
                                if (!this.hiv.contains(str)) {
                                    this.hiv.add(str);
                                }
                            }
                            x.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.hiv.size());
                            if (this.rET != null) {
                                x.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
                                this.rET.refresh();
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Select_Contact", bh.d(this.hiv, ","));
                            setResult(-1, intent2);
                            finish();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
