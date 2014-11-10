/*
The contents of this file are subject to the Mozilla Public License
Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at
http://www.mozilla.org/MPL/

Software distributed under the License is distributed on an "AS IS"
basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations
under the License.

The Original Code is collection of files collectively known as Open Camera.

The Initial Developer of the Original Code is Almalence Inc.
Portions created by Initial Developer are Copyright (C) 2013 
by Almalence Inc. All Rights Reserved.
 */

/* <!-- +++
 package com.almalence.opencam_plus;
 +++ --> */
// <!-- -+-
package com.almalence.opencam.ui;

//-+- -->

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TabHost;

import com.almalence.opencam.MainScreen;
import com.almalence.opencam.PluginManager;
import com.almalence.opencam.PluginType;
import com.almalence.opencam.R;
import com.almalence.ui.RotateDialog;
import com.almalence.ui.RotateImageView;
import com.almalence.ui.RotateLayout;
/* <!-- +++
 import com.almalence.opencam_plus.MainScreen;
 import com.almalence.opencam_plus.PluginManager;
 import com.almalence.opencam_plus.PluginType;
 import com.almalence.opencam_plus.R;
 +++ --> */
// <!-- -+-
//-+- -->
/* <!-- +++
 import com.almalence.opencam_plus.MainScreen;
 import com.almalence.opencam_plus.PluginManager;
 import com.almalence.opencam_plus.PluginType;
 import com.almalence.opencam_plus.R;
 +++ --> */
// <!-- -+-
//-+- -->

public class SelfTimerAndTimeLapseDialog extends RotateDialog
{
	public SelfTimerAndTimeLapseDialog(Context context)
	{
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.selftimer_and_phototimelapse_dialog);

		TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
		
		tabs.setup();
		
		TabHost.TabSpec spec = tabs.newTabSpec("tag1");

		spec.setContent(R.id.tabSelftimer);
		spec.setIndicator("Self timer");
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tag2");
		spec.setContent(R.id.tabTimelapse);
		spec.setIndicator("Timelapse");
		tabs.addTab(spec);
		
		tabs.setCurrentTab(0);
	}

	@Override
	public void setRotate(int degree)
	{
		degree = degree >= 0 ? degree % 360 : degree % 360 + 360;

		if (degree == currentOrientation)
		{
			return;
		}
		currentOrientation = degree;

		RotateLayout r = (RotateLayout) findViewById(R.id.rotateLayoutTimelapse);
		r.setAngle(degree);
		r.requestLayout();
		r.invalidate();
		
		r = (RotateLayout) findViewById(R.id.rotateLayoutTimer);
		r.setAngle(degree);
		r.requestLayout();
		r.invalidate();
	}
}
