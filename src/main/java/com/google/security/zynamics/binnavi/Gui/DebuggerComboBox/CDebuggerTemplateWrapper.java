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

package com.google.security.zynamics.binnavi.Gui.DebuggerComboBox;

import com.google.security.zynamics.binnavi.debug.debugger.DebuggerTemplate;
import com.google.security.zynamics.zylib.gui.DefaultWrapper;

/**
 * Wrapper class that can be used to display debugger templates in GUI components.
 */
public final class CDebuggerTemplateWrapper extends DefaultWrapper<DebuggerTemplate> {
  /**
   * Creates a new wrapper object.
   *
   * @param template The debugger template to wrap or null to signal "No Debugger".
   */
  public CDebuggerTemplateWrapper(final DebuggerTemplate template) {
    super(template);
  }

  @Override
  public String toString() {
    final DebuggerTemplate debugger = getObject();

    return debugger == null ? "No Debugger" : String.format(
        "%s - %s:%d", debugger.getName(), debugger.getHost(), debugger.getPort());
  }
}
