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
