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

package com.google.security.zynamics.binnavi.ZyGraph.Menus.Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


import com.google.common.base.Preconditions;
import com.google.security.zynamics.binnavi.yfileswrap.zygraph.NaviNode;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ClipboardCopier;

/**
 * Action class used to copy the content of a node to the clipboard.
 */
public final class CCopyNodeAction extends AbstractAction {
  /**
   * Used for serialization.
   */
  private static final long serialVersionUID = 3630032240507567289L;

  /**
   * The node whose content is copied to the clipboard.
   */
  private final NaviNode m_node;

  /**
   * Creates a new copy node action.
   *
   * @param node The node whose content is copied to the clipboard.
   */
  public CCopyNodeAction(final NaviNode node) {
    super("Copy node to clipboard");

    m_node = Preconditions.checkNotNull(node, "IE02155: Node argument can not be null");
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    ClipboardCopier.copyToClipboard(m_node);
  }
}
