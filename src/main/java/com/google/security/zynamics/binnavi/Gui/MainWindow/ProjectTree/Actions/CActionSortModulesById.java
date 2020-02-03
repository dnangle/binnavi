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

import com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Nodes.ModuleContainer.CModuleContainerNode;


/**
 * Action class for sorting modules in the project tree by ID.
 */
public final class CActionSortModulesById extends AbstractAction {
  /**
   * Used for serialization.
   */
  private static final long serialVersionUID = 2666077010901760800L;

  /**
   * Module container node whose children are sorted.
   */
  private final CModuleContainerNode m_node;

  /**
   * Creates a new action object.
   * 
   * @param node Module container node whose children are sorted.
   */
  public CActionSortModulesById(final CModuleContainerNode node) {
    super("By Creation Date");

    m_node = node;
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    m_node.setSorted(false);
  }
}
