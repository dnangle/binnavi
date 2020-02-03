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

package com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Nodes.Tag;



import com.google.security.zynamics.binnavi.Database.Interfaces.IDatabase;
import com.google.security.zynamics.binnavi.Gui.Actions.CActionProxy;
import com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Actions.CAddTagAction;
import com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Actions.CDeleteTagAction;
import com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Actions.CDeleteTagSubtreeAction;
import com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Actions.CInsertTagAction;
import com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Nodes.CAbstractMenuBuilder;
import com.google.security.zynamics.binnavi.Tagging.CTag;
import com.google.security.zynamics.zylib.types.trees.TreeNode;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTree;



/**
 * Menu builder for context menus of tag nodes.
 */
public final class CTagNodeMenuBuilder extends CAbstractMenuBuilder {
  /**
   * Database where the tag is stored.
   */
  private final IDatabase m_database;

  /**
   * Tag represented by the clicked node.
   */
  private final TreeNode<CTag> m_tag;

  /**
   * Creates a new menu builder object.
   * 
   * @param projectTree Project tree of the main window.
   * @param database Database where the tag is stored.
   * @param tag Tag represented by the clicked node.
   */
  public CTagNodeMenuBuilder(final JTree projectTree, final IDatabase database,
      final TreeNode<CTag> tag) {
    super(projectTree);

    m_database = database;
    m_tag = tag;
  }

  @Override
  protected void createMenu(final JComponent menu) {
    menu.add(new JMenuItem(CActionProxy.proxy(new CAddTagAction(getParent(), m_database
        .getContent().getViewTagManager(), m_tag, "New Tag"))));

    menu.add(new JMenuItem(CActionProxy.proxy(new CInsertTagAction(getParent(), m_database
        .getContent().getViewTagManager(), m_tag, "New Tag"))));

    menu.add(new JSeparator());
    menu.add(new JMenuItem(CActionProxy.proxy(new CDeleteTagAction(getParent(), m_database
        .getContent().getViewTagManager(), m_tag))));
    menu.add(new JSeparator());
    menu.add(new JMenuItem(CActionProxy.proxy(new CDeleteTagSubtreeAction(getParent(), m_database
        .getContent().getViewTagManager(), m_tag))));
  }

  @Override
  protected JMenu getMenu() {
    final JMenu menu = new JMenu("Tagging");

    menu.setMnemonic("HK_MENU_TAGGING".charAt(0));

    return menu;
  }
}
