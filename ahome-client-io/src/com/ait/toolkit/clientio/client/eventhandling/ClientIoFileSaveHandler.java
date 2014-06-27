package com.ait.toolkit.clientio.client.eventhandling;

/**
 * Base interface for saving a file on the client.
 * 
 * @author Alain Ekambi
 * 
 */
public interface ClientIoFileSaveHandler {

	/**
	 * Called when the file was successfully created.
	 * 
	 * 
	 */
	public void onFileSave(String fileName, String fileType, double fileSize);

	/**
	 * Called when the file creation was canceled
	 */
	public void onCancel();

	/**
	 * Called when an I/O error occurs
	 */
	public void onIoError(String errorMessage);

}
