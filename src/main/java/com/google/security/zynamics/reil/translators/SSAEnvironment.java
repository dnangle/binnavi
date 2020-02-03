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

package com.google.security.zynamics.reil.translators;

import com.google.security.zynamics.reil.OperandSize;


public class SSAEnvironment implements ITranslationEnvironment {

  private int nextVariable = 0;

  @Override
  public int generateNextVariable() {
    return nextVariable++;
  }

  @Override
  public OperandSize getArchitectureSize() {
    return OperandSize.DWORD;
  }

  @Override
  public int getNextVariable() {
    return nextVariable;
  }

  @Override
  public String getNextVariableString() {
    return String.format("t%d", generateNextVariable());
  }

  @Override
  public void nextInstruction() {
  }

  @Override
  public void setNextVariable(final int nextVariable) {
    this.nextVariable = nextVariable;
  }
}
