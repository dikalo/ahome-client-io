package com.ait.toolkit.clientio.client.eventhandling;

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
		Window.alert("Flash seems to not be installed");
	}

}
