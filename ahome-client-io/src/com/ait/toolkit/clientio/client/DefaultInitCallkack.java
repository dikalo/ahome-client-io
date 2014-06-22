package com.ait.toolkit.clientio.client;

import com.google.gwt.user.client.Window;

/**
 * Default Client IO initialization handler
 * 
 * @author Alain Ekambi
 * 
 */
public class DefaultInitCallkack implements ClientIOInitCallback {

	@Override
	public void onIOSuccess() {

	}

	@Override
	public void onIOError() {
		Window.alert(ClientIO.CLIENT_IO_NOT_INITIALIZED);
	}

	@Override
	public void onInitError() {
		Window.alert(ClientIO.FLASH_NOT_INSTALLED);
	}

}
