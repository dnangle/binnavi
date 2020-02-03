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

package com.google.security.zynamics.binnavi.standardplugins.callresolver;

import com.google.security.zynamics.binnavi.API.debug.Debugger;

/**
 * Interface to be implemented by objects that want to be notified about changes in call resolver
 * target objects.
 */
public interface ICallResolverTargetListener {
  /**
   * Invoked after the debugger of call resolver target changed.
   * 
   * @param target The target whose debugger changed.
   * @param debugger The new debugger of the call resolver target.
   */
  void changedDebugger(ICallResolverTarget target, Debugger debugger);
}
