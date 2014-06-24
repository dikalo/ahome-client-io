package com.ait.toolkit.clientio.client;

import com.ait.toolkit.flash.core.client.utils.ByteArray;

/**
 * Base interface for reading a file on the client. <br/>
 * All clients should implement this interface to get notified when reading a file on the client was successful.
 * 
 * @author Alain Ekambi
 * 
 */
public interface ClientIoFileSelectHandler {

	/**
	 * Called when the file content was successfully loaded.
	 * 
	 * @param data
	 *            , the data contained in the file
	 * 
	 */
	public void onFileLoaded(ByteArray data);

	/**
	 * Called when the file selection was canceled
	 */
	public void onCancel();

	/**
	 * Called when an I/O error occurs
	 */
	public void onIoError();

}
