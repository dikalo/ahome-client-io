package com.ait.toolkit.clientio.uploader.client.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface UploaderResources extends ClientBundle {

    public static final UploaderResources INSTANCE = GWT.create( UploaderResources.class );

    @Source( "swfupload.js" )
    public TextResource js();

    @Source( "swfupload.speed.js" )
    public TextResource jsSpeed();
}
