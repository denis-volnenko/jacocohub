package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.dto.ValueDto;
import ru.volnenko.cloud.testhub.model.Jacoco;
import ru.volnenko.cloud.testhub.repository.JacocoRepository;

import java.util.List;

@Service
public class JacocoServiceBean implements JacocoService {

    @Autowired
    private JacocoRepository jacocoRepository;

    @NonNull
    @Override
    public Jacoco create(
            @NonNull String artifactId,
            @NonNull String versionId,
            @NonNull final String branchId,
            @NonNull ValueDto valueDto
    ) {
        @NonNull final Jacoco jacoco = new Jacoco();
        jacoco.setArtifactId(artifactId);
        jacoco.setVersionId(versionId);
        jacoco.setBranchId(branchId);

        jacoco.setInstructionMissed(valueDto.getInstructionMissed());
        jacoco.setInstructionCovered(valueDto.getInstructionCovered());
        jacoco.setInstructionTotal(valueDto.getInstructionTotal());
        jacoco.setInstructionPercent(valueDto.getInstructionPercent());

        jacoco.setBranchMissed(valueDto.getBranchMissed());
        jacoco.setBranchCovered(valueDto.getBranchCovered());
        jacoco.setBranchTotal(valueDto.getBranchTotal());
        jacoco.setBranchPercent(valueDto.getBranchPercent());

        jacoco.setLineMissed(valueDto.getLineMissed());
        jacoco.setLineCovered(valueDto.getLineCovered());
        jacoco.setLineTotal(valueDto.getLineTotal());
        jacoco.setLinePercent(valueDto.getLinePercent());

        jacoco.setClassCovered(valueDto.getClassCovered());
        jacoco.setClassMissed(valueDto.getClassMissed());
        jacoco.setClassTotal(valueDto.getClassTotal());
        jacoco.setClassPercent(valueDto.getClassPercent());

        jacoco.setMethodMissed(valueDto.getMethodMissed());
        jacoco.setMethodCovered(valueDto.getMethodCovered());
        jacoco.setMethodTotal(valueDto.getMethodTotal());
        jacoco.setMethodPercent(valueDto.getMethodPercent());

        jacoco.setClassMissed(valueDto.getClassMissed());
        jacoco.setClassCovered(valueDto.getClassCovered());
        jacoco.setClassTotal(valueDto.getClassTotal());
        jacoco.setClassPercent(valueDto.getClassPercent());

        jacoco.setCoverage(valueDto.getCoverage());

        return jacocoRepository.save(jacoco);
    }

    @Override
    @NonNull
    @Transactional(readOnly = true)
    public List<Jacoco> findAllByArtifactId(@NonNull final String artifactId) {
        return jacocoRepository.findAllByArtifactId(artifactId);
    }

}
