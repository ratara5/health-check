package org.health.healthcheck.web.controller;


import org.health.healthcheck.domain.Measure;
import org.health.healthcheck.domain.User;
import org.health.healthcheck.domain.service.MeasureService;
import org.health.healthcheck.domain.service.UserService;
import org.health.healthcheck.persistence.entity.MeasureProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/measures")
public class MeasureController {

    @Autowired
    private MeasureService measureService;

    public Map<Integer, Float> getImcs(String typeId, String userId) {
        Map<Integer, Float> imcsHashMap = new HashMap<>();
        List<MeasureProjection> imcs = measureService.getImcs(typeId, userId);
        for (MeasureProjection entry : imcs) {
            Integer measureId = entry.getMeasureId();
            Float imc = entry.getImc();
            if (Objects.nonNull(entry.getMeasureId()) && Objects.nonNull(entry.getImc())) {
                imcsHashMap.put(entry.getMeasureId(), entry.getImc());
            }
        }
        return imcsHashMap;
    }

    @GetMapping("user/{type}-{id}")
    public ResponseEntity<List<Measure>> getByUser(@PathVariable("type") String typeId, @PathVariable("id") String userId){

        Optional<List<Measure>> measures = measureService.getByUser(typeId, userId);
        Map<Integer, Float> imcsMap = getImcs(typeId, userId);

        measures.ifPresent(ms-> {
                    ms.forEach(m -> m.setImc(imcsMap.get(m.getMeasureId())));

        });

        return measures
                .map(ms->new ResponseEntity<>(ms, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    //TODO: @PostMapping("/save")

    //TODO: @DeleteMapping("/delete/{type}-{id}")

    //TODO: @PutMapping("/update/{type}-{id}")

}
