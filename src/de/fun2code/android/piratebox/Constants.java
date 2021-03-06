package de.fun2code.android.piratebox;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;

/**
 * Constants that are used throughout the app
 * 
 * @author joschi
 *
 */
public class Constants {
	private static String INSTALL_DIR;
	
	public static final String TAG = "PirateBox";
	public static final String PREF_START_ON_BOOT = "startOnBoot";
	public static final String PREF_SSID_NAME = "ssidName";
	public static final String PREF_STORAGE_DIR = "storageDir";
	public static final String PREF_IOS_WISPR_SUPPORT = "iosWispr";
	public static final String PREF_WP_NCSI_SUPPORT = "wpNcsi";
	public static final String PREF_VERSION = "version";
	public static final String PREF_UPDATE = "update";
	public static final String PREF_AUTO_AP_STARTUP = "autoApStartup";
	public static final String PREF_DEV_CONTENT_SD = "devContentSd";
	public static final String PREF_DEV_INFO_PIRATEBOX_VERSION = "infoPirateBoxVersion";
	public static final String PREF_DEV_INFO_PAW_VERSION = "infoPawVersion";
	public static final String PREF_DEV_INFO_AP_IP_ADDRESS = "infoApIpAddress";
	public static final String PREF_DEV_INFO_LOCAL_PORT = "infoLocalPort";
	public static final String PREF_DEV_INFO_UPLOADS = "infoUploads";
	public static final String PREF_DEV_INFO_MESSAGES = "infoMessages";
	
	//public static final String DEV_SWITCH_FILE = Environment.getExternalStorageDirectory().getPath() + "/.piratebox_dev";
	
	public static final String BROADCAST_INTENT_SERVER = "de.fun2code.android.piratebox.broadcast.intent.server";
	public static final String INTENT_SERVER_EXTRA_STATE = "state";
	
	public static final String BROADCAST_INTENT_AP = "de.fun2code.android.piratebox.broadcast.intent.ap";
	public static final String INTENT_AP_EXTRA_STATE = "state";
	
	public static final String BROADCAST_INTENT_NETWORK = "de.fun2code.android.piratebox.broadcast.intent.network";
	public static final String INTENT_NETWORK_EXTRA_STATE = "state";
	
	public static final String BROADCAST_INTENT_SHOUT = "de.fun2code.android.piratebox.broadcast.intent.shout";
	public static final String INTENT_SHOUT_EXTRA_NAME = "name";
	public static final String INTENT_SHOUT_EXTRA_TEXT = "text";
	
	public static final String BROADCAST_INTENT_UPLOAD = "de.fun2code.android.piratebox.broadcast.intent.upload";
	public static final String INTENT_UPLOAD_EXTRA_FILE = "file";
	
	
	public static String getInstallDir(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		
		if(INSTALL_DIR == null) {
			//if(new File(DEV_SWITCH_FILE).exists()) {
			if(preferences.getBoolean(PREF_DEV_CONTENT_SD, false)) {
				// Use external storage
				INSTALL_DIR = Environment.getExternalStorageDirectory().getPath() + "/piratebox";
			}
			else {
				// Use /data/data/... directory
				INSTALL_DIR = context.getFilesDir().getAbsolutePath() + "/piratebox";
			}
		}
		
		return INSTALL_DIR;
	}
}
