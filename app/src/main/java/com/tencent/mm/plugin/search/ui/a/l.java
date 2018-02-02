package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.plugin.fts.d.a.b$b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class l extends b {
    public b qeE;
    public boolean qeF;
    private a qeG = new a(this);

    public class a extends b.b {
        final /* synthetic */ l qeH;

        public a(l lVar) {
            this.qeH = lVar;
            super(lVar);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            l lVar = (l) bVar;
            if (lVar.qeE != null) {
                Intent intent;
                if (lVar.qeE.status == 1 || lVar.qeE.status == 2) {
                    x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
                    intent = new Intent();
                    intent.putExtra("Contact_User", this.qeH.qeE.getUsername());
                    intent.putExtra("Contact_Nick", this.qeH.qeE.Nw());
                    intent.putExtra("Contact_Mobile_MD5", this.qeH.qeE.Nr());
                    intent.putExtra("Contact_Alias", this.qeH.qeE.hvy);
                    intent.putExtra("Contact_Sex", this.qeH.qeE.hvt);
                    intent.putExtra("Contact_Signature", this.qeH.qeE.hvw);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(this.qeH.qeE.hvC, this.qeH.qeE.hvu, this.qeH.qeE.hvv));
                    intent.putExtra("Contact_Scene", 13);
                    intent.putExtra("Contact_ShowUserName", false);
                    if (this.qeH.qeF) {
                        intent.putExtra("add_more_friend_search_scene", 1);
                    }
                    com.tencent.mm.plugin.c.a.ifs.d(intent, context);
                } else if (this.qeH.qeE.status == 0) {
                    x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
                    intent = new Intent(context, InviteFriendUI.class);
                    intent.putExtra("friend_type", 1);
                    intent.putExtra("friend_user_name", this.qeH.qeE.getUsername());
                    intent.putExtra("friend_num", this.qeH.qeE.Nz());
                    intent.putExtra("friend_nick", this.qeH.qeE.Nt());
                    intent.putExtra("friend_weixin_nick", this.qeH.qeE.Nw());
                    intent.putExtra("friend_scene", 13);
                    context.startActivity(intent);
                } else {
                    x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
                }
            }
            return true;
        }
    }

    public l(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        this.username = this.iVU.mLs;
        ar.Hg();
        this.jLe = c.EY().WO(this.username);
        this.qeE = af.OD().bd(this.iVU.mMf);
        CharSequence Nt = this.qeE.Nt();
        boolean z;
        boolean z2;
        int i;
        int i2;
        switch (this.iVU.mLr) {
            case 5:
                z = false;
                z2 = false;
                break;
            case 6:
                z = false;
                break;
            case 7:
                z = true;
                break;
            case 12:
                z = false;
                z2 = false;
                break;
            case 13:
                z = false;
                break;
            case 14:
                z = true;
                break;
            case 16:
                i = 1;
                i2 = 0;
                Object Nz = this.qeE.Nz();
                Object string = context.getString(R.l.eII);
                z = false;
                z2 = false;
                break;
            default:
                z2 = false;
                i = 0;
                i2 = 0;
                CharSequence charSequence = null;
                CharSequence charSequence2 = null;
                z = false;
                break;
        }
    }

    public final b$b adp() {
        return this.qeG;
    }
}
