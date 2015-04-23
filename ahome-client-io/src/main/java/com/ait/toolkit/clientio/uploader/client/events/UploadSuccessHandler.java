/*
 * Copyright 2011 Moxie Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ait.toolkit.clientio.uploader.client.events;

/**
 * An interface that can be used as a callback handler when uploader success events are fired by
 * the Uploader component.  General usage is as follows:
 * <code><pre>
 * uploader.setUploadSuccessHandler(new UploadSuccessHandler() {
 *    public boolean onUploadSuccess(UploadSuccessEvent event) {
 *       Window.alert("Successfully uploaded " + event.getFile().getName());
 *       return true;
 *    }
 * });
 * </pre></code>
 * <p/>
 * Note that 'uploadSuccess' is fired when the entire uploader has been transmitted and the server
 * returns a HTTP 200 status code. Any data outputted by the server is available in the server data property.
 * <p/>
 * Due to some bugs in the Flash Player the server response may not be acknowledged and no uploadSuccess
 * event is fired by Flash. In this case the {@link com.ait.toolkit.clientio.uploader.client.Uploader#setAssumeSuccessTimeout(long)}
 * setting is checked to see if enough time has passed to fire uploadSuccess anyway. In this
 * case the received response parameter will be false.
 * <p/>
 * The {@link com.ait.toolkit.clientio.uploader.client.Uploader#setHttpSuccess(long...)} setting allows
 * uploadSuccess to be fired for HTTP status codes other than 200. In this case no server data is
 * available from the Flash Player.
 * <p/>
 * At this point the uploader is not yet complete. Another uploader cannot be started from uploadSuccess.
 * <p/>
 * See the documentation on the {@link UploadSuccessEvent} class for more details on the data
 * available when an uploader success event occurs.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 */
public interface UploadSuccessHandler {

    /**
     * This method is fired whenever a uploader success event occurs in the Uploader component.  See
     * the {@link UploadSuccessEvent} class for more details on the data available when this event is fired.
     *
     * @param uploadSuccessEvent The details of the event that occurred.
     * @return The response to send back to the event handler function
     */
    public boolean onUploadSuccess(UploadSuccessEvent uploadSuccessEvent);

}
