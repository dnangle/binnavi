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

package com.google.security.zynamics.reil.translators.ppc;

import com.google.security.zynamics.reil.OperandSize;
import com.google.security.zynamics.reil.ReilHelpers;
import com.google.security.zynamics.reil.ReilInstruction;
import com.google.security.zynamics.reil.translators.IInstructionTranslator;
import com.google.security.zynamics.reil.translators.ITranslationEnvironment;
import com.google.security.zynamics.reil.translators.InternalTranslationException;
import com.google.security.zynamics.reil.translators.TranslationHelpers;
import com.google.security.zynamics.zylib.disassembly.IInstruction;
import com.google.security.zynamics.zylib.disassembly.IOperandTreeNode;

import java.util.List;


public class MrDotTranslator implements IInstructionTranslator {
  @Override
  public void translate(final ITranslationEnvironment environment, final IInstruction instruction,
      final List<ReilInstruction> instructions) throws InternalTranslationException {
    TranslationHelpers.checkTranslationArguments(environment, instruction, instructions, "mr.");

    final IOperandTreeNode targetRegister =
        instruction.getOperands().get(0).getRootNode().getChildren().get(0);
    final IOperandTreeNode sourceRegister =
        instruction.getOperands().get(1).getRootNode().getChildren().get(0);

    Long baseOffset = instruction.getAddress().toLong() * 0x100;
    final OperandSize dw = OperandSize.DWORD;
    final String crTemp = environment.getNextVariableString();

    instructions.add(ReilHelpers.createStr(baseOffset++, dw, sourceRegister.getValue(), dw,
        targetRegister.getValue()));

    // EQ CR0
    instructions.add(ReilHelpers.createBisz(baseOffset++, OperandSize.DWORD,
        targetRegister.getValue(), OperandSize.BYTE, Helpers.CR0_EQUAL));

    // LT CR0
    instructions
        .add(ReilHelpers.createBsh(baseOffset++, OperandSize.DWORD, targetRegister.getValue(),
            OperandSize.WORD, "-31", OperandSize.BYTE, Helpers.CR0_LESS_THEN));

    // GT CR0
    instructions.add(ReilHelpers.createOr(baseOffset++, OperandSize.BYTE, Helpers.CR0_EQUAL,
        OperandSize.BYTE, Helpers.CR0_LESS_THEN, OperandSize.BYTE, crTemp));
    instructions.add(ReilHelpers.createBisz(baseOffset++, OperandSize.BYTE, crTemp,
        OperandSize.BYTE, Helpers.CR0_GREATER_THEN));

    // SO CR0
    instructions.add(ReilHelpers.createStr(baseOffset, OperandSize.BYTE,
        Helpers.XER_SUMMARY_OVERFLOW, OperandSize.BYTE, Helpers.CRO_SUMMARY_OVERFLOW));

  }
}
