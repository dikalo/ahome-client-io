package com.ait.toolkit.clientio.client;


public class ClientIoElement {

	private ClientIOSwf swf;
	private String bridgeName;

	public ClientIoElement(String bridgeName) {
		this.bridgeName = bridgeName;
	}

	public ClientIOSwf getSurface() {
		if (this.swf == null) {
			this.swf = ClientIOSwf.get(bridgeName);
		}
		return this.swf;
	}

}
