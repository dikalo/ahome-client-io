package com.ait.toolkit.clientio.client;

/**
 * Base interface for handling Client IO initialization.
 * 
 * @author Alain Ekambi
 * 
 */
public interface ClientIOInitCallback {

	/**
	 * Called when an I/O operation ends with no errors.
	 */
	public void onIOSuccess();

	/**
	 * Called when an I/O operation ends with errors.
	 */
	public void onIOError();

	/**
	 * called when Client IO could not get initialized.
	 */
	public void onInitError();

}
