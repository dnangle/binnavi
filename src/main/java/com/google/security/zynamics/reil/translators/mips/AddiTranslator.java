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

package com.google.security.zynamics.reil.translators.mips;

import com.google.security.zynamics.reil.OperandSize;
import com.google.security.zynamics.reil.ReilHelpers;
import com.google.security.zynamics.reil.ReilInstruction;
import com.google.security.zynamics.reil.translators.IInstructionTranslator;
import com.google.security.zynamics.reil.translators.ITranslationEnvironment;
import com.google.security.zynamics.reil.translators.InternalTranslationException;
import com.google.security.zynamics.reil.translators.TranslationHelpers;
import com.google.security.zynamics.zylib.disassembly.IInstruction;

import java.util.List;

public class AddiTranslator implements IInstructionTranslator {

  @Override
  public void translate(final ITranslationEnvironment environment, final IInstruction instruction,
      final List<ReilInstruction> instructions) throws InternalTranslationException {
    TranslationHelpers.checkTranslationArguments(environment, instruction, instructions, "addi");

    final String targetRegister =
        instruction.getOperands().get(0).getRootNode().getChildren().get(0).getValue();
    final String sourceRegister =
        instruction.getOperands().get(1).getRootNode().getChildren().get(0).getValue();
    final String sourceImmediate =
        instruction.getOperands().get(2).getRootNode().getChildren().get(0).getValue();

    final OperandSize bt = OperandSize.BYTE;
    final OperandSize dw = OperandSize.DWORD;
    final OperandSize qw = OperandSize.QWORD;

    final long baseOffset = ReilHelpers.toReilAddress(instruction.getAddress()).toLong();
    long offset = baseOffset;

    final String temporaryResult = environment.getNextVariableString();
    final String bit31 = environment.getNextVariableString();
    final String bit32 = environment.getNextVariableString();
    final String jumpCondition = environment.getNextVariableString();
    final String xoredBits = environment.getNextVariableString();

    final String sourceImmediateSignExtended =
        SignExtendGenerator.extend16BitTo32(offset, environment, sourceImmediate, instructions);

    instructions.add(ReilHelpers.createAdd(offset++, dw, sourceRegister, dw,
        sourceImmediateSignExtended, qw, temporaryResult));

    // is bit 32 != bit 31
    instructions.add(ReilHelpers.createBsh(offset++, qw, temporaryResult, dw, String.valueOf(-31L),
        bt, bit31));
    instructions.add(ReilHelpers.createBsh(offset++, qw, temporaryResult, dw, String.valueOf(-32L),
        bt, bit32));
    instructions.add(ReilHelpers.createXor(offset++, bt, bit31, bt, bit32, bt, xoredBits));
    instructions.add(ReilHelpers.createBisz(offset++, bt, xoredBits, bt, jumpCondition));

    final String jmpGoal =
        String.format("%d.%d", instruction.getAddress().toLong(), instructions.size() + 2);
    instructions.add(ReilHelpers.createJcc(offset++, bt, jumpCondition, dw, jmpGoal));

    instructions.add(ReilHelpers.createAnd(offset++, qw, temporaryResult, dw,
        String.valueOf(0xFFFFFFFFL), dw, targetRegister));
    instructions.add(ReilHelpers.createNop(offset));

  }

}
