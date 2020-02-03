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

package com.google.security.zynamics.reil.translators.arm;

import com.google.security.zynamics.reil.OperandSize;
import com.google.security.zynamics.reil.ReilHelpers;
import com.google.security.zynamics.reil.ReilInstruction;
import com.google.security.zynamics.reil.translators.ITranslationEnvironment;
import com.google.security.zynamics.reil.translators.InternalTranslationException;
import com.google.security.zynamics.reil.translators.TranslationHelpers;
import com.google.security.zynamics.zylib.disassembly.IInstruction;
import com.google.security.zynamics.zylib.disassembly.IOperandTreeNode;

import java.util.List;


public class ARMSmulXYTranslator extends ARMBaseTranslator {
  @Override
  protected void translateCore(final ITranslationEnvironment environment,
      final IInstruction instruction, final List<ReilInstruction> instructions) {
    final IOperandTreeNode registerOperand1 =
        instruction.getOperands().get(0).getRootNode().getChildren().get(0);
    final IOperandTreeNode registerOperand2 =
        instruction.getOperands().get(1).getRootNode().getChildren().get(0);
    final IOperandTreeNode registerOperand3 =
        instruction.getOperands().get(2).getRootNode().getChildren().get(0);

    final String targetRegister = (registerOperand1.getValue());
    final String sourceRegister1 = (registerOperand2.getValue());
    final String sourceRegister2 = (registerOperand3.getValue());

    final OperandSize wd = OperandSize.WORD;
    final OperandSize dw = OperandSize.DWORD;
    final OperandSize qw = OperandSize.QWORD;

    long baseOffset = ReilHelpers.nextReilAddress(instruction, instructions);

    final String operand1 = environment.getNextVariableString();
    final String operand2 = environment.getNextVariableString();
    final String tmpVar1 = environment.getNextVariableString();
    final String tmpVar2 = environment.getNextVariableString();
    final String tmpVar3 = environment.getNextVariableString();

    if (instruction.getMnemonic().contains("BB")) {
      Helpers.signExtend(baseOffset, environment, instruction, instructions, dw, sourceRegister1,
          dw, operand1, 16);
      baseOffset = ReilHelpers.nextReilAddress(instruction, instructions);
      Helpers.signExtend(baseOffset, environment, instruction, instructions, dw, sourceRegister2,
          dw, operand2, 16);

    } else if (instruction.getMnemonic().contains("BT")) {
      Helpers.signExtend(baseOffset, environment, instruction, instructions, dw, sourceRegister1,
          dw, operand1, 16);
      baseOffset = ReilHelpers.nextReilAddress(instruction, instructions);
      instructions.add(ReilHelpers.createBsh(baseOffset++, dw, sourceRegister2, wd,
          String.valueOf(-16L), dw, tmpVar1));
      Helpers.signExtend(baseOffset, environment, instruction, instructions, dw, tmpVar1, dw,
          operand2, 16);
    } else if (instruction.getMnemonic().contains("TB")) {
      instructions.add(ReilHelpers.createBsh(baseOffset++, dw, sourceRegister1, wd,
          String.valueOf(-16L), dw, tmpVar1));
      Helpers.signExtend(baseOffset, environment, instruction, instructions, dw, tmpVar1, dw,
          operand1, 16);
      baseOffset = ReilHelpers.nextReilAddress(instruction, instructions);
      Helpers.signExtend(baseOffset, environment, instruction, instructions, dw, sourceRegister2,
          dw, operand2, 16);
    } else if (instruction.getMnemonic().contains("TB")) {
      instructions.add(ReilHelpers.createBsh(baseOffset++, dw, sourceRegister1, wd,
          String.valueOf(-16L), dw, tmpVar1));
      Helpers.signExtend(baseOffset, environment, instruction, instructions, dw, tmpVar1, dw,
          operand1, 16);
      baseOffset = ReilHelpers.nextReilAddress(instruction, instructions);
      instructions.add(ReilHelpers.createBsh(baseOffset++, dw, sourceRegister2, wd,
          String.valueOf(-16L), dw, tmpVar2));
      Helpers.signExtend(baseOffset, environment, instruction, instructions, dw, tmpVar2, dw,
          operand2, 16);
    }

    instructions.add(ReilHelpers.createMul(baseOffset++, dw, operand1, dw, operand2, qw, tmpVar3));
    instructions.add(ReilHelpers.createAnd(baseOffset++, qw, tmpVar3, dw,
        String.valueOf(0xFFFFFFFFL), dw, targetRegister));
  }

  /**
   * SMUL<x><y>{<cond>} <Rd>, <Rm>, <Rs>
   * 
   * Operation:
   * 
   * if ConditionPassed(cond) then if (x == 0) then operand1 = SignExtend(Rm[15:0]) else // x == 1
   * operand1 = SignExtend(Rm[31:16]) if (y == 0) then operand2 = SignExtend(Rs[15:0]) else // y ==
   * 1 operand2 = SignExtend(Rs[31:16]) Rd = operand1 * operand2
   */

  @Override
  public void translate(final ITranslationEnvironment environment, final IInstruction instruction,
      final List<ReilInstruction> instructions) throws InternalTranslationException {
    TranslationHelpers.checkTranslationArguments(environment, instruction, instructions, "SMUL");
    translateAll(environment, instruction, "SMUL", instructions);
  }
}
