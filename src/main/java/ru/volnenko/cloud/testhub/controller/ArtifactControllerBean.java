package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.volnenko.cloud.testhub.model.Branch;
import ru.volnenko.cloud.testhub.model.Release;
import ru.volnenko.cloud.testhub.model.Version;
import ru.volnenko.cloud.testhub.service.*;

@Controller
public class ArtifactControllerBean implements ArtifactController {

    @Autowired
    private ArtifactService artifactService;

    @Autowired
    private JacocoService jacocoService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private VersionService versionService;

    @Autowired
    private ReleaseService releaseService;

    @NonNull
    @Override
    @GetMapping("/ui/artifacts")
    public ModelAndView artifacts() {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("artifacts");
        modelAndView.addObject("artifacts", artifactService.findAllArtifact());
        return modelAndView;
    }

    @NonNull
    @Override
    public ModelAndView artifact(@PathVariable("artifactId") @NonNull final String artifactId) {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("artifact");
        modelAndView.addObject("artifact", artifactService.findById(artifactId));
        modelAndView.addObject("controller", this);
        modelAndView.addObject("results",  jacocoService.findAllByArtifactId(artifactId));
        return modelAndView;
    }

    public Branch getBranch(@NonNull final String id) {
        return branchService.cacheById(id);
    }

    public Release getRelease(@NonNull final String id) {
        return  releaseService.cacheById(id);
    }

    public Version getVersion(@NonNull final String id) {
        return versionService.cacheById(id);
    }

    public Version getVersionByReleaseId(@NonNull final String id) {
        @NonNull final Release release = getRelease(id);
        if (release == null) return null;
        return getVersion(release.getVersionId());
    }

}
