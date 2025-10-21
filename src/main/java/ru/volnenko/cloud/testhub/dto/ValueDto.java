package ru.volnenko.cloud.testhub.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValueDto {

    public ValueDto(JacocoResultDto result) {
        instructionMissed = result.getInstructionMissed();
        instructionCovered = result.getInstructionCovered();
        instructionTotal = instructionMissed + instructionCovered;
        if (instructionTotal == 0) instructionPercent = 0;
        else instructionPercent = instructionCovered / instructionTotal * 100;

        branchMissed = result.getBranchMissed();
        branchCovered = result.getBranchCovered();
        branchTotal = branchMissed + branchCovered;
        if (branchTotal == 0) branchPercent = 0;
        else branchPercent = branchCovered / branchTotal * 100;

        lineMissed = result.getLineMissed();
        lineCovered = result.getLineCovered();
        lineTotal = lineMissed + lineCovered;
        if (lineTotal == 0) linePercent = 0;
        else linePercent = lineCovered / lineTotal * 100;

        complexityCovered = result.getComplexityCovered();
        complexityMissed = result.getComplexityMissed();
        complexityTotal = complexityMissed + complexityCovered;
        if (complexityTotal == 0) complexityPercent = 0;
        else complexityPercent = complexityCovered / complexityTotal * 100;

        methodMissed = result.getMethodMissed();
        methodCovered = result.getMethodCovered();
        methodTotal = methodMissed + methodCovered;
        if (methodTotal == 0) methodPercent = 0;
        else methodPercent = methodCovered / methodTotal * 100;

        classMissed = result.getClassMissed();
        classCovered = result.getClassCovered();
        classTotal = classMissed + classCovered;
        if (classTotal == 0) classPercent = 0;
        else classPercent = classCovered / classTotal * 100;

        coverage = (instructionPercent + branchPercent) / 2;
    }

    private double instructionMissed = 0;

    private double instructionCovered = 0;

    private double instructionTotal = 0;

    private double instructionPercent = 0;

    private double branchMissed = 0;

    private double branchCovered = 0;

    private double branchTotal = 0;

    private double branchPercent = 0;

    private double lineMissed = 0;

    private double lineCovered = 0;

    private double lineTotal = 0;

    private double linePercent = 0;

    private double complexityMissed = 0;

    private double complexityCovered = 0;

    private double complexityTotal = 0;

    private double complexityPercent = 0;

    private double methodMissed = 0;

    private double methodCovered = 0;

    private double methodTotal = 0;

    private double methodPercent = 0;

    private double classMissed = 0;

    private double classCovered = 0;

    private double classTotal = 0;

    private double classPercent = 0;

    private double coverage = 0;

}
