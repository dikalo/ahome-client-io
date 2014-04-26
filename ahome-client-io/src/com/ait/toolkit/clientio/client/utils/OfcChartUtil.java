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
package com.ait.toolkit.clientio.client.utils;

/**
 * Utility class for Open Flash Charts
 */
public class OfcChartUtil {

	private OfcChartUtil() {

	}

	public static final native String getImageBinary(String chartID) /*-{
		var obj = $doc.getElementById(chartID);
		if (!obj) {
			throw new Error(
					"The element with the id "
							+ chartID
							+ " must be visible on the page. It looks like we can't find it. Is it hidden ? ");
		}
		return obj.get_img_binary();
	}-*/;

}
