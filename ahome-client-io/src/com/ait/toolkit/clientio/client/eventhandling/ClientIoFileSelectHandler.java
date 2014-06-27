/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.clientio.client.eventhandling;

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
	public void onFileLoaded(String fileName, String fileType, ByteArray data, double fileSize);

	/**
	 * Called when the file selection was canceled
	 */
	public void onCancel();

	/**
	 * Called when an I/O error occurs
	 */
	public void onIoError(String errorMessage);

}
