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

package com.google.security.zynamics.binnavi.disassembly;

import com.google.security.zynamics.binnavi.Gui.GraphWindows.CommentDialogs.Interfaces.IComment;
import com.google.security.zynamics.binnavi.Tagging.CTag;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;

import java.awt.Color;
import java.util.List;



/**
 * Adapter for classes that want to listen on just a few code node events.
 */
public class CNaviCodeNodeListenerAdapter implements INaviCodeNodeListener {

  @Override
  public void addedInstruction(final INaviCodeNode codeNode, final INaviInstruction instruction) {
    // Empty default implementation
  }

  @Override
  public void appendedGlobalCodeNodeComment(final INaviCodeNode codeNode, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void appendedLocalCodeNodeComment(final INaviCodeNode codeNode, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void appendedLocalInstructionComment(final INaviCodeNode codeNode,
      final INaviInstruction instruction, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void changedBorderColor(final IViewNode<?> node, final Color color) {
    // Empty default implementation
  }

  @Override
  public void changedColor(final IViewNode<?> node, final Color color) {
    // Empty default implementation
  }

  @Override
  public void changedInstructionColor(final CCodeNode codeNode, final INaviInstruction instruction,
      final int level, final Color color) {
    // Empty default implementation
  }

  @Override
  public void changedParentGroup(final INaviViewNode node, final INaviGroupNode groupNode) {
    // Empty default implementation
  }

  @Override
  public void changedSelection(final IViewNode<?> node, final boolean selected) {
    // Empty default implementation
  }

  @Override
  public void changedVisibility(final IViewNode<?> node, final boolean visible) {
    // Empty default implementation
  }

  @Override
  public void deletedGlobalCodeNodeComment(final INaviCodeNode codenode, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void deletedLocalCodeNodeComment(final INaviCodeNode codeNode, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void deletedLocalInstructionComment(final INaviCodeNode codeNode,
      final INaviInstruction instruction, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void editedGlobalCodeNodeComment(final INaviCodeNode codeNode, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void editedLocalCodeNodeComment(final INaviCodeNode codeNode, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void editedLocalInstructionComment(final INaviCodeNode codeNode,
      final INaviInstruction instruction, final IComment comment) {
    // Empty default implementation
  }

  @Override
  public void heightChanged(final IViewNode<?> node, final double height) {
    // Empty default implementation
  }

  @Override
  public void initializedGlobalCodeNodeComment(final INaviCodeNode codeNode,
      final List<IComment> comments) {
    // Empty default implementation
  }

  @Override
  public void initializedLocalCodeNodeComment(final INaviCodeNode codeNode,
      final List<IComment> comments) {
    // Empty default implementation
  }

  @Override
  public void initializedLocalInstructionComment(final INaviCodeNode codeNode,
      final INaviInstruction instruction, final List<IComment> comments) {
    // TODO Auto-generated method stub
  }

  @Override
  public void removedInstruction(final INaviCodeNode codeNode, final INaviInstruction instruction) {
    // Empty default implementation
  }

  @Override
  public void taggedNode(final INaviViewNode node, final CTag tag) {
    // Empty default implementation
  }

  @Override
  public void untaggedNodes(final INaviViewNode node, final List<CTag> tags) {
    // Empty default implementation
  }

  @Override
  public void widthChanged(final IViewNode<?> node, final double width) {
    // Empty default implementation
  }

  @Override
  public void xposChanged(final IViewNode<?> node, final double xpos) {
    // Empty default implementation
  }

  @Override
  public void yposChanged(final IViewNode<?> node, final double ypos) {
    // Empty default implementation
  }
}
