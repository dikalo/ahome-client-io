package com.ait.toolkit.clientio.client;

/**
 * Base interface for handling Client IO initialization.
 * 
 * @author Alain Ekambi
 * 
 */
public interface ClientIOInitHandler {

	/**
	 * Called when an I/O operation ends with no errors.
	 */
	public void onInit();

	/**
	 * called when Client IO could not get initialized.
	 */
	public void onInitError();

}
