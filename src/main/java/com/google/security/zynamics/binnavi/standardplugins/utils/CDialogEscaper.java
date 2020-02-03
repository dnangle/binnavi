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

package com.google.security.zynamics.binnavi.standardplugins.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JDialog;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.binnavi.Gui.HotKeys;

public final class CDialogEscaper {
  private final JDialog m_dialog;

  public CDialogEscaper(final JDialog dialog) {
    m_dialog = Preconditions.checkNotNull(dialog, "Error: dialog argument can not be null");

    ((JComponent) dialog.getRootPane()).registerKeyboardAction(new InternalListener(), "doEscape",
        HotKeys.ESCAPE_HK.getKeyStroke(), JComponent.WHEN_IN_FOCUSED_WINDOW);
  }

  private class InternalListener implements ActionListener {
    @Override
    public void actionPerformed(final ActionEvent arg0) {
      m_dialog.setVisible(false);

      m_dialog.dispose();
    }
  }
}
