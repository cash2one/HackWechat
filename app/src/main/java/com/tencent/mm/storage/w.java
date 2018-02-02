package com.tencent.mm.storage;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class w {
    public static String gZK = e.gZK;
    public static final String xmI = (ac.getContext().getFilesDir() + "/xlog");

    public enum a {
        USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG,
        USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG,
        USERINFO_UPDATE_UPDATE_FLAG_LONG,
        USERINFO_UPDATE_UPDATE_VERION_LONG,
        USERINFO_UPDATE_UPDATE_TIME_LONG,
        USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC,
        USERINFO_WALLET_OFFLINE_CODE_VER_STRING,
        USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC,
        USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC,
        USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC,
        USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC,
        USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC,
        USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC,
        USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC,
        USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC,
        USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC,
        USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC,
        USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC,
        USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC,
        USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC,
        USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG,
        USERINFO_GAME_GLOBAL_CONFIG_UPDATE_TIME_LONG,
        USERINFO_MINIGAME_SEARCH_LIST_UPDATE_TIME_LONG,
        USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN,
        USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG,
        USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG,
        USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN,
        USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN,
        USERINFO_EMOJI_STORE_LAST_REFRESH_TIME_LONG,
        USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG,
        USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN,
        USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN,
        USERINFO_EMOJI_SYNC_STORE_EMOJI_NEW_PANEL_BOOLEAN,
        USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN,
        USERINFO_EMOJI_LAST_BATCH_EMOJI_DOWNLOAD_TIME_2_LONG,
        USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG,
        USERINFO_EMOJI_ENCODE_EMOJI_FILE_TASK_LONG,
        USERINFO_EMOJI_REPORT_CUSTOM_EMOJI_COUNT_LONG,
        USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN,
        USERINFO_EMOJI_CUREENT_VERSION_INT,
        USERINFO_EMOJI_UPDATE_EMOJI_GROUP_COUNT_BOOLEAN,
        USERINFO_EMOJI_NEW_EMOJI_INT,
        USERINFO_EMOJI_NEW_PANEL_INT,
        USERINFO_EMOJI_NEW_SUGGEST_INT,
        USERINFO_EMOJI_EGG_INT,
        USERINFO_EMOJI_NEW_PANEL_NAME_STRING,
        USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC,
        USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT,
        USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN,
        USERFINO_VOICEPRINT_SETTING_DOT_SHOW_BOOLEAN,
        USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN,
        USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN,
        USERINFO_REPORTNETTYPE_SEQ_LONG,
        USERINFO_REPORTNETTYPE_LASTREPORT_LONG,
        USERINFO_SELFINFO_SMALLIMGURL_STRING,
        USERINFO_SELFINFO_GETPROFILE_TIME_LONG,
        USERINFO_WALLET_BALANCE_NOTICE_STRING,
        USERINFO_WALLET_FETCH_NOTICE_STRING,
        USERINFO_WALLET_SUPPORT_BANK_WORD_STRING,
        USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG,
        USERINFO_EXPOSE_GETEXPOSESCENE_TIME_LONG,
        USERINFO_WXPHONE_PB_COUNT_INT,
        USERINFO_MALL_INDEX_HAS_SHOWN_FTF_NOTICE_BOOLEAN,
        USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING,
        USERINFO_QQMAIL_UNREAD_COUNT_INT,
        USERINFO_AUTOGETBIG_IMG_MAX_LONG,
        USERINFO_AUTOGETBIG_IMG_CURRENT_LONG,
        USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG,
        USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG,
        USERINFO_SHAKE_TV_LATITUDE_STRING,
        USERINFO_SHAKE_TV_LONGTITUDE_STRING,
        NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC,
        NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC,
        NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC,
        NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC,
        USERINFO_CARDLAYOUT_TESTDATA_STRING,
        USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC,
        USERINFO_CARD_REDOT_WORDING_STRING_SYNC,
        USERINFO_CARD_REDOT_END_TIME_INT_SYNC,
        USERINFO_CARD_REDOT_BUFF_STRING_SYNC,
        USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC,
        USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC,
        USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC,
        USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC,
        USERINFO_CARD_GET_LAYOUT_JSON_STRING_SYNC,
        USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC,
        USERINFO_CARD_REQUENCE_LONG_SYNC,
        USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC,
        USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC,
        USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC,
        USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC,
        USERINFO_CARD_SHARE_LIST_CLEAR_TIME_INT_SYNC,
        USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC,
        USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC,
        USERINFO_CARD_MSG_CARD_ID_STRING_SYNC,
        USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC,
        USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN,
        USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC,
        USERINFO_WALLET_FINGERPRINT_SWITCH_IS_NOT_NEW_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_IS_SO_LOADLIBRARY_SUCCESS_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC,
        USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC,
        USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC,
        USERINFO_ABTEST_SERVER_TIMESTAMP_INT,
        USERINFO_ABTEST_LAST_UPDATE_TIME_LONG,
        USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT,
        USERINFO_NFC_CPU_CARD_CONFIG_STRING,
        USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN,
        USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN,
        USERINFO_BIND_MOBILE_XML_WORDING_STRING,
        USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT,
        USERINFO_NFC_OPEN_SWITCH_INT_SYNC,
        USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC,
        BUSINESS_SNS_ADLOG_FREQUENCY_INT,
        BUSINESS_SNS_ADLOG_CNTTIME_INT,
        USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC,
        USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT,
        USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG,
        USERINFO_IPCALL_FIRST_IN_BOOLEAN,
        USERINFO_IPCALL_ADDRESS_LASTREPORT_TIME_LONG,
        USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG,
        USERINFO_IPCALL_ADDRESS_GETLOCATION_LASTUPDATE_TIME_LONG,
        USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN,
        USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT,
        USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING,
        USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING,
        USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT,
        USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT,
        USERFINO_IPCALL_RECHARGE_STRING,
        USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN,
        USERINFO_IPCALL_PACKAGE_PURCHASE_STRING,
        USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN,
        USERFINO_IPCALL_HAS_ENTRY_BOOLEAN,
        USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT,
        USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING,
        USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN,
        USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_TYPE_INT,
        USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN,
        USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT,
        USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT,
        USERFINO_IPCALL_SHOW_FROM_VOIP_LAST_TIME_LONG,
        USERFINO_IPCALL_SHOW_FROM_VOIP_TIME_COUNT_INT,
        USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN,
        USERFINO_FAV_USED_CAPACITY_LONG,
        USERFINO_FAV_TOTAL_CAPACITY_LONG,
        USERFINO_FAV_IS_FULL_BOOLEAN,
        USERFINO_IPCALL_SHOW_FEEDBACK_LAST_TIME_LONG,
        USERFINO_IPCALL_SHOW_FEEDBACK_TIME_COUNT_INT,
        USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN,
        USERFINO_IPCALL_ACTIVITY_STRING,
        USERINFO_SUBMENU_SHOW_TIT_BOOLEAN,
        USERINFO_PROFILE_WEIDIANINFO_STRING,
        GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC,
        GAME_INDEX_BUBBLE_MSGID_LONG_SYNC,
        GAME_MSG_ENTRANCE_MSGID_LONG_SYNC,
        GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC,
        GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC,
        USERINFO_WELCOMEMSG_CONTENT_STRING,
        USERINFO_WELCOMEMSG_EXT_LASTTIME_LONG,
        USERINFO_WELCOMEMSG_EXT_SHOWCOUNT_LONG,
        USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG,
        USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG,
        USERINFO_LOAN_ENTRANCE_RED_POINT_INT,
        USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG,
        USERINFO_IBEACON_PUSH_SHOP_ID_LONG,
        USERINFO_IBEACON_PUSH_CHANNEL_OPEN_METHOD_INT,
        USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG,
        USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT,
        USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN,
        USERINFO_IBEACON_PUSH_BEACONINFO_STRING,
        USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING,
        USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN,
        USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG,
        USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN,
        USERINFO_IBEACON_SHAKE_TAB_IS_BLUETOOTH_RESIDENT_BOOLEAN,
        USERINFO_IBEACON_SHAKE_TAB_IS_CITY_RESIDENT_BOOLEAN,
        USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT,
        USERINFO_IBEACON_SHAKE_TAB_RESIDENT_GATED_LAUNCH_INT,
        USERINFO_PROFILE_WEIDIANINFO_ALERT_INT,
        USERINFO_LAST_LOCATION_STRING,
        USERINFO_LAST_F2F_INVITE_TIME_LONG,
        USERINFO_F2F_DELAY_TIME_LONG,
        USERINFO_MALL_INDEX_TYPE_NAME_LIST_STRING_SYNC,
        USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING,
        USERINFO_SHAKE_TV_ACCURACY_STRING,
        USERINFO_IPCALL_ACCOUNT_CACHE_STRING,
        USERINFO_SET_CAN_WEBVIEW_CACHE_DOWNLOAD_BOOLEAN,
        USERINFO_SET_CAN_WEBVIEW_CACHE_PRE_PUSH_DOWNLOAD_BOOLEAN,
        USERINFO_WEBVIEW_CACHE_CLEANUP_INTERVAL_LONG,
        USERINFO_TRICK_SOTER_BOOLEAN,
        USERINFO_CLEANUI_QQMGRINFO_STRING,
        USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN,
        USERINFO_POSITION_INVOKE_EDIT_TIP_IN_BOOLEAN,
        USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN,
        USERINFO_WALLET_BULLETIN_GET_TIME_LONG,
        USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRL_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_TIP_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKFINDMORE_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKCAMERA_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKFULLSCREEN_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCTRLHASSHOW_BOOLEAN_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKGOLDCAMERATIP_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_TIPMARKCAMERATIP_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_LEVELCTRL_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SNS_FLOW_CONTROL_CACHEBUFFER_STRING,
        USERINFO_NEWYEAR_2016_ACCEPT_CARD_ITEM_BUFFER_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_CAN_OPEN_SNS_PAY_INT_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_IS_WHITE_USER_INT_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_OPEN_SNS_PAY_TITLE_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_OPEN_SNS_PAY_WORDING_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_TITLE_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_WORDING_STRING_SYNC,
        USERINFO_NEWYEAR_2016_HONGBAO_HAS_SHOW_SNS_PAY_GUIDE_DIALOG_BOOLEAN_SYNC,
        USERINFO_NEWYEAR_HONGBAO_IMAGE_PATH_STRING_SYNC,
        USERINFO_NEWYEAR_HONGBAO_IMAGE_ID_STRING_SYNC,
        USERINFO_NEWYEAR_HONGBAO_IMAGE_AES_KEY_STRING_SYNC,
        USERINFO_NEWYEAR_HONGBAO_IMAGE_LENGTH_INT_SYNC,
        USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC,
        USERINFO_FINGERPRINT_RETRY_TIME_INT_SYNC,
        USERINFO_FINGERPRINT_LAST_FREEZE_TIME_LONG_SYNC,
        USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC,
        USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC,
        USERINFO_WALLET_FETCH_CHARGE_TIP_DIALOG_BOOLEAN_SYNC,
        USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC,
        USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC,
        USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC,
        USERINFO_WALLET_BANKCARD_DETAIL_URL_TIMESTAMP_LONG_SYNC,
        USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC,
        USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC,
        USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC,
        USERINFO_WALLET_REALNAME_URL_STRING_SYNC,
        USERINFO_WALLET_LBS_REPORT_DIALOG_SHOW_TIME_LONG_SYNC,
        USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC,
        USERINFO_WALLET_LBS_REPORT_DIALOG_TITLE_STRING_SYNC,
        USERINFO_WALLET_LBS_REPORT_DIALOG_CONTENT_STRING_SYNC,
        USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC,
        USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC,
        USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING,
        USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING,
        USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC,
        USERINFO_FACE_DETECTION_ENROLLED_BOOLEAN_SYNC,
        USERINFO_WALLET_MALLINDEX_OSDATA_TYPE_STRING_SYNC,
        USERINFO_WALLET_REGION_TYPE_INT_SYNC,
        USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN,
        USERINFO_APP_BRAND_PUBLIC_LIB_UPDATE_NEXT_TIME_SEC_LONG,
        USERINFO_APP_BRAND_PUBLIC_LIB_USERNAME_STRING,
        USERINFO_APP_BRAND_PUBLIC_LIB_APPID_STRING,
        USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG,
        USERINFO_APP_BRAND_USAGE_RECORD_SYNC_NEXT_TIME_SEC_LONG,
        USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN,
        USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN,
        USERINFO_APP_BRAND_SHOW_HISTORY_COUNT_BOOLEAN,
        USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN,
        USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG,
        USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG,
        USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING,
        USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG,
        USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT,
        USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT,
        USERINFO_APP_BRAND_ENTRANCE_RED_DOT_TIPS_STRING,
        USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN,
        USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN,
        USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_MSG_ID_STRING,
        USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_END_TIME_SECOND_LONG,
        USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_LAST_TIME_SECOND_LONG,
        USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_FREQUENCY_SECOND_LONG,
        USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN,
        USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC,
        USERINFO_APP_BRAND_CHATTING_BANNER_INFO_STRING_SYNC,
        USERINFO_APP_BRAND_SEARCH_SHOW_OUT_DAILY_SYNC_LAST_TIME_SECOND_LONG,
        USERINFO_APP_BRAND_RECENT_BAR_HAS_BEEN_REVEALED_BY_FIRST_APP_LAUNCH_BOOLEAN,
        USERINFO_EXT_SPORT_PKGNAME_STRING,
        USERINFO_SENSE_WHERE_LOCATION_STRING,
        USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG,
        USERINFO_LAST_START_SENSE_WHERE_LONG,
        USERINFO_REPORT_SD_STATUS_TIME_LONG,
        USERINFO_REPORT_HARDCODER_TIME_LONG,
        USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC,
        USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC,
        USERINFO_ONLINE_VIDEO_INT,
        USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE_DIALOG_BOOLEAN_SYNC,
        USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC,
        USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC,
        USERINFO_WALLETDIGITAL_CERT_CRT_STRING_SYNC,
        USERINFO_WALLETDIGITAL_CERT_NO_STRING_SYNC,
        USERINFO_WALLETDIGITAL_CERT_SHOW_INT_SYNC,
        USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC,
        USERINFO_AA_MAX_PAYER_NUM_INT,
        USERINFO_AA_MAX_RECEIVER_NUM_INT,
        USERINFO_AA_MAX_TOTAL_USER_NUM_INT,
        USERINFO_AA_MAX_TOTAL_AMOUNT_LONG,
        USERINFO_AA_MAX_PER_AMOUNT_LONG,
        USERINFO_APP_BRAND_FAILED_FORMID_STRING,
        USERINFO_LOCAL_SIGHT_RECODER_INT_SYNC,
        USERINFO_LOCAL_SIGHT_ENCODEINSEND_INT_SYNC,
        USERINFO_LOCAL_SIGHT_PREWVIEWSIZE_INT_SYNC,
        USERINFO_LOCAL_SIGHT_BITRATE_INT_SYNC,
        USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC,
        USERINFO_LOCAL_SIGHT_SET_SHUTTER_SOUND_INT_SYNC,
        USERINFO_LOCAL_SIGHT_CROP_INT_SYNC,
        USERINFO_LOCAL_SIGHT_OPENOLDSIGHT_INT_SYNC,
        USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC,
        USERINFO_LOCAL_SIGHT_THREADCOUNT_INT_SYNC,
        USERINFO_LOCAL_SIGHT_REALSCALE_INT_SYNC,
        USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC,
        USERINFO_LOCAL_SIGHT_FFMMPEGCUT_INT_SYNC,
        USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC,
        USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC,
        USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC,
        USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT,
        USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG,
        USERINFO_CLOG_SAMPLING_REFRESH_TIME_LONG,
        USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG,
        USERINFO_WECHAT_FILE_SCAN_INTERVAL_LONG,
        USERINFO_WECHAT_FILE_SCAN_WAIT_TIME_LONG,
        USERINFO_INSTALL_FIRST_TIME_LONG,
        USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT,
        USERINFO_INSTALL_LAST_REPORT_TIME_LONG,
        USERINFO_MSG_SYNCHRONIZE_BOOLEAN,
        USERINFO_LOGIN_EXT_DEVICE_INFO_INT,
        USERINFO_BACKUP_PC_BACKUPING_BOOLEAN,
        USERINFO_BACKUP_PC_RECOVERING_BOOLEAN,
        USERINFO_BACKUP_PC_MERGERING_BOOLEAN,
        USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN,
        USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN,
        USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN,
        USERINFO_BACKUP_OLD_RECORDS_BOOLEAN,
        USERINFO_WECHAT_BACKUP_CHAT_SIZE_CALCULATE_LAST_TIME_LONG,
        USERINFO_WECHAT_BACKUP_CHAT_SIZE_CALCULATE_INTERVAL_LONG,
        USERINFO_WECHAT_BACKUP_CHAT_SIZE_CALCULATE_WAIT_TIME_LONG,
        USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING,
        USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING,
        USERINFO_DELAY_TRANSFER_REMIND_WORDING_STRING,
        USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG,
        USERINFO_DELAY_TRANSFER_DESC_URL_STRING,
        USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT,
        USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT,
        USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN,
        USERINFO_WEIXIN_CAMERA_STATE_INT,
        USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN,
        USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN,
        USERINFO_WALLET_REMITTANCE_STRING_SYNC,
        USERINFO_WALLET_HONGBAO_STRING_SYNC,
        USERINFO_WEBVIEW_KEEP_STRING_SYNC,
        USERINFO_WEBVIEW_KEEP_LAST_PAGE_STRING_SYNC,
        USERINFO_WEBVIEW_KEEP_LAST_PAGE_TITLE_STRING_SYNC,
        USERINFO_F2F_RING_TONE_STRING,
        USERINFO_WXA_SEARCH_INPUT_HINT_LANG_STRING_SYNC,
        USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC,
        USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC,
        USERINFO_WXA_SEARCH_INPUT_HINT_UPDATE_TIME_LONG_SYNC,
        USERINFO_SHAKE_NEWYEAR_COOKIE_STRING,
        USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC,
        USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN,
        USERINFO_MALL_NEWS_MARKED_STRING_SYNC,
        USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING,
        USERINFO_WEBVIEW_KEEP_TOP_SCENE_INT_SYNC,
        USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC,
        USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC,
        USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_URL_STRING_SYNC,
        USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_USERNAME_STRING_SYNC,
        USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_TITLE_STRING_SYNC,
        USERINFO_HEAVY_USER_FLAG_LONG,
        USERINFO_HEAVY_USER_REPORT_TIME_LONG,
        USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG,
        USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG,
        USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG,
        USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG,
        USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG,
        USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG,
        USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG,
        USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG,
        USERINFO_MM_LVFETIME_REPORT_PID_INT,
        USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG,
        USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT,
        USERINFO_X264_VERSION_INT,
        USERINFO_SETTING_RECENT_RED_DOT_ID_INT,
        USERINFO_MY_RED_DOT_WILL_SHOW_ID_INT,
        USERINFO_MY_RED_DOT_DID_SHOW_ID_INT,
        USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT,
        USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT,
        USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT,
        USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT,
        USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT,
        USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT,
        USERINFO_WEIXIN_ENABLEFPSTOOL_STATE_BOOLEAN,
        USERINFO_CONTINUE_TEST_SCAN_TIME_INT,
        USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN,
        USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG,
        USERINFO_MUSIO_LAST_SCAN_MUSIC_FILE_TIME_LONG,
        USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC,
        USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC,
        USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC,
        USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC,
        USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING,
        USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING,
        USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING,
        USERINFO_WEB_SEARCH_CONFIG_EN_STRING,
        USERINFO_WEB_SEARCH_CONFIG_AR_STRING,
        USERINFO_WEB_SEARCH_CONFIG_DE_STRING,
        USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING,
        USERINFO_WEB_SEARCH_CONFIG_ES_STRING,
        USERINFO_WEB_SEARCH_CONFIG_FR_STRING,
        USERINFO_WEB_SEARCH_CONFIG_HE_STRING,
        USERINFO_WEB_SEARCH_CONFIG_HI_STRING,
        USERINFO_WEB_SEARCH_CONFIG_ID_STRING,
        USERINFO_WEB_SEARCH_CONFIG_IN_STRING,
        USERINFO_WEB_SEARCH_CONFIG_IT_STRING,
        USERINFO_WEB_SEARCH_CONFIG_IW_STRING,
        USERINFO_WEB_SEARCH_CONFIG_JA_STRING,
        USERINFO_WEB_SEARCH_CONFIG_KO_STRING,
        USERINFO_WEB_SEARCH_CONFIG_LO_STRING,
        USERINFO_WEB_SEARCH_CONFIG_MS_STRING,
        USERINFO_WEB_SEARCH_CONFIG_MY_STRING,
        USERINFO_WEB_SEARCH_CONFIG_PL_STRING,
        USERINFO_WEB_SEARCH_CONFIG_PT_STRING,
        USERINFO_WEB_SEARCH_CONFIG_RU_STRING,
        USERINFO_WEB_SEARCH_CONFIG_TH_STRING,
        USERINFO_WEB_SEARCH_CONFIG_TR_STRING,
        USERINFO_WEB_SEARCH_CONFIG_VI_STRING,
        USERINFO_CLIENT_SERVER_DIFF_TIME_LONG,
        USERINFO_MSG_DELAY_STAT_STRING,
        USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN,
        USERINFO_TENCENT_MAP_COUNT_INT,
        USERINFO_CROWDTEST_CLIENT_VERSION_INT,
        USERINFO_CROWDTEST_APPLY_EXPIRE_LONG,
        USERINFO_CROWDTEST_APPLY_LINK_STRING,
        USERINFO_CROWDTEST_FEEDBACK_LINK_STRING,
        USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT,
        USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING,
        USERINFO_BACKGROUND_CALC_TIME_LONG,
        USERINFO_WELAB_LAST_UPDATE_TIME_LONG,
        USERINFO_WELAB_UPDATE_TIME_INTERVAL_INT,
        USERINFO_WELAB_SERVER_TIMESTAMP_INT,
        USERINFO_WELAB_REDPOINT_STRING,
        USERINFO_WELAB_APP_REDPOINT_STRING,
        USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC,
        BUSINESS_OFFLINE_GETMSG_INTERVAL_INT,
        BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING,
        BUSINESS_OFFLINE_GETMSG_MAX_POS_TIME_INT,
        USERINFO_WALLET_HK_PAY_URL_STRING,
        USERINFO_SUPPORT_HEVC_VIDEO_INT,
        USERINFO_HAD_PRELOAD_SIZE_LONG,
        USERINFO_HAD_PRELOAD_TIME_LONG,
        USERINFO_C2C_HAD_PRELOAD_COUNT_INT,
        USERINFO_SNS_HAD_PRELOAD_COUNT_INT,
        USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC,
        USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC,
        USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC,
        USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC,
        USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC,
        USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC,
        USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC,
        USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC,
        USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC,
        USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC,
        USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC,
        USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC,
        USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC,
        USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC,
        USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC,
        USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC,
        USERINFO_WALLET_INDEX_MAIDAN_STRING_SYNC,
        USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING,
        USERINFO_LQT_WALLET_RED_DOT_INT,
        USERINFO_LQT_BALANCE_RED_DOT_INT,
        USERINFO_LQT_LINK_RED_DOT_INT,
        USERINFO_LQB_MALL_ENTRY_RED_DOT_INT,
        USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG,
        USERINFO_FTS_MASTER_DB_VERISON_INT_SYNC,
        USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC,
        USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG,
        BUSINESS_OFFLINE_GETMSG_REQ_KEY_STRING,
        BUSINESS_OFFLINE_GETMSG_PAYMSG_TYPE_INT,
        BUSINESS_OFFLINE_GETMSG_TRANS_ID_STRING,
        USERINFO_FTS_DISCOVERY_RED_ID_INT,
        USERINFO_FTS_DISCOVERY_RED_XML_STRING,
        NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC,
        NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC,
        NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC,
        USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC,
        USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC,
        USERINFO_CALC_WX_SCAN_STEP_INT,
        USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG,
        USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG,
        USERINFO_CALC_WX_SCAN_REPORT_TIME_LONG,
        USERINFO_CALC_WX_SCAN_START_TIME_LONG,
        USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG,
        USERINFO_CALC_WX_SCAN_SHOW_FILE_INT,
        USERINFO_WALLET_F2F_COLLECT_PAY_URL_STRING_SYNC,
        USERINFO_WALLET_F2F_COLLECT_TRUE_NAME_STRING_SYNC,
        USERINFO_WALLET_F2F_COLLECT_BOTTOM_MENU_STRING_SYNC,
        USERINFO_WALLET_F2F_COLLECT_BOTTOM_LEFT_ICON_URL_STRING_SYNC,
        USERINFO_WALLET_F2F_COLLECT_UPRIGHT_MENU_STRING_SYNC,
        USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC,
        USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC,
        USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC,
        USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC,
        USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC,
        USERINFO_WALLET_SET_PWD_TIP_INT_SYNC,
        USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC,
        USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC,
        USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC,
        USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC,
        USERINFO_WALLETLOCK_FINGERPRINT_LAST_VERIFY_OK_TIME_STRING_SYNC,
        USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC,
        USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC,
        USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC,
        USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC,
        USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC,
        USERINFO_WCPAY_WALLET_BUFFER_CN_STRING_SYNC,
        USERINFO_WCPAY_WALLET_BUFFER_MY_STRING_SYNC,
        USERINFO_WCPAY_WALLET_BUFFER_ZA_STRING_SYNC,
        USERINFO_WCPAY_WALLET_BUFFER_HK_STRING_SYNC,
        USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC,
        USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC,
        USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC,
        USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC,
        USERINFO_WALLET_QR_REWARD_TRUE_NAME_STRING_SYNC,
        USERINFO_WALLET_QR_REWARD_MAX_AMT_INT_SYNC,
        USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC,
        USERINFO_WALLET_QR_REWARD_BOTTOM_STR_STRING_SYNC,
        USERINFO_WALLET_QR_REWARD_BOTTOM_URL_STRING_SYNC,
        USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC,
        USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC,
        USERINFO_WALLET_COLLECT_BUSITYPE_INT_SYNC,
        USERINFO_WALLET_COLLECT_BUSIURL_STRING_SYNC,
        USERINFO_SETTING_SWITCH_ACCOUNT_FIRST_CLICK_BOOLEAN_SYNC,
        GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC,
        NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC,
        NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC,
        NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC,
        NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC,
        NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC,
        USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC,
        USERINFO_WALLET_BANK_REMIT_MIN_POUNDAGE_INT_SYNC,
        USERINFO_WALLET_BANK_REMIT_MAX_TRANSFER_AMOUNT_INT_SYNC,
        USERINFO_WALLET_BANK_REMIT_PAYLIST_STRING_SYNC,
        USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC,
        USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC,
        USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC,
        USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC,
        USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC,
        USERINFO_APPBRANDRECENTVIEW_CONFIG_BOOLEAN_SYNC,
        USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC,
        USERINFO_LQT_DEFAULTCARD_STRING_SYNC,
        USERINFO_LQT_DEFAULTCARD_SAVE_STRING_SYNC,
        USERINFO_LQT_DEFAULTCARD_FETCH_STRING_SYNC,
        USERINFO_HARDWARE_CPU_FREQUENCY_MHZ_INT_SYNC,
        USERINFO_HARDWARE_MEMORY_IN_MB_INT_SYNC,
        USERINFO_RECOMMEND_REDDOT_LONG,
        USERINFO_FTS_DISCOVERY_RED_XML_REC_STRING,
        NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC,
        NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC,
        USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC,
        USERINFO_FTS_RECOMMEND_LOCAL_FILE_INDEX_LONG_SYNC,
        USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC,
        USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC,
        USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC,
        USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC,
        USERINFO_WALLET_INDEX_IS_SHOW_LQB_INT_SYNC,
        USERINFO_WALLET_INDEX_IS_LQB_OPEN_INT_SYNC,
        USERINFO_WALLET_INDEX_LQB_OPEN_URL_STRING_SYNC,
        USERINFO_LAST_LOGIN_USERNAME_STRING,
        USERINFO_LAST_LOGIN_AVATAR_PATH_STRING,
        USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC
    }
}