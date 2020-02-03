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

package com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Actions;



import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import com.google.security.zynamics.binnavi.Gui.MainWindow.Implementations.CModuleStaringFunctions;
import com.google.security.zynamics.binnavi.disassembly.INaviModule;


/**
 * Action class used for toggling the star state of modules.
 */
public class CToggleStarsModulesAction extends AbstractAction {
  /**
   * Used for serialization.
   */
  private static final long serialVersionUID = 4990715070915079644L;

  /**
   * Parent window used for dialogs.
   */
  private final JFrame m_parent;

  /**
   * The modules whose star state is toggled.
   */
  private final INaviModule[] m_modules;

  /**
   * Creates a new action object.
   * 
   * @param parent Parent window used for dialogs.
   * @param modules The modules whose star state is toggled.
   */
  public CToggleStarsModulesAction(final JFrame parent, final INaviModule[] modules) {
    super("Toggle module stars");

    m_parent = parent;
    m_modules = modules.clone();
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    CModuleStaringFunctions.toggleStars(m_parent, m_modules);
  }
}
