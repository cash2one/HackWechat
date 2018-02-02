package com.tencent.mm.plugin.game.model;

import android.content.Intent;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class SubCoreGameCenter$2 extends c<lg> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$2(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = lg.class.getName().hashCode();
    }

    private static boolean a(lg lgVar) {
        String optString;
        int i;
        JSONException e;
        Intent intent;
        Exception e2;
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject(lgVar.fCD.extraInfo);
            optString = jSONObject.optString("appId");
            try {
                i = bh.getInt(jSONObject.optString("ssid"), 0);
            } catch (JSONException e3) {
                e = e3;
                x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                i = 0;
                intent = new Intent();
                switch (lgVar.fCD.fCE) {
                    case 0:
                        intent.setClass(lgVar.fCD.context, GameCenterUI.class);
                        if (lgVar.fCD.jumpType == 1) {
                            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lgVar.fCD.context.startActivity(intent);
                        ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                        break;
                    case 1:
                        intent.setClass(lgVar.fCD.context, GameLibraryUI.class);
                        if (lgVar.fCD.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lgVar.fCD.context.startActivity(intent);
                        ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                        break;
                    case 2:
                        if (!bh.ov(optString)) {
                            intent.setClass(lgVar.fCD.context, GameDetailUI.class);
                            intent.putExtra("game_app_id", optString);
                            if (lgVar.fCD.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            lgVar.fCD.context.startActivity(intent);
                            ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                            break;
                        }
                        break;
                    case 3:
                        intent.setClass(lgVar.fCD.context, GameMessageUI.class);
                        intent.putExtra("game_report_from_scene", 5);
                        lgVar.fCD.context.startActivity(intent);
                        ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                        break;
                }
                return false;
            } catch (Exception e4) {
                e2 = e4;
                x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e2.getMessage()});
                i = 0;
                intent = new Intent();
                switch (lgVar.fCD.fCE) {
                    case 0:
                        intent.setClass(lgVar.fCD.context, GameCenterUI.class);
                        if (lgVar.fCD.jumpType == 1) {
                            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lgVar.fCD.context.startActivity(intent);
                        ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                        break;
                    case 1:
                        intent.setClass(lgVar.fCD.context, GameLibraryUI.class);
                        if (lgVar.fCD.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lgVar.fCD.context.startActivity(intent);
                        ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                        break;
                    case 2:
                        if (bh.ov(optString)) {
                            intent.setClass(lgVar.fCD.context, GameDetailUI.class);
                            intent.putExtra("game_app_id", optString);
                            if (lgVar.fCD.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            lgVar.fCD.context.startActivity(intent);
                            ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                            break;
                        }
                        break;
                    case 3:
                        intent.setClass(lgVar.fCD.context, GameMessageUI.class);
                        intent.putExtra("game_report_from_scene", 5);
                        lgVar.fCD.context.startActivity(intent);
                        ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                        break;
                }
                return false;
            }
        } catch (JSONException e5) {
            JSONException jSONException = e5;
            optString = str;
            e = jSONException;
            x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
            i = 0;
            intent = new Intent();
            switch (lgVar.fCD.fCE) {
                case 0:
                    intent.setClass(lgVar.fCD.context, GameCenterUI.class);
                    if (lgVar.fCD.jumpType == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lgVar.fCD.context.startActivity(intent);
                    ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                    break;
                case 1:
                    intent.setClass(lgVar.fCD.context, GameLibraryUI.class);
                    if (lgVar.fCD.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lgVar.fCD.context.startActivity(intent);
                    ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                    break;
                case 2:
                    if (bh.ov(optString)) {
                        intent.setClass(lgVar.fCD.context, GameDetailUI.class);
                        intent.putExtra("game_app_id", optString);
                        if (lgVar.fCD.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lgVar.fCD.context.startActivity(intent);
                        ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                        break;
                    }
                    break;
                case 3:
                    intent.setClass(lgVar.fCD.context, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    lgVar.fCD.context.startActivity(intent);
                    ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                    break;
            }
            return false;
        } catch (Exception e6) {
            Exception exception = e6;
            optString = str;
            e2 = exception;
            x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e2.getMessage()});
            i = 0;
            intent = new Intent();
            switch (lgVar.fCD.fCE) {
                case 0:
                    intent.setClass(lgVar.fCD.context, GameCenterUI.class);
                    if (lgVar.fCD.jumpType == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lgVar.fCD.context.startActivity(intent);
                    ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                    break;
                case 1:
                    intent.setClass(lgVar.fCD.context, GameLibraryUI.class);
                    if (lgVar.fCD.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lgVar.fCD.context.startActivity(intent);
                    ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                    break;
                case 2:
                    if (bh.ov(optString)) {
                        intent.setClass(lgVar.fCD.context, GameDetailUI.class);
                        intent.putExtra("game_app_id", optString);
                        if (lgVar.fCD.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lgVar.fCD.context.startActivity(intent);
                        ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                        break;
                    }
                    break;
                case 3:
                    intent.setClass(lgVar.fCD.context, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    lgVar.fCD.context.startActivity(intent);
                    ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                    break;
            }
            return false;
        }
        intent = new Intent();
        switch (lgVar.fCD.fCE) {
            case 0:
                intent.setClass(lgVar.fCD.context, GameCenterUI.class);
                if (lgVar.fCD.jumpType == 1) {
                    intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                }
                intent.putExtra("game_report_from_scene", 5);
                lgVar.fCD.context.startActivity(intent);
                ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                break;
            case 1:
                intent.setClass(lgVar.fCD.context, GameLibraryUI.class);
                if (lgVar.fCD.jumpType == 1) {
                    intent.putExtra("jump_game_center", "jump_game_center");
                }
                intent.putExtra("game_report_from_scene", 5);
                lgVar.fCD.context.startActivity(intent);
                ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                break;
            case 2:
                if (bh.ov(optString)) {
                    intent.setClass(lgVar.fCD.context, GameDetailUI.class);
                    intent.putExtra("game_app_id", optString);
                    if (lgVar.fCD.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lgVar.fCD.context.startActivity(intent);
                    ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                    break;
                }
                break;
            case 3:
                intent.setClass(lgVar.fCD.context, GameMessageUI.class);
                intent.putExtra("game_report_from_scene", 5);
                lgVar.fCD.context.startActivity(intent);
                ap.a(lgVar.fCD.context, 5, 5, 1, 6, i, null);
                break;
        }
        return false;
    }
}
