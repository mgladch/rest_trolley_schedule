package com.hladchuk.controller;

import com.hladchuk.model.Stop;
import com.hladchuk.service.StopService;
import com.hladchuk.mapper.postmapper.PostStopMapper;
import com.hladchuk.model.dto.postdto.PostRouteDto;
import com.hladchuk.model.dto.postdto.PostStopDto;
import com.hladchuk.model.dto.postdto.PostTransportDto;
import com.hladchuk.util.StopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class StopController {
    StopService stopService;
    StopUtil stopUtil;

    @Autowired
    public StopController(StopService stopService, StopUtil stopUtil) {
        this.stopService = stopService;
        this.stopUtil = stopUtil;
    }

    @GetMapping("/stops")
    public ResponseEntity<List<PostStopDto>> findAll() {
        return ResponseEntity.ok(PostStopMapper.INSTANCE.stopToPostStopDtos(stopService.findAll()));
    }

    @PostMapping("/stops")
    public ResponseEntity<PostStopDto> create(@RequestBody PostStopDto postStopDto) {
        stopService.save(PostStopMapper.INSTANCE.postDtoToStop(postStopDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(postStopDto);
    }

    @GetMapping(value = "/stopById/{id}")
    public ResponseEntity<PostStopDto> findById(@PathVariable int id) {
        Optional<Stop> stop = stopService.findById(id);

        return ResponseEntity.ok(PostStopMapper.INSTANCE.toPostDto(stop.get()));
    }

    @PutMapping("/stops/{id}")
    public ResponseEntity<PostStopDto> update(@PathVariable int id, @RequestBody PostStopDto postStopDto) {
        Stop stop = PostStopMapper.INSTANCE.postDtoToStop(postStopDto);
        stop.setId(id);

        stopService.save(stop);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postStopDto);
    }

    @DeleteMapping("/stops/{id}")
    public ResponseEntity<PostStopDto> delete(@PathVariable int id) {
        stopService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/getRoutesByStopName/{name}")
    public ResponseEntity<Set<PostRouteDto>> getRoutesByStopName(@PathVariable String name) {
        return ResponseEntity.ok(stopUtil.getRoutesByStopName(name));
    }

    @GetMapping("/getTransportByStopName/{name}")
    public ResponseEntity<Set<PostTransportDto>> getTransportByStopName(@PathVariable String name) {
        return ResponseEntity.ok(stopUtil.getTransportByStopName(name));
    }

}
