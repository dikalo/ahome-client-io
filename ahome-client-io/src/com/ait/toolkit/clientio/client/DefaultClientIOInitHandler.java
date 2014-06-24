package com.ait.toolkit.clientio.client;

import com.google.gwt.user.client.Window;

/**
 * Default Client IO initialization handler
 * 
 * @author Alain Ekambi
 * 
 */
public class DefaultClientIOInitHandler implements ClientIOInitHandler {

	@Override
	public void onInit() {

	}

	@Override
	public void onInitError() {
		Window.alert(ClientIO.FLASH_NOT_INSTALLED);
	}

}
