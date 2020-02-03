// Copyright 2011-2016 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.security.zynamics.binnavi.Help;

import com.google.security.zynamics.binnavi.Gui.SaveFields.CSaveCheckbox;

/**
 * Save checkbox class that can display context-sensitive help.
 */
public class CHelpSaveCheckbox extends CSaveCheckbox implements IHelpProvider
{
	/**
	 * Used for serialization.
	 */
	private static final long serialVersionUID = -1776494924551382364L;

	/**
	 * Provides context-sensitive help.
	 */
	private final IHelpInformation m_information;

	/**
	 * Creates a new check box object.
	 *
	 * @param text Text shown in the check box.
	 * @param information Provides context-sensitive help.
	 */
	public CHelpSaveCheckbox(final String text, final IHelpInformation information)
	{
		super(text);

		m_information = information;
	}

	@Override
	public IHelpInformation getHelpInformation()
	{
		return m_information;
	}
}
