package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.volnenko.cloud.testhub.model.Branch;
import ru.volnenko.cloud.testhub.model.Jacoco;
import ru.volnenko.cloud.testhub.model.Release;
import ru.volnenko.cloud.testhub.model.Version;
import ru.volnenko.cloud.testhub.service.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

@Controller
public final class ArtifactControllerBean implements ArtifactController {

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
        @NonNull final List<Jacoco> results = jacocoService.findAllByArtifactId(artifactId);
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("artifact");
        modelAndView.addObject("svg", svg(results));
        modelAndView.addObject("artifact", artifactService.findById(artifactId));
        modelAndView.addObject("controller", this);
        modelAndView.addObject("results",  results);
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


    @NonNull
    public String svg(@NonNull final List<Jacoco> results) {
        @NonNull final String title = "ГРАФИК ПОКРЫТИЯ ТЕСТАМИ";
        @NonNull final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int i = 1;
        for (Jacoco jacoco: results) {
            dataset.addValue(jacoco.getCoverage(), "ПОКРЫТИЕ",  String.format("%02d", i));
            i++;
        }

        @NonNull final JFreeChart chart = ChartFactory.createLineChart(title, "СБОРКИ", "ПРОЦЕНТЫ", dataset);
        @NonNull final LineAndShapeRenderer renderer = (LineAndShapeRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setAutoPopulateSeriesStroke(false);
        renderer.setDefaultStroke(new BasicStroke(3.0f));
        @NonNull final SVGGraphics2D graphics2D = new SVGGraphics2D(600, 300);
        graphics2D.setPaint(Color.RED);
        chart.draw(graphics2D, new Rectangle2D.Double(0, 0, 600, 300), null);
        return graphics2D.getSVGElement();
    }

    private float rand() {
        int min = 10;
        int max = 90;
        int randomInt = min + (int)(Math.random() * ((max - min) + 1));
        return randomInt;
    }

}
