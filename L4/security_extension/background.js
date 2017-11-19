// Copyright (c) 2011 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// Called when the user clicks on the browser action.
chrome.tabs.onUpdated.addListener(function(tabId, changeInfo, tab) {
  // No tabs or host permissions needed!
  var url = tab.url;
  if(url !== undefined && changeInfo.status == "complete") {
  	chrome.tabs.executeScript(null, { file: "jquery-3.2.1.min.js" }, function() {
    	chrome.tabs.executeScript(null, { file: "script.js" });
	});
  }
     
});

chrome.tabs.onCreated.addListener(function() {         
   chrome.tabs.executeScript({
    file: 'script.js'
  });
});
