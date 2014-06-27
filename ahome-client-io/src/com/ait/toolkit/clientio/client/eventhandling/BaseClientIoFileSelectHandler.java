package com.ait.toolkit.clientio.client.eventhandling;

/**
 * Base Client IO FileSelect handler. <br/>
 * Extends this class if you are only interested in the content of the file and dont want to handle the error and cancel event
 * 
 * @author Alain Ekambi
 * 
 */
public abstract class BaseClientIoFileSelectHandler implements ClientIoFileSelectHandler {

	@Override
	public void onCancel() {

	}

	@Override
	public void onIoError(String errorMessage) {

	}

}
